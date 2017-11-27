package com.dens.sp01.parser;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.dens.sp01.holder.ProcessorHolder;

public final class  ProcessorParser extends AbstractSingleBeanDefinitionParser {
	@Override
	protected Class<?> getBeanClass(Element element) {
		return ProcessorHolder.class;
	}

	@Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		super.doParse(element, parserContext, builder);
		AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
		BeanDefinitionParserDelegate delegate = parserContext.getDelegate();
		Object val = delegate.parseArrayElement(element, beanDefinition);
		Node item = element.getChildNodes().item(1);
		delegate.parseIdRefElement((Element)item);
		builder.addPropertyValue("processorService", val);
	}

	@Override
	protected boolean shouldGenerateId() {
		return true;
	}
}
