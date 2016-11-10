package cn.tf.ecps.dao;

import java.util.List;

import cn.tf.ecps.po.EbSku;



public interface EbSkuDao {

	public void saveSku(List<EbSku> skuList, Long itemId);
	
	
}
