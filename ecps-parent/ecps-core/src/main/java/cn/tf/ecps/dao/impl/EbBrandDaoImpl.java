package cn.tf.ecps.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tf.ecps.dao.EbBrandDao;
import cn.tf.ecps.po.EbBrand;


@Repository
public class EbBrandDaoImpl extends SqlSessionDaoSupport implements EbBrandDao {

	String ns = "cn.tf.ecps.mapper.EbBrandMapper.";
	
	public void saveBrand(EbBrand brand) {
		this.getSqlSession().insert(ns+"insert", brand);
	}

	public List<EbBrand> selectBrandAll() {
		return this.getSqlSession().selectList(ns+"selectBrandAll");
	}

	public List<EbBrand> validBrandName(String brandName) {
		return this.getSqlSession().selectList(ns+"validBrandName", brandName);
	}

}
