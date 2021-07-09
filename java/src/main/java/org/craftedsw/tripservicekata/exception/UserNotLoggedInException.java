package org.craftedsw.tripservicekata.exception;

public class UserNotLoggedInException extends RuntimeException {

    private static final long serialVersionUID = 8959479918185637340L;

    public UserNotLoggedInException() {
        super();
    }

    public UserNotLoggedInException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotLoggedInException(String message) {
        super(message);
    }

    public UserNotLoggedInException(Throwable cause) {
        super(cause);
    }

}
