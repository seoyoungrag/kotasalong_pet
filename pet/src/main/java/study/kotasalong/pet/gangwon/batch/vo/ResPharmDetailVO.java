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
@Table(name="res_pharminfo_detail")
public class ResPharmDetailVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3717407048842078670L;
	@Id
	@Column(name="NO")
	private int no;
	@Column(name="lunchSat")
	@SerializedName("lunchSat")
	private String lunchSat;
	@Column(name="lunchWeek")
	@SerializedName("lunchWeek")
	private String lunchWeek;
	@Column(name="noTrmtHoli")
	@SerializedName("noTrmtHoli")
	private String noTrmtHoli;
	@Column(name="noTrmtSun")
	@SerializedName("noTrmtSun")
	private String noTrmtSun;
	@Column(name="parkEtc")
	@SerializedName("parkEtc")
	private String parkEtc;
	@Column(name="plcDir")
	@SerializedName("plcDir")
	private String plcDir;
	@Column(name="plcNm")
	@SerializedName("plcNm")
	private String plcNm;
	@Column(name="rcvSat")
	@SerializedName("rcvSat")
	private String rcvSat;
	@Column(name="rcvWeek")
	@SerializedName("rcvWeek")
	private String rcvWeek;
	@Column(name="trmtFriEnd")
	@SerializedName("trmtFriEnd")
	private String trmtFriEnd;
	@Column(name="trmtFriStart")
	@SerializedName("trmtFriStart")
	private String trmtFriStart;
	@Column(name="trmtMonEnd")
	@SerializedName("trmtMonEnd")
	private String trmtMonEnd;
	@Column(name="trmtMonStart")
	@SerializedName("trmtMonStart")
	private String trmtMonStart;
	@Column(name="trmtSatEnd")
	@SerializedName("trmtSatEnd")
	private String trmtSatEnd;
	@Column(name="trmtSatStart")
	@SerializedName("trmtSatStart")
	private String trmtSatStart;
	@Column(name="trmtThuEnd")
	@SerializedName("trmtThuEnd")
	private String trmtThuEnd;
	@Column(name="trmtThuStart")
	@SerializedName("trmtThuStart")
	private String trmtThuStart;
	@Column(name="trmtTueEnd")
	@SerializedName("trmtTueEnd")
	private String trmtTueEnd;
	@Column(name="trmtTueStart")
	@SerializedName("trmtTueStart")
	private String trmtTueStart;
	@Column(name="trmtWedEnd")
	@SerializedName("trmtWedEnd")
	private String trmtWedEnd;
	@Column(name="trmtWedStart")
	@SerializedName("trmtWedStart")
	private String trmtWedStart;
	@Column(name="Pharm_Detail_INSERT_DT")
    @Temporal(TemporalType.TIMESTAMP)
	private Date insertDt;
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="Pharm_Detail_UPDATE_DT")
    private Date updateDt;
    
	/**
	 * 
	 */
	public ResPharmDetailVO() {
		super();
	}

	/**
	 * @param no
	 * @param lunchSat
	 * @param lunchWeek
	 * @param noTrmtHoli
	 * @param noTrmtSun
	 * @param parkEtc
	 * @param plcDir
	 * @param plcNm
	 * @param rcvSat
	 * @param rcvWeek
	 * @param trmtFriEnd
	 * @param trmtFriStart
	 * @param trmtMonEnd
	 * @param trmtMonStart
	 * @param trmtSatEnd
	 * @param trmtSatStart
	 * @param trmtThuEnd
	 * @param trmtThuStart
	 * @param trmtTueEnd
	 * @param trmtTueStart
	 * @param trmtWedEnd
	 * @param trmtWedStart
	 * @param insertDt
	 * @param updateDt
	 */
	public ResPharmDetailVO(int no, String lunchSat, String lunchWeek, String noTrmtHoli, String noTrmtSun,
			String parkEtc, String plcDir, String plcNm, String rcvSat, String rcvWeek, String trmtFriEnd,
			String trmtFriStart, String trmtMonEnd, String trmtMonStart, String trmtSatEnd, String trmtSatStart,
			String trmtThuEnd, String trmtThuStart, String trmtTueEnd, String trmtTueStart, String trmtWedEnd,
			String trmtWedStart, Date insertDt, Date updateDt) {
		super();
		this.no = no;
		this.lunchSat = lunchSat;
		this.lunchWeek = lunchWeek;
		this.noTrmtHoli = noTrmtHoli;
		this.noTrmtSun = noTrmtSun;
		this.parkEtc = parkEtc;
		this.plcDir = plcDir;
		this.plcNm = plcNm;
		this.rcvSat = rcvSat;
		this.rcvWeek = rcvWeek;
		this.trmtFriEnd = trmtFriEnd;
		this.trmtFriStart = trmtFriStart;
		this.trmtMonEnd = trmtMonEnd;
		this.trmtMonStart = trmtMonStart;
		this.trmtSatEnd = trmtSatEnd;
		this.trmtSatStart = trmtSatStart;
		this.trmtThuEnd = trmtThuEnd;
		this.trmtThuStart = trmtThuStart;
		this.trmtTueEnd = trmtTueEnd;
		this.trmtTueStart = trmtTueStart;
		this.trmtWedEnd = trmtWedEnd;
		this.trmtWedStart = trmtWedStart;
		this.insertDt = insertDt;
		this.updateDt = updateDt;
	}

	public ResPharmDetailVO(ResHospDetailVO vo) {
		super();
		this.no = vo.getNo();
		this.lunchSat = vo.getLunchSat();
		this.lunchWeek = vo.getLunchWeek();
		this.noTrmtHoli = vo.getNoTrmtHoli();
		this.noTrmtSun = vo.getNoTrmtSun();
		this.parkEtc = vo.getParkEtc();
		this.plcDir = vo.getPlcDir();
		this.plcNm = vo.getPlcNm();
		this.rcvSat = vo.getRcvSat();
		this.rcvWeek = vo.getRcvWeek();
		this.trmtFriEnd = vo.getTrmtFriEnd();
		this.trmtFriStart = vo.getTrmtFriStart();
		this.trmtMonEnd = vo.getTrmtMonEnd();
		this.trmtMonStart = vo.getTrmtMonStart();
		this.trmtSatEnd = vo.getTrmtSatEnd();
		this.trmtSatStart = vo.getTrmtSatStart();
		this.trmtThuEnd = vo.getTrmtThuEnd();
		this.trmtThuStart = vo.getTrmtThuStart();
		this.trmtTueEnd = vo.getTrmtTueEnd();
		this.trmtTueStart = vo.getTrmtTueStart();
		this.trmtWedEnd = vo.getTrmtWedEnd();
		this.trmtWedStart = vo.getTrmtWedStart();
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
	 * @return the lunchSat
	 */
	public String getLunchSat() {
		return lunchSat;
	}
	/**
	 * @param lunchSat the lunchSat to set
	 */
	public void setLunchSat(String lunchSat) {
		this.lunchSat = lunchSat;
	}
	/**
	 * @return the lunchWeek
	 */
	public String getLunchWeek() {
		return lunchWeek;
	}
	/**
	 * @param lunchWeek the lunchWeek to set
	 */
	public void setLunchWeek(String lunchWeek) {
		this.lunchWeek = lunchWeek;
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
	 * @return the plcDir
	 */
	public String getPlcDir() {
		return plcDir;
	}
	/**
	 * @param plcDir the plcDir to set
	 */
	public void setPlcDir(String plcDir) {
		this.plcDir = plcDir;
	}
	/**
	 * @return the plcNm
	 */
	public String getPlcNm() {
		return plcNm;
	}
	/**
	 * @param plcNm the plcNm to set
	 */
	public void setPlcNm(String plcNm) {
		this.plcNm = plcNm;
	}
	/**
	 * @return the rcvSat
	 */
	public String getRcvSat() {
		return rcvSat;
	}
	/**
	 * @param rcvSat the rcvSat to set
	 */
	public void setRcvSat(String rcvSat) {
		this.rcvSat = rcvSat;
	}
	/**
	 * @return the rcvWeek
	 */
	public String getRcvWeek() {
		return rcvWeek;
	}
	/**
	 * @param rcvWeek the rcvWeek to set
	 */
	public void setRcvWeek(String rcvWeek) {
		this.rcvWeek = rcvWeek;
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
	 * @return the trmtFriEnd
	 */
	public String getTrmtFriEnd() {
		return trmtFriEnd;
	}
	/**
	 * @param trmtFriEnd the trmtFriEnd to set
	 */
	public void setTrmtFriEnd(String trmtFriEnd) {
		this.trmtFriEnd = trmtFriEnd;
	}
	/**
	 * @return the trmtFriStart
	 */
	public String getTrmtFriStart() {
		return trmtFriStart;
	}
	/**
	 * @param trmtFriStart the trmtFriStart to set
	 */
	public void setTrmtFriStart(String trmtFriStart) {
		this.trmtFriStart = trmtFriStart;
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
	 * @return the trmtThuEnd
	 */
	public String getTrmtThuEnd() {
		return trmtThuEnd;
	}
	/**
	 * @param trmtThuEnd the trmtThuEnd to set
	 */
	public void setTrmtThuEnd(String trmtThuEnd) {
		this.trmtThuEnd = trmtThuEnd;
	}
	/**
	 * @return the trmtThuStart
	 */
	public String getTrmtThuStart() {
		return trmtThuStart;
	}
	/**
	 * @param trmtThuStart the trmtThuStart to set
	 */
	public void setTrmtThuStart(String trmtThuStart) {
		this.trmtThuStart = trmtThuStart;
	}
	/**
	 * @return the trmtTueEnd
	 */
	public String getTrmtTueEnd() {
		return trmtTueEnd;
	}
	/**
	 * @param trmtTueEnd the trmtTueEnd to set
	 */
	public void setTrmtTueEnd(String trmtTueEnd) {
		this.trmtTueEnd = trmtTueEnd;
	}
	/**
	 * @return the trmtTueStart
	 */
	public String getTrmtTueStart() {
		return trmtTueStart;
	}
	/**
	 * @param trmtTueStart the trmtTueStart to set
	 */
	public void setTrmtTueStart(String trmtTueStart) {
		this.trmtTueStart = trmtTueStart;
	}
	/**
	 * @return the trmtWedEnd
	 */
	public String getTrmtWedEnd() {
		return trmtWedEnd;
	}
	/**
	 * @param trmtWedEnd the trmtWedEnd to set
	 */
	public void setTrmtWedEnd(String trmtWedEnd) {
		this.trmtWedEnd = trmtWedEnd;
	}
	/**
	 * @return the trmtWedStart
	 */
	public String getTrmtWedStart() {
		return trmtWedStart;
	}
	/**
	 * @param trmtWedStart the trmtWedStart to set
	 */
	public void setTrmtWedStart(String trmtWedStart) {
		this.trmtWedStart = trmtWedStart;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResPharmDetailVO [no=" + no + ", lunchSat=" + lunchSat + ", lunchWeek=" + lunchWeek + ", noTrmtHoli="
				+ noTrmtHoli + ", noTrmtSun=" + noTrmtSun + ", parkEtc=" + parkEtc + ", plcDir=" + plcDir + ", plcNm="
				+ plcNm + ", rcvSat=" + rcvSat + ", rcvWeek=" + rcvWeek + ", trmtFriEnd=" + trmtFriEnd
				+ ", trmtFriStart=" + trmtFriStart + ", trmtMonEnd=" + trmtMonEnd + ", trmtMonStart=" + trmtMonStart
				+ ", trmtSatEnd=" + trmtSatEnd + ", trmtSatStart=" + trmtSatStart + ", trmtThuEnd=" + trmtThuEnd
				+ ", trmtThuStart=" + trmtThuStart + ", trmtTueEnd=" + trmtTueEnd + ", trmtTueStart=" + trmtTueStart
				+ ", trmtWedEnd=" + trmtWedEnd + ", trmtWedStart=" + trmtWedStart + ", insertDt=" + insertDt
				+ ", updateDt=" + updateDt + "]";
	}
	
}
