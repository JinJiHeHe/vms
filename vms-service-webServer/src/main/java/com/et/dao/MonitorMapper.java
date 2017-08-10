package com.et.dao;

import com.et.entity.organization;
import com.et.entity.vehicleinfo;
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
    @Select("select * from vehicleinfo v where v.org_id like #{0}")
    public List<vehicleinfo> getVehicleByOrg(String org_id);
}
