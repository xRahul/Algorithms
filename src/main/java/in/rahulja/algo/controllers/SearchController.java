package in.rahulja.algo.controllers;

import in.rahulja.algo.constants.ResponseCode;
import in.rahulja.algo.constants.SearchConstants;
import in.rahulja.algo.models.ResponseModel;
import in.rahulja.algo.services.SearchService;
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
  private SearchService<Integer> integerLinearSearchService;

  @Resource(name = "linearSearchService")
  private SearchService<String> stringLinearSearchService;


  @Resource(name = "binarySearchService")
  private SearchService<Integer> integerBinarySearchService;

  @Resource(name = "binarySearchService")
  private SearchService<String> stringBinarySearchService;


  /**
   * . Linear search Ex: /linearSearch?element=9&elementsList=3,6,1,8,2,5,9
   *
   * @param element search element
   * @param elementsList list of elements
   * @return response
   */
  @GetMapping(value = "/linearSearch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Object> linearSearch(@RequestParam(name = "element") String element,
      @RequestParam(name = "elementsList") String elementsList) {

    int index;

    if (ListUtil.isAListOfIntegers(elementsList)) {
      index = integerLinearSearchService.search(Integer.valueOf(element),
          ListUtil.getIntegerList(elementsList));
    } else {
      index = stringLinearSearchService.search(element,
          ListUtil.getStringList(elementsList));
    }

    return createResponse(index);
  }


  /**
   * . Binary search Ex: /binarySearch?element=89&elementsList=1,3,5,7,9,13,44,89
   *
   * @param element search element
   * @param elementsList list of elements
   * @return response
   */
  @GetMapping(value = "/binarySearch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Object> binarySearch(@RequestParam(name = "element") String element,
      @RequestParam(name = "elementsList") String elementsList) {

    int index;

    if (ListUtil.isAListOfIntegers(elementsList)) {
      index = integerBinarySearchService.search(Integer.valueOf(element),
          ListUtil.getIntegerList(elementsList));
    } else {
      index = stringBinarySearchService
          .search(element, ListUtil.getStringList(elementsList));
    }

    return createResponse(index);
  }


  private ResponseEntity<Object> createResponse(int index) {
    if (index != SearchConstants.NOT_FOUND) {
      return foundResponse(index);
    }
    return notFoundResponse();
  }


  private ResponseEntity<Object> notFoundResponse() {
    return new ResponseEntity<>(
        ResponseModel.builder().responseCode(ResponseCode.NOT_FOUND).errorMessage("Not Found")
            .build(),
        HttpStatus.NOT_FOUND);
  }


  private ResponseEntity<Object> foundResponse(int index) {
    return new ResponseEntity<>(
        ResponseModel.builder().responseCode(ResponseCode.FOUND)
            .successMessage("found at: " + index).build(),
        HttpStatus.OK);
  }

}
