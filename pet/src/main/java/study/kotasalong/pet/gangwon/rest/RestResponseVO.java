/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : RestResponseVO.java
 * 2. Package : study.kotasalong.pet.gangwon.rest
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 8. 28. 오전 10:27:54
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 28. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.rest;

import java.util.Calendar;
import java.util.Date;

/** 
* @FileName      : RestResponseVO.java 
* @Project     : pet 
* @Date        : 2017. 8. 28. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

public class RestResponseVO {

	public static final String R_MSG_EMPTY = "";
	public static final String R_MSG_SUCCESS = "success";
	public static final String R_MSG_FAIL = "fail";
	public static final String R_CODE_SUCCESS = "1";
	public static final String R_CODE_FAIL = "0";

	private final String responseCode;
	private final Date execDt;
	private final String message;

	private Object data;

	public RestResponseVO() {
		this.execDt = Calendar.getInstance().getTime();
		this.message = RestResponseVO.R_MSG_EMPTY;
		this.responseCode = RestResponseVO.R_CODE_SUCCESS;
		this.data = null;
	}

	/**
	 * A Creates a new instance of Response
	 *
	 * @param code
	 * @param message
	 * @param execDt
	 */
	public RestResponseVO(final String code, final String message, final Date execDt) {

		this.execDt = execDt == null ? Calendar.getInstance().getTime() : execDt;
		this.message = message == null ? RestResponseVO.R_MSG_EMPTY : message;
		this.responseCode = code == null ? RestResponseVO.R_CODE_SUCCESS : code;
		this.data = null;
	}

	/**
	 * @return the execDt
	 */
	public Date getExecDt() {

		return this.execDt;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {

		return this.message;
	}

	/**
	 * @return the response
	 */
	public Object getData() {

		return this.data;
	}

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {

		return this.responseCode;
	}

	/**
	 * sets the response object
	 *
	 * @param obj
	 * @return
	 */
	public RestResponseVO setData(final Object obj) {

		this.data = obj;
		return this;
	}
}
