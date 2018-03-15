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
	 * ajax У���û����Ƿ�ע��
	 */
	public String ajaxValidateLoginName(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ȡ������
		String loginname = request.getParameter("loginname");
		// ͨ��servies�õ����
		boolean b = userServies.validateLoginName(loginname);
		// �����ͻ���
		response.getWriter().print(b);
		return null;
	}

	/*
	 * ajax emailУ��
	 */
	public String ajaxValidateEmail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ȡ���û���
		String email = request.getParameter("email");
		// ͨ��servies�õ����
		boolean b = userServies.validateEmail(email);
		// �����ͻ���
		response.getWriter().print(b);
		return null;
	}

	/*
	 * ajax ��֤��У��
	 */
	public String ajaxValidateVerifyCode(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.ȡ����������֤��
		String verifyCode = request.getParameter("verifyCode");
		// 2.ȡ��ͼƬ�ϵ���֤��
		String vCode = (String) request.getSession().getAttribute("vCode");
		// 3.�ж���֤���Ƿ�һ��,���Դ�Сд
		boolean b = verifyCode.equalsIgnoreCase(vCode);
		// �����ͻ���
		response.getWriter().print(b);
		return null;
	}

	/**
	 * �����
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
		 * 1.��ȡ������2.����Servies�ķ��� 3.����Ϣ
		 */
		String code = request.getParameter("activationCode");
		try {
			userServies.activation(code);
			request.setAttribute("code", "success");
			request.setAttribute("msg", "��ϲ�㣬����ɹ�");
		} catch (Exception e) {
			request.setAttribute("code", "error");
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/jsps/user/regist.jsp";
	}

	/**
	 * ע�Ṧ��
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String regist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.��װ�����ݵ�User
		User formUser = CommonUtils.toBean(request.getParameterMap(),
				User.class);
		// 2.У��֮���д���Ļ�����װ��Ϣ��ת��jsp��
		// Map<String,String> errors =
		// validateRegist(formUser,request.getSession());
		// if(errors.size()>0){
		// //errors��ֵ��ִ��
		// request.setAttribute("form", formUser);
		// request.setAttribute("errors", errors);
		// return "f:/jsps/user/regist.jsp";
		// }
		// 3.ʹ��servies����ҵ��
		userServies.regist(formUser);
		// 4.ת����msg.jsp
		request.setAttribute("code", "success");
		request.setAttribute("msg", "ע��ɹ��������ϵ����伤�");
		return "f:/jsps/msg.jsp";
	}

	/**
	 * ��¼����
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
		 * 1.��������� 2.У�� 3.����servies�ķ��� 4.��userΪ�գ���ʾ��Ϣ�������ڸ��û� ���������Ϣ �������ݣ�Ϊ�˻���
		 * 5��user��Ϊ�գ���statusΪfalse����ʾ��Ϣ�����û�δ���� ���������Ϣ �������ݣ�Ϊ�˻���
		 * 6.������true���󶨵�session�Ҵ浽cookie�У�cookieע����룩 7.��תҳ��
		 */
		// 1.������Ϣ
		User formUser = CommonUtils.toBean(request.getParameterMap(),
				User.class);
		// 2.У��
		// Map<String,String> errors =
		// validateRegist(formUser,request.getSession());
		// if(errors.size()>0){
		// //errors��ֵ��ִ��
		// request.setAttribute("user", formUser);
		// request.setAttribute("errors", errors);
		// return "f:/jsps/user/login.jsp";
		// }
		// 3.����servies����Ϣ
		User user = userServies.login(formUser);
		// 4.�ж�
		if (user == null) {
			request.setAttribute("msg", "��¼�����������");
			request.setAttribute("user", formUser);
			return "f:/jsps/msg.jsp";
		} else {
			if (!user.isStatus()) {
				request.setAttribute("msg", "���û�δ����");
				request.setAttribute("user", formUser);
				return "f:/jsps/user/login.jsp";
			} else {
				// �󶨵�session��
				// request.getSession().setAttribute("sessionUser", formUser);
				request.getSession().setAttribute("sessionUser", user);
				// ����cookie
				String loginname = user.getLoginname();
				loginname = URLEncoder.encode(loginname, "utf-8");
				Cookie cookie = new Cookie("loginname", loginname);
				cookie.setMaxAge(60 * 60 * 12 * 10); // ��λ����
				response.addCookie(cookie);
				return "r:/shuyuan/index.jsp";
			}
		}
	}
	/**
	 * �����¼
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
		 * ����servies��checkOnline����
		 */
		boolean flag = userServies.checkOnline(username,usernameList);
		if(!flag){
			login(request, response);//���û��½�����õ�½����
			return "r:/shuyuan/index.jsp";
		}else{
			request.setAttribute("code", "success");//�������ѵ�½��Ϣ
			request.setAttribute("msg", "��Ǹ�����û��ѵ�½");
			return "f:/jsps/msg.jsp";
		}
		
	}
	/**
	 * �޸�����
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
		 * 1.��װ������ 2.У�� 3.����servies�ķ��� 4.
		 */
		User formUser = CommonUtils.toBean(request.getParameterMap(),
				User.class);
		User user = (User) request.getSession().getAttribute("sessionUser");
		if (user == null) {
			request.setAttribute("msg", "��û��½");
			request.setAttribute("user", formUser);
			return "f:/jsps/user/login.jsp";
		}
		try {
			userServies.updatePassWord(user.getLoginname(),
					formUser.getLoginpass(), formUser.getNewpass());
			System.out.println("uidservlet" + user.getUid());
			request.setAttribute("msg", "��ϲ���޸ĳɹ�");
			request.setAttribute("code", "success");
			return "f:/jsps/msg.jsp";
		} catch (UserException e) {
			// ���벻��ȷ�쳣������Ϣ��Ϊ�˻���
			System.out.println(formUser.getLoginpass() + "���ݿ�"
					+ user.getLoginpass());
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", formUser);
			return "f:/jsps/user/pwd.jsp";
		}
	}

	/**
	 * �˳���¼
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
	 * У��ע�� �Ա��ֶν���У�飬���д��󣬵�ǰ�ֶ�Ϊkey��������ϢΪvalue����װ��map�� ����map
	 */
	private Map<String, String> validateRegist(User formUser,
			HttpSession session) {
		Map<String, String> errors = new HashMap<String, String>();
		/*
		 * �û���У��
		 */
		String loginname = formUser.getLoginname();
		if (loginname == null || loginname.trim().length() == 0) {
			errors.put("loginname", "�û�������Ϊ��");
		} else if (loginname.length() < 3 || loginname.length() > 20) {
			errors.put("loginname", "�û������ȱ���3~20");
		} else if (!userServies.validateLoginName(loginname)) {
			errors.put("loginname", "���û���ע��");
		}
		/*
		 * ����У��
		 */
		String loginpass = formUser.getLoginpass();
		if (loginpass == null || loginpass.trim().length() == 0) {
			errors.put("loginpass", "���벻��Ϊ��");
		} else if (loginpass.length() < 3 || loginpass.length() > 20) {
			errors.put("loginpass", "���볤�ȱ���3~20");
		}
		/*
		 * ���� ����У��
		 */
		String repassword = formUser.getRepassword();
		if (repassword == null || repassword.trim().length() == 0) {
			errors.put("repassword", "���벻��Ϊ��");
		} else if (!repassword.equals(loginpass)) {
			errors.put("repassword", "�������������ͬ");
		}
		/*
		 * emailУ��
		 */
		String email = formUser.getEmail();
		if (email == null || email.trim().length() == 0) {
			errors.put("email", "���벻��Ϊ��");
		} else if (email
				.matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$")) {
			errors.put("email", "�����ʽ����");
		} else if (!userServies.validateEmail(email)) {
			errors.put("email", "�������ѱ�ע��");
		}
		/*
		 * ��֤��У��
		 */
		String verifyCode = formUser.getVerifyCode();
		String vCode = (String) session.getAttribute("vCode");
		if (verifyCode == null || verifyCode.trim().length() == 0) {
			errors.put("verifyCode", "��֤��Ϊ��");
		} else if (verifyCode.length() != 4) {
			errors.put("verifyCode", "��֤��λ��");
		} else if (!verifyCode.equalsIgnoreCase(vCode)) {
			errors.put("verifyCode", "��֤�����");
		}
		return errors;

	}

	/**
	 * ��½�����У��
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
