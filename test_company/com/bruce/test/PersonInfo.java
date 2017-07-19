package com.bruce.test;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

public class PersonInfo {
	public static void main(String[] args) {
		String identity = "362202199306076517";
		String name = "罗团";
		String result = invokeNciicService(identity, name);
		System.out.println(result);
	}
	/**
	 * 查询公民身份是否一致
	 * @param identity
	 * @param name
	 * @return
	 */
	private static String invokeNciicService(String identity, String name) {
		RPCServiceClient serviceClient = null;
		try {
			ProtocolSocketFactory easy = new EasyTLSProtocolSocketFactory();
			Protocol protocol = new Protocol("https", easy, 443);
			Protocol.registerProtocol("https", protocol);

			String HTTPS_URL = "https://api.nciic.com.cn/nciic_ws/services/NciicServices";
			serviceClient = new RPCServiceClient();
			Options options = serviceClient.getOptions();
			EndpointReference targetEPR = new EndpointReference(HTTPS_URL);
			int timeOut = Integer.valueOf(1800000);
			options.setTimeOutInMilliSeconds(timeOut); // 10000 seconds
			options.setProperty(HTTPConstants.CHUNKED, Boolean.FALSE);
			options.setProperty(HTTPConstants.SO_TIMEOUT, timeOut);
			options.setProperty(HTTPConstants.CONNECTION_TIMEOUT, timeOut);
			options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, Boolean.TRUE);
			// client.getOptions().setProperty(HTTPConstants.AUTO_RELEASE_CONNECTION,
			// Boolean.TRUE);
			options.setExceptionToBeThrownOnSOAPFault(true);
			options.setTo(targetEPR);
			/** * 读取授权文件内容，因为授权文件为加密格式请不要对内容做任何修改 */
			String licensecode = null;
			BufferedReader in;
			try {
				in = new BufferedReader(new FileReader(
						"E:\\development\\wokspace1\\javaInCompany\\test_company\\rszyzyrs46038_1092.txt"));
				licensecode = in.readLine();
				System.out.println("licensecode:" + licensecode);
			} catch (Exception e) {
				System.out.println("读取授权文件异常，异常信息:" + e.getMessage());
				System.out.println(e);
				return null;
			}
			// 服务条件模板获取
			QName nciicGetCondition = new QName("https://ws.nciic.org.cn/nciic_ws/services/NciicServices",
					"nciicGetCondition");
			Object[] nciicGetConditionArgs = new Object[] { licensecode };
			@SuppressWarnings("rawtypes")
			Class[] returnTypes = new Class[] { String.class };
			Object[] response = serviceClient.invokeBlocking(nciicGetCondition, nciicGetConditionArgs, returnTypes);
			if (response == null) {
				System.out.println("nciicGetCondition response is null !");
				return null;
			}
			String result = (String) response[0];
			if (result == null) {
				System.out.println("nciicGetCondition response[0] is null !");
				return null;
			}
			System.out.println("nciicGetCondition result : " + result);
			QName nciicCheck = new QName("https://api.nciic.com.cn/nciic_ws/services/NciicServices", "nciicCheck");
			String nciicGetConditionInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROWS><INFO><SBM>avivaCofco</SBM></INFO><ROW><GMSFHM>公民身份号码</GMSFHM><XM>姓名</XM></ROW><ROW FSD=\"500000\" YWLX=\"保险\"><GMSFHM>"
					+ identity + "</GMSFHM><XM>" + name + "</XM></ROW></ROWS>";
			Object[] nciicCheckArgs = new Object[] { licensecode, nciicGetConditionInput };
			@SuppressWarnings("rawtypes")
			Class[] returnTypes2 = new Class[] { String.class };
			Object[] response2 = serviceClient.invokeBlocking(nciicCheck, nciicCheckArgs, returnTypes2);
			if (response2 == null) {
				System.out.println("nciicCheck didn't initialize!");
				// log.error("nciicGetCondition response2 is null !");
				return null;
			}
			String result2 = (String) response2[0];
			if (result2 == null) {
				System.out.println("nciicCheck didn't initialize!");
				// log.error("nciicGetCondition response2[0] is null !");
				return null;
			}
			// Displaying the result
			System.out.println("nciicCheck result : " + result2);
			// log.info("nciicCheck result : " + result2);
			return result2;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error:" + e);
			// log.error(e.getMessage(), e);
		} finally {
			try {
				// clear up
				serviceClient.cleanupTransport();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("error:" + e);
				// System.out.println(e.getMessage(), e);
			}
		}
		return null;
	}
}
