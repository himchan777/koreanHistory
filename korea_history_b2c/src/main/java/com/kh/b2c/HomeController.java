package com.kh.b2c;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.b2c.DAO.UserDAO;
import com.kh.b2c.VO.UserVO;
import com.kh.b2c.db.UserInfoService;


/**
 * Handles requests for the application home page.
 */
@Controller
@ContextConfiguration
(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class HomeController {
	// 루트컨테이너에서 빈(Bean)을 받아와서 자동으로 넣어줌
	@Inject
	private DataSource dataSource;
	// 루트컨테이너에서 빈(Bean)을 받아와서 자동으로 넣어줌
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Autowired
	public ApplicationContext ctx;
	
	// 루트 컨테이너에서 DAO 객체를 가져와 저장
	@Resource(name = "userDAO")
	private UserDAO dao;
	
	@Autowired
	public UserInfoService userInfoService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	@Transactional
	public String board() {
		try {
			userInfoService.selectOne("test1");
			System.out.println("성공");
		} catch (Exception ex){
			System.out.println("실패..!");
			ex.printStackTrace();
		}
		
		return "board";
	}
	
}
