package com.denlaku.async.parser;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import com.denlaku.async.holder.ProcessorHolder;

public class ProcessorParser extends AbstractSingleBeanDefinitionParser {

	private static final String TYPE = "type";
	private static final String AWARE = "aware";

	@Override
	protected Class<?> getBeanClass(Element element) {
		return ProcessorHolder.class;
	}

	@Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		super.doParse(element, parserContext, builder);
		AbstractBeanDefinition bd = builder.getBeanDefinition();
		BeanDefinitionParserDelegate delegate = parserContext.getDelegate();
		MutablePropertyValues propertyValues = bd.getPropertyValues();

		String type = element.getAttribute(TYPE);
		if (type != null && !"".equals(type)) {
			propertyValues.add(TYPE, type);
		}

		String aware = element.getAttribute(AWARE);
		if (aware != null && !"".equals(aware)) {
			propertyValues.add(AWARE, aware);
		}

		Object value = delegate.parseArrayElement(element, bd);
		propertyValues.add("processor", value);

		// String type = element.getAttribute(TYPE);
		// if (StringUtil.isNonEmpty(type)) {
		// builder.addPropertyValue(TYPE, type);
		// }
		//
		// String aware = element.getAttribute(AWARE);
		// if (StringUtil.isNonEmpty(type)) {
		// builder.addPropertyValue(AWARE, aware);
		// }
		//
		// Object value = delegate.parseArrayElement(element, beanDefinition);
		// builder.addPropertyValue("processor", value);

	}

	@Override
	protected boolean shouldGenerateId() {
		return true;
	}
}
