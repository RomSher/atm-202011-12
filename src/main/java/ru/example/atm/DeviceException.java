package ru.example.atm;

public class DeviceException extends Exception{
    public DeviceException() {
    }

    public DeviceException(String errorMessage) {
        super(errorMessage);
    }

    public DeviceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceException(Throwable cause) {
        super(cause);
    }

    public DeviceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
