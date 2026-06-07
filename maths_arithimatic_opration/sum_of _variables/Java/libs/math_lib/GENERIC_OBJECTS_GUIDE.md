# Generic Object Operations Guide - Java

## Overview

The **GenericObjectOperations** class enables summing any numeric field from any Java object using reflection. This is similar to C's generic struct approach but uses Java's reflection API.

---

## How It Works

### Reflection Pattern

```java
// Get the class of the object
Class<?> clazz = objects.get(0).getClass();

// Get the field by name
Field field = clazz.getDeclaredField(fieldName);

// Make it accessible (handles private fields)
field.setAccessible(true);

// Access the field value
int value = field.getInt(obj);
```

---

## 📊 Supported Operations

### sumIntField - Sum Integer Fields

**Method Signature:**
```java
public static <T> int sumIntField(List<T> objects, String fieldName)
public static <T> int sumIntField(T[] objects, String fieldName)
```

**Example:**
```java
List<Student> students = ...;
int totalMarks = GenericObjectOperations.sumIntField(students, "marks");
```

---

### sumFloatField - Sum Float Fields

**Method Signature:**
```java
public static <T> float sumFloatField(List<T> objects, String fieldName)
public static <T> float sumFloatField(T[] objects, String fieldName)
```

**Example:**
```java
List<Product> products = ...;
float totalPrice = GenericObjectOperations.sumFloatField(products, "price");
```

---

### sumDoubleField - Sum Double Fields

**Method Signature:**
```java
public static <T> double sumDoubleField(List<T> objects, String fieldName)
public static <T> double sumDoubleField(T[] objects, String fieldName)
```

**Example:**
```java
Employee[] staff = ...;
double totalBonus = GenericObjectOperations.sumDoubleField(staff, "bonus");
```

---

## 💡 Real-World Examples

### Example 1: Student Result System

```java
class StudentResult {
    public int id;
    public String name;
    public int marks;
    public float percentage;
}

// Create list
List<StudentResult> students = new ArrayList<>();
students.add(new StudentResult());
// ... add more students ...

// Sum marks
try {
    int totalMarks = GenericObjectOperations.sumIntField(students, "marks");
    System.out.println("Total Marks: " + totalMarks);
    
    // Sum percentages
    float totalPercentage = GenericObjectOperations.sumFloatField(students, "percentage");
    System.out.println("Average Percentage: " + (totalPercentage / students.size()));
}
catch (NoSuchFieldException e) {
    System.out.println("Field not found: " + e.getMessage());
}
catch (IllegalAccessException e) {
    System.out.println("Cannot access field: " + e.getMessage());
}
```

---

### Example 2: Product Inventory

```java
class Product {
    public int id;
    public String name;
    public int quantity;
    public float price;
}

List<Product> inventory = new ArrayList<>();
// ... populate inventory ...

try {
    // Total items in stock
    int totalQty = GenericObjectOperations.sumIntField(inventory, "quantity");
    
    // Total value per unit
    float totalPrice = GenericObjectOperations.sumFloatField(inventory, "price");
    
    // Calculate total inventory cost
    float totalCost = 0;
    for (Product p : inventory) {
        totalCost += p.quantity * p.price;
    }
    
    System.out.println("Items in Stock: " + totalQty);
    System.out.println("Total Price: $" + totalPrice);
    System.out.println("Total Cost: $" + totalCost);
}
catch (Exception e) {
    e.printStackTrace();
}
```

---

### Example 3: Employee Payroll

```java
class Employee {
    public int empId;
    public String name;
    public float salary;
    public double bonus;
}

Employee[] team = new Employee[100];
// ... populate team ...

try {
    // Sum all salaries
    float totalSalary = GenericObjectOperations.sumFloatField(team, "salary");
    
    // Sum all bonuses
    double totalBonus = GenericObjectOperations.sumDoubleField(team, "bonus");
    
    // Total payroll
    double totalPayroll = totalSalary + totalBonus;
    
    System.out.println("Total Salary: $" + totalSalary);
    System.out.println("Total Bonus: $" + totalBonus);
    System.out.println("Total Payroll: $" + totalPayroll);
}
catch (Exception e) {
    e.printStackTrace();
}
```

---

### Example 4: Measurement Data

