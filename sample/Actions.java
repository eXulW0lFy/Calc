package sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;

public class Actions {
	private static final Logger log = LogManager.getLogger(Actions.class.getName());
	
	static double max(double[] nums) {
		double res = Double.MIN_VALUE;
		for (double num : nums) {
			if (num > res) {
				res = num;
			}
		}
		return res;
	}
	
	static int max(int[] nums) {
		int res = Integer.MIN_VALUE;
		for (int num : nums) {
			if (num > res) {
				res = num;
			}
		}
		return res;
	}
	
	static float max(float[] nums) {
		float res = Float.MIN_VALUE;
		for (float num : nums) {
			if (num > res) {
				res = num;
			}
		}
		return res;
	}
	
	static double min(double[] nums) {
		double res = Double.MAX_VALUE;
		for (double num : nums) {
			if (num < res) {
				res = num;
			}
		}
		return res;
	}
	
	static int min(int[] nums) {
		int res = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num < res) {
				res = num;
			}
		}
		return res;
	}
	
	static float min(float[] nums) {
		float res = Float.MAX_VALUE;
		for (float num : nums) {
			if (num < res) {
				res = num;
			}
		}
		return res;
	}
	
	static int symsCount(String str, String symbols) {
		return str.length() - str.replace(symbols, "").length();
	}
	
	static double sum(double a, double b) {
		return  a + b;
	}
	static double diff(double a, double b) {
		return a - b;
	}
	static double mult(double a, double b) {
		return  a * b;
	}
	static double div(double a, double b) {
		return a / b;
	}
	
	public static String reverse(String s) {
		StringBuilder r = new StringBuilder();
		for (int i = s.length() - 1; i > -1; --i) {
			r.append(s.charAt(i));
		}
		return r.toString();
	}

	
	
}
