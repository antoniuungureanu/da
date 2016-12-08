/**
 * Created by calin on azi.
 */
public class TestMain {
    public static void main(String argv[]){
        Filter filter1 = new Filter(null, null, null, null, null, null, "Ion");
        Filter filter2 = new Filter("sport", null, null, null, null, null, null);
        Filter filter3 = new Filter(null, "tenis", null, null, null, null, null);
        Filter curva = new Filter(null, null, null, null, null, null, null);

        News news1 = new News("sport", null, null, null, null, "Ion");
        News news2 = new News(null, "tenis", null, null, null, null);
        News news3 = new News(null, null, null, null, null, "Ion");
        News news4 =  new News(null, null, null, "diana...", null,null);

        Editor editor1 = new Editor(news1, filter2);
        Editor editor2 = new Editor(news2, filter3);
        Reader reader1 = new Reader(filter2);

        new Thread(reader1).start();
        new Thread(editor1).start();
        new Thread(editor2).start();
    }
}

