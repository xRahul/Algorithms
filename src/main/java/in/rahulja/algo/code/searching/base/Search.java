package in.rahulja.algo.code.searching.base;

import java.util.List;

public interface Search<T> {

  void setList(List<T> initialList);

  int search(T element);

}
