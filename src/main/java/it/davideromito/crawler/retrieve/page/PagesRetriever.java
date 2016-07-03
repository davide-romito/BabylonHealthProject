package it.davideromito.crawler.retrieve.page;

import it.davideromito.crawler.model.Page;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by davideromito on 28/06/16.
 */
public class PagesRetriever {
    private final static Integer NUMBER_THREAD_POOL = 3;
    private String basePage;

    public PagesRetriever(String base) {
        this.basePage = base;
    }

    /**
     * Given a set of url, it will parse the pages returning a set of objects page
     * @param urlSet set of url
     * @return set of objects page
     * @throws Exception
     */
    public Set<Page> retrievePages(Set<String> urlSet)  {
        ExecutorService pool = Executors.newFixedThreadPool(NUMBER_THREAD_POOL);
        Set<Future<Page>> set = new HashSet<Future<Page>>();
        for (String url : urlSet) {
            Callable<Page> callable = new PageRetrieverCallable(basePage + url);
            Future<Page> future = pool.submit(callable);
            set.add(future);
        }
        Set<Page> pages = new HashSet<Page>();
        for (Future<Page> future : set) {
            try {
                pages.add(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return pages;
    }
}
