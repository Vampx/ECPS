package cn.tf.ecps.service;

import java.util.List;

import cn.tf.ecps.po.EbBrand;
import cn.tf.ecps.po.EbBrandExample;
import cn.tf.ecps.po.EbItem;
import cn.tf.ecps.utils.Page;
import cn.tf.ecps.utils.QueryCondition;



public interface EbItemService {
	
	
	public Page selectItemByCondition(QueryCondition qc);

	public int deleteGoods(String id);

	//通过itm_no查询
	public EbItem selectItemByNo(String id);
 
}
