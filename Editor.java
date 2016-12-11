import java.util.Calendar;
import java.util.Date;

/**
 * Created by Antoniu on 08-Dec-16.
 */
public class Editor implements IPublisher, ISubscriber, Runnable {
    private EventBus eventBus;
    private News news;
    private Filter filter;

    public Editor(News news, Filter filter) {
        eventBus = EventBus.getInstance();
        this.news = news;
        this.filter = filter;

    }
    @Override
    public void publish(News news) {
        eventBus.publish(news);
    }

    @Override
    public void edit(News news) {
        news.update(Calendar.getInstance().getTime().toString());
        publish(news);
    }

    @Override
    public void subscribe(Filter filter) {
        eventBus.subscribe(filter, this);
    }

    @Override
    public void inform(News news) {
        System.out.println("Editor " + "news title: " + news.title + " Count no: " + news.readCount);
    }

    @Override
    public void unsubscribe(Filter filter) {
        eventBus.unsubscribe(filter, this);
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public void subscribeWrapper() {
        subscribe(filter);
    }

    @Override
    public void run() {
        //subscribe(filter);
        publish(news);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
