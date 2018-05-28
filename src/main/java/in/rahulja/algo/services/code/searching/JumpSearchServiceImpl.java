package in.rahulja.algo.services.code.searching;

import in.rahulja.algo.code.searching.base.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jumpSearchService")
public class JumpSearchServiceImpl<T> extends SearchServiceImpl<T> {

  @Autowired
  public JumpSearchServiceImpl(Search<T> jumpSearch) {
    this.search = jumpSearch;
  }
}
