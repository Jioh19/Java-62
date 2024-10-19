import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class ArrayListToCSV {
    public static void main(String[] args) {
        // Create an example ArrayList
        ArrayList<String[]> data = new ArrayList<>();
        data.add(new String[]{"Name", "Age", "City"});
        data.add(new String[]{"John", "30", "New York"});
        data.add(new String[]{"Alice", "25", "Los Angeles"});
        data.add(new String[]{"Bob", "35", "Chicago"});

        // Define the output file name
        String csvFile = "output.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {
            // Iterate through the ArrayList and write to CSV
            for (String[] row : data) {
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < row.length; i++) {
                    line.append(row[i]);
                    if (i != row.length - 1) {
                        line.append(",");
                    }
                }
                line.append("\n");
                writer.write(line.toString());
            }
            System.out.println("CSV file has been created successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file.");
            e.printStackTrace();
        }
    }
}
