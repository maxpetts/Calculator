package lab6;

import java.util.Scanner;

public class CalculatorTester {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		Calculator calc = new Calculator();

		calc.calculate(1);
		calc.setLastOperator("+");
		calc.calculate(2);
		System.out.println("1 + 2\t\t result = " + calc.getResult());

		calc.reset();
		calc.calculate(1);
		calc.setLastOperator("+");
		calc.calculate(2);
		calc.setLastOperator("+");
		calc.calculate(3);
		System.out.println("1 + 2 + 3\t result = " + calc.getResult());

		calc.reset();
		calc.calculate(1);
		calc.setLastOperator("+");
		calc.calculate(2);
		calc.setLastOperator("*");
		calc.calculate(3);
		System.out.println("1 + 2 * 3\t result = " + calc.getResult());

		calc.reset();
		calc.calculate(8);
		calc.setLastOperator("/");
		calc.calculate(2);
		System.out.println("8 / 2\t\t result = " + calc.getResult());

		calc.reset();
		calc.calculate(4);
		calc.setLastOperator("-");
		calc.calculate(2);
		System.out.println("4 - 2\t\t result = " + calc.getResult());

		calc.reset();
		calc.calculate(-2);
		calc.setLastOperator("+");
		calc.calculate(2);
		System.out.println("-2 + 2\t\t result = " + calc.getResult());
	}
}
