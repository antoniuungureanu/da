import java.util.ArrayList;

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

        ArrayList<Editor> editors = new ArrayList<>();
        for ( int i = 0; i < 10; i++) {
            Editor e = new Editor(news1, filter2);
            editors.add(e);
            e.subscribeWrapper();
        }
        editor1.subscribeWrapper();
        editor2.subscribeWrapper();
        ArrayList<Thread> threads = new ArrayList<>();
        Thread readerT = new Thread(reader1); reader1.subscribeWrapper(); readerT.start();
        for ( Editor e : editors) {
            Thread t = new Thread(e);
            threads.add(t);
            t.start();
        }

        new Thread(editor1).start();
        new Thread(editor2).start();
        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            readerT.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EventBus.getInstance().printNumbOfPub();
    }
}

