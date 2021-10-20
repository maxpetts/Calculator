/**
 * Calculator.java - handles arithmetic and logic of a calculator
 * 
 * @author Max Petts / eeub35
 * @version 0.1
 * @since 10/11/18
 */

package lab6;

public class Calculator {
	private double result; // Holds accumulator value
	private String lastOperator; // Stores last operator entered
	private boolean checkSingleOperator; // Indicates start Operation of a computation
	private double storedNum;
	private boolean start; // indicates if an equation has taken place

	public Calculator() {
		result = 0;
		lastOperator = "=";
		checkSingleOperator = true;
		storedNum = 0;
		start = true;
	}

	public void reset() {
		result = 0;
		lastOperator = "=";
		checkSingleOperator = true;
		start = true;
	}

	/**
	 * @param num
	 */
	public void setStoredNum(double num) {
		storedNum = num;
	}

	/**
	 * @return stored number
	 */
	public double getStoredNum() {
		return storedNum;
	}

	/**
	 * @return result
	 */
	public double getResult() {
		return result;
	}

	/**
	 * @return checkSingleOperator
	 */
	public boolean getCheckSingleOperator() {
		return checkSingleOperator;
	}

	/**
	 * @param checkSingleOperator = checkSingleOperator
	 */
	public void setCheckSingleOperator(boolean checkSingleOperator) {
		this.checkSingleOperator = checkSingleOperator;
	}

	/**
	 * @return
	 */
	public boolean getStart() {
		return start;
	}

	/**
	 * @param start
	 */
	public void setStart(boolean start) {
		this.start = start;
	}

	/**
	 * @return
	 */
	public String getLastOperator() {
		return lastOperator;
	}

	/**
	 * @param operator
	 */
	public void setLastOperator(String operator) {
		lastOperator = operator;
	}

	public double calculate(double x) {

		// System.out.println("x: " + x);
		// System.out.println("Result: " + result);

		switch (lastOperator) {
		case "+":
			result += x;
			break;
		case "-":
			result -= x;
			break;
		case "/":
			result /= x;
			break;
		case "*":
			result *= x;
			break;
		case "=":
			result = x;
			break;
		case "√":
			result = Math.sqrt(x);
			break;
		case "%":
			result = result * x / 100;
			break;
		}
		return result;

	}

	/**
	 * Carries out the pending calculation.
	 * 
	 * @param x the value to be accumulated with the prior result.
	 *
	 *          public double calculate2(double x) {
	 * 
	 *          if (lastOperator.equals("+")) result += x; else if
	 *          (lastOperator.equals("-")) result -= x; else if
	 *          (lastOperator.equals("*")) result *= x; else if
	 *          (lastOperator.equals("/")) result /= x; else if
	 *          (lastOperator.equals("1/x")) result = 1/x; else if
	 *          (lastOperator.equals("√")) result = Math.sqrt(x); else if
	 *          (lastOperator.equals("%")) { result = (result*x/100); } else if
	 *          (lastOperator.equals("1/x")) result = 1/x; else if
	 *          (lastOperator.equals("+/-")) result = (-1) * x; else if
	 *          (lastOperator.equals("=")) result = x;
	 * 
	 * 
	 *          return result; }
	 */

	/**
	 * Returns string representation of calculator state.
	 * 
	 * @param return calculator state
	 */
	public String toString() {
		return getClass().getSimpleName() + "[result = " + result + ", lastOperator = " + lastOperator + ", start = "
				+ checkSingleOperator + "]";
	}
}
