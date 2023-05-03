package sopt.org.fourthSeminar.exception.model;

import sopt.org.fourthSeminar.exception.Error;

public class ConflictException extends SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}
