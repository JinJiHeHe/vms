package com.et.terminalserver.common.http;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.*;
import org.apache.http.client.entity.DeflateDecompressingEntity;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.List;

public class HttpRequestUtils {
	
public static Log log=LogFactory.getLog(HttpRequestUtils.class);

public static String httpPost(String url,List<NameValuePair> list){
	CloseableHttpClient httpClient=HttpClients.createDefault();
	HttpPost post=new HttpPost(url);
	String str="";
	try {
		UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list,"utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        post.setEntity(entity);
        HttpResponse response=httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()==200){
        	log.info("请求和响应成功");
        	HttpEntity httpEntity=response.getEntity();
        	httpEntity=checkGzipOrdefalte(httpEntity);
        	str=EntityUtils.toString(httpEntity);
        	log.info("postResponse: "+str);
        }
	} catch (Exception e) {
		// TODO Auto-generated catch block
	       log.info(e);
	} 
	return str;
}
public static String  httpGet(String url,List<NameValuePair> list){
	
	CloseableHttpClient httpClient= HttpClients.createDefault();
	String str="";
	try {
	UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list,"utf-8");
    entity.setContentEncoding("UTF-8");
    entity.setContentType("application/json");
    String str1=EntityUtils.toString(entity);
    HttpGet get=new HttpGet(url+"?"+str1);
    HttpResponse response=httpClient.execute(get);
    HttpEntity httpEntity =response.getEntity();
    httpEntity=checkGzipOrdefalte(httpEntity);
    str=EntityUtils.toString(httpEntity);

	     } catch (Exception e) {
		// TODO: handle exception
		log.info(e);
	}
	return str;
}
/**
 * 检查content-encoding是否含有deflate或gzip时应解压缩
 */
public static HttpEntity checkGzipOrdefalte(HttpEntity entity){
	Header header=entity.getContentEncoding();
	System.out.println("haha");
	if(header!=null){
		System.out.println("header is not null");
		HeaderElement[] elements=header.getElements();
		for(int i=0;i<elements.length;i++){
			if(elements[i].getName().equalsIgnoreCase("gizp")){
				entity=new GzipDecompressingEntity(entity);
				System.out.println("gizp....");
			}
			if(elements[i].getName().equalsIgnoreCase("deflate")){
				entity=new DeflateDecompressingEntity(entity);
				System.out.println("deflate...");
			}
		}
		
	}
	return entity;
	
}
}
