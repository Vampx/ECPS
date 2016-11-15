package cn.tf.ecps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import cn.tf.ecps.dao.EbBrandDao;
import cn.tf.ecps.dao.EbOrderDao;
import cn.tf.ecps.dao.EbOrderDetailDao;
import cn.tf.ecps.dao.EbSkuDao;
import cn.tf.ecps.dao.TsPtlUserDao;
import cn.tf.ecps.exception.EbStockException;
import cn.tf.ecps.po.EbBrand;
import cn.tf.ecps.po.EbOrder;
import cn.tf.ecps.po.EbOrderDetail;
import cn.tf.ecps.po.EbSku;
import cn.tf.ecps.po.TsPtlUser;
import cn.tf.ecps.service.EbBrandService;
import cn.tf.ecps.service.EbCartService;
import cn.tf.ecps.service.EbOrderService;
import cn.tf.ecps.service.TsPtlUserService;
import cn.tf.ecps.utils.MD5;


@Service
public class EbOrderServiceImpl implements EbOrderService {
	
	@Autowired
	private EbOrderDao orderDao;
	
	@Autowired
	private EbOrderDetailDao detailDao;
	
	@Autowired
	private EbSkuDao skuDao;

	@Autowired
	private EbCartService cartService;
	
	public void saveOrder(EbOrder order, List<EbOrderDetail> detailList,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		//保存订单并且返回orderId
		orderDao.saveOrder(order);
		for(EbOrderDetail detail: detailList){
			detail.setOrderId(order.getOrderId());
			detailDao.saveDetail(detail);
			
			
			map.put("skuId", detail.getSkuId());
			map.put("quantity", detail.getQuantity());
			int flag = skuDao.updateStock(map);
			
			if(flag == 0){
				throw new EbStockException("stock_error");
			}
			//修改redis中的数据库存
			skuDao.updateRedisStock(detail.getSkuId(), detail.getQuantity());
		}
		cartService.clearCart(request, response);
	}

}
