package com.dens.sp01.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class TestLog4J {

	@Test
	public void genXML() {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("root");
		root.addAttribute("class", "com.dens.test.TestLog4J");
		root.addAttribute("id", "testLog4J");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		try {
			File file = new File("C:\\Users\\User\\Desktop\\xml\\TelePhone.xml");
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			XMLWriter out = new XMLWriter(new FileWriter(file), format);
			out.write(doc);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void parseXML() {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read("C:\\Users\\User\\Desktop\\xml\\TelePhone.xml");
			Element root = doc.getRootElement();
			String name = root.getName();
			Attribute attribute = root.attribute("class");
			System.out.println(root);
			System.out.println(name);
			System.out.println(attribute.getName());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
