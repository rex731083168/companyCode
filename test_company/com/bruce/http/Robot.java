package com.bruce.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class Robot {
	/**
	 * 处理post请求.
	 * 
	 * @param url
	 *            请求路径
	 * @param params
	 *            参数
	 * @return json
	 */
	public String post(String url, String jsonString) {
		Map<String, Object> params = new HashMap<String, Object>();
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
	@Test
	public void testInfo(){
		String APIKEY = "4bae56fd5b4f4cf3a81fdf1c778983bd";
		String info = "你是傻逼吗";
		//String loc = "北京到上海的飞机";
		//String userid = "12345678";
		String jsonString = "{'key':'"+APIKEY+"','info':'"+info+"'}";
		String add_url = "http://www.tuling123.com/openapi/api";
		//add_url = "http://devaclmp.95545.com.cn/healthy/care/home/exchangeRecord.do";
		String result=new Robot().post(add_url, jsonString);
		System.out.println(result);
	}
}
