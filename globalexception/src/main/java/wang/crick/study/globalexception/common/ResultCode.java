package wang.crick.study.globalexception.common;
/**
*@author easyhuang
*@version 创建时间:Dec 13, 2018 2:40:42 PM
*说明
*/
public enum ResultCode {

	INVALID_ARGUMENT(800),
    RECORD_HAS_BEEN_DELETED(801),
    PERSONNEL_STATUS_IS_NOT_AVAILABLE(802),
    PERSONNEL_CURRENT_PASSWORD_ERROR(803),
    ERROR_PERMISSION_DENIED(805),
    ABNORMAL_OPERATING_DATABASE(810);
	
    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
