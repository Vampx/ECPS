package cn.tf.ecps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.tf.ecps.dao.EbItemDao;

import cn.tf.ecps.po.EbItem;
import cn.tf.ecps.service.EbItemService;
import cn.tf.ecps.utils.Page;
import cn.tf.ecps.utils.QueryCondition;

@Service
public class EbItemServiceImpl implements EbItemService {

	@Autowired
	private EbItemDao itemDao;

	public Page selectItemByCondition(QueryCondition qc) {
		// 获得页码
		Integer pageNo = qc.getPageNo();
		// 创建page对象
		Page page = new Page();
		page.setPageNo(pageNo);
		// 查询当前条件下的记录数
		Integer totalCount = itemDao.selectItemByConditionCount(qc);
		page.setTotalCount(totalCount);
		// 获得开始行号和结束行号
		Integer startNum = page.getStartNum();
		Integer endNum = page.getEndNum();
		// 把开始行号和结束行号设置给qc对象
		qc.setStartNum(startNum);
		qc.setEndNum(endNum);
		// 查询结果集
		List<EbItem> itemList = itemDao.selectItemByCondition(qc);
		// 给page对象设置结果集
		page.setList(itemList);
		return page;
	}

}
