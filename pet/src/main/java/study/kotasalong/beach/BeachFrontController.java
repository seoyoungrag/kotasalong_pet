/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : FrontController.java
 * 2. Package : study.kotasalong.beach
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 10. 5. 오후 7:17:17
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 10. 5. :            : 신규 개발.
 */
package study.kotasalong.beach;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import study.kotasalong.pet.gangwon.rest.JQGridVO;
import study.kotasalong.pet.gangwon.rest.PagingVO;
import study.kotasalong.pet.gangwon.rest.RestResponseVO;

/** 
* @FileName      : FrontController.java 
* @Project     : pet 
* @Date        : 2017. 10. 5. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

@RestController
public class BeachFrontController {

	@Resource(name="beachDao")  
	private BeachDao beachDao;
	
	@RequestMapping(value = "kotasalong/beach/jqgridSubTable.do", method = RequestMethod.GET)
	public ModelAndView jqgridSubTable(
			@RequestParam(value = "no", required = false) int no) {
		ModelAndView mav = new ModelAndView("beach/pages/jqgridSubTable");
		List<BeachVO> beachList = new ArrayList<BeachVO>();
		BeachKohaVO vo = new BeachKohaVO();
		CustomBeachVO cvo = new CustomBeachVO();
		try {
			vo = beachDao.findBeachKohaVOByNo(no);
			beachList = beachDao.findAllBeachVOs();
			cvo.setNo(no);
			cvo.setTitle(vo.getNm());
			cvo.setMapx(vo.getXcnts());
			cvo.setMapy(vo.getYdnts());
			cvo.setAddr1(vo.getAddr());
			if(vo.getPhoto_no()==null){
				for(BeachVO tvo : beachList){
					if(tvo.getTitle().startsWith(vo.getNm().substring(0,2))){
						if(tvo.getFirstimage2()!=null){
							cvo.setFirstimage2(tvo.getFirstimage2());
						}
						if(tvo.getFirstimage()!=null){
							cvo.setFirstimage(tvo.getFirstimage());
						}
						break;
					}
				}
			}else{
				cvo.setFirstimage("http://www.khoa.go.kr/oceanmap/gallery/otms/해양레저관광/해수욕장/Thumbnail/TN_"+vo.getPhoto_no());
			}
			cvo.setFacilities(vo.getFacilities());
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("beachVO",cvo);
		return mav;
	}

	@RequestMapping(value = "kotasalong/beach/map.do")
	public ModelAndView map(
			@RequestParam(value = "type", required = false, defaultValue = "beach") String type){
		ModelAndView mav = new ModelAndView("beach/pages/map");
		mav.addObject("type", type);
		return mav;
	}
	
	@RequestMapping(value = "kotasalong/beach/main.do")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView("beach/pages/index");
		return mav;
	}

	@RequestMapping(value = "kotasalong/beach/table.do")
	public ModelAndView table() {
		ModelAndView mav = new ModelAndView("beach/pages/table");
		return mav;
	}

	@RequestMapping(value = "kotasalong/beach/test.do")
	public ModelAndView test(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("beach/pages/test");
		StringBuffer requestURL = request.getRequestURL();
		if (request.getQueryString() != null) {
		    requestURL.append("?").append(request.getQueryString());
		}
		String completeURL = requestURL.toString();
		String apiKey = "";
		System.out.println("-----------------------");
		System.out.println(completeURL);
		if(completeURL.startsWith("http://localhost")||completeURL.startsWith("https://localhost")){
			apiKey = "588FDED8-ACD5-3F28-A9A2-8331A3D6480E";
		}else if(completeURL.startsWith("http://127.0.0.1")||completeURL.startsWith("https://127.0.0.1")){
			apiKey = "588FDED8-ACD5-3F28-A9A2-8331A3D6480E";
		}else if(completeURL.startsWith("http://10.0.2.2")||completeURL.startsWith("https://10.0.2.2")){
			apiKey = "E09D58DA-97DF-38F4-869E-F8A3AE1CE834";
		}else if(completeURL.startsWith("http://truezure.cafe24.com/")){
			apiKey = "40528A32-2569-3B8C-8B01-1414F37AF70B";
		}else if(completeURL.startsWith("https://truezure.cafe24.com/")){
			apiKey = "B58D79AE-EEB6-37CD-B883-30C010970295";
		}
		mav.addObject("apiKey",apiKey);
		return mav;
	}
	
	@RequestMapping(value = "kotasalong/beach", method = RequestMethod.GET)
	public RestResponseVO getBeachList(
			HttpServletRequest req,
			@RequestParam(value = "listType", required = false) String listType,
			@RequestParam(value = "lat", required = false) String lat,
			@RequestParam(value = "lng", required = false) String lng) {
		RestResponseVO res = new RestResponseVO();
		List<BeachVO> beachList = new ArrayList<BeachVO>();
		List<BeachKohaVO> beachKohaList = new ArrayList<BeachKohaVO>();
		List<CustomBeachVO> customBeachList = new ArrayList<CustomBeachVO>();
		try {
			beachList = beachDao.findAllBeachVOs();
			beachKohaList = beachDao.findAllBeachKohaVOs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(BeachKohaVO vo : beachKohaList){
			CustomBeachVO cvo = new CustomBeachVO();
			cvo.setNo(vo.getNo());
			cvo.setTitle(vo.getNm());
			cvo.setMapx(vo.getXcnts());
			cvo.setMapy(vo.getYdnts());
			cvo.setAddr1(vo.getAddr());
			if(vo.getPhoto_no()==null){
				for(BeachVO tvo : beachList){
					if(tvo.getTitle().startsWith(vo.getNm().substring(0,2))){
						if(tvo.getFirstimage2()!=null){
							cvo.setFirstimage2(tvo.getFirstimage2());
						}
						if(tvo.getFirstimage()!=null){
							cvo.setFirstimage(tvo.getFirstimage());
						}
						break;
					}
				}
			}else{
				cvo.setFirstimage("http://www.khoa.go.kr/oceanmap/gallery/otms/"+vo.getPpath()+"Thumbnail/TN_"+vo.getPhoto_no());
			}
			cvo.setFacilities(vo.getFacilities());
			customBeachList.add(cvo);
		}
		if(listType!=null && listType.equals("jqgrid")){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setPaging(req);

			JQGridVO<CustomBeachVO> jqGridData = new JQGridVO<CustomBeachVO>();
			long totalCnt = customBeachList.size();
			pagingVO.setListCount(totalCnt);

			jqGridData.setPage(pagingVO.getPage());
			jqGridData.setTotal(String.valueOf(totalCnt));
			jqGridData.setRecords(String.valueOf(pagingVO.getListCount()));
			jqGridData.setRows(customBeachList);
			res.setData(jqGridData);
		}else{
			res.setData(customBeachList);
		}
		return res;
	}
	

	@RequestMapping(value = "kotasalong/camp", method = RequestMethod.GET)
	public RestResponseVO getCampList(
			HttpServletRequest req,
			@RequestParam(value = "listType", required = false) String listType,
			@RequestParam(value = "lat", required = false) String lat,
			@RequestParam(value = "lng", required = false) String lng) {
		RestResponseVO res = new RestResponseVO();
		List<CampKohaVO> voList = new ArrayList<CampKohaVO>();
		List<CustomBeachVO> customBeachList = new ArrayList<CustomBeachVO>();
		try {
			voList = beachDao.findAllCampKohaVOs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(CampKohaVO vo : voList){
			CustomBeachVO cvo = new CustomBeachVO();
			cvo.setNo(vo.getNo());
			cvo.setTitle(vo.getNm());
			cvo.setMapx(vo.getXcnts());
			cvo.setMapy(vo.getYdnts());
			cvo.setAddr1(vo.getAddr());
			if(vo.getPhoto_no()!=null){
				cvo.setFirstimage("http://www.khoa.go.kr/oceanmap/gallery/otms/"+vo.getPpath()+"Thumbnail/TN_"+vo.getPhoto_no());
			}
			cvo.setFacilities(vo.getFacilities());
			customBeachList.add(cvo);
		}
		if(listType!=null && listType.equals("jqgrid")){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setPaging(req);

			JQGridVO<CustomBeachVO> jqGridData = new JQGridVO<CustomBeachVO>();
			long totalCnt = customBeachList.size();
			pagingVO.setListCount(totalCnt);

			jqGridData.setPage(pagingVO.getPage());
			jqGridData.setTotal(String.valueOf(totalCnt));
			jqGridData.setRecords(String.valueOf(pagingVO.getListCount()));
			jqGridData.setRows(customBeachList);
			res.setData(jqGridData);
		}else{
			res.setData(customBeachList);
		}
		return res;
	}

	@RequestMapping(value = "kotasalong/festival", method = RequestMethod.GET)
	public RestResponseVO getFestivalList(
			HttpServletRequest req,
			@RequestParam(value = "listType", required = false) String listType,
			@RequestParam(value = "lat", required = false) String lat,
			@RequestParam(value = "lng", required = false) String lng) {
		RestResponseVO res = new RestResponseVO();
		List<FestivalKohaVO> voList = new ArrayList<FestivalKohaVO>();
		List<CustomBeachVO> customBeachList = new ArrayList<CustomBeachVO>();
		try {
			voList = beachDao.findAllFestivalKohaVOs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(FestivalKohaVO vo : voList){
			CustomBeachVO cvo = new CustomBeachVO();
			cvo.setNo(vo.getNo());
			cvo.setTitle(vo.getNm());
			cvo.setMapx(vo.getXcnts());
			cvo.setMapy(vo.getYdnts());
			cvo.setAddr1(vo.getAddr());
			if(vo.getPhoto_no()!=null){
				cvo.setFirstimage("http://www.khoa.go.kr/oceanmap/gallery/otms/"+vo.getPpath()+"Thumbnail/TN_"+vo.getPhoto_no());
			}
			cvo.setFacilities(vo.getFacilities());
			customBeachList.add(cvo);
		}
		if(listType!=null && listType.equals("jqgrid")){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setPaging(req);

			JQGridVO<CustomBeachVO> jqGridData = new JQGridVO<CustomBeachVO>();
			long totalCnt = customBeachList.size();
			pagingVO.setListCount(totalCnt);

			jqGridData.setPage(pagingVO.getPage());
			jqGridData.setTotal(String.valueOf(totalCnt));
			jqGridData.setRecords(String.valueOf(pagingVO.getListCount()));
			jqGridData.setRows(customBeachList);
			res.setData(jqGridData);
		}else{
			res.setData(customBeachList);
		}
		return res;
	}

	@RequestMapping(value = "kotasalong/sport", method = RequestMethod.GET)
	public RestResponseVO getSportList(
			HttpServletRequest req,
			@RequestParam(value = "listType", required = false) String listType,
			@RequestParam(value = "lat", required = false) String lat,
			@RequestParam(value = "lng", required = false) String lng) {
		RestResponseVO res = new RestResponseVO();
		List<SportKohaVO> voList = new ArrayList<SportKohaVO>();
		List<CustomBeachVO> customBeachList = new ArrayList<CustomBeachVO>();
		try {
			voList = beachDao.findAllSportKohaVOs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(SportKohaVO vo : voList){
			CustomBeachVO cvo = new CustomBeachVO();
			cvo.setNo(vo.getNo());
			cvo.setTitle(vo.getNm());
			cvo.setMapx(vo.getXcnts());
			cvo.setMapy(vo.getYdnts());
			cvo.setAddr1(vo.getAddr());
			if(vo.getPhoto_no()!=null){
				cvo.setFirstimage("http://www.khoa.go.kr/oceanmap/gallery/otms/"+vo.getPpath()+"Thumbnail/TN_"+vo.getPhoto_no());
			}
			cvo.setFacilities(vo.getFacilities());
			customBeachList.add(cvo);
		}
		if(listType!=null && listType.equals("jqgrid")){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setPaging(req);

			JQGridVO<CustomBeachVO> jqGridData = new JQGridVO<CustomBeachVO>();
			long totalCnt = customBeachList.size();
			pagingVO.setListCount(totalCnt);

			jqGridData.setPage(pagingVO.getPage());
			jqGridData.setTotal(String.valueOf(totalCnt));
			jqGridData.setRecords(String.valueOf(pagingVO.getListCount()));
			jqGridData.setRows(customBeachList);
			res.setData(jqGridData);
		}else{
			res.setData(customBeachList);
		}
		return res;
	}
	/*
	@RequestMapping(value = "kotasalong/beach/ori", method = RequestMethod.GET)
	public RestResponseVO getBeachOriList() {
		List<BeachKohaVO> beachList = new ArrayList<BeachKohaVO>();
		String beachUrl = "http://www.khoa.go.kr/oceanmap/otmsWfsApi.do?ServiceKey=oV/zQ68Zmoh7KhHhnGQ3Gs27BI0ipHjQDHSdxVnxrwPXfXncjF3hjEMmlEHTO6Kf&Layer=TB_FACI_BEACH";
		String beachListXml = null;
		try {
			beachListXml = BatchUtil.readUrl(beachUrl);
			beachList = (List<BeachKohaVO>) BatchUtil.beachListXmlToListFromKoha(beachListXml);
			beachDao.hqlTruncate("BeachKohaVO");
			for(BeachKohaVO vo : beachList){
				beachDao.saveBeachKohaVO(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		RestResponseVO res = new RestResponseVO();
		return res;
	}
	*/
}
