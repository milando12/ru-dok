package Error;

import Observer.IPublisher;
import Observer.ISubscriber;
import View.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class ErrorFactory implements IPublisher {
    private List<ISubscriber> subscribers;

    public void generateError(String message, int type, String title){
        notifySubscribers(new MyError(message, type, title));
    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if (subscribers==null) subscribers= new ArrayList<>();
        else if (subscriber== null || subscribers.contains(subscriber)) return;
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubsriber(ISubscriber subscriber) {
        if (subscribers== null || subscriber==null|| !subscribers.contains(subscriber)) return;
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty()) return;

        for (ISubscriber listener: subscribers) {
            listener.update(notification);
        }
    }

    public static ErrorFactory instance;

    public static ErrorFactory getInstance(){
        if (instance== null){
            instance= new ErrorFactory();
        }
        return instance;
    }
}
