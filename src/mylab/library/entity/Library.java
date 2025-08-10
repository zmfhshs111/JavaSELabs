package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� �÷����� �����ϴ� Ŭ����
 */
public class Library {
    private String name;           // ������ �̸�
    private List<Book> books;      // ���� ���
    
    /**
     * ������ �̸��� �ʱ�ȭ�ϰ� �� ���� ����� �����ϴ� ������
     */
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    
    // Getter �޼����
    public String getName() {
        return name;
    }
    
    public List<Book> getBooks() {
        return books;
    }
    
    /**
     * ������ �߰��ϴ� �޼���
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("������ �߰��Ǿ����ϴ�: " + book.getTitle());
    }
    
    /**
     * �������� ������ �˻��ϴ� �޼���
     * @param title �˻��� ����
     * @return ã�� ���� ��ü, ������ null
     */
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    
    /**
     * ���ڷ� ������ �˻��ϴ� �޼���
     * @param author �˻��� ���ڸ�
     * @return �ش� ������ ���� ���
     */
    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }
    
    /**
     * ISBN���� ������ �˻��ϴ� �޼���
     * @param isbn �˻��� ISBN
     * @return ã�� ���� ��ü, ������ null
     */
    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    
    /**
     * ISBN���� ������ �����ϴ� �޼���
     * @param isbn ������ ������ ISBN
     * @return ���� ���� �� true, ���� �� false
     */
    public boolean checkOutBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null && book.checkOut()) {
            return true;
        }
        return false;
    }
    
    /**
     * ISBN���� ������ �ݳ��ϴ� �޼���
     * @param isbn �ݳ��� ������ ISBN
     * @return �ݳ� ���� �� true, ���� �� false
     */
    public boolean returnBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            return true;
        }
        return false;
    }
    
    /**
     * ���� ������ ���� ����� ��ȯ�ϴ� �޼���
     * @return ���� ������ ���� ���
     */
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    
    /**
     * ��� ���� ����� ��ȯ�ϴ� �޼���
     * @return ��ü ���� ���
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
    
    /**
     * ��ü ���� ������ ��ȯ�ϴ� �޼���
     * @return ��ü ���� ��
     */
    public int getTotalBooks() {
        return books.size();
    }
    
    /**
     * ���� ������ ���� ������ ��ȯ�ϴ� �޼���
     * @return ���� ������ ���� ��
     */
    public int getAvailableBooksCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * ���� ���� ���� ������ ��ȯ�ϴ� �޼���
     * @return ���� ���� ���� ��
     */
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
}