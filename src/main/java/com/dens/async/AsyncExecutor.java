package com.dens.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dens.async.holder.ProcessorHolder;
import com.dens.async.vo.AsyncVO;

@Component
public class AsyncExecutor implements InitializingBean, DisposableBean {

	@Autowired
	private ProcessorSelector processorSelector;

	private ExecutorService threadPool;
	private int corePoolSize = 16;
	private int maximumPoolSize = Integer.MAX_VALUE;
	private int keepAliveTime = 60;

	public void execute(AsyncVO asyncVO) {
		this.threadPool.execute(new AsyncTask(asyncVO));
	}

	private class AsyncTask implements Runnable {
		private AsyncVO asyncVO;

		public AsyncTask(AsyncVO asyncVO) {
			this.asyncVO = asyncVO;
		}

		@Override
		public void run() {
			String type = asyncVO.getType();
			ProcessorHolder processorHolder = processorSelector.getProcessor(type);
			IProcessor processor = processorHolder.getProcessor();
			processor.process(asyncVO);
		}

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (this.threadPool == null) {
			this.threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MINUTES,
					new LinkedBlockingQueue<Runnable>(Integer.MAX_VALUE), new RejectedExecutionHandler() {

						@Override
						public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
							
						}

					});
		}
	}

	@Override
	public void destroy() throws Exception {
		if (this.threadPool != null) {
			this.threadPool.shutdown();
		}
	}
}
