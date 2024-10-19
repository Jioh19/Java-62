import java.io.*;
import java.nio.file.*;

public class FileOpenWriteExercises {

    public static void main(String[] args) {
        // Exercise 1: Write to a file using FileWriter
        writeWithFileWriter("exercise1.txt", "Hello, FileWriter!");

        // Exercise 2: Write to a file using BufferedWriter
        writeWithBufferedWriter("exercise2.txt", "Hello, BufferedWriter!");

        // Exercise 3: Write to a file using FileOutputStream
        writeWithFileOutputStream("exercise3.txt", "Hello, FileOutputStream!");

        // Exercise 4: Write to a file using Files class (Java NIO)
        writeWithFiles("exercise4.txt", "Hello, Files class!");

        // Exercise 5: Append to an existing file
        appendToFile("exercise5.txt", "This is line 1.\n");
        appendToFile("exercise5.txt", "This is line 2.\n");

        // Exercise 6: Write multiple lines at once
        String[] lines = {"Line 1", "Line 2", "Line 3"};
        writeMultipleLines("exercise6.txt", lines);
    }

    // Exercise 1: Write to a file using FileWriter
    public static void writeWithFileWriter(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Successfully wrote to " + fileName + " using FileWriter.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to " + fileName);
            e.printStackTrace();
        }
    }

    // Exercise 2: Write to a file using BufferedWriter
    public static void writeWithBufferedWriter(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Successfully wrote to " + fileName + " using BufferedWriter.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to " + fileName);
            e.printStackTrace();
        }
    }

    // Exercise 3: Write to a file using FileOutputStream
    public static void writeWithFileOutputStream(String fileName, String content) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] bytes = content.getBytes();
            fos.write(bytes);
            System.out.println("Successfully wrote to " + fileName + " using FileOutputStream.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to " + fileName);
            e.printStackTrace();
        }
    }

    // Exercise 4: Write to a file using Files class (Java NIO)
    public static void writeWithFiles(String fileName, String content) {
        try {
            Files.write(Paths.get(fileName), content.getBytes());
            System.out.println("Successfully wrote to " + fileName + " using Files class.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to " + fileName);
            e.printStackTrace();
        }
    }

    // Exercise 5: Append to an existing file
    public static void appendToFile(String fileName, String content) {
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(content);
            System.out.println("Successfully appended to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while appending to " + fileName);
            e.printStackTrace();
        }
    }

    // Exercise 6: Write multiple lines at once
    public static void writeMultipleLines(String fileName, String[] lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Successfully wrote multiple lines to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to " + fileName);
            e.printStackTrace();
        }
    }
}
