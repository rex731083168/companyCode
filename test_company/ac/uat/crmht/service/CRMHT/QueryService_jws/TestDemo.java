package ac.uat.crmht.service.CRMHT.QueryService_jws;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

public class TestDemo {
	private static String getMethod(String url,String param) throws IOException{		
		HttpClient httpClient =new HttpClient();		
		String posturl = url + "?" +param;
		HttpMethod method = new GetMethod(posturl);		
		httpClient.executeMethod(method);
		
		String response=new String(method.getResponseBodyAsString().getBytes("ISO-8859-1"),"UTF-8");

		System.out.println("response " + response + "end.....");
		method.releaseConnection();
		return "";	
		
	}
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
    	getMethod("http://10.145.8.77:9077/CRMHT/RESTService", 
				"tradeCode=" + URLEncoder.encode("00040001","utf-8") + 
				"&filterName=" + URLEncoder.encode("RealTimePolicyDetail_MPS","utf-8") + 
				"&param=" + URLEncoder.encode("CHDRCOY,3,CHDRNUM,A0000560","utf-8"));

	}
}
