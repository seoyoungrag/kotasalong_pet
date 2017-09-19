/**
 * 0. Project  : ���� �� â�� ������Ʈ
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
import java.net.URLEncoder;
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
import study.kotasalong.pet.gangwon.batch.common.ResponseVOForAddr;
import study.kotasalong.pet.gangwon.batch.common.ResultVOForAddr;
import study.kotasalong.pet.gangwon.batch.common.ResultVOForHosp;
import study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService;
import study.kotasalong.pet.gangwon.batch.service.IResKTAddressPharmService;
import study.kotasalong.pet.gangwon.batch.service.IResPharmDetailService;
import study.kotasalong.pet.gangwon.batch.service.IResPharmInfoService;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyVO;
import study.kotasalong.pet.gangwon.batch.vo.ResHospDetailVO;
import study.kotasalong.pet.gangwon.batch.vo.ResHospInfoVO;
import study.kotasalong.pet.gangwon.batch.vo.ResKTAddressPharmVO;
import study.kotasalong.pet.gangwon.batch.vo.ResPharmDetailVO;
import study.kotasalong.pet.gangwon.batch.vo.ResPharmInfoVO;

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
    @Value("${api.address.uri}")
    String apiAddressUri;
    @Value("${api.servicename.address}")
    String addrApiServiceName;
    @Value("${api.servicename.pharmacyInfoService}")
    String apiHospBasisListUri;
    @Value("${api.servicename.getHospBasisList.ServiceKey}")
    String apiHospBasisListKey;
    @Value("${api.servicename.medicInsttDetailInfoService}")
    String apiHospDetailUri;
    
	@Resource(name="resAnimalPharmacyService") //spring,quartz lifecycle 
	private IResAnimalPharmacyService resAnimalPharmacyService;
	@Resource(name="resPharmInfoService")
	private IResPharmInfoService resPharmInfoService;
	@Resource(name="resPharmDetailService")
	private IResPharmDetailService resPharmDetailService;
	@Resource(name="resKTAddressPharmService")
	private IResKTAddressPharmService resKTAddressPharmService;
	
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
		int allResult = list.size();
		int notFoundresult = 0;
	    for(ResAnimalPharmacyVO vo : list){
	    	ResPharmInfoVO resultPharmInfo = null;
	    	String hospAddresFindUrl = MessageFormat.format(apiHospBasisListUri, apiHospBasisListKey, URLEncoder.encode(vo.getBizplcNm().replaceAll(" ", ""), "UTF-8"), vo.getLat(), vo.getLng());
	    	String hospAddresJson = BatchUtil.readUrl(hospAddresFindUrl);
	    	Object object = BatchUtil.jsonToVOForHosp(hospAddresJson);
	    	if(object==null){
	    		logger.debug(hospAddresFindUrl + " is null");
	    	}else{
		    	if(object instanceof ResHospInfoVO){
		    		ResHospInfoVO hosp = (ResHospInfoVO) object;
	    			if(hosp.getAddr().startsWith("강원") && hosp.getYadmNm().equals(vo.getBizplcNm().replaceAll(" ", ""))){
	    				resultPharmInfo = new ResPharmInfoVO(hosp);
	    			}
	    			else if(hosp.getAddr().equals(vo.getLocplcLotnoAddr())){
	    				resultPharmInfo = new ResPharmInfoVO(hosp);
	    			}
		    	}else if(object instanceof ResultVOForHosp){
		    		List<ResHospInfoVO> hospList = ((ResultVOForHosp) object).getItem();
		    		for(ResHospInfoVO hosp: hospList){
		    			if(hosp.getAddr().startsWith("강원") && hosp.getYadmNm().equals(vo.getBizplcNm().replaceAll(" ", ""))){
		    				resultPharmInfo = new ResPharmInfoVO(hosp);
				    		break;
		    			}
		    			if(hosp.getAddr().equals(vo.getLocplcLotnoAddr())){
		    				resultPharmInfo = new ResPharmInfoVO(hosp);
				    		break;
		    			}
		    		}
		    	}
	    	}
		    if(resultPharmInfo==null){
		    	logger.debug(hospAddresFindUrl + ": correct result is empty");
		    }else{
		    	resultPharmInfo.setNo(vo.getNo());
		    	resPharmInfoService.save(resultPharmInfo);
		    	if(!resultPharmInfo.getYkiho().equals("")){
    		    	String hospDetailFindUrl = MessageFormat.format(apiHospDetailUri, apiHospBasisListKey, resultPharmInfo.getYkiho());
    		    	String hospDetailJson = BatchUtil.readUrl(hospDetailFindUrl);
    		    	ResHospDetailVO detail = BatchUtil.jsonToVOForHospDetail(hospDetailJson);
    		    	if(detail!=null){
    		    		ResPharmDetailVO resultDetail = new ResPharmDetailVO(detail);
    		    		resultDetail.setNo(vo.getNo());
    		    		resPharmDetailService.save(resultDetail);
    		    		logger.debug(hospAddresFindUrl);
    		    		logger.debug(hospDetailFindUrl);
    		    	}
		    	}
		    }
		    if(resultPharmInfo==null){
		    	ResKTAddressPharmVO resultKTInfo = null;
				String addressFindUrl = MessageFormat.format(apiAddressUri, vo.getLat(), vo.getLng(), vo.getBizplcNm());
			    String addressJson = BatchUtil.readUrl(addressFindUrl);
			    Type addressCollectionType = new TypeToken<ResponseVOForAddr>(){}.getType();
			    List<ResultVOForAddr> addrList = BatchUtil.jsonToVOForAddr(addressJson, addrApiServiceName, addressCollectionType);
			    if(addrList==null){
			    	logger.debug(addressFindUrl + " is null");
			    }else{
				    for(ResultVOForAddr addr : addrList){
				    	if(addr.getFieldMap().getAddrNm().startsWith("강원") && addr.getFieldMap().getPubNm().equals(vo.getBizplcNm())){
				    		resultKTInfo = new ResKTAddressPharmVO(addr.getFieldMap());
				    		break;
				    	}
				    	if(addr.getFieldMap().getAddrNm().equals(vo.getLocplcLotnoAddr())){
				    		resultKTInfo = new ResKTAddressPharmVO(addr.getFieldMap());
				    		break;
				    	}
				    }
			    }
			    if(resultKTInfo==null){
			    	logger.debug(addressFindUrl + ": correct result is empty");
			    	notFoundresult++;
			    }else{
			    	resultKTInfo.setNo(vo.getNo());
			    	resKTAddressPharmService.save(resultKTInfo);
			    }
		    }
	    	resAnimalPharmacyService.saveResAnimalPharmacyVO(vo);
	    }
		end = System.currentTimeMillis(); 
		logger.info("animalPharmacyBatchFinished: "+ dayTime.format(new Date(end)));
		logger.info("animalPharmacyBatchProceed: "+ (end-start)/1000 +" seconds");
		logger.info("animalPharmacyBatchNotFoundResult: "+ notFoundresult +" / "+allResult);
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
