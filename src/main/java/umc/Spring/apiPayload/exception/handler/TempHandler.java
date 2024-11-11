package umc.Spring.apiPayload.exception.handler;

import umc.Spring.apiPayload.BaseErrorCode;
import umc.Spring.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
