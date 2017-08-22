package com.et.terminalserver.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description 文件工具类
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月11日 上午8:34:20
 * @mail terrorbladeyang@gmail.com
 */
public class FileUtil {

	private static final Log log = LogFactory.getLog(FileUtil.class);

	/**
	 * 存文件
	 * */
	public static void saveFile(byte[] data, String path, String fileName) {

		try {
			log.info("Save file to local " + path + fileName);
//			int n = -1;
//			String fp = null;
//			if ((n = fileName.lastIndexOf("/")) > -1) {
//				fp = path + fileName.subSequence(0, n);
//			}
			File file = new File(path);
			if (!file.exists())
				file.mkdirs();
			
			FileOutputStream fos = null;
			fos = new FileOutputStream(path + fileName);
			fos.write(data);
			fos.flush();
			fos.close();
			log.info("Save file " + path + fileName + " completed");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void deleteFile(String path) {
		File file = new File(path);
		file.delete();
	}

	public static File[] getFilesInDir(String dir, String suffix) {
		File file = new File(dir);
		File[] files = null;

		if (!file.isFile()) {
			final String name = suffix;
			if (null == name)
				files = file.listFiles();
			else
				files = file.listFiles(new FileFilter() {
					@Override
					public boolean accept(File f) {
						if (f.getName().endsWith("." + name))
							return true;
						return false;
					}
				});
			log.info("Get files " + (null == files ? 0 : files.length)
					+ " in DIR of " + file.getAbsolutePath());
		} else {
			log.warn("This is not a DIR of " + file.getAbsolutePath());
		}
		return files;
	}

	public static URL[] getURIsInDir(String dir, String suffix) {
		File[] files = getFilesInDir(dir, suffix);
		if (null != files) {
			URL[] urls = new URL[files.length];
			for (int i = 0; i < urls.length; i++) {
				try {
					urls[i] = files[i].toURI().toURL();
				} catch (MalformedURLException e) {
					log.warn("", e);
				}
			}
			return urls;
		}
		return null;
	}

	/**
	 * 加载文件
	 * */
	public static byte[] loadFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			log.warn("File " + path + " dose not exist ");
			return null;
		}
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			return data;
		} catch (Exception e) {
			log.warn("", e);
		}

		return null;
	}
}
