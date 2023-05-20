package sopt.org.fourthSeminar.exception.model;

import sopt.org.fourthSeminar.exception.Error;

public class BadRequestException extends SoptException {
    public BadRequestException(Error error, String message) {
        super(error, message);
    }
}
