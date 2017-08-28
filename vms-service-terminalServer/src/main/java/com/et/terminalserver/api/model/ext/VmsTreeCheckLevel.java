package com.et.terminalserver.api.model.ext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 检测树节点实现类
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:07:14
 * @mail terrorbladeyang@gmail.com
 */
public class VmsTreeCheckLevel implements ICheckLevelForTree {

	/**
	 * @Description:判断o2是否为o1的子节点
	 * @param :o1 树实体类 1
	 * @param :o2 树实体类2
	 * @return o2是否为o1的子节点
	 * @throws Exception
	 */
	@Override
	public boolean isChild(Object o1, Object o2) {
		if (null == o2) {
			return false;
		}
		if (null == o1) {
			return true;
		}
		return (((TreeNodeOrg) o2).getOrgCode()).startsWith(((TreeNodeOrg) o1)
				.getOrgCode());
	}

	/**
	 * @Description:数据转换
	 * @param :map 需要转换的map
	 * @param :value 要转换的值
	 * @return 节点id
	 * @throws Exception
	 */
	@Override
	public List<Integer> translate(Map<Object, Object> map, Object value) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String tmp = (String) value;
		if (null == value) {
			return list;
		}
		for (int i = tmp.length(); i > 0; i -= 2) {
			Integer code = (Integer) map.get(tmp.substring(0, i));
			if (null != code) {
				list.add(0, code);
			}
		}

		return list;
	}

	/**
	 * @Description:通过value 获取key
	 * @param :value map的value值
	 * @return map的key值
	 * @throws Exception
	 */
	@Override
	public Object getKey(Object value) {

		return null == value ? null : ((TreeNodeOrg) value).getOrgCode();
	}
}
