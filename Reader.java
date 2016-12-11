/**
 * Created by Antoniu on 08-Dec-16.
 */
public class Reader implements ISubscriber, Runnable {
    private EventBus eventBus = EventBus.getInstance();
    private Filter filter;

    public Reader(Filter filter) {
        this.filter = filter;

    }

    @Override
    public void subscribe(Filter filter) {
        eventBus.subscribe(filter, this);
    }

    @Override
    public void inform(News news) {
        System.out.println("Reader " + "News title: " + news.title + " news domain: " + news.domain);
    }

    @Override
    public void unsubscribe(Filter filter) {
        eventBus.unsubscribe(filter, this);
    }

    public void modifyFilter(Filter filter) {
        this.filter = filter;
    }

    public void subscribeWrapper() {
        subscribe(filter);
    }

    @Override
    public void run() {
        //subscribe(filter);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        unsubscribe(filter);
    }
}
