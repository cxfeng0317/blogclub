package com.company.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.bean.User;
import com.company.service.IBlogService;
import com.company.service.IUserService;
import com.company.vo.BlogVO;

@Controller
public class IndexController {

	@Resource
	private IBlogService iblogService;
	@Resource
	private IUserService userService;

	/**
	 * 首页
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		List<BlogVO> hotList = iblogService.findHotList();
		List<BlogVO> indexList = iblogService.findIndexList();
		model.addAttribute("hotList", hotList);
		model.addAttribute("indexList", indexList);
		return "index";
	}

	/**
	 * 登录控制器
	 */
	@RequestMapping("/login")
	public String login(String captcha, HttpSession session, String name, String pass, Model model) {
		String sessionCaptcha = session.getAttribute("simpleCaptcha").toString();
		if (captcha.equals(sessionCaptcha)) {
			User user = userService.findByName(name, pass);
			if (user != null) {
				session.setAttribute("current_user", user);
				session.setMaxInactiveInterval(60 * 30);
				return "forward:personblogschemalist.action?uid=" + user.getId();
			} else {
				model.addAttribute("mess", "密码输入有误！");
				return "login";
			}
		} else {
			model.addAttribute("mess", "验证码输入有误！");
			return "login";
		}

	}

	/**
	 * 注销控制器
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index.action";
	}

}
