package in.rahulja.algo.services.code.searching;

import in.rahulja.algo.code.searching.base.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("exponentialSearchService")
public class ExponentialSearchServiceImpl<T> extends SearchServiceImpl<T> {

  @Autowired
  public ExponentialSearchServiceImpl(Search<T> exponentialSearch) {
    this.search = exponentialSearch;
  }
}
