package cn.tf.ecps.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import cn.tf.ecps.po.EbCart;
import cn.tf.ecps.po.EbShipAddrBean;
import cn.tf.ecps.po.TsPtlUser;
import cn.tf.ecps.service.EbCartService;
import cn.tf.ecps.service.EbShipAddrService;


@Controller
@RequestMapping("/order")
public class EbOrderController {
	
	@Autowired
	private EbShipAddrService addrService;
	@Autowired
	private EbCartService cartService;
	
	
	
	@RequestMapping("/toSubmitOrder.do")
	public String toSubmitOrder(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Model model){
		TsPtlUser  userId=(TsPtlUser) session.getAttribute("user");
		
		List<EbShipAddrBean> addrList = addrService.selectAddrByUserIdWithRedis(userId.getPtlUserId());
		model.addAttribute("addrList",addrList);
		
		//查询购物车的数据
		List<EbCart> cartList = cartService.selectCart(request, response);
		model.addAttribute("cartList",cartList);
		Integer itemNum=0;
		BigDecimal totalPrice = new BigDecimal(0);
		for (EbCart cart : cartList) {
			//计算商品数量
			itemNum = cart.getQuantity() + itemNum;
			//计算商品总金额，不会损失精度
			totalPrice = totalPrice.add(cart.getSku().getSkuPrice().multiply(new BigDecimal(cart.getQuantity())));
		}
		model.addAttribute("itemNum", itemNum);
		model.addAttribute("totalPrice", totalPrice);
		
		
		return "shop/confirmProductCase";
	}
	
	
	

}
