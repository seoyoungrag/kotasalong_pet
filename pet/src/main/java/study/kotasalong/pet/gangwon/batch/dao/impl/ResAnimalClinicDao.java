/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResAnimalClinicDao.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.dao.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 8. 27. 오후 4:05:27
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import study.kotasalong.pet.gangwon.batch.dao.AbstractDao;
import study.kotasalong.pet.gangwon.batch.dao.IResAnimalClinicDao;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicVO;

/** 
* @FileName      : ResAnimalPharmacyDao.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Repository("resAnimalClinicDao")
public class ResAnimalClinicDao extends AbstractDao implements IResAnimalClinicDao {

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#saveResAnimalClinicVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicVO)
	 */
	public void saveResAnimalClinicVO(ResAnimalClinicVO resAnimalClinicVO) {
        //persist(resAnimalClinicVO);
		saveOrUpdate(resAnimalClinicVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#findAllResAnimalClinicVOs()
	 */
	@SuppressWarnings("unchecked")
	public List<ResAnimalClinicVO> findAllResAnimalClinicVOs() {
        Criteria criteria = getSession().createCriteria(ResAnimalClinicVO.class);
        return (List<ResAnimalClinicVO>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#deleteResAnimalClinicVOByNo(int)
	 */
	public void deleteResAnimalClinicVOByNo(int no) {
        Query query = getSession().createSQLQuery("delete from ResAnimalClinicVO where no = :no");
        query.setInteger("no", no);
        query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#findByNo(int)
	 */
	public ResAnimalClinicVO findByNo(int no) {
        Criteria criteria = getSession().createCriteria(ResAnimalClinicVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (ResAnimalClinicVO) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#updateResAnimalClinicVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicVO)
	 */
	public void updateResAnimalClinicVO(ResAnimalClinicVO resAnimalClinicVO) {
        getSession().update(resAnimalClinicVO);
	}

}
