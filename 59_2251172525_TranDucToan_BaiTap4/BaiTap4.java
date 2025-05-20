/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author toan4
 */
interface ILogger {
    void Output();
}

interface INotifier {
    void Output();
}

class FileLogger implements ILogger {
    public void Output() {
        System.out.println("Ghi log vao file...");
    }
}

class ServiceLogger implements ILogger {
    public void Output() {
        System.out.println("Ghi log vao dich vu...");
    }
}

class EmailNotifier implements INotifier {
    public void Output() {
        System.out.println("Gui thong bao qua Email...");
    }
}

class SMSNotifier implements INotifier {
    public void Output() {
        System.out.println("Gui thong bao qua SMS...");
    }
}

interface NotificationFactory {
    ILogger createLogger();
    INotifier createNotifier();
}

class BasicNotificationFactory implements NotificationFactory {
    public ILogger createLogger() {
        return new FileLogger();
    }

    public INotifier createNotifier() {
        return new EmailNotifier();
    }
}

class AdvancedNotificationFactory implements NotificationFactory {
    public ILogger createLogger() {
        return new ServiceLogger();
    }

    public INotifier createNotifier() {
        return new SMSNotifier();
    }
}

class Client {
    private NotificationFactory factory;

    public Client(NotificationFactory factory) {
        this.factory = factory;
    }

    public void someOperation() {
        ILogger logger = factory.createLogger();
        INotifier notifier = factory.createNotifier();

        logger.Output();
        notifier.Output();
    }
}

public class BaiTap4 {
    public static void main(String[] args) {
        NotificationFactory basicFactory = new BasicNotificationFactory();
        Client client1 = new Client(basicFactory);
        System.out.println("== Thong bao co ban ==");
        client1.someOperation();

        NotificationFactory advancedFactory = new AdvancedNotificationFactory();
        Client client2 = new Client(advancedFactory);
        System.out.println("\n== Thong bao nang cao ==");
        client2.someOperation();
    }
}
