package cn.tf.ecps.service;

import java.util.List;

import cn.tf.ecps.po.EbBrand;
import cn.tf.ecps.po.EbBrandExample;



public interface EbBrandService {
	
	/*//保存
	public void saveBrand(EbBrand brand);
	//查询
	public List<EbBrand> selectBrandAll();
	//通过商品名查询
	public List<EbBrand> validBrandName(String brandName);*/
	
	public void saveBrand(EbBrand brand);
	
	public List<EbBrand> selectBrandAll();
	
	public List<EbBrand> validBrandName(String brandName);
 
}
