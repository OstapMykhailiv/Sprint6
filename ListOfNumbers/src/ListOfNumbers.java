import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers() {
        list = new ArrayList<>(SIZE);
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            list.add(rand.nextInt(100));
        }
        this.writeList("file.txt");
        this.readList("file.txt");
    }

    public void readList(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Integer i = Integer.parseInt(line);
                System.out.println(i);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File: " + file + " not found.");
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

    public void writeList(String file) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (int i = 0; i < SIZE; i++) {
                writer.println(list.get(i));
            }
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ListOfNumbers();
    }
}
