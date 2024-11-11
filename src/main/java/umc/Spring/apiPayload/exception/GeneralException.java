package umc.Spring.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.Spring.apiPayload.BaseErrorCode;
import umc.Spring.apiPayload.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}