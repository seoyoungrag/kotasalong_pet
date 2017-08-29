/**
 * 0. Project  : ������ �� â�� ������Ʈ
 *
 * 1. FileName : RestResponseVO.java
 * 2. Package : study.kotasalong.pet.gangwon.rest
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 28. ���� 10:27:54
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 28. :            : �ű� ����.
 */
package study.kotasalong.pet.gangwon.rest;

import java.util.Calendar;
import java.util.Date;

/** 
* @FileName      : RestResponseVO.java 
* @Project     : pet 
* @Date        : 2017. 8. 28. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
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
