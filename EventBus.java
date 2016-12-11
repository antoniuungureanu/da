import java.util.ArrayList;


/**
 * Created by calin on 17.03.2016.
 */
public class EventBus {
    private static EventBus instance;
    private LockReadWrite locker;
    private int numberOfPub;

    private EventBus(){
        numberOfPub = 0;
        locker = new LockReadWrite();
    }

    public static EventBus getInstance() {
        if (instance == null)
            instance = new EventBus();
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
                numberOfPub++;
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
            locker.lockRead();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Subscription s : subscriptions) {
            if (s.getFilter() == filter &&
                    s.getSubscriber() == subscriber) ;

            locker.unlockRead();

            try {
                locker.lockWrite();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            subscriptions.remove(s);

            locker.unlockWrite();
            break;
        }

    }
    public void printNumbOfPub() {
        System.out.println("number of Publishes " + numberOfPub);
    }

}

