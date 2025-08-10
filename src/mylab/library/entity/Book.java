package mylab.library.entity;

/**
 * ���� ������ ��� Ŭ����
 */
public class Book {
    private String title;        // ����
    private String author;       // ����
    private String isbn;         // ISBN
    private int publishYear;     // ���ǳ⵵
    private boolean isAvailable; // ������� (true: ���Ⱑ��, false: ������)
    
    /**
     * �⺻ ������ - ���� ���� ���·� �ʱ�ȭ
     */
    public Book() {
        this.isAvailable = true;
    }
    
    /**
     * ��� �ʵ带 �ʱ�ȭ�ϴ� ������ - ���� ���� ���·� �ʱ�ȭ
     */
    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true;  // �ʱ� ���� �� ���� ����
    }
    
    // Getter �޼����
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
    
    // Setter �޼����
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
     * ���� ���� ó�� �޼���
     * @return ���� ������ ��� true, �Ұ����� ��� false
     */
    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    
    /**
     * ���� �ݳ� ó�� �޼���
     */
    public void returnBook() {
        isAvailable = true;
    }
    
    /**
     * ���� ������ ���ڿ� ǥ�� ��ȯ
     */
    @Override
    public String toString() {
        return String.format("å ����: %s ����: %s ISBN: %s ���ǳ⵵: %d ���� ���� ����: %s",
                title, author, isbn, publishYear, 
                isAvailable ? "����" : "���� ��");
    }
}