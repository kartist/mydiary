package cn.kartist.mydiary.common.entity;

public class Result {
    private String message;
    private boolean success = true;
    private Object data;

    public Result() {
        message = "OK";
    }

    public Result(String message) {
        this.message = message;
    }

    public Result(Exception e) {
        message = e.getMessage();
        success = false;
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Result{");
        sb.append("message='").append(message).append('\'');
        sb.append(", success=").append(success);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }

    public void setData(Object data) {
        this.data = data;
    }
}
