package sample.systems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sample.Actions;

public class Binary {
	private static final Logger log = LogManager.getLogger(Binary.class.getName());
	public Binary(String binStr) {
		number = binStr;
	}
	
	public String number = "";
	public final byte NOTATION = 2;
	
	public String toDecimal() {
		int result = 0;
		number = Actions.reverse(number);
		for (int i = 0; i < number.length(); ++i) {
			result += Integer.parseInt(String.valueOf(number.charAt(i))) * Math.pow(NOTATION, i);
		}
		// 10101 = 1^4 + 0^3 + 1^2 + 0^1 + 1^0
		return Integer.toString(result);
	}
}
