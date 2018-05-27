package in.rahulja.algo.code.searching;

import in.rahulja.algo.constants.SearchConstants;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class LinearSearch<T> implements Search<T> {

  @Getter
  private List<T> list;

  public LinearSearch() {

  }

  public LinearSearch(List<T> initialList) {
    setList(initialList);
  }

  public void setList(List<T> initialList) {
    list = initialList;
  }

  @Override
  public int search(T element) {

    for (int i = 0; i < list.size(); i++) {
      if (Objects.deepEquals(element, list.get(i))) {
        return i;
      }
    }
    return SearchConstants.NOT_FOUND;
  }
}