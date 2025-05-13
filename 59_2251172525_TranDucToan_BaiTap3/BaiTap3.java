/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



interface ILogging {
    void log(String message);
}

interface INotifying {
    void notify(String message);
}

class FileLogger implements ILogging {
    @Override
    public void log(String message) {
        System.out.println("Ghi log: " + message);
    }
}

class EmailNotifier implements INotifying {
    @Override
    public void notify(String message) {
        System.out.println("Gui thong bao email: " + message);
    }
}

class ServiceManager implements ILogging, INotifying {
    @Override
    public void log(String message) {
        System.out.println("Service log: " + message);
    }

    @Override
    public void notify(String message) {
        System.out.println("Service notify: " + message);
    }
}

abstract class LoggerFactory {
    public abstract ILogging createLogger();
}

abstract class NotifierFactory {
    public abstract INotifying createNotifier();
}

class FileLoggerFactory extends LoggerFactory {
    @Override
    public ILogging createLogger() {
        return new FileLogger();
    }
}

class ServiceLoggerFactory extends LoggerFactory {
    @Override
    public ILogging createLogger() {
        return new ServiceManager();
    }
}

class EmailNotifierFactory extends NotifierFactory {
    @Override
    public INotifying createNotifier() {
        return new EmailNotifier();
    }
}

class ServiceNotifierFactory extends NotifierFactory {
    @Override
    public INotifying createNotifier() {
        return new ServiceManager();
    }
}

public class BaiTap3 {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new FileLoggerFactory();
        ILogging logger = loggerFactory.createLogger();
        logger.log("Day la thong bao log");

        NotifierFactory notifierFactory = new EmailNotifierFactory();
        INotifying notifier = notifierFactory.createNotifier();
        notifier.notify("Day la thong bao notify");

        LoggerFactory serviceLoggerFactory = new ServiceLoggerFactory();
        ILogging serviceLogger = serviceLoggerFactory.createLogger();
        serviceLogger.log("Log tu ServiceManager");

        NotifierFactory serviceNotifierFactory = new ServiceNotifierFactory();
        INotifying serviceNotifier = serviceNotifierFactory.createNotifier();
        serviceNotifier.notify("Notify tu ServiceManager");
    }
}

