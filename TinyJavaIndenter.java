import java.util.ArrayList;
import java.util.Scanner;

public class TinyJavaIndenter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        FileTools file = new FileTools();
        IndentationTools indenter = new IndentationTools();
        
        // Intro
        System.out.println("Tiny Java Indenter version 0.04");
        System.out.println("-------------------------------");
        System.out.println("");
        
        // Get file name
        System.out.print("Source file name: ");
        String input = scan.nextLine();
        
        // Load source file into workbench ArrayList
        ArrayList<String> sourceCode = file.readFile(input);
   
        // Fix indentation inside the workbench ArrayList
        ArrayList<String> fixedCode = indenter.correctIndentation(sourceCode);
        
        // Write workbench ArrayList into a new file
        System.out.print("\nDestination file name: ");
        input = scan.nextLine();
        file.writeFile(fixedCode, input);
    }
    
}
