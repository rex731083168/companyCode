package com.tools.util;
/**
 * 将浮点数转化为人民币（中文）
 * 此程序只支持万元内的转化
 * @author luotuan
 *
 */
public class RMBExchange {
	//中文数字
	private static String[] upperNum = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	//单位
	private static String[] moneyNumber={"十","佰","千","万"};
	//货币单位
	private static String[] moneyUnit = {"元","角","分"};
	public static void main(String[] args) {
		String result = getRMBinfo(5001.01);
		System.out.println(result);
	}
	/**
	 * 转为人民币输出
	 * @param num
	 * @return
	 */
	private static String getRMBinfo(double num){
		String result = "";
		String[] moneys = divide(num);
		//整数部分
		String whole = moneys[0];
		//小数部分
		String decimal = moneys[1];
		int size1 = whole.length();
		//整数部分中文货币拼接
		for(int i=0;i<size1;i++){
			int number = Integer.parseInt(whole.substring(i, i+1));
			if(i!=size1-1){
				if(number!=0){
					result+= upperNum[number]+moneyNumber[size1-i-2];
				}else{
					result+=upperNum[number];
				}
			}else{
				result+=upperNum[number];
			}
		}
		while(result.endsWith("零")){
			result = result.substring(0, result.length()-1);
		}
		if(result.contains("零零")){
			result = result.replace("零零", "零");
		}
		result+=moneyUnit[0];
		//分数部分拼接
		int size2 = decimal.length();
		for(int j=0;j<size2;j++){
			int number = Integer.parseInt(decimal.substring(j, j+1));
			if(j!=size2-1){
				if(number!=0){
					result+=upperNum[number]+moneyUnit[j+1];
				}else{
					result+=upperNum[number];
				}
			}else{
				if(number!=0){
					result+=upperNum[number]+moneyUnit[j+1];
				}
			}
		}
		return result;
	}
	/**
	 * 解析浮点数
	 * @param num
	 * @return
	 */
    private static String[] divide(double num){
    	//获取浮点数的整数部分
    	long whole = (long) num;
    	//取2位小数
    	long decimal = Math.round((num-whole)*100);
    	String decimalStr = String.valueOf(decimal);
    	if(decimal<10){
    		decimalStr="0"+decimal;
    	}
    	//用数组存储整数位和小数
    	return new String[]{String.valueOf(whole),decimalStr};
    }
    
}
