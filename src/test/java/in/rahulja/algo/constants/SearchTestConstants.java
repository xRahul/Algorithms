package in.rahulja.algo.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SearchTestConstants {

  public static final List<Integer> SEARCH_LIST_INTEGERS = Collections.unmodifiableList(
      Arrays.asList(2, 5, 8, 1, 3, 9));
  public static final List<String> SEARCH_LIST_STRINGS = Collections.unmodifiableList(
      Arrays.asList("a", "bc", "d", "efg"));
  public static final int SEARCH_LIST_INTEGER_PRESENT = 8;
  public static final int SEARCH_LIST_INTEGER_PRESENT_POSITION = 2;
  public static final int SEARCH_LIST_INTEGER_ABSENT = 4;
  public static final String SEARCH_LIST_STRING_PRESENT = "bc";
  public static final int SEARCH_LIST_STRING_PRESENT_POSITION = 1;
  public static final String SEARCH_LIST_STRING_ABSENT = "hi";
}
