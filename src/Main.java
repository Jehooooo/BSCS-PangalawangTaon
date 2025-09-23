import models.Book;
import models.Member;
import models.Student;
import models.Faculty;
import java.io.IOException;
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public ArrayList<Book> books = new ArrayList<>();
    protected ArrayList<Member> members = new ArrayList<>();// Not declared as final so the list contents can be updated (add, remove or update members).
    private static ArrayList <Student> students = new ArrayList<>();// Not declared as final so the list contents can be updated (add, remove  or update  members). but it can be a protected instead of private
    private static ArrayList <Faculty> faculties = new ArrayList<>();// Not declared as final so the list contents can be updated (add, remove or update  members).

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
                    MemberManagementMenu();
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

    public void BookManagementMenu()  {

        int options = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose an option:\n1. Add Book\n2. Remove Book\n3. Update Book\n4. View All Books\n5. Back to Main Menu"));
        //NEED RERTRICTIONS FOR THIS INPUT PART
        //NEED RERTRICTIONS FOR THIS INPUT PART
        //NEED RERTRICTIONS FOR THIS INPUT PART
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
                int bookIdToUpdate = Integer.parseInt(JOptionPane.showInputDialog("Enter book number to update: "));
                if ( bookIdToUpdate != 0) {
                    for (Book book : books) {
                        if ( book.getBookNumber() == bookIdToUpdate) {
                            String newTitle = JOptionPane.showInputDialog("Enter new title (leave blank to keep current):");
                            if (!newTitle.isEmpty()) {
                                book.setTitle(newTitle);
                            }
                            String newAuthor = JOptionPane.showInputDialog("Enter new author (leave blank to keep current):");
                            if (!newAuthor.isEmpty()) {
                                book.setAuthor(newAuthor);
                            }
                            String newCategory = JOptionPane.showInputDialog("Enter new category (leave blank to keep current):");
                            if (!newCategory.isEmpty()) {
                                book.setCategory(newCategory);
                            }
                            String newIsbn = JOptionPane.showInputDialog("Enter new ISBN (leave blank to keep current):");
                            if (!newIsbn.isEmpty()) {
                                book.setIsbn(newIsbn);
                            }
                            JOptionPane.showMessageDialog(null, "Book updated successfully!");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Book not found.");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid book number.");
                }
                break;
            case 4:
                for (Book book : books) {
                    System.out.print(books.toString());
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
                int memberType = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose member type:\n1. Student\n2. Faculty"));
                if (memberType == 1) {
                    String studName = JOptionPane.showInputDialog("Enter student name:");
                    int studId = Integer.parseInt(JOptionPane.showInputDialog("Enter student ID:"));
                    String studDept = JOptionPane.showInputDialog("Enter student department:");
                    String studLevel = JOptionPane.showInputDialog("Enter student level:");
                    String studMajor = JOptionPane.showInputDialog("Enter student major:");
                    Student newStudent = new Student(studName, studId, studDept, studLevel, studMajor);
                    newStudent.getMemberInfo();
                    System.out.println("Student Added Successfully"+newStudent.getMemberInfo());
                    students.add(newStudent);
                    members.add(newStudent);
                }else if (memberType == 2) {
                    String factName = JOptionPane.showInputDialog("Enter faculty name:");
                    int factId = Integer.parseInt(JOptionPane.showInputDialog("Enter faculty ID:"));
                    String factDept = JOptionPane.showInputDialog("Enter faculty department:");
                    String position = JOptionPane.showInputDialog("Enter faculty position: ");
                    Faculty newFaculty = new Faculty(factName, factId, factDept, position);
                    newFaculty.getMemberInfo();
                    System.out.println("Faculty Added Successfully"+newFaculty.getMemberInfo());
                    faculties.add(newFaculty);
                    members.add(newFaculty);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid member type.");
                    MemberManagementMenu();
                }


                //addMember();
                break;
            case 2:

                try {
                    if (students.isEmpty() && faculties.isEmpty()) {
                        throw new Exception("No members available to remove.");
                    }

                //select the type of member to remove
                int memberTypeToRemove = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose member type to remove:\n1. Student\n2. Faculty"));
                if (memberTypeToRemove == 1) {
                    String studIdToRemove = JOptionPane.showInputDialog("Enter student ID to remove: ");
                    boolean removedStudent = students.removeIf(Student -> Integer.toString(Student.getNumberID()).equals(studIdToRemove));
                } else if (memberTypeToRemove == 2) {
                    String factIdToRemove = JOptionPane.showInputDialog("Enter faculty ID to remove: ");
                    boolean removedFaculty = faculties.removeIf(Faculty -> Integer.toString(Faculty.getNumberID()).equals(factIdToRemove));
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid member type.");
                    MemberManagementMenu();

                }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    MemberManagementMenu();
                    return;
                }
                break;
            case 3:

                //updateMember();
                break;
            case 4:
                for (Student student : students) {
                    System.out.println(student.getMemberInfo());
                }
                for (Faculty faculty : faculties) {
                    System.out.println(faculty.getMemberInfo());
                }
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