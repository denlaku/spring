package com.denlaku.spring.parser;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public final class PropertyValueParser extends AbstractSingleBeanDefinitionParser {

	@Override
	protected boolean shouldGenerateId() {
		return true;
	}
	
	@Override
	protected String getBeanClassName(Element element) {
		return element.getAttribute("class");
	}

	@Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		super.doParse(element, parserContext, builder);
		AbstractBeanDefinition bd = builder.getBeanDefinition();
		MutablePropertyValues propertyValues = bd.getPropertyValues();
		String beanName = element.getAttribute("bean");
		RuntimeBeanNameReference rbnr = new RuntimeBeanNameReference(beanName);
//		RuntimeBeanReference rbnr = new RuntimeBeanReference(beanName);
		propertyValues.add("carId", rbnr);
	}
}
