package in.rahulja.algo.models;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class SearchModel<T> {

  private T element;
  private String elementsList;

}
