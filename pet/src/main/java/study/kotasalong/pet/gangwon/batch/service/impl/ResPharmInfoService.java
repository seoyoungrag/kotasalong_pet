/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResPharmInfoService.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.service.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:12:20
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 19. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import study.kotasalong.pet.gangwon.batch.dao.IResPharmInfoDao;
import study.kotasalong.pet.gangwon.batch.service.IResPharmInfoService;
import study.kotasalong.pet.gangwon.batch.vo.ResPharmInfoVO;

/** 
* @FileName      : ResPharmInfoService.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Service("resPharmInfoService")
@Transactional
public class ResPharmInfoService implements IResPharmInfoService {

    @Resource(name="resPharmInfoDao")
    private IResPharmInfoDao dao;
    
	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResPharmInfoService#save(study.kotasalong.pet.gangwon.batch.vo.ResPharmInfoVO)
	 */
	@Override
	public void save(ResPharmInfoVO vo) {
		dao.save(vo);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResPharmInfoService#findAll()
	 */
	@Override
	public List<ResPharmInfoVO> findAll() {
		return dao.findAll();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResPharmInfoService#deleteByNo(int)
	 */
	@Override
	public void deleteByNo(int no) {
		dao.deleteByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResPharmInfoService#findByNo(int)
	 */
	@Override
	public ResPharmInfoVO findByNo(int no) {
		return dao.findByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResPharmInfoService#update(study.kotasalong.pet.gangwon.batch.vo.ResPharmInfoVO)
	 */
	@Override
	public void update(ResPharmInfoVO vo) {
		dao.update(vo);
	}

}
