/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : AnimalPension.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.vo
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 24. 오후 2:20:06
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 24. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

/** 
* @FileName      : AnimalPension.java 
* @Project     : pet 
* @Date        : 2017. 9. 24. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Entity
@Table(name="animal_pension")
public class AnimalPensionVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8293531812383290418L;
	@Id
	@Column(name="NO")
	int no;
	@Column(name="bizplc_nm")
	String bizplcNm;
	@Column(name="locplc_Lotno_Addr")
	String locplcLotnoAddr;
	@Column(name="loplc_Roadnm_Addr")
	String locplcRoadnmAddr;
	@Column(name="lat")
	String lat;
	@Column(name="lng")
	String lng;
	@Column(name="telno")
	String telno;
	@Column(name="check_in")
	String checkIn;
	@Column(name="check_out")
	String checkOut;
	@Column(name="etc_info")
	String etcInfo;
	@Transient
	double distance = 0.0;
    @PrePersist
    public void ensureUuid(){
    	System.out.println("no:"+no);
    }
	/**
	 * 
	 */
	public AnimalPensionVO() {
		super();
	}
	/**
	 * @param vo
	 */
	
	public AnimalPensionVO(AnimalPensionVO vo) {
		super();
		this.no = vo.no;
		this.bizplcNm = vo.bizplcNm;
		this.locplcLotnoAddr = vo.locplcLotnoAddr;
		this.locplcRoadnmAddr = vo.locplcRoadnmAddr;
		this.lat = vo.lat;
		this.lng = vo.lng;
		this.telno = vo.telno;
		this.checkIn = vo.checkIn;
		this.checkOut = vo.checkOut;
		this.etcInfo = vo.etcInfo;
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
	 * @return the bizplcNm
	 */
	public String getBizplcNm() {
		return bizplcNm;
	}
	/**
	 * @param bizplcNm the bizplcNm to set
	 */
	public void setBizplcNm(String bizplcNm) {
		this.bizplcNm = bizplcNm;
	}
	/**
	 * @return the locplcLotnoAddr
	 */
	public String getLocplcLotnoAddr() {
		return locplcLotnoAddr;
	}
	/**
	 * @param locplcLotnoAddr the locplcLotnoAddr to set
	 */
	public void setLocplcLotnoAddr(String locplcLotnoAddr) {
		this.locplcLotnoAddr = locplcLotnoAddr;
	}
	/**
	 * @return the locplcRoadnmAddr
	 */
	public String getLocplcRoadnmAddr() {
		return locplcRoadnmAddr;
	}
	/**
	 * @param locplcRoadnmAddr the locplcRoadnmAddr to set
	 */
	public void setLocplcRoadnmAddr(String locplcRoadnmAddr) {
		this.locplcRoadnmAddr = locplcRoadnmAddr;
	}
	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}
	/**
	 * @return the lng
	 */
	public String getLng() {
		return lng;
	}
	/**
	 * @param lng the lng to set
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}
	/**
	 * @return the telno
	 */
	public String getTelno() {
		return telno;
	}
	/**
	 * @param telno the telno to set
	 */
	public void setTelno(String telno) {
		this.telno = telno;
	}
	/**
	 * @return the checkIn
	 */
	public String getCheckIn() {
		return checkIn;
	}
	/**
	 * @param checkIn the checkIn to set
	 */
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	/**
	 * @return the checkOut
	 */
	public String getCheckOut() {
		return checkOut;
	}
	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	/**
	 * @return the etcInfo
	 */
	public String getEtcInfo() {
		return etcInfo;
	}
	/**
	 * @param etcInfo the etcInfo to set
	 */
	public void setEtcInfo(String etcInfo) {
		this.etcInfo = etcInfo;
	}
	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
}
