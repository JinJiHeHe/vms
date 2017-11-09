package com.et.terminalserver.common.util;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.*;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/10/10 9:26
 */
public class DbPoolConnection {
    private static DbPoolConnection databasePool = null;
    private static DruidDataSource dds = null;


    static {
        Properties properties = loadPropertyFile("druid.properties");
        try {
            dds = (DruidDataSource) DruidDataSourceFactory
                    .createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DbPoolConnection() {
    }

    public static synchronized DbPoolConnection getInstance() {
        if (null == databasePool) {
            databasePool = new DbPoolConnection();
        }
        return databasePool;
    }

    public DruidDataSource getDataSource() throws SQLException {
        return dds;
    }

    public DruidPooledConnection getConnection() throws SQLException {
        return dds.getConnection();
    }

    public static Properties loadPropertyFile(String filePath) {
        String path=DbPoolConnection.class.getProtectionDomain().getCodeSource().getLocation().getPath();
          path= path.split("target")[0];
        filePath=path+"src/main/resources/"+filePath;
       filePath= filePath.substring(1);
        System.out.println("filePath:"+filePath);
        String webRootPath = null;
        if (null == filePath || filePath.equals(""))
            throw new IllegalArgumentException(
                    "Properties file path can not be null : " + filePath);
//    webRootPath = DruidConnection.class.getClassLoader().getResource("\\")
//            .getPath();
//    System.out.println(webRootPath);
//    webRootPath = new File(webRootPath).getParent();
//    System.out.println(webRootPath);
        InputStream inputStream = null;
        Properties p = null;
        try {
//        String profilepath = webRootPath + File.separator + fullFile;
            //       System.out.println(profilepath);
            inputStream = new FileInputStream(new File(filePath));
            p = new Properties();
            p.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Properties file not found: "
                    + filePath);
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Properties file can not be loading: " + filePath);
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return p;
    }
}
