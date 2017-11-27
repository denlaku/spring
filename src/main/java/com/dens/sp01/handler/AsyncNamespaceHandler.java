package com.dens.sp01.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.dens.sp01.parser.ConduitParser;
import com.dens.sp01.parser.ProcessorParser;

public class AsyncNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("processor", new ProcessorParser());
		registerBeanDefinitionParser("conduit", new ConduitParser());
	}

}
