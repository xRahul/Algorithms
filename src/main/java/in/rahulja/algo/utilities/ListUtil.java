package in.rahulja.algo.utilities;

import static in.rahulja.algo.constants.CommonConstants.COMMA;
import static in.rahulja.algo.constants.CommonConstants.REGEX_NUMBER_LIST;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ListUtil {

  /**.
   * get List of Integers from comma separated integer list
   * @param stringList comma separated integer list
   * @return List of Integers
   */
  public static List<Integer> getIntegerList(@NonNull String stringList) {

    Pattern pattern = Pattern.compile(COMMA);
    return pattern.splitAsStream(stringList)
        .map(String::trim)
        .map(Integer::valueOf)
        .collect(Collectors.toList());

  }

  /**.
   * get List of Strings from comma separated String list
   * @param stringList comma separated String list
   * @return List of Strings
   */
  public static List<String> getStringList(@NonNull String stringList) {

    Pattern pattern = Pattern.compile(COMMA);
    return pattern.splitAsStream(stringList)
        .map(String::trim)
        .collect(Collectors.toList());

  }

  /**.
   *
   * @param stringList comma separated String list
   * @return true if is list of integers
   */
  public static boolean isAListOfIntegers(@NonNull String stringList) {
    return stringList.matches(REGEX_NUMBER_LIST);
  }

}
