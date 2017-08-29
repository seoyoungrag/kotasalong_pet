/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : IResAnimalClinicService.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.service
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 8. 27. 오후 4:18:07
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.service;

import java.util.List;

import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicVO;

/** 
* @FileName      : IResAnimalPharmacyService.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

public interface IResAnimalClinicService {
	 
    void saveResAnimalClinicVO(ResAnimalClinicVO resAnimalClinicVO);
 
    List<ResAnimalClinicVO> findAllResAnimalClinicVOs();
 
    void deleteResAnimalClinicVOByNo(int no);
 
    ResAnimalClinicVO findByNo(int no);
 
    void updateResAnimalClinicVO(ResAnimalClinicVO resAnimalClinicVO);
}
