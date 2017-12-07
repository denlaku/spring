package com.dens.sp01.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.denlaku.spring.vo.AddressVO;
import com.denlaku.spring.vo.CarVO;
import com.denlaku.spring.vo.UserVO;

public class TestClass {
	
	@Test
	public void test03() {
//		String path = "D:\\sts-bundle-3.8.4\\workspace\\spring\\test\\sp01\\src\\main\\resources\\beans.xml";
		String path = "classpath:beans.xml";
		try (FileSystemXmlApplicationContext fac = new FileSystemXmlApplicationContext(path);) {
//			fac.getBeanFactory().registerSingleton("obj", new Object());
			UserVO bean = fac.getBean("userVO", UserVO.class);
			System.out.println(bean);
//			System.out.println(fac.getBean("obj", Object.class));
		}

	}

	@Test
	public void test02() {
		Class<?>[] cls = { UserVO.class, AddressVO.class, CarVO.class };
		try (AnnotationConfigApplicationContext aa = new AnnotationConfigApplicationContext(cls);) {
			UserVO bean = aa.getBean("userVO", UserVO.class);
			System.out.println(bean);
		}

	}

	@Test
	public void test01() {
		try (ClassPathXmlApplicationContext ctt = new ClassPathXmlApplicationContext("/beans.xml") {
			protected void initPropertySources() {
				// this.getEnvironment().addActiveProfile("dev");
			};
		};) {
			UserVO bean = ctt.getBean("userVO", UserVO.class);
			System.out.println(bean);
		}
	}

}
