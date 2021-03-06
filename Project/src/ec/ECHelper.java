package ec;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.xml.bind.DatatypeConverter;

import beans.ItemInfoBeans;

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

	/**
	 * カートに入った商品の合計額を計算
	 * @param items
	 * 　　　商品
	 * @return int
	 */
	public static int getTotalItemPrice(ArrayList<ItemInfoBeans> items) {

		int total = 0;
		for(ItemInfoBeans item: items) {
			total += item.getAmount() * item.getPriceWithTax()*(double)(1-(double)item.getRate()/100);
		}

		System.out.println("Getting total price has been completed");
		return total;
	}

	/**
	 * 文字列をMD5で暗号化
	 * @param source
	 * @return
	 */
	public static String convertEncryption(String source) {

		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";
		try {
			//ハッシュ生成処理
			byte[] bytes;
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			String result = DatatypeConverter.printHexBinary(bytes);
			//標準出力
			System.out.println(result);
			return result;
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return null;
	}

}
