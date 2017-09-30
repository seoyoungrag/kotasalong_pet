/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResKTAddressPharmDao.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.dao.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:17:03
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
import study.kotasalong.pet.gangwon.batch.dao.IResKTAddressPharmDao;
import study.kotasalong.pet.gangwon.batch.vo.ResKTAddressPharmVO;

/** 
* @FileName      : ResKTAddressPharmDao.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Repository("resKTAddressPharmDao")
public class ResKTAddressPharmDao extends AbstractDao implements IResKTAddressPharmDao {

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResKTAddressPharmDao#save(study.kotasalong.pet.gangwon.batch.vo.ResKTAddressPharmVO)
	 */
	@Override
	public void save(ResKTAddressPharmVO resultKTInfo) {
		saveOrUpdate(resultKTInfo);

	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResKTAddressPharmDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ResKTAddressPharmVO> findAll() {
        Criteria criteria = getSession().createCriteria(ResKTAddressPharmVO.class);
        return (List<ResKTAddressPharmVO>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResKTAddressPharmDao#deleteByNo(int)
	 */
	@Override
	public void deleteByNo(int no) {
		ResKTAddressPharmVO delVO = new ResKTAddressPharmVO();
		delVO.setNo(no);
		delete(delVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResKTAddressPharmDao#findByNo(int)
	 */
	@Override
	public ResKTAddressPharmVO findByNo(int no) {
        Criteria criteria = getSession().createCriteria(ResKTAddressPharmVO.class);
        criteria.add(Restrictions.eq("no",no));
        return (ResKTAddressPharmVO) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.dao.IResKTAddressPharmDao#update(study.kotasalong.pet.gangwon.batch.vo.ResKTAddressPharmVO)
	 */
	@Override
	public void update(ResKTAddressPharmVO vo) {
        getSession().update(vo);
	}

}
