package in.rahulja.algo.controllers;

import in.rahulja.algo.constants.ResponseCode;
import in.rahulja.algo.constants.SearchConstants;
import in.rahulja.algo.constants.SearchType;
import in.rahulja.algo.models.ResponseModel;
import in.rahulja.algo.services.code.searching.SearchService;
import in.rahulja.algo.utilities.ListUtil;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

  @Resource(name = "linearSearchService")
  private SearchService<String> linearSearchService;

  @Resource(name = "binarySearchService")
  private SearchService<String> binarySearchService;

  @Resource(name = "jumpSearchService")
  private SearchService<String> jumpSearchService;

  @Resource(name = "exponentialSearchService")
  private SearchService<String> exponentialSearchService;


  /**
   * Linear search Ex: /search?searchType=LINEAR_SEARCH&element=9&elementsList=3,6,1,8,2,5,9 .
   * Binary Search Ex: /search?searchType=BINARY_SEARCH&element=9&elementsList=1,2,3,4,5,6,8,9
   *
   * @param element search element
   * @param elementsList list of elements
   * @return response
   */
  @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Object> search(
      @RequestParam(name = "searchType") SearchType searchType,
      @RequestParam(name = "element") String element,
      @RequestParam(name = "elementsList") String elementsList) {

    SearchService<String> searchService = getSearchService(searchType);

    long startTime = System.nanoTime();
    int index = searchService.search(element, ListUtil.getStringList(elementsList));
    long endTime = System.nanoTime();

    return createResponse(index, endTime - startTime);
  }


  private SearchService<String> getSearchService(SearchType searchType) {
    switch (searchType) {
      case LINEAR_SEARCH:
        return linearSearchService;
      case BINARY_SEARCH:
        return binarySearchService;
      case JUMP_SEARCH:
        return jumpSearchService;
      case EXPONENTIAL_SEARCH:
        return exponentialSearchService;
      default:
    }

    return linearSearchService;
  }


  private ResponseEntity<Object> createResponse(int index, long duration) {
    if (index != SearchConstants.NOT_FOUND) {
      return foundResponse(index, duration);
    }
    return notFoundResponse(duration);
  }


  private ResponseEntity<Object> notFoundResponse(long duration) {
    return new ResponseEntity<>(
        ResponseModel.builder().responseCode(ResponseCode.NOT_FOUND).errorMessage("Not Found")
            .executionTime(getExecutionTime(duration)).build(),
        HttpStatus.NOT_FOUND);
  }


  private ResponseEntity<Object> foundResponse(int index, long duration) {
    return new ResponseEntity<>(
        ResponseModel.builder().responseCode(ResponseCode.FOUND)
            .successMessage("found at: " + index).executionTime(getExecutionTime(duration)).build(),
        HttpStatus.OK);
  }


  private String getExecutionTime(long duration) {
    return String.valueOf(duration) + "ns";
  }

}
