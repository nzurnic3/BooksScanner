package scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main program
public class Main {
    public static List<Book> loadBooks(String fileName){
        ArrayList<Book> books = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(fileName));
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(", ");
                String title = data[0];
                String author = data[1];
                int year = Integer.parseInt(data[2]);
                int pages = Integer.parseInt(data[3]);
                Book k = new Book(title, author, year, pages);
                books.add(k);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }
    public static void main(String[] args) {
        List<Book> books = loadBooks("knjige.txt");
        System.out.println(books);
    }
}
