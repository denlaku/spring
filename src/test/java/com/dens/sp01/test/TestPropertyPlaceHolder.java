package com.dens.sp01.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.denlaku.spring.vo.UserVO;

public class TestPropertyPlaceHolder {

	@Test
	public void test01() {
		try (ClassPathXmlApplicationContext ctt = new ClassPathXmlApplicationContext("/spring-placeholder.xml") {
			protected void postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory beanFactory) {
				super.postProcessBeanFactory(beanFactory);
//				BeanDefinition bd = beanFactory.getBeanDefinition("userVO");
//				MutablePropertyValues propertyValues = bd.getPropertyValues();
//				PropertyValue propertyValue = propertyValues.getPropertyValue("name");
//				System.out.println(propertyValue.getName() + " : " + propertyValue.getValue());
			};
			
		};) {
			UserVO userVO = ctt.getBean("userVO", UserVO.class);
			System.out.println(userVO);
		}
	}
}
