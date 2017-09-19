/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResHospInfoService.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.service.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:11:32
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

import study.kotasalong.pet.gangwon.batch.dao.IResHospInfoDao;
import study.kotasalong.pet.gangwon.batch.service.IResHospInfoService;
import study.kotasalong.pet.gangwon.batch.vo.ResHospInfoVO;

/** 
* @FileName      : ResHospInfoService.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Service("resHospInfoService")
@Transactional
public class ResHospInfoService implements IResHospInfoService {

    @Resource(name="resHospInfoDao")
    private IResHospInfoDao dao;
	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResHospInfoService#save(study.kotasalong.pet.gangwon.batch.vo.ResHospInfoVO)
	 */
	@Override
	public void save(ResHospInfoVO vo) {
		dao.save(vo);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResHospInfoService#findAll()
	 */
	@Override
	public List<ResHospInfoVO> findAll() {
		return dao.findAll();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResHospInfoService#deleteByNo(int)
	 */
	@Override
	public void deleteByNo(int no) {
		dao.deleteByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResHospInfoService#findByNo(int)
	 */
	@Override
	public ResHospInfoVO findByNo(int no) {
		return dao.findByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResHospInfoService#update(study.kotasalong.pet.gangwon.batch.vo.ResHospInfoVO)
	 */
	@Override
	public void update(ResHospInfoVO vo) {
		dao.update(vo);
	}

}
