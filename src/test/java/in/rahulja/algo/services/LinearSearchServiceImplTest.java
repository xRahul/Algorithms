package in.rahulja.algo.services;

import static in.rahulja.algo.constants.SearchConstants.NOT_FOUND;
import static in.rahulja.algo.constants.SearchTestConstants.SEARCH_LIST_INTEGERS;
import static in.rahulja.algo.constants.SearchTestConstants.SEARCH_LIST_INTEGER_ABSENT;
import static in.rahulja.algo.constants.SearchTestConstants.SEARCH_LIST_INTEGER_PRESENT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LinearSearchServiceImplTest {

  @Autowired
  private SearchService<Integer> linearSearchService;

  @Test
  public void linearSearchIsWorking_whenElementIsPresent() {

    linearSearchService.setList(SEARCH_LIST_INTEGERS);
    int position = linearSearchService.search(SEARCH_LIST_INTEGER_PRESENT);
    assertNotEquals(NOT_FOUND, position);

    position = linearSearchService.search(SEARCH_LIST_INTEGER_PRESENT,
        SEARCH_LIST_INTEGERS);
    assertNotEquals(NOT_FOUND, position);

    linearSearchService.setList(SEARCH_LIST_INTEGERS);
    boolean isPresent = linearSearchService.isPresent(SEARCH_LIST_INTEGER_PRESENT);
    assertTrue(isPresent);

    isPresent = linearSearchService.isPresent(SEARCH_LIST_INTEGER_PRESENT,
        SEARCH_LIST_INTEGERS);
    assertTrue(isPresent);

  }

  @Test
  public void linearSearchIsWorking_whenElementIsAbsent() {

    linearSearchService.setList(SEARCH_LIST_INTEGERS);
    int position = linearSearchService.search(SEARCH_LIST_INTEGER_ABSENT);
    assertEquals(NOT_FOUND, position);

    position = linearSearchService.search(SEARCH_LIST_INTEGER_ABSENT,
        SEARCH_LIST_INTEGERS);
    assertEquals(NOT_FOUND, position);

    linearSearchService.setList(SEARCH_LIST_INTEGERS);
    boolean isPresent = linearSearchService.isPresent(SEARCH_LIST_INTEGER_ABSENT);
    assertFalse(isPresent);

    isPresent = linearSearchService.isPresent(SEARCH_LIST_INTEGER_ABSENT,
        SEARCH_LIST_INTEGERS);
    assertFalse(isPresent);

  }


}
