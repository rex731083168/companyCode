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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * 在java中处理http请求.
 * 
 * @author nagsh
 * 
 */
public class HttpDmsClaimTest {
	/**
	 * 处理get请求.
	 * 
	 * @param url
	 *            请求路径
	 * @return json
	 */
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
	 * @return json
	 */
	public String post(String url, String jsonString) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("query", jsonString);
		// 实例化httpClient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 实例化post方法
		HttpPost httpPost = new HttpPost(url);
		// 处理参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}
		// 结果
		CloseableHttpResponse response = null;
		String content = "";
		try {
			// 提交的参数
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvps, "GBK");
			// 将参数给post方法
			httpPost.setEntity(uefEntity);
			// 执行post方法
			response = httpclient.execute(httpPost);
			// System.out.println(response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() == 200) {
				content = EntityUtils.toString(response.getEntity(), "GBK");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	@Test
	public void test1() {
		HttpDmsClaimTest hd = new HttpDmsClaimTest();
		long start = System.currentTimeMillis();
		String add_url = "http://localhost:8080/dms4_claim/Claim/ClaimInterface.jspx";
		String query = "[{\"customerId\":\"01630918\",\"userId\":\"GHQOCLIWJ\",\"claimSource\":\"i\",\"BatchNo\":\"0163091820170914174703\",\"workFlowId\":\"\"},{\"selectCoverages\":[{\"coverageName\":\"中英人寿附加乐安康住院津贴医疗保险\",\"sequence\":1,\"adjustSelected\":\"true\",\"policyNumber\":\"D0608449\",\"coverageCode\":\"HARA\"}],\"claimFolderBaseInfo\":[{\"injureExteriorReasonName\":\"\",\"diseaseName\":\"胆结石（含结石、阻塞、发炎）\",\"diagnosticStatusCode\":\"01\",\"outHospitalTime\":\"2017-07-22\",\"enteringReceiptDetail\":\"false\",\"inICUDate\":\"\",\"buyBack\":\"N\",\"diseaseNo\":\"胆结石\",\"diseaseName2\":\"\",\"bedNumber\":\"\",\"diagnosticStatusName\":\"临床诊断\",\"durationUnit\":{\"name\":\"HOUR\"},\"specificAccidentAddress\":\"\",\"healthCondition\":\"腹部剧烈疼痛\",\"onlineAccept\":\"Y\",\"accidentAddress\":\"\",\"otherDisease\":\"\",\"diagnosticStatus\":{\"name\":\"GENERAL\"},\"openDate\":\"2017-06-29\",\"claimReason\":{\"name\":\"MB\"},\"remitteeType\":{\"name\":\"INSURED\"},\"diseaseNo2\":\"\",\"investigateExpense\":\"\",\"operationName\":\"\",\"inHospitalTime\":\"2017-06-28\",\"remittee\":\"慕青梅\",\"DCChange\":\"true\",\"claimInformationPath\":[{\"formId\":\"SH121\",\"path\":\"/MPM/video_image/2017/09/14/01630918/20170914174652357/01630918.pdf\"},{\"formId\":\"CL801\",\"path\":\"/MPM/allowance_direct/2017/09/14/310D0608449/20170914174659386/310D0608449_OtherPics.pdf\"},{\"formId\":\"CL131\",\"path\":\"/MPM/electronic_sign/2017/09/14/01630918/20170914174657262/01630918_20170914174657_signedPdfFile.pdf\"}],\"bankName\":\"工商银行\",\"investigateExpenseType\":{\"name\":\"NOTHING\"},\"inHospitalStatus\":\"true\",\"operationCode\":\"\",\"applyDate\":\"2017-09-14\",\"outICUDate\":\"\",\"duration\":\"8\",\"injureExteriorReasonCode\":\"\",\"hospitalName\":\"四川省人民医院\",\"dangerousReason\":{\"name\":\"FAIL\"},\"bankkey\":\"22\",\"hospitalCode\":\"\",\"previousHistory\":{\"name\":\"true\"},\"visitDepartment\":\"\",\"cardNumber\":\"6222024402028184103\",\"claimInvestigateCode\":{\"name\":\"OTHER\"}}]}]";
		System.out.println(hd.post(add_url, query));
		System.out.println("响应时间：" + (System.currentTimeMillis() - start) / 1000 + "秒");
	}
}