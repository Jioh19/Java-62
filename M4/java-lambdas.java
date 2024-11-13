import java.util.*;
import java.util.function.*;

public class LambdaExamples {
    
    // Sample functional interface
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }
    
    // Sample POJO for examples
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
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
    
    public static void main(String[] args) {
        // 1. Basic Lambda Syntax
        // Traditional way (Anonymous class)
        MathOperation addition = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        
        // Lambda way
        MathOperation additionLambda = (a, b) -> a + b;
        System.out.println("Addition result: " + additionLambda.operate(5, 3)); // Output: 8
        
        // Multiple lines in lambda
        MathOperation complexOperation = (a, b) -> {
            int result = a * 2;
            result += b * 3;
            return result;
        };
        
        // 2. Built-in Functional Interfaces
        // Predicate (takes one argument, returns boolean)
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // Output: true
        
        // Function (takes one argument, returns a result)
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello")); // Output: 5
        
        // Consumer (takes one argument, returns nothing)
        Consumer<String> printer = message -> System.out.println("Message: " + message);
        printer.accept("Hello Lambda!"); // Output: Message: Hello Lambda!
        
        // Supplier (takes no arguments, returns a result)
        Supplier<Double> randomNumber = () -> Math.random();
        System.out.println("Random number: " + randomNumber.get());
        
        // BiFunction (takes two arguments, returns a result)
        BiFunction<Integer, Integer, String> sumToString = 
            (a, b) -> String.valueOf(a + b);
        System.out.println("Sum as string: " + sumToString.apply(5, 3)); // Output: "8"
        
        // 3. Method References
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        
        // Lambda way
        names.forEach(name -> System.out.println(name));
        
        // Method reference way
        names.forEach(System.out::println);
        
        // 4. Collection Operations with Lambdas
        List<Person> people = Arrays.asList(
            new Person("John", 30),
            new Person("Alice", 25),
            new Person("Bob", 35)
        );
        
        // Sorting
        Collections.sort(people, (p1, p2) -> p1.getAge() - p2.getAge());
        
        // Filtering with Stream API
        List<Person> adults = people.stream()
            .filter(p -> p.getAge() >= 30)
            .toList();
        
        // Mapping with Stream API
        List<String> personNames = people.stream()
            .map(Person::getName)
            .toList();
        
        // 5. Exception Handling in Lambdas
        Function<String, Integer> parseInteger = str -> {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return -1;
            }
        };
        
        // 6. Composing Functions
        Function<Integer, Integer> multiply2 = x -> x * 2;
        Function<Integer, Integer> add3 = x -> x + 3;
        
        // Compose functions
        Function<Integer, Integer> multiply2ThenAdd3 = add3.compose(multiply2);
        System.out.println("multiply2ThenAdd3(4): " + multiply2ThenAdd3.apply(4)); // Output: 11
        
        // 7. Variable Capture
        int multiplier = 2;
        // Lambda using final or effectively final variable
        Function<Integer, Integer> multiplicator = x -> x * multiplier;
        
        // 8. Chaining Predicates
        Predicate<Integer> isPositive = x -> x > 0;
        Predicate<Integer> isLessThan10 = x -> x < 10;
        
        // Combine predicates
        Predicate<Integer> isBetween0And10 = isPositive.and(isLessThan10);
        System.out.println("Is 5 between 0 and 10? " + isBetween0And10.test(5)); // Output: true
        
        // 9. Optional with Lambda
        Optional<String> optionalName = Optional.of("John");
        optionalName.ifPresent(name -> System.out.println("Name is present: " + name));
        
        // 10. Parallel Operations
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.parallelStream()
            .map(x -> x * 2)
            .forEach(System.out::println);
    }
}
