/**
 * 0. Project  : ������ �� â�� ������Ʈ
 *
 * 1. FileName : ResultVO.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.common
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 5:04:23
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
 */
package study.kotasalong.pet.gangwon.batch.common;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/** 
* @FileName      : ResultVO.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
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
