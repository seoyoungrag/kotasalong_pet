/**
 * 0. Project  : ������ �� â�� ������Ʈ
 *
 * 1. FileName : AnimalPharmacyBatchJob.java
 * 2. Package : study.kotasalong.pet.gangwon.batch
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 4:42:11
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
 */
package study.kotasalong.pet.gangwon.batch;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;

import study.kotasalong.pet.gangwon.batch.common.BatchUtil;
import study.kotasalong.pet.gangwon.batch.common.ResponseVO;
import study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyVO;

/** 
* @FileName      : AnimalPharmacyBatchJob.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Component("AnimalPharmacyBatchJob")
public class AnimalPharmacyBatchJob extends QuartzJobBean {
	private static final Logger logger = LoggerFactory.getLogger(AnimalPharmacyBatchJob.class);

    @Value("${api.uri}")
    String apiUrl;
    @Value("${api.key}")
    String apiKey;
    @Value("${api.servicename.animalpharmacy}")
    String apiServiceName;
    @Value("${api.startindex}")
    String apiStartIdex;
    @Value("${api.endindex}")
    String apiEndIndex;
    
	@Resource(name="resAnimalPharmacyService") //spring,quartz�� lifecycle �ٸ�
	private IResAnimalPharmacyService resAnimalPharmacyService;
	
	public void animalPharmacyBatchStart() throws Exception {		
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long start = System.currentTimeMillis() ; 
		logger.info("animalPharmacyBatchStart: "+ dayTime.format(new Date(start)));
		logger.info("animalPharmacyBatchStart request: "+ dayTime.format(new Date(System.currentTimeMillis())));
		String animalClinicUrl = MessageFormat.format(apiUrl, apiKey, apiServiceName, apiStartIdex, apiEndIndex);
	    String json = BatchUtil.readUrl(animalClinicUrl);
	    Type collectionType = new TypeToken<ResponseVO<ResAnimalPharmacyVO>>(){}.getType();
	    List<ResAnimalPharmacyVO> list = BatchUtil.jsonToVO(json, apiServiceName, collectionType);
		logger.info("animalPharmacyBatchStart request end: "+ dayTime.format(new Date(System.currentTimeMillis())));
		long end = System.currentTimeMillis(); 
		logger.info("animalPharmacyBatch request Proceed: "+ (end-start)/1000 +" seconds");
		logger.info("animalPharmacyBatchProssingCnt: "+ list.size() +" objects");
	    for(ResAnimalPharmacyVO vo : list){
	    	resAnimalPharmacyService.saveResAnimalPharmacyVO(vo);
	    }
		end = System.currentTimeMillis(); 
		logger.info("animalPharmacyBatchFinished: "+ dayTime.format(new Date(end)));
		logger.info("animalPharmacyBatchProceed: "+ (end-start)/1000 +" seconds");
	}

	/* (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		
		try {
			animalPharmacyBatchStart();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
