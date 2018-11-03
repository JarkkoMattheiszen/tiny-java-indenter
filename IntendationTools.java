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
       
public class IntendationTools {    
    
    // Go through the source code line by line and fix intendation
    public ArrayList correctIntendation(ArrayList sourceCode) {
        ArrayList<String> fixedCode = new ArrayList<>();
        int lineNumber = 0;
        int level = 0;
        
        System.out.println("\nFixing intendation...");

        // Fix the lines
        while (lineNumber < sourceCode.size() - 1) {
            
            System.out.println("Processing line " + lineNumber + "...");
            String line = (String) sourceCode.get(lineNumber);
            String nextLine = (String) sourceCode.get(lineNumber + 1);
            nextLine = nextLine.trim();
            String fixedLine = printIntendation(level) + line.trim();
            fixedCode.add(fixedLine);                  
            
            // Check if the next line alone justifies lowering the intendation level
            if (nextLine.equals("}")) {
                if (level > 0) {
                    level--;
                }
            }
            
            // Check if the current line is a single line comment
            // else if (fixedLine.substring(0,2).equals("//")) { *
            //     level = level;
            // }        
            
            // See if the current line is empty
            else if (fixedLine.length() == 0) {
                level = level;
            }
                
            // See if the current line is a single character
            else if (fixedLine.length() == 1) {
                if (fixedLine.equals("{")) {
                    level++;
                }
            }
            
            // See if the current line ends in { *
            else if (fixedLine.substring(fixedLine.length() - 1).equals("{")) {
                level++;
            }       
            
            // See if the next line begins with } *
            else if (nextLine.length() > 0) {
                if (nextLine.substring(0, 1).equals("}")) {
                    if (level > 0) {
                        level--;
                    }
                }
            }
                
            lineNumber++;
        }
        
        // Fix the last line
        String line = (String) sourceCode.get(lineNumber);
        String fixedLine = line.trim();
        fixedCode.add(fixedLine);        
       
        System.out.println("All done!");
        
        return fixedCode;
        
    }
    
    // Add intendation in the beginning of the line
    public String printIntendation(int level) {
        int i = 0;
        String intendation = "";
        while (i < level) {
            intendation = intendation.concat("\t");
            i++;          
        }
        
        return intendation;
    }
    
}
