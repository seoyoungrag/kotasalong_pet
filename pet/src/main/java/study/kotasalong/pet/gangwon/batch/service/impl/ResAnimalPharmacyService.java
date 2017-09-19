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
