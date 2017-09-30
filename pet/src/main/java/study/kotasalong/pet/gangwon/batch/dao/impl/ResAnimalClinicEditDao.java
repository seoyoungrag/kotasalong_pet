/**
 * 0. Project  : ���� �� â�� ������Ʈ
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
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import study.kotasalong.pet.gangwon.batch.dao.AbstractDao;
import study.kotasalong.pet.gangwon.batch.dao.IResAnimalClinicEditDao;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicEditedVO;

/** 
* @FileName      : ResAnimalPharmacyDao.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

@Repository("resAnimalClinicEditDao")
public class ResAnimalClinicEditDao extends AbstractDao implements IResAnimalClinicEditDao {

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#saveResAnimalClinicEditedVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicEditedVO)
	 */
	public void saveResAnimalClinicEditedVO(ResAnimalClinicEditedVO vo) {
        //persist(ResAnimalClinicEditedVO);
		ResAnimalClinicEditedVO merged;
		ResAnimalClinicEditedVO candidate =  (ResAnimalClinicEditedVO) getSession().get(ResAnimalClinicEditedVO.class, vo.getNo());
	    if (candidate != null) {
	        merged = (ResAnimalClinicEditedVO) getSession().merge(vo);
	    } else {
	    	vo.ensureUuid();
	    	getSession().save(vo);
	        merged = vo;
	    }
		//saveOrUpdate(vo);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#findAllResAnimalClinicEditedVOs()
	 */
	@SuppressWarnings("unchecked")
	public List<ResAnimalClinicEditedVO> findAllResAnimalClinicEditedVOs() {
        Criteria criteria = getSession().createCriteria(ResAnimalClinicEditedVO.class);
        return (List<ResAnimalClinicEditedVO>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#deleteResAnimalClinicEditedVOByNo(int)
	 */
	public void deleteResAnimalClinicEditedVOByNo(int no) {
		ResAnimalClinicEditedVO delVO = new ResAnimalClinicEditedVO();
		delVO.setNo(no);
		delete(delVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#findByNo(int)
	 */
	public ResAnimalClinicEditedVO findByNo(int no) {
        Criteria criteria = getSession().createCriteria(ResAnimalClinicEditedVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (ResAnimalClinicEditedVO) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#updateResAnimalClinicEditedVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicEditedVO)
	 */
	public void updateResAnimalClinicEditedVO(ResAnimalClinicEditedVO resAnimalClinicEditedVO) {
		if(resAnimalClinicEditedVO.getNo() ==0 ){
			getSession().persist(resAnimalClinicEditedVO);
		}else{
			getSession().update(resAnimalClinicEditedVO);
		}
	}

}
