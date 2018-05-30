package sample.systems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Decimal {
	private static final Logger log = LogManager.getLogger(Binary.class.getName());
	Decimal(String decStr) {
		number = decStr;
	}
	
	public String number = "";
	
	public String toBinary() {
		int result = 0;
		
		return Integer.toString(result);
	}
}
