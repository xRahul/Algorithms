package in.rahulja.algo.code.searching.base;

import in.rahulja.algo.constants.SearchConstants;
import java.util.List;
import lombok.Getter;

public abstract class SearchBase<T> implements Search<T> {

  @Getter
  protected List<T> list;
  protected T element;
  protected Search<T> blockSearch;


  @Override
  public void setList(List<T> initialList) {
    list = initialList;
  }


  protected int getBlockEndPointer(int pointer, int listSize) {
    int blockEndPointer = pointer;

    if (pointer >= listSize) {
      blockEndPointer = listSize - 1;
    } else if (pointer < 0) {
      blockEndPointer = 0;
    }

    return blockEndPointer;
  }


  protected int getBlockStartPosition(int pointer, int jumpSize) {
    return pointer - jumpSize <= 0 ? 0 : pointer - jumpSize;
  }


  protected int executeBlockSearch(int blockStart, int blockEnd) {

    blockSearch.setList(list.subList(blockStart, blockEnd + 1));
    int blockPosition = blockSearch.search(element);

    if (blockPosition != SearchConstants.NOT_FOUND) {
      return blockStart + blockPosition;
    }

    return SearchConstants.NOT_FOUND;
  }

}
