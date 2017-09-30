/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : AdminController.java
 * 2. Package : study.kotasalong.pet.gangwon.rest.controller
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 29. 오후 11:23:08
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 29. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.rest.controller;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import study.kotasalong.pet.gangwon.batch.service.IAnimalPensionService;
import study.kotasalong.pet.gangwon.batch.service.IResAnimalClinicEditService;
import study.kotasalong.pet.gangwon.batch.service.IResAnimalClinicService;
import study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyEditService;
import study.kotasalong.pet.gangwon.batch.service.IResAnimalPharmacyService;
import study.kotasalong.pet.gangwon.batch.service.IResHospDetailService;
import study.kotasalong.pet.gangwon.batch.service.IResHospInfoService;
import study.kotasalong.pet.gangwon.batch.service.IResKTAddressClinicService;
import study.kotasalong.pet.gangwon.batch.service.IResKTAddressPharmService;
import study.kotasalong.pet.gangwon.batch.service.IResPharmDetailService;
import study.kotasalong.pet.gangwon.batch.service.IResPharmInfoService;
import study.kotasalong.pet.gangwon.batch.vo.AnimalPensionVO;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicEditedVO;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicVO;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyEditedVO;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyVO;
import study.kotasalong.pet.gangwon.rest.RestResponseVO;

/** 
* @FileName      : AdminController.java 
* @Project     : pet 
* @Date        : 2017. 9. 29. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/
@RestController
public class AdminController {

	@Resource(name = "resAnimalClinicService")
	private IResAnimalClinicService resAnimalClinicService;
	@Resource(name = "resHospInfoService")
	private IResHospInfoService resHospInfoService;
	@Resource(name = "resHospDetailService")
	private IResHospDetailService resHospDetailService;
	@Resource(name = "resKTAddressClinicService")
	private IResKTAddressClinicService resKTAddressClinicService;
	@Resource(name = "resAnimalPharmacyService")
	private IResAnimalPharmacyService resAnimalPharmacyService;
	@Resource(name = "resPharmInfoService")
	private IResPharmInfoService resPharmInfoService;
	@Resource(name = "resPharmDetailService")
	private IResPharmDetailService resPharmDetailService;
	@Resource(name = "resKTAddressPharmService")
	private IResKTAddressPharmService resKTAddressPharmService;
	@Resource(name = "animalPensionService")
	private IAnimalPensionService animalPensionService;
	@Resource(name = "resAnimalClinicEditService")
	private IResAnimalClinicEditService resAnimalClinicEditService;
	@Resource(name = "resAnimalPharmacyEditService")
	private IResAnimalPharmacyEditService resAnimalPharmacyEditService;
	
	@RequestMapping(value = "pet/gangwon/clinic", method = RequestMethod.GET)
	public ModelAndView clinicList() {
		ModelAndView mav = new ModelAndView("animalClinicEdited");
		return mav;
	}

	@RequestMapping(value = "pet/gangwon/clinic/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponseVO clinicUpdate(ResAnimalClinicEditedVO vo, String oper) {
		RestResponseVO res = new RestResponseVO();
		if(oper.equals("edit")){
			resAnimalClinicEditService.saveResAnimalClinicEditedVO(vo);
		}else if(oper.equals("add")){
			vo.setNo(resAnimalClinicService.getMaxNo());
			ResAnimalClinicVO ravo = new ResAnimalClinicVO(vo);
			resAnimalClinicService.saveResAnimalClinicVO(ravo);
			vo.setNo(ravo.getNo());
		}else if(oper.equals("del")){
			int no = vo.getNo();
			try{
				resAnimalClinicService.deleteResAnimalClinicVOByNo(no);
				resAnimalClinicEditService.deleteResAnimalClinicEditedVOByNo(no);
				resHospInfoService.deleteByNo(no);
				resHospDetailService.deleteByNo(no);
				resKTAddressClinicService.deleteByNo(no);
			}catch(Exception e){
				
			}
		}
		res.setData(vo);	
		return res;
	}

	@RequestMapping(value = "pet/gangwon/pharmacy/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponseVO pharmacyUpdate(ResAnimalPharmacyEditedVO vo, String oper) {
		RestResponseVO res = new RestResponseVO();
		if(oper.equals("edit")){
			resAnimalPharmacyEditService.saveResAnimalPharmacyEditedVO(vo);
		}else if(oper.equals("add")){
			vo.setNo(resAnimalPharmacyService.getMaxNo());
			ResAnimalPharmacyVO ravo = new ResAnimalPharmacyVO(vo);
			resAnimalPharmacyService.saveResAnimalPharmacyVO(ravo);
			vo.setNo(ravo.getNo());
		}else if(oper.equals("del")){
			int no = vo.getNo();
			try{
				resAnimalPharmacyService.deleteResAnimalPharmacyVOByNo(no);
				resAnimalPharmacyEditService.deleteResAnimalPharmacyEditedVOByNo(no);
				resPharmInfoService.deleteByNo(no);
				resPharmDetailService.deleteByNo(no);
				resKTAddressPharmService.deleteByNo(no);
			}catch(Exception e){
				
			}
		}
		res.setData(vo);
		return res;
	}
	@RequestMapping(value = "pet/gangwon/pension/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponseVO pensionUpdate(AnimalPensionVO vo, String oper) {
		RestResponseVO res = new RestResponseVO();
		if(oper.equals("edit")){
			animalPensionService.updateAnimalPensionVO(vo);
		}else if(oper.equals("add")){
			vo.setNo(animalPensionService.getMaxNo());
			AnimalPensionVO ravo = new AnimalPensionVO(vo);
			animalPensionService.saveAnimalPensionVO(ravo);
			vo.setNo(ravo.getNo());
		}else if(oper.equals("del")){
			int no = vo.getNo();
			try{
				animalPensionService.deleteAnimalPensionVOByNo(no);
			}catch(Exception e){
				
			}
		}
		res.setData(vo);
		return res;
	}
	@RequestMapping(value = "pet/gangwon/admin/facility/edit", method = RequestMethod.GET)
	public ModelAndView adminEdit(
			@RequestParam(value = "type", required = true, defaultValue = "clinic") String type) {
		ModelAndView mav = new ModelAndView("admin/edit");
		mav.addObject("type", type);
		return mav;
	}

	@RequestMapping(value = "pet/gangwon/admin/main.do")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView("admin/main");
		return mav;
	}
}
