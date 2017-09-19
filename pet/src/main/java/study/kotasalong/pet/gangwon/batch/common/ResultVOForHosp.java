/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResultVOForHosp.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.common
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 6:54:55
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 19. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.common;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import study.kotasalong.pet.gangwon.batch.vo.ResHospInfoVO;

/** 
* @FileName      : ResultVOForHosp.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

public class ResultVOForHosp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8021651803207486681L;
	@SerializedName("item")
	List<ResHospInfoVO> item;
	/**
	 * @return the item
	 */
	public List<ResHospInfoVO> getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(List<ResHospInfoVO> item) {
		this.item = item;
	}

}
