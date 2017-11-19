/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : AppDispatcherServlet.java
 * 2. Package : study.kotasalong.pet.gangwon.rest
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 11:46:59
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
 */
package study.kotasalong.rest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.DispatcherServlet;

/** 
* @FileName      : AppDispatcherServlet.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

public class AppDispatcherServlet extends DispatcherServlet {

	private static final long serialVersionUID = -8191793258251930012L;
	
	private static final Logger logger = LoggerFactory.getLogger(AppDispatcherServlet.class);
	
	/**
	 * Controller�� �ʱ�ȭ �Ѵ�.
	 * 
	 * @param ServletConfig
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.info("dispatcher initialize: "+config.getServletName());
		super.init(config);
	}
}
