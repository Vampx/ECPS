package cn.tf.ecps.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import cn.tf.ecps.dao.EbBrandDao;
import cn.tf.ecps.dao.EbShipAddrDao;
import cn.tf.ecps.dao.TsPtlUserDao;
import cn.tf.ecps.po.EbBrand;
import cn.tf.ecps.po.EbBrandExample;
import cn.tf.ecps.po.EbBrandExample.Criteria;
import cn.tf.ecps.po.EbShipAddr;
import cn.tf.ecps.po.EbShipAddrBean;
import cn.tf.ecps.po.TsPtlUser;
import cn.tf.ecps.service.EbBrandService;
import cn.tf.ecps.service.EbShipAddrService;
import cn.tf.ecps.service.TsPtlUserService;
import cn.tf.ecps.utils.MD5;


@Service
public class EbShipAddrServiceImpl implements EbShipAddrService {
	
	@Autowired
	private EbShipAddrDao shipAddrDao;

	
	public List<EbShipAddrBean> selectAddrByUserId(Long userId) {
		return shipAddrDao.selectAddrByUserId(userId);
	}


	public EbShipAddr selectAddrById(Long shipAddrId) {
		return shipAddrDao.selectAddrById(shipAddrId);
	}


	public void saveOrUpdateAddr(EbShipAddr addr) {
		//修改默认收货地址,把默认变为非默认
		shipAddrDao.updateDefaultAddr(addr.getPtlUserId());
		
		if(addr.getShipAddrId()==null){
			//说明是新增
			shipAddrDao.saveAddr(addr);
		}else{
			//说明是修改
			shipAddrDao.updateAddr(addr);
		}
		
		
		
	}
	
	

}
