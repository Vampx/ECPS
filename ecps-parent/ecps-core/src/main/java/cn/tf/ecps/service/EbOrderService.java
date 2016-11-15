package cn.tf.ecps.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tf.ecps.po.EbOrder;
import cn.tf.ecps.po.EbOrderDetail;

public interface EbOrderService {

	void saveOrder(EbOrder order, List<EbOrderDetail> detailList,
			HttpServletRequest request, HttpServletResponse response);

}
