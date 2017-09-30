/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : ResAnimalPharmacyVO.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.vo
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 3:55:10
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
* @FileName      : ResAnimalPharmacyVO.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

@Entity
@Table(name="res_animal_pharmacy")
public class ResAnimalPharmacyVO  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3950956483138873405L;
	@Id
	@Column(name="NO")
	@SerializedName("NO")
	private int no;
	@SerializedName("SIGUN_CD")
	@Column(name="SIGUN_CD")
	private String sigunCd;
	@Column(name="SIGUN_NM")
	@SerializedName("SIGUN_NM")
	private String sigunNm;
	@Column(name="BIZPLC_NM")
	@SerializedName("BIZPLC_NM")
	private String bizplcNm;
	@Column(name="LOCPLC_LOTNO_ADDR")
	@SerializedName("LOCPLC_LOTNO_ADDR")
	private String locplcLotnoAddr;
	@Column(name="LOCPLC_ROADNM_ADDR")
	@SerializedName("LOCPLC_ROADNM_ADDR")
	private String locplcRoadnmAddr;
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
	private String locplcZipCd;
	@Column(name="TOT_EMPLY_CNT")
	@SerializedName("TOT_EMPLY_CNT")
	private String totEmplyCnt;
	@Column(name="SFRMPROD_PROCSBIZ_DIV_NM")
	@SerializedName("SFRMPROD_PROCSBIZ_DIV_NM")
	private String sfrmprodProcsbizDivNm;
	@Column(name="STOCKRS_DUTY_DIV_NM")
	@SerializedName("STOCKRS_DUTY_DIV_NM")
	private String stockrsDutyDivNm;
	@Column(name="WGS84_LOGT")
	@SerializedName("WGS84_LOGT")
	private String wsg84Logt;
	@Column(name="WGS84_LAT")
	@SerializedName("WGS84_LAT")
	private String wsg84Lat;
	@Column(name="X_CRDNT")
	@SerializedName("X_CRDNT")
	private String xCrdnt;
	@Column(name="Y_CRDNT")
	@SerializedName("Y_CRDNT")
	private String yCrdnt;
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
    private ResPharmInfoVO pharmInfo;
    @Transient
    private ResPharmDetailVO pharmDetail;
    @Transient
    private ResKTAddressPharmVO ktInfo;
    
	/**
	 * 
	 */
	public ResAnimalPharmacyVO() {
		super();
	}
	/**
	 * @param vo
	 */
	public ResAnimalPharmacyVO(ResAnimalPharmacyEditedVO vo) {
		super();
		this.no = vo.no;
		this.bizplcNm = vo.bizplcNm;
		this.locplcLotnoAddr = vo.locplcLotnoAddr;
		this.locplcRoadnmAddr = vo.locplcRoadnmAddr;
		this.lat = vo.lat;
		this.lng = vo.lng;
	}
	/**
	 * @return the pharmInfo
	 */
	public ResPharmInfoVO getPharmInfo() {
		return pharmInfo;
	}
	/**
	 * @param pharmInfo the pharmInfo to set
	 */
	public void setPharmInfo(ResPharmInfoVO pharmInfo) {
		this.pharmInfo = pharmInfo;
	}
	/**
	 * @return the pharmDetail
	 */
	public ResPharmDetailVO getPharmDetail() {
		return pharmDetail;
	}
	/**
	 * @param pharmDetail the pharmDetail to set
	 */
	public void setPharmDetail(ResPharmDetailVO pharmDetail) {
		this.pharmDetail = pharmDetail;
	}
	/**
	 * @return the ktInfo
	 */
	public ResKTAddressPharmVO getKtInfo() {
		return ktInfo;
	}
	/**
	 * @param ktInfo the ktInfo to set
	 */
	public void setKtInfo(ResKTAddressPharmVO ktInfo) {
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
	 * @return the sigunCd
	 */
	public String getSigunCd() {
		return sigunCd;
	}
	/**
	 * @param sigunCd the sigunCd to set
	 */
	public void setSigunCd(String sigunCd) {
		this.sigunCd = sigunCd;
	}
	/**
	 * @return the sigunNm
	 */
	public String getSigunNm() {
		return sigunNm;
	}
	/**
	 * @param sigunNm the sigunNm to set
	 */
	public void setSigunNm(String sigunNm) {
		this.sigunNm = sigunNm;
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
	 * @return the locplcZipCd
	 */
	public String getLocplcZipCd() {
		return locplcZipCd;
	}
	/**
	 * @param locplcZipCd the locplcZipCd to set
	 */
	public void setLocplcZipCd(String locplcZipCd) {
		this.locplcZipCd = locplcZipCd;
	}
	/**
	 * @return the totEmplyCnt
	 */
	public String getTotEmplyCnt() {
		return totEmplyCnt;
	}
	/**
	 * @param totEmplyCnt the totEmplyCnt to set
	 */
	public void setTotEmplyCnt(String totEmplyCnt) {
		this.totEmplyCnt = totEmplyCnt;
	}
	/**
	 * @return the sfrmprodProcsbizDivNm
	 */
	public String getSfrmprodProcsbizDivNm() {
		return sfrmprodProcsbizDivNm;
	}
	/**
	 * @param sfrmprodProcsbizDivNm the sfrmprodProcsbizDivNm to set
	 */
	public void setSfrmprodProcsbizDivNm(String sfrmprodProcsbizDivNm) {
		this.sfrmprodProcsbizDivNm = sfrmprodProcsbizDivNm;
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
	 * @return the wsg84Logt
	 */
	public String getWsg84Logt() {
		return wsg84Logt;
	}
	/**
	 * @param wsg84Logt the wsg84Logt to set
	 */
	public void setWsg84Logt(String wsg84Logt) {
		this.wsg84Logt = wsg84Logt;
	}
	/**
	 * @return the wsg84Lat
	 */
	public String getWsg84Lat() {
		return wsg84Lat;
	}
	/**
	 * @param wsg84Lat the wsg84Lat to set
	 */
	public void setWsg84Lat(String wsg84Lat) {
		this.wsg84Lat = wsg84Lat;
	}
	/**
	 * @return the xCrdnt
	 */
	public String getxCrdnt() {
		return xCrdnt;
	}
	/**
	 * @param xCrdnt the xCrdnt to set
	 */
	public void setxCrdnt(String xCrdnt) {
		this.xCrdnt = xCrdnt;
	}
	/**
	 * @return the yCrdnt
	 */
	public String getyCrdnt() {
		return yCrdnt;
	}
	/**
	 * @param yCrdnt the yCrdnt to set
	 */
	public void setyCrdnt(String yCrdnt) {
		this.yCrdnt = yCrdnt;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResAnimalPharmacyVO [no=" + no + ", sigunCd=" + sigunCd + ", sigunNm=" + sigunNm + ", bizplcNm="
				+ bizplcNm + ", locplcLotnoAddr=" + locplcLotnoAddr + ", locplcRoadnmAddr=" + locplcRoadnmAddr
				+ ", licensgDe=" + licensgDe + ", bsnStateNm=" + bsnStateNm + ", clsbizDe=" + clsbizDe
				+ ", suspnbizBeginDe=" + suspnbizBeginDe + ", suspnbizEndDe=" + suspnbizEndDe + ", reopenbizDe="
				+ reopenbizDe + ", locplcAr=" + locplcAr + ", locplcZipCd=" + locplcZipCd + ", totEmplyCnt="
				+ totEmplyCnt + ", sfrmprodProcsbizDivNm=" + sfrmprodProcsbizDivNm + ", stockrsDutyDivNm="
				+ stockrsDutyDivNm + ", wsg84Logt=" + wsg84Logt + ", wsg84Lat=" + wsg84Lat + ", xCrdnt=" + xCrdnt
				+ ", yCrdnt=" + yCrdnt + ", dataColctDe=" + dataColctDe + ", etlLdadngDtm=" + etlLdadngDtm + ", lat="
				+ lat + ", lng=" + lng + ", insertDt=" + insertDt + ", updateDt=" + updateDt + "]";
	}
	
}
