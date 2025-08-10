package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;
import java.util.List;

/**
 * ������ ���� �ý��� �׽�Ʈ�� ���� ���� Ŭ����
 */
public class LibraryManagementSystem {
    
    public static void main(String[] args) {
        // 1. ������ ��ü ����
        Library library = new Library("�߾� ������");
        
        // 2. ���� ���� �߰�
        addSampleBooks(library);
        
        // 3. ������ ���� ���
        printLibraryStatus(library);
        
        // 4. ���� �˻� ��� �׽�Ʈ
        testFindBook(library);
        
        // 5. ���� ���� ��� �׽�Ʈ
        testCheckOut(library);
        
        // 6. ���� �ݳ� ��� �׽�Ʈ
        testReturn(library);
        
        // 7. ���� ������ ���� ��� ���
        displayAvailableBooks(library);
    }
    
    /**
     * ���� ���� ����� �������� �߰��ϴ� �޼���
     */
    private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
    }
    
    /**
     * ������ ���� ���¸� ����ϴ� �޼���
     */
    private static void printLibraryStatus(Library library) {
        System.out.println("\n===== " + library.getName() + " =====");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
        System.out.println();
    }
    
    /**
     * ����� ���ڷ� ������ �˻��ϴ� ����� �׽�Ʈ�ϴ� �޼���
     */
    private static void testFindBook(Library library) {
        System.out.println("===== ���� �˻� �׽�Ʈ =====");
        
        // �������� �˻�
        System.out.println("�������� �˻� ���:");
        Book book = library.findBookByTitle("�ڹ��� ����");
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("�ش� ������ ������ ã�� �� �����ϴ�.");
        }
        
        System.out.println();
        
        // ���ڷ� �˻�
        System.out.println("���ڷ� �˻� ���:");
        List<Book> booksByAuthor = library.findBooksByAuthor("Robert C. Martin");
        if (!booksByAuthor.isEmpty()) {
            for (Book b : booksByAuthor) {
                System.out.println(b);
            }
        } else {
            System.out.println("�ش� ������ ������ ã�� �� �����ϴ�.");
        }
        
        System.out.println();
    }
    
    /**
     * ���� ���� ����� �׽�Ʈ�ϴ� �޼���
     */
    private static void testCheckOut(Library library) {
        System.out.println("===== ���� ���� �׽�Ʈ =====");
        
        String isbn = "978-89-01-14077-4"; // �ڹ��� ����
        boolean success = library.checkOutBook(isbn);
        
        if (success) {
            System.out.println("���� ���� ����!");
            Book book = library.findBookByISBN(isbn);
            System.out.println("����� ���� ����:");
            System.out.println(book);
        } else {
            System.out.println("���� ���� ����!");
        }
        
        System.out.println();
        System.out.println("������ ���� ����:");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
        System.out.println();
    }
    
    /**
     * ���� �ݳ� ����� �׽�Ʈ�ϴ� �޼���
     */
    private static void testReturn(Library library) {
        System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
        
        String isbn = "978-89-01-14077-4"; // �ڹ��� ����
        boolean success = library.returnBook(isbn);
        
        if (success) {
            System.out.println("���� �ݳ� ����!");
            Book book = library.findBookByISBN(isbn);
            System.out.println("�ݳ��� ���� ����:");
            System.out.println(book);
        } else {
            System.out.println("���� �ݳ� ����!");
        }
        
        System.out.println();
        System.out.println("������ ���� ����:");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
        System.out.println();
    }
    
    /**
     * ���� ������ ���� ����� ����ϴ� �޼���
     */
    private static void displayAvailableBooks(Library library) {
        System.out.println("===== ���� ������ ���� ��� =====");
        
        List<Book> availableBooks = library.getAvailableBooks();
        
        if (availableBooks.isEmpty()) {
            System.out.println("���� ������ ������ �����ϴ�.");
        } else {
            for (Book book : availableBooks) {
                System.out.println(book);
                System.out.println("-----------------------------");
            }
        }
    }
}