/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : KTAdressVO.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.vo
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 12:16:04
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.SerializedName;

/** 
* @FileName      : KTAdressVO.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Entity
@Table(name="res_kt_address_info_clinic")
public class ResKTAddressClinicVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3717407048842078670L;
	@Id
	@Column(name="NO")
	private int no;
	@Column(name="main_num")
	@SerializedName("main_num")
	private String mainNum;
	@Column(name="addr_road_nm")
	@SerializedName("addr_road_nm")
	private String addrRoadNm;
	@Column(name="up_nm")
	@SerializedName("up_nm")
	private String upNm;
	@Column(name="addr_nm")
	@SerializedName("addr_nm")
	private String addrNm;
	@Column(name="pub_nm")
	@SerializedName("pub_nm")
	private String pubNm;
	@Column(name="CLNIC_KT_ADDRESS_INSERT_DT")
    @Temporal(TemporalType.TIMESTAMP)
	private Date insertDt;
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="CLNIC_KT_ADDRESS_UPDATE_DT")
    private Date updateDt;
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
	 * @return the mainNum
	 */
	public String getMainNum() {
		return mainNum;
	}
	/**
	 * @param mainNum the mainNum to set
	 */
	public void setMainNum(String mainNum) {
		this.mainNum = mainNum;
	}
	/**
	 * @return the addrRoadNm
	 */
	public String getAddrRoadNm() {
		return addrRoadNm;
	}
	/**
	 * @param addrRoadNm the addrRoadNm to set
	 */
	public void setAddrRoadNm(String addrRoadNm) {
		this.addrRoadNm = addrRoadNm;
	}
	/**
	 * @return the upNm
	 */
	public String getUpNm() {
		return upNm;
	}
	/**
	 * @param upNm the upNm to set
	 */
	public void setUpNm(String upNm) {
		this.upNm = upNm;
	}
	/**
	 * @return the addrNm
	 */
	public String getAddrNm() {
		return addrNm;
	}
	/**
	 * @param addrNm the addrNm to set
	 */
	public void setAddrNm(String addrNm) {
		this.addrNm = addrNm;
	}
	/**
	 * @return the pubNm
	 */
	public String getPubNm() {
		return pubNm;
	}
	/**
	 * @param pubNm the pubNm to set
	 */
	public void setPubNm(String pubNm) {
		this.pubNm = pubNm;
	}
	/**
	 * @return the insertDt
	 */
	public Date getInsertDt() {
		return insertDt;
	}
	/**
	 * @param insertDt the insertDt to set
	 */
	public void setInsertDt(Date insertDt) {
		this.insertDt = insertDt;
	}
	/**
	 * @return the updateDt
	 */
	public Date getUpdateDt() {
		return updateDt;
	}
	/**
	 * @param updateDt the updateDt to set
	 */
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "KTAdressVO [no=" + no + ", mainNum=" + mainNum + ", addrRoadNm=" + addrRoadNm + ", upNm=" + upNm
				+ ", addrNm=" + addrNm + ", pubNm=" + pubNm + ", insertDt=" + insertDt + ", updateDt=" + updateDt + "]";
	}
	
}
