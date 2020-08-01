package com.mysprb.mysprb;

import com.mysprb.mysprb.bean.MyBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest
//避免冲突
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MysprbApplicationTests {

	@Autowired
	MyBean myBean;

	//日志记录器
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void contextLoads() {
		System.out.println(myBean);
		//日志记录
		logger.info(myBean.toString());

		//日志输出级别
		//logger.trace("跟踪信息");
		//logger.debug("");
		//logger.info("");
		//logger.warn("");
		//logger.error("");

	}

}

