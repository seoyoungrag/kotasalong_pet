/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : RestController.java
 * 2. Package : study.kotasalong.pet.gangwon.rest.controller
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 11:18:37
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
 */
package study.kotasalong.pet.gangwon.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import study.kotasalong.pet.gangwon.batch.service.IResAnimalClinicService;
import study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService;
import study.kotasalong.pet.gangwon.batch.service.IResHospDetailService;
import study.kotasalong.pet.gangwon.batch.service.IResHospInfoService;
import study.kotasalong.pet.gangwon.batch.service.IResKTAddressClinicService;
import study.kotasalong.pet.gangwon.batch.service.IResKTAddressPharmService;
import study.kotasalong.pet.gangwon.batch.service.IResPharmDetailService;
import study.kotasalong.pet.gangwon.batch.service.IResPharmInfoService;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicVO;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyVO;
import study.kotasalong.pet.gangwon.batch.vo.ResHospDetailVO;
import study.kotasalong.pet.gangwon.batch.vo.ResHospInfoVO;
import study.kotasalong.pet.gangwon.batch.vo.ResKTAddressClinicVO;
import study.kotasalong.pet.gangwon.batch.vo.ResKTAddressPharmVO;
import study.kotasalong.pet.gangwon.batch.vo.ResPharmDetailVO;
import study.kotasalong.pet.gangwon.batch.vo.ResPharmInfoVO;
import study.kotasalong.pet.gangwon.rest.RestResponseVO;

/** 
* @FileName      : RestController.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

@RestController
public class SimpleRestController {

	@Resource(name="resAnimalClinicService") 
	private IResAnimalClinicService resAnimalClinicService;
	@Resource(name="resAnimalPharmacyService") 
	private IResAnimalPharmacyService resAnimalPharmacyService;
	@Resource(name="resHospInfoService")  
	private IResHospInfoService resHospInfoService;
	@Resource(name="resHospDetailService")  
	private IResHospDetailService resHospDetailService;
	@Resource(name="resKTAddressClinicService")  
	private IResKTAddressClinicService resKTAddressClinicService;
	@Resource(name="resPharmInfoService")
	private IResPharmInfoService resPharmInfoService;
	@Resource(name="resPharmDetailService")
	private IResPharmDetailService resPharmDetailService;
	@Resource(name="resKTAddressPharmService")
	private IResKTAddressPharmService resKTAddressPharmService;

	@RequestMapping(value = "pet/gangwon/animalClinic", method = RequestMethod.GET)
	public RestResponseVO getAnimalClinicListAll() {
		RestResponseVO res = new RestResponseVO();
		List<ResAnimalClinicVO> resAnimalClinicVOList = new ArrayList<ResAnimalClinicVO>();
		List<ResHospInfoVO> resHospInfoVOList = new ArrayList<ResHospInfoVO>();
		List<ResHospDetailVO> resHospDetailVOList = new ArrayList<ResHospDetailVO>();
		List<ResKTAddressClinicVO> resKTAddressClinicVOList = new ArrayList<ResKTAddressClinicVO>();
		try {
			resAnimalClinicVOList = resAnimalClinicService.findAllResAnimalClinicVOs();
			resHospInfoVOList = resHospInfoService.findAll();
			resHospDetailVOList = resHospDetailService.findAll();
			resKTAddressClinicVOList = resKTAddressClinicService.findAll();
			for(ResAnimalClinicVO vo : resAnimalClinicVOList){
				for(ResHospInfoVO info : resHospInfoVOList){
					if(vo.getNo()==info.getNo()){
						vo.setHospInfo(info);
						break;
					}
				}
				for(ResHospDetailVO detail : resHospDetailVOList){
					if(vo.getNo()==detail.getNo()){
						vo.setHospDetail(detail);
						break;
					}
					
				}
				for(ResKTAddressClinicVO kt : resKTAddressClinicVOList){
					if(vo.getNo()==kt.getNo()){
						vo.setKtInfo(kt);
						break;
					}
					
				}
			}
		} catch (Exception e) {
			res = new RestResponseVO(RestResponseVO.R_CODE_FAIL,RestResponseVO.R_MSG_FAIL,null);
			e.printStackTrace();
		}
		res.setData(resAnimalClinicVOList);
		return res;
	}

	@RequestMapping(value = "pet/gangwon/animalPharmacy", method = RequestMethod.GET)
	public RestResponseVO getAnimalPharmacyListAll() {
		RestResponseVO res = new RestResponseVO();
		List<ResAnimalPharmacyVO> resAnimalClinicVOList = new ArrayList<ResAnimalPharmacyVO>();
		List<ResPharmInfoVO> resPharmInfoVOList = new ArrayList<ResPharmInfoVO>();
		List<ResPharmDetailVO> resPharmDetailVOList = new ArrayList<ResPharmDetailVO>();
		List<ResKTAddressPharmVO> resKTAddressPharmVOList = new ArrayList<ResKTAddressPharmVO>();
		try {
			resAnimalClinicVOList = resAnimalPharmacyService.findAllResAnimalPharmacyVOs();
			resPharmInfoVOList = resPharmInfoService.findAll();
			resPharmDetailVOList = resPharmDetailService.findAll();
			resKTAddressPharmVOList = resKTAddressPharmService.findAll();
			for(ResAnimalPharmacyVO vo : resAnimalClinicVOList){
				for(ResPharmInfoVO info : resPharmInfoVOList){
					if(vo.getNo()==info.getNo()){
						vo.setPharmInfo(info);
						break;
					}
				}
				for(ResPharmDetailVO detail : resPharmDetailVOList){
					if(vo.getNo()==detail.getNo()){
						vo.setPharmDetail(detail);
						break;
					}
					
				}
				for(ResKTAddressPharmVO kt : resKTAddressPharmVOList){
					if(vo.getNo()==kt.getNo()){
						vo.setKtInfo(kt);
						break;
					}
					
				}
			}
		} catch (Exception e) {
			res = new RestResponseVO(RestResponseVO.R_CODE_FAIL,RestResponseVO.R_MSG_FAIL,null);
			e.printStackTrace();
		}
		res.setData(resAnimalClinicVOList);
		return res;
	}
}
