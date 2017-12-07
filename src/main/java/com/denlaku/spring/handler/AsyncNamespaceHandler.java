package com.denlaku.spring.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.denlaku.spring.parser.ConduitParser;
import com.denlaku.spring.parser.ProcessorParser;

public class AsyncNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("processor", new ProcessorParser());
		registerBeanDefinitionParser("conduit", new ConduitParser());
	}

}
