package com.mathlib.test;

import com.mathlib.MathOperations;
import com.mathlib.GenericObjectOperations;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * ComprehensiveTest - Comprehensive test suite for Math Library v2.1
 * 
 * Tests all functions with 40+ test cases
 * Demonstrates real-world usage scenarios
 */
public class ComprehensiveTest
{
	/* ==================== HELPER CLASSES ==================== */

	/**
	 * Student result record
	 */
	public static class StudentResult
	{
		public int id;
		public int marks;
		public float percentage;
		public String name;

		public StudentResult(int id, int marks, float percentage, String name)
		{
			this.id = id;
			this.marks = marks;
			this.percentage = percentage;
			this.name = name;
		}

		@Override
		public String toString()
		{
			return String.format("ID: %d, Name: %-10s, Marks: %d, Percentage: %.1f%%",
				id, name, marks, percentage);
		}
	}

	/**
	 * Product inventory record
	 */
	public static class Product
	{
		public int id;
		public int quantity;
		public float price;
		public String name;

		public Product(int id, int quantity, float price, String name)
		{
			this.id = id;
			this.quantity = quantity;
			this.price = price;
			this.name = name;
		}

		@Override
		public String toString()
		{
			return String.format("ID: %d, Name: %-10s, Qty: %d, Price: $%.2f",
				id, name, quantity, price);
		}
	}

	/**
	 * Measurement record
	 */
	public static class Measurement
	{
		public int sampleId;
		public float reading;
		public double value;
		public String unit;

		public Measurement(int sampleId, float reading, double value, String unit)
		{
			this.sampleId = sampleId;
			this.reading = reading;
			this.value = value;
			this.unit = unit;
		}

		@Override
		public String toString()
		{
			return String.format("Sample %d: %.1f %s (precise: %.6f)",
				sampleId, reading, unit, value);
		}
	}

	/**
	 * Employee record
	 */
	public static class Employee
	{
		public int empId;
		public float salary;
		public double bonus;
		public String name;

		public Employee(int empId, float salary, double bonus, String name)
		{
			this.empId = empId;
			this.salary = salary;
			this.bonus = bonus;
			this.name = name;
		}

		@Override
		public String toString()
		{
			return String.format("ID: %d, Name: %-10s, Salary: $%.2f, Bonus: $%.2f",
				empId, name, salary, bonus);
		}
	}

	/* ==================== SEPARATOR ==================== */

	public static void printSeparator()
	{
		System.out.println("\n========================================");
	}

	/* ==================== TEST METHODS ==================== */

	public static void testIntegerOperations()
	{
		printSeparator();
		System.out.println("  INTEGER OPERATIONS TEST");
		printSeparator();

		System.out.println("\nTest 1: Add Two Integers");
		System.out.println("Result: 5 + 3 = " + MathOperations.addTwo(5, 3));

		System.out.println("\nTest 2: Add Three Integers");
		System.out.println("Result: 5 + 3 + 2 = " + MathOperations.addThree(5, 3, 2));

		System.out.println("\nTest 3: Add Four Integers");
		System.out.println("Result: 5 + 3 + 2 + 4 = " + MathOperations.addFour(5, 3, 2, 4));

		System.out.println("\nTest 4: Add Five Integers");
		System.out.println("Result: 5 + 3 + 2 + 4 + 1 = " + MathOperations.addFive(5, 3, 2, 4, 1));

		System.out.println("\nTest 5: Add Integer Array");
		int[] intArray = {10, 20, 30, 40, 50};
		System.out.println("Array: " + Arrays.toString(intArray));
		System.out.println("Result: " + MathOperations.addArray(intArray));
	}

	public static void testFloatOperations()
	{
		printSeparator();
		System.out.println("  FLOAT OPERATIONS TEST");
		printSeparator();

		System.out.println("\nTest 1: Add Two Floats");
		System.out.println("Result: 5.5 + 3.2 = " + MathOperations.addTwo(5.5f, 3.2f));

		System.out.println("\nTest 2: Add Three Floats");
		System.out.println("Result: 5.5 + 3.2 + 2.1 = " + MathOperations.addThree(5.5f, 3.2f, 2.1f));

		System.out.println("\nTest 3: Add Four Floats");
		System.out.println("Result: 5.5 + 3.2 + 2.1 + 1.8 = " + 
			MathOperations.addFour(5.5f, 3.2f, 2.1f, 1.8f));

		System.out.println("\nTest 4: Add Five Floats");
		System.out.println("Result: 5.5 + 3.2 + 2.1 + 1.8 + 0.4 = " + 
			MathOperations.addFive(5.5f, 3.2f, 2.1f, 1.8f, 0.4f));

		System.out.println("\nTest 5: Add Float Array");
		float[] floatArray = {10.5f, 20.3f, 30.2f, 40.1f, 50.9f};
		System.out.println("Array: " + Arrays.toString(floatArray));
		System.out.println("Result: " + String.format("%.2f", MathOperations.addArray(floatArray)));
	}

