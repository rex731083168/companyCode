package com.fastJsonDemo;

public class Replace {
	public static void main(String[] args) {
		String json = "{\"name\":\"sample2-message\",\"origin\":\"1\",\"type\":\"TA86\",\"params\":[{\"param_type\":\"ECSAppInfo\",\"param_maps\":{\"appNum\":\"11836\",\"clntNum\":\"00006199\",\"surName\":\"常少艳\",\"chdrcoy\":\"A\",\"branch\":\"02\",\"chdrNum\":\"19079\",\"fullChdrnum\":\"A0219079\",\"appDate\":\"2016-04-14\",\"appType\":\"TA86\",\"appStatus\":\"0\"}},{\"param_type\":\"ECSLAIFInfo\",\"param_maps\":{\"bankClntNum\":\"00006199\",\"bankAccDsc\":\"常少艳\",\"factHous\":\"boc\",\"bankName\":\"中行\",\"zcardFlg\":\"0\",\"bankAccNum\":\"123456789123456\",\"effDate\":\"20161010\",\"toAmount\":\"10\",\"hhpleamt\":\"y\",\"hpleint\":\"y\",\"needchgacc\":\"y\",\"healthIndicator\":{\"formId\":\"y\",\"cownnum\":\"45679\",\"lifcnum\":\"y\",\"covrArrayList\":[{\"life\":\"y\",\"covrage\":\"10.00\",\"rider\":\"y\",\"crtable\":\"y\",\"sumins\":\"10.00\",\"zbinstprem\":\"10.00\",\"crtableDesc\":\"y\",\"raflag\":\"y\"}],\"transExeDate\":\"y\",\"transExeTime\":\"y\",\"specialTxt\":\"y\",\"sumin\":\"10.00\",\"healthNoteList\":[{\"questionTextOw\":\"y\",\"responseCodeOw\":\"y\",\"responseTextOw\":\"y\",\"questionTextLf\":\"y\",\"responseCodeLf\":\"y\",\"responseTextLf\":\"y\"}]}}}]}";
        Boolean has=json.contains("name");
        String s1 =json.replace("name","sdfdsf");
        System.out.println(json);
        System.out.println(s1);
	}
}
