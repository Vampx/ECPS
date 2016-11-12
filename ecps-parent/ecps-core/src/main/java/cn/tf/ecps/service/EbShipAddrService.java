package cn.tf.ecps.service;

import java.util.List;

import cn.tf.ecps.po.EbShipAddr;
import cn.tf.ecps.po.EbShipAddrBean;

public interface EbShipAddrService {
	
	public List<EbShipAddrBean>  selectAddrByUserId(Long userId);

	public EbShipAddr selectAddrById(Long shipAddrId);
	
	public void saveOrUpdateAddr(EbShipAddr addr);
	
	

}
