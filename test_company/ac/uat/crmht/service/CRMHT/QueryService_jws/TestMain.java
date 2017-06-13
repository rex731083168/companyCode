package ac.uat.crmht.service.CRMHT.QueryService_jws;

import java.rmi.RemoteException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import net.sf.json.JSONObject;

public class TestMain {

	public static void main(String[] args) throws DocumentException {
		QueryServiceProxy  proxy=new QueryServiceProxy();
		String[] map01 = {"COWNNUM","00196012"};
		String resultInfo="";
		String customLvl = "";
		try {
			resultInfo = proxy.getXMLList("00040001", "InsuInfo", map01);
			Document document = DocumentHelper.parseText(resultInfo);
			Iterator iterator = document.selectNodes("/TradeData/OutputData/ECSInfo/InsuInfo/Item").iterator();
			while(iterator!=null && iterator.hasNext()){
				JSONObject insured = new JSONObject();
				Element element = (Element) iterator.next();
				String name =  element.elementTextTrim("SURNAME");
				String cardType = element.elementTextTrim("CTRYORIG");
				String cardNo = element.elementTextTrim("SECUITYNO");
				insured.put("name", name);
				insured.put("cardType", cardType);
				insured.put("cardNo", cardNo);
				System.out.println(insured.toString());
			}
			//System.out.println(resultInfo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("客户的层级:"+customLvl);
	}
	@Test
    public void test(){
    	QueryServiceProxy  proxy=new QueryServiceProxy();
		String[] map01 = {"COWNNUM","00196012"};
		String result;
		try {
			result = proxy.getXMLList("00040001", "Client_Info", map01);
			System.out.println("result=========>>>>>>>:\n"+result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }	
}
