package tiny.java.intender;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jarkko
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.PrintWriter;

public class FileTools {
    
    public ArrayList readFile(String fileName) {
        ArrayList<String> outputArrayList = new ArrayList<>();
        System.out.println("Loading source file...");
        
        try (Scanner file = new Scanner(new FileInputStream(fileName))) {
            System.out.println("Source file loaded.");
            
            while (file.hasNextLine()) {
                outputArrayList.add(file.nextLine());
            }           
        }
        
        catch (Exception e) {
            System.out.println("Error loading source file:" + e.getMessage());
            System.exit(0);
        }    
        
        return outputArrayList;
    }
    
    public void printArrayList(ArrayList arraylist) {
        System.out.println("\nSource file contents:");
        for (int i = 0; i < arraylist.size(); i++) {
            System.out.println(arraylist.get(i));
        }
    }
    
    public void writeFile(ArrayList workbench, String fileName) {
        File outputFile = new File(fileName);
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
