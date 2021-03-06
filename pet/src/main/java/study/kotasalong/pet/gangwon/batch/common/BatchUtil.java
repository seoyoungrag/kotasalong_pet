/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : Util.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.common
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 9:21:32
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
 */
package study.kotasalong.pet.gangwon.batch.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.XML;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import study.kotasalong.beach.BeachKohaVO;
import study.kotasalong.beach.BeachVO;
import study.kotasalong.beach.CampKohaVO;
import study.kotasalong.beach.FestivalKohaVO;
import study.kotasalong.beach.SportKohaVO;
import study.kotasalong.pet.gangwon.batch.vo.ResHospDetailVO;
import study.kotasalong.pet.gangwon.batch.vo.ResHospInfoVO;

/**
 * @FileName : Util.java
 * @Project : batch
 * @Date : 2017. 8. 27. @�ۼ��� : yrseo @�����̷� : @���α׷� ���� :
 */

public class BatchUtil {

	public static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	public static <T> List<T> jsonToVO(String jsonString, String apiServiceName, Type collectionType) {
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(jsonString).getAsJsonObject();
		Gson gson = new Gson();
		ResponseVO<T> response = gson.fromJson(o.get(apiServiceName).toString(), collectionType);
		return response.getRow();
	}

	public static <T> List<ResultVOForAddr> jsonToVOForAddr(String jsonString, String apiServiceName,
			Type collectionType) {
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(jsonString).getAsJsonObject().getAsJsonObject("data").getAsJsonObject("search");
		Gson gson = new Gson();
		ResponseVOForAddr response = gson.fromJson(o.get("results").toString(), collectionType);
		if (response == null) {
			return null;
		}
		return response.getResult();
	}

	/**
	 * @param <T>
	 * @Method Name : jsonToVOForHosp
	 * @변경이력 :
	 * @Method 설명 :
	 * @param hospAddresJson
	 * @return
	 */
	public static Object jsonToVOForHosp(String jsonString) {
		org.json.JSONObject xmlJSONObj = XML.toJSONObject(jsonString);
		String xmlJSONObjString = xmlJSONObj.toString();
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(xmlJSONObjString).getAsJsonObject().getAsJsonObject("response")
				.getAsJsonObject("body");
		if (o.get("totalCount").toString().equals("0")) {
			return null;
		} else if (o.get("totalCount").toString().equals("1")) {
			Gson gson = new Gson();
			ResHospInfoVO response = gson.fromJson(o.getAsJsonObject("items").getAsJsonObject("item").toString(),
					new TypeToken<ResHospInfoVO>() {
					}.getType());
			if (response == null) {
				return null;
			}
			return response;
		} else {
			Gson gson = new Gson();
			ResultVOForHosp response = gson.fromJson(o.getAsJsonObject("items").toString(),
					new TypeToken<ResultVOForHosp>() {
					}.getType());
			if (response == null) {
				return null;
			}
			return response;
		}
	}

	/**
	 * @Method Name : jsonToVOForHospDetail
	 * @변경이력 :
	 * @Method 설명 :
	 * @param hospDetailJson
	 * @return
	 */

	public static ResHospDetailVO jsonToVOForHospDetail(String hospDetailJson) {
		org.json.JSONObject xmlJSONObj = XML.toJSONObject(hospDetailJson);
		String xmlJSONObjString = xmlJSONObj.toString();
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(xmlJSONObjString).getAsJsonObject().getAsJsonObject("response");
		Gson gson = new Gson();
		ResHospDetailVO response = null;
		if (!(o.get("body") instanceof JsonPrimitive)) {
			try {
				response = gson.fromJson(o.getAsJsonObject("body").getAsJsonObject("item").toString(),
						new TypeToken<ResHospDetailVO>() {
						}.getType());
			} catch (Exception e) {

			}
		}
		return response;
	}

	public static Object beachListXmlToList(String xmlString) {
		org.json.JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
		String xmlJSONObjString = xmlJSONObj.toString();
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(xmlJSONObjString).getAsJsonObject().getAsJsonObject("response")
				.getAsJsonObject("body");
		if (o.get("totalCount").toString().equals("0")) {
			return null;
		} else if (o.get("totalCount").toString().equals("1")) {
			Gson gson = new Gson();
			BeachVO response = gson.fromJson(o.getAsJsonObject("items").getAsJsonObject("item").toString(),
					new TypeToken<BeachVO>() {
					}.getType());
			if (response == null) {
				return null;
			}
			return response;
		} else {
			Gson gson = new Gson();
			Collection<BeachVO> response = gson.fromJson(o.getAsJsonObject("items").getAsJsonArray("item").toString(),
					new TypeToken<Collection<BeachVO>>() {
					}.getType());
			if (response == null) {
				return null;
			}
			return response;
		}
	}

	public static Object beachListXmlToListFromKoha(String xmlString, String type) {
		// TB_FACI_SPORT
		// TB_FACI_FESTIVAL
		// TB_FACI_CAMPSITE
		// TB_FACI_BEACH
		org.json.JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
		String xmlJSONObjString = xmlJSONObj.toString();
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(xmlJSONObjString).getAsJsonObject().getAsJsonObject("wfs:FeatureCollection");
		Gson gson = new Gson();
		// Collection<BeachKohaWrapperVO> response =
		// gson.fromJson(o.getAsJsonArray("gml:featureMember").toString(), new
		// TypeToken<Collection<BeachKohaWrapperVO>>(){}.getType());
		Collection<JsonObject> oo = gson.fromJson(o.getAsJsonArray("gml:featureMember").toString(),
				new TypeToken<Collection<JsonObject>>() {
				}.getType());
		List<Object> response = new ArrayList<Object>();
		try {
				ObjectMapper objectMapper = new ObjectMapper();
				for (JsonObject obj : oo) {
					JsonObject ooo = gson.fromJson(obj.getAsJsonObject(type).toString(), new TypeToken<JsonObject>() {
					}.getType());
					Object oooo = null;
					if (type.equals("TB_FACI_BEACH")) {
					oooo = objectMapper.readValue(ooo.toString(), BeachKohaVO.class);
					} else if (type.equals("TB_FACI_CAMPSITE")) {
						oooo = objectMapper.readValue(ooo.toString(), CampKohaVO.class);
					} else if (type.equals("TB_FACI_FESTIVAL")) {
						oooo = objectMapper.readValue(ooo.toString(), FestivalKohaVO.class);
					} else if (type.equals("TB_FACI_SPORT")) {
						oooo = objectMapper.readValue(ooo.toString(), SportKohaVO.class);
					}
					response.add(oooo);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
