package in.rahulja.algo.code.searching;

import in.rahulja.algo.code.searching.base.BinarySearch;
import in.rahulja.algo.code.searching.base.Search;
import in.rahulja.algo.code.searching.base.SearchBase;
import java.util.List;
import java.util.Objects;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExponentialSearch<T extends Comparable<T>> extends SearchBase<T> implements Search<T> {

  @Autowired
  public ExponentialSearch(BinarySearch<T> binarySearch) {
    blockSearch = binarySearch;
  }

  public ExponentialSearch(@NonNull List<T> initialList) {
    setList(initialList);
  }

  public void setList(@NonNull List<T> initialList) {
    list = initialList;
  }

  @Override
  public int search(@NonNull T searchElement) {

    element = searchElement;

    int pointerAt;
    int size = list.size();
    int jumpSize = 1;

    for (pointerAt = 0; pointerAt < size; pointerAt += jumpSize) {

      if (Objects.deepEquals(element, list.get(pointerAt))) {
        return pointerAt;
      }

      if (element.compareTo(list.get(pointerAt)) < 0) {
        break;
      }

      jumpSize *= 2;
    }

    int blockStartPointer = getBlockStartPosition(pointerAt, jumpSize);
    int blockEndPointer = getBlockEndPointer(pointerAt, size);

    return executeBlockSearch(blockStartPointer, blockEndPointer);
  }
}
