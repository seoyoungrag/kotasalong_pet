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
public class BeachVO implements Serializable{
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
	String areacode;
	String cat1;
	String cat2;
	String cat3;
	String contentid;
	String contenttypeid;
	String createdtime;
	String mlevel;
	String modifiedtime;
	String readcount;
	String sigungucode;
	String zipcode;
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
	 * @return the areacode
	 */
	public String getAreacode() {
		return areacode;
	}
	/**
	 * @param areacode the areacode to set
	 */
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	/**
	 * @return the cat1
	 */
	public String getCat1() {
		return cat1;
	}
	/**
	 * @param cat1 the cat1 to set
	 */
	public void setCat1(String cat1) {
		this.cat1 = cat1;
	}
	/**
	 * @return the cat2
	 */
	public String getCat2() {
		return cat2;
	}
	/**
	 * @param cat2 the cat2 to set
	 */
	public void setCat2(String cat2) {
		this.cat2 = cat2;
	}
	/**
	 * @return the cat3
	 */
	public String getCat3() {
		return cat3;
	}
	/**
	 * @param cat3 the cat3 to set
	 */
	public void setCat3(String cat3) {
		this.cat3 = cat3;
	}
	/**
	 * @return the contentid
	 */
	public String getContentid() {
		return contentid;
	}
	/**
	 * @param contentid the contentid to set
	 */
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	/**
	 * @return the contenttypeid
	 */
	public String getContenttypeid() {
		return contenttypeid;
	}
	/**
	 * @param contenttypeid the contenttypeid to set
	 */
	public void setContenttypeid(String contenttypeid) {
		this.contenttypeid = contenttypeid;
	}
	/**
	 * @return the createdtime
	 */
	public String getCreatedtime() {
		return createdtime;
	}
	/**
	 * @param createdtime the createdtime to set
	 */
	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}
	/**
	 * @return the mlevel
	 */
	public String getMlevel() {
		return mlevel;
	}
	/**
	 * @param mlevel the mlevel to set
	 */
	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}
	/**
	 * @return the modifiedtime
	 */
	public String getModifiedtime() {
		return modifiedtime;
	}
	/**
	 * @param modifiedtime the modifiedtime to set
	 */
	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	/**
	 * @return the readcount
	 */
	public String getReadcount() {
		return readcount;
	}
	/**
	 * @param readcount the readcount to set
	 */
	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}
	/**
	 * @return the sigungucode
	 */
	public String getSigungucode() {
		return sigungucode;
	}
	/**
	 * @param sigungucode the sigungucode to set
	 */
	public void setSigungucode(String sigungucode) {
		this.sigungucode = sigungucode;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}
