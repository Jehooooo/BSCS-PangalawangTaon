import models.Book;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        app.MainMenu();
    }
    public void MainMenu(){
        while (true) {
            int options = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose an option:\n1. Book Management\n2. Member Management\n3. Borrowing System\n4. Search\n5. Exit"));
            switch (options) {
                case 1:
                    BookManagementMenu();
                    break;
                case 2:
                    //MemberManagementMenu();
                    break;
                case 3:
                    //BorrowingSystemMenu();
                    break;
                case 4:
                    //SearchMenu();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
}
    public ArrayList<Book> books = new ArrayList<>();
    public void BookManagementMenu(){
        int options = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose an option:\n1. Add Book\n2. Remove Book\n3. Update Book\n4. View All Books\n5. Back to Main Menu"));
        switch (options) {
            case 1:
                String title = JOptionPane.showInputDialog("Enter book title:");
                String author = JOptionPane.showInputDialog("Enter book author:");
                String category = JOptionPane.showInputDialog("Enter book category:");
                String isbn = JOptionPane.showInputDialog("Enter book ISBN:");
                Book newBook = new Book(title, author, category, isbn);
                //addBook(newBook);
                JOptionPane.showMessageDialog(null,"Book added successfully!"+newBook.displayInfo());
                books.add(newBook);
                break;
            case 2:
                String bookIdToRemove = JOptionPane.showInputDialog("Enter book number to remove: ");

                boolean removed = books.removeIf(book -> Integer.toString(book.getBookNumber()).equals(bookIdToRemove));
                if (removed) {
                    JOptionPane.showMessageDialog(null, "Book removed successfully!");
                }else {
                    JOptionPane.showMessageDialog(null, "Book not found.");
                }
                break;
            case 3:
                //updateBook();
                break;
            case 4:
                for (Book book : books) {
                    JOptionPane.showMessageDialog(null, book.displayInfo());
                    
                }
                break;
            case 5:
                MainMenu();
                break;
        }
    }


    public void MemberManagementMenu(){
        int options = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose an option:\n1. Add Member\n2. Remove Member\n3. Update Member\n4. View All Members\n5. Back to Main Menu"));
        switch (options) {
            case 1:
                //addMember();
                break;
            case 2:
                //removeMember();
                break;
            case 3:
                //updateMember();
                break;
            case 4:
                //viewAllMembers();
                break;
            case 5:
                MainMenu();
                break;
        }
    }
    public void BorrowingSystemMenu(){
        int options = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose an option:\n1. Borrow Book\n2. Return Book\n3. View Borrowed Books\n4. Back to Main Menu"));
        switch (options) {
            case 1:
                //borrowBook();
                break;
            case 2:
                //returnBook();
                break;
            case 3:
                //viewBorrowedBooks();
                break;
            case 4:
                MainMenu();
                break;
        }
    }
    public void SearchMenu(){
        int options = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose an option:\n1. Search Book by Title\n2. Search Book by Author\n3. Search Member by Name\n4. Back to Main Menu"));
        switch (options) {
            case 1:
                //searchBook();
                break;
            case 2:
                //searchMemberByName();
                break;
            case 3:
                //searchBorrowerByName();
                break;
            case 4:
                MainMenu();
                break;
        }
    }
}