package com.et.terminalserver.common.util.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Project CNPC_VMS
 * @Title XmlElement
 * @Description 结点类
 * @author guanhl
 * @date 2014年8月7日 上午9:20:30
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public class XmlElement implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name = null; // 名称
	private List content = new ArrayList();// 内容
	private Map children = new HashMap();// 子节点
	private Map attributes = new HashMap();// 属性
	private static final String LINESEPARATOR = System.getProperty("line.separator"); // 分隔符
	private static final boolean APPLY_INDENTATION = false;

	/**
	 * @Description 构造方法
	 * @param name 结点名
	 */
	public XmlElement(String name) {
		this.name = name;
	}

	/**
	 * @Description 获取名
	 */
	public String getName() {
		return name;
	}

	/**
	 * @Description 设置属性
	 */
	public void setAttributes(Map attributes) {
		this.attributes = attributes;
	}

	/**
	 * @Description 删除属性
	 */
	public void removeAttribute(String attributeName) {
		attributes.remove(attributeName);
	}

	/**
	 * @Description 获取属性
	 */
	public Map getAttributes() {
		return attributes;
	}

	/**
	 * @Description 获取属性值
	 */
	public String getAttribute(String attributeName) {
		return (String) attributes.get(attributeName);
	}

	/**
	 * @Description 增加子节点
	 */
	public void addChild(XmlElement child) {
		String childName = child.getName();
		List namedChildren = (List) children.get(childName);
		// 子节点空就创建，像个树
		if (namedChildren == null) {
			namedChildren = new ArrayList();
			children.put(childName, namedChildren);
		}
		namedChildren.add(child);
		content.add(child);
	}

	/**
	 * @Description 删除
	 */
	public void removeXmlElement(XmlElement delegateXmlElement) {
		List namedChildren = (List) children.get(delegateXmlElement.getName());
		namedChildren.remove(delegateXmlElement);
		content.remove(delegateXmlElement);
	}

	/**
	 * @Description 按名获取子节点集合
	 */
	public List getChildElements(String childName) {
		List childElements = (List) children.get(childName);
		if (childElements == null) {
			childElements = new ArrayList(0);
		}
		return childElements;
	}

	/**
	 * @Description 按名获取子节点
	 */
	public XmlElement getChildElement(String childName) {
		XmlElement child = null;
		List namedChildren = (List) children.get(childName);
		if (namedChildren != null) {
			if (namedChildren.size() == 1) {
				child = (XmlElement) namedChildren.iterator().next();
			} else if (namedChildren.size() > 1) {
				throw new RuntimeException("expected only one child-element '" + childName + "' of element '" + name + "' while there were "
						+ namedChildren.size());
			}
		}
		return child;
	}

	/**
	 * @Description 增加文本
	 */
	public void addText(String text) {
		this.content.add(text);
	}

	/**
	 * @Description 获取文本内容
	 */
	public List getContent() {
		return content;
	}

	/**
	 * @Description 获取文本内容的字符串
	 */
	public String getContentString() {
		StringBuffer buffer = new StringBuffer();
		getContentString(buffer, "");
		return buffer.toString();
	}

	/**
	 * @Description 获取配置
	 */
	public String getProperty(String propertyName) {
		String propertyValue = null;
		// 属性
		if (attributes.containsKey(propertyName)) {
			// 如果存在就获取
			propertyValue = (String) attributes.get(propertyName);
		} else {
			// 不存在就获取子集
			XmlElement child = this.getChildElement(propertyName);

			if ((child != null) && (child.content.size() == 1)) {

				Object contentsString = child.content.get(0);
				if (!(contentsString instanceof String)) {
					throw new RuntimeException("can't get property '" + propertyName + "' from element '" + name
							+ "' : child-element with that name contains an element instead of text");
				}
				propertyValue = (String) contentsString;
			}

		}
		return propertyValue;
	}

	/**
	 * @Description 获取内容字符串
	 * @param buffer 缓存
	 * @param indentation 压缩
	 */
	public void getContentString(StringBuffer buffer, String indentation) {
		Iterator iter = content.iterator();
		while (iter.hasNext()) {
			Object contentItem = iter.next();
			if (contentItem instanceof XmlElement) {
				XmlElement element = (XmlElement) contentItem;
				// toString 压缩
				element.toString(buffer, indentation);
			} else { // 压缩标志
				if (APPLY_INDENTATION)
					buffer.append(indentation);
				buffer.append(contentItem.toString());
			}

			if (APPLY_INDENTATION) // 压缩标志
				buffer.append(LINESEPARATOR);
		}
	}

	/**
	 * @Description 重新toString
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		toString(buffer, "");
		return buffer.toString().trim();
	}

	/**
	 * @Description toString 具体实现
	 */
	private void toString(StringBuffer buffer, String indentation) {

		if (APPLY_INDENTATION)// 支持压缩
			buffer.append(indentation);// 加个压缩头
		// 下面都在拼接xml的字符串
		buffer.append('<'); // 标签头
		buffer.append(name); // 名字

		// 迭代属性
		Iterator iter = attributes.entrySet().iterator();

		// 属性拼接
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			buffer.append(' ');
			buffer.append((String) entry.getKey());
			buffer.append("=\"");
			buffer.append((String) entry.getValue());
			buffer.append("\"");
		}

		if (content.size() > 0) {
			buffer.append('>');
			if (APPLY_INDENTATION) // 支持压缩
				buffer.append(LINESEPARATOR);
			getContentString(buffer, indentation + "  ");
			if (APPLY_INDENTATION)
				buffer.append(indentation);
			buffer.append("</"); // 结束符拼接
			buffer.append(name);
			buffer.append('>');
		} else {
			buffer.append("/>");
		}
	}
}
