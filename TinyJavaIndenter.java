package tiny.java.indenter;

/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */

/**
 *
 * @author Jarkko Mattheiszen
 */



import java.util.ArrayList;
import java.util.Scanner;

public class TinyJavaIndenter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        FileTools file = new FileTools();
        IndentationTools indenter = new IndentationTools();
        // ArrayList<String> sourceCode = new ArrayList<String>();
        // ArrayList<String> fixedCode = new ArrayList<String>();
        
        // Intro
        System.out.println("Tiny Java Indenter version 0.03");
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
