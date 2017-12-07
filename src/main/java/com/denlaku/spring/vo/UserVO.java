package com.denlaku.spring.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import lombok.Data;

@Data
public class UserVO implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, BeanClassLoaderAware,
		ApplicationContextAware, ApplicationListener<ApplicationEvent> {

	@Value("SSSSS")
	private String name;
	private String value;
	private Character chr;
	private boolean bool;
	private Date birth;
	private List<String> list;
	private Set<String> set;
	private Map<String, String> map;
	private Properties properties;
	private int[] array;
	private CarVO car;
	private String carId;
	private AddressVO address;

	public UserVO() {
		super();
		System.out.println("UserVO.UserVO()");
	}


	public void init() {
		System.out.println("UserVO.init()");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("UserVO.setBeanName()");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("UserVO.setBeanFactory()");
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("UserVO.setBeanClassLoader()");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("UserVO.setApplicationContext()");
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("UserVO.onApplicationEvent()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("UserVO.afterPropertiesSet()");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("UserVO.destroy()");
	}

	// @PostConstruct
	public void initM() {
		System.out.println("UserVO.initM()");
	}

}
