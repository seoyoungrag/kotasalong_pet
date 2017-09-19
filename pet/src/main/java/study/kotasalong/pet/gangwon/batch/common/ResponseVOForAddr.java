/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResponseVOForAddr.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.common
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 1:11:20
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 19. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.common;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/** 
* @FileName      : ResponseVOForAddr.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

public class ResponseVOForAddr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7008258942323103121L;
	@SerializedName("result")
	List<ResultVOForAddr> result;
	/**
	 * @return the result
	 */
	public List<ResultVOForAddr> getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(List<ResultVOForAddr> result) {
		this.result = result;
	}
	

}
