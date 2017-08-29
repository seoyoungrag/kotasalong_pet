/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResultVO.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.common
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 8. 27. 오후 5:04:23
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.common;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/** 
* @FileName      : ResultVO.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

public class ResultVO  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6306814023917399588L;
	@SerializedName("CODE")
	String code;
	@SerializedName("MESSAGE")
	String message;
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
