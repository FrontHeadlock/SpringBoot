package umc.Spring.apiPayload.exception.handler;

import umc.Spring.apiPayload.BaseErrorCode;

public class StoreHandler extends RuntimeException {
  public StoreHandler(BaseErrorCode code) {
      super (code);
  }
}
