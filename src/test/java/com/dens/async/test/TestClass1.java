package com.dens.async.test;
//package com.tl.async.test;
//
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.tl.async.AsyncExecutor;
//import com.tl.async.vo.AsyncVO;
//
//public class TestClass1 {
//
//	public static void main(String[] args) {
//		try (ClassPathXmlApplicationContext ctt = new ClassPathXmlApplicationContext("/spring-async.xml");) {
//			AsyncExecutor bean = ctt.getBean(AsyncExecutor.class);
//			AsyncVO asyncVO = new AsyncVO();
//			asyncVO.setType("send");
//			AsyncVO asyncVO2 = new AsyncVO();
//			asyncVO2.setType("receive");
//			for (int i = 0; i < 5; i++) {
//				bean.execute(asyncVO);
//				bean.execute(asyncVO2);
//			}
//		}
//	}
//}
