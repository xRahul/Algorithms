package in.rahulja.algo.services;

import in.rahulja.algo.code.searching.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("binarySearchService")
public class BinarySearchServiceImpl<T> extends SearchServiceImpl<T> {

  @Autowired
  public BinarySearchServiceImpl(Search<T> binarySearch) {
    this.search = binarySearch;
  }
}
