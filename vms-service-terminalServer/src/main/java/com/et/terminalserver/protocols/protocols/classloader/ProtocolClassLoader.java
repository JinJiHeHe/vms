package com.et.terminalserver.protocols.protocols.classloader;

import com.et.terminalserver.protocols.protocols.MessageBody;
import com.et.terminalserver.protocols.protocols.MessageHeader;
import com.et.terminalserver.protocols.protocols.ProtocolAnalysis;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ProtocolClassLoader {

	Log log = LogFactory.getLog(ProtocolClassLoader.class);
	Map<String, LoaderInfo> map = new ConcurrentHashMap<String, LoaderInfo>();

	private static String extFile = "META-INF/protocols/protocol.ext";

	public String loadExtProtocolJar(String jarPath) {
		URL[] urls = new URL[0];
		BaseClassLoader loader = null;
		try {
			loader = new BaseClassLoader(urls);
			loader.addJar(new File(jarPath).toURI().toURL());
		} catch (MalformedURLException e) {
			log.warn("Wrong jar " + jarPath);
		} catch (Exception e) {
			log.warn("Wrong jar " + jarPath);
		}
		if (null != loader)
			return scanExtProtocolFile(extFile, loader);
		return null;
	}

	protected String scanExtProtocolFile(String path, BaseClassLoader loader) {
		String protocolName = null;
		String analysisClass = null;
		int version = 0;
		InputStream is = loader.getResourceAsStream(path);
		Properties prop = new Properties();
		try {
			prop.load(is);
			protocolName = prop.getProperty("protocolname");
			analysisClass = prop.getProperty("protocolanalysis");
			version = prop.getProperty("protocolversion") == null ? 0 : Integer
					.valueOf(prop.getProperty("protocolversion"));

			if (null != protocolName && null != analysisClass) {
				if (map.containsKey(protocolName)) {
					if (map.get(protocolName).getVersion() < version) {
						loader.loadClass(analysisClass);
						LoaderInfo info = new LoaderInfo();
						info.setAnalysisClass(analysisClass);
						info.setLoader(loader);
						info.setProtocolName(protocolName);
						info.setVersion(version);
						LoaderInfo prevInfo = map.put(protocolName, info);
						log.info("scaned and loaded the protocol "
								+ protocolName + " , analysis class is "
								+ analysisClass + " , version is " + version);
						closeLoader(prevInfo);
					} else {
						log.warn("scaned older protocol " + protocolName
								+ " , analysis class is " + analysisClass
								+ " , version is " + version
								+ " and current version is "
								+ map.get(protocolName).getVersion());
					}
				} else {
					loader.loadClass(analysisClass, true);
					LoaderInfo info = new LoaderInfo();
					info.setAnalysisClass(analysisClass);
					info.setLoader(loader);
					info.setProtocolName(protocolName);
					info.setVersion(version);
					map.put(protocolName, info);
					log.info("scaned and loaded the protocol " + protocolName
							+ " , analysis class is " + analysisClass
							+ " , version is " + version);
				}

			} else {
				log.warn("File protocol.ext has wrong propery");
			}
		} catch (IOException e) {
			log.warn("No File protocol.ext ", e);
		} catch (Exception e) {
			log.warn("No class " + analysisClass + " for protocol "
					+ protocolName, e);
		}
		return protocolName;

	}

	public Set<String> getLoadedProtocols() {
		return map.keySet();
	}

	private void closeLoader(LoaderInfo info) {
		try {
			info.getLoader().close();
			log.info("Close loader of protocol " + info.getProtocolName()
					+ " succeed , analysis class is " + info.getAnalysisClass()
					+ " , version is " + info.getVersion());
		} catch (IOException e) {
			log.warn(
					"Close loader of protocol " + info.getProtocolName()
							+ "  failed  , analysis class is "
							+ info.getAnalysisClass() + " , version is "
							+ info.getVersion(), e);
		}
	}

	public void removeLoader(String protocolName) {
		LoaderInfo info = map.remove(protocolName);
		if (null != info) {
			log.info("Remove loader of protocol " + info.getProtocolName()
					+ " , analysis class is " + info.getAnalysisClass()
					+ " , version is " + info.getVersion());
			closeLoader(info);

		}
	}

	@SuppressWarnings("unchecked")
	public ProtocolAnalysis<MessageHeader,MessageBody> createProtocolAnalysis(String protocolName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(map.containsKey(protocolName)){
			LoaderInfo info = map.get(protocolName);
			return (ProtocolAnalysis<MessageHeader,MessageBody>) info.getLoader().loadClass(info.getAnalysisClass()).newInstance();
		}else {
			log.warn("The protocol of " + protocolName +" has not loaded ");
			return null;
		}
	}

	public class LoaderInfo {

		private BaseClassLoader loader;
		private String protocolName;
		private String analysisClass;
		private int version;

		public int getVersion() {
			return version;
		}

		public void setVersion(int version) {
			this.version = version;
		}

		public BaseClassLoader getLoader() {
			return loader;
		}

		public void setLoader(BaseClassLoader loader) {
			this.loader = loader;
		}

		public String getProtocolName() {
			return protocolName;
		}

		public void setProtocolName(String protocolName) {
			this.protocolName = protocolName;
		}

		public String getAnalysisClass() {
			return analysisClass;
		}

		public void setAnalysisClass(String analysisClass) {
			this.analysisClass = analysisClass;
		}

	}
}
