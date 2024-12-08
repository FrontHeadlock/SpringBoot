package umc.Spring.apiPayload.exception.handler;

import umc.Spring.apiPayload.BaseErrorCode;
import umc.Spring.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
  public StoreHandler(BaseErrorCode code) {
      super (code);
  }
}
