package com.et.web.dao;

import com.et.web.entity.organization;
import com.et.web.entity.vehicleinfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaop on 2017/8/8.
 */
@Repository("monitorMapper")
public interface MonitorMapper {
    @Select("select * from organization o where o.org_id like #{0}")
    public List<organization> getRootNode(String root);
    @Select("select * from v_vehicleinfo v where v.org_code like #{0}")
    public List<vehicleinfo> getVehicleByOrg(String id);
}
