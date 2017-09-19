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
@Table(name="res_pharminfo_basis")
public class ResPharmInfoVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3717407048842078670L;
	@Id
	@Column(name="NO")
	private int no;
	@Column(name="addr")
	@SerializedName("addr")
	private String addr;
	@Column(name="hospUrl")
	@SerializedName("hospUrl")
	private String hospUrl;
	@Column(name="telno")
	@SerializedName("telno")
	private String telno;
	@Column(name="yadmNm")
	@SerializedName("yadmNm")
	private String yadmNm;
	@Column(name="ykiho")
	@SerializedName("ykiho")
	private String ykiho;
	@Column(name="Pharm_Basis_INSERT_DT")
    @Temporal(TemporalType.TIMESTAMP)
	private Date insertDt;
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="Pharm_Basis_UPDATE_DT")
    private Date updateDt;
    
	/**
	 * 
	 */
	public ResPharmInfoVO() {
		super();
	}
	/**
	 * @param no
	 * @param addr
	 * @param hospUrl
	 * @param telno
	 * @param yadmNm
	 * @param ykiho
	 * @param insertDt
	 * @param updateDt
	 */
	public ResPharmInfoVO(int no, String addr, String hospUrl, String telno, String yadmNm, String ykiho, Date insertDt,
			Date updateDt) {
		super();
		this.no = no;
		this.addr = addr;
		this.hospUrl = hospUrl;
		this.telno = telno;
		this.yadmNm = yadmNm;
		this.ykiho = ykiho;
		this.insertDt = insertDt;
		this.updateDt = updateDt;
	}

	public ResPharmInfoVO(ResHospInfoVO vo) {
		super();
		this.no = vo.getNo();
		this.addr = vo.getAddr();
		this.hospUrl = vo.getHospUrl();
		this.telno = vo.getTelno();
		this.yadmNm = vo.getYadmNm();
		this.ykiho = vo.getYkiho();
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
	/**
	 * @return the hospUrl
	 */
	public String getHospUrl() {
		return hospUrl;
	}
	/**
	 * @param hospUrl the hospUrl to set
	 */
	public void setHospUrl(String hospUrl) {
		this.hospUrl = hospUrl;
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
	 * @return the yadmNm
	 */
	public String getYadmNm() {
		return yadmNm;
	}
	/**
	 * @param yadmNm the yadmNm to set
	 */
	public void setYadmNm(String yadmNm) {
		this.yadmNm = yadmNm;
	}
	/**
	 * @return the ykiho
	 */
	public String getYkiho() {
		return ykiho;
	}
	/**
	 * @param ykiho the ykiho to set
	 */
	public void setYkiho(String ykiho) {
		this.ykiho = ykiho;
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
		return "ResHospInfoVO [no=" + no + ", addr=" + addr + ", hospUrl=" + hospUrl + ", telno=" + telno + ", yadmNm="
				+ yadmNm + ", ykiho=" + ykiho + ", insertDt=" + insertDt + ", updateDt=" + updateDt + "]";
	}
	
}
