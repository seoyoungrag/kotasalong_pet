/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : IResPharmInfoDao.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.dao
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:13:51
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 19. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.dao;

import java.util.List;

import study.kotasalong.pet.gangwon.batch.vo.ResPharmInfoVO;

/** 
* @FileName      : IResPharmInfoDao.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

public interface IResPharmInfoDao {
	 
    void save(ResPharmInfoVO vo);
 
    List<ResPharmInfoVO> findAll();
 
    void deleteByNo(int no);
 
    ResPharmInfoVO findByNo(int no);
 
    void update(ResPharmInfoVO vo);
}
