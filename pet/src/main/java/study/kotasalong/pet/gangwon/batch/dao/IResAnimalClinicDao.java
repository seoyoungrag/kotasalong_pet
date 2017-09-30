/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : IResAnimalClinicDao.java
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

import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicVO;

/** 
* @FileName      : IResAnimalPharmacyDao.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

public interface IResAnimalClinicDao {
	 
    void saveResAnimalClinicVO(ResAnimalClinicVO resAnimalClinicVO);
     
    List<ResAnimalClinicVO> findAllResAnimalClinicVOs();
     
    void deleteResAnimalClinicVOByNo(int no);
     
    ResAnimalClinicVO findByNo(int no);
     
    void updateResAnimalClinicVO(ResAnimalClinicVO resAnimalClinicVO);

	/** 
	* @Method Name : getMaxNo 
	* @변경이력      : 
	* @Method 설명     : 
	* @return 
	*/
	
	
	int getMaxNo();

	/** 
	* @Method Name : insert 
	* @변경이력      : 
	* @Method 설명     : 
	* @param resAnimalClinicVO 
	*/
	
	
	void insert(ResAnimalClinicVO resAnimalClinicVO);
}
