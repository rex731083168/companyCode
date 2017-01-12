package com.fastJsonDemo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {
	public static void main(String[] args) {
		String json = "{\"name\":\"sample2-message\",\"origin\":\"1\",\"type\":\"TA86\",\"params\":[{\"param_type\":\"ECSAppInfo\",\"param_maps\":{\"appNum\":\"11836\",\"clntNum\":\"00006199\",\"surName\":\"常少艳\",\"chdrcoy\":\"A\",\"branch\":\"02\",\"chdrNum\":\"19079\",\"fullChdrnum\":\"A0219079\",\"appDate\":\"2016-04-14\",\"appType\":\"TA86\",\"appStatus\":\"0\"}},{\"param_type\":\"ECSLAIFInfo\",\"param_maps\":{\"bankClntNum\":\"00006199\",\"bankAccDsc\":\"常少艳\",\"factHous\":\"boc\",\"bankName\":\"中行\",\"zcardFlg\":\"0\",\"bankAccNum\":\"123456789123456\",\"effDate\":\"20161010\",\"toAmount\":\"10\",\"hhpleamt\":\"y\",\"hpleint\":\"y\",\"needchgacc\":\"y\",\"healthIndicator\":{\"formId\":\"y\",\"cownnum\":\"45679\",\"lifcnum\":\"y\",\"covrArrayList\":[{\"life\":\"y\",\"covrage\":\"10.00\",\"rider\":\"y\",\"crtable\":\"y\",\"sumins\":\"10.00\",\"zbinstprem\":\"10.00\",\"crtableDesc\":\"y\",\"raflag\":\"y\"}],\"transExeDate\":\"y\",\"transExeTime\":\"y\",\"specialTxt\":\"y\",\"sumin\":\"10.00\",\"healthNoteList\":[{\"questionTextOw\":\"y\",\"responseCodeOw\":\"y\",\"responseTextOw\":\"y\",\"questionTextLf\":\"y\",\"responseCodeLf\":\"y\",\"responseTextLf\":\"y\"}]}}}]}";
		JSONObject ecsObject = JSONObject.fromObject(json);
		JSONArray paramsArray = ecsObject.getJSONArray("params");
		JSONObject appInfoObject = paramsArray.getJSONObject(0);
		JSONObject laifInfoObject = paramsArray.getJSONObject(1);
		ECSAppInfo appInfo = new ECSAppInfo();
		ECSLAIFInfo ecsLaifInfo = new ECSLAIFInfo();
		ArrayOfCovrArrayList covrArrayList = new ArrayOfCovrArrayList();
		CovrArrayList covrArrayList2 = new CovrArrayList();
		covrArrayList.getItem().add(covrArrayList2);
		ArrayOfHealthNoteList healthNoteList = new ArrayOfHealthNoteList();
		HealthNoteList noteList = new HealthNoteList();
		healthNoteList.getItem().add(noteList);
		HealthIndicator healthIndicator = new HealthIndicator();
		healthIndicator.setCovrArrayList(covrArrayList);
		healthIndicator.setHealthNoteList(healthNoteList);
		ecsLaifInfo.setHealthIndicator(healthIndicator);
		JSONObject appInfoCase = JSONObject.fromObject(appInfo);
		JSONObject laifInfoCase = JSONObject.fromObject(ecsLaifInfo);
		JSONArray covrArrayListItems = laifInfoCase.getJSONObject("healthIndicator").getJSONObject("covrArrayList")
				.getJSONArray("item");
		laifInfoCase.getJSONObject("healthIndicator").remove("covrArrayList");
		laifInfoCase.getJSONObject("healthIndicator").put("covrArrayList", covrArrayListItems);

		JSONArray healthNoteListItems = laifInfoCase.getJSONObject("healthIndicator").getJSONObject("healthNoteList")
				.getJSONArray("item");
		laifInfoCase.getJSONObject("healthIndicator").remove("healthNoteList");
		laifInfoCase.getJSONObject("healthIndicator").put("healthNoteList", healthNoteListItems);
		appInfoObject.put("param_maps", appInfoCase);
		laifInfoObject.put("param_maps", laifInfoCase);
		String joString = ecsObject.toString();
		joString = joString.replaceAll("ZCardFlg", "zcardFlg");
		joString = joString.replaceAll("TOAMOUNT", "toAmount");
		joString = joString.replaceAll("HHPLEAMT", "hhpleamt");
		joString = joString.replaceAll("HPLEINT", "hpleint");
		joString = joString.replaceAll("ZBINSTPREM", "zbinstprem");
		System.out.println("请求报文是: " + joString);

	}
}
