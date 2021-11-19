import com.demo.spi.Search;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<Search> searches = ServiceLoader.load(Search.class);
        Iterator<Search> searchIterator = searches.iterator();
        while (searchIterator.hasNext()) {
            Search search = searchIterator.next();
            System.out.println(search.search("hello"));
        }
    }
}
