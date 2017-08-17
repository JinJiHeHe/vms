package com.et.terminalserver.common.cache;

import com.et.terminalserver.common.util.conllection.ICollection;

import java.util.Map;

/**
 * @Project CNPC_VMS
 * @Title module_name
 * @Description 缓存接口，继承JDK_Map接口和自定义集合接口，实现类有 {@link LocalCache}
 * @author guanhl
 * @date 2014年10月3日 下午5:00:27
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public interface ICache extends Map<Object, Object>, ICollection {

}
