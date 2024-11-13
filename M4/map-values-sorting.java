import java.util.*;
import java.util.stream.Collectors;

public class MapValuesSorting {
    
    // Sample Person class for complex object examples
    static class Person {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() { return name; }
        public int getAge() { return age; }
        
        @Override
        public String toString() {
            return String.format("Person{name='%s', age=%d}", name, age);
        }
    }
    
    public static void main(String[] args) {
        // 1. Sorting Map with Simple Values (Integers)
        Map<String, Integer> scoresMap = new HashMap<>();
        scoresMap.put("John", 85);
        scoresMap.put("Alice", 92);
        scoresMap.put("Bob", 78);
        scoresMap.put("Charlie", 95);

        // Method 1: Using Stream API
        List<Integer> sortedScores = scoresMap.values().stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Sorted scores: " + sortedScores);
        
        // Method 2: Using ArrayList constructor
        List<Integer> sortedScores2 = new ArrayList<>(scoresMap.values());
        Collections.sort(sortedScores2);
        System.out.println("Sorted scores (method 2): " + sortedScores2);
        
        // 2. Sorting Map Entries by Values
        // This preserves the key-value relationship
        List<Map.Entry<String, Integer>> sortedEntries = scoresMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toList());
        System.out.println("Sorted entries by score: " + sortedEntries);
        
        // 3. Sorting in Reverse Order
        List<Map.Entry<String, Integer>> reverseSortedEntries = scoresMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toList());
        System.out.println("Reverse sorted entries by score: " + reverseSortedEntries);
        
        // 4. Sorting Map with Complex Objects as Values
        Map<String, Person> peopleMap = new HashMap<>();
        peopleMap.put("emp1", new Person("John", 30));
        peopleMap.put("emp2", new Person("Alice", 25));
        peopleMap.put("emp3", new Person("Bob", 35));
        
        // Sort by age
        List<Person> sortedByAge = peopleMap.values().stream()
            .sorted(Comparator.comparing(Person::getAge))
            .collect(Collectors.toList());
        System.out.println("People sorted by age: " + sortedByAge);
        
        // Sort by name
        List<Person> sortedByName = peopleMap.values().stream()
            .sorted(Comparator.comparing(Person::getName))
            .collect(Collectors.toList());
        System.out.println("People sorted by name: " + sortedByName);
        
        // 5. Creating a New Sorted Map
        // Note: LinkedHashMap maintains insertion order
        Map<String, Integer> sortedMap = scoresMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,  // merge function
                LinkedHashMap::new  // maintain order
            ));
        System.out.println("New sorted map: " + sortedMap);
        
        // 6. Multiple Field Sorting with Complex Objects
        Map<String, Person> employeeMap = new HashMap<>();
        employeeMap.put("emp1", new Person("John", 30));
        employeeMap.put("emp2", new Person("Alice", 30));
        employeeMap.put("emp3", new Person("Bob", 25));
        
        // Sort by age, then by name
        List<Person> sortedByAgeAndName = employeeMap.values().stream()
            .sorted(Comparator.comparing(Person::getAge)
                .thenComparing(Person::getName))
            .collect(Collectors.toList());
        System.out.println("Sorted by age and name: " + sortedByAgeAndName);
        
        // 7. Handling Null Values
        Map<String, Integer> mapWithNulls = new HashMap<>();
        mapWithNulls.put("A", 1);
        mapWithNulls.put("B", null);
        mapWithNulls.put("C", 3);
        
        // Sort with nulls last
        List<Integer> sortedWithNulls = mapWithNulls.values().stream()
            .sorted(Comparator.nullsLast(Comparator.naturalOrder()))
            .collect(Collectors.toList());
        System.out.println("Sorted with nulls last: " + sortedWithNulls);
        
        // 8. Custom Comparator Example
        List<Map.Entry<String, Integer>> customSorted = scoresMap.entrySet().stream()
            .sorted((e1, e2) -> {
                // Custom sorting logic
                return e2.getValue().compareTo(e1.getValue()); // descending order
            })
            .collect(Collectors.toList());
        System.out.println("Custom sorted entries: " + customSorted);
    }
}
