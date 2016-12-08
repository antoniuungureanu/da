import java.util.ArrayList;


/**
 * Created by calin on 17.03.2016.
 */
public class EventBus {
    private static final EventBus instance = new EventBus();
    private LockReadWrite locker = new LockReadWrite();

    private EventBus(){}

    public static EventBus getInstance(){
        return instance;
    }

    private ArrayList<Subscription> subscriptions = new ArrayList<Subscription>();

    public void publish(News news) {
        try {
            locker.lockRead();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Subscription s : subscriptions) {

            if ( s.getFilter().filter(news) == true) {
                s.getSubscriber().inform(news);
                news.read();
            }
        }
        locker.unlockRead();
    }

    public void subscribe(Filter filter, ISubscriber subscriber) {
        try {
            locker.lockWrite();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        subscriptions.add(new Subscription(filter, subscriber));
        locker.unlockWrite();
    }

    public void unsubscribe(Filter filter, ISubscriber subscriber) {
        try {
            locker.lockWrite();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Subscription s : subscriptions) {
            if ( s.getFilter() == filter &&
                s.getSubscriber() == subscriber);

                   subscriptions.remove(s);
        }
        locker.unlockWrite();
    }

}

