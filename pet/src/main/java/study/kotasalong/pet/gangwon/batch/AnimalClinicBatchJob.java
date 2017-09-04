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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;

import study.kotasalong.pet.gangwon.batch.common.BatchUtil;
import study.kotasalong.pet.gangwon.batch.common.ResponseVO;
import study.kotasalong.pet.gangwon.batch.service.IResAnimalClinicService;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicVO;

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
@Component("AnimalClinicBatchJob")
public class AnimalClinicBatchJob extends QuartzJobBean {
	
	private static final Logger logger = LoggerFactory.getLogger(AnimalClinicBatchJob.class);

    @Autowired
    @Value("${api.uri}")
    String apiUrl;
    @Value("${api.key}")
    String apiKey;
    @Value("${api.servicename.animalclinic}")
    String apiServiceName;
    @Value("${api.startindex}")
    String apiStartIdex;
    @Value("${api.endindex}")
    String apiEndIndex;
    
	@Resource(name="resAnimalClinicService") //spring,quartz�� lifecycle �ٸ�
	private IResAnimalClinicService resAnimalClinicService;
	
	public void animalClinicBatchStart() throws Exception {
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long start = System.currentTimeMillis() ; 
		logger.info("animalClinicBatchStart: "+ dayTime.format(new Date(start)));
		logger.info("animalClinicBatchStart request: "+ dayTime.format(new Date(System.currentTimeMillis())));
		String animalClinicUrl = MessageFormat.format(apiUrl, apiKey, apiServiceName, apiStartIdex, apiEndIndex);
	    String json = BatchUtil.readUrl(animalClinicUrl);
	    Type collectionType = new TypeToken<ResponseVO<ResAnimalClinicVO>>(){}.getType();
	    List<ResAnimalClinicVO> list = BatchUtil.jsonToVO(json, apiServiceName, collectionType);
		logger.info("animalClinicBatchStart request end: "+ dayTime.format(new Date(System.currentTimeMillis())));
		long end = System.currentTimeMillis(); 
		logger.info("animalClinicBatch request Proceed: "+ (end-start)/1000 +" seconds");
		logger.info("animalClinicBatchProssingCnt: "+ list.size() +" objects");
	    for(ResAnimalClinicVO vo : list){
	    	resAnimalClinicService.saveResAnimalClinicVO(vo);
	    }
		end = System.currentTimeMillis(); 
		logger.info("animalClinicBatchFinished: "+ dayTime.format(new Date(end)));
		logger.info("animalClinicBatchProceed: "+ (end-start)/1000 +" seconds");
	}

	/* (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		
		try {
			animalClinicBatchStart();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
