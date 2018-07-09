package ec;

public class ECHelper {
	//数字かどうか判定
	static boolean isNum(String number) {
	    try {
	        Integer.parseInt(number);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
}
