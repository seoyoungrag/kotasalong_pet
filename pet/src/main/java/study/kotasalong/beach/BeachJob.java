/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : BeachJob.java
 * 2. Package : study.kotasalong.beach
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 10. 6. 오후 2:23:14
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 10. 6. :            : 신규 개발.
 */
package study.kotasalong.beach;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import study.kotasalong.pet.gangwon.batch.common.BatchUtil;

/** 
* @FileName      : BeachJob.java 
* @Project     : pet 
* @Date        : 2017. 10. 6. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Component("BeachJob")
public class BeachJob extends QuartzJobBean {
	private static final Logger logger = LoggerFactory.getLogger(BeachJob.class);
	
	@Resource(name="beachDao")  
	private BeachDao beachDao;
	
	/* (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		try {
			getBeachListStart();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** 
	* @Method Name : getBeachListStart 
	* @변경이력      : 
	* @Method 설명     :  
	*/
	
	
	@SuppressWarnings("unchecked")
	private void getBeachListStart() {
		List<BeachVO> beachList = new ArrayList<BeachVO>();
		String beachUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=TKQRSEPF8rJnnF5Iqf%2BribGqrb8vgDklpLlJF5PhH%2B7%2BzfnOSSma3qZLQjk6m7laPiGgeIXjvPRMtLsKE5b1Cg%3D%3D&MobileOS=ETC&MobileApp=AppTest&cat1=A01&cat2=A0101&cat3=A01011200&numOfRows=1000&pageNo=1";
		String beachListXml = null;
		try {
			beachListXml = BatchUtil.readUrl(beachUrl);
			beachList = (List<BeachVO>) BatchUtil.beachListXmlToList(beachListXml);
			beachDao.hqlTruncate("BeachVO");
			for(BeachVO vo : beachList){
				beachDao.saveBeachVO(vo);
			}
			/*
			List<BeachVO> savedBeachList = beachDao.findAllBeachVOs();
			for(BeachVO vo : beachList){
				boolean isSaved=false;
				for(BeachVO row : savedBeachList){
					if(vo.getTitle().equals(row.getTitle()) && vo.getSigungucode().equals(row.getSigungucode())){
						isSaved=true;
						break;
					}
				}
				if(!isSaved){
					beachDao.saveBeachVO(vo);
				}
			}
			*/
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		List<BeachKohaVO> beachKohaList = new ArrayList<BeachKohaVO>();
		String beachKohaUrl = "http://www.khoa.go.kr/oceanmap/otmsWfsApi.do?ServiceKey=oV/zQ68Zmoh7KhHhnGQ3Gs27BI0ipHjQDHSdxVnxrwPXfXncjF3hjEMmlEHTO6Kf&Layer=TB_FACI_BEACH";
		String beachKohaListXml = null;
		try {
			beachKohaListXml = BatchUtil.readUrl(beachKohaUrl);
			beachKohaList = (List<BeachKohaVO>) BatchUtil.beachListXmlToListFromKoha(beachKohaListXml,"TB_FACI_BEACH");
			beachDao.hqlTruncate("BeachKohaVO");
			for(BeachKohaVO vo : beachKohaList){
				beachDao.saveBeachKohaVO(vo);
			}
		}catch(Exception e){
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		List<CampKohaVO> campKohaList = new ArrayList<CampKohaVO>();
		String campKohaUrl = "http://www.khoa.go.kr/oceanmap/otmsWfsApi.do?ServiceKey=oV/zQ68Zmoh7KhHhnGQ3Gs27BI0ipHjQDHSdxVnxrwPXfXncjF3hjEMmlEHTO6Kf&Layer=TB_FACI_CAMPSITE";
		String campKohaListXml = null;
		try {
			campKohaListXml = BatchUtil.readUrl(campKohaUrl);
			campKohaList = (List<CampKohaVO>) BatchUtil.beachListXmlToListFromKoha(campKohaListXml,"TB_FACI_CAMPSITE");
			beachDao.hqlTruncate("CampKohaVO");
			for(CampKohaVO vo : campKohaList){
				beachDao.saveCampKohaVO(vo);
			}
		}catch(Exception e){
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		List<FestivalKohaVO> festivalKohaList = new ArrayList<FestivalKohaVO>();
		String festivalKohaUrl = "http://www.khoa.go.kr/oceanmap/otmsWfsApi.do?ServiceKey=oV/zQ68Zmoh7KhHhnGQ3Gs27BI0ipHjQDHSdxVnxrwPXfXncjF3hjEMmlEHTO6Kf&Layer=TB_FACI_FESTIVAL";
		String festivalKohaListXml = null;
		try {
			festivalKohaListXml = BatchUtil.readUrl(festivalKohaUrl);
			festivalKohaList = (List<FestivalKohaVO>) BatchUtil.beachListXmlToListFromKoha(festivalKohaListXml,"TB_FACI_FESTIVAL");
			beachDao.hqlTruncate("FestivalKohaVO");
			for(FestivalKohaVO vo : festivalKohaList){
				beachDao.saveFestivalKohaVO(vo);
			}
		}catch(Exception e){
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		List<SportKohaVO> sportKohaList = new ArrayList<SportKohaVO>();
		String sportKohaUrl = "http://www.khoa.go.kr/oceanmap/otmsWfsApi.do?ServiceKey=oV/zQ68Zmoh7KhHhnGQ3Gs27BI0ipHjQDHSdxVnxrwPXfXncjF3hjEMmlEHTO6Kf&Layer=TB_FACI_SPORT";
		String sportKohaListXml = null;
		try {
			sportKohaListXml = BatchUtil.readUrl(sportKohaUrl);
			sportKohaList = (List<SportKohaVO>) BatchUtil.beachListXmlToListFromKoha(sportKohaListXml,"TB_FACI_SPORT");
			beachDao.hqlTruncate("SportKohaVO");
			for(SportKohaVO vo : sportKohaList){
				beachDao.saveSportKohaVO(vo);
			}
		}catch(Exception e){
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

}
