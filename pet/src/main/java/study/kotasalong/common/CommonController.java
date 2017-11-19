/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : CommonController.java
 * 2. Package : study.kotasalong.common
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 10. 7. 오전 12:13:01
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 10. 7. :            : 신규 개발.
 */
package study.kotasalong.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import study.kotasalong.pet.gangwon.rest.RestResponseVO;

/** 
* @FileName      : CommonController.java 
* @Project     : pet 
* @Date        : 2017. 10. 7. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@RestController
public class CommonController {

	@RequestMapping(value = "kotasalong/pxy.do", method = RequestMethod.GET)
	public ModelAndView jqgridSubTable(
			@RequestParam(value = "url", required = true) String url) {
		ModelAndView mav = new ModelAndView("pxy");
		mav.addObject("url",url);
		return mav;
	}
	@RequestMapping(value = "kotasalong/pd.do", method = RequestMethod.GET)
	public RestResponseVO getPwd() {
		RestResponseVO result = new RestResponseVO();
		result.setData("prototype-1");
		return result;
	}
}
