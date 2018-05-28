package in.rahulja.algo.services.code.searching;

import java.util.List;

public interface SearchService<T> {

  void setList(List<T> list);

  int search(T element);

  int search(T element, List<T> list);

  boolean isPresent(T element);

  boolean isPresent(T element, List<T> list);

}
