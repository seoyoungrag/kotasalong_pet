/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : ResAnimalPharmacyDao.java
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
import study.kotasalong.pet.gangwon.batch.dao.IResAnimalPharmacyEditDao;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicEditedVO;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyEditedVO;

/** 
* @FileName      : ResAnimalPharmacyDao.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

@Repository("resAnimalPharmacyEditDao")
public class ResAnimalPharmacyEditDao extends AbstractDao implements IResAnimalPharmacyEditDao {

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#saveResAnimalPharmacyEditedVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyEditedVO)
	 */
	public void saveResAnimalPharmacyEditedVO(ResAnimalPharmacyEditedVO vo) {
		ResAnimalPharmacyEditedVO merged;
		ResAnimalPharmacyEditedVO candidate =  (ResAnimalPharmacyEditedVO) getSession().get(ResAnimalPharmacyEditedVO.class, vo.getNo());
	    if (candidate != null) {
	        merged = (ResAnimalPharmacyEditedVO) getSession().merge(vo);
	    } else {
	    	vo.ensureUuid();
	    	getSession().save(vo);
	        merged = vo;
	    }
        //persist(ResAnimalPharmacyEditedVO);
		//saveOrUpdate(ResAnimalPharmacyEditedVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#findAllResAnimalPharmacyEditedVOs()
	 */
	@SuppressWarnings("unchecked")
	public List<ResAnimalPharmacyEditedVO> findAllResAnimalPharmacyEditedVOs() {
        Criteria criteria = getSession().createCriteria(ResAnimalPharmacyEditedVO.class);
        return (List<ResAnimalPharmacyEditedVO>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#deleteResAnimalPharmacyEditedVOByNo(int)
	 */
	public void deleteResAnimalPharmacyEditedVOByNo(int no) {
		ResAnimalPharmacyEditedVO delVO = new ResAnimalPharmacyEditedVO();
		delVO.setNo(no);
		delete(delVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#findByNo(int)
	 */
	public ResAnimalPharmacyEditedVO findByNo(int no) {
        Criteria criteria = getSession().createCriteria(ResAnimalPharmacyEditedVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (ResAnimalPharmacyEditedVO) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#updateResAnimalPharmacyEditedVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyEditedVO)
	 */
	public void updateResAnimalPharmacyEditedVO(ResAnimalPharmacyEditedVO resAnimalPharmacyEditedVO) {
		if(resAnimalPharmacyEditedVO.getNo() ==0 ){
			getSession().persist(resAnimalPharmacyEditedVO);
		}else{
			getSession().update(resAnimalPharmacyEditedVO);
		}
	}

}
