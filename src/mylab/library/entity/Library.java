package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 도서 컬렉션을 관리하는 클래스
 */
public class Library {
    private String name;           // 도서관 이름
    private List<Book> books;      // 도서 목록
    
    /**
     * 도서관 이름을 초기화하고 빈 도서 목록을 생성하는 생성자
     */
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    
    // Getter 메서드들
    public String getName() {
        return name;
    }
    
    public List<Book> getBooks() {
        return books;
    }
    
    /**
     * 도서를 추가하는 메서드
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }
    
    /**
     * 제목으로 도서를 검색하는 메서드
     * @param title 검색할 제목
     * @return 찾은 도서 객체, 없으면 null
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
     * 저자로 도서를 검색하는 메서드
     * @param author 검색할 저자명
     * @return 해당 저자의 도서 목록
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
     * ISBN으로 도서를 검색하는 메서드
     * @param isbn 검색할 ISBN
     * @return 찾은 도서 객체, 없으면 null
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
     * ISBN으로 도서를 대출하는 메서드
     * @param isbn 대출할 도서의 ISBN
     * @return 대출 성공 시 true, 실패 시 false
     */
    public boolean checkOutBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null && book.checkOut()) {
            return true;
        }
        return false;
    }
    
    /**
     * ISBN으로 도서를 반납하는 메서드
     * @param isbn 반납할 도서의 ISBN
     * @return 반납 성공 시 true, 실패 시 false
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
     * 대출 가능한 도서 목록을 반환하는 메서드
     * @return 대출 가능한 도서 목록
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
     * 모든 도서 목록을 반환하는 메서드
     * @return 전체 도서 목록
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
    
    /**
     * 전체 도서 개수를 반환하는 메서드
     * @return 전체 도서 수
     */
    public int getTotalBooks() {
        return books.size();
    }
    
    /**
     * 대출 가능한 도서 개수를 반환하는 메서드
     * @return 대출 가능한 도서 수
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
     * 대출 중인 도서 개수를 반환하는 메서드
     * @return 대출 중인 도서 수
     */
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
}