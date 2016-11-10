package cn.tf.ecps.dao;

import java.util.List;

import cn.tf.ecps.po.EbItem;
import cn.tf.ecps.utils.QueryCondition;

public interface EbItemDao {
	public List<EbItem>  selectItemByCondition(QueryCondition qc);
	
	public Integer selectItemByConditionCount(QueryCondition qc);

	public int deleteGoods(String id);

	public EbItem selectItemByNo(String id);

}
