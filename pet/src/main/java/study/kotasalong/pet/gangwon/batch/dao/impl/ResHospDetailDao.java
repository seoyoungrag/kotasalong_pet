/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResHospDetailDao.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.dao.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:16:30
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
import study.kotasalong.pet.gangwon.batch.dao.IResHospDetailDao;
import study.kotasalong.pet.gangwon.batch.vo.ResHospDetailVO;

/** 
* @FileName      : ResHospDetailDao.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Repository("resHospDetailDao")
public class ResHospDetailDao extends AbstractDao implements IResHospDetailDao {

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResHospDetailDao#save(study.kotasalong.pet.gangwon.batch.vo.ResHospDetailVO)
	 */
	@Override
	public void save(ResHospDetailVO detail) {
		saveOrUpdate(detail);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResHospDetailDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ResHospDetailVO> findAll() {
        Criteria criteria = getSession().createCriteria(ResHospDetailVO.class);
        return (List<ResHospDetailVO>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResHospDetailDao#deleteByNo(int)
	 */
	@Override
	public void deleteByNo(int no) {
        Query query = getSession().createSQLQuery("delete from ResHospDetailVO where no = :no");
        query.setInteger("no", no);
        query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResHospDetailDao#findByNo(int)
	 */
	@Override
	public ResHospDetailVO findByNo(int no) {
        Criteria criteria = getSession().createCriteria(ResHospDetailVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (ResHospDetailVO) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResHospDetailDao#update(study.kotasalong.pet.gangwon.batch.vo.ResHospDetailVO)
	 */
	@Override
	public void update(ResHospDetailVO vo) {
        getSession().update(vo);

	}

}
