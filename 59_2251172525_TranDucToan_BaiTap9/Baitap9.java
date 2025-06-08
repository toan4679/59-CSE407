interface IStrategy {
    void execute(String message);
}

class FileLogger implements IStrategy {
    public void execute(String message) {
        System.out.println("Ghi nhật ký vào file: " + message);
    }
}

class EmailNotifier implements IStrategy {
    public void execute(String message) {
        System.out.println("Gửi thông báo qua email: " + message);
    }
}

class Context {
    private IStrategy strategy;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void doService(String message) {
        strategy.execute(message);
    }
}

public class Baitap9 {
    public static void main(String[] args) {
        Context context = new Context();

        context.setStrategy(new FileLogger());
        context.doService("Đây là thông điệp mẫu");

        context.setStrategy(new EmailNotifier());
        context.doService("Đây là thông điệp mẫu");
    }
}
