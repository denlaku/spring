package com.dens.sp01.holder;

import com.dens.sp01.service.IProcessorService;

public class ProcessorHolder {

	private IProcessorService processorService;

	public IProcessorService getProcessorService() {
		return processorService;
	}

	public void setProcessorService(IProcessorService processorService) {
		this.processorService = processorService;
	}
	
}
