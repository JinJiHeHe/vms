package com.et.terminalserver.terminalaccess.baseinfo;

import com.et.terminalserver.api.GsonUtil;
import com.et.terminalserver.api.model.SimCardInfo;
import com.et.terminalserver.api.model.TerminalInfo;
import com.et.terminalserver.api.model.VehicleInfo;
import com.et.terminalserver.api.model.ext.BaseInfoUpdateEntity;
import com.et.terminalserver.api.model.ext.UpperList;
import com.et.terminalserver.common.bus.Command;
import com.et.terminalserver.common.cache.LocalCache;
import com.et.terminalserver.common.cache.LocalCacheManager;
import com.et.terminalserver.common.datastore.IPoolManager;
import com.et.terminalserver.protocols.business.bo.BusinessObject;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 基础数据的处理类
 * @author jakiro
 * @version V1.0
 * @Date 2015年12月1日 下午6:03:28
 * @mail terrorbladeyang@gmail.com
 */
public class BaseInfoHandler implements BaseInfo {

	// 日志找的是log4j
	private final static Log log = LogFactory.getLog(BaseInfoHandler.class);

	// 车辆信息的缓存 <vid,车辆信息>
	private LocalCache relationCache = LocalCacheManager.getCache("_relation");
	// 终端信息的缓存 <terminalCode,终端信息>
	private LocalCache terminalCache = LocalCacheManager.getCache("_terminal");
	// SIM卡信息的缓存 <SIMNUM,SIM卡信息>
	private LocalCache SimCache = LocalCacheManager.getCache("_sim");

	// 车辆对应上级平台缓存
	private LocalCache vidToPlateFormsCache = LocalCacheManager.getCache("_vehicleToPlateForms");

	// 是否是debug模式
	private boolean debug = false;

	// JSON格式化
	Gson gson = GsonUtil.getGson();
	// 数据库连接池
	private IPoolManager pool = null;
	// debug选择sql语句
	private String DUBUG_STR = "where (  T.TERMINAL_CODE='B07410020334' or T.TERMINAL_CODE='18210744764' or T.TERMINAL_CODE='14719862668' or T.TERMINAL_CODE='88888' or T.TERMINAL_CODE='18210747859' or T.TERMINAL_CODE='869158008712891' or T.TERMINAL_CODE='88888' or T.TERMINAL_CODE='8100517295' or T.TERMINAL_CODE = '861074021857779' or T.TERMINAL_CODE = '8748957' or T.TERMINAL_CODE = '0211060156'  or T.TERMINAL_CODE = '70571' or T.TERMINAL_CODE = '13488748957'  or T.TERMINAL_CODE = '13439531977') ";

//	// 一个找圈车列表的缓存 <vid[String],转发平台ID[List[String]]>
//	RedisCache vidTopPlateRedisCache;
//	// Redis缓存管理类
//	RedisCacheManager redisCacheManager;

	// 初始化方法 加载静态信息
	public void init() {
            System.out.println("init");
		// vidTopPlateRedisCache=redisCacheManager.getCache(RedisNameManager.VEHICLE_TO_PLATES,
		// List.class);

		loadVehicleTerminalRelation();
		loadVehicleToPlateForms();
	}

