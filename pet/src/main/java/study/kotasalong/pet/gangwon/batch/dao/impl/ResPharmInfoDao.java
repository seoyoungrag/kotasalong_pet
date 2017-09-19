/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResPharmInfoDao.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.dao.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:17:22
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 19. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import study.kotasalong.pet.gangwon.batch.dao.AbstractDao;
import study.kotasalong.pet.gangwon.batch.dao.IResPharmInfoDao;
import study.kotasalong.pet.gangwon.batch.vo.ResPharmInfoVO;

/** 
* @FileName      : ResPharmInfoDao.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Repository("resPharmInfoDao")
public class ResPharmInfoDao extends AbstractDao implements IResPharmInfoDao {

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResPharmInfoDao#save(study.kotasalong.pet.gangwon.batch.vo.ResPharmInfoVO)
	 */
	@Override
	public void save(ResPharmInfoVO vo) {
		saveOrUpdate(vo);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResPharmInfoDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ResPharmInfoVO> findAll() {
        Criteria criteria = getSession().createCriteria(ResPharmInfoVO.class);
        return (List<ResPharmInfoVO>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResPharmInfoDao#deleteByNo(int)
	 */
	@Override
	public void deleteByNo(int no) {
        Query query = getSession().createSQLQuery("delete from ResPharmInfoVO where no = :no");
        query.setInteger("no", no);
        query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResPharmInfoDao#findByNo(int)
	 */
	@Override
	public ResPharmInfoVO findByNo(int no) {
        Criteria criteria = getSession().createCriteria(ResPharmInfoVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (ResPharmInfoVO) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResPharmInfoDao#update(study.kotasalong.pet.gangwon.batch.vo.ResPharmInfoVO)
	 */
	@Override
	public void update(ResPharmInfoVO vo) {
        getSession().update(vo);
	}

}
