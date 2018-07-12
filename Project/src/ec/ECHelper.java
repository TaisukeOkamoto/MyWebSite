package ec;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ECHelper {

	/**
	 * 数字かどうか判定
	 * @param number
	 * 			何らかの数字
	 * @return bool
	 */
	public static boolean isNum(String number) {
	    try {
	        Integer.parseInt(number);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	/**
	 * 年、月、日を結合してDate型のyyyy/MM/dd形式に変換
	 * @param year
	 * @param month
	 * @param day
	 * @return Date
	 */
	public static java.util.Date CovertUtilDateYMD(String year,String month,String day) {
		String strDate = year +"/"+ month +"/"+ day;
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date date = null;
		try {
			date = sdFormat.parse(strDate);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 年、月、日を結合してsql型のyyyy/MM/dd形式に変換
	 * @param year
	 * @param month
	 * @param day
	 * @return Date
	 */
	public static java.sql.Date CovertSqlDateYMD(String year,String month,String day) {
		String strDate = year +"-"+ month +"-"+ day;
		java.sql.Date sqlDate= java.sql.Date.valueOf(strDate);
		return sqlDate;
	}


}
