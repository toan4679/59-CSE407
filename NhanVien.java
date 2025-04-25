import java.util.Scanner;

class NhanVien {
    protected String ten;
    protected int soGioLam;

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten nhan vien: ");
        ten = scanner.nextLine();
        System.out.print("Nhap so gio lam viec: ");
        soGioLam = scanner.nextInt();
    }

    public void hienThiThongTin() {
        System.out.println("Ten: " + ten);
        System.out.println("So gio lam: " + soGioLam);
    }

    public double tinhLuong() {
        return 0; 
    }
}

class NhanVienToanThoiGian extends NhanVien {
    @Override
    public double tinhLuong() {
        return soGioLam * 50000;
    }
}

class NhanVienBanThoiGian extends NhanVien {
    @Override
    public double tinhLuong() {
        return soGioLam * 30000;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhan vien toan thoi gian (1) hay Nhan vien ban thoi gian (2)? ");
        int luaChon = scanner.nextInt();
        scanner.nextLine(); 

        NhanVien nv;
        if (luaChon == 1) {
            nv = new NhanVienToanThoiGian();
        } else {
            nv = new NhanVienBanThoiGian();
        }

        nv.nhapThongTin();
        System.out.println("\n--- Bang Luong ---");
        nv.hienThiThongTin();
        System.out.println("Luong: " + nv.tinhLuong() + " VND");
    }
}
