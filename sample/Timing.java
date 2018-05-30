package sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class Timing {
	// Timing.getRunTime(() -> ---doSth()---);
	// Timing.printRunTime(() -> ---doSth()---);
	private static final Logger log = LogManager.getLogger(Timing.class.getName());
	
	public static long getRunTime(Runnable run) {
		long time1;
		long time2;
		time1 = new Date().getTime();
		run.run();
		time2 = new Date().getTime();
		return time2 - time1;
	}
	
	public static void printRunTime(Runnable run) {
		System.out.println(getRunTime(run));
	}
}
