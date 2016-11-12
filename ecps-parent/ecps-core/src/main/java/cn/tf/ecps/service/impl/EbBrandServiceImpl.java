package cn.tf.ecps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import cn.tf.ecps.dao.EbBrandDao;
import cn.tf.ecps.po.EbBrand;
import cn.tf.ecps.po.EbBrandExample;
import cn.tf.ecps.po.EbBrandExample.Criteria;
import cn.tf.ecps.service.EbBrandService;


@Service
public class EbBrandServiceImpl implements EbBrandService {
	
	@Autowired
	private EbBrandDao brandDao;
	
	public void saveBrand(EbBrand brand) {
		brandDao.saveBrand(brand);
	}

	public List<EbBrand> selectBrandAll() {
		return brandDao.selectBrandAll();
	}

	public List<EbBrand> validBrandName(String brandName) {
		return brandDao.validBrandName(brandName);
	}

	//删除
	public int deleteBrand(String id) {
		return brandDao.deleteBrand(id);
		
	}   

	/*@Autowired
	private EbBrandMapper ebBrandMapper;
	
	public void saveBrand(EbBrand brand) {
		ebBrandMapper.insert(brand);
	}

	public List<EbBrand> selectBrandAll() {
		EbBrandExample brand=new EbBrandExample();
		return ebBrandMapper.selectByExample(brand);
	}

	public List<EbBrand> validBrandName(String brandName) {
		EbBrandExample example=new EbBrandExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andBrandNameEqualTo(brandName);
		
		return ebBrandMapper.selectByExample(example);
	}

*/

}
