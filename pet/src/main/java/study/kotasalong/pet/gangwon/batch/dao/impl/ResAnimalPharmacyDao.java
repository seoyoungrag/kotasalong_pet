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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import study.kotasalong.pet.gangwon.batch.dao.AbstractDao;
import study.kotasalong.pet.gangwon.batch.dao.IResAnimalPharmacyDao;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyVO;

/** 
* @FileName      : ResAnimalPharmacyDao.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

@Repository("resAnimalPharmacyDao")
public class ResAnimalPharmacyDao extends AbstractDao implements IResAnimalPharmacyDao {

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#saveResAnimalPharmacyVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyVO)
	 */
	public void saveResAnimalPharmacyVO(ResAnimalPharmacyVO resAnimalPharmacyVO) {
        //persist(resAnimalPharmacyVO);
		saveOrUpdate(resAnimalPharmacyVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#findAllResAnimalPharmacyVOs()
	 */
	@SuppressWarnings("unchecked")
	public List<ResAnimalPharmacyVO> findAllResAnimalPharmacyVOs() {
        Criteria criteria = getSession().createCriteria(ResAnimalPharmacyVO.class);
        return (List<ResAnimalPharmacyVO>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#deleteResAnimalPharmacyVOByNo(int)
	 */
	public void deleteResAnimalPharmacyVOByNo(int no) {
		ResAnimalPharmacyVO delVO = new ResAnimalPharmacyVO();
		delVO.setNo(no);
		delete(delVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#findByNo(int)
	 */
	public ResAnimalPharmacyVO findByNo(int no) {
        Criteria criteria = getSession().createCriteria(ResAnimalPharmacyVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (ResAnimalPharmacyVO) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.vo.dao.IResAnimalPharmacyDao#updateResAnimalPharmacyVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyVO)
	 */
	public void updateResAnimalPharmacyVO(ResAnimalPharmacyVO resAnimalPharmacyVO) {
        getSession().update(resAnimalPharmacyVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResAnimalPharmacyDao#getMaxNo()
	 */
	@Override
	public int getMaxNo() {
		Criteria c = getSession().createCriteria(ResAnimalPharmacyVO.class);
		c.addOrder(Order.desc("no"));
		c.setMaxResults(1);
		ResAnimalPharmacyVO vo = (ResAnimalPharmacyVO)c.uniqueResult();
		return vo.getNo()+100001;
	}

}
