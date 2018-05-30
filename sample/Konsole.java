package sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sample.systems.*;


public class Konsole {
	private static final Logger log = LogManager.getLogger(Konsole.class.getName());
	
	public static void main(String[] args) {
//		System.out.println(s);
//
//
//		Binary bin = new Binary("101010");
//		System.out.println(bin.toDecimal());
		
		Math.addExp("3 + 4 * 2 / (1 - 5)");
		Math.solve();
		
		Math.addExp("-2 + 5"); // _2 5 +
		Math.solve();
		Math.addExp("95 * 8 / (56 + 6)"); // 95 8 * 56 6 + /
		Math.solve();
		Math.addExp("95 * (9 - 99 / 57) - 31"); // 95 9 99 57 / - * 31 -
		Math.solve();
		Math.addExp("((2 + 5) * 6 ) / 3"); // 2 5 + 6 * 3 /
		
		{{}{}}
		Math.solve();
		Math.addExp("3 * 2 * (-5 / 4 + (-2) * 3) - 78"); // 3 2 * _5 4 / _2 3 * + * 78
		Math.solve();
		Math.addExp("(-22 + 5) / (-3)"); //
		Math.solve();
		
		Runnable run5 = () -> {
			for (long i = 0; i < 50_000_000; i++) {
				//DO STH
				//870_000_000 ~ 1500 msec
				//600_000_000 ~ 1000 msec = 1 sec
				//290_000_000 ~ 500 msec
				//50_000_000 ~ 100 msec
			}
		};
//		Timing.printRunTime(run5);
	}
}


/* FIXME PLZ
_2+5                   _2 5 +
95*8/56+6              95 8 * 56 6 +
95*9-99/57-31          95 9 * 99 57 / 31
2+5*6/3                2 5 6 * 3 +
3*2*5/4+_2*3-78        3 2 * 5 4 / _2 3 * 78
_22+5/_3               _22 5 _3 / +
(FIXME) I'M JUST FUCKED UP
 */