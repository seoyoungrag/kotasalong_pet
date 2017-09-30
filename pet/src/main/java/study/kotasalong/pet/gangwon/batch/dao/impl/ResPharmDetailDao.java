/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResPharmDetailDao.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.dao.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:17:12
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 19. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import study.kotasalong.pet.gangwon.batch.dao.AbstractDao;
import study.kotasalong.pet.gangwon.batch.dao.IResPharmDetailDao;
import study.kotasalong.pet.gangwon.batch.vo.ResPharmDetailVO;

/** 
* @FileName      : ResPharmDetailDao.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Repository("resPharmDetailDao")
public class ResPharmDetailDao extends AbstractDao implements IResPharmDetailDao {

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResPharmDetailDao#save(study.kotasalong.pet.gangwon.batch.vo.ResPharmDetailVO)
	 */
	@Override
	public void save(ResPharmDetailVO resultDetail) {
		saveOrUpdate(resultDetail);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResPharmDetailDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ResPharmDetailVO> findAll() {
        Criteria criteria = getSession().createCriteria(ResPharmDetailVO.class);
        return (List<ResPharmDetailVO>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResPharmDetailDao#deleteByNo(int)
	 */
	@Override
	public void deleteByNo(int no) {
		ResPharmDetailVO delVO = new ResPharmDetailVO();
		delVO.setNo(no);
		delete(delVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResPharmDetailDao#findByNo(int)
	 */
	@Override
	public ResPharmDetailVO findByNo(int no) {
        Criteria criteria = getSession().createCriteria(ResPharmDetailVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (ResPharmDetailVO) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResPharmDetailDao#update(study.kotasalong.pet.gangwon.batch.vo.ResPharmDetailVO)
	 */
	@Override
	public void update(ResPharmDetailVO vo) {
        getSession().update(vo);
	}

}
