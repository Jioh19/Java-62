import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortingExamples {
    
    // Sample Person class for demonstrations
    static class Person {
        private String name;
        private int age;
        private double salary;
        
        public Person(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
        
        public String getName() { return name; }
        public int getAge() { return age; }
        public double getSalary() { return salary; }
        
        @Override
        public String toString() {
            return String.format("Person{name='%s', age=%d, salary=%.2f}", name, age, salary);
        }
    }
    
    public static void main(String[] args) {
        // 1. Basic Sorting (Numbers)
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);
        
        // Natural order
        List<Integer> sortedNumbers = numbers.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Sorted numbers: " + sortedNumbers);
        
        // Reverse order
        List<Integer> reverseSortedNumbers = numbers.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        System.out.println("Reverse sorted numbers: " + reverseSortedNumbers);
        
        // 2. Sorting Strings
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        
        // Case-sensitive sort
        List<String> sortedNames = names.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Sorted names: " + sortedNames);
        
        // Case-insensitive sort
        List<String> caseInsensitiveSortedNames = names.stream()
            .sorted(String.CASE_INSENSITIVE_ORDER)
            .collect(Collectors.toList());
        System.out.println("Case-insensitive sorted names: " + caseInsensitiveSortedNames);
        
        // 3. Sorting Objects
        List<Person> people = Arrays.asList(
            new Person("John", 30, 50000),
            new Person("Alice", 25, 60000),
            new Person("Bob", 35, 55000),
            new Person("Charlie", 28, 65000)
        );
        
        // Sort by age
        List<Person> sortedByAge = people.stream()
            .sorted(Comparator.comparing(Person::getAge))
            .collect(Collectors.toList());
        System.out.println("Sorted by age: " + sortedByAge);
        
        // Sort by name
        List<Person> sortedByName = people.stream()
            .sorted(Comparator.comparing(Person::getName))
            .collect(Collectors.toList());
        System.out.println("Sorted by name: " + sortedByName);
        
        // 4. Complex Sorting (Multiple Fields)
        // Sort by age, then by salary
        List<Person> sortedByAgeAndSalary = people.stream()
            .sorted(Comparator
                .comparing(Person::getAge)
                .thenComparing(Person::getSalary))
            .collect(Collectors.toList());
        System.out.println("Sorted by age and salary: " + sortedByAgeAndSalary);
        
        // 5. Custom Comparator
        // Sort by salary descending
        List<Person> sortedBySalaryDesc = people.stream()
            .sorted((p1, p2) -> Double.compare(p2.getSalary(), p1.getSalary()))
            .collect(Collectors.toList());
        System.out.println("Sorted by salary (descending): " + sortedBySalaryDesc);
        
        // 6. Null-Safe Sorting
        List<String> namesWithNull = Arrays.asList("John", null, "Alice", "Bob", null);
        
        // Nulls last
        List<String> sortedNullsLast = namesWithNull.stream()
            .sorted(Comparator.nullsLast(Comparator.naturalOrder()))
            .collect(Collectors.toList());
        System.out.println("Sorted with nulls last: " + sortedNullsLast);
        
        // Nulls first
        List<String> sortedNullsFirst = namesWithNull.stream()
            .sorted(Comparator.nullsFirst(Comparator.naturalOrder()))
            .collect(Collectors.toList());
        System.out.println("Sorted with nulls first: " + sortedNullsFirst);
    }
}
