import java.io.*;
import java.util.ArrayList;

public class ListOfNumbers {
    private static final int SIZE = 10;
    private ArrayList<Integer> numbers;

    public ListOfNumbers() {
        numbers = new ArrayList<Integer>();
        this.readList("file.txt");
        this.writeList();
    }

    public void readList(String file) {
        String line = null;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null){
                Integer i = Integer.parseInt(line);
                System.out.println(i);
                numbers.add(i);
            }
            reader.close();
        } catch(FileNotFoundException e) {
            System.err.println("File: " + file + " not found.");
        }catch (IOException e){
            System.out.println("IOexception");
        }
    }
    public void writeList() {
        PrintWriter out = null;

        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));

            for (int i = 0; i < SIZE; i++)
                out.println("Value at: " + i + " = " + numbers.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                    e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    public static void main (String[] Args){
        new ListOfNumbers();
    }
}