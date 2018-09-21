package com.situ.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.ssm.entity.Banji;
import com.situ.ssm.service.IBanjiService;
import com.situ.ssm.service.impl.BanjiServiceImpl;
import com.situ.ssm.vo.PageBean;

@Controller
@RequestMapping(value = "/banji")
public class BanjiController {
	private IBanjiService banjiService = new BanjiServiceImpl();

	@RequestMapping(value = "/pageList")
	public String pageList(Integer pageNo, Integer pageSize, Model model) {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (pageSize == null) {
			pageSize = 3;
		}
		PageBean<Banji> pageBean = banjiService.getPageBean(pageNo, pageSize);
		model.addAttribute("pageBean", pageBean);
		return "/banji/banji_list";
	}

	@RequestMapping(value = "/deleteById")
	public String deleteById(Integer id, Integer pageNo) {
		boolean result = banjiService.deleteById(id);
		return "redirect:/banji/pageList.action?pageNo=" + pageNo;
	}

	@RequestMapping(value = "/getAddPage")
	public String getAddPage() {
		return "/banji/banji_add";
	}

	@RequestMapping(value = "/checkName")
	@ResponseBody
	public boolean checkName(String name) {
		boolean isExist = banjiService.checkName(name);
		return isExist;
	}

	@RequestMapping(value = "/addBanji")
	@ResponseBody
	public boolean addBanji(Banji banji) {
		return banjiService.addBanji(banji);
	}

	@RequestMapping(value = "/getUpdatePage")
	public String getUpdatePage() {
		return "/banji/banji_update";
	}

	@RequestMapping(value = "/updateBanji")
	public String updateBanji() {

		return null;
	}
}
