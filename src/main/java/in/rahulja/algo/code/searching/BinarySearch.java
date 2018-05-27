package in.rahulja.algo.code.searching;

import in.rahulja.algo.constants.SearchConstants;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class BinarySearch<T extends Comparable<T>> implements Search<T> {

  @Getter
  private List<T> list;

  public BinarySearch() {

  }

  public BinarySearch(List<T> initialList) {
    setList(initialList);
  }

  public void setList(List<T> initialList) {
    list = initialList;
  }

  @Override
  public int search(T element) {
    return binarySearch(element, 0, list.size() - 1);
  }

  private int binarySearch(T element, int start, int end) {

    int middle = (start + end) / 2;

    if (start == end && !Objects.deepEquals(element, list.get(middle))) {
      return SearchConstants.NOT_FOUND;
    }

    if (Objects.deepEquals(element, list.get(middle))) {
      return middle;
    }

    if (element.compareTo(list.get(middle)) < 0) {
      return binarySearch(element, start, middle - 1);
    } else {
      return binarySearch(element, middle + 1, end);
    }
  }
}
