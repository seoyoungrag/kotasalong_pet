/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : AppDispatcherServlet.java
 * 2. Package : study.kotasalong.pet.gangwon.rest
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 8. 27. 오후 11:46:59
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.rest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.DispatcherServlet;

/** 
* @FileName      : AppDispatcherServlet.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

public class AppDispatcherServlet extends DispatcherServlet {

	private static final long serialVersionUID = -8191793258251930012L;
	
	private static final Logger logger = LoggerFactory.getLogger(AppDispatcherServlet.class);
	
	/**
	 * Controller를 초기화 한다.
	 * 
	 * @param ServletConfig
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.info("dispatcher initialize: "+config.getServletName());
		super.init(config);
	}
}
