import java.util.Date;

/**
 * Created by Antoniu on 08-Dec-16.
 */
public class News {

    final public String parentDomain;
    final public String domain;
    final public String source;
    public String lastChange;
    final public String firstPublish;
    final public String author;
    final public String title;
    public int readCount = 0;

    public News(String parentDomain, String domain, String source, String firstPublish, String author, String title){
        this.title = title;
        this.parentDomain = parentDomain;
        this.domain = domain;
        this.source = source;
        this.lastChange = firstPublish;
        this.firstPublish = firstPublish;
        this.author = author;
    }

    public void update(String lastChange){
        this.lastChange = lastChange;
    }

    public void read() {
        readCount++;
    }


}
