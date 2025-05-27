/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author toan4
 */
public class Baitap6 {
    public static void main(String[] args) {
        EmailNotifier emailNotifier = new EmailNotifier();
        NotifierAdapter adapter = new NotifierAdapter(emailNotifier);
        ServiceManager serviceManager = new ServiceManager(adapter);
        serviceManager.Notify("Day la thong bao bang email");
    }
}

interface INotifying {
    void Notify(String message);
}

class EmailNotifier {
    public void SendEmail(String msg) {
        System.out.println("Dang gui email: " + msg);
    }
}

class NotifierAdapter implements INotifying {
    private EmailNotifier adapter;

    public NotifierAdapter(EmailNotifier adapter) {
        this.adapter = adapter;
    }

    public void Notify(String message) {
        adapter.SendEmail(message);
    }
}

class ServiceManager {
    private INotifying notifying;

    public ServiceManager(INotifying notifying) {
        this.notifying = notifying;
    }

    public void Notify(String message) {
        notifying.Notify(message);
    }
}
