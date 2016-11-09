package cn.tf.ecps.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.tf.ecps.po.EbBrand;


@RunWith(SpringJUnit4ClassRunner.class)//指定juit的spring运行器
@ContextConfiguration(locations={"classpath:beans.xml"})//指定spring的文件
public class EbBrandServiceTest {

	@Autowired
	private EbBrandService brandService;

	@Test
	public void testSaveBrand() {
		EbBrand brand=new EbBrand();
		brand.setBrandName("苹果8");
		brand.setBrandDesc("最新版");
		brand.setBrandSort(1);
		brand.setImgs("http://taotao.tianfang1314.cn");
		brand.setWebsite("http://taotao.tianfang1314.cn");
		brandService.saveBrand(brand);
	
	}

	
}
