package com.dens.async.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.dens.async.IProcessor;
import com.dens.async.vo.AsyncVO;

@Component("receiveService")
public class ReceiveService implements IProcessor{

	@Override
	public void process(AsyncVO asyncVO) {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ReceiveService.process()");
	}

	
}
