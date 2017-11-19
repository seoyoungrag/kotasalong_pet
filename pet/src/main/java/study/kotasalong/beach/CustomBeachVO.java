/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : BeachVO.java
 * 2. Package : study.kotasalong.beach
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 10. 5. 오후 8:55:55
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 10. 5. :            : 신규 개발.
 */
package study.kotasalong.beach;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/** 
* @FileName      : BeachVO.java 
* @Project     : pet 
* @Date        : 2017. 10. 5. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Entity
@Table(name="res_beach_area_based_list")
public class CustomBeachVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2444069655494725606L;
	@Id
	int no;
	String title;
	String mapx;
	String mapy;
	String addr1;
	String addr2;
	String firstimage;
	String firstimage2;
	String facilities;
    @PrePersist
    public void ensureUuid(){
    	//System.out.println("no:"+no);
    }
	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the mapx
	 */
	public String getMapx() {
		return mapx;
	}
	/**
	 * @param mapx the mapx to set
	 */
	public void setMapx(String mapx) {
		this.mapx = mapx;
	}
	/**
	 * @return the mapy
	 */
	public String getMapy() {
		return mapy;
	}
	/**
	 * @param mapy the mapy to set
	 */
	public void setMapy(String mapy) {
		this.mapy = mapy;
	}
	/**
	 * @return the addr1
	 */
	public String getAddr1() {
		return addr1;
	}
	/**
	 * @param addr1 the addr1 to set
	 */
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	/**
	 * @return the addr2
	 */
	public String getAddr2() {
		return addr2;
	}
	/**
	 * @param addr2 the addr2 to set
	 */
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	/**
	 * @return the firstimage
	 */
	public String getFirstimage() {
		return firstimage;
	}
	/**
	 * @param firstimage the firstimage to set
	 */
	public void setFirstimage(String firstimage) {
		this.firstimage = firstimage;
	}
	/**
	 * @return the firstimage2
	 */
	public String getFirstimage2() {
		return firstimage2;
	}
	/**
	 * @param firstimage2 the firstimage2 to set
	 */
	public void setFirstimage2(String firstimage2) {
		this.firstimage2 = firstimage2;
	}
	/**
	 * @return the facilities
	 */
	public String getFacilities() {
		return facilities;
	}
	/**
	 * @param facilities the facilities to set
	 */
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	
}
