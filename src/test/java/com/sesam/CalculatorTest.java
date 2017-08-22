package com.sesam;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Unit test for simple Calculator.
 */
public class CalculatorTest extends TestCase {
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalculatorTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CalculatorTest.class);
    }

    /**
     * Test the calculator methods
     */
    public void testApp() throws FileNotFoundException {
		try {
			File input = new File("src/test/resources/numbers.txt");
			Scanner in = new Scanner(input);

			while(in.hasNextInt()) {
				int a = in.nextInt();
				int b = in.nextInt();
				System.out.println("[" + a + ", " + b + "]");
				int div = Calculator.division(a, b);
				divisionTest(a, b, div);
				System.out.println("- Division result: " + div);
				int mult = Calculator.multiplication(a, b);
				multiplicationTest(a, b, mult);
				System.out.println("- Multiplication result: " + mult);
				int sub = Calculator.subtraction(a, b);
				subtractionTest(a, b, sub);
				System.out.println("- Subtraction result: " + sub);
				int sum = Calculator.sum(a, b);
				sumTest(a, b, sum);
				System.out.println("- Addition result: " + sum);
			}
		} catch(FileNotFoundException e) {
			System.out.print("File not found");
		}
    }

	public void sumTest(int a, int b, int sum) {
		int result =  a + b;
		assertEquals(sum, result);
	}

	public void subtractionTest(int a, int b, int sub) {
		int result =  a - b;
		assertEquals(sub, result);
	}

	public void divisionTest(int a, int b, int div) {
		int result = a/b;
		assertEquals(div, result);
	}

	public void multiplicationTest(int a, int b, int mult) {
		int result = a * b;
		assertEquals(mult, result);
	}
}
