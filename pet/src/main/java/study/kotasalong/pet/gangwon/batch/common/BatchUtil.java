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
import java.util.List;

import org.json.XML;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import study.kotasalong.pet.gangwon.batch.vo.ResHospDetailVO;
import study.kotasalong.pet.gangwon.batch.vo.ResHospInfoVO;

/** 
* @FileName      : Util.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
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
	
	public static <T> List<T> jsonToVO(String jsonString, String apiServiceName, Type collectionType){
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(jsonString).getAsJsonObject();
	    Gson gson = new Gson();        
	    ResponseVO<T> response = gson.fromJson(o.get(apiServiceName).toString(), collectionType);
	    return response.getRow();
	}

	public static <T> List<ResultVOForAddr> jsonToVOForAddr(String jsonString, String apiServiceName, Type collectionType){
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(jsonString).getAsJsonObject().getAsJsonObject("data").getAsJsonObject("search");
	    Gson gson = new Gson();
	    ResponseVOForAddr response = gson.fromJson(o.get("results").toString(), collectionType);
	    if(response==null){
	    	return null;
	    }
	    return response.getResult();
	}

	/** 
	* @param <T>
	 * @Method Name : jsonToVOForHosp 
	* @변경이력      : 
	* @Method 설명     : 
	* @param hospAddresJson
	* @return 
	*/
	public static Object jsonToVOForHosp(String jsonString) {
		org.json.JSONObject xmlJSONObj = XML.toJSONObject(jsonString);
		String xmlJSONObjString = xmlJSONObj.toString();
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(xmlJSONObjString).getAsJsonObject().getAsJsonObject("response").getAsJsonObject("body");
		if(o.get("totalCount").toString().equals("0")){
			return null;
		}else if(o.get("totalCount").toString().equals("1")){
		    Gson gson = new Gson();
		    ResHospInfoVO response = gson.fromJson(o.getAsJsonObject("items").getAsJsonObject("item").toString(), new TypeToken<ResHospInfoVO>(){}.getType());
		    if(response==null){
		    	return null;
		    }
		    return response;
		}else{
		    Gson gson = new Gson();
		    ResultVOForHosp response = gson.fromJson(o.getAsJsonObject("items").toString(), new TypeToken<ResultVOForHosp>(){}.getType());
		    if(response==null){
		    	return null;
		    }	
		    return response;
		}
	}

	/** 
	* @Method Name : jsonToVOForHospDetail 
	* @변경이력      : 
	* @Method 설명     : 
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
		if(!(o.get("body") instanceof JsonPrimitive)){
	    	response = gson.fromJson(o.getAsJsonObject("body").getAsJsonObject("item").toString(), new TypeToken<ResHospDetailVO>(){}.getType());
		}
	    return response;
	}
}
