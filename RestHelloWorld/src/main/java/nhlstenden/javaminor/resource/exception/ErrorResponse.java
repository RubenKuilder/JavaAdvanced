package nhlstenden.javaminor.resource.exception;

public class ErrorResponse {
    private String error;

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
