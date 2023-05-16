package sopt.org.fourthSeminar.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import sopt.org.fourthSeminar.common.dto.ApiResponse;
import sopt.org.fourthSeminar.exception.Error;
import sopt.org.fourthSeminar.exception.model.SoptException;

import javax.validation.UnexpectedTypeException;
import java.util.Objects;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 400 BAD_REQUEST
     */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        FieldError fieldError = Objects.requireNonNull(e.getFieldError());
        return ApiResponse.error(Error.REQUEST_VALIDATION_EXCEPTION, String.format("%s. (%s)", fieldError.getDefaultMessage(), fieldError.getField()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ApiResponse handleMissingServletRequestParameterException(final MissingServletRequestParameterException e) {
        return ApiResponse.error(Error.NO_REQUEST_PARAMETER_EXCEPTION, String.format("%s. (%s)", Error.NO_REQUEST_PARAMETER_EXCEPTION.getMessage(), e.getParameterName()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ApiResponse handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException e) {
        return ApiResponse.error(Error.PARAMETER_TYPE_MISMATCH_EXCEPTION, String.format("%s. (%s)", Error.PARAMETER_TYPE_MISMATCH_EXCEPTION.getMessage(), e.getName()));
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(UnexpectedTypeException.class)
//    protected ApiResponse handleUnexpectedTypeException(final UnexpectedTypeException e) {
//        return ApiResponse.error(Error.VALIDATION_WRONG_TYPE_EXCEPTION);
//    }
//
//    /**
//     * 500 Internal Server
//     */
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    protected ApiResponse<Object> handleException(final Exception e) {
//        return ApiResponse.error(Error.INTERNAL_SERVER_ERROR);
//    }

    /**
     * Sopt custom error
     */
    @ExceptionHandler(SoptException.class)
    protected ResponseEntity<ApiResponse> handleSoptException(SoptException e) {
        return ResponseEntity.status(e.getHttpStatus())
                .body(ApiResponse.error(e.getError(), e.getMessage()));
    }
}
