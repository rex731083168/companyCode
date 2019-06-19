package com.bruce.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
/**
  Hi bruce,我是rex，中英人寿研发工程师。检测到你的代码中有连接我司接口平台的配置的代码。
  烦请删掉该测试类。以免对我司接口平台造成不好的影响。请尽快删除，并与我取得联系.
  email:rex_ma@aviva-cofco.com.cn
 **/
public class RTSingleRecHttp {
	public static void main(String[] args) throws Exception{
		String requestUrl = "https://testopen.aviva-cofco.com.cn/GIP/GIPServlet";
		String key = "DFE23HLAW198820SQWE1224SDAQQ3319201234";
		Map<String, String> tmap = new TreeMap<>();
		//接口平台参数
		tmap.put("tradetype", "04");
		tmap.put("username", "SSF");
		tmap.put("queueId", "realtimeservice");
		tmap.put("transparent", "0");
		tmap.put("requesttype", "post");
		tmap.put("charset", "utf-8");
		//xml请求报文获取
		StringBuffer buffer = null;
		try {
			FileInputStream fi = new FileInputStream(new File(
			"E:/RTSingleRec.txt"));
			BufferedReader in = new BufferedReader(new InputStreamReader(fi,
					"gbk"));
			buffer = new StringBuffer();
			String line = "";
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String dmsinput=buffer.toString();		
		String dmsinput_encode=URLEncoder.encode(dmsinput,"GBK");
		System.out.println("请求的xml报文-->"+dmsinput_encode);
		tmap.put("xml",dmsinput_encode);
		//生成sign的MD5签名
		StringBuilder sbd = new StringBuilder("");
		for(String tkey:tmap.keySet()){
			sbd.append(tkey).append("=").append(tmap.get(tkey)).append("&");
		}
		String d = sbd.toString();
		String orginData = d.substring(0, d.length()-1)+key;
		System.out.println("orginData:"+orginData);
		String sign= Md5Util.getMD5Str(orginData, "utf-8");//签名编码utf-8
		tmap.put("sign", sign);
		String result = new RTSingleRecHttp().post(requestUrl, tmap); 
		System.out.println("执行的结果---->"+result);
	}
	@Test
	public void HttpRequestTest() throws Exception{
		String requestUrl = "https://testopen.aviva-cofco.com.cn/GIP/GIPServlet";
		String key = "DFE23HLAW198820SQWE1224SDAQQ3319201234";
		Map<String, String> tmap = new TreeMap<>();
		//接口平台参数
		tmap.put("tradetype", "04");
		tmap.put("username", "SSF");
		tmap.put("queueId", "realtimeservice");
		tmap.put("transparent", "0");
		tmap.put("requesttype", "post");
		tmap.put("charset", "utf-8");
		//xml请求报文获取
		StringBuffer buffer = null;
		try {
			FileInputStream fi = new FileInputStream(new File(
			"E:/RTSingleRec.txt"));
			BufferedReader in = new BufferedReader(new InputStreamReader(fi,
					"gbk"));
			buffer = new StringBuffer();
			String line = "";
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String dmsinput=URLEncoder.encode(buffer.toString(),"GBK");
		System.out.println("请求的xml报文-->"+dmsinput);
		tmap.put("xml",dmsinput);
		//生成sign的MD5签名
		StringBuilder sbd = new StringBuilder("");
		for(String tkey:tmap.keySet()){
			sbd.append(tkey).append("=").append(tmap.get(tkey)).append("&");
		}
		String d = sbd.toString();
		String orginData = d.substring(0, d.length()-1)+key;
		System.out.println("orginData:"+orginData);
		String sign= Md5Util.getMD5Str(orginData, "utf-8");//签名编码utf-8
		tmap.put("sign", sign);
		String result=post(requestUrl, tmap);
		System.out.println("执行的结果---->"+result);
	}
	/**
	 * 处理get请求.
	 * 
	 * @param url
	 *            请求路径
	 * @return json
	 */
	private static final RTSingleRecHttp HTTP_DEAL = new RTSingleRecHttp();
	public String get(String url) {
		// 实例化httpclient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 实例化get方法
		HttpGet httpget = new HttpGet(url);
		// 请求结果
		CloseableHttpResponse response = null;
		String content = "";
		try {
			// 执行get方法
			response = httpclient.execute(httpget);
			if (response.getStatusLine().getStatusCode() == 200) {
				content = EntityUtils.toString(response.getEntity(), "gbk");
				System.out.println(content);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * 处理post请求.
	 * 
	 * @param url
	 *            请求路径
	 * @param params
	 *            参数
	 * @return 
	 */
	public String post(String url, String jsonString) {	
		Map<String, Object> params  = new HashMap<String, Object>();
		JSONObject paramsObject = JSONObject.parseObject(jsonString);
		params = paramsObject.toJavaObject(paramsObject, Map.class);
		//params.put("query", jsonString);
		// 实例化httpClient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 实例化post方法
		HttpPost httpPost = new HttpPost(url);
		// 处理参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
		}
		// 结果
		CloseableHttpResponse response = null;
		String content = "";
		try {
			// 提交的参数
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvps, "utf-8");
			// 将参数给post方法
			httpPost.setEntity(uefEntity);
			// 执行post方法
			response = httpclient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				content = EntityUtils.toString(response.getEntity(), "utf-8");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
	public String post(String url, Map<String, String> params) {	
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 实例化post方法
		HttpPost httpPost = new HttpPost(url);
		// 处理参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
		}
		// 结果
		CloseableHttpResponse response = null;
		String content = "";
		try {
			// 提交的参数
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvps, "utf-8");
			// 将参数给post方法
			httpPost.setEntity(uefEntity);
			// 执行post方法
			response = httpclient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				content = EntityUtils.toString(response.getEntity(), "utf-8");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
}
