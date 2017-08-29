/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResAnimalPharmacyService.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.service.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 8. 27. 오후 4:20:17
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import study.kotasalong.pet.gangwon.batch.dao.IResAnimalPharmacyDao;
import study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyVO;

/** 
* @FileName      : ResAnimalPharmacyService.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Service("resAnimalPharmacyService")
@Transactional
public class ResAnimalPharmacyService implements IResAnimalPharmacyService {

    @Resource(name="resAnimalPharmacyDao")
    private IResAnimalPharmacyDao resAnimalPharmacyDao;

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#saveResAnimalPharmacyVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyVO)
	 */
	public void saveResAnimalPharmacyVO(ResAnimalPharmacyVO resAnimalPharmacyVO) {
        resAnimalPharmacyDao.saveResAnimalPharmacyVO(resAnimalPharmacyVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#findAllResAnimalPharmacyVOs()
	 */
	public List<ResAnimalPharmacyVO> findAllResAnimalPharmacyVOs() {
        return resAnimalPharmacyDao.findAllResAnimalPharmacyVOs();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#deleteResAnimalPharmacyVOBySsn(int)
	 */
	public void deleteResAnimalPharmacyVOByNo(int no) {
        resAnimalPharmacyDao.deleteResAnimalPharmacyVOByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#findBySsn(int)
	 */
	public ResAnimalPharmacyVO findByNo(int no) {
        return resAnimalPharmacyDao.findByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#updateResAnimalPharmacyVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyVO)
	 */
	public void updateResAnimalPharmacyVO(ResAnimalPharmacyVO resAnimalPharmacyVO) {
        resAnimalPharmacyDao.updateResAnimalPharmacyVO(resAnimalPharmacyVO);
	}

}
