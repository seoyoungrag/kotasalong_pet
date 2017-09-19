/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResHospDetailService.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.service.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:11:16
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

import study.kotasalong.pet.gangwon.batch.dao.IResHospDetailDao;
import study.kotasalong.pet.gangwon.batch.service.IResHospDetailService;
import study.kotasalong.pet.gangwon.batch.vo.ResHospDetailVO;

/** 
* @FileName      : ResHospDetailService.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Service("resHospDetailService")
@Transactional
public class ResHospDetailService implements IResHospDetailService {

    @Resource(name="resHospDetailDao")
    private IResHospDetailDao dao;
    
	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResHospDetailService#save(study.kotasalong.pet.gangwon.batch.vo.ResHospDetailVO)
	 */
	@Override
	public void save(ResHospDetailVO detail) {
		dao.save(detail);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResHospDetailService#findAll()
	 */
	@Override
	public List<ResHospDetailVO> findAll() {
		return dao.findAll();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResHospDetailService#deleteByNo(int)
	 */
	@Override
	public void deleteByNo(int no) {
		dao.deleteByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResHospDetailService#findByNo(int)
	 */
	@Override
	public ResHospDetailVO findByNo(int no) {
		return dao.findByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResHospDetailService#update(study.kotasalong.pet.gangwon.batch.vo.ResHospDetailVO)
	 */
	@Override
	public void update(ResHospDetailVO vo) {
		dao.update(vo);
	}

}
