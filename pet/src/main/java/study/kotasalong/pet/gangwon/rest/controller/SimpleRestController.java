/**
 * 0. Project  : ������ �� â�� ������Ʈ
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
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalClinicVO;
import study.kotasalong.pet.gangwon.batch.vo.ResAnimalPharmacyVO;
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

	@RequestMapping(value = "pet/gangwon/animalClinic", method = RequestMethod.GET)
	public RestResponseVO getAnimalClinicListAll() {
		RestResponseVO res = new RestResponseVO();
		List<ResAnimalClinicVO> resAnimalClinicVOList = new ArrayList<ResAnimalClinicVO>();
		try {
			resAnimalClinicVOList = resAnimalClinicService.findAllResAnimalClinicVOs();
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
		try {
			resAnimalClinicVOList = resAnimalPharmacyService.findAllResAnimalPharmacyVOs();
		} catch (Exception e) {
			res = new RestResponseVO(RestResponseVO.R_CODE_FAIL,RestResponseVO.R_MSG_FAIL,null);
			e.printStackTrace();
		}
		res.setData(resAnimalClinicVOList);
		return res;
	}
}
