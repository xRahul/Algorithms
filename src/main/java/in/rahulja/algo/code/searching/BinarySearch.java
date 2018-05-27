package in.rahulja.algo.code.searching;

import in.rahulja.algo.constants.SearchConstants;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class BinarySearch<T extends Comparable<T>> implements Search<T> {

  @Getter
  private List<T> list;

  public BinarySearch() {
    // empty constructor
  }

  public BinarySearch(@NonNull List<T> initialList) {
    setList(initialList);
  }

  public void setList(@NonNull List<T> initialList) {
    list = initialList;
  }

  @Override
  public int search(@NonNull T element) {
    return binarySearch(element, 0, list.size() - 1);
  }

  private int binarySearch(T element, int start, int end) {

    int middle = getMiddle(start, end);
    T middleElement = list.get(middle);

    if (start == end && !Objects.deepEquals(element, middleElement)) {
      return SearchConstants.NOT_FOUND;
    }

    if (Objects.deepEquals(element, middleElement)) {
      return middle;
    }

    return recurseBinarySearch(element, start, end);
  }

  private int getMiddle(int start, int end) {
    return (start + end) / 2;
  }

  private int recurseBinarySearch(T element, int start, int end) {
    int middle = getMiddle(start, end);

    if (element.compareTo(list.get(middle)) < 0) {
      return binarySearch(element, start, middle - 1);
    } else {
      return binarySearch(element, middle + 1, end);
    }
  }
}
