/**
 * Created by calin on 17.03.2016.
 */
public interface ISubscriber {


    void subscribe(Filter filter);

    //set action onEvent
    void inform(News news);

    void unsubscribe(Filter filter);
}
