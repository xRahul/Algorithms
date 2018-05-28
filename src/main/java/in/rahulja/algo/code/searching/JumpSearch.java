package in.rahulja.algo.code.searching;

import in.rahulja.algo.constants.SearchConstants;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class JumpSearch<T extends Comparable<T>> implements Search<T> {

  @Getter
  private List<T> list;
  private T element;

  public JumpSearch() {
    // empty constructor
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

    return linearBlockSearch(pointerAt, jumpSize, size);
  }


  private int linearBlockSearch(int blockEndPointer, int jumpSize, int size) {

    int pointerAt = blockEndPointer <= 0 ? 0 : blockEndPointer - jumpSize;

    for (; pointerAt < blockEndPointer && pointerAt < size; pointerAt++) {
      if (Objects.deepEquals(element, list.get(pointerAt))) {
        return pointerAt;
      }
    }

    return SearchConstants.NOT_FOUND;
  }
}
