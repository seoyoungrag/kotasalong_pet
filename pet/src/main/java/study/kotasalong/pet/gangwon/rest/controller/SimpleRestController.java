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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import study.kotasalong.pet.gangwon.batch.common.DistanceUtil;
import study.kotasalong.pet.gangwon.batch.common.ResponseData;
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
import study.kotasalong.pet.gangwon.batch.vo.ResHospDetailVO;
import study.kotasalong.pet.gangwon.batch.vo.ResHospInfoVO;
import study.kotasalong.pet.gangwon.batch.vo.ResKTAddressClinicVO;
import study.kotasalong.pet.gangwon.batch.vo.ResKTAddressPharmVO;
import study.kotasalong.pet.gangwon.batch.vo.ResPharmDetailVO;
import study.kotasalong.pet.gangwon.batch.vo.ResPharmInfoVO;
import study.kotasalong.pet.gangwon.rest.JQGridVO;
import study.kotasalong.pet.gangwon.rest.PagingVO;
import study.kotasalong.pet.gangwon.rest.RestResponseVO;

/**
 * @FileName : RestController.java
 * @Project : batch
 * @Date : 2017. 8. 27. @�ۼ��� : yrseo @�����̷� : @���α׷� ���� :
 */

@RestController
public class SimpleRestController {

	@Resource(name = "resAnimalClinicService")
	private IResAnimalClinicService resAnimalClinicService;
	@Resource(name = "resAnimalPharmacyService")
	private IResAnimalPharmacyService resAnimalPharmacyService;
	@Resource(name = "resHospInfoService")
	private IResHospInfoService resHospInfoService;
	@Resource(name = "resHospDetailService")
	private IResHospDetailService resHospDetailService;
	@Resource(name = "resKTAddressClinicService")
	private IResKTAddressClinicService resKTAddressClinicService;
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