	/**
	 * 加载静态信息,分别将 SIM卡 终端信息 以及车辆信息 分别加载到上述对应的缓存中
	 * */
	public boolean loadVehicleTerminalRelation() {

		if (!debug) {
			DUBUG_STR = " where 1=1 ";
		}

		int num = 0;
		// 数据库连接
		Connection conn = null;
		// 数据库语句执行对象
		Statement st = null;
		try {
			System.out.println("haha");
			// 获取连接池连接
			conn = pool.getConnection();
			log.info("chengong");
		} catch (SQLException e1) {
			log.warn("Get JDBC connection failed!", e1);
		}

		try {
			// 得到对象的实例
			st = conn.createStatement();
			// sql语句串
			StringBuffer sql = new StringBuffer();
			// 查询车辆和终端关系
			sql.append("SELECT V.VEHICLE_ID,V.ID_NUMBER,T.TERMINAL_ID,T.TERMINAL_CODE,V.TYPE_ID,V.ORG_CODE,V.COLOR_ID_NUMBER_ID ").append("FROM V_VEHICLEINFO V LEFT JOIN T_TERMINALINFO T ")
					.append("ON V.TERMINAL_ID = T.TERMINAL_ID ");
			// +
			// " AND (T.DELETE_FLAG <> 1 OR T.DELETE_FLAG IS NULL) AND (V.DELETE_FLAG <> 1 OR V.DELETE_FLAG IS  NULL)");
			// 执行语句得到结果集
			ResultSet rs = st.executeQuery(sql.toString());
			// 迭代结果集 装载对象 存入缓存
			while (rs.next()) {
				try {
					VehicleInfo vinfo = new VehicleInfo();
					String key = String.valueOf(rs.getInt("VEHICLE_ID"));// 100011707

					vinfo.setGcode(rs.getString("ORG_CODE"));//
					vinfo.setPlate(rs.getString("ID_NUMBER"));
					vinfo.setTerminalCode(rs.getString("TERMINAL_CODE"));// A100134
					vinfo.setTerminalId(String.valueOf(rs.getInt("TERMINAL_ID")));// 100000041
					vinfo.setUplopadType(rs.getInt("TYPE_ID"));
					vinfo.setVechileId(String.valueOf(rs.getInt("VEHICLE_ID")));
					vinfo.setVehicleColor(rs.getString("COLOR_ID_NUMBER_ID"));
					relationCache.put(key, vinfo);

					log.info("Loading vechile ................... " + num++ + " " + vinfo.getPlate());

				} catch (Exception e) {
					log.warn("", e);
				}
			}

			num = 0;

			// 执行第二个语句
			String sql_2="select v.vehicle_id,s.sim_id,s.sim_num,t.terminal_code,t.terminal_id,t.ttype_id,v.org_code from v_vehicleinfo v join t_terminalinfo t on v.vehicle_id=t.vehicle_id join  t_siminfo s on s.sim_id=t.sim_id";
			System.out.println("sql_2:"+sql_2);
			rs = st.executeQuery(sql_2);
			// 迭代结果 装载对象入缓存
			while (rs.next()) {
				try {

					TerminalInfo tinfo = new TerminalInfo();
					String tkey = rs.getString("TERMINAL_CODE");// A100134
					tinfo.setGcode(rs.getString("ORG_CODE"));
					tinfo.setSimCardId(rs.getString("SIM_ID"));
					tinfo.setSimNum(rs.getString("SIM_NUM"));
					tinfo.setTerminalCode(rs.getString("TERMINAL_CODE"));
					tinfo.setTerminalId(rs.getString("TERMINAL_ID"));
					tinfo.setTerminalType(rs.getString("TTYPE_ID"));
					tinfo.setVechileId(rs.getString("VEHICLE_ID"));
					terminalCache.put(tkey, tinfo);

					log.info("Loading terminal .................. " + num++ + " " + tinfo.getTerminalCode());
				} catch (Exception e) {
					log.warn("", e);
				}
			}

			num = 0;

			String sql_3 = "SELECT S.ORG_CODE,S.DEPTCODE,S.SIM_ID,S.SIM_NUM,T.TERMINAL_CODE,T.TERMINAL_ID " + "FROM T_SIMINFO S LEFT JOIN T_TERMINALINFO T ON T.SIM_ID=S.SIM_ID "
					;
			rs = st.executeQuery(sql_3);
			while (rs.next()) {
				try {
					SimCardInfo sinfo = new SimCardInfo();
					sinfo.setGcode(rs.getString("ORG_CODE"));
					sinfo.setProvider(rs.getString("DEPTCODE"));
					sinfo.setSimCardId(rs.getString("SIM_ID"));
					sinfo.setSimNum(rs.getString("SIM_NUM").trim());
					sinfo.setTerminalCode(rs.getString("TERMINAL_CODE"));
					sinfo.setTerminalId(rs.getString("TERMINAL_ID"));
					SimCache.put(sinfo.getSimNum(), sinfo);
					log.info("Loading simcardNo .................." + num++ + " " + sinfo.getSimNum());
				} catch (Exception e) {
					log.warn("", e);
				}
			}
		} catch (SQLException e) {
			log.warn("", e);
		} finally {
			try {
				// 关闭执行对象和连接
				st.cancel();
				conn.close();
			} catch (SQLException e) {
				log.warn("", e);
			}
		}
		return true;
	}

	/**
	 * 通过vid获取车辆信息
	 * */
	@Override
	public VehicleInfo getVechileInfo(String vid) {
		// info.setDriverId("10000001");
		// info.setGcode("0103"); // vehicle ORG_CODE varchar
		// info.setPlate("冀BL2051"); //vehicle ID_NUMBER varchar
		// info.setTerminalCode("014502105876");//terminal TERMINAL_CODE varchar
		// info.setTerminalId("014502105876"); //vehicle TERMINAL_ID int
		// info.setUplopadType(1); //vehicle TYPE_ID int
		// info.setVechileId("10000001");//vehicle VEHICLE_ID int
		VehicleInfo info = (VehicleInfo) relationCache.get(vid);

		return info;
	}

