import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintWriter;

public class FileTools {
    
    public ArrayList<String> readFile(String fileName) {
        ArrayList<String> outputArrayList = new ArrayList<>();
        System.out.println("Loading source file...");
        
        try (Scanner file = new Scanner(new FileInputStream(fileName))) {
            System.out.println("Source file loaded.");
            
            while (file.hasNextLine()) {
                outputArrayList.add(file.nextLine());
            }           
        }
        
        catch (Exception e) {
            System.out.println("Error loading source file: " + e.getMessage());
            System.exit(0);
        }    
        
        return outputArrayList;
    }
    
    // Not used at the moment
    public void printArrayList(ArrayList arraylist) {
        System.out.println("\nSource file contents:");
        for (int i = 0; i < arraylist.size(); i++) {
            System.out.println(arraylist.get(i));
        }
    }
    
    public void writeFile(ArrayList workbench, String fileName) {
        System.out.print("Writing destination file... ");
        try (PrintWriter out = new PrintWriter(fileName)) {
            for (int i = 0; i < workbench.size(); i++) {
                out.println(workbench.get(i));
            }
            
            System.out.println("Done.");
        }
        
        catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
    }
}
