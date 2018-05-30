package sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

class Math {
	private static final Logger log = LogManager.getLogger(Math.class.getName());
	private static String exp;
	private static String[] exps;
	private static String[] curva;
	
	static final byte EQUALS = 0;
	static final byte SUM = 1;
	static final byte MINUS = 2;
	static final byte MULTIPLY = 3;
	static final byte DIVIDE = 4;
	static final byte OPEN_BR = 126;
	static final byte CLOSE_BR = 127;
	
	static void addExp(String exp) {
		Math.exp = exp;
	}
	
	private static int symsCount(String symbols) {
		return exp.length() - exp.replace(symbols, "").length();
	}
	
	static private void parse() {
		exps = parse(exp);
	}
	
	static private String[] parse(String str) {
		str = str.replace(" ", "");
		if (str.startsWith("-")) {
			str = "_" + str.substring(1);
		}
		str = str.replace("(-", "(_");
		str = str.replace("+", " + ").replace("-", " - ").replace("*", " * ").replace("/", " / ")
				.replace("(", " ( ").replace(")", " ) ");
		for (int i = 0; i < 5; i++) {
			str = str.replace("  ", " ");
		}
		str = str.replace("_", "-");
		return str.split(" ");
	}
	
	static private String[] getCurvaString() {
		String[] input = exps;
		String[] output = new String[input.length + 2];
		byte c = 0;
		Stack<String> stack = new Stack<>();
		for (String in : input) {
			switch (in) {
				case "+":
				case "-":
				case "*":
				case "/":
					if (stack.empty()) {
						stack.push(in);
					} else {
						String prPeep = stack.peek();
						prPeep = prPeep.replace("+", "1").replace("-", "1").replace("*", "2").replace("/", "2")
								.replace("(", "0").replace(")", "0");
						String prSign = in.replace("+", "1").replace("-", "1").replace("*", "2").replace("/", "2")
								.replace("(", "0").replace(")", "0");
						if (Integer.parseInt(prSign) <= Integer.parseInt(prPeep)) {
							output[c] = stack.pop();
							++c;
						}
						stack.push(in);
					}
					break;
				case "(":
					stack.push(in);
					break;
				case ")":
					while (! stack.peek().equals("(")) {
						output[c] = stack.pop();
						++c;
					}
					stack.pop();
					break;
				default:
					output[c] = in;
					++c;
					break;
			}
		}
		while (!stack.empty()) {
			output[c] = stack.pop();
			++c;
		}
		return output;
	}
	
	static double solve() {
		double res = 0;
		parse();
		curva = getCurvaString();
//		System.out.println(curva);
		// todo todo todo todo todo todo todoooo todotododo
		for (int i = 0; i < curva.length; i++) {
			if (curva[i] != null) {
				if ((curva[i].equals("+") || curva[i].equals("-") ||
						curva[i].equals("*") || curva[i].equals("/"))) {
					res = res + solution(i);
					i -= 2;
				}
			}
		}
		
		System.out.println(res);
		return res;
	}
	
	private static double solution(int index) {
		double res = 0;
		String[] exam = {curva[index], "", ""};
		for (int i = index - 1; i >= 0; i--) {
			//FIXME WTF FUCK ME
			boolean a = curva[i] != null || !Objects.equals(curva[i], "null");
			boolean b = !Objects.equals(curva[i], "+") || !Objects.equals(curva[i], "-") ||
					!Objects.equals(curva[i], "*") || !Objects.equals(curva[i], "/");
			boolean b2 = !(Objects.equals(curva[i], "+") && Objects.equals(curva[i], "-") &&
					Objects.equals(curva[i], "*") && Objects.equals(curva[i], "/"));
			if (a && b && b2) {
				if (exam[2].equals("")) {
					exam[2] = curva[i];
				} else if (exam[1].equals("")) {
					exam[1] = curva[i];
				}
			}
		}
		
		switch (exam[0]) {
			case "+":
				res = Actions.sum(Double.parseDouble(exam[1]), Double.parseDouble(exam[2]));
				break;
			case "-":
				res = Actions.diff(Double.parseDouble(exam[1]), Double.parseDouble(exam[2]));
				break;
			case "*":
				res = Actions.mult(Double.parseDouble(exam[1]), Double.parseDouble(exam[2]));
				break;
			case "/":
				res = Actions.div(Double.parseDouble(exam[1]), Double.parseDouble(exam[2]));
				break;
		}
		curva[index - 2] = String.valueOf(res);
		for (int i = index + 1; i < curva.length; i++) {
			curva[i - 2] = curva[i];
		}
		return res;
	}
	
}

// 3 4  2 * 1 5 - / + n n
// 3 8  1 5 - / + n n n n
// 3 8 -4 / + n n n n n n
// 3 -2 + n n n n n n n n
// -1
