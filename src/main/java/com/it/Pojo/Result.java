package com.it.Pojo;

public class Result {
    private Integer code;
    private String message;
    private Object data;

    public Result(Integer code, String message, Object data) {
        this.code=code;
        this.message=message;
        this.data=data;
    }

    public Integer getCode() {return code;}
    public String getMessage() {return message;}
    public Object getData() {return data;}
    public void setCode(Integer code) {this.code = code;}
    public void setMessage(String message) {this.message = message;}
    public void setData(Object data) {this.data = data;}

    /*public static：
        这表示 success 方法是公共的，可以在类的外部被调用，
        并且是静态的，意味着它可以不通过类的实例而直接通过类名来调用。
        多态性：Object 是Java中所有类的超类。这意味着任何类型的对象都可以传递给这个方法，因为它们都是 Object 类型的实例。这使得方法可以接受不同类型的参数，提供了很大的灵活性。
        泛型数据传递：通过使用 Object 类型的参数，方法可以接受任何类型的数据。这在不确定具体数据类型或需要处理多种数据类型的情况下非常有用。

        */


    public static Result success(Object data) {
        return new Result(1, "success", data);
    }
    public static Result error(Object data) {
        return new Result(0, "error", data);
    }
    @Override
    public String toString() {
        return "Result [code=" + code + ", message=" + message + ", data=" + data + "]";
    }

}
