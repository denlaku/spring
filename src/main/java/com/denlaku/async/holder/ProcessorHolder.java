package com.denlaku.async.holder;

import com.denlaku.async.IProcessor;

public class ProcessorHolder {

	private String type;
	private String aware;
	private IProcessor processor;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAware() {
		return aware;
	}

	public void setAware(String aware) {
		this.aware = aware;
	}

	public IProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(IProcessor processor) {
		this.processor = processor;
	}

}
