package cn.tf.ecps.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tf.ecps.po.EbOrder;
import cn.tf.ecps.po.EbOrderDetail;
import cn.tf.ecps.po.TaskBean;

public interface EbOrderService {

	//保存订单
	public String  saveOrder(EbOrder order, List<EbOrderDetail> detailList,
			HttpServletRequest request, HttpServletResponse response);

	//更新支付状态
	public void updatePay(String processInstanceId, Long orderId);

	
	public List<TaskBean>   selectOrderPay(String assignee,Short isCall);
	
	
	
}
