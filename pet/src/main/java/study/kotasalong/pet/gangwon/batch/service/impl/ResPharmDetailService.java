/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResPharmDetailService.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.service.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:12:10
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

import study.kotasalong.pet.gangwon.batch.dao.IResPharmDetailDao;
import study.kotasalong.pet.gangwon.batch.service.IResPharmDetailService;
import study.kotasalong.pet.gangwon.batch.vo.ResPharmDetailVO;

/** 
* @FileName      : ResPharmDetailService.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Service("resPharmDetailService")
@Transactional
public class ResPharmDetailService implements IResPharmDetailService {

    @Resource(name="resPharmDetailDao")
    private IResPharmDetailDao dao;
    
	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResPharmDetailService#save(study.kotasalong.pet.gangwon.batch.vo.ResPharmDetailVO)
	 */
	@Override
	public void save(ResPharmDetailVO resultDetail) {
		dao.save(resultDetail);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResPharmDetailService#findAll()
	 */
	@Override
	public List<ResPharmDetailVO> findAll() {
		return dao.findAll();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResPharmDetailService#deleteByNo(int)
	 */
	@Override
	public void deleteByNo(int no) {
		dao.deleteByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResPharmDetailService#findByNo(int)
	 */
	@Override
	public ResPharmDetailVO findByNo(int no) {
		return dao.findByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResPharmDetailService#update(study.kotasalong.pet.gangwon.batch.vo.ResPharmDetailVO)
	 */
	@Override
	public void update(ResPharmDetailVO vo) {
		dao.update(vo);
	}

}
