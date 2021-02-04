package libarysystem;

import java.util.*;

public class LibarySystem {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<book> booklist = new ArrayList<>();

    public static void main(String[] args) {
        booklist = fileHandaling.readFile();
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("Welcome to the libary system");
        System.out.println("what would you like to do?");
        System.out.println("1: Add a book");
        System.out.println("2: view all books");
        System.out.println("3: edit book");

        System.out.println("0-exit");
        int userChoice = input.nextInt();

        switch (userChoice) {
            case 1:
                addBook();
                break;

            case 2:
                viewBook();
                break;
                
            case 3:
                editBook();
                break;
            
            case 4:
                deleteBook();
                break;
            

            case 0:
                fileHandaling.writeFile( booklist);
                System.exit(0);

        }

    }

    public static void addBook() {
        System.out.println("please type in a name");
        String name = input.nextLine();
        System.out.println("Please Type in ISBN");
        String ISBN = input.nextLine();
        System.out.println("Please Typer in the author");
        String Author = input.nextLine();
        System.out.println("please enter the price");
        double price = input.nextDouble();
        System.out.println("Please enter in the release date");
        String releaseDate = input.nextLine();
        System.out.println("please type in the genre");
        String genre = input.nextLine();

        book myBook = new book(name, Author, ISBN, price, releaseDate, genre);
        booklist.add(myBook);

        System.out.println(myBook.toString());

    }

    public static void viewBook() {
        if (booklist.isEmpty()) {
            System.out.println("Sorry, there are no books at the moment");

        } else {

            {
                for (int i = 0; i < booklist.size(); i++) {
                    System.out.println(booklist.get(i).toString());
                }
            }
        }

    }

    public static void editBook() {
        //search for the names in the obj in the array
        System.out.println("Please type in the ISBN");
        String ISBN = input.next();

        int index = -1; // to set as the book they have typed in
        if (!booklist.isEmpty()) {
            for (int i = 0; i < booklist.size(); i++) {
                if (ISBN.equals(booklist.get(i).getISBN())) {
                    index = i;
                    break;
                }
            }
        }

        if (index != -1) {
            System.out.println("What would you like to edit?");
            System.out.println("1 - name");
            System.out.println("2 - ISBN");
            System.out.println("3 - author");
            System.out.println("4 - price");
            System.out.println("5 - release date");
            System.out.println("6 - genre");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Please type in a name");
                    input.nextLine();
                    String newName = input.nextLine();
                    booklist.get(index).setName(newName);
                    break;
                case 2:
                    System.out.println("Please type in a ISBN");
                    input.nextLine();
                    String newISBN = input.nextLine();
                    booklist.get(index).setISBN(newISBN);
                    break;
                case 3:
                    System.out.println("Please type in a author");
                    input.nextLine();
                    String newAuthor = input.nextLine();
                    booklist.get(index).setAuthor(newAuthor);
                    break;
                case 4:
                    System.out.println("Please type in a price");
                    double newPrice = input.nextDouble();
                    booklist.get(index).setPrice(newPrice);
                    break;
                case 5:
                    System.out.println("Please type in a release date");
                    String newReleaseDate = input.nextLine();
                    booklist.get(index).setReleaseDate(newReleaseDate);
                    break;
                case 6:
                    System.out.println("Please type in a the genre");
                    input.nextLine();
                    String newGenre = input.nextLine();
                    booklist.get(index).setGenre(newGenre);
                    break;
            }
            System.out.println("Done, the book has been changes to " + booklist.get(index).toString());
        }

    }

    public static void deleteBook() {
        System.out.println("Please type in the ISBN");
        String ISBN = input.next();

        int index = -1; // to set as the book they have typed in
        if (!booklist.isEmpty()) {
            for (int i = 0; i < booklist.size(); i++) {
                if (ISBN.equals(booklist.get(i).getISBN())) {
                    index = i;
                    break;
                }
            }

        } else {
            System.out.println("Book not found");
        }

    }

    public static int getIndex() {
        System.out.println("Please type in the ISBN");
        String ISBN = input.next();

         // to set as the book they have typed in
        if (!booklist.isEmpty()) {
            for (int i = 0; i < booklist.size(); i++) {
                if (ISBN.equals(booklist.get(i).getISBN())) {
    
                    return i;
                }
            }
        }
        return -1;
    }
}
