package com.dens.async.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dens.async.AsyncExecutor;
import com.dens.async.service.ReceiveService;
import com.dens.async.vo.AsyncVO;

public class TestClass0 {

	@Test
	public void test03() {
		try (ClassPathXmlApplicationContext ctt = new ClassPathXmlApplicationContext("/beans.xml") {
			protected void initPropertySources() {
				this.getEnvironment().addActiveProfile("dev");
				this.setAllowBeanDefinitionOverriding(true);
			};

			protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {
				super.prepareBeanFactory(beanFactory);
				beanFactory.registerAlias("receiveService", "rs");
			};
		};) {
			ReceiveService receiveService = ctt.getBean("rs", ReceiveService.class);
			System.out.println(receiveService);
			
			
			try {
				TimeUnit.SECONDS.sleep(6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Test
	public void test02() {
		try (ClassPathXmlApplicationContext ctt = new ClassPathXmlApplicationContext("/beans.xml") {
			protected void initPropertySources() {
				this.getEnvironment().addActiveProfile("dev");
				this.setAllowBeanDefinitionOverriding(true);
			};

			protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {
				super.prepareBeanFactory(beanFactory);
				beanFactory.registerAlias("receiveService", "rs");
			};
		};) {
			ReceiveService bean = ctt.getBean("rs", ReceiveService.class);
			System.out.println(bean);
		}
	}

	@Test
	public void test01() {
		try (ClassPathXmlApplicationContext ctt = new ClassPathXmlApplicationContext("/spring-async.xml");) {
			AsyncExecutor bean = ctt.getBean(AsyncExecutor.class);
			AsyncVO asyncVO = new AsyncVO();
			asyncVO.setType("send");
			AsyncVO asyncVO2 = new AsyncVO();
			asyncVO2.setType("receive");
			for (int i = 0; i < 5; i++) {
				bean.execute(asyncVO);
				bean.execute(asyncVO2);
			}
		}
	}
}
