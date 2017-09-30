/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : IResAnimalPharmacyDao.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.dao
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 4:02:57
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
 */
package study.kotasalong.pet.gangwon.batch.dao;

import java.util.List;

import study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyEditedVO;

/** 
* @FileName      : IResAnimalPharmacyDao.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

public interface IResAnimalPharmacyEditDao {
	 
    void saveResAnimalPharmacyEditedVO(ResAnimalPharmacyEditedVO ResAnimalPharmacyEditedVO);
     
    List<ResAnimalPharmacyEditedVO> findAllResAnimalPharmacyEditedVOs();
     
    void deleteResAnimalPharmacyEditedVOByNo(int no);
     
    ResAnimalPharmacyEditedVO findByNo(int no);
     
    void updateResAnimalPharmacyEditedVO(ResAnimalPharmacyEditedVO ResAnimalPharmacyEditedVO);
}
