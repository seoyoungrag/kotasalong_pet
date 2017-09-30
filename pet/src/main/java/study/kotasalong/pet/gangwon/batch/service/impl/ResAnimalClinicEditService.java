/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : ResAnimalClinicService.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.service.impl
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 4:20:17
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
 */
package study.kotasalong.pet.gangwon.batch.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import study.kotasalong.pet.gangwon.batch.dao.IResAnimalClinicEditDao;
import study.kotasalong.pet.gangwon.batch.service.IResAnimalClinicEditService;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicEditedVO;

/** 
* @FileName      : ResAnimalClinicService.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

@Service("resAnimalClinicEditService")
@Transactional
public class ResAnimalClinicEditService implements IResAnimalClinicEditService {

    @Resource(name="resAnimalClinicEditDao")
    private IResAnimalClinicEditDao resAnimalClinicDao;

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#saveResAnimalClinicEditedVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicEditedVO)
	 */
	public void saveResAnimalClinicEditedVO(ResAnimalClinicEditedVO ResAnimalClinicEditedVO) {
		resAnimalClinicDao.saveResAnimalClinicEditedVO(ResAnimalClinicEditedVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#findAllResAnimalClinicEditedVOs()
	 */
	public List<ResAnimalClinicEditedVO> findAllResAnimalClinicEditedVOs() {
        return resAnimalClinicDao.findAllResAnimalClinicEditedVOs();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#deleteResAnimalClinicEditedVOBySsn(int)
	 */
	public void deleteResAnimalClinicEditedVOByNo(int no) {
		resAnimalClinicDao.deleteResAnimalClinicEditedVOByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#findBySsn(int)
	 */
	public ResAnimalClinicEditedVO findByNo(int no) {
        return resAnimalClinicDao.findByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#updateResAnimalClinicEditedVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicEditedVO)
	 */
	public void updateResAnimalClinicEditedVO(ResAnimalClinicEditedVO ResAnimalClinicEditedVO) {
		resAnimalClinicDao.updateResAnimalClinicEditedVO(ResAnimalClinicEditedVO);
	}

}
