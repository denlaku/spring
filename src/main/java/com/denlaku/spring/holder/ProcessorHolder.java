package com.denlaku.spring.holder;

import com.denlaku.spring.service.IProcessorService;

public class ProcessorHolder {

	private IProcessorService processorService;

	public IProcessorService getProcessorService() {
		return processorService;
	}

	public void setProcessorService(IProcessorService processorService) {
		this.processorService = processorService;
	}
	
}
