package com.dens.sp01.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.dens.sp01.parser.PropertyValueParser;

public class PropertyValueNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("ref", new PropertyValueParser());
	}

}
