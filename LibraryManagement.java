//importing libraries for using arraylist
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
//created by krishnaanupam56@gmail.com
//creating a new class library management
public class LibraryManagement
{
//total number of books available in the library
    private int totalNoBooks;
//number of books issued
    private int noOfIssuedBooks;
//arraylist for storing the list of all available books
    private final List<String> books = new ArrayList<>();
//arraylist for storing the list of all issued books
    private final List<String> issuedBooks = new ArrayList<>();

//method for adding a new book in the library
    public void addBook(String bookName)
    {
        if (totalNoBooks + 1 == books.size())//check for no space in the library
        {
            System.out.println("There is no space to add more books in the library.");
            return;
        }
        //check whether the has been already added or not
        for (String book : books)
        {
            if (Objects.equals(book, bookName))
            {
                System.out.println("The has been already added .");
                return;
            }
        }
        //adding a new book
         books.add(bookName);
         totalNoBooks++;
    }

//method for issuing a book
    public void issueBook(String bookName)
    {
        if (totalNoBooks == 0)//empty condition of library
        {
            System.out.println("No book to issue.");
            return;
        }
        //issuing the book
        for (int i = 0; i < totalNoBooks; i++)
        {
            if (Objects.equals(books.get(i), bookName))
            {
                issuedBooks.add(bookName);
                noOfIssuedBooks++;
                books.remove(i);
                totalNoBooks--;
                System.out.println(bookName + " has been issued.");
                return;
            }
        }
        //if book is not there in the library
        System.out.println("The required book is not available.\nPlease try after some time or take any other book.");
    }

//method for returning an issued book
    public void returnBook(String bookName)
    {
        for (int i = 0; i <noOfIssuedBooks ; i++)
        {
           if (Objects.equals(issuedBooks.get(i),bookName))
           {
             books.add(bookName);
             totalNoBooks++;
             issuedBooks.remove(bookName);
             noOfIssuedBooks--;
             System.out.println("The book has been returned successfully : ");
             return;
           }
        }
        //if the book was not issued from that library
        System.out.println("This book does not belongs to our library.\n we can't take it back .");
    }

//method for showing the list of available books in the library
    public void showAvailableBooks()
    {
        if(totalNoBooks==0)//empty condition of the library
        {
            System.out.println("We don't have any book to show .");
            return;
        }
        System.out.println("Available books are:");
        for (int i = 0; i < totalNoBooks; i++)
        {
           int j=i+1;
           System.out.println(j+ ". " + books.get(i));
        }
    }

//method for displaying the list of all issued books
    public void showIssuedBooks()
    {
        if (noOfIssuedBooks == 0)//empty condition of the issue book list
        {
            System.out.println("No books have been issued.");
            return;
        }
        System.out.println("Issued books are:");
        for (int i = 0; i < noOfIssuedBooks; i++)
        {
            int j = i + 1;
            System.out.println(j + ". " + issuedBooks.get(i));
        }
    }

    //driver's code
    public static void main(String[] args)
    {
        //creating a new library branch library1
        LibraryManagement library1 = new LibraryManagement();
        //adding books in the library
        library1.addBook("Java");
        library1.addBook("Python");
        library1.addBook("JavaScript");
        library1.addBook("MySQL");
        library1.addBook("Node.js");
        library1.addBook("React.js");
        library1.addBook("CSS");
        library1.addBook("HTML");
        library1.addBook("MongoDB");
        library1.addBook("Django");
        //displaying all available books in library
        library1.showAvailableBooks();
        //issuing book named as 'Mysql'(case-sensitive)
        library1.issueBook("MySQL");
        //looking at the list of available books after issuing a book
        library1.showAvailableBooks();
        //display list of issued books
        library1.showIssuedBooks();
        //trying to issue a book which is not in the library
        library1.issueBook("Krishna");
        //returning the already issued book
        library1.returnBook("MySQL");
        //displaying the list of available books after returning the book
        library1.showAvailableBooks();
        //looking for changes in issued book list after returning the book
        library1.showIssuedBooks();
    }
}
