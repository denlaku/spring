package com.dens.sp01.test;

import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.denlaku.async.service.ReceiveService;
import com.denlaku.spring.vo.UserVO;

public class TestClass0 {

	@Test
	public void test03() {
		try (ClassPathXmlApplicationContext ctt = new ClassPathXmlApplicationContext("beans.xml") {
			protected void initPropertySources() {
				this.getEnvironment().addActiveProfile("dev");
				this.setAllowBeanDefinitionOverriding(true);
			};

			protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {
				super.prepareBeanFactory(beanFactory);
//				beanFactory.registerAlias("receiveService", "rs");
			};
		};) {
			UserVO userVO = ctt.getBean("userVO", UserVO.class);
			System.out.println(userVO);
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
//		try (ClassPathXmlApplicationContext ctt = new ClassPathXmlApplicationContext("/beans.xml");) {
//			ProcessorHolder processorConfig = ctt.getBean("com.dens.config.ProcessorConfig#0", ProcessorHolder.class);
//			System.out.println(processorConfig);
//			System.out.println(processorConfig.getProcessorService());
//
//			ConduitHolder conduitConfig = ctt.getBean("com.dens.config.ConduitConfig#0", ConduitHolder.class);
//			System.out.println(conduitConfig);
//			System.out.println(conduitConfig.getConduits());
//		}
	}
}
