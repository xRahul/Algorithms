package in.rahulja.algo.controllers;

import static in.rahulja.algo.constants.SearchTestConstants.SEARCH_LIST_STRINGS;
import static in.rahulja.algo.constants.SearchTestConstants.SEARCH_LIST_STRING_ABSENT;
import static in.rahulja.algo.constants.SearchTestConstants.SEARCH_LIST_STRING_PRESENT;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchControllerTest {

  @Autowired
  private SearchController searchController;


  @Test
  public void testLinearSearch_whenNotFound() {
    ResponseEntity<Object> response = searchController.linearSearch(SEARCH_LIST_STRING_ABSENT,
        StringUtils.collectionToCommaDelimitedString(SEARCH_LIST_STRINGS));

    Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }

  @Test
  public void testLinearSearch_whenFound() {
    ResponseEntity<Object> response = searchController.linearSearch(SEARCH_LIST_STRING_PRESENT,
        StringUtils.collectionToCommaDelimitedString(SEARCH_LIST_STRINGS));

    Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
  }

}
