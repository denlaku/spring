package com.dens.async.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.dens.async.IProcessor;
import com.dens.async.vo.AsyncVO;

@Component("sendService")
public class SendService implements IProcessor {

	@Override
	public void process(AsyncVO asyncVO) {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
		}
		System.out.println("SendService.process()");
	}

}
