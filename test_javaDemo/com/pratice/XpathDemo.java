package com.pratice;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XpathDemo {
	public static void main(String[] args) {
		Document document = getDocument();
		List<Element> nodes= document.selectNodes("//xpcml/program[@name='BOSUCLPT']/parameterList/structParm[@name='WSAA-RSPDTA']/struct[@name='BOSUCLPTCO-REC']/struct[@name='MESSAGE-DATA']/struct[@name='ADDITIONAL-FIELDS']/arrayOfStringParm/i");
		for (Element element : nodes) {
			System.out.print(element.getTextTrim()+"-->");
		}
		System.out.println();
		System.out.println(nodes.size());
	}
    
	public static Document getDocument() {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read("E://development//wokspace1//javaInCompany//test_javaDemo//com//pratice//demo.xml");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}
}
