package cn.tf.ecps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class EbOrderController {
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		
		return "order/index";
	}
	
	@RequestMapping("/listOrderPay.do")
	public String listOrderPay(String assignee,Model model){
		
		
		return "order/orderPay/orderPay";
	}
	
	
}