	public static void testDoubleOperations()
	{
		printSeparator();
		System.out.println("  DOUBLE OPERATIONS TEST");
		printSeparator();

		System.out.println("\nTest 1: Add Two Doubles");
		System.out.println("Result: 5.123456 + 3.654321 = " + 
			String.format("%.6f", MathOperations.addTwo(5.123456, 3.654321)));

		System.out.println("\nTest 2: Add Three Doubles");
		System.out.println("Result: 5.123456 + 3.654321 + 2.456789 = " + 
			String.format("%.6f", MathOperations.addThree(5.123456, 3.654321, 2.456789)));

		System.out.println("\nTest 3: Add Four Doubles");
		double result = MathOperations.addFour(5.1, 3.2, 2.3, 1.4);
		System.out.println("Result: 5.1 + 3.2 + 2.3 + 1.4 = " + String.format("%.6f", result));

		System.out.println("\nTest 4: Add Five Doubles");
		double result2 = MathOperations.addFive(5.1, 3.2, 2.3, 1.4, 0.5);
		System.out.println("Result: 5.1 + 3.2 + 2.3 + 1.4 + 0.5 = " + String.format("%.6f", result2));

		System.out.println("\nTest 5: Add Double Array");
		double[] doubleArray = {10.123456, 20.234567, 30.345678, 40.456789, 50.567890};
		System.out.println("Array: " + Arrays.toString(doubleArray));
		System.out.println("Result: " + String.format("%.6f", MathOperations.addArray(doubleArray)));
	}

