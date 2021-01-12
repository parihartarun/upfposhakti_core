package com.upfpo.app.web_controller;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.upfpo.app.entity.User;
import com.upfpo.app.service.LoginService;
import com.upfpo.app.util.RandomString;

@RestController
//@RequestMapping("/UPFPO")
public class LoginController {
		
	@Autowired
	LoginService loginService;
	
	private ModelAndView mav;
	private String csrf_token = RandomString.getAlphaNumericString();
	
	@RequestMapping(value="/")
	private String home()
	{
		System.out.println("Inside home");
		return "home page";
	}
	
	@RequestMapping("/getLogin")
	public ModelAndView getLogin(HttpSession session) throws Exception {
		try {
			System.err.println("csrf_token == "+csrf_token);
			if(csrf_token!=null)
			{
			session.setAttribute("csrf_token", csrf_token);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		return mav;
	}
	
	@RequestMapping(value="/login")
	private String login(HttpSession httpSession, @Valid User user)
	{
		User detailOfUser = loginService.userDetail(user.getUserName());
		httpSession.setAttribute("username", detailOfUser.getUserName());
	
		String roleId = detailOfUser.getRoleRefId();
		String roleName = loginService.getRoleName(roleId);
		
		String seesion_token = (String) httpSession.getAttribute("csrf_token");
		System.out.println("Inside login == "+seesion_token);
		return "login page";
	}
	
	@RequestMapping("/user")
	public String user()
	{
		System.out.println("Inside login ");
		return "welcome user";
	}
	
	
//	@RequestMapping(value = "/profile")
//	public void profile(HttpSession session, Model model) {
//		String role = (String) session.getAttribute("usersrole");
//		try {
//			if (session.getAttribute("usersrole") != null && session.getAttribute("usersrole").equals("ROLE_FPC")) {
//				//session.setAttribute("csrf_token", csrf_token);
//			} else {
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
	