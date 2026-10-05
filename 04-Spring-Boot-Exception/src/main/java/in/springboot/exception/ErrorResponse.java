package in.springboot.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private int HttpStatusCode;
    private String error;
    private String message;
    private String path;

    public ErrorResponse(
            LocalDateTime timestamp,
            int HttpStatusCode,
            String error,
            String message,
            String path) {

        this.timestamp = timestamp;
        this.HttpStatusCode = HttpStatusCode;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getHttpStatusCode() {
        return HttpStatusCode;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}