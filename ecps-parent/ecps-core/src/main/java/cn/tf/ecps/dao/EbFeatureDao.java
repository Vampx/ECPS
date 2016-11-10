package cn.tf.ecps.dao;

import java.util.List;

import cn.tf.ecps.po.EbFeature;

public interface EbFeatureDao {
	// 查询普通属性 
	public List<EbFeature>  selectCommFeature();
	
	//查询特殊属性
	public List<EbFeature>  selectSpecFeature();
	

}
