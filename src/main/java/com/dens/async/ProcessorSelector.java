package com.dens.async;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.dens.async.holder.ProcessorHolder;

@Component
public class ProcessorSelector implements ApplicationContextInitializer<ConfigurableApplicationContext>, ApplicationListener<ApplicationEvent> {

	private Map<String, ProcessorHolder> processorMap = new ConcurrentHashMap<>();

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		String[] beanNames = applicationContext.getBeanNamesForType(ProcessorHolder.class);
		for (String beanName : beanNames) {
			System.out.println("ProcessorSelector.initialize(): " + beanName);
		}
	}
	
	public ProcessorHolder getProcessor(String type) {
		return processorMap.get(type);
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			ContextRefreshedEvent cre = (ContextRefreshedEvent)event;
			ApplicationContext att = cre.getApplicationContext();
			String[] beanNames = att.getBeanNamesForType(ProcessorHolder.class);
			for (String beanName : beanNames) {
				ProcessorHolder ph = att.getBean(beanName, ProcessorHolder.class);
				String type = ph.getType();
				processorMap.put(type, ph);
			}
		}
	}

}
