package in.rahulja.algo.code.searching.base;

import in.rahulja.algo.constants.SearchConstants;
import java.util.List;
import java.util.Objects;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class LinearSearch<T> extends SearchBase<T> implements Search<T> {

  public LinearSearch() {
    // empty constructor
  }

  public LinearSearch(@NonNull List<T> initialList) {
    setList(initialList);
  }

  public void setList(@NonNull List<T> initialList) {
    list = initialList;
  }

  @Override
  public int search(@NonNull T element) {

    for (int i = 0; i < list.size(); i++) {
      if (Objects.deepEquals(element, list.get(i))) {
        return i;
      }
    }
    return SearchConstants.NOT_FOUND;
  }
}
