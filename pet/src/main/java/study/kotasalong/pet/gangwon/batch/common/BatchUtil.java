/**
 * 0. Project  : ������ �� â�� ������Ʈ
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

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
	
}