	/**
	 * 通过terminalID获取终端信息
	 * */
	@Override
	public TerminalInfo getTerminalInfo(String tid) {
		// info.setGcode("0103"); //terminal ORG_CODE varchar
		// info.setSimCardId("1"); //terminal SIM_ID int
		// info.setSimNum("14502105876"); //SIM SIM_NUM varchar
		// info.setTerminalCode("014502105876");//terminal TERMINAL_CODE varchar
		// info.setTerminalId("014502105876"); //terminal TERMINAL_ID int
		// info.setTerminalType("1"); //TERMINAL TTYPE_ID int
		// info.setVechileId("10000001"); //vehicel TERMINAL_ID int
		TerminalInfo info = (TerminalInfo) terminalCache.get(tid);

		return info;
	}

	/**
	 * 通过SIMNUM 获得SIM对象
	 * */
	@Override
	public SimCardInfo getSimCardInfo(String sim) {
		// info.setGcode("0103"); //Sim ORG_CODE varchar
		// info.setProvider("014502105876"); //Sim DEPTCODE varchar
		// info.setSimCardId("14502105876"); //Sim SIM_ID int
		// info.setSimNum("14502105876"); //Sim SIM_NUM varchar
		// info.setTerminalCode("014502105876");//terminal TERMINAL_CODE varchar
		// info.setTerminalId("014502105876");//terminal TERMINAL_ID int
		SimCardInfo info = (SimCardInfo) SimCache.get(sim);

		return info;
	}

