package Observer;

public interface IPublisher {
    void addSubscriber(ISubscriber subscriber);
    void removeSubsriber(ISubscriber subscriber);
    void notifySubscribers(Object notification);
}