	@RequestMapping(value = "pet/gangwon/animalClinic", method = RequestMethod.GET)
	public RestResponseVO getAnimalClinicListAll(
			HttpServletRequest req,
			@RequestParam(value = "listType", required = false) String listType,
			@RequestParam(value = "lat", required = false) String lat,
			@RequestParam(value = "lng", required = false) String lng) {
		RestResponseVO res = new RestResponseVO();
		List<ResAnimalClinicVO> resAnimalClinicVOList = new ArrayList<ResAnimalClinicVO>();
		List<ResHospInfoVO> resHospInfoVOList = new ArrayList<ResHospInfoVO>();
		List<ResHospDetailVO> resHospDetailVOList = new ArrayList<ResHospDetailVO>();
		List<ResKTAddressClinicVO> resKTAddressClinicVOList = new ArrayList<ResKTAddressClinicVO>();
		List<ResAnimalClinicEditedVO> resKTAddressClinicEdtiedVOList = new ArrayList<ResAnimalClinicEditedVO>();
		List<ResponseData> dataList = new ArrayList<ResponseData>();

		try {
			resAnimalClinicVOList = resAnimalClinicService.findAllResAnimalClinicVOs();
			resHospInfoVOList = resHospInfoService.findAll();
			resHospDetailVOList = resHospDetailService.findAll();
			resKTAddressClinicVOList = resKTAddressClinicService.findAll();
			resKTAddressClinicEdtiedVOList = resAnimalClinicEditService.findAllResAnimalClinicEditedVOs();
			for (ResAnimalClinicVO vo : resAnimalClinicVOList) {
				ResponseData data = new ResponseData();
				dataList.add(data);
				data.setNo(vo.getNo());
				data.setBizplcNm(vo.getBizplcNm());
				data.setLat(vo.getLat());
				data.setLng(vo.getLng());
				data.setLocplcLotnoAddr(vo.getLocplcLotnoAddr());
				data.setLocplcRoadnmAddr(vo.getLoplcRoadnmAddr());
				if (!isBlank(lat) && !isBlank(lng) && !isBlank(vo.getLat()) && !isBlank(vo.getLng())) {
					double lat1 = Double.valueOf(lat).doubleValue();
					double lng1 = Double.valueOf(lng).doubleValue();
					double lng2 = Double.valueOf(vo.getLng()).doubleValue();
					double lat2 = Double.valueOf(vo.getLat()).doubleValue();
					double distanceMeter = DistanceUtil.distance(lat1, lng1, lat2, lng2, "meter");
					data.setDistance(distanceMeter);
				}
				for (ResHospInfoVO info : resHospInfoVOList) {
					if (vo.getNo() == info.getNo()) {
						vo.setHospInfo(info);
						data.setTelno(info.getTelno());
						break;
					}
				}
				for (ResHospDetailVO detail : resHospDetailVOList) {
					if (vo.getNo() == detail.getNo()) {
						vo.setHospDetail(detail);
						data.setNoTrmtHoli(detail.getNoTrmtHoli());
						data.setNoTrmtSun(detail.getNoTrmtSun());
						data.setParkEtc(detail.getParkEtc());
						data.setTrmtMonStart(detail.getTrmtMonStart());
						data.setTrmtMonEnd(detail.getTrmtMonEnd());
						data.setTrmtSatStart(detail.getTrmtSatStart());
						data.setTrmtSatEnd(detail.getTrmtSatEnd());
						break;
					}

				}
				for (ResKTAddressClinicVO kt : resKTAddressClinicVOList) {
					if (vo.getNo() == kt.getNo()) {
						vo.setKtInfo(kt);
						if (data.getTelno() == null) {
							data.setTelno(kt.getMainNum());
						}
						break;
					}

				}
				for (ResAnimalClinicEditedVO edit : resKTAddressClinicEdtiedVOList) {
					if (vo.getNo() == edit.getNo()) {
						data.setNo(edit.getNo());
						data.setBizplcNm(edit.getBizplcNm());
						data.setLat(edit.getLat());
						data.setLng(edit.getLng());
						data.setLocplcLotnoAddr(edit.getLocplcLotnoAddr());
						data.setLocplcRoadnmAddr(edit.getLocplcRoadnmAddr());
						if (!isBlank(lat) && !isBlank(lng) && !isBlank(edit.getLat()) && !isBlank(edit.getLng())) {
							double lat1 = Double.valueOf(lat).doubleValue();
							double lng1 = Double.valueOf(lng).doubleValue();
							double lng2 = Double.valueOf(edit.getLng()).doubleValue();
							double lat2 = Double.valueOf(edit.getLat()).doubleValue();
							double distanceMeter = DistanceUtil.distance(lat1, lng1, lat2, lng2, "meter");
							data.setDistance(distanceMeter);
						}
						break;
					}
				}
			}
		} catch (Exception e) {
			res = new RestResponseVO(RestResponseVO.R_CODE_FAIL, RestResponseVO.R_MSG_FAIL, null);
			e.printStackTrace();
		}
		// res.setData(resAnimalClinicVOList);
		ResponseDataAscending ascending = new ResponseDataAscending();
		Collections.sort(dataList, ascending);

		if(listType!=null && listType.equals("jqgrid")){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setPaging(req);

			JQGridVO<ResponseData> jqGridData = new JQGridVO<ResponseData>();
			long totalCnt = dataList.size();
			pagingVO.setListCount(totalCnt);

			jqGridData.setPage(pagingVO.getPage());
			jqGridData.setTotal(String.valueOf(totalCnt));
			jqGridData.setRecords(String.valueOf(pagingVO.getListCount()));
			jqGridData.setRows(dataList);
			res.setData(jqGridData);
		}else{
			res.setData(dataList);
		}
		return res;
	}

