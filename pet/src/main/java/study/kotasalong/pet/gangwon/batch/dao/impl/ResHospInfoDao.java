/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResHospInfoDao.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.dao.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:16:41
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
import study.kotasalong.pet.gangwon.batch.dao.IResHospInfoDao;
import study.kotasalong.pet.gangwon.batch.vo.ResHospInfoVO;

/** 
* @FileName      : ResHospInfoDao.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Repository("resHospInfoDao")
public class ResHospInfoDao extends AbstractDao implements IResHospInfoDao {

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResHospInfoDao#save(study.kotasalong.pet.gangwon.batch.vo.ResHospInfoVO)
	 */
	@Override
	public void save(ResHospInfoVO vo) {
		saveOrUpdate(vo);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResHospInfoDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ResHospInfoVO> findAll() {
        Criteria criteria = getSession().createCriteria(ResHospInfoVO.class);
        return (List<ResHospInfoVO>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResHospInfoDao#deleteByNo(int)
	 */
	@Override
	public void deleteByNo(int no) {
        Query query = getSession().createSQLQuery("delete from ResHospInfoVO where no = :no");
        query.setInteger("no", no);
        query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResHospInfoDao#findByNo(int)
	 */
	@Override
	public ResHospInfoVO findByNo(int no) {
        Criteria criteria = getSession().createCriteria(ResHospInfoVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (ResHospInfoVO) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResHospInfoDao#update(study.kotasalong.pet.gangwon.batch.vo.ResHospInfoVO)
	 */
	@Override
	public void update(ResHospInfoVO vo) {
        getSession().update(vo);
	}

}
