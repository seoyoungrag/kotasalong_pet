/**
 * 0. Project  : ������ �� â�� ������Ʈ
 *
 * 1. FileName : ResAnimalClinicDao.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.dao.impl
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 4:05:27
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
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
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
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
