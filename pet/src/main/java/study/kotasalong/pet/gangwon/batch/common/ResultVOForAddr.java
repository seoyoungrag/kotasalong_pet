/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResultVOForAddr.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.common
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 1:14:08
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 19. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.common;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import study.kotasalong.pet.gangwon.batch.vo.ResKTAddressClinicVO;

/** 
* @FileName      : ResultVOForAddr.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

public class ResultVOForAddr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9169716247189873095L;
	@SerializedName("fieldMap")
	ResKTAddressClinicVO fieldMap;
	/**
	 * @return the fieldMap
	 */
	public ResKTAddressClinicVO getFieldMap() {
		return fieldMap;
	}
	/**
	 * @param fieldMap the fieldMap to set
	 */
	public void setFieldMap(ResKTAddressClinicVO fieldMap) {
		this.fieldMap = fieldMap;
	}
	
}
