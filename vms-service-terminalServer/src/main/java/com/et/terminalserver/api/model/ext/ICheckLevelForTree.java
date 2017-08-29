package com.et.terminalserver.api.model.ext;
import java.util.List;
import java.util.Map;

/**
 * @Description 树节点级别检测
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:02:40
 * @mail terrorbladeyang@gmail.com
 */
public interface ICheckLevelForTree {

	/**
	 * @Description:判断是否是o1的子节点
	 * @param :o1 父节点
	 * @param :o2子节点
	 * @return o2是否为o1的子节点
	 * @throws Exception
	 */
	public boolean isChild(Object o1, Object o2);

	/**
	 * @Description:数据转换
	 * @param :map 需要转换的map
	 * @param :value 要转换的值
	 * @return 节点id
	 * @throws Exception
	 */

	public List<Integer> translate(Map<Object, Object> map, Object value);
	
	/**
	 * @Description:通过value 获取key
	 * @param :value map的value值
	 * @return map的key值
	 * @throws Exception
	 */
	public Object getKey(Object value);
}
