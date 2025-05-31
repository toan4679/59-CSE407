/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author toan4
 */
interface ILogger {
    void Log(String message);
    void Warn(String message);
    void Error(String message);
}

interface INotifying {
    void Notify(String message);
    void Alert(String message);
    void Confirm(String message);
}

class FileLogger implements ILogger {
    public void Log(String message) {
        System.out.println("GHI NHAT KY: " + message);
    }

    public void Warn(String message) {
        System.out.println("CANH BAO: " + message);
    }

    public void Error(String message) {
        System.out.println("LOI: " + message);
    }
}

class EmailNotifier implements INotifying {
    public void Notify(String message) {
        System.out.println("Thong bao qua Email: " + message);
    }

    public void Alert(String message) {
        System.out.println("Canh bao qua Email: " + message);
    }

    public void Confirm(String message) {
        System.out.println("Xac nhan qua Email: " + message);
    }
}

class ServiceManager {
    protected ILogger logger;
    protected INotifying notifier;

    public ServiceManager(ILogger logger, INotifying notifier) {
        this.logger = logger;
        this.notifier = notifier;
    }

    public void Log(String message) {
        logger.Log(message);
    }

    public void Notify(String message) {
        notifier.Notify(message);
    }
}

class AdvancedServiceManager extends ServiceManager {
    public AdvancedServiceManager(ILogger logger, INotifying notifier) {
        super(logger, notifier);
    }

    public void featureN() {
        System.out.println("Dang thuc hien tinh nang nang cao ...");
    }
}

public class BaiTap7 {
    public static void main(String[] args) {
        ILogger logger = new FileLogger();
        INotifying notifier = new EmailNotifier();

        ServiceManager service = new ServiceManager(logger, notifier);
        service.Log("Khoi dong dich vu");
        service.Notify("He thong da san sang");

        AdvancedServiceManager advService = new AdvancedServiceManager(logger, notifier);
        advService.featureN();
        advService.Log("Ghi log tu AdvancedServiceManager");
    }
}

