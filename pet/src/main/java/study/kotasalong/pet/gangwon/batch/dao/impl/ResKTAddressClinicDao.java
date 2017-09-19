/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResKTAddressClinicDao.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.dao.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:16:52
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
import study.kotasalong.pet.gangwon.batch.dao.IResKTAddressClinicDao;
import study.kotasalong.pet.gangwon.batch.vo.ResKTAddressClinicVO;

/** 
* @FileName      : ResKTAddressClinicDao.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Repository("resKTAddressClinicDao")
public class ResKTAddressClinicDao extends AbstractDao implements IResKTAddressClinicDao {

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResKTAddressClinicDao#save(study.kotasalong.pet.gangwon.batch.vo.ResKTAddressClinicVO)
	 */
	@Override
	public void save(ResKTAddressClinicVO resultKTInfo) {
		saveOrUpdate(resultKTInfo);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResKTAddressClinicDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ResKTAddressClinicVO> findAll() {
        Criteria criteria = getSession().createCriteria(ResKTAddressClinicVO.class);
        return (List<ResKTAddressClinicVO>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResKTAddressClinicDao#deleteByNo(int)
	 */
	@Override
	public void deleteByNo(int no) {
        Query query = getSession().createSQLQuery("delete from ResKTAddressClinicVO where no = :no");
        query.setInteger("no", no);
        query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResKTAddressClinicDao#findByNo(int)
	 */
	@Override
	public ResKTAddressClinicVO findByNo(int no) {
        Criteria criteria = getSession().createCriteria(ResKTAddressClinicVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (ResKTAddressClinicVO) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResKTAddressClinicDao#update(study.kotasalong.pet.gangwon.batch.vo.ResKTAddressClinicVO)
	 */
	@Override
	public void update(ResKTAddressClinicVO vo) {
        getSession().update(vo);
	}

}
