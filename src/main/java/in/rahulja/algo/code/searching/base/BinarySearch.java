package in.rahulja.algo.code.searching.base;

import in.rahulja.algo.constants.SearchConstants;
import java.util.List;
import java.util.Objects;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class BinarySearch<T extends Comparable<T>> extends SearchBase<T> implements Search<T> {


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
  public int search(@NonNull T searchElement) {
    element = searchElement;

    if (passedBaseCaseCheck()) {
      return binarySearch(0, list.size() - 1);
    }

    return SearchConstants.NOT_FOUND;
  }

  private boolean passedBaseCaseCheck() {
    return element.compareTo(list.get(0)) >= 0
        && element.compareTo(list.get(list.size() - 1)) <= 0;
  }


  private int binarySearch(int start, int end) {

    int middle = getMiddle(start, end);
    T middleElement = list.get(middle);

    if (start == end && !Objects.deepEquals(element, middleElement)) {
      return SearchConstants.NOT_FOUND;
    }

    if (Objects.deepEquals(element, middleElement)) {
      return middle;
    }

    return recurseBinarySearch(start, end, middle);
  }


  private int getMiddle(int start, int end) {
    return (start + end) / 2;
  }


  private int recurseBinarySearch(int start, int end, int middle) {

    if (element.compareTo(list.get(middle)) < 0) {
      return binarySearch(start, middle - 1);
    } else {
      return binarySearch(middle + 1, end);
    }
  }
}
