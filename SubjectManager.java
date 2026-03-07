package Baiseasion15;

import java.util.ArrayList;

public class SubjectManager<T extends Subject> {

    private ArrayList<T> list = new ArrayList<>();

    public void add(T subject) {
        list.add(subject);
        System.out.println("Thêm môn học thành công.");
    }

    public void remove(String code) {
        for (T s : list) {
            if (s.getCode().equals(code)) {
                list.remove(s);
                System.out.println("Đã xóa môn học.");
                return;
            }
        }
        System.out.println("Không tìm thấy môn học.");
    }

    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        for (T s : list) {
            System.out.println(s);
        }
    }

    public void search(String name) {
        for (T s : list) {
            if (s.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(s);
            }
        }
    }

    public void filterCredits(int credits) {
        for (T s : list) {
            if (s.getCredits() == credits) {
                System.out.println(s);
            }
        }
    }
}
