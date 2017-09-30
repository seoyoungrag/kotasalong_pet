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

import study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyVO;

/** 
* @FileName      : IResAnimalPharmacyDao.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

public interface IResAnimalPharmacyDao {
	 
    void saveResAnimalPharmacyVO(ResAnimalPharmacyVO resAnimalPharmacyVO);
     
    List<ResAnimalPharmacyVO> findAllResAnimalPharmacyVOs();
     
    void deleteResAnimalPharmacyVOByNo(int no);
     
    ResAnimalPharmacyVO findByNo(int no);
     
    void updateResAnimalPharmacyVO(ResAnimalPharmacyVO resAnimalPharmacyVO);

	/** 
	* @Method Name : getMaxNo 
	* @변경이력      : 
	* @Method 설명     : 
	* @return 
	*/
	
	
	int getMaxNo();
}
