/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResponseData.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.common
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 24. 오후 1:32:57
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 24. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.common;

import java.io.Serializable;

/** 
* @FileName      : ResponseData.java 
* @Project     : pet 
* @Date        : 2017. 9. 24. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

public class ResponseData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3872761351962639465L;
	int no;
	String bizplcNm;
	String locplcLotnoAddr;
	String locplcRoadnmAddr;
	String lat;
	String lng;
	String telno;
	String noTrmtHoli;
	String noTrmtSun;
	String parkEtc;
	String trmtMonEnd;
	String trmtMonStart;
	String trmtSatEnd;
	String trmtSatStart;
	double distance;
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
	 * @return the noTrmtHoli
	 */
	public String getNoTrmtHoli() {
		return noTrmtHoli;
	}
	/**
	 * @param noTrmtHoli the noTrmtHoli to set
	 */
	public void setNoTrmtHoli(String noTrmtHoli) {
		this.noTrmtHoli = noTrmtHoli;
	}
	/**
	 * @return the noTrmtSun
	 */
	public String getNoTrmtSun() {
		return noTrmtSun;
	}
	/**
	 * @param noTrmtSun the noTrmtSun to set
	 */
	public void setNoTrmtSun(String noTrmtSun) {
		this.noTrmtSun = noTrmtSun;
	}
	/**
	 * @return the parkEtc
	 */
	public String getParkEtc() {
		return parkEtc;
	}
	/**
	 * @param parkEtc the parkEtc to set
	 */
	public void setParkEtc(String parkEtc) {
		this.parkEtc = parkEtc;
	}
	/**
	 * @return the trmtMonEnd
	 */
	public String getTrmtMonEnd() {
		return trmtMonEnd;
	}
	/**
	 * @param trmtMonEnd the trmtMonEnd to set
	 */
	public void setTrmtMonEnd(String trmtMonEnd) {
		this.trmtMonEnd = trmtMonEnd;
	}
	/**
	 * @return the trmtMonStart
	 */
	public String getTrmtMonStart() {
		return trmtMonStart;
	}
	/**
	 * @param trmtMonStart the trmtMonStart to set
	 */
	public void setTrmtMonStart(String trmtMonStart) {
		this.trmtMonStart = trmtMonStart;
	}
	/**
	 * @return the trmtSatEnd
	 */
	public String getTrmtSatEnd() {
		return trmtSatEnd;
	}
	/**
	 * @param trmtSatEnd the trmtSatEnd to set
	 */
	public void setTrmtSatEnd(String trmtSatEnd) {
		this.trmtSatEnd = trmtSatEnd;
	}
	/**
	 * @return the trmtSatStart
	 */
	public String getTrmtSatStart() {
		return trmtSatStart;
	}
	/**
	 * @param trmtSatStart the trmtSatStart to set
	 */
	public void setTrmtSatStart(String trmtSatStart) {
		this.trmtSatStart = trmtSatStart;
	}
	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}
	/**
	 * @param distanceMeter the distance to set
	 */
	public void setDistance(double distanceMeter) {
		this.distance = distanceMeter;
	}
	
	
}
