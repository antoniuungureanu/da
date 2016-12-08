import java.util.ArrayList;

/**
 * Created by calin on 17.03.2016.
 */
public class Filter {
    final public String parentDomain;
    final public String domain;
    final public String source;
    public String lastChange;
    final public String firstPublish;
    final public String author;
    final public String title;

    public Filter(String parentDomain, String domain, String source, String lastChange, String firstPublish, String author, String title){
        this.title = title;
        this.parentDomain = parentDomain;
        this.domain = domain;
        this.source = source;
        this.lastChange = lastChange;
        this.firstPublish = firstPublish;
        this.author = author;
    }

    boolean filter(News news){

        if(parentDomain != null && !parentDomain.equals(news.parentDomain))
            return false;
        if(domain != null && !domain.equals(news.domain))
            return false;
        if(source != null && !source.equals(news.source))
            return false;
        if(lastChange!=null && !lastChange.equals(news.lastChange))
            return false;
        if(firstPublish!=null && !firstPublish.equals(news.firstPublish))
            return false;
        if(author!=null && !author.equals(news.author))
            return false;
        if(title!=null && !title.equals(news.title))
            return false;

        return true;
    }
}
