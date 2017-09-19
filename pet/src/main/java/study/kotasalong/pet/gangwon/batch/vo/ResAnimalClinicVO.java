/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : ResAnimalClinic.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.vo
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 9:09:06
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
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
import javax.persistence.Transient;

import com.google.gson.annotations.SerializedName;

/** 
* @FileName      : ResAnimalClinic.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

@Entity
@Table(name="res_animal_clinic")
public class ResAnimalClinicVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5359456381548432199L;
	@Id
	@Column(name="NO")
	@SerializedName("NO")
	private int no;
	@Column(name="BIZPLC_NM")
	@SerializedName("BIZPLC_NM")
	private String bizplcNm;
	@Column(name="LOCPLC_LOTNO_ADDR")
	@SerializedName("LOCPLC_LOTNO_ADDR")
	private String locplcLotnoAddr;
	@Column(name="LOCPLC_ROADNM_ADDR")
	@SerializedName("LOCPLC_ROADNM_ADDR")
	private String loplcRoadnmAddr;
	@Column(name="LICENSG_DE")
	@SerializedName("LICENSG_DE")
	private String licensgDe;
	@Column(name="BSN_STATE_NM")
	@SerializedName("BSN_STATE_NM")
	private String bsnStateNm;
	@Column(name="CLSBIZ_DE")
	@SerializedName("CLSBIZ_DE")
	private String clsbizDe;
	@Column(name="SUSPNBIZ_BEGIN_DE")
	@SerializedName("SUSPNBIZ_BEGIN_DE")
	private String suspnbizBeginDe;
	@Column(name="SUSPNBIZ_END_DE")
	@SerializedName("SUSPNBIZ_END_DE")
	private String suspnbizEndDe;
	@Column(name="REOPENBIZ_DE")
	@SerializedName("REOPENBIZ_DE")
	private String reopenbizDe;
	@Column(name="LOCPLC_AR")
	@SerializedName("LOCPLC_AR")
	private String locplcAr;
	@Column(name="LOCPLC_ZIP_CD")
	@SerializedName("LOCPLC_ZIP_CD")
	private String loplcZipCd;
	@Column(name="TOT_PSN_CNT")
	@SerializedName("TOT_PSN_CNT")
	private String totPsnCnt;
	@Column(name="SFRMPROD_PROCSBIZ_DIV_NM")
	@SerializedName("SFRMPROD_PROCSBIZ_DIV_NM")
	private String sfrmprodProcbizDivNm;
	@Column(name="STOCKRS_DUTY_DIV_NM")
	@SerializedName("STOCKRS_DUTY_DIV_NM")
	private String stockrsDutyDivNm;
	@Column(name="DATA_COLCT_DE")
	@SerializedName("DATA_COLCT_DE")
	private String dataColctDe;
	@Column(name="ETL_LDADNG_DTM")
	@SerializedName("ETL_LDADNG_DTM")
	private String etlLdadngDtm;
	@Column(name="LAT")
	@SerializedName("LAT")
	private String lat;
	@Column(name="LNG")
	@SerializedName("LNG")
	private String lng;
	@Column(name="INSERT_DT")
    @Temporal(TemporalType.TIMESTAMP)
	private Date insertDt;
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DT")
    private Date updateDt;
    @Transient
    private ResHospInfoVO hospInfo;
    @Transient
    private ResHospDetailVO hospDetail;
    @Transient
    private ResKTAddressClinicVO ktInfo;
	/**
	 * @return the hospInfo
	 */
	public ResHospInfoVO getHospInfo() {
		return hospInfo;
	}
	/**
	 * @param hospInfo the hospInfo to set
	 */
	public void setHospInfo(ResHospInfoVO hospInfo) {
		this.hospInfo = hospInfo;
	}
	/**
	 * @return the hospDetail
	 */
	public ResHospDetailVO getHospDetail() {
		return hospDetail;
	}
	/**
	 * @param hospDetail the hospDetail to set
	 */
	public void setHospDetail(ResHospDetailVO hospDetail) {
		this.hospDetail = hospDetail;
	}
	/**
	 * @return the ktInfo
	 */
	public ResKTAddressClinicVO getKtInfo() {
		return ktInfo;
	}
	/**
	 * @param ktInfo the ktInfo to set
	 */
	public void setKtInfo(ResKTAddressClinicVO ktInfo) {
		this.ktInfo = ktInfo;
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
	 * @return the loplcRoadnmAddr
	 */
	public String getLoplcRoadnmAddr() {
		return loplcRoadnmAddr;
	}
	/**
	 * @param loplcRoadnmAddr the loplcRoadnmAddr to set
	 */
	public void setLoplcRoadnmAddr(String loplcRoadnmAddr) {
		this.loplcRoadnmAddr = loplcRoadnmAddr;
	}
	/**
	 * @return the licensgDe
	 */
	public String getLicensgDe() {
		return licensgDe;
	}
	/**
	 * @param licensgDe the licensgDe to set
	 */
	public void setLicensgDe(String licensgDe) {
		this.licensgDe = licensgDe;
	}
	/**
	 * @return the bsnStateNm
	 */
	public String getBsnStateNm() {
		return bsnStateNm;
	}
	/**
	 * @param bsnStateNm the bsnStateNm to set
	 */
	public void setBsnStateNm(String bsnStateNm) {
		this.bsnStateNm = bsnStateNm;
	}
	/**
	 * @return the clsbizDe
	 */
	public String getClsbizDe() {
		return clsbizDe;
	}
	/**
	 * @param clsbizDe the clsbizDe to set
	 */
	public void setClsbizDe(String clsbizDe) {
		this.clsbizDe = clsbizDe;
	}
	/**
	 * @return the suspnbizBeginDe
	 */
	public String getSuspnbizBeginDe() {
		return suspnbizBeginDe;
	}
	/**
	 * @param suspnbizBeginDe the suspnbizBeginDe to set
	 */
	public void setSuspnbizBeginDe(String suspnbizBeginDe) {
		this.suspnbizBeginDe = suspnbizBeginDe;
	}
	/**
	 * @return the suspnbizEndDe
	 */
	public String getSuspnbizEndDe() {
		return suspnbizEndDe;
	}
	/**
	 * @param suspnbizEndDe the suspnbizEndDe to set
	 */
	public void setSuspnbizEndDe(String suspnbizEndDe) {
		this.suspnbizEndDe = suspnbizEndDe;
	}
	/**
	 * @return the reopenbizDe
	 */
	public String getReopenbizDe() {
		return reopenbizDe;
	}
	/**
	 * @param reopenbizDe the reopenbizDe to set
	 */
	public void setReopenbizDe(String reopenbizDe) {
		this.reopenbizDe = reopenbizDe;
	}
	/**
	 * @return the locplcAr
	 */
	public String getLocplcAr() {
		return locplcAr;
	}
	/**
	 * @param locplcAr the locplcAr to set
	 */
	public void setLocplcAr(String locplcAr) {
		this.locplcAr = locplcAr;
	}
	/**
	 * @return the loplcZipCd
	 */
	public String getLoplcZipCd() {
		return loplcZipCd;
	}
	/**
	 * @param loplcZipCd the loplcZipCd to set
	 */
	public void setLoplcZipCd(String loplcZipCd) {
		this.loplcZipCd = loplcZipCd;
	}
	/**
	 * @return the totPsnCnt
	 */
	public String getTotPsnCnt() {
		return totPsnCnt;
	}
	/**
	 * @param totPsnCnt the totPsnCnt to set
	 */
	public void setTotPsnCnt(String totPsnCnt) {
		this.totPsnCnt = totPsnCnt;
	}
	/**
	 * @return the sfrmprodProcbizDivNm
	 */
	public String getSfrmprodProcbizDivNm() {
		return sfrmprodProcbizDivNm;
	}
	/**
	 * @param sfrmprodProcbizDivNm the sfrmprodProcbizDivNm to set
	 */
	public void setSfrmprodProcbizDivNm(String sfrmprodProcbizDivNm) {
		this.sfrmprodProcbizDivNm = sfrmprodProcbizDivNm;
	}
	/**
	 * @return the stockrsDutyDivNm
	 */
	public String getStockrsDutyDivNm() {
		return stockrsDutyDivNm;
	}
	/**
	 * @param stockrsDutyDivNm the stockrsDutyDivNm to set
	 */
	public void setStockrsDutyDivNm(String stockrsDutyDivNm) {
		this.stockrsDutyDivNm = stockrsDutyDivNm;
	}
	/**
	 * @return the dataColctDe
	 */
	public String getDataColctDe() {
		return dataColctDe;
	}
	/**
	 * @param dataColctDe the dataColctDe to set
	 */
	public void setDataColctDe(String dataColctDe) {
		this.dataColctDe = dataColctDe;
	}
	/**
	 * @return the etlLdadngDtm
	 */
	public String getEtlLdadngDtm() {
		return etlLdadngDtm;
	}
	/**
	 * @param etlLdadngDtm the etlLdadngDtm to set
	 */
	public void setEtlLdadngDtm(String etlLdadngDtm) {
		this.etlLdadngDtm = etlLdadngDtm;
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
	 * @return the inserDt
	 */
	public Date getInsertDt() {
		return insertDt;
	}
	/**
	 * @param inserDt the inserDt to set
	 */
	public void setInsertDt(Date insertDt) {
		this.insertDt = insertDt;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResAnimalClinicVO [no=" + no + ", bizplcNm=" + bizplcNm + ", locplcLotnoAddr=" + locplcLotnoAddr
				+ ", loplcRoadnmAddr=" + loplcRoadnmAddr + ", licensgDe=" + licensgDe + ", bsnStateNm=" + bsnStateNm
				+ ", clsbizDe=" + clsbizDe + ", suspnbizBeginDe=" + suspnbizBeginDe + ", suspnbizEndDe=" + suspnbizEndDe
				+ ", reopenbizDe=" + reopenbizDe + ", locplcAr=" + locplcAr + ", loplcZipCd=" + loplcZipCd
				+ ", totPsnCnt=" + totPsnCnt + ", sfrmprodProcbizDivNm=" + sfrmprodProcbizDivNm + ", stockrsDutyDivNm="
				+ stockrsDutyDivNm + ", dataColctDe=" + dataColctDe + ", etlLdadngDtm=" + etlLdadngDtm + ", lat=" + lat
				+ ", lng=" + lng + ", insertDt=" + insertDt + ", updateDt=" + updateDt + ", getNo()=" + getNo()
				+ ", getBizplcNm()=" + getBizplcNm() + ", getLocplcLotnoAddr()=" + getLocplcLotnoAddr()
				+ ", getLoplcRoadnmAddr()=" + getLoplcRoadnmAddr() + ", getLicensgDe()=" + getLicensgDe()
				+ ", getBsnStateNm()=" + getBsnStateNm() + ", getClsbizDe()=" + getClsbizDe()
				+ ", getSuspnbizBeginDe()=" + getSuspnbizBeginDe() + ", getSuspnbizEndDe()=" + getSuspnbizEndDe()
				+ ", getReopenbizDe()=" + getReopenbizDe() + ", getLocplcAr()=" + getLocplcAr() + ", getLoplcZipCd()="
				+ getLoplcZipCd() + ", getTotPsnCnt()=" + getTotPsnCnt() + ", getSfrmprodProcbizDivNm()="
				+ getSfrmprodProcbizDivNm() + ", getStockrsDutyDivNm()=" + getStockrsDutyDivNm() + ", getDataColctDe()="
				+ getDataColctDe() + ", getEtlLdadngDtm()=" + getEtlLdadngDtm() + ", getLat()=" + getLat()
				+ ", getLng()=" + getLng() + ", getInsertDt()=" + getInsertDt() + ", getUpdateDt()=" + getUpdateDt()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
