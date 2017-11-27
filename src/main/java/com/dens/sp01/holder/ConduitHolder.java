package com.dens.sp01.holder;

import java.util.List;

import com.dens.sp01.service.IProcessorService;

public class ConduitHolder {

	private List<String> conduits;
	
	private IProcessorService processorService;

	public IProcessorService getProcessorService() {
		return processorService;
	}

	public void setProcessorService(IProcessorService processorService) {
		this.processorService = processorService;
	}

	public List<String> getConduits() {
		return conduits;
	}

	public void setConduits(List<String> conduits) {
		this.conduits = conduits;
	}
}
