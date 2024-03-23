package com.example.mock1.utils.respone;

public enum ResCode {

    SUCCESS("000", "SUCCESS"),
    INVALID_USER("001", "INVALID_USER"),
    AUTHEN_FAIL("003", "AUTHEN_FAIL"),
    UNAUTHENTICATED("004", "User không có quyền thực hiện tính năng này"),
    FUNCTION_NOT_EXISTS("005", "Tính năng chưa phát triển, vui lòng thử lại sau!"),
    INVALID_DATA_API("400", "Dữ liệu gửi lên không hợp lệ"),
    PARAMETER_INVALID("401", "Tham số không hợp lệ"),
    RESOURCE_NOT_FOUND("404", "Không tìm thấy tài nguyên"),
    INTERNAL_ERROR("999", "Đã xảy ra lỗi trong quá trình xử lý. Vui lòng thực hiện lại sau"),

    // related system 100-199
    ROLE_ALREADY_EXISTS("100", "Nhóm quyền đã tồn tại, vui lòng kiểm tra lại"),
    ROLE_NOT_EXISTS("101", "Nhóm quyền không tồn tại, vui lòng kiểm tra lại"),
    USER_NOT_EXISTS("102", "Người dùng không tồn tại, vui lòng kiểm tra lại"),
    USER_ALREADY_EXISTS("103", "Người dùng đã tồn tại, vui lòng kiểm tra lại"),
    REPASS_NOT_MATCH("104", "Mật khẩu không trùng khớp, vui lòng kiểm tra lại"),
    INVALID_PASSWORD("105", "Mật khẩu không hợp lệ, vui lòng kiểm tra lại"),
    MUST_LOGOUT("106", "Đổi mật khẩu người dùng thành công. Quý khách vui lòng đăng nhập lại"),
    EMPLOYEE_NOT_EXISTS("107", "Nhân viên này khôn tồn tại . Vui lòng kiểm tra lại"),
    PARKING_LOT_NOT_EXISTS("108","Bãi đỗ xe không tồn tại. Vui lòng kiểm tra lại"),
    CAR_NOT_EXISTS("108","Xe không tồn tại. Vui lòng kiểm tra lại"),
    TRIP_NOT_EXISTS("109","Chuyến xe không tồn tại không tồn tại. Vui lòng kiểm tra lại"),
    TICKET_NOT_EXISTS("110","Vé của chuyến đi không tồn tại"),
    DATA_NOT_VALID("111","Dữ liệu đầu vào không hợp lệ, vui lòng kiểm tra lại")
    ;



    private String value;
    private String des;
    private String origin;

    ResCode(String value, String des) {
        this.value = value;
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getValue() {
        return value;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