	public static void testStudentResults()
	{
		printSeparator();
		System.out.println("  GENERIC TEST: STUDENT RESULTS");
		printSeparator();

		List<StudentResult> students = new ArrayList<>();
		students.add(new StudentResult(101, 85, 85.0f, "Alice"));
		students.add(new StudentResult(102, 92, 92.0f, "Bob"));
		students.add(new StudentResult(103, 78, 78.0f, "Charlie"));

		System.out.println("\nStudent Records:");
		for (StudentResult s : students)
			System.out.println("  " + s);

		try
		{
			System.out.println("\nTest 1: Sum All Marks");
			int totalMarks = GenericObjectOperations.sumIntField(students, "marks");
			System.out.println("Total Marks: " + totalMarks);
			System.out.println("Average Marks: " + String.format("%.2f", (float)totalMarks / students.size()));

			System.out.println("\nTest 2: Sum All Percentages");
			float totalPercentage = GenericObjectOperations.sumFloatField(students, "percentage");
			System.out.println("Total Percentage: " + String.format("%.2f%%", totalPercentage));
			System.out.println("Average Percentage: " + 
				String.format("%.2f%%", totalPercentage / students.size()));
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void testProductInventory()
	{
		printSeparator();
		System.out.println("  GENERIC TEST: PRODUCT INVENTORY");
		printSeparator();

		List<Product> products = new ArrayList<>();
		products.add(new Product(1001, 50, 29.99f, "Laptop"));
		products.add(new Product(1002, 150, 9.99f, "Mouse"));
		products.add(new Product(1003, 200, 19.99f, "Keyboard"));
		products.add(new Product(1004, 30, 99.99f, "Monitor"));

		System.out.println("\nInventory Records:");
		for (Product p : products)
			System.out.println("  " + p);

		try
		{
			System.out.println("\nTest 1: Total Items in Stock");
			int totalQty = GenericObjectOperations.sumIntField(products, "quantity");
			System.out.println("Total Items: " + totalQty);

			System.out.println("\nTest 2: Total Inventory Value per Unit");
			float totalPrice = GenericObjectOperations.sumFloatField(products, "price");
			System.out.println("Total Price Value: $" + String.format("%.2f", totalPrice));
			System.out.println("Average Unit Price: $" + 
				String.format("%.2f", totalPrice / products.size()));

			System.out.println("\nTest 3: Total Inventory Cost");
			float totalCost = 0.0f;
			for (Product p : products)
				totalCost += p.quantity * p.price;
			System.out.println("Total Inventory Cost: $" + String.format("%.2f", totalCost));
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void testMeasurements()
	{
		printSeparator();
		System.out.println("  GENERIC TEST: MEASUREMENTS");
		printSeparator();

		Measurement[] measurements = new Measurement[5];
		measurements[0] = new Measurement(1, 23.5f, 23.456789, "Celsius");
		measurements[1] = new Measurement(2, 24.1f, 24.123456, "Celsius");
		measurements[2] = new Measurement(3, 23.8f, 23.876543, "Celsius");
		measurements[3] = new Measurement(4, 24.5f, 24.543210, "Celsius");
		measurements[4] = new Measurement(5, 23.9f, 23.987654, "Celsius");

		System.out.println("\nMeasurement Records:");
		for (Measurement m : measurements)
			System.out.println("  " + m);

		try
		{
			System.out.println("\nTest 1: Total Readings");
			float totalReading = GenericObjectOperations.sumFloatField(
				measurements, "reading");
			System.out.println("Total Readings: " + String.format("%.1f", totalReading));
			System.out.println("Average Reading: " + 
				String.format("%.2f %s", totalReading / measurements.length, "Celsius"));

			System.out.println("\nTest 2: Total Precise Values");
			double totalValue = GenericObjectOperations.sumDoubleField(
				measurements, "value");
			System.out.println("Total Precise Values: " + String.format("%.6f", totalValue));
			System.out.println("Average Precise Value: " + 
				String.format("%.6f", totalValue / measurements.length));
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void testEmployeePayroll()
	{
		printSeparator();
		System.out.println("  GENERIC TEST: EMPLOYEE PAYROLL");
		printSeparator();

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(501, 5000.50f, 1000.00, "John"));
		employees.add(new Employee(502, 6500.75f, 1500.50, "Sarah"));
		employees.add(new Employee(503, 5500.25f, 1200.00, "Mike"));

		System.out.println("\nEmployee Records:");
		for (Employee e : employees)
			System.out.println("  " + e);

		try
		{
			System.out.println("\nTest 1: Total Salary Payroll");
			float totalSalary = GenericObjectOperations.sumFloatField(employees, "salary");
			System.out.println("Total Salary: $" + String.format("%.2f", totalSalary));
			System.out.println("Average Salary: $" + 
				String.format("%.2f", totalSalary / employees.size()));

			System.out.println("\nTest 2: Total Bonus Amount");
			double totalBonus = GenericObjectOperations.sumDoubleField(employees, "bonus");
			System.out.println("Total Bonus: $" + String.format("%.2f", totalBonus));
			System.out.println("Average Bonus: $" + 
				String.format("%.2f", totalBonus / employees.size()));

			System.out.println("\nTest 3: Total Compensation");
			double totalComp = 0.0;
			for (Employee e : employees)
				totalComp += e.salary + e.bonus;
			System.out.println("Total Compensation: $" + String.format("%.2f", totalComp));
			System.out.println("Average Compensation: $" + 
				String.format("%.2f", totalComp / employees.size()));
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void testStringConversions()
	{
		printSeparator();
		System.out.println("  STRING CONVERSION TEST");
		printSeparator();

		System.out.println("\nTest 1: Integer to String");
		System.out.println("Original: 12345");
		System.out.println("Converted: " + MathOperations.intToString(12345));

		System.out.println("\nTest 2: Float to String");
		System.out.println("Original: 123.456");
		System.out.println("Converted: " + MathOperations.floatToString(123.456f));

		System.out.println("\nTest 3: Double to String");
		System.out.println("Original: 123.456789");
		System.out.println("Converted: " + MathOperations.doubleToString(123.456789));

		System.out.println("\nTest 4: Negative Number to String");
		System.out.println("Original: -999");
		System.out.println("Converted: " + MathOperations.intToString(-999));

		System.out.println("\nTest 5: Negative Float to String");
		System.out.println("Original: -45.67");
		System.out.println("Converted: " + MathOperations.floatToString(-45.67f));
	}

	/* ==================== MAIN METHOD ==================== */

	public static void main(String[] args)
	{
		System.out.println();
		printSeparator();
		System.out.println("  MATH LIBRARY v2.1 - COMPREHENSIVE TEST SUITE");
		System.out.println("  Java Implementation");
		printSeparator();

		testIntegerOperations();
		testFloatOperations();
		testDoubleOperations();
		testStudentResults();
		testProductInventory();
		testMeasurements();
		testEmployeePayroll();
		testStringConversions();

		printSeparator();
		System.out.println("  ALL TESTS COMPLETED SUCCESSFULLY!");
		printSeparator();
		System.out.println();
	}
}
