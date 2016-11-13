package cn.tf.ecps.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.tf.ecps.po.EbBrand;
import cn.tf.ecps.po.EbItem;
import cn.tf.ecps.utils.ECPSUtil;
import cn.tf.ecps.utils.FMutil;


@RunWith(SpringJUnit4ClassRunner.class)//指定juit的spring运行器
@ContextConfiguration(locations={"classpath:beans.xml"})//指定spring的文件
public class EbBrandServiceTest {

	@Autowired
	private EbBrandService brandService;
	

/*	@Test
	public void testSaveBrand() {
		EbBrand brand=new EbBrand();
		brand.setBrandName("苹果8");
		brand.setBrandDesc("最新版");
		brand.setBrandSort(1);
		brand.setImgs("http://taotao.tianfang1314.cn");
		brand.setWebsite("http://taotao.tianfang1314.cn");
		brandService.saveBrand(brand);
	
	}*/
	@Autowired
	private EbItemService itemService;

	@Test
	public void testGeneraHtml() throws Exception {
		Map<String,Object>  map=new HashMap<String,Object> ();
		EbItem item=itemService.selectItemDetailById(3080);
		map.put("item", item);
		
		map.put("path", ECPSUtil.readProp("portal_path"));
		map.put("file_path", ECPSUtil.readProp("FILE_PATH"));
		FMutil fm=new FMutil();

	     fm.ouputFile("productDetail.ftl", item.getItemId()+".html", map);
	
	}
	
}
