package com.bruce.http;

import java.util.HashMap;
import java.util.Map;
public class Sign {
	private static String[] VALIDFIELDS = { "RdSeq", "Amount" };
	
	public static String invo(String Amount, String RdSeq, String tmpSafeCode) {
		String tmpSign = "";
		try {
			Map mapDetails = new HashMap();
			mapDetails.put("RdSeq",RdSeq);
			mapDetails.put("Amount",Amount);
			System.out.println(mapDetails.keySet());
			 Map mapParams = new HashMap();
		      for (String tmpValidField : VALIDFIELDS) {
		        if (mapDetails.containsKey(tmpValidField)) {
		          mapParams.put(tmpValidField, mapDetails.get(tmpValidField));
		        }
		      }
		      System.out.println("mapParams"+mapParams);
			String tmpWaitSign = Crypto.buildObjectSortWaitSign(mapParams, false);
			System.out.println("tmpWaitSign"+tmpWaitSign);
			System.out.println(tmpWaitSign);
			String tmpEncoding = "UTF-8";
			tmpWaitSign = tmpWaitSign + "&key=" + tmpSafeCode;
			StringBuilder sbErr = new StringBuilder();
			tmpSign = Crypto.md5ToHexString(tmpWaitSign, tmpEncoding, sbErr);
			System.out.println("待签串：" + tmpWaitSign + "   编码：" + tmpEncoding +"   tmpSign:"+tmpSign);
			System.out.println("MD5签名---->"+tmpSign);
			return tmpSign;

		} catch (Exception ex) {
			System.out.println("生成签名异常：" + ex);
			return tmpSign;
		}
	}
	public static String invo(String RdSeq, String tmpSafeCode) {
		String tmpSign = "";
		try {
			Map mapDetails = new HashMap();
			mapDetails.put("RdSeq",RdSeq);
			System.out.println(mapDetails.keySet());
			 Map mapParams = new HashMap();
		      for (String tmpValidField : VALIDFIELDS) {
		        if (mapDetails.containsKey(tmpValidField)) {
		          mapParams.put(tmpValidField, mapDetails.get(tmpValidField));
		        }
		      }
		      System.out.println("mapParams"+mapParams);
			String tmpWaitSign = Crypto.buildObjectSortWaitSign(mapParams, false);
			System.out.println("tmpWaitSign"+tmpWaitSign);
			System.out.println(tmpWaitSign);
			String tmpEncoding = "UTF-8";
			tmpWaitSign = tmpWaitSign + "&key=" + tmpSafeCode;
			StringBuilder sbErr = new StringBuilder();
			tmpSign = Crypto.md5ToHexString(tmpWaitSign, tmpEncoding, sbErr);
			System.out.println("待签串：" + tmpWaitSign + "   编码：" + tmpEncoding +"   tmpSign:"+tmpSign);
			System.out.println("MD5签名---->"+tmpSign);
			return tmpSign;

		} catch (Exception ex) {
			System.out.println("生成签名异常：" + ex);
			return tmpSign;
		}
	}


	  
	public static void main(String[] args) {
		Sign.invo("2017000000168282", "DFE23HLAW198820SQWE1224SDAQQ3319201234");
	}
}
