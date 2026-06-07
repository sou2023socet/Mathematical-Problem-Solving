# Java Math Library v2.1 - Quick Start

## 🚀 5-Minute Setup

### Step 1: Check Java Installation
```bash
java -version
javac -version
```

Both commands should display version information. If not, install JDK from https://www.oracle.com/java/

---

### Step 2: Navigate to Library
```bash
cd "Java\libs\math_lib"
```

---

### Step 3: Build & Run
```bash
build.bat
```

That's it! You'll see 40+ tests running with real-world examples.

---

## 📋 Available Commands

**Build and test (Windows):**
```bash
build.bat
```

**Manual build:**
```bash
javac -d bin src/com/mathlib/*.java src/com/mathlib/test/*.java
```

**Run tests:**
```bash
java -cp bin com.mathlib.test.ComprehensiveTest
```

---

## 💡 Common Usage

### Integer Addition
```java
import com.mathlib.MathOperations;

int result = MathOperations.addTwo(10, 5);
System.out.println(result);  // 15
```

### Array Addition
```java
int[] numbers = {1, 2, 3, 4, 5};
int total = MathOperations.addArray(numbers);
System.out.println(total);  // 15
```

### Sum Student Marks
```java
import com.mathlib.GenericObjectOperations;
import java.util.*;

class Student {
    public int marks;
}

List<Student> students = new ArrayList<>();
// ... add students ...

int total = GenericObjectOperations.sumIntField(students, "marks");
```

---

## 📁 Structure

```
Java/libs/math_lib/
├── src/
│   └── com/mathlib/
│       ├── MathOperations.java
│       ├── GenericObjectOperations.java
│       └── test/ComprehensiveTest.java
├── bin/                    (Created after build)
├── build.bat              (Windows build script)
└── README.md              (Full documentation)
```

---

## ✅ What Works

✓ Basic addition (2, 3, 4, 5 numbers)  
✓ Array addition  
✓ Generic object field summing  
✓ Type conversions  
✓ Student results, products, measurements, employees  

---

## 🆘 Troubleshooting

| Problem | Solution |
|---------|----------|
| `javac: command not found` | Install JDK, add to PATH |
| Build fails | Check Java version with `java -version` |
| Test errors | Ensure all files in src directory |

---

## 📚 Next Steps

1. Read `README.md` for complete documentation
2. Check `ComprehensiveTest.java` for examples
3. Create your own test class
4. Integrate into your project

---

## 🎯 Example: Student Marks System

```java
import com.mathlib.GenericObjectOperations;
import java.util.*;

class Student {
    public int id;
    public String name;
    public int marks;
    
    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 85));
        students.add(new Student(2, "Bob", 92));
        students.add(new Student(3, "Charlie", 78));
        
        int total = GenericObjectOperations.sumIntField(students, "marks");
        float average = (float) total / students.size();
        
        System.out.println("Total Marks: " + total);
        System.out.println("Average: " + average);
    }
}
```

---

**Start with `build.bat` and explore the tests!** 🎉
