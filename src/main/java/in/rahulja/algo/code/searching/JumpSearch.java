package in.rahulja.algo.code.searching;

import in.rahulja.algo.code.searching.base.LinearSearch;
import in.rahulja.algo.code.searching.base.Search;
import in.rahulja.algo.code.searching.base.SearchBase;
import java.util.List;
import java.util.Objects;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JumpSearch<T extends Comparable<T>> extends SearchBase<T> implements Search<T> {

  @Autowired
  public JumpSearch(LinearSearch<T> linearSearch) {
    blockSearch = linearSearch;
  }

  public JumpSearch(@NonNull List<T> initialList) {
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
    int jumpSize = (int) Math.floor(Math.sqrt(size));

    for (pointerAt = 0; pointerAt < size; pointerAt += jumpSize) {

      if (Objects.deepEquals(element, list.get(pointerAt))) {
        return pointerAt;
      }

      if (element.compareTo(list.get(pointerAt)) < 0) {
        break;
      }
    }

    int blockStartPointer = getBlockStartPosition(pointerAt, jumpSize);
    int blockEndPointer = getBlockEndPointer(pointerAt, size);

    return executeBlockSearch(blockStartPointer, blockEndPointer);
  }
}
