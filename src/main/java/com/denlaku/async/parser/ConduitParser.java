package com.denlaku.async.parser;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import com.denlaku.async.holder.ConduitHolder;

public class ConduitParser extends AbstractSingleBeanDefinitionParser {
	@Override
	protected Class<?> getBeanClass(Element element) {
		return ConduitHolder.class;
	}

	@Override
	protected boolean shouldGenerateId() {
		return true;
	}

	@Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		super.doParse(element, parserContext, builder);
		AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();

		Object conduits = parserContext.getDelegate().parseArrayElement(element, beanDefinition);
		builder.addPropertyValue("conduits", conduits);
	}
}
