import java.util.*;
import java.util.stream.Collectors;

public class MultipleSortingExamples {
    
    // Sample Student class with multiple fields
    static class Student {
        private String name;
        private int age;
        private double gpa;
        private String department;
        
        public Student(String name, int age, double gpa, String department) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
            this.department = department;
        }
        
        public String getName() { return name; }
        public int getAge() { return age; }
        public double getGpa() { return gpa; }
        public String getDepartment() { return department; }
        
        @Override
        public String toString() {
            return String.format("Student{name='%s', age=%d, gpa=%.2f, department='%s'}", 
                name, age, gpa, department);
        }
    }
    
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("John", 20, 3.8, "CS"),
            new Student("Alice", 20, 3.9, "Math"),
            new Student("Bob", 22, 3.7, "CS"),
            new Student("Sarah", 19, 3.9, "Physics"),
            new Student("Mike", 22, 3.7, "Math"),
            new Student("Emma", 20, 3.8, "Physics")
        );

        // 1. Basic sorting by age and then GPA using Comparator.comparing()
        List<Student> sortedByAgeAndGpa = students.stream()
            .sorted(Comparator
                .comparing(Student::getAge)
                .thenComparing(Student::getGpa))
            .collect(Collectors.toList());
        
        System.out.println("Sorted by age (ascending) and GPA (ascending):");
        sortedByAgeAndGpa.forEach(System.out::println);
        
        // 2. Sorting with mixed ordering (age ascending, GPA descending)
        List<Student> sortedMixed = students.stream()
            .sorted(Comparator
                .comparing(Student::getAge)
                .thenComparing(Student::getGpa, Comparator.reverseOrder()))
            .collect(Collectors.toList());
            
        System.out.println("\nSorted by age (ascending) and GPA (descending):");
        sortedMixed.forEach(System.out::println);
        
        // 3. Sorting by department, then GPA descending, then name
        List<Student> sortedComplex = students.stream()
            .sorted(Comparator
                .comparing(Student::getDepartment)
                .thenComparing(Student::getGpa, Comparator.reverseOrder())
                .thenComparing(Student::getName))
            .collect(Collectors.toList());
            
        System.out.println("\nSorted by department, GPA (desc), and name:");
        sortedComplex.forEach(System.out::println);
        
        // 4. Custom comparison logic
        Comparator<Student> customComparator = (s1, s2) -> {
            // First compare departments
            int deptCompare = s1.getDepartment().compareTo(s2.getDepartment());
            if (deptCompare != 0) {
                return deptCompare;
            }
            
            // If same department, compare by GPA
            int gpaCompare = Double.compare(s2.getGpa(), s1.getGpa()); // descending
            if (gpaCompare != 0) {
                return gpaCompare;
            }
            
            // If same GPA, compare by age
            return Integer.compare(s1.getAge(), s2.getAge());
        };
        
        List<Student> customSorted = new ArrayList<>(students);
        customSorted.sort(customComparator);
        
        System.out.println("\nCustom sorting:");
        customSorted.forEach(System.out::println);
        
        // 5. Sorting with null handling
        List<Student> studentsWithNull = new ArrayList<>(students);
        studentsWithNull.add(null);
        
        List<Student> sortedWithNulls = studentsWithNull.stream()
            .sorted(Comparator
                .nullsLast(Comparator
                    .comparing(Student::getAge)
                    .thenComparing(Student::getGpa)))
            .collect(Collectors.toList());
            
        System.out.println("\nSorted with null handling:");
        sortedWithNulls.forEach(System.out::println);
        
        // 6. Case-insensitive string sorting with other fields
        List<Student> sortedCaseInsensitive = students.stream()
            .sorted(Comparator
                .comparing(Student::getDepartment, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Student::getName, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Student::getGpa))
            .collect(Collectors.toList());
            
        System.out.println("\nCase-insensitive sorting:");
        sortedCaseInsensitive.forEach(System.out::println);
        
        // 7. Using traditional Comparator implementation
        class StudentComparator implements Comparator<Student> {
            @Override
            public int compare(Student s1, Student s2) {
                // First compare by department
                int deptCompare = s1.getDepartment().compareTo(s2.getDepartment());
                if (deptCompare != 0) {
                    return deptCompare;
                }
                
                // Then by GPA (descending)
                int gpaCompare = Double.compare(s2.getGpa(), s1.getGpa());
                if (gpaCompare != 0) {
                    return gpaCompare;
                }
                
                // Finally by name
                return s1.getName().compareTo(s2.getName());
            }
        }
        
        List<Student> traditionalSorted = new ArrayList<>(students);
        traditionalSorted.sort(new StudentComparator());
        
        System.out.println("\nTraditional Comparator sorting:");
        traditionalSorted.forEach(System.out::println);
    }
}
