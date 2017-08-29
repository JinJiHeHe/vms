package com.et.terminalserver.api.model.ext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 树节点
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:07:28
 * @mail terrorbladeyang@gmail.com
 */
public class VmsTreeNode<N, Key> {

//	private static final Logger logger = Logger.getLogger(VmsTreeNode.class);
	private N node;
	private Object key;
	private List<VmsTreeNode<N, Key>> children;
	public static ICheckLevelForTree check;

	/**
	 * @Description:构造方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */

	public VmsTreeNode() {
		this(null);
	}

	/**
	 * @Description:构造方法
	 * @param :node 节点实体类
	 * @return
	 * @throws Exception
	 */
	public VmsTreeNode(N node) {
		this.node = node;
		this.children = new ArrayList<VmsTreeNode<N, Key>>();
	}

	/**
	 * @Description:获取当前节点的key
	 * @param :args
	 * @return 返回key值
	 * @throws Exception
	 */
	public Object getKey() {
		return key;
	}

	/**
	 * @Description:设置当前节点的key
	 * @param :key 关键值
	 * @return
	 * @throws Exception
	 */
	public void setKey(Object key) {
		this.key = key;
	}

	/**
	 * @Description:设置节点的值
	 * @param :node 节点的值
	 * @return
	 * @throws Exception
	 */

	public void setValue(N node) {
		this.node = node;
		if (null == node) {
			this.key = null;
		} else {
			this.key = check.getKey(node);
		}
	}

	/**
	 * @Description:获取当前节点
	 * @param :args
	 * @return 返回当前节点
	 * @throws Exception
	 */
	public N getValue() {
		return this.node;
	}

	/**
	 * @Description:获取子节点
	 * @param :args
	 * @return 子节点集合
	 * @throws Exception
	 */
	public List<VmsTreeNode<N, Key>> getChildren() {
		return children;
	}

	/**
	 * @Description:获取子节点的对象
	 * @param :i 子节点在列表中的index值
	 * @return 树节点对象
	 * @throws Exception
	 */

	public VmsTreeNode<N, Key> get(int i) {
		if (i < children.size()) {
			return children.get(i);
		}
		return null;
	}

	/**
	 * @Description:根据节点id路径获取节点信息
	 * @param :path节点路径
	 * @return 树节点实体类
	 * @throws Exception
	 */

	public VmsTreeNode<N, Key> get(List<Integer> subPath) {

		if (1 == subPath.size()) {
			return get(subPath.get(0));
		} else if (1 < subPath.size()) {
			int i = subPath.get(0);
			subPath.remove(0);
			VmsTreeNode data = get(i);
			if (null == data) {
//				logger.info(this.key + "," + this.node);
				return null;
			}
			return data.get(subPath);
		}
		return null;
	}

	/**
	 * @Description:设置子节点集合
	 * @param :children 子节点集合
	 * @return
	 * @throws Exception
	 */

	public void setChildren(List<VmsTreeNode<N, Key>> children) {
		this.children = children;
	}

	/**
	 * @Description:设置子节点
	 * @param :child 子节点
	 * @return
	 * @throws Exception
	 */
	public void setChild(int i, VmsTreeNode<N, Key> node) {
		if (i < children.size()) {
			children.add(i, node);
			children.remove(i + 1);
		}
	}

	/**
	 * @Description:添加子节点
	 * @param :child 子节点
	 * @return
	 * @throws Exception
	 */
	public void addChild(VmsTreeNode<N, Key> child) {
		this.children.add(child);
	}

	/**
	 * @Description:判断是否包含子节点
	 * @param : args
	 * @return 是否含有子节点
	 * @throws Exception
	 */
	public boolean isLeaf() {
		return 0 == children.size();
	}

	/**
	 * @Description:获取节点集合
	 * @param : args
	 * @return 节点集合
	 * @throws Exception
	 */
	public List<VmsTreeNode<N, Key>> getList() {
		ArrayList<VmsTreeNode<N, Key>> list = new ArrayList<VmsTreeNode<N, Key>>();
		list.add(this);
		if (!isLeaf()) {
			for (VmsTreeNode<N, Key> child : children) {
				list.addAll(child.getList());
			}
		}
		return list;
	}

	/**
	 * @Description:重写toString方法
	 * @param :args
	 * @return 实体类转换为字符串
	 * @throws Exception
	 */
	@Override
	public String toString() {
		String tmp = "[" + String.valueOf(node);
		if (!isLeaf()) {
			for (VmsTreeNode<N, Key> child : children) {
				tmp = tmp + child.toString();
			}
		}
		return tmp + "]";
	}

	/**
	 * @Description:构建树方法
	 * @param :list 集合信息
	 * @return 树的集合
	 * @throws Exception
	 */

	public HashMap<Key, Integer> buildTree(List<Key> list) {
		HashMap<Key, Integer> map = new HashMap<Key, Integer>();
		return map;

	}

	/**
	 * @Description:创建树
	 * @param :list 对象集合
	 * @param :node 树节点
	 * @param :index 树的值
	 * @return
	 * @throws Exception
	 */

	public static void creatTree(List<Object> list,
			VmsTreeNode<Object, Object> node, Map<Object, Object> index) {

		if (null == list || 0 == list.size()) {
			return;
		}
		int i = 0;
		while (0 < list.size() && check.isChild(node.getValue(), list.get(0))) {
			VmsTreeNode<Object, Object> child = new VmsTreeNode<Object, Object>();
			child.setValue(list.get(0));
			index.put(child.getKey(), i++);
			list.remove(0);
			creatTree(list, child, index);
			node.addChild(child);
		}

		return;
	}

	/**
	 * @Description:创建子节点
	 * @param :list 对象集合
	 * @param :globalMap 全局缓存
	 * @param :father 父节点
	 * @param :node 子节点node
	 * @return
	 * @throws Exception
	 */

	public static List<Object> createChild(List<Object> list,
			Map<Object, Integer> globalMap, VmsTreeNode<Object, Object> father,
			VmsTreeNode<Object, Object> node) {

		if (null == list) {
			return null;
		} else if (0 == list.size()) {
			father.addChild(node);
			return null;
		} else if (check.isChild(node.getValue(), list.get(0))) {
			// 包含下一级
			VmsTreeNode<Object, Object> child = new VmsTreeNode<Object, Object>();
			child.setValue(list.get(0));
			list.remove(0);
			List<Object> left = createChild(list, globalMap, node, child);
			father.addChild(node);
			return left;
		}
		return null;

	}

}
