package com.dens.async.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.dens.async.parser.ConduitParser;
import com.dens.async.parser.ProcessorParser;

public class AsyncNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("processor", new ProcessorParser());
		registerBeanDefinitionParser("conduit", new ConduitParser());
	}

}
