package com.denlaku.async.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.denlaku.async.parser.ConduitParser;
import com.denlaku.async.parser.ProcessorParser;

public class AsyncNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("processor", new ProcessorParser());
		registerBeanDefinitionParser("conduit", new ConduitParser());
	}

}
