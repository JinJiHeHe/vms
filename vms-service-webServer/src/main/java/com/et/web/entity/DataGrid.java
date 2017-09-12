package com.et.web.entity;


import java.util.List;

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/8/28 17:10
 */
public class DataGrid {
private List<DataGridGps> rows;
   private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DataGridGps> getRows() {
        return rows;
    }

    public void setRows(List<DataGridGps> rows) {
        this.rows = rows;
    }
}
