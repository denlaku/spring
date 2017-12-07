package com.denlaku.async.holder;

import java.util.List;

import com.denlaku.async.IProcessor;

public class ConduitHolder {

	private List<String> conduits;
	
	private IProcessor processorService;

	public IProcessor getProcessorService() {
		return processorService;
	}

	public void setProcessorService(IProcessor processorService) {
		this.processorService = processorService;
	}

	public List<String> getConduits() {
		return conduits;
	}

	public void setConduits(List<String> conduits) {
		this.conduits = conduits;
	}
}