	@RequestMapping(value = "pet/gangwon/animalPharmacy", method = RequestMethod.GET)
	public RestResponseVO getAnimalPharmacyListAll(
			HttpServletRequest req,
			@RequestParam(value = "listType", required = false) String listType,
			@RequestParam(value = "lat", required = false) String lat,
			@RequestParam(value = "lng", required = false) String lng) {
		RestResponseVO res = new RestResponseVO();
		List<ResAnimalPharmacyVO> resAnimalClinicVOList = new ArrayList<ResAnimalPharmacyVO>();
		List<ResPharmInfoVO> resPharmInfoVOList = new ArrayList<ResPharmInfoVO>();
		List<ResPharmDetailVO> resPharmDetailVOList = new ArrayList<ResPharmDetailVO>();
		List<ResKTAddressPharmVO> resKTAddressPharmVOList = new ArrayList<ResKTAddressPharmVO>();
		List<ResponseData> dataList = new ArrayList<ResponseData>();
		List<ResAnimalPharmacyEditedVO> resKTAddressPharmacyEdtiedVOList = new ArrayList<ResAnimalPharmacyEditedVO>();
		
		try {
			resAnimalClinicVOList = resAnimalPharmacyService.findAllResAnimalPharmacyVOs();
			resPharmInfoVOList = resPharmInfoService.findAll();
			resPharmDetailVOList = resPharmDetailService.findAll();
			resKTAddressPharmVOList = resKTAddressPharmService.findAll();
			resKTAddressPharmacyEdtiedVOList = resAnimalPharmacyEditService.findAllResAnimalPharmacyEditedVOs();
			for (ResAnimalPharmacyVO vo : resAnimalClinicVOList) {
				ResponseData data = new ResponseData();
				dataList.add(data);
				data.setNo(vo.getNo());
				data.setBizplcNm(vo.getBizplcNm());
				data.setLat(vo.getLat());
				data.setLng(vo.getLng());
				data.setLocplcLotnoAddr(vo.getLocplcLotnoAddr());
				data.setLocplcRoadnmAddr(vo.getLocplcRoadnmAddr());
				if (!isBlank(lat) && !isBlank(lng) && !isBlank(vo.getLat()) && !isBlank(vo.getLng())) {
					double lat1 = Double.valueOf(lat).doubleValue();
					double lng1 = Double.valueOf(lng).doubleValue();
					double lng2 = Double.valueOf(vo.getLng()).doubleValue();
					double lat2 = Double.valueOf(vo.getLat()).doubleValue();
					double distanceMeter = DistanceUtil.distance(lat1, lng1, lat2, lng2, "meter");
					data.setDistance(distanceMeter);
				}
				for (ResPharmInfoVO info : resPharmInfoVOList) {
					if (vo.getNo() == info.getNo()) {
						vo.setPharmInfo(info);
						data.setTelno(info.getTelno());
						break;
					}
				}
				for (ResPharmDetailVO detail : resPharmDetailVOList) {
					if (vo.getNo() == detail.getNo()) {
						vo.setPharmDetail(detail);
						data.setNoTrmtHoli(detail.getNoTrmtHoli());
						data.setNoTrmtSun(detail.getNoTrmtSun());
						data.setParkEtc(detail.getParkEtc());
						data.setTrmtMonStart(detail.getTrmtMonStart());
						data.setTrmtMonEnd(detail.getTrmtMonEnd());
						data.setTrmtSatStart(detail.getTrmtSatStart());
						data.setTrmtSatEnd(detail.getTrmtSatEnd());
						break;
					}

				}
				for (ResKTAddressPharmVO kt : resKTAddressPharmVOList) {
					if (vo.getNo() == kt.getNo()) {
						vo.setKtInfo(kt);
						if (data.getTelno() == null) {
							data.setTelno(kt.getMainNum());
						}
						break;
					}
				}
				for (ResAnimalPharmacyEditedVO edit : resKTAddressPharmacyEdtiedVOList) {
					if (vo.getNo() == edit.getNo()) {
						data.setNo(edit.getNo());
						data.setBizplcNm(edit.getBizplcNm());
						data.setLat(edit.getLat());
						data.setLng(edit.getLng());
						data.setLocplcLotnoAddr(edit.getLocplcLotnoAddr());
						data.setLocplcRoadnmAddr(edit.getLocplcRoadnmAddr());
						if (!isBlank(lat) && !isBlank(lng) && !isBlank(edit.getLat()) && !isBlank(edit.getLng())) {
							double lat1 = Double.valueOf(lat).doubleValue();
							double lng1 = Double.valueOf(lng).doubleValue();
							double lng2 = Double.valueOf(edit.getLng()).doubleValue();
							double lat2 = Double.valueOf(edit.getLat()).doubleValue();
							double distanceMeter = DistanceUtil.distance(lat1, lng1, lat2, lng2, "meter");
							data.setDistance(distanceMeter);
						}
						break;
					}
				}
			}
		} catch (Exception e) {
			res = new RestResponseVO(RestResponseVO.R_CODE_FAIL, RestResponseVO.R_MSG_FAIL, null);
			e.printStackTrace();
		}
		// res.setData(resAnimalClinicVOList);
		ResponseDataAscending ascending = new ResponseDataAscending();
		Collections.sort(dataList, ascending);
		if(listType!=null && listType.equals("jqgrid")){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setPaging(req);

			JQGridVO<ResponseData> jqGridData = new JQGridVO<ResponseData>();
			long totalCnt = dataList.size();
			pagingVO.setListCount(totalCnt);

			jqGridData.setPage(pagingVO.getPage());
			jqGridData.setTotal(String.valueOf(totalCnt));
			jqGridData.setRecords(String.valueOf(pagingVO.getListCount()));
			jqGridData.setRows(dataList);
			res.setData(jqGridData);
		}else{
			res.setData(dataList);
		}
		return res;
	}