```java
class Measurement {
    public int sampleId;
    public float reading;
    public double value;
    public String unit;
}

Measurement[] samples = new Measurement[1000];
// ... populate samples ...

try {
    // Average reading
    float totalReading = GenericObjectOperations.sumFloatField(samples, "reading");
    float average = totalReading / samples.length;
    
    // High precision calculations
    double totalValue = GenericObjectOperations.sumDoubleField(samples, "value");
    double averageValue = totalValue / samples.length;
    
    System.out.println("Average Reading: " + average + " " + samples[0].unit);
    System.out.println("Average Value (precise): " + averageValue);
}
catch (Exception e) {
    e.printStackTrace();
}
```

---

## ⚠️ Important Requirements

### 1. Field Must Be Public

```java
// ✓ WORKS - Public field
class Student {
    public int marks;
}

// ✗ FAILS - Private field
class Student {
    private int marks;
}
```

### 2. Field Name Must Match Exactly (Case-Sensitive)

```java
// ✓ WORKS
GenericObjectOperations.sumIntField(list, "marks");

class Student {
    public int marks;  // Matches exactly
}

// ✗ FAILS - Wrong case
GenericObjectOperations.sumIntField(list, "Marks");

// ✗ FAILS - Wrong name
GenericObjectOperations.sumIntField(list, "grade");
```

### 3. Field Type Must Match Method

```java
// ✓ WORKS
class Student {
    public int marks;  // int field
}
GenericObjectOperations.sumIntField(list, "marks");  // sumIntField

// ✗ FAILS - Type mismatch
class Student {
    public float marks;  // float field
}
GenericObjectOperations.sumIntField(list, "marks");  // sumIntField expects int
```

---

## 🔄 Generic Type Parameter

The `<T>` allows working with any object type:

```java
// With Student objects
List<Student> students = new ArrayList<>();
int total = GenericObjectOperations.sumIntField(students, "marks");

// With Product objects - SAME METHOD
List<Product> products = new ArrayList<>();
int total = GenericObjectOperations.sumIntField(products, "quantity");

// With Employee objects - SAME METHOD
Employee[] staff = new Employee[50];
float total = GenericObjectOperations.sumFloatField(staff, "salary");
```

---

## 🆘 Exception Handling

### NoSuchFieldException

**Cause:** Field doesn't exist in the class

```java
try {
    GenericObjectOperations.sumIntField(list, "nonexistent");
}
catch (NoSuchFieldException e) {
    System.out.println("Field not found: " + e.getMessage());
    // Output: Field not found: nonexistent
}
```

### IllegalAccessException

**Cause:** Cannot access the field (usually private)

```java
try {
    GenericObjectOperations.sumIntField(list, "marks");
}
catch (IllegalAccessException e) {
    System.out.println("Cannot access field: " + e.getMessage());
}
```

### Null Pointer

**Cause:** Empty list or array

```java
List<Student> students = new ArrayList<>();
int total = GenericObjectOperations.sumIntField(students, "marks");
// Returns 0 if list is empty
```

---

## 📈 Performance Considerations

### Reflection Overhead

- **First call:** ~1-5ms (reflection setup)
- **Subsequent calls:** ~0.1-0.5ms per object
- **For n=1000:** ~50-100ms total

### Optimization Tips

```java
// ✓ GOOD - Reflection only once
int total = GenericObjectOperations.sumIntField(largeList, "marks");

// ✗ SLOW - Reflection in loop
for (Student s : students) {
    int m = GenericObjectOperations.sumIntField(
        Arrays.asList(s), "marks");
}
```

---

## 🎯 Comparison with C Version

| Aspect | C Version | Java Version |
|--------|-----------|--------------|
| Method | offsetof/sizeof (compile-time) | Reflection (runtime) |
| Type Safety | Manual | Checked |
| Performance | Faster | Slightly slower |
| Error Handling | Manual checks | Exceptions |
| Flexibility | High (void pointers) | High (generics) |

---

## ✅ Checklist for Success

Before using generic operations:

- [ ] Field is public (not private)
- [ ] Field name matches exactly (case-sensitive)
- [ ] Field type matches method (int → sumIntField)
- [ ] List/array is not null
- [ ] Objects in list are initialized
- [ ] Exception handling is in place

---

## 🔗 Related Classes

- **MathOperations.java** - Basic math operations
- **ComprehensiveTest.java** - Examples with all data types

---

## 💻 Testing Your Code

Run the comprehensive test to see all examples:

```bash
java -cp bin com.mathlib.test.ComprehensiveTest
```

Look for "GENERIC TEST" sections to see all working examples.

---

## 🚀 Next Steps

1. **Implement:** Create your own classes with public fields
2. **Test:** Use the generic operations on your data
3. **Validate:** Check output with manual calculations
4. **Optimize:** Cache field references if called repeatedly

---

**Ready to sum any field from any object!** ✨
