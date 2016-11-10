package cn.tf.ecps.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tf.ecps.dao.EbItemDao;
import cn.tf.ecps.po.EbItem;
import cn.tf.ecps.utils.QueryCondition;

@Repository
public class EbItemDaoImpl extends SqlSessionDaoSupport implements EbItemDao {

	String ns = "cn.tf.ecps.mapper.EbItemMapper.";

	public List<EbItem> selectItemByCondition(QueryCondition qc) {
		return this.getSqlSession().selectList(ns+"selectItemByCondition", qc);
	}

	public Integer selectItemByConditionCount(QueryCondition qc) {
		return this.getSqlSession().selectOne(ns+"selectItemByConditionCount", qc);
	}

	public int deleteGoods(String id) {
		return this.getSqlSession().delete(ns+"deleteByItemNO", id);
	}

	public EbItem selectItemByNo(String id) {
		return this.getSqlSession().selectOne(ns+"selectByNO", id);
	}
	
	
}

