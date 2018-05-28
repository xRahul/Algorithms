package in.rahulja.algo.code.searching;

import static in.rahulja.algo.constants.SearchConstants.NOT_FOUND;
import static in.rahulja.algo.constants.SearchTestConstants.SEARCH_LIST_INTEGERS;
import static in.rahulja.algo.constants.SearchTestConstants.SEARCH_LIST_INTEGER_ABSENT;
import static in.rahulja.algo.constants.SearchTestConstants.SEARCH_LIST_INTEGER_PRESENT;
import static in.rahulja.algo.constants.SearchTestConstants.SEARCH_LIST_STRINGS;
import static in.rahulja.algo.constants.SearchTestConstants.SEARCH_LIST_STRING_ABSENT;
import static in.rahulja.algo.constants.SearchTestConstants.SEARCH_LIST_STRING_PRESENT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import in.rahulja.algo.code.searching.base.Search;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LinearSearchTest {

  @Resource(name = "linearSearch")
  private Search<Integer> linearSearchIntegers;

  @Resource(name = "linearSearch")
  private Search<String> linearSearchStrings;


  @Test
  public void integerLinearSearchIsWorking_whenElementIsPresent() {
    linearSearchIntegers.setList(SEARCH_LIST_INTEGERS);
    int position = linearSearchIntegers.search(SEARCH_LIST_INTEGER_PRESENT);
    assertNotEquals(NOT_FOUND, position);
  }

  @Test
  public void integerLinearSearchIsWorking_whenElementIsAbsent() {
    linearSearchIntegers.setList(SEARCH_LIST_INTEGERS);
    int position = linearSearchIntegers.search(SEARCH_LIST_INTEGER_ABSENT);
    assertEquals(NOT_FOUND, position);
  }

  @Test
  public void stringLinearSearchIsWorking_whenElementIsPresent() {
    linearSearchStrings.setList(SEARCH_LIST_STRINGS);
    int position = linearSearchStrings.search(SEARCH_LIST_STRING_PRESENT);
    assertNotEquals(NOT_FOUND, position);
  }

  @Test
  public void stringLinearSearchIsWorking_whenElementIsAbsent() {
    linearSearchStrings.setList(SEARCH_LIST_STRINGS);
    int position = linearSearchStrings.search(SEARCH_LIST_STRING_ABSENT);
    assertEquals(NOT_FOUND, position);
  }
}
