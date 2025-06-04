/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author toan4
 */
public class Baitap8 {
    public static void main(String[] args) {
        ServiceManager manager = new ServiceManager();
        manager.reactOnLog();
        manager.reactOnNotify();
        manager.reactOnSMS();
        manager.reactOnDB();
        manager.notify(manager);
    }
}

interface INotifying {
    void notify(Object sender);
}

class FileLogger implements INotifying {
    public void log(String message) {
        System.out.println("Ghi log tep: " + message);
    }

    @Override
    public void notify(Object sender) {
        log("Nhan thong bao tu: " + sender.getClass().getSimpleName());
    }
}

class EmailNotifier implements INotifying {
    public void notify(String message) {
        System.out.println("Gui email: " + message);
    }

    @Override
    public void notify(Object sender) {
        notify("Nhan thong bao tu: " + sender.getClass().getSimpleName());
    }
}

class SMSNotifier implements INotifying {
    public void sendSMS(String message) {
        System.out.println("Gui SMS: " + message);
    }

    @Override
    public void notify(Object sender) {
        sendSMS("Nhan thong bao tu: " + sender.getClass().getSimpleName());
    }
}

class DatabaseLogger implements INotifying {
    public void saveLog(String message) {
        System.out.println("Luu log vao co so du lieu: " + message);
    }

    @Override
    public void notify(Object sender) {
        saveLog("Nhan thong bao tu: " + sender.getClass().getSimpleName());
    }
}

class ServiceManager {
    private FileLogger fileLogger;
    private EmailNotifier emailNotifier;
    private SMSNotifier smsNotifier;
    private DatabaseLogger databaseLogger;

    public ServiceManager() {
        this.fileLogger = new FileLogger();
        this.emailNotifier = new EmailNotifier();
        this.smsNotifier = new SMSNotifier();
        this.databaseLogger = new DatabaseLogger();
    }

    public void notify(Object sender) {
        fileLogger.notify(sender);
        emailNotifier.notify(sender);
        smsNotifier.notify(sender);
        databaseLogger.notify(sender);
    }

    public void reactOnLog() {
        fileLogger.log("Su kien log");
    }

    public void reactOnNotify() {
        emailNotifier.notify("Thong bao email");
    }

    public void reactOnSMS() {
        smsNotifier.sendSMS("Thong bao SMS");
    }

    public void reactOnDB() {
        databaseLogger.saveLog("Du lieu log");
    }
}