	/**
	 * 静态信息改变 后台通过监听缓存的推送 来获取信息的改变 分多种情况
	 * */
	@Override
	public int BaseInfoUpdate(BaseInfoUpdateEntity baseinfoEntity) {

		String OperationType = baseinfoEntity.getOperationType().toUpperCase();

		if (OperationType.equals("INSERT")) {
			VehicleInfo vinfo = new VehicleInfo();
			TerminalInfo tinfo = new TerminalInfo();
			SimCardInfo sinfo = new SimCardInfo();

			vinfo.setGcode(baseinfoEntity.getOrgCode());
			vinfo.setPlate(baseinfoEntity.getIdNumber());
			vinfo.setTerminalCode(baseinfoEntity.getTerminalCode());
			vinfo.setTerminalId(baseinfoEntity.getTerminalID());
			vinfo.setUplopadType(Integer.valueOf(baseinfoEntity.getTypeID()));
			vinfo.setVechileId(baseinfoEntity.getVid());

			tinfo.setGcode(baseinfoEntity.getOrgCode());
			tinfo.setSimCardId(baseinfoEntity.getSimCardID());
			tinfo.setSimNum(baseinfoEntity.getSimNum());
			tinfo.setTerminalCode(baseinfoEntity.getTerminalCode());
			tinfo.setTerminalId(baseinfoEntity.getTerminalID());
			tinfo.setTerminalType(baseinfoEntity.getTerminalType());
			tinfo.setVechileId(baseinfoEntity.getVid());

			sinfo.setGcode(baseinfoEntity.getOrgCode());
			sinfo.setProvider(baseinfoEntity.getProvider());
			sinfo.setSimCardId(baseinfoEntity.getSimCardID());
			sinfo.setSimNum(baseinfoEntity.getSimNum());
			sinfo.setTerminalCode(baseinfoEntity.getTerminalCode());
			sinfo.setTerminalId(baseinfoEntity.getTerminalID());

			relationCache.put(baseinfoEntity.getVid(), vinfo);
			terminalCache.put(baseinfoEntity.getTerminalCode(), tinfo);
			SimCache.put(baseinfoEntity.getSimNum(), sinfo);


		} else if (OperationType.equals("INSERTSIM")) {
			SimCardInfo sinfo_insertSim = new SimCardInfo();
			sinfo_insertSim.setGcode(baseinfoEntity.getOrgCode());
			sinfo_insertSim.setProvider(baseinfoEntity.getProvider());
			sinfo_insertSim.setSimCardId(baseinfoEntity.getSimCardID());
			sinfo_insertSim.setSimNum(baseinfoEntity.getSimNum());
			// sinfo_insertSim.setTerminalCode(baseinfoEntity.getTerminalCode());
			// sinfo_insertSim.setTerminalId(baseinfoEntity.getTerminalID());

			SimCache.put(baseinfoEntity.getSimNum(), sinfo_insertSim);

		} else if (OperationType.equals("UPDATESIM")) {// "{\"terminalCode\":\"1313132\",\"terminalID\":\"100000096\",\"simCardID\":\"10000206\","
			// +
			// "\"simNum\":\"13131313132\",\"terminalType\":\"1\",\"OperationType\":\"INSERTTERMINAL\"}"
			// 关系 Vehicle Terminal SIM
			SimCardInfo sinfo_updatetSim = new SimCardInfo();
			sinfo_updatetSim.setGcode(baseinfoEntity.getOrgCode());
			sinfo_updatetSim.setProvider(baseinfoEntity.getProvider());
			sinfo_updatetSim.setSimCardId(baseinfoEntity.getSimCardID());
			sinfo_updatetSim.setSimNum(baseinfoEntity.getSimNum());
			// sinfo_updatetSim.setTerminalCode(baseinfoEntity.getTerminalCode());
			// sinfo_updatetSim.setTerminalId(baseinfoEntity.getTerminalID());

			SimCache.put(baseinfoEntity.getSimNum(), sinfo_updatetSim);

		} else if (OperationType.equals("DELSIM")) {
			String sim_delSim = baseinfoEntity.getSimNum();
			SimCardInfo sinfo_delSim = (SimCardInfo) SimCache.get(sim_delSim);
			if (sinfo_delSim != null) {
				String terminalCode_delSim = sinfo_delSim.getTerminalCode();
				if (terminalCode_delSim == null || terminalCode_delSim.equals("")) {// 表明没被绑
					SimCache.remove(sinfo_delSim);
				} else {// 表明被绑定了 删掉终端缓存里的这个SIM卡的绑定 然后再删除缓存
					TerminalInfo tinfo_delSim = (TerminalInfo) terminalCache.get(baseinfoEntity.getTerminalCode());
					tinfo_delSim.setSimNum("");
					tinfo_delSim.setSimCardId("");
					terminalCache.put(baseinfoEntity.getTerminalCode(), tinfo_delSim);
					SimCache.remove(sim_delSim);
				}
			}


			// 15313822891
		} else if (OperationType.equals("INSERTTERMINAL")) {
			String terminalCode_insertterminal = baseinfoEntity.getTerminalCode();
			// 先把更新的参数赋值给对象
			TerminalInfo tinfo_inserterminal = new TerminalInfo();
			tinfo_inserterminal.setGcode(baseinfoEntity.getOrgCode());
			tinfo_inserterminal.setSimCardId(baseinfoEntity.getSimCardID());
			tinfo_inserterminal.setSimNum(baseinfoEntity.getSimNum());
			tinfo_inserterminal.setTerminalCode(baseinfoEntity.getTerminalCode());
			tinfo_inserterminal.setTerminalId(baseinfoEntity.getTerminalID());
			tinfo_inserterminal.setTerminalType(baseinfoEntity.getTerminalType());

			// 原来在terminalCache这个缓存里 肯定也是没有这个terminalCode 也是小心翼翼的判断一下
			boolean result = terminalCache.containsKey(terminalCode_insertterminal);
			if (!result) {// 说明是真心是新的terminal
				terminalCache.put(terminalCode_insertterminal, tinfo_inserterminal);
			} else {
				log.error("前台判断有错误 之前有这个TerminalCode:" + terminalCode_insertterminal);
			}

			// 单纯的增加一个没被绑定的SIM
			String simNum_insertterminal = baseinfoEntity.getSimNum();

			// 因为是已有的SIM 所以一定能拿到
			SimCardInfo sinfo_inserterminal = (SimCardInfo) SimCache.get(simNum_insertterminal);

			// 也是小心的做个判断
			if (sinfo_inserterminal != null) {
				sinfo_inserterminal.setTerminalCode(baseinfoEntity.getTerminalCode());
				sinfo_inserterminal.setTerminalId(baseinfoEntity.getTerminalID());
				SimCache.put(simNum_insertterminal, sinfo_inserterminal);
			} else {
				log.error("前台判断有错误 没有这个SIM:" + simNum_insertterminal);
			}


		} else if (OperationType.equals("UPDATETERMINAL")) {
			String terminalCode_updateterminal = baseinfoEntity.getTerminalCode();
			TerminalInfo tinfo_updateterminal = new TerminalInfo();
			tinfo_updateterminal.setGcode(baseinfoEntity.getOrgCode());
			tinfo_updateterminal.setSimCardId(baseinfoEntity.getSimCardID());
			tinfo_updateterminal.setSimNum(baseinfoEntity.getSimNum());
			tinfo_updateterminal.setTerminalCode(baseinfoEntity.getTerminalCode());
			tinfo_updateterminal.setTerminalId(baseinfoEntity.getTerminalID());
			tinfo_updateterminal.setTerminalType(baseinfoEntity.getTerminalType());
			tinfo_updateterminal.setVechileId(baseinfoEntity.getVid());

			// 首先他是选中一条进行更改,所以本地一定是有terminalCode
			// SIM是否是空
			String simNum_updateterminal = baseinfoEntity.getSimNum();
			if (simNum_updateterminal.equals("") || simNum_updateterminal == null) {// 解绑SIM
				// 或者是
				// 在原来也没有的情况下更新

				if (terminalCache.containsKey(terminalCode_updateterminal)) {// 判断一下
					// 肯定有
					// 这是更新 所以他是必须有的
					TerminalInfo tinfo_updateterminal_primary = (TerminalInfo) terminalCache.get(terminalCode_updateterminal);
					// 拿到原来的这个Code对应的对象
					String simNum_primary_update = tinfo_updateterminal_primary.getSimNum(); // 这个是原来的
					if (simNum_primary_update.equals("")) {// 说明原来也没有SIM卡
						terminalCache.put(terminalCode_updateterminal, tinfo_updateterminal);
					} else {// 说明原来有SIM卡 这种情况要通知SIM也解绑
						SimCardInfo sinfo_updateterminal_primary = (SimCardInfo) SimCache.get(simNum_primary_update);
						sinfo_updateterminal_primary.setTerminalCode("");
						sinfo_updateterminal_primary.setTerminalId("");
						SimCache.put(simNum_primary_update, sinfo_updateterminal_primary);
						terminalCache.put(terminalCode_updateterminal, tinfo_updateterminal);
					}
				} else {// 说明这是第一个 不能走这!!!!!! 走着就是有问题
					log.error("前台选中的 terminalCode:" + terminalCode_updateterminal + "但是我本地没有 妈个鸡");
					// terminalCache.put(terminalCode_insertterminal,tinfo_inserterminal);
				}

			} else { // SIM卡不是空 这种情况可能是 1.啥也没变的更新 或者是 2.换绑定SIM

				if (terminalCache.containsKey(terminalCode_updateterminal)) {// 判断一下
					// 肯定有
					// 这是更新 所以他是必须有的
					TerminalInfo tinfo_updateterminal_primary_withSIM = (TerminalInfo) terminalCache.get(terminalCode_updateterminal);
					// 拿到原来的这个终端对应的SIM
					String simNum_primary_update_withSIM = tinfo_updateterminal_primary_withSIM.getSimNum();
					if (simNum_primary_update_withSIM.equals("")) {// 原来是没有的
						// 新绑定的SIM
						// 这个是要绑定的SIM 一定会有 没有的话 就有问题
						SimCardInfo sinfo_updateterminal_primary_withSIM = (SimCardInfo) SimCache.get(simNum_updateterminal);
						if (sinfo_updateterminal_primary_withSIM != null) {// 说明是有这个对象的
							// 正常
							sinfo_updateterminal_primary_withSIM.setTerminalCode(baseinfoEntity.getTerminalCode());
							sinfo_updateterminal_primary_withSIM.setTerminalId(baseinfoEntity.getTerminalID());
							SimCache.put(simNum_updateterminal, sinfo_updateterminal_primary_withSIM);
							terminalCache.put(terminalCode_updateterminal, tinfo_updateterminal);
						} else {// 这特么就不对了 要绑的SIM 我本地竟然没有
							log.error("这个终端:" + terminalCode_updateterminal + "要绑定的这个SIM:" + simNum_updateterminal + " 并没有");
						}
					} else {// 原来是有的 相当于1.换绑 也有可能2.跟原来一样
						if (simNum_primary_update_withSIM.equals(baseinfoEntity.getSimNum())) {// 说明和原来一样
							// 只简单的更新一下
							terminalCache.put(terminalCode_updateterminal, tinfo_updateterminal);
						} else {// 和原来的不一样 这样我们就认为是换绑了 也是最麻烦的一种情况
							// 先要把他原来的给解绑了
							SimCardInfo sinfo_updateterminal_primary_exchange = (SimCardInfo) SimCache.get(simNum_primary_update_withSIM);
							sinfo_updateterminal_primary_exchange.setTerminalCode("");
							sinfo_updateterminal_primary_exchange.setTerminalId("");
							SimCache.put(simNum_primary_update_withSIM, sinfo_updateterminal_primary_exchange);
							// 然后再绑定新的
							SimCardInfo sinfo_updateterminal_now_exchange = (SimCardInfo) SimCache.get(simNum_updateterminal);
							sinfo_updateterminal_now_exchange.setTerminalCode(baseinfoEntity.getTerminalCode());
							sinfo_updateterminal_now_exchange.setTerminalId(baseinfoEntity.getTerminalID());
							SimCache.put(simNum_updateterminal, sinfo_updateterminal_now_exchange);
							terminalCache.put(terminalCode_updateterminal, tinfo_updateterminal);
						}
					}

				} else {
					log.error("要更新的TerminalCode:" + terminalCode_updateterminal + "我本地竟然没有");
				}
			}


		} else if (OperationType.equals("DELTERMINAL")) {// 把车辆双方关系也顺便解绑了

			// 先拿到信息
			String terminalCode_delterminal = baseinfoEntity.getTerminalCode();
			String vehicleID_delterminal = baseinfoEntity.getVid();
			String simNum_delterminal = baseinfoEntity.getIdNumber();

			if (terminalCache.containsKey(terminalCode_delterminal)) {// 说明本地缓存有这个terminalCode
				// 先看是不是绑定了SIM
				if (!simNum_delterminal.equals("")) {// 这个情况说明原来有SIM
					SimCardInfo sinfo_delterminal = (SimCardInfo) SimCache.get(simNum_delterminal);
					if (sinfo_delterminal != null) {// 说明原来是有的
						sinfo_delterminal.setTerminalCode("");
						sinfo_delterminal.setTerminalId("");
						SimCache.put(simNum_delterminal, sinfo_delterminal);

					} else {// 要解绑的SIM 在SimCache 里没有
						log.error("要解绑的SIM:" + simNum_delterminal + "本地就是没有");
					}
				}

				if (!vehicleID_delterminal.equals("")) {// 这个情况说明原来有被车辆绑定
					VehicleInfo vinfo_delterminal = (VehicleInfo) relationCache.get(vehicleID_delterminal);
					if (vinfo_delterminal != null) {// 说明确实有
						vinfo_delterminal.setTerminalCode("");
						vinfo_delterminal.setTerminalId("");
						relationCache.put(vehicleID_delterminal, vinfo_delterminal);
					} else {// 错啦! 说明要解绑的车 在本地里 并没有!!
						log.error("删除终端的时候,要解绑的vid:" + vehicleID_delterminal + "本地并没有");
					}
				}

				terminalCache.remove(terminalCode_delterminal);
			} else {// 说明本地没有 这就错了 想删不能删才最寂寞
				log.error("本地并没有你想删除的terminalCode:" + terminalCode_delterminal);
			}


		} else if (OperationType.equals("INSERTVEHICLE")) {
			String vehicleID_insertvehicle = baseinfoEntity.getVid();
			// 先把更新的参数赋值给对象
			VehicleInfo vinfo_insertvehicle = new VehicleInfo();

			vinfo_insertvehicle.setGcode(baseinfoEntity.getOrgCode());//
			vinfo_insertvehicle.setPlate(baseinfoEntity.getIdNumber());
			vinfo_insertvehicle.setTerminalCode(baseinfoEntity.getTerminalCode());// A100134
			vinfo_insertvehicle.setTerminalId(baseinfoEntity.getTerminalID());// 100000041
			vinfo_insertvehicle.setUplopadType(Integer.valueOf(baseinfoEntity.getTypeID()));
			vinfo_insertvehicle.setVechileId(baseinfoEntity.getVid());
			vinfo_insertvehicle.setVehicleColor(baseinfoEntity.getVehicleColor());

			// 原来在terminalCache这个缓存里 肯定也是没有这个terminalCode 也是小心翼翼的判断一下
			boolean isContainsVid = relationCache.containsKey(vehicleID_insertvehicle);
			if (!isContainsVid) {// 说明是真心是新的terminal
				relationCache.put(vehicleID_insertvehicle, vinfo_insertvehicle);
			} else {
				log.error("前台判断有错误 之前有这个vehicleID:" + vehicleID_insertvehicle);
			}

			// 单纯的增加一个没被绑定的SIM
			String terminalCode_insertvehicle = baseinfoEntity.getTerminalCode();

			// 因为是已有的terminalCode 所以一定能拿到
			TerminalInfo tinfo_insertvehicle = (TerminalInfo) terminalCache.get(terminalCode_insertvehicle);

			// 也是小心的做个判断
			if (tinfo_insertvehicle != null) {
				tinfo_insertvehicle.setVechileId(baseinfoEntity.getVid());
				terminalCache.put(terminalCode_insertvehicle, tinfo_insertvehicle);
			} else {
				log.error("前台判断有错误 没有这个SIM:" + terminalCode_insertvehicle);
			}

		} else if (OperationType.equals("UPDATEVEHICLE")) {// 4.也有可能要换绑

			String vehicleID_updatevehicle = baseinfoEntity.getVid();
			// 先把更新的参数赋值给对象
			VehicleInfo vinfo_updatevehicle = new VehicleInfo();

			vinfo_updatevehicle.setGcode(baseinfoEntity.getOrgCode());//
			vinfo_updatevehicle.setPlate(baseinfoEntity.getIdNumber());
			vinfo_updatevehicle.setTerminalCode(baseinfoEntity.getTerminalCode());// A100134
			vinfo_updatevehicle.setTerminalId(baseinfoEntity.getTerminalID());// 100000041
			vinfo_updatevehicle.setUplopadType(Integer.valueOf(baseinfoEntity.getTypeID()));
			vinfo_updatevehicle.setVechileId(baseinfoEntity.getVid());
			vinfo_updatevehicle.setVehicleColor(baseinfoEntity.getVehicleColor());

			// 首先他是选中一条进行更改,所以本地一定是有terminalCode
			// SIM是否是空
			String terminalCode_updateVehicle = baseinfoEntity.getTerminalCode();
			if (terminalCode_updateVehicle.equals("") || terminalCode_updateVehicle == null) {// 解绑terminal或者是在原来也没有的情况下更新
				if (relationCache.containsKey(vehicleID_updatevehicle)) {// 判断一下
					// 肯定有
					// 这是更新 所以他是必须有的
					VehicleInfo vinfo_updatevehicle_primary = (VehicleInfo) relationCache.get(vehicleID_updatevehicle);
					// 拿到原来这个车的terminalCode
					String terminalCode_primary_update_noterminal = vinfo_updatevehicle_primary.getTerminalCode();
					if (terminalCode_primary_update_noterminal.equals("")) {// 说明原来也没有terminal
						// 直接覆盖
						relationCache.put(vehicleID_updatevehicle, vinfo_updatevehicle);
					} else {// 说明原来有terminalCode 这种情况下要通知terminal也要解绑
						TerminalInfo tinfo_updatevehicle_primary_noterminal = (TerminalInfo) terminalCache.get(terminalCode_primary_update_noterminal);
						tinfo_updatevehicle_primary_noterminal.setVechileId("");
						terminalCache.put(terminalCode_primary_update_noterminal, tinfo_updatevehicle_primary_noterminal);
						relationCache.put(vehicleID_updatevehicle, vinfo_updatevehicle);
					}
				} else { // 说明本地缓存没有这个要更改的车辆 走着就有问题
					log.error("前台选中的这个要更改的车辆 在本地不存在:" + vehicleID_updatevehicle);
				}
			} else {// terminalCode不是空 这种情可能是 1.啥也没变的更新 2.换绑定的terminalCode
				if (relationCache.containsKey(vehicleID_updatevehicle)) {// 判断一下
					// 肯定有
					// 这是更新 所以他是必须有的
					VehicleInfo vinfo_updatevehicle_primary_withterminal = (VehicleInfo) relationCache.get(vehicleID_updatevehicle);
					// 拿到原来这个vehicle对应的terminal
					String terminalCode_primary_update_withterminal = vinfo_updatevehicle_primary_withterminal.getTerminalCode();
					if (terminalCode_primary_update_withterminal.equals("")) {// 原来是没有的
						// 新绑定的terminal
						// 这个是要绑定的terminal 一定会有没有的话 就有问题
						TerminalInfo tinfo_updatevehicle_primary_withterminal = (TerminalInfo) terminalCache.get(terminalCode_updateVehicle);
						if (tinfo_updatevehicle_primary_withterminal != null) {// 说明是有这个对象的
							// 正常
							tinfo_updatevehicle_primary_withterminal.setVechileId(baseinfoEntity.getVid());
							terminalCache.put(terminalCode_updateVehicle, tinfo_updatevehicle_primary_withterminal);
							relationCache.put(vehicleID_updatevehicle, vinfo_updatevehicle);
						} else {// 这特么就不对了 要绑定terminal 我本地竟然没有
							log.error("这个车辆:" + vehicleID_updatevehicle + "要绑定的这个terminal:" + terminalCode_updateVehicle + "本地并没有");
						}
					} else {// 原来是有的 相当于1.换绑 也可能 2.跟原来一样
						if (terminalCode_primary_update_withterminal.equals(baseinfoEntity.getTerminalCode())) {// 说明和原来的一样只是简单的更新下
							relationCache.put(vehicleID_updatevehicle, vinfo_updatevehicle);
						} else {// 和原来的不一样 这样我们就认为是换绑了 也是最麻烦的一种情况
							// 先要把原来的给解绑了
							TerminalInfo tinfo_updatevehicle_primary_exchange = (TerminalInfo) terminalCache.get(terminalCode_primary_update_withterminal);
							tinfo_updatevehicle_primary_exchange.setVechileId("");
							terminalCache.put(terminalCode_primary_update_withterminal, tinfo_updatevehicle_primary_exchange);

							// 然后再绑定新的
							TerminalInfo tinfo_updatevehicle_now_exchange = (TerminalInfo) terminalCache.get(terminalCode_updateVehicle);
							tinfo_updatevehicle_now_exchange.setVechileId(baseinfoEntity.getVid());
							terminalCache.put(terminalCode_updateVehicle, tinfo_updatevehicle_now_exchange);
							relationCache.put(vehicleID_updatevehicle, vinfo_updatevehicle);
						}
					}
				} else {
					log.error("要更新的vehicle:" + vehicleID_updatevehicle + "我本地竟然没有");
				}
			}

		} else if (OperationType.equals("DELVEHICLE")) {// 先拿到信息
			String vehicleID_delvehicle = baseinfoEntity.getVid();
			String terminalCode_delvehicle = baseinfoEntity.getTerminalCode();

			if (relationCache.containsKey(vehicleID_delvehicle)) {// 说明本地缓存有这个vid
				// 先看看是不是绑定了terminal
				if (!terminalCode_delvehicle.equals("")) {// 这个情况说明原来有terminal
					TerminalInfo tinfo_delvehicle = (TerminalInfo) terminalCache.get(terminalCode_delvehicle);
					tinfo_delvehicle.setVechileId("");
					terminalCache.put(terminalCode_delvehicle, tinfo_delvehicle);

				} else {// 要解绑的Terminal 在本地缓存里 没有
					log.error("要解绑的terminalCode:" + terminalCode_delvehicle + "本地没有");
				}
				relationCache.remove(vehicleID_delvehicle);
			} else {// 说明本地没有 这就错了
				log.error("本地并没有你想删除的vid:" + vehicleID_delvehicle);
			}


		} else {
		}
		String terminalKey;
		if (baseinfoEntity.getSimNum() != null) {
			terminalKey = baseinfoEntity.getSimNum();
		} else {
			if (baseinfoEntity.getTerminalCode() != null) {
				terminalKey = baseinfoEntity.getTerminalCode();
			} else {
				terminalKey = baseinfoEntity.getVid();
			}
		}

		Command command = new Command();
		command.setCode(BusinessObject.OP_UPDATE);
		command.setParam(terminalKey);
		return 0;
	}

