import daos.BookDAO;
import models.BookDTO;

import java.awt.print.Book;

public class App {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();

        // get book by id
        System.out.println("Get book by id:");
        System.out.println(bookDAO.findById(1).toString());

        // get all books from DB
        System.out.println("\nGet all books:");
        bookDAO.findAll().forEach(car -> {
            System.out.println(car.toString());
        });

        // update book
        System.out.println("\nupdate a book:");
        BookDTO book = bookDAO.findAll().get(0);
        System.out.println(book);
        System.out.println("change to");
        book.setGenre("Fiction");
        System.out.println(bookDAO.update(book));
        System.out.println("change back to");
        book.setGenre("Non-Fiction");
        System.out.println(bookDAO.update(book));

        // add book into DB
        BookDTO book2 = new BookDTO(11, "Warriors", "Sandy Cheeks", "Fiction", 2001, "988103751");
        bookDAO.create(book2);
        System.out.println("\nAfter added book with id=11");
        bookDAO.findAll().forEach(c -> {
            System.out.println(c.toString());
        });

        // delete book into DB
        bookDAO.delete(11);
        System.out.println("\nAfter delete book with id=11");
        bookDAO.findAll().forEach(c -> {
            System.out.println(c.toString());
        });
    }
}
