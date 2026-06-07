package com.mathlib;

/**
 * MathOperations - Main Math Library for Java
 * 
 * Provides comprehensive addition operations for multiple data types
 * Supports: 2, 3, 4, 5 number addition, arrays, and objects
 * 
 * Author: Custom Library Team
 * Version: 2.1.0
 * Date: 2026-06-07
 */
public class MathOperations
{
	/* ==================== INTEGER OPERATIONS ==================== */

	/**
	 * addTwo - Add two integers
	 * @param a First integer
	 * @param b Second integer
	 * @return Sum of a and b
	 */
	public static int addTwo(int a, int b)
	{
		return a + b;
	}

	/**
	 * addThree - Add three integers
	 * @param a First integer
	 * @param b Second integer
	 * @param c Third integer
	 * @return Sum of a, b and c
	 */
	public static int addThree(int a, int b, int c)
	{
		return a + b + c;
	}

	/**
	 * addFour - Add four integers
	 * @param a First integer
	 * @param b Second integer
	 * @param c Third integer
	 * @param d Fourth integer
	 * @return Sum of a, b, c and d
	 */
	public static int addFour(int a, int b, int c, int d)
	{
		return a + b + c + d;
	}

	/**
	 * addFive - Add five integers
	 * @param a First integer
	 * @param b Second integer
	 * @param c Third integer
	 * @param d Fourth integer
	 * @param e Fifth integer
	 * @return Sum of all five numbers
	 */
	public static int addFive(int a, int b, int c, int d, int e)
	{
		return a + b + c + d + e;
	}

	/**
	 * addArray - Add all elements in integer array
	 * @param arr Array of integers
	 * @return Sum of all elements, 0 if array is null or empty
	 */
	public static int addArray(int[] arr)
	{
		if (arr == null || arr.length == 0)
			return 0;

		int sum = 0;
		for (int num : arr)
			sum += num;

		return sum;
	}

	/* ==================== FLOAT OPERATIONS ==================== */

	/**
	 * addTwo - Add two floats
	 * @param a First float
	 * @param b Second float
	 * @return Sum of a and b
	 */
	public static float addTwo(float a, float b)
	{
		return a + b;
	}

	/**
	 * addThree - Add three floats
	 * @param a First float
	 * @param b Second float
	 * @param c Third float
	 * @return Sum of a, b and c
	 */
	public static float addThree(float a, float b, float c)
	{
		return a + b + c;
	}

	/**
	 * addFour - Add four floats
	 * @param a First float
	 * @param b Second float
	 * @param c Third float
	 * @param d Fourth float
	 * @return Sum of a, b, c and d
	 */
	public static float addFour(float a, float b, float c, float d)
	{
		return a + b + c + d;
	}

	/**
	 * addFive - Add five floats
	 * @param a First float
	 * @param b Second float
	 * @param c Third float
	 * @param d Fourth float
	 * @param e Fifth float
	 * @return Sum of all five numbers
	 */
	public static float addFive(float a, float b, float c, float d, float e)
	{
		return a + b + c + d + e;
	}

	/**
	 * addArray - Add all elements in float array
	 * @param arr Array of floats
	 * @return Sum of all elements, 0.0f if array is null or empty
	 */
	public static float addArray(float[] arr)
	{
		if (arr == null || arr.length == 0)
			return 0.0f;

		float sum = 0.0f;
		for (float num : arr)
			sum += num;

		return sum;
	}

	/* ==================== DOUBLE OPERATIONS ==================== */

	/**
	 * addTwo - Add two doubles
	 * @param a First double
	 * @param b Second double
	 * @return Sum of a and b
	 */
	public static double addTwo(double a, double b)
	{
		return a + b;
	}

	/**
	 * addThree - Add three doubles
	 * @param a First double
	 * @param b Second double
	 * @param c Third double
	 * @return Sum of a, b and c
	 */
	public static double addThree(double a, double b, double c)
	{
		return a + b + c;
	}

	/**
	 * addFour - Add four doubles
	 * @param a First double
	 * @param b Second double
	 * @param c Third double
	 * @param d Fourth double
	 * @return Sum of a, b, c and d
	 */
	public static double addFour(double a, double b, double c, double d)
	{
		return a + b + c + d;
	}

	/**
	 * addFive - Add five doubles
	 * @param a First double
	 * @param b Second double
	 * @param c Third double
	 * @param d Fourth double
	 * @param e Fifth double
	 * @return Sum of all five numbers
	 */
	public static double addFive(double a, double b, double c, double d, double e)
	{
		return a + b + c + d + e;
	}

	/**
	 * addArray - Add all elements in double array
	 * @param arr Array of doubles
	 * @return Sum of all elements, 0.0 if array is null or empty
	 */
	public static double addArray(double[] arr)
	{
		if (arr == null || arr.length == 0)
			return 0.0;

		double sum = 0.0;
		for (double num : arr)
			sum += num;

		return sum;
	}

	/* ==================== STRING CONVERSION ==================== */

	/**
	 * intToString - Convert integer to string
	 * @param num Integer to convert
	 * @return String representation of the integer
	 */
	public static String intToString(int num)
	{
		return String.valueOf(num);
	}

	/**
	 * floatToString - Convert float to string with 2 decimal places
	 * @param num Float to convert
	 * @return String representation of the float
	 */
	public static String floatToString(float num)
	{
		return String.format("%.2f", num);
	}

	/**
	 * doubleToString - Convert double to string with 6 decimal places
	 * @param num Double to convert
	 * @return String representation of the double
	 */
	public static String doubleToString(double num)
	{
		return String.format("%.6f", num);
	}
}
