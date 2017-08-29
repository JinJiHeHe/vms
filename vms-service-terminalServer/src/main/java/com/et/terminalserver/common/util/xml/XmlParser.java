package com.et.terminalserver.common.util.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.InputStream;
import java.io.Reader;

/**
 * @Project CNPC_VMS
 * @Title XmlParser
 * @Description xml解析
 * @author guanhl
 * @date 2014年8月7日 上午9:20:10
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public class XmlParser {
	private InputSource inputSource = null;
	private boolean isConsumed = false;
	private boolean validate = true;
	private boolean parse = true;
	private static Log log = LogFactory.getLog(XmlParser.class.getName());
	private static final String LINESEPARATOR = System.getProperty("line.separator");

	/**
	 * creates an XmlParser for an inputStream (conaining an xml-document).
	 * 
	 * @throws NullPointerException if inputStream is null.
	 */
	public XmlParser(InputStream inputStream) {
		this.inputSource = new InputSource(inputStream);
		if (inputStream == null) {
			throw new NullPointerException("couldn't create an XmlParser with a null-value for inputStream");
		}
	}

	/**
	 * creates an XmlParser for an inputStream (conaining an xml-document).
	 * 
	 * @throws NullPointerException if reader is null.
	 */
	public XmlParser(Reader reader) {
		this.inputSource = new InputSource(reader);
		if (reader == null) {
			throw new NullPointerException("couldn't create an XmlParser with a null-value for reader");
		}
	}

	/**
	 * creates an XmlParser for an inputStream (conaining an xml-document).
	 * 
	 * @throws NullPointerException if inputSource is null.
	 */
	public XmlParser(InputSource inputSource) {
		if (inputSource == null) {
			throw new NullPointerException("couldn't create an XmlParser with a null-value for inputSource");
		}
		this.inputSource = inputSource;
	}

	public void setValidation(boolean validate) {
		this.validate = validate;
	}

	/**
	 * validates an xml-document without building a XmlElement's for the parsed contents.
	 */
	public void validate() throws XmlException {
		this.validate = false;
		this.parse = true;
		parse();
	}

	/**
	 * parses and/or validates an xml document.
	 * 
	 * @throws IllegalStateException if this parser has already been used before. It can only be used once because the inputSource can be read only
	 * once.
	 */
	public XmlElement parse() throws XmlException {
		if (isConsumed) {
			throw new IllegalStateException("this XmlParser-instance has already been used, please create a new one for each usage");
		}
		XmlElement rootElement = null;
		// 处理类
		ParserHandler parserHandler = new ParserHandler();

		// SAXParserFactory factory = SAXParserFactory.newInstance();
		if (validate) {
			// factory.setValidating( true );
		}
		try {
			// 创建xml读取对象
			XMLReader reader = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
			reader.setContentHandler(parserHandler);
			if (parse) {
				// 设置处理类
				reader.setContentHandler(parserHandler);
			}
			if (validate) {
				// 验证
				reader.setEntityResolver(parserHandler);
				reader.setErrorHandler(parserHandler);
			}
			isConsumed = true;
			// 解析
			reader.parse(inputSource);
			rootElement = parserHandler.getRootElement();
		} catch (Throwable t) {
			log.error("couldn't parse xml document", t);
			throw new XmlException("couldn't parse xml document : " + t.getMessage());
		}

		if (parserHandler.hasErrors()) {
			throw new XmlException(parserHandler.getErrors());
		}

		return rootElement;
	}
}
