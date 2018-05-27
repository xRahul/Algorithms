package in.rahulja.algo.models;

import in.rahulja.algo.constants.ResponseCode;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ResponseModel {

  @Builder.Default
  private ResponseCode responseCode = ResponseCode.SUCCESS;
  @Builder.Default
  private String errorMessage = "";
  @Builder.Default
  private String successMessage = "";
  @Builder.Default
  private String executionTime = "0";
}
