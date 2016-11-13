package cn.tf.ecps.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tf.ecps.dao.EbSkuDao;
import cn.tf.ecps.po.EbSku;
import cn.tf.ecps.po.EbSpecValue;



@Repository
public class EbSkuDaoImpl extends SqlSessionDaoSupport implements EbSkuDao {

	String ns = "cn.tf.ecps.mapper.EbSkuMapper.";
	String ns1 = "cn.tf.ecps.mapper.EbSpecValueMapper.";

	public void saveSku(List<EbSku> skuList, Long itemId) {
		SqlSession session = this.getSqlSession();
		for(EbSku sku : skuList){
			//设置itemId
			sku.setItemId(itemId);
			//保存sku并且返回skuId
			session.insert(ns+"insert", sku);
			List<EbSpecValue> specList = sku.getSpecList();
			for(EbSpecValue sv : specList){
				//设置skuId外键
				sv.setSkuId(sku.getSkuId());
				session.insert(ns1+"insert", sv);
			}
		}
	}

	public EbSku getSkuById(Long skuId) {
		return this.getSqlSession().selectOne(ns+"selectByPrimaryKey",skuId);
	}

	public EbSku getSkuDetail(Long skuId) {
		return this.getSqlSession().selectOne(ns+"getSkuDetail",skuId);
	}

	public EbSku getSkuDetailWithRedis(Long skuId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
