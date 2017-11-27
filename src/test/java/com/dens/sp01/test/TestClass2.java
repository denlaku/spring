package com.dens.sp01.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ClassUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class TestClass2 {

	@Test
	public void test01() {

//		ClassPathXmlApplicationContext ctt = new ClassPathXmlApplicationContext(path);
//		NamedService bean = ctt.getBean("startService", NamedService.class);
//		System.out.println(bean);
//		ctt.close();
	}

	@Test
	public void test02() {
		// String str = "C:\\Users\\User\\Desktop\\class_";

		InputStream resourceAsStream = TestClass2.class.getResourceAsStream("/beans.xml");
		System.out.println(resourceAsStream);

	}

	@Test
	public void test03() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		try {
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			InputStream is = TestClass2.class.getClassLoader().getResourceAsStream("beans.xml");
			InputSource source = new InputSource(is);
			Document doc = docBuilder.parse(source);

			Element root = doc.getDocumentElement();
			String namespaceURI = root.getNamespaceURI();
			System.out.println(namespaceURI);
			System.out.println(root);
			NodeList childNodes = root.getChildNodes();
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node node = childNodes.item(i);
				if (node instanceof Element) {
					Element ele = (Element) node;
					System.out.println("namespace : " + ele.getNamespaceURI());
					System.out.println(ele.getNodeName());
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testClassUtil() {
		try {
			Class<?> forName = ClassUtils.forName("com.dens.sp01.test.TestClass", TestClass2.class.getClassLoader());
			System.out.println(forName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (LinkageError e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testClassPathResource() {
		ClassPathResource resource = new ClassPathResource(path);
		ClassLoader cl = resource.getClassLoader();
		String description = resource.getDescription();
		System.out.println(description);
		System.out.println(cl);
		try {
			InputStream inputStream = resource.getInputStream();
			System.out.println(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testStringTokenizer() {
		StringTokenizer st = new StringTokenizer("DDD;A|AA;FFF,GG", ";,|");
		
		while(st.hasMoreTokens()) {
			String nextToken = st.nextToken();
			System.out.println(nextToken);
		}
	}

	public static String path = "/beans.xml";
}
