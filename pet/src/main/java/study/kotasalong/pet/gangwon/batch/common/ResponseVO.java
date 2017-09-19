/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : ResponseVO.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.common
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 5:00:00
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
 */
package study.kotasalong.pet.gangwon.batch.common;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/** 
* @FileName      : ResponseVO.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
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
