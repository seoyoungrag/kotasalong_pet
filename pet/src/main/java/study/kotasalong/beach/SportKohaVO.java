/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : BeachOriVO.java
 * 2. Package : study.kotasalong.beach
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 10. 9. 오전 4:03:25
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 10. 9. :            : 신규 개발.
 */
package study.kotasalong.beach;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** 
* @FileName      : BeachOriVO.java 
* @Project     : pet 
* @Date        : 2017. 10. 9. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Entity
@Table(name="res_sport_koha_list")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SportKohaVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4984351936142375940L;
	@Id
	int no;
	@JsonProperty(value="PPATH")
	String ppath;
	@JsonProperty(value="LEISURE_ID")
	String leisure_id;
	@JsonProperty(value="ORIORG")
	String oriorg;
	@JsonProperty(value="XCNTS")
	String xcnts;
	@JsonProperty(value="SE")
	String se;
	@JsonProperty(value="SIGUN")
	String sigun;
	@JsonProperty(value="PHOTO_NO")
	String photo_no;
	@JsonProperty(value="FACILITIES")
	String facilities;
	@JsonProperty(value="ORIGIN")
	String origin;
	@JsonProperty(value="ATPT")
	String atpt;
	@JsonProperty(value="NM")
	String nm;
	@JsonProperty(value="ID")
	String id;
	@JsonProperty(value="ORIYR")
	String oriyr;
	@JsonProperty(value="YDNTS")
	String ydnts;
	@JsonProperty(value="ADDR")
	String addr;
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
	 * @return the ppath
	 */
	public String getPpath() {
		return ppath;
	}
	/**
	 * @param ppath the ppath to set
	 */
	public void setPpath(String ppath) {
		this.ppath = ppath;
	}
	/**
	 * @return the leisure_id
	 */
	public String getLeisure_id() {
		return leisure_id;
	}
	/**
	 * @param leisure_id the leisure_id to set
	 */
	public void setLeisure_id(String leisure_id) {
		this.leisure_id = leisure_id;
	}
	/**
	 * @return the oriorg
	 */
	public String getOriorg() {
		return oriorg;
	}
	/**
	 * @param oriorg the oriorg to set
	 */
	public void setOriorg(String oriorg) {
		this.oriorg = oriorg;
	}
	/**
	 * @return the xcnts
	 */
	public String getXcnts() {
		return xcnts;
	}
	/**
	 * @param xcnts the xcnts to set
	 */
	public void setXcnts(String xcnts) {
		this.xcnts = xcnts;
	}
	/**
	 * @return the se
	 */
	public String getSe() {
		return se;
	}
	/**
	 * @param se the se to set
	 */
	public void setSe(String se) {
		this.se = se;
	}
	/**
	 * @return the sigun
	 */
	public String getSigun() {
		return sigun;
	}
	/**
	 * @param sigun the sigun to set
	 */
	public void setSigun(String sigun) {
		this.sigun = sigun;
	}
	/**
	 * @return the photo_no
	 */
	public String getPhoto_no() {
		return photo_no;
	}
	/**
	 * @param photo_no the photo_no to set
	 */
	public void setPhoto_no(String photo_no) {
		this.photo_no = photo_no;
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
	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * @return the atpt
	 */
	public String getAtpt() {
		return atpt;
	}
	/**
	 * @param atpt the atpt to set
	 */
	public void setAtpt(String atpt) {
		this.atpt = atpt;
	}
	/**
	 * @return the nm
	 */
	public String getNm() {
		return nm;
	}
	/**
	 * @param nm the nm to set
	 */
	public void setNm(String nm) {
		this.nm = nm;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the oriyr
	 */
	public String getOriyr() {
		return oriyr;
	}
	/**
	 * @param oriyr the oriyr to set
	 */
	public void setOriyr(String oriyr) {
		this.oriyr = oriyr;
	}
	/**
	 * @return the ydnts
	 */
	public String getYdnts() {
		return ydnts;
	}
	/**
	 * @param ydnts the ydnts to set
	 */
	public void setYdnts(String ydnts) {
		this.ydnts = ydnts;
	}
	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
