/**
 * 0. Project  : 강원도 앱 창업 프로젝트
 *
 * 1. FileName : DitanceUtil.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.common
 * 3. Comment : 
 * 4. 작성자  : yrseo
 * 5. 작성일  : 2017. 9. 24. 오후 3:34:55
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 9. 24. :            : 신규 개발.
 */
package study.kotasalong.pet.gangwon.batch.common;

/** 
* @FileName      : DitanceUtil.java 
* @Project     : pet 
* @Date        : 2017. 9. 24. 
* @작성자          : yrseo 
* @변경이력     : 
* @프로그램 설명     : 
*/

public class DistanceUtil {
	/*
	 public static void main(String[] args) {
		 
	        // 마일(Mile) 단위
	        double distanceMile =
	            distance(37.504198, 127.047967, 37.501025, 127.037701, "");
	         
	        // 미터(Meter) 단위
	        double distanceMeter =
	            distance(37.504198, 127.047967, 37.501025, 127.037701, "meter");
	         
	        // 킬로미터(Kilo Meter) 단위
	        double distanceKiloMeter =
	            distance(37.504198, 127.047967, 37.501025, 127.037701, "kilometer");
	         
	        System.out.println(distanceMile) ;
	        System.out.println(distanceMeter) ;
	        System.out.println(distanceKiloMeter) ;
	         
	         
	    }
	*/     
	     
	     
	    /**
	     * 두 지점간의 거리 계산
	     *
	     * @param lat1 지점 1 위도
	     * @param lon1 지점 1 경도
	     * @param lat2 지점 2 위도
	     * @param lon2 지점 2 경도
	     * @param unit 거리 표출단위
	     * @return
	     */
	    public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
	         
	        double theta = lon1 - lon2;
	        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	         
	        dist = Math.acos(dist);
	        dist = rad2deg(dist);
	        dist = dist * 60 * 1.1515;
	         
	        if (unit == "kilometer") {
	            dist = dist * 1.609344;
	        } else if(unit == "meter"){
	            dist = dist * 1609.344;
	        }
	 
	        return (dist);
	    }
	     
	 
	    // This function converts decimal degrees to radians
	    private static double deg2rad(double deg) {
	        return (deg * Math.PI / 180.0);
	    }
	     
	    // This function converts radians to decimal degrees
	    private static double rad2deg(double rad) {
	        return (rad * 180 / Math.PI);
	    }

}
