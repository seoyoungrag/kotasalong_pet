/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : ResAnimalClinicService.java
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

import study.kotasalong.pet.gangwon.batch.dao.IResAnimalClinicDao;
import study.kotasalong.pet.gangwon.batch.service.IResAnimalClinicService;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicVO;

/** 
* @FileName      : ResAnimalClinicService.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Service("resAnimalClinicService")
@Transactional
public class ResAnimalClinicService implements IResAnimalClinicService {

    @Resource(name="resAnimalClinicDao")
    private IResAnimalClinicDao resAnimalClinicDao;

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#saveResAnimalClinicVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicVO)
	 */
	public void saveResAnimalClinicVO(ResAnimalClinicVO resAnimalClinicVO) {
		resAnimalClinicDao.saveResAnimalClinicVO(resAnimalClinicVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#findAllResAnimalClinicVOs()
	 */
	public List<ResAnimalClinicVO> findAllResAnimalClinicVOs() {
        return resAnimalClinicDao.findAllResAnimalClinicVOs();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#deleteResAnimalClinicVOBySsn(int)
	 */
	public void deleteResAnimalClinicVOByNo(int no) {
		resAnimalClinicDao.deleteResAnimalClinicVOByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#findBySsn(int)
	 */
	public ResAnimalClinicVO findByNo(int no) {
        return resAnimalClinicDao.findByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#updateResAnimalClinicVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicVO)
	 */
	public void updateResAnimalClinicVO(ResAnimalClinicVO resAnimalClinicVO) {
		resAnimalClinicDao.updateResAnimalClinicVO(resAnimalClinicVO);
	}

}
