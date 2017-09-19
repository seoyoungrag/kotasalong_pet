/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResKTAddressClinicService.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.service.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:11:45
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

import study.kotasalong.pet.gangwon.batch.dao.IResKTAddressClinicDao;
import study.kotasalong.pet.gangwon.batch.service.IResKTAddressClinicService;
import study.kotasalong.pet.gangwon.batch.vo.ResKTAddressClinicVO;

/** 
* @FileName      : ResKTAddressClinicService.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Service("resKTAddressClinicService")
@Transactional
public class ResKTAddressClinicService implements IResKTAddressClinicService {

    @Resource(name="resKTAddressClinicDao")
    private IResKTAddressClinicDao dao;
    
	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResKTAddressClinicService#save(study.kotasalong.pet.gangwon.batch.vo.ResKTAddressClinicVO)
	 */
	@Override
	public void save(ResKTAddressClinicVO resultKTInfo) {
		dao.save(resultKTInfo);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResKTAddressClinicService#findAll()
	 */
	@Override
	public List<ResKTAddressClinicVO> findAll() {
		return dao.findAll();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResKTAddressClinicService#deleteByNo(int)
	 */
	@Override
	public void deleteByNo(int no) {
		dao.deleteByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResKTAddressClinicService#findByNo(int)
	 */
	@Override
	public ResKTAddressClinicVO findByNo(int no) {
		return dao.findByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResKTAddressClinicService#update(study.kotasalong.pet.gangwon.batch.vo.ResKTAddressClinicVO)
	 */
	@Override
	public void update(ResKTAddressClinicVO vo) {
		dao.update(vo);
	}

}
