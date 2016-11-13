package cn.tf.ecps.dao;

import java.util.List;

import cn.tf.ecps.po.EbSku;



public interface EbSkuDao {

	
	public EbSku getSkuById(Long skuId);

	public void saveSku(List<EbSku> skuList, Long itemId);

	public EbSku getSkuDetail(Long skuId);
	
	
	public EbSku getSkuDetailWithRedis(Long skuId);
}
