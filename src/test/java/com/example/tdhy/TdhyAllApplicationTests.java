package com.example.tdhy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.tdhy.po.InProduct;
import com.example.tdhy.service.InProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TdhyAllApplicationTests {

	@Autowired
	public InProductService inProductService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getAll() {
		List<InProduct> inProductMenus;
		try {
			inProductMenus = inProductService.getAll();
			System.out.println(inProductMenus.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
