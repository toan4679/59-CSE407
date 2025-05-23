public class Baitap5 {

    interface IBuilder {
        void khoiTaoLai();
        void xayDungBuocGhiLog();
        void xayDungBuocThongBao();
    }

    static class FileLogger {
        public void ghiFile() {
            System.out.println("Ghi log vao file.");
        }
    }

    static class EmailNotifier {
        public void guiEmailThongBao() {
            System.out.println("Gui thong bao qua email.");
        }
    }

    static class FileLoggerBuilder implements IBuilder {
        private FileLogger ketQua;

        public FileLoggerBuilder() {
            khoiTaoLai();
        }

        @Override
        public void khoiTaoLai() {
            ketQua = new FileLogger();
        }

        @Override
        public void xayDungBuocGhiLog() {
            System.out.println("Ghi log cho file logger.");
        }

        @Override
        public void xayDungBuocThongBao() {
            System.out.println("Thong bao cho file logger.");
        }

        public FileLogger layKetQua() {
            return ketQua;
        }
    }

    static class EmailNotifierBuilder implements IBuilder {
        private EmailNotifier ketQua;

        public EmailNotifierBuilder() {
            khoiTaoLai();
        }

        @Override
        public void khoiTaoLai() {
            ketQua = new EmailNotifier();
        }

        @Override
        public void xayDungBuocGhiLog() {
            System.out.println("Ghi log cho email notifier.");
        }

        @Override
        public void xayDungBuocThongBao() {
            System.out.println("Thong bao cho email notifier.");
        }

        public EmailNotifier layKetQua() {
            return ketQua;
        }
    }

    static class NguoiDieuKhienDichVu {
        private IBuilder builder;

        public NguoiDieuKhienDichVu(IBuilder builder) {
            this.builder = builder;
        }

        public void tao(String loai) {
            builder.khoiTaoLai();
            if (loai.equalsIgnoreCase("Logger")) {
                builder.xayDungBuocGhiLog();
            } else if (loai.equalsIgnoreCase("Notifier")) {
                builder.xayDungBuocThongBao();
            } else {
                System.out.println("Khong xac dinh loai.");
            }
        }
    }

    public static void main(String[] args) {
        FileLoggerBuilder fileBuilder = new FileLoggerBuilder();
        NguoiDieuKhienDichVu dieuKhien1 = new NguoiDieuKhienDichVu(fileBuilder);
        dieuKhien1.tao("Logger");
        FileLogger fileLogger = fileBuilder.layKetQua();
        fileLogger.ghiFile();

        EmailNotifierBuilder emailBuilder = new EmailNotifierBuilder();
        NguoiDieuKhienDichVu dieuKhien2 = new NguoiDieuKhienDichVu(emailBuilder);
        dieuKhien2.tao("Notifier");
        EmailNotifier emailNotifier = emailBuilder.layKetQua();
        emailNotifier.guiEmailThongBao();
    }
}
