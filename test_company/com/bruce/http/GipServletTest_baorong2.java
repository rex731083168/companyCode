package com.bruce.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class GipServletTest_baorong2 {

	public static void ceshi() {
		try {

			URL url;
			String result = "", requesttype = "post", urlStr = "";
			String key = "DFE23HLAW198820SQWE1224SDAQQ3319201234";
			urlStr = "http://testopen.aviva-cofco.com.cn:8080/GIP/GIPServlet?";
			SortedMap<String, String> tmap = new TreeMap<String, String>();
			// 接口平台参数
			tmap.put("tradetype", "04");
			tmap.put("username", "SSF");
			tmap.put("queueId", "realtimeservice");
			tmap.put("transparent", "0");
			tmap.put("requesttype", "post");
			tmap.put("charset", "utf-8");

			StringBuffer buffer = null;
			try {
				FileInputStream fi = new FileInputStream(new File("E:/recall.txt"));
				BufferedReader in = new BufferedReader(new InputStreamReader(fi, "gbk"));
				buffer = new StringBuffer();
				String line = "";
				while ((line = in.readLine()) != null) {
					buffer.append(line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			String dmsinput = buffer.toString();
			String dmsinput_encode = URLEncoder.encode(dmsinput, "GBK");
			System.out.println("----->" + dmsinput_encode);
			tmap.put("xml", dmsinput_encode);//
			StringBuilder sbd = new StringBuilder("");
			for (String tkey : tmap.keySet()) {
				sbd.append(tkey).append("=").append(tmap.get(tkey)).append("&");
			}
			String d = sbd.toString();
			String orginData = d.substring(0, d.length() - 1) + key;
			System.out.println("orginData:" + orginData);
			String encryData = Md5Util.getMD5Str(orginData, "utf-8");// 签名编码utf-86
			String paras = d + "sign=" + encryData;
			System.out.println("paras:" + paras);
			// urlStr+="sign="+encryData;
			System.out.println("urlStr--->" + urlStr);
			HttpURLConnection conn;
			// 1
			url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			if ("get".equals(requesttype)) {
				conn.setRequestMethod("GET");

			}

			// 2
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setConnectTimeout(180000);
			conn.setReadTimeout(60000);

			if (!"get".equals(requesttype)) {
				PrintWriter output;
				output = new PrintWriter(conn.getOutputStream());
				output.print(paras);
				output.flush();
				output.close();
			}
			String line = "";
			conn.connect();
			InputStreamReader temp1 = new InputStreamReader(conn.getInputStream(), "GBK");
			BufferedReader in = new BufferedReader(temp1);
			while ((line = in.readLine()) != null) {
				result += line + "\n";
			}

			System.out.println("结果如下：" + result);
			in.close();
			temp1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String post() throws Exception {
		Map<String, Object> sParaTemp = new HashMap<>();
		String key = "DFE23HLAW198820SQWE1224SDAQQ3319201234";
		String urlStr = "https://testopen.aviva-cofco.com.cn/GIP/GIPServlet";
		sParaTemp.put("tradetype", "04");
		sParaTemp.put("username", "SSF");
		sParaTemp.put("queueId", "realtimeservice");
		sParaTemp.put("transparent", "0");
		sParaTemp.put("requesttype", "post");
		sParaTemp.put("charset", "utf-8");
		StringBuffer buffer = null;
		try {
			FileInputStream fi = new FileInputStream(new File("E:/search.txt"));
			BufferedReader in = new BufferedReader(new InputStreamReader(fi, "gbk"));
			buffer = new StringBuffer();
			String line = "";
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String dmsinput = buffer.toString();
		String dmsinput_encode = URLEncoder.encode(dmsinput, "GBK");
		System.out.println("----->" + dmsinput_encode);
		sParaTemp.put("xml", dmsinput_encode);//6
		StringBuilder sbd = new StringBuilder("");
		for (String tkey : sParaTemp.keySet()) {
			sbd.append(tkey).append("=").append(sParaTemp.get(tkey)).append("&");
		}
		String d = sbd.toString();
		String orginData = d.substring(0, d.length() - 1) + key;
		System.out.println("orginData:" + orginData);
		String encryData = Md5Util.getMD5Str(orginData, "utf-8");// 签名编码utf-86
		sParaTemp.put("sign", encryData);
		HttpClient httpClient = new HttpClient();
		PostMethod post = new PostMethod(urlStr);
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		List<String> keys = new ArrayList<String>(sParaTemp.keySet());
		NameValuePair[] param = new NameValuePair[keys.size() + 1];
		for (int i = 0; i < keys.size(); i++) {
			String name = keys.get(i);
			Object object = sParaTemp.get(name);
			String value = "";
			if (object != null) {
				value = (String) sParaTemp.get(name);
			}
			// 添加参数
			param[i] = new NameValuePair(name, value);
			post.setParameter(param[i].getName(), param[i].getValue());
		}
		HttpMethod method = post;
		httpClient.executeMethod(method);
		String response = method.getResponseBodyAsString();
		System.out.println("response---->"+response);
		post.releaseConnection();
		return response;
	}

	public static void main(String[] args) throws Exception {
		GipServletTest_baorong2.ceshi();
		//post();
	}
}
