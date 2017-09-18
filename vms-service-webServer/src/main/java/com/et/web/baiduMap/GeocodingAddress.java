package com.et.web.baiduMap;
/**
 * Created by gaop on 2017/9/15.
 */

import com.et.terminalserver.common.http.HttpRequestUtils;
import com.et.terminalserver.common.util.xml.XmlElement;
import com.et.terminalserver.common.util.xml.XmlException;
import com.et.terminalserver.common.util.xml.XmlParser;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/9/15 9:28
 */
public class GeocodingAddress {
    public static String getAddress(String location){
        String url="http://api.map.baidu.com/geocoder/v2/";
        List<NameValuePair> list=new ArrayList<NameValuePair>();
        list.add(new BasicNameValuePair("ak","3ifW06URXxsYvbA9btjujrG8OoIb0fPQ"));
        list.add(new BasicNameValuePair("callback","renderReverse"));
        list.add(new BasicNameValuePair("coordtype","wgs84ll"));
        list.add(new BasicNameValuePair("location",location));
        list.add(new BasicNameValuePair("output","xml"));
        list.add(new BasicNameValuePair("pois","0"));
        String response=HttpRequestUtils.httpGet(url,list);
        //System.out.println(response);


        String formatted_address="";

        try {
            InputStream in=new ByteArrayInputStream(response.getBytes("utf-8"));
            XmlParser xmlParser=new XmlParser(in);
            XmlElement element= xmlParser.parse();
            formatted_address  = element.getChildElement("result").getProperty("formatted_address");
            String sematic_description=element.getChildElement("result").getProperty("sematic_description");
            formatted_address=formatted_address+sematic_description;
            // System.out.println(formatted_address);
        } catch (XmlException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return formatted_address;
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        String url="http://api.map.baidu.com/geocoder/v2/";
        List<NameValuePair> list=new ArrayList<NameValuePair>();
    list.add(new BasicNameValuePair("ak","3ifW06URXxsYvbA9btjujrG8OoIb0fPQ"));
       list.add(new BasicNameValuePair("callback","renderReverse"));
       list.add(new BasicNameValuePair("coordtype","wgs84ll"));
       list.add(new BasicNameValuePair("location","39.983424,116.322987"));
       list.add(new BasicNameValuePair("output","xml"));
       list.add(new BasicNameValuePair("pois","0"));
        String response=HttpRequestUtils.httpGet(url,list);
        System.out.println(response);
        InputStream in=new ByteArrayInputStream(response.getBytes("utf-8"));

        String formatted_address;
        try {
            XmlParser xmlParser=new XmlParser(in);
           XmlElement element= xmlParser.parse();
            formatted_address  = element.getChildElement("result").getProperty("formatted_address");
        System.out.println(formatted_address);
        } catch (XmlException e) {
            e.printStackTrace();
        }

    }
}
