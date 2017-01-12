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

/**
 * 在java中处理http请求.
 * 
 * @author nagsh
 * 
 */
public class HttpDeal {
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
		Map<String, String> params  = new HashMap<String, String>();
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
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvps, "gbk");
			// 将参数给post方法
			httpPost.setEntity(uefEntity);
			// 执行post方法
			response = httpclient.execute(httpPost);
			//System.out.println(response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() == 200) {
				content = EntityUtils.toString(response.getEntity(), "gbk");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public static void main(String[] args) {
		HttpDeal hd = new HttpDeal();
		//String query = "[{workFlowId:\"123456\",customerId:\"00151084\",userId:\"999\",declareReportId:\"\",BatchNo:\"\",claimSource:\"I\"},{claimFolderBaseInfo:[{applyDate:\"2015-11-12\",openDate:\"2014-08-09\",inHospitalTime:\"2014-08-09\",outHospitalTime:\"2014-08-13\",dangerousReason:{name:\"FAIL\"},claimReason:{name:\"A1\"},inHospitalStatus:\"true\",previousHistory:{name:\"true\"},healthCondition:\"1122\",duration:\"3\",durationUnit:{name:\"HOUR\"},investigateExpenseType:{name:\"\"},investigateExpense:\"\",specificAccidentAddress:\"\",claimInvestigateCode:{name:\"OTHER\"},diseaseName:\"伤寒性脑膜炎\",diseaseNo:\"A01.003\",diagnosticStatus:{name:\"GENERAL\"},diseaseName2:\"\",diseaseNo2:\"\",injureExteriorReasonName:\"\",injureExteriorReasonCode:\"\",otherDisease:\"\",diagnosticStatusName:\"\",diagnosticStatusCode:\"\",accidentAddress:\"624600\",hospitalName:\"福建省妇幼保健院\",hospitalCode:\"\",visitDepartment:\"\",bedNumber:\"\",inICUDate:\"\",outICUDate:\"\",operationName:\"\",operationCode:\"\",enteringReceiptDetail:\"false\",onlineAccept:\"Y\",buyBack:\"N\"}],selectCoverages:[{adjustSelected:\"false\",sequence:\"0\"},{adjustSelected:\"true\",sequence:\"1\"},{adjustSelected:\"true\",sequence:\"2\"},{adjustSelected:\"false\",sequence:\"0\"},{adjustSelected:\"true\",sequence:\"3\"},{adjustSelected:\"true\",sequence:\"4\"}],prescription:[{externalReference:\"住院\",prescriptionId:\"\",prescriptionLines:[{drugOrTreatmentName1:\"\",drugOrTreatmentCode1:\"\",amount:\"\",againAmount:\"\",discount:\"\",againDiscount:\"\",adjustmentType:\"\",adjustmentDescription:\"\",receiptType:\"\",receiptNumber:\"\",receiptProvideUnit:\"\",outpatientDate:\"\",expenseTotalAmount:\"\",prescriptionLine_Type:\"\"},{drugOrTreatmentName2:\"\",drugOrTreatmentCode2:\"\",amount:\"\",againAmount:\"\",discount:\"\",againDiscount:\"\",adjustmentType:\"\",adjustmentDescription:\"\",receiptType:\"\",receiptNumber:\"\",receiptProvideUnit:\"\",outpatientDate:\"\",expenseTotalAmount:\"\",prescriptionLine_Type:\"\"}]},{externalReference:\"手术\",prescriptionId:\"\",visitingOfficerDescription:\"\",prescriptionLines:[{drugOrTreatmentName1:\"\",drugOrTreatmentCode1:\"\",amount:\"\",againAmount:\"\",discount:\"\",againDiscount:\"\",adjustmentType:\"\",adjustmentDescription:\"\",receiptType:\"\",receiptNumber:\"\",receiptProvideUnit:\"\",outpatientDate:\"\",expenseTotalAmount:\"\",prescriptionLine_Type:\"\"}]},{externalReference:\"门诊\",prescriptionId:\"\",prescriptionLines:[{drugOrTreatmentName1:\"\",drugOrTreatmentCode1:\"\",amount:\"\",againAmount:\"\",discount:\"\",againDiscount:\"\",adjustmentType:\"\",adjustmentDescription:\"\",receiptType:\"\",receiptNumber:\"\",receiptProvideUnit:\"\",outpatientDate:\"\",expenseTotalAmount:\"\",prescriptionLine_Type:\"\"}]}],BenefitClaim:[{Selected:\"true\",benefitName:\"急救医疗运送保险金\",claimShare:\"1\",paidDays:\"\",deductDays:\"\",deductType:\"\",deductDescription:\"\"},{Selected:\"false\",benefitName:\"住院急诊保险金\",claimShare:\"1\",paidDays:\"\",deductDays:\"\",deductType:\"\",deductDescription:\"\"}]}]";
		String query = "{\"workFlowId\":\"123456\",\"customerId\":\"00151084\",\"userId\":\"999\",\"BatchNo\":\"\",\"declareReportId\":\"\",\"claimSource\":\"I\",\"reparations\":[{\"claimFolderBaseInfo\":{\"applyDate\":\"2016-12-02\",\"openDate\":\"2016-11-01\",\"inHospitalTime\":\"2016-11-01\",\"outHospitalTime\":\"2016-11-11\",\"dangerousReason\":\"FAIL\",\"claimReason\":\"MB\",\"inHospitalStatus\":\"true\",\"previousHistory\":\"true\",\"healthCondition\":\"11\",\"duration\":\"1\",\"durationUnit\":\"HOUR\",\"investigateExpenseType\":\"\",\"investigateExpense\":\"\",\"specificAccidentAddress\":\"四川省阿坝州阿坝县地税局家属区\",\"claimInvestigateCode\":\"OTHER\",\"diseaseName\":\"急性粒细胞性白血病,未分化型(M1型)\",\"diseaseNo\":\"C92.001\",\"diagnosticStatus\":\"GENERAL\",\"diseaseName2\":\"\",\"diseaseNo2\":\"\",\"injureExteriorReasonName\":\"\",\"injureExteriorReasonCode\":\"\",\"otherDisease\":\"\",\"diagnosticStatusName\":\"\",\"diagnosticStatusCode\":\"\",\"accidentAddress\":\"624600\",\"hospitalName\":\"解放军161医院\",\"hospitalCode\":\"\",\"visitDepartment\":\"\",\"bedNumber\":\"\",\"inICUDate\":\"\",\"outICUDate\":\"\",\"operationName\":\"\",\"operationCode\":\"\",\"enteringReceiptDetail\":\"false\",\"onlineAccept\":\"Y\",\"buyBack\":\"Y\"},\"selectCoverages\":[{\"adjustSelected\":\"true\",\"sequence\":\"2\",\"policyNumber\":\"A0103636\",\"coverageName\":\"HSAA\"},{\"adjustSelected\":\"true\",\"sequence\":\"4\",\"policyNumber\":\"A0103636\",\"coverageName\":\"HCRA\"},{\"adjustSelected\":\"true\",\"sequence\":\"3\",\"policyNumber\":\"A0115364\",\"coverageName\":\"HSRA\"},{\"adjustSelected\":\"true\",\"sequence\":\"1\",\"policyNumber\":\"A0103636\",\"coverageName\":\"HSRA\"}],\"prescription\":[{\"externalReference\":\"住院\",\"doctor\":\"\",\"transactor\":\"\",\"hospitalAudit\":\"\",\"visitingOfficerDescription\":\"\",\"prescriptionLines\":{\"drugOrTreatmentName\":\"测试1201\",\"drugOrTreatmentCode\":\"\",\"amount\":\"1000\",\"againAmount\":\"1000\",\"discount\":\"10\",\"againDiscount\":\"10\",\"adjustmentType\":\"MEDICARE_SELF_ACOUNT\",\"adjustmentDescription\":\"xxxxx测试\",\"receiptType\":\"\",\"receiptNumber\":\"\",\"receiptProvideUnit\":\"\",\"receiptProvideUnitCode\":\"\",\"outpatientDate\":\"\",\"expenseTotalAmount\":\"\",\"prescriptionLine_Type\":\"\"}},{\"externalReference\":\"手术\",\"doctor\":\"\",\"transactor\":\"\",\"hospitalAudit\":\"\",\"visitingOfficerDescription\":\"\",\"prescriptionLines\":{\"drugOrTreatmentName\":\"\",\"drugOrTreatmentCode\":\"\",\"amount\":\"\",\"againAmount\":\"\",\"discount\":\"\",\"againDiscount\":\"\",\"adjustmentType\":\"\",\"adjustmentDescription\":\"\",\"receiptType\":\"\",\"receiptNumber\":\"\",\"receiptProvideUnit\":\"\",\"receiptProvideUnitCode\":\"\",\"outpatientDate\":\"\",\"expenseTotalAmount\":\"\",\"prescriptionLine_Type\":\"\"}},{\"externalReference\":\"门诊\",\"doctor\":\"\",\"transactor\":\"\",\"hospitalAudit\":\"\",\"visitingOfficerDescription\":\"\",\"prescriptionLines\":{\"drugOrTreatmentName\":\"\",\"drugOrTreatmentCode\":\"\",\"amount\":\"\",\"againAmount\":\"\",\"discount\":\"\",\"againDiscount\":\"\",\"adjustmentType\":\"\",\"adjustmentDescription\":\"\",\"receiptType\":\"\",\"receiptNumber\":\"\",\"receiptProvideUnit\":\"\",\"receiptProvideUnitCode\":\"\",\"outpatientDate\":\"\",\"expenseTotalAmount\":\"\",\"prescriptionLine_Type\":\"\"}}],\"BenefitClaim\":[{\"Selected\":\"true\",\"benefitName\":\"急救医疗运送保险金\",\"claimShare\":\"1\",\"paidDays\":\"\",\"deductDays\":\"\",\"deductType\":\"\",\"deductDescription\":\"\"},{\"Selected\":\"false\",\"benefitName\":\"住院急诊保险金\",\"claimShare\":\"1\",\"paidDays\":\"\",\"deductDays\":\"\",\"deductType\":\"\",\"deductDescription\":\"\"}]}]}";
		String add_url = "http://localhost:8080/dms4_claim/Claim/ClaimInterface.jspx";
		//获取response返回报文携带的值
		long start = System.currentTimeMillis();
		System.out.println(hd.post(add_url, query));
		long end = System.currentTimeMillis();
		System.out.println("赔案信息录入时间:  "+(end-start)+"ms");
	}
}