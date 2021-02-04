
package libarysystem;

import java.util.*;
import java.io.*;



public class fileHandaling {
    public static String folderDirectory = System.getProperty("user.die")+ "\\booklist.txt";
    public static void writeFile(ArrayList<book> booklist){
        try{
            FileWriter writeToFile = new FileWriter(folderDirectory, false);
            PrintWriter printToFile = new PrintWriter (writeToFile);
            for (int i = 0; i < booklist.size(); i++){
                printToFile.println(booklist.get(i).toString());
                  
            }
            printToFile.close();
            writeToFile.close();
            
            
            
            
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
    public static ArrayList<book> readFile(){
        ArrayList<book> booklist = new ArrayList<>();
        String lineFromFile;
        try{
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null){
                String[] bookDetails = lineFromFile.split(", ");
                book mybook = new book(bookDetails[0], bookDetails [1], bookDetails[2], Double.parseDouble(bookDetails[3]), bookDetails[4], bookDetails[5]);
                booklist.add(mybook);
            }
            read.close();
        } catch (Exception e){
            System.out.println("Error: " + e);
        }  
       return booklist; 
    }
    
    
    
    
    
}
