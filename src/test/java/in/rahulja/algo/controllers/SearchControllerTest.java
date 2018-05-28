package in.rahulja.algo.controllers;

import static in.rahulja.algo.constants.SearchTestConstants.SORTED_LIST_STRINGS;
import static in.rahulja.algo.constants.SearchTestConstants.SORTED_LIST_STRING_ABSENT;
import static in.rahulja.algo.constants.SearchTestConstants.SORTED_LIST_STRING_PRESENT;
import static in.rahulja.algo.constants.SearchTestConstants.UNSORTED_LIST_STRINGS;
import static in.rahulja.algo.constants.SearchTestConstants.UNSORTED_LIST_STRING_ABSENT;
import static in.rahulja.algo.constants.SearchTestConstants.UNSORTED_LIST_STRING_PRESENT;

import in.rahulja.algo.constants.ResponseCode;
import in.rahulja.algo.constants.SearchType;
import in.rahulja.algo.models.ResponseModel;
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
    ResponseEntity<Object> response = searchController
        .search(SearchType.LINEAR_SEARCH, UNSORTED_LIST_STRING_ABSENT,
            StringUtils.collectionToCommaDelimitedString(UNSORTED_LIST_STRINGS));

    Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    Assert.assertEquals(ResponseCode.NOT_FOUND,
        ((ResponseModel) response.getBody()).getResponseCode());
  }

  @Test
  public void testLinearSearch_whenFound() {
    ResponseEntity<Object> response = searchController
        .search(SearchType.LINEAR_SEARCH, UNSORTED_LIST_STRING_PRESENT,
            StringUtils.collectionToCommaDelimitedString(UNSORTED_LIST_STRINGS));

    Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assert.assertEquals(ResponseCode.FOUND,
        ((ResponseModel) response.getBody()).getResponseCode());
  }


  @Test
  public void testBinarySearch_whenNotFound() {
    ResponseEntity<Object> response = searchController
        .search(SearchType.BINARY_SEARCH, SORTED_LIST_STRING_ABSENT,
            StringUtils.collectionToCommaDelimitedString(SORTED_LIST_STRINGS));

    Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    Assert.assertEquals(ResponseCode.NOT_FOUND,
        ((ResponseModel) response.getBody()).getResponseCode());
  }

  @Test
  public void testBinarySearch_whenFound() {
    ResponseEntity<Object> response = searchController
        .search(SearchType.BINARY_SEARCH, SORTED_LIST_STRING_PRESENT,
            StringUtils.collectionToCommaDelimitedString(SORTED_LIST_STRINGS));

    Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assert.assertEquals(ResponseCode.FOUND,
        ((ResponseModel) response.getBody()).getResponseCode());
  }


  @Test
  public void testJumpSearch_whenNotFound() {
    ResponseEntity<Object> response = searchController
        .search(SearchType.JUMP_SEARCH, SORTED_LIST_STRING_ABSENT,
            StringUtils.collectionToCommaDelimitedString(SORTED_LIST_STRINGS));

    Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    Assert.assertEquals(ResponseCode.NOT_FOUND,
        ((ResponseModel) response.getBody()).getResponseCode());
  }

  @Test
  public void testJumpSearch_whenFound() {
    ResponseEntity<Object> response = searchController
        .search(SearchType.JUMP_SEARCH, SORTED_LIST_STRING_PRESENT,
            StringUtils.collectionToCommaDelimitedString(SORTED_LIST_STRINGS));

    Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assert.assertEquals(ResponseCode.FOUND,
        ((ResponseModel) response.getBody()).getResponseCode());
  }


  @Test
  public void testExponentialSearch_whenNotFound() {
    ResponseEntity<Object> response = searchController
        .search(SearchType.EXPONENTIAL_SEARCH, SORTED_LIST_STRING_ABSENT,
            StringUtils.collectionToCommaDelimitedString(SORTED_LIST_STRINGS));

    Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    Assert.assertEquals(ResponseCode.NOT_FOUND,
        ((ResponseModel) response.getBody()).getResponseCode());
  }

  @Test
  public void testExponentialSearch_whenFound() {
    ResponseEntity<Object> response = searchController
        .search(SearchType.EXPONENTIAL_SEARCH, SORTED_LIST_STRING_PRESENT,
            StringUtils.collectionToCommaDelimitedString(SORTED_LIST_STRINGS));

    Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assert.assertEquals(ResponseCode.FOUND,
        ((ResponseModel) response.getBody()).getResponseCode());
  }

}
