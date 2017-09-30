/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : AnimalPensionService.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.service.impl
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 24. 오후 2:26:13
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 24. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import study.kotasalong.pet.gangwon.batch.dao.IAnimalPensionDao;
import study.kotasalong.pet.gangwon.batch.service.IAnimalPensionService;
import study.kotasalong.pet.gangwon.batch.vo.AnimalPensionVO;

/** 
* @FileName      : AnimalPensionService.java 
* @Project     : pet 
* @Date        : 2017. 9. 24. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Service("animalPensionService")
@Transactional
public class AnimalPensionService implements IAnimalPensionService {

    @Resource(name="animalPensionDao")
    private IAnimalPensionDao animalPensionDao;
	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IAnimalService#saveAnimalPensionVO(study.kotasalong.pet.gangwon.batch.vo.AnimalPensionVO)
	 */
	@Override
	public void saveAnimalPensionVO(AnimalPensionVO animalPension) {
		animalPensionDao.saveAnimalPensionVO(animalPension);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IAnimalService#findAllResAnimalClinicVOs()
	 */
	@Override
	public List<AnimalPensionVO> findAllAnimalPensionVOs() {
        return animalPensionDao.findAllAnimalPensions();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IAnimalService#deleteAnimalPensionVOByNo(int)
	 */
	@Override
	public void deleteAnimalPensionVOByNo(int no) {
		animalPensionDao.deleteAnimalPensionVOByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IAnimalService#findByNo(int)
	 */
	@Override
	public AnimalPensionVO findByNo(int no) {
        return animalPensionDao.findByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IAnimalService#updateAnimalClinicVO(study.kotasalong.pet.gangwon.batch.vo.AnimalPensionVO)
	 */
	@Override
	public void updateAnimalPensionVO(AnimalPensionVO animalPension) {
		animalPensionDao.updateAnimalPensionVO(animalPension);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IAnimalPensionService#getMaxNo()
	 */
	@Override
	public int getMaxNo() {
		return animalPensionDao.getMaxNo() > 200000 ? animalPensionDao.getMaxNo()-100000 : animalPensionDao.getMaxNo() ;
	}

}