	/**
	 * 通过车辆ID 拿转发列表
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getVechileToPlatforms(String vid) {

		Object result = vidToPlateFormsCache.get(vid);

		return result != null ? ((List<String>) result) : new ArrayList<String>();
	}

	/**
	 * 监听圈车缓存同步本地
	 * */
	@Override
	public int vehicleToPlateUpdate(UpperList upperList) {

		vidToPlateFormsCache.put(upperList.getVid() + "", upperList.getPlates());

		return 0;
	}

	/**
	 * 服务启动时 加载数据
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public int loadVehicleToPlateForms() {

//		vidTopPlateRedisCache = redisCacheManager.getCache(RedisNameManager.VEHICLE_TO_PLATES, HashMap.class);
//		Set<String> set_keys = vidTopPlateRedisCache.keySet();
//		for (String key : set_keys) {
//			Map<String, Object> map = (Map<String, Object>) vidTopPlateRedisCache.get(key);
//
//			List<String> value = (List<String>) map.get("plates");
//			// List<String> real_value=gson.fromJson(value, List.class);
//			// List<String> value =new ArrayList<String>();
//			// value.add("17");
//			vidToPlateFormsCache.put(key, value);
//		}
		return 0;
	}

	public IPoolManager getPool() {
		return pool;
	}
	public void setPool(IPoolManager pool) {
		this.pool = pool;
	}

}
