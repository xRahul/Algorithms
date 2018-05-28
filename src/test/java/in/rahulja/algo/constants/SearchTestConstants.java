package in.rahulja.algo.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SearchTestConstants {

  public static final List<Integer> UNSORTED_LIST_INTEGERS = Collections.unmodifiableList(
      Arrays.asList(2, 5, 8, 1, 3, 9));
  public static final int UNSORTED_LIST_INTEGER_ABSENT = 4;
  public static final int UNSORTED_LIST_INTEGER_PRESENT = 8;
  public static final int UNSORTED_LIST_INTEGER_PRESENT_POSITION = 2;

  public static final List<String> UNSORTED_LIST_STRINGS = Collections.unmodifiableList(
      Arrays.asList("bc", "d", "a", "efg"));
  public static final String UNSORTED_LIST_STRING_PRESENT = "bc";
  public static final int UNSORTED_LIST_STRING_PRESENT_POSITION = 0;
  public static final String UNSORTED_LIST_STRING_ABSENT = "hi";

  public static final List<Integer> SORTED_LIST_INTEGERS = Collections.unmodifiableList(
      Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
  public static final int SORTED_LIST_INTEGER_ABSENT = 10;
  public static final int SORTED_LIST_INTEGER_PRESENT = 6;
  public static final int SORTED_LIST_INTEGER_PRESENT_POSITION = 5;

  public static final List<String> SORTED_LIST_STRINGS = Collections.unmodifiableList(
      Arrays.asList("ab", "cd", "ef", "gh"));
  public static final String SORTED_LIST_STRING_PRESENT = "cd";
  public static final int SORTED_LIST_STRING_PRESENT_POSITION = 1;
  public static final String SORTED_LIST_STRING_ABSENT = "hi";
}
