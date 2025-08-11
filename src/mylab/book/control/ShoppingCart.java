package mylab.book.control;

import mylab.book.entity.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Publication> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
    }

    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
                return true;
            }
        }
        System.out.println("�ش� ������ ���ǹ��� ã�� �� �����ϴ�.");
        return false;
    }

    public void displayCart() {
        System.out.println("\n====== ��ٱ��� ���� ======");
        if (items.isEmpty()) {
            System.out.println("��ٱ��ϰ� ����ֽ��ϴ�.");
            return;
        }
        for (Publication item : items) {
            System.out.println("- " + item.toString());
        }
        System.out.println("-------------------------");
        System.out.println("�� ���� (���� ��): " + calculateTotalPrice() + "��");
        System.out.println("�� ���� (���� ��): " + calculateDiscountedPrice() + "��");
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public int calculateDiscountedPrice() {
        double total = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                total += item.getPrice() * 0.9;  // 10% ����
            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85; // 15% ����
            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8;  // 20% ����
            } else {
                total += item.getPrice();
            }
        }
        return (int)total;
    }
    
    public void printStatistics() {
        int magazineCount = 0;
        int novelCount = 0;
        int referenceBookCount = 0;
        
        for (Publication item : items) {
            if (item instanceof Magazine) magazineCount++;
            else if (item instanceof Novel) novelCount++;
            else if (item instanceof ReferenceBook) referenceBookCount++;
        }

        System.out.println("====== ��ٱ��� ��� ======");
        System.out.println("����: " + magazineCount + "��");
        System.out.println("�Ҽ�: " + novelCount + "��");
        System.out.println("����: " + referenceBookCount + "��");
        System.out.println("�� ���ǹ�: " + items.size() + "��");
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"));
        cart.addItem(new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"));
        cart.addItem(new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"));
        cart.addItem(new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"));
        
        cart.displayCart();
        cart.printStatistics();

        System.out.println("\n'���߿�' �׸��� �����մϴ�.");
        cart.removeItem("���߿�");
        
        cart.displayCart();
    }
}

// ==================================================================================

// ���ϸ�: StatisticsAnalyzer.java
