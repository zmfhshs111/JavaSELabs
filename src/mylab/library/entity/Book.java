package mylab.library.entity;

/**
 * 도서 정보를 담는 클래스
 */
public class Book {
    private String title;        // 제목
    private String author;       // 저자
    private String isbn;         // ISBN
    private int publishYear;     // 출판년도
    private boolean isAvailable; // 대출상태 (true: 대출가능, false: 대출중)
    
    /**
     * 기본 생성자 - 대출 가능 상태로 초기화
     */
    public Book() {
        this.isAvailable = true;
    }
    
    /**
     * 모든 필드를 초기화하는 생성자 - 대출 가능 상태로 초기화
     */
    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true;  // 초기 생성 시 대출 가능
    }
    
    // Getter 메서드들
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public int getPublishYear() {
        return publishYear;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Setter 메서드들
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
    
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    /**
     * 도서 대출 처리 메서드
     * @return 대출 가능한 경우 true, 불가능한 경우 false
     */
    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    
    /**
     * 도서 반납 처리 메서드
     */
    public void returnBook() {
        isAvailable = true;
    }
    
    /**
     * 도서 정보의 문자열 표현 반환
     */
    @Override
    public String toString() {
        return String.format("책 제목: %s 저자: %s ISBN: %s 출판년도: %d 대출 가능 여부: %s",
                title, author, isbn, publishYear, 
                isAvailable ? "가능" : "대출 중");
    }
}