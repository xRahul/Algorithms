package in.rahulja.algo.services;

import in.rahulja.algo.code.searching.Search;
import in.rahulja.algo.constants.SearchConstants;
import java.util.List;


public abstract class SearchServiceImpl<T> implements SearchService<T> {

  protected Search<T> search;

  private int searchListFor(T element) {
    return search.search(element);
  }

  @Override
  public void setList(List<T> list) {
    search.setList(list);
  }

  @Override
  public int search(T element) {
    return searchListFor(element);
  }

  @Override
  public int search(T element, List<T> list) {
    setList(list);
    return searchListFor(element);
  }

  @Override
  public boolean isPresent(T element) {
    return searchListFor(element) != SearchConstants.NOT_FOUND;
  }

  @Override
  public boolean isPresent(T element, List<T> list) {
    setList(list);
    return searchListFor(element) != SearchConstants.NOT_FOUND;
  }
}
