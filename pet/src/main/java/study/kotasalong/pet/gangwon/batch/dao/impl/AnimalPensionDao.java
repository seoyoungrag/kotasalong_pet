/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : AnimalPensionDao.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.dao.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 24. 오후 2:23:39
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 24. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import study.kotasalong.pet.gangwon.batch.dao.AbstractDao;
import study.kotasalong.pet.gangwon.batch.dao.IAnimalPensionDao;
import study.kotasalong.pet.gangwon.batch.vo.AnimalPensionVO;

/** 
* @FileName      : AnimalPensionDao.java 
* @Project     : pet 
* @Date        : 2017. 9. 24. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Repository("animalPensionDao")
public class AnimalPensionDao extends AbstractDao implements IAnimalPensionDao {

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IAnimalPensionDao#saveAnimalPensionVO(study.kotasalong.pet.gangwon.batch.vo.AnimalPensionVO)
	 */
	@Override
	public void saveAnimalPensionVO(AnimalPensionVO vo) {
		AnimalPensionVO merged;
		AnimalPensionVO candidate =  (AnimalPensionVO) getSession().get(AnimalPensionVO.class, vo.getNo());
	    if (candidate != null) {
	        merged = (AnimalPensionVO) getSession().merge(vo);
	    } else {
	    	vo.ensureUuid();
	    	getSession().save(vo);
	        merged = vo;
	    }
		//saveOrUpdate(animalPension);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IAnimalPensionDao#findAllAnimalPensions()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AnimalPensionVO> findAllAnimalPensions() {
        Criteria criteria = getSession().createCriteria(AnimalPensionVO.class);
        return (List<AnimalPensionVO>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IAnimalPensionDao#deleteAnimalPensionVOByNo(int)
	 */
	@Override
	public void deleteAnimalPensionVOByNo(int no) {
		AnimalPensionVO delVO = new AnimalPensionVO();
		delVO.setNo(no);
		delete(delVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IAnimalPensionDao#findByNo(int)
	 */
	@Override
	public AnimalPensionVO findByNo(int no) {
        Criteria criteria = getSession().createCriteria(AnimalPensionVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (AnimalPensionVO) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IAnimalPensionDao#updateAnimalPensionVO(study.kotasalong.pet.gangwon.batch.vo.AnimalPensionVO)
	 */
	@Override
	public void updateAnimalPensionVO(AnimalPensionVO animalPension) {
		if(animalPension.getNo() ==0 ){
			getSession().persist(animalPension);
		}else{
			getSession().update(animalPension);
		}
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IAnimalPensionDao#getMaxNo()
	 */
	@Override
	public int getMaxNo() {
		Criteria c = getSession().createCriteria(AnimalPensionVO.class);
		c.addOrder(Order.desc("no"));
		c.setMaxResults(1);
		AnimalPensionVO vo = (AnimalPensionVO)c.uniqueResult();
		return vo.getNo()+100001;
	}

}
