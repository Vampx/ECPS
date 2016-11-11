package cn.tf.ecps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tf.ecps.po.EbBrand;
import cn.tf.ecps.po.EbFeature;
import cn.tf.ecps.service.EbBrandService;
import cn.tf.ecps.service.EbFeatureService;
import cn.tf.ecps.service.EbItemService;

@Controller
@RequestMapping("/item")
public class EbItemController {

	@Autowired
	private EbBrandService brandService;

	@Autowired
	private EbFeatureService featureService;

	// 进入主页面
	@RequestMapping("/toIndex.do")
	public String toIndex(Model model) {
		// 查询品牌
		List<EbBrand> bList = brandService.selectBrandAll();
		model.addAttribute("bList", bList);
		// 查询筛选属性
		List<EbFeature> fList = featureService.selectIsSelectFeature();
		model.addAttribute("fList", fList);

		return "index";
	}

	// 商品列表查询
	@RequestMapping("/listItem.do")
	public String listItem() {
		return "phoneClassification";
	}

}
