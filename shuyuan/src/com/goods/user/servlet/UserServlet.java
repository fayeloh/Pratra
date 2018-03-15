package com.goods.user.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fayeloh.tools.commons.CommonUtils;
import com.fayeloh.tools.servlet.BaseServlet;
import com.goods.user.entity.User;
import com.goods.user.exception.UserException;
import com.goods.user.servies.UserServies;

public class UserServlet extends BaseServlet {
	UserServies userServies = new UserServies();

	/*
	 * ajax 校验用户名是否注册
	 */
	public String ajaxValidateLoginName(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 取得密码
		String loginname = request.getParameter("loginname");
		// 通过servies得到结果
		boolean b = userServies.validateLoginName(loginname);
		// 发给客户端
		response.getWriter().print(b);
		return null;
	}

	/*
	 * ajax email校验
	 */
	public String ajaxValidateEmail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 取得用户名
		String email = request.getParameter("email");
		// 通过servies得到结果
		boolean b = userServies.validateEmail(email);
		// 发给客户端
		response.getWriter().print(b);
		return null;
	}

	/*
	 * ajax 验证码校验
	 */
	public String ajaxValidateVerifyCode(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.取得输入框的验证码
		String verifyCode = request.getParameter("verifyCode");
		// 2.取得图片上的验证码
		String vCode = (String) request.getSession().getAttribute("vCode");
		// 3.判断验证码是否一致,忽略大小写
		boolean b = verifyCode.equalsIgnoreCase(vCode);
		// 发给客户端
		response.getWriter().print(b);
		return null;
	}

	/**
	 * 激活功能
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String activation(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取激活码2.调用Servies的方法 3.绑定信息
		 */
		String code = request.getParameter("activationCode");
		try {
			userServies.activation(code);
			request.setAttribute("code", "success");
			request.setAttribute("msg", "恭喜你，激活成功");
		} catch (Exception e) {
			request.setAttribute("code", "error");
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/jsps/user/regist.jsp";
	}

	/**
	 * 注册功能
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String regist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.封装表单数据到User
		User formUser = CommonUtils.toBean(request.getParameterMap(),
				User.class);
		// 2.校验之，有错误的话，封装信息，转发jsp中
		// Map<String,String> errors =
		// validateRegist(formUser,request.getSession());
		// if(errors.size()>0){
		// //errors有值才执行
		// request.setAttribute("form", formUser);
		// request.setAttribute("errors", errors);
		// return "f:/jsps/user/regist.jsp";
		// }
		// 3.使用servies处理业务
		userServies.regist(formUser);
		// 4.转发到msg.jsp
		request.setAttribute("code", "success");
		request.setAttribute("msg", "注册成功，请马上到邮箱激活！");
		return "f:/jsps/msg.jsp";
	}

	/**
	 * 登录功能
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.保存表单数据 2.校验 3.调用servies的方法 4.若user为空，显示信息：不存在该用户 保存错误信息 保存数据，为了回显
		 * 5，user不为空，但status为false，显示信息：该用户未激活 保存错误信息 保存数据，为了回显
		 * 6.存在且true，绑定到session且存到cookie中（cookie注意编码） 7.跳转页面
		 */
		// 1.保存信息
		User formUser = CommonUtils.toBean(request.getParameterMap(),
				User.class);
		// 2.校验
		// Map<String,String> errors =
		// validateRegist(formUser,request.getSession());
		// if(errors.size()>0){
		// //errors有值才执行
		// request.setAttribute("user", formUser);
		// request.setAttribute("errors", errors);
		// return "f:/jsps/user/login.jsp";
		// }
		// 3.调用servies的信息
		User user = userServies.login(formUser);
		// 4.判断
		if (user == null) {
			request.setAttribute("msg", "登录名或密码错误");
			request.setAttribute("user", formUser);
			return "f:/jsps/msg.jsp";
		} else {
			if (!user.isStatus()) {
				request.setAttribute("msg", "该用户未激活");
				request.setAttribute("user", formUser);
				return "f:/jsps/user/login.jsp";
			} else {
				// 绑定到session中
				// request.getSession().setAttribute("sessionUser", formUser);
				request.getSession().setAttribute("sessionUser", user);
				// 增加cookie
				String loginname = user.getLoginname();
				loginname = URLEncoder.encode(loginname, "utf-8");
				Cookie cookie = new Cookie("loginname", loginname);
				cookie.setMaxAge(60 * 60 * 12 * 10); // 单位是秒
				response.addCookie(cookie);
				return "r:/shuyuan/index.jsp";
			}
		}
	}
	/**
	 * 单点登录
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String sso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("loginname");
		ServletContext context = this.getServletContext();
		List<String> usernameList = (List<String>) context.getAttribute("usernameList");
		if(usernameList==null){
			usernameList = new ArrayList<String>();
			context.setAttribute("usernameList", usernameList);
			
		}
		System.out.println("sso");
		/*
		 * 调用servies的checkOnline方法
		 */
		boolean flag = userServies.checkOnline(username,usernameList);
		if(!flag){
			login(request, response);//如果没登陆，调用登陆方法
			return "r:/shuyuan/index.jsp";
		}else{
			request.setAttribute("code", "success");//否则发送已登陆信息
			request.setAttribute("msg", "抱歉，该用户已登陆");
			return "f:/jsps/msg.jsp";
		}
		
	}
	/**
	 * 修改密码
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String updatePassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.封装表单参数 2.校验 3.调用servies的方法 4.
		 */
		User formUser = CommonUtils.toBean(request.getParameterMap(),
				User.class);
		User user = (User) request.getSession().getAttribute("sessionUser");
		if (user == null) {
			request.setAttribute("msg", "你没登陆");
			request.setAttribute("user", formUser);
			return "f:/jsps/user/login.jsp";
		}
		try {
			userServies.updatePassWord(user.getLoginname(),
					formUser.getLoginpass(), formUser.getNewpass());
			System.out.println("uidservlet" + user.getUid());
			request.setAttribute("msg", "恭喜你修改成功");
			request.setAttribute("code", "success");
			return "f:/jsps/msg.jsp";
		} catch (UserException e) {
			// 密码不正确异常保存信息，为了回显
			System.out.println(formUser.getLoginpass() + "数据库"
					+ user.getLoginpass());
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", formUser);
			return "f:/jsps/user/pwd.jsp";
		}
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String quit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		return "f:/jsps/user/login.jsp";
	}

	/*
	 * 校验注册 对表单字段进行校验，若有错误，当前字段为key，错误信息为value，封装到map中 返回map
	 */
	private Map<String, String> validateRegist(User formUser,
			HttpSession session) {
		Map<String, String> errors = new HashMap<String, String>();
		/*
		 * 用户名校验
		 */
		String loginname = formUser.getLoginname();
		if (loginname == null || loginname.trim().length() == 0) {
			errors.put("loginname", "用户名不能为空");
		} else if (loginname.length() < 3 || loginname.length() > 20) {
			errors.put("loginname", "用户名长度必须3~20");
		} else if (!userServies.validateLoginName(loginname)) {
			errors.put("loginname", "该用户已注册");
		}
		/*
		 * 密码校验
		 */
		String loginpass = formUser.getLoginpass();
		if (loginpass == null || loginpass.trim().length() == 0) {
			errors.put("loginpass", "密码不能为空");
		} else if (loginpass.length() < 3 || loginpass.length() > 20) {
			errors.put("loginpass", "密码长度必须3~20");
		}
		/*
		 * 重置 密码校验
		 */
		String repassword = formUser.getRepassword();
		if (repassword == null || repassword.trim().length() == 0) {
			errors.put("repassword", "密码不能为空");
		} else if (!repassword.equals(loginpass)) {
			errors.put("repassword", "两次密码必须相同");
		}
		/*
		 * email校验
		 */
		String email = formUser.getEmail();
		if (email == null || email.trim().length() == 0) {
			errors.put("email", "密码不能为空");
		} else if (email
				.matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$")) {
			errors.put("email", "邮箱格式错误");
		} else if (!userServies.validateEmail(email)) {
			errors.put("email", "该邮箱已被注册");
		}
		/*
		 * 验证码校验
		 */
		String verifyCode = formUser.getVerifyCode();
		String vCode = (String) session.getAttribute("vCode");
		if (verifyCode == null || verifyCode.trim().length() == 0) {
			errors.put("verifyCode", "验证码为空");
		} else if (verifyCode.length() != 4) {
			errors.put("verifyCode", "验证码位数");
		} else if (!verifyCode.equalsIgnoreCase(vCode)) {
			errors.put("verifyCode", "验证码错误");
		}
		return errors;

	}

	/**
	 * 登陆的相关校验
	 * 
	 * @param formUser
	 * @param session
	 * @return
	 */
	private Map<String, String> validateLogin(User formUser, HttpSession session) {
		Map<String, String> errors = new HashMap<String, String>();
		return errors;

	}
}
