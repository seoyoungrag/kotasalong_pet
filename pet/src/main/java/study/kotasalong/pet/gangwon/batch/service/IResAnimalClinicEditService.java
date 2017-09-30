/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : IResAnimalClinicService.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.service
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 4:18:07
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
 */
package study.kotasalong.pet.gangwon.batch.service;

import java.util.List;

import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicEditedVO;

/** 
* @FileName      : IResAnimalPharmacyService.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

public interface IResAnimalClinicEditService {
	 
    void saveResAnimalClinicEditedVO(ResAnimalClinicEditedVO ResAnimalClinicEditedVO);
 
    List<ResAnimalClinicEditedVO> findAllResAnimalClinicEditedVOs();
 
    void deleteResAnimalClinicEditedVOByNo(int no);
 
    ResAnimalClinicEditedVO findByNo(int no);
 
    void updateResAnimalClinicEditedVO(ResAnimalClinicEditedVO ResAnimalClinicEditedVO);
}
