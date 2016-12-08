/**
 * Created by calin on 17.03.2016.
 */
public class Subscription {
    private Filter filter;
    private ISubscriber subscriber;

    public Subscription(Filter filter, ISubscriber subscriber) {
        this.filter = filter;
        this.subscriber = subscriber;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
    }
}
