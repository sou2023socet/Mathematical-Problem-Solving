package com.mathlib;

import java.lang.reflect.Field;
import java.util.List;

/**
 * GenericObjectOperations - Generic field operations for any object type
 * 
 * Provides methods to sum any integer, float, or double field from any object
 * Supports: Student results, Product inventory, Employee payroll, etc.
 * 
 * Author: Custom Library Team
 * Version: 2.1.0
 * Date: 2026-06-07
 */
public class GenericObjectOperations
{
	/**
	 * sumIntField - Sum integer field from list of objects
	 * 
	 * Example:
	 *   List<Student> students = new ArrayList<>();
	 *   int total = GenericObjectOperations.sumIntField(students, "marks");
	 * 
	 * @param <T> Generic type parameter
	 * @param objects List of objects
	 * @param fieldName Name of the integer field to sum
	 * @return Sum of the field values, 0 if list is null or empty
	 * @throws IllegalAccessException if field cannot be accessed
	 * @throws NoSuchFieldException if field does not exist
	 */
	public static <T> int sumIntField(List<T> objects, String fieldName)
		throws IllegalAccessException, NoSuchFieldException
	{
		if (objects == null || objects.isEmpty())
			return 0;

		int sum = 0;
		Class<?> clazz = objects.get(0).getClass();
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);

		for (T obj : objects)
		{
			sum += field.getInt(obj);
		}

		return sum;
	}

	/**
	 * sumFloatField - Sum float field from list of objects
	 * 
	 * Example:
	 *   List<Product> products = new ArrayList<>();
	 *   float total = GenericObjectOperations.sumFloatField(products, "price");
	 * 
	 * @param <T> Generic type parameter
	 * @param objects List of objects
	 * @param fieldName Name of the float field to sum
	 * @return Sum of the field values, 0.0f if list is null or empty
	 * @throws IllegalAccessException if field cannot be accessed
	 * @throws NoSuchFieldException if field does not exist
	 */
	public static <T> float sumFloatField(List<T> objects, String fieldName)
		throws IllegalAccessException, NoSuchFieldException
	{
		if (objects == null || objects.isEmpty())
			return 0.0f;

		float sum = 0.0f;
		Class<?> clazz = objects.get(0).getClass();
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);

		for (T obj : objects)
		{
			sum += field.getFloat(obj);
		}

		return sum;
	}

	/**
	 * sumDoubleField - Sum double field from list of objects
	 * 
	 * Example:
	 *   List<Measurement> measurements = new ArrayList<>();
	 *   double total = GenericObjectOperations.sumDoubleField(measurements, "value");
	 * 
	 * @param <T> Generic type parameter
	 * @param objects List of objects
	 * @param fieldName Name of the double field to sum
	 * @return Sum of the field values, 0.0 if list is null or empty
	 * @throws IllegalAccessException if field cannot be accessed
	 * @throws NoSuchFieldException if field does not exist
	 */
	public static <T> double sumDoubleField(List<T> objects, String fieldName)
		throws IllegalAccessException, NoSuchFieldException
	{
		if (objects == null || objects.isEmpty())
			return 0.0;

		double sum = 0.0;
		Class<?> clazz = objects.get(0).getClass();
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);

		for (T obj : objects)
		{
			sum += field.getDouble(obj);
		}

		return sum;
	}

	/**
	 * sumIntField - Sum integer field from array of objects
	 * 
	 * @param <T> Generic type parameter
	 * @param objects Array of objects
	 * @param fieldName Name of the integer field to sum
	 * @return Sum of the field values, 0 if array is null or empty
	 * @throws IllegalAccessException if field cannot be accessed
	 * @throws NoSuchFieldException if field does not exist
	 */
	public static <T> int sumIntField(T[] objects, String fieldName)
		throws IllegalAccessException, NoSuchFieldException
	{
		if (objects == null || objects.length == 0)
			return 0;

		int sum = 0;
		Class<?> clazz = objects[0].getClass();
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);

		for (T obj : objects)
		{
			sum += field.getInt(obj);
		}

		return sum;
	}

	/**
	 * sumFloatField - Sum float field from array of objects
	 * 
	 * @param <T> Generic type parameter
	 * @param objects Array of objects
	 * @param fieldName Name of the float field to sum
	 * @return Sum of the field values, 0.0f if array is null or empty
	 * @throws IllegalAccessException if field cannot be accessed
	 * @throws NoSuchFieldException if field does not exist
	 */
	public static <T> float sumFloatField(T[] objects, String fieldName)
		throws IllegalAccessException, NoSuchFieldException
	{
		if (objects == null || objects.length == 0)
			return 0.0f;

		float sum = 0.0f;
		Class<?> clazz = objects[0].getClass();
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);

		for (T obj : objects)
		{
			sum += field.getFloat(obj);
		}

		return sum;
	}

	/**
	 * sumDoubleField - Sum double field from array of objects
	 * 
	 * @param <T> Generic type parameter
	 * @param objects Array of objects
	 * @param fieldName Name of the double field to sum
	 * @return Sum of the field values, 0.0 if array is null or empty
	 * @throws IllegalAccessException if field cannot be accessed
	 * @throws NoSuchFieldException if field does not exist
	 */
	public static <T> double sumDoubleField(T[] objects, String fieldName)
		throws IllegalAccessException, NoSuchFieldException
	{
		if (objects == null || objects.length == 0)
			return 0.0;

		double sum = 0.0;
		Class<?> clazz = objects[0].getClass();
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);

		for (T obj : objects)
		{
			sum += field.getDouble(obj);
		}

		return sum;
	}
}
