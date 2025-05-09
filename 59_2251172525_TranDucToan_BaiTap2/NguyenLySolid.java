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

public class NguyenLySolid {
    public static void main(String[] args) {
        ILogging fileLogger = new FileLogger();
        fileLogger.log("Day la log file");

        INotifying emailNotifier = new EmailNotifier();
        emailNotifier.notify("Day la thong bao email");

        ServiceManager serviceManager = new ServiceManager();
        serviceManager.log("Log tu service");
        serviceManager.notify("Thong bao tu service");
    }
}
