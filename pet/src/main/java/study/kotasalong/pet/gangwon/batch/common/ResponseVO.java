/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResponseVO.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.common
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 8. 27. 오후 5:00:00
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.common;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/** 
* @FileName      : ResponseVO.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

public class ResponseVO<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 901642375284366095L;
	@SerializedName("list_total_count")
	int listTotalCount;
	@SerializedName("RESULT")
	ResultVO result;
	@SerializedName("row")
	List<T> row;
	/**
	 * @return the listTotalCount
	 */
	public int getListTotalCount() {
		return listTotalCount;
	}
	/**
	 * @param listTotalCount the listTotalCount to set
	 */
	public void setListTotalCount(int listTotalCount) {
		this.listTotalCount = listTotalCount;
	}
	/**
	 * @return the result
	 */
	public ResultVO getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(ResultVO result) {
		this.result = result;
	}
	/**
	 * @return the row
	 */
	public List<T> getRow() {
		return row;
	}
	/**
	 * @param row the row to set
	 */
	public void setRow(List<T> row) {
		this.row = row;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseVO [listTotalCount=" + listTotalCount + ", result=" + result + ", row=" + row + "]";
	}
	
}
