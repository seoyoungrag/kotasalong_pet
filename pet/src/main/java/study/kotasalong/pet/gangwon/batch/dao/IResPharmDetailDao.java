/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : IResPharmDetailDao.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.dao
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 19. 오후 11:13:44
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 19. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.dao;

import java.util.List;

import study.kotasalong.pet.gangwon.batch.vo.ResPharmDetailVO;

/** 
* @FileName      : IResPharmDetailDao.java 
* @Project     : pet 
* @Date        : 2017. 9. 19. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

public interface IResPharmDetailDao {

    void save(ResPharmDetailVO resultDetail);
 
    List<ResPharmDetailVO> findAll();
 
    void deleteByNo(int no);
 
    ResPharmDetailVO findByNo(int no);
 
    void update(ResPharmDetailVO vo);
}