	@RequestMapping(value = "pet/gangwon/animalPension", method = RequestMethod.GET)
	public RestResponseVO getAnimalPensionListAll(
			HttpServletRequest req,
			@RequestParam(value = "listType", required = false) String listType,
			@RequestParam(value = "lat", required = false) String lat,
			@RequestParam(value = "lng", required = false) String lng) {
		RestResponseVO res = new RestResponseVO();
		List<AnimalPensionVO> animalPensionVOList = new ArrayList<AnimalPensionVO>();
		try {
			animalPensionVOList = animalPensionService.findAllAnimalPensionVOs();
			for (AnimalPensionVO vo : animalPensionVOList) {
				if (!isBlank(lat) && !isBlank(lng) && !isBlank(vo.getLat()) && !isBlank(vo.getLng())) {
					double lat1 = Double.valueOf(lat).doubleValue();
					double lng1 = Double.valueOf(lng).doubleValue();
					double lng2 = Double.valueOf(vo.getLng()).doubleValue();
					double lat2 = Double.valueOf(vo.getLat()).doubleValue();
					double distanceMeter = DistanceUtil.distance(lat1, lng1, lat2, lng2, "meter");
					vo.setDistance(distanceMeter);
				}
			}
		} catch (Exception e) {
			res = new RestResponseVO(RestResponseVO.R_CODE_FAIL, RestResponseVO.R_MSG_FAIL, null);
			e.printStackTrace();
		}
		AnimalPensionVOAscending ascending = new AnimalPensionVOAscending();
		Collections.sort(animalPensionVOList, ascending);

		if(listType!=null && listType.equals("jqgrid")){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setPaging(req);

			JQGridVO<AnimalPensionVO> jqGridData = new JQGridVO<AnimalPensionVO>();
			long totalCnt = animalPensionVOList.size();
			pagingVO.setListCount(totalCnt);

			jqGridData.setPage(pagingVO.getPage());
			jqGridData.setTotal(String.valueOf(totalCnt));
			jqGridData.setRecords(String.valueOf(pagingVO.getListCount()));
			jqGridData.setRows(animalPensionVOList);
			res.setData(jqGridData);
		}else{
			res.setData(animalPensionVOList);
		}
		return res;
	}

	private boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
}

class AnimalPensionVOAscending implements Comparator<AnimalPensionVO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(AnimalPensionVO o1, AnimalPensionVO o2) {
		double firstValue = o1.getDistance();
		double secondValue = o2.getDistance();
		if (firstValue == 0.0) {
			firstValue = 9999999.9;
		}
		if (secondValue == 0.0) {
			secondValue = 9999999.9;
		}
		if (firstValue > secondValue) {
			return 1;
		} else if (firstValue < secondValue) {
			return -1;
		} else {
			return 0;
		}
	}

}

class ResponseDataAscending implements Comparator<ResponseData> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(ResponseData o1, ResponseData o2) {
		double firstValue = o1.getDistance();
		double secondValue = o2.getDistance();
		if (firstValue == 0.0) {
			firstValue = 9999999.9;
		}
		if (secondValue == 0.0) {
			secondValue = 9999999.9;
		}
		if (firstValue > secondValue) {
			return 1;
		} else if (firstValue < secondValue) {
			return -1;
		} else {
			return 0;
		}
	}

}
