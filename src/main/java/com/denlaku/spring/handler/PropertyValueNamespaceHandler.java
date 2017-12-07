package com.denlaku.spring.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.denlaku.spring.parser.PropertyValueParser;

public class PropertyValueNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("ref", new PropertyValueParser());
	}

}
