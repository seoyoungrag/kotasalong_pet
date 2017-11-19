/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : BeachDao.java
 * 2. Package : study.kotasalong.beach
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 10. 6. 오후 2:26:48
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 10. 6. :            : 신규 개발.
 */
package study.kotasalong.beach;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import study.kotasalong.pet.gangwon.batch.dao.AbstractDao;

/** 
* @FileName      : BeachDao.java 
* @Project     : pet 
* @Date        : 2017. 10. 6. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Repository("beachDao")
@Transactional
public class BeachDao extends AbstractDao {
	@SuppressWarnings("unused")
	public void saveBeachVO(BeachVO vo) {
		BeachVO merged;
		BeachVO candidate =  (BeachVO) getSession().get(BeachVO.class, vo.getNo());
	    if (candidate != null) {
	        merged = (BeachVO) getSession().merge(vo);
	    } else {
	    	vo.ensureUuid();
	    	getSession().save(vo);
	        merged = vo;
	    }
	}
	@SuppressWarnings("unchecked")
	public List<BeachVO> findAllBeachVOs() {
        Criteria criteria = getSession().createCriteria(BeachVO.class);
        return (List<BeachVO>) criteria.list();
	}
	public BeachVO findByNo(int no) {
        Criteria criteria = getSession().createCriteria(BeachVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (BeachVO) criteria.uniqueResult();
	}
	public int hqlTruncate(String myTable){
	    String hql = String.format("delete from %s",myTable);
	    Query query = getSession().createQuery(hql);
	    return query.executeUpdate();
	}

	@SuppressWarnings("unused")
	public void saveCampKohaVO(CampKohaVO vo) {
		CampKohaVO merged;
		CampKohaVO candidate =  (CampKohaVO) getSession().get(CampKohaVO.class, vo.getNo());
	    if (candidate != null) {
	        merged = (CampKohaVO) getSession().merge(vo);
	    } else {
	    	vo.ensureUuid();
	    	getSession().save(vo);
	        merged = vo;
	    }
	}
	@SuppressWarnings("unchecked")
	public List<CampKohaVO> findAllCampKohaVOs() {
        Criteria criteria = getSession().createCriteria(CampKohaVO.class);
        return (List<CampKohaVO>) criteria.list();
	}
	public CampKohaVO findCampKohaVOByNo(int no) {
        Criteria criteria = getSession().createCriteria(CampKohaVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (CampKohaVO) criteria.uniqueResult();
	}
	

	@SuppressWarnings("unused")
	public void saveBeachKohaVO(BeachKohaVO vo) {
		BeachKohaVO merged;
		BeachKohaVO candidate =  (BeachKohaVO) getSession().get(BeachKohaVO.class, vo.getNo());
	    if (candidate != null) {
	        merged = (BeachKohaVO) getSession().merge(vo);
	    } else {
	    	vo.ensureUuid();
	    	getSession().save(vo);
	        merged = vo;
	    }
	}
	@SuppressWarnings("unchecked")
	public List<BeachKohaVO> findAllBeachKohaVOs() {
        Criteria criteria = getSession().createCriteria(BeachKohaVO.class);
        return (List<BeachKohaVO>) criteria.list();
	}
	public BeachKohaVO findBeachKohaVOByNo(int no) {
        Criteria criteria = getSession().createCriteria(BeachKohaVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (BeachKohaVO) criteria.uniqueResult();
	}
	

	@SuppressWarnings("unused")
	public void saveFestivalKohaVO(FestivalKohaVO vo) {
		FestivalKohaVO merged;
		FestivalKohaVO candidate =  (FestivalKohaVO) getSession().get(FestivalKohaVO.class, vo.getNo());
	    if (candidate != null) {
	        merged = (FestivalKohaVO) getSession().merge(vo);
	    } else {
	    	vo.ensureUuid();
	    	getSession().save(vo);
	        merged = vo;
	    }
	}
	@SuppressWarnings("unchecked")
	public List<FestivalKohaVO> findAllFestivalKohaVOs() {
        Criteria criteria = getSession().createCriteria(FestivalKohaVO.class);
        return (List<FestivalKohaVO>) criteria.list();
	}
	public FestivalKohaVO findFestivalKohaVOByNo(int no) {
        Criteria criteria = getSession().createCriteria(FestivalKohaVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (FestivalKohaVO) criteria.uniqueResult();
	}

	
	@SuppressWarnings("unused")
	public void saveSportKohaVO(SportKohaVO vo) {
		SportKohaVO merged;
		SportKohaVO candidate =  (SportKohaVO) getSession().get(SportKohaVO.class, vo.getNo());
	    if (candidate != null) {
	        merged = (SportKohaVO) getSession().merge(vo);
	    } else {
	    	vo.ensureUuid();
	    	getSession().save(vo);
	        merged = vo;
	    }
	}
	@SuppressWarnings("unchecked")
	public List<SportKohaVO> findAllSportKohaVOs() {
        Criteria criteria = getSession().createCriteria(SportKohaVO.class);
        return (List<SportKohaVO>) criteria.list();
	}
	public SportKohaVO findSportKohaVOByNo(int no) {
        Criteria criteria = getSession().createCriteria(SportKohaVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (SportKohaVO) criteria.uniqueResult();
	}
}
