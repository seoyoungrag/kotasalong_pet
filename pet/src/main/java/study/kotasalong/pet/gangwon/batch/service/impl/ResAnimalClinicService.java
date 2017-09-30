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

import study.kotasalong.pet.gangwon.batch.dao.IResAnimalClinicDao;
import study.kotasalong.pet.gangwon.batch.service.IResAnimalClinicService;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicVO;

/** 
* @FileName      : ResAnimalClinicService.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

@Service("resAnimalClinicService")
@Transactional
public class ResAnimalClinicService implements IResAnimalClinicService {

    @Resource(name="resAnimalClinicDao")
    private IResAnimalClinicDao resAnimalClinicDao;
    
    public int getMaxNo(){
		return resAnimalClinicDao.getMaxNo() > 200000 ? resAnimalClinicDao.getMaxNo()-100000 : resAnimalClinicDao.getMaxNo() ;
    }
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
