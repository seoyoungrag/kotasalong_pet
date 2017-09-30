/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : ResAnimalPharmacyService.java
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

import study.kotasalong.pet.gangwon.batch.dao.IResAnimalPharmacyEditDao;
import study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyEditService;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyEditedVO;

/** 
* @FileName      : ResAnimalPharmacyService.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@Service("resAnimalPharmacyEditService")
@Transactional
public class ResAnimalPharmacyEditService implements IResAnimalPharmacyEditService {

    @Resource(name="resAnimalPharmacyEditDao")
    private IResAnimalPharmacyEditDao resAnimalPharmacyDao;

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#saveResAnimalPharmacyEditedVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyEditedVO)
	 */
	public void saveResAnimalPharmacyEditedVO(ResAnimalPharmacyEditedVO ResAnimalPharmacyEditedVO) {
        resAnimalPharmacyDao.saveResAnimalPharmacyEditedVO(ResAnimalPharmacyEditedVO);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#findAllResAnimalPharmacyEditedVOs()
	 */
	public List<ResAnimalPharmacyEditedVO> findAllResAnimalPharmacyEditedVOs() {
        return resAnimalPharmacyDao.findAllResAnimalPharmacyEditedVOs();
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#deleteResAnimalPharmacyEditedVOBySsn(int)
	 */
	public void deleteResAnimalPharmacyEditedVOByNo(int no) {
        resAnimalPharmacyDao.deleteResAnimalPharmacyEditedVOByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#findBySsn(int)
	 */
	public ResAnimalPharmacyEditedVO findByNo(int no) {
        return resAnimalPharmacyDao.findByNo(no);
	}

	/* (non-Javadoc)
	 * @see study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService#updateResAnimalPharmacyEditedVO(study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyEditedVO)
	 */
	public void updateResAnimalPharmacyEditedVO(ResAnimalPharmacyEditedVO ResAnimalPharmacyEditedVO) {
        resAnimalPharmacyDao.updateResAnimalPharmacyEditedVO(ResAnimalPharmacyEditedVO);
	}

}
