/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResKTAddressPharmService.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.service.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:11:58
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

import study.kotasalong.pet.gangwon.batch.dao.IResKTAddressPharmDao;
import study.kotasalong.pet.gangwon.batch.service.IResKTAddressPharmService;
import study.kotasalong.pet.gangwon.batch.vo.ResKTAddressPharmVO;

/** 
* @FileName      : ResKTAddressPharmService.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Service("resKTAddressPharmService")
@Transactional
public class ResKTAddressPharmService implements IResKTAddressPharmService {

    @Resource(name="resKTAddressPharmDao")
    private IResKTAddressPharmDao dao;
    
	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResKTAddressPharmService#save(study.kotasalong.pet.gangwon.batch.vo.ResKTAddressPharmVO)
	 */
	@Override
	public void save(ResKTAddressPharmVO resultKTInfo) {
		dao.save(resultKTInfo);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResKTAddressPharmService#findAll()
	 */
	@Override
	public List<ResKTAddressPharmVO> findAll() {
		return dao.findAll();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResKTAddressPharmService#deleteByNo(int)
	 */
	@Override
	public void deleteByNo(int no) {
		dao.deleteByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResKTAddressPharmService#findByNo(int)
	 */
	@Override
	public ResKTAddressPharmVO findByNo(int no) {
		return dao.findByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResKTAddressPharmService#update(study.kotasalong.pet.gangwon.batch.vo.ResKTAddressPharmVO)
	 */
	@Override
	public void update(ResKTAddressPharmVO vo) {
		dao.update(vo);
	}

}
