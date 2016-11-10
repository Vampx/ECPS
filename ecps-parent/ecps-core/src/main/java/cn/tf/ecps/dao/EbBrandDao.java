package cn.tf.ecps.dao;

import java.util.List;

import cn.tf.ecps.po.EbBrand;



public interface EbBrandDao {
	
	public void saveBrand(EbBrand brand);
	
	public List<EbBrand> selectBrandAll();
	
	

	public List<EbBrand> validBrandName(String brandName);

	public int deleteBrand(String id);
}
