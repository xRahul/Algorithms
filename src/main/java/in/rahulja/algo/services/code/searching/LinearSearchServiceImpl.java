package in.rahulja.algo.services.code.searching;

import in.rahulja.algo.code.searching.base.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("linearSearchService")
public class LinearSearchServiceImpl<T> extends SearchServiceImpl<T> {

  @Autowired
  public LinearSearchServiceImpl(Search<T> linearSearch) {
    this.search = linearSearch;
  }
}
