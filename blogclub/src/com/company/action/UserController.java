package com.company.action;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.bean.User;
import com.company.service.IUserService;

/**
 * @author CJF
 * @category 用户控制器
 */
@Controller
public class UserController {
	@Resource
	private IUserService userService;

	/**
	 * 注册控制器
	 */
	@RequestMapping("/regist")
	public String regist(User user, Model model, HttpServletRequest request) {
		user.setIp(request.getRemoteAddr());
		user.setInputdate(new Timestamp(System.currentTimeMillis()));
		boolean flag = userService.add(user);
		return "";
	}
}
