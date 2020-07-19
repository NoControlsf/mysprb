package com.mysprb.mysprb;

import com.mysprb.mysprb.bean.MyBean;
import org.junit.Test;
import org.junit.runner.RunWith;
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

	@Test
	public void contextLoads() {
		System.out.println(myBean);
	}

}

