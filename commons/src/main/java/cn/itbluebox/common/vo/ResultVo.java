package cn.itbluebox.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * API返回的结果封装类
 * @author  chenshangxian
 */
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class ResultVo<T> {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     *  返回的标识码
     */
    private String code;

    /**
     * 返回的消息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private T data;


    /**
     * 返回的状态码及提示信息
     */
    public enum  ReturnCode{

        SUCCESS("0000","查询成功"),
        NO_DATA("0001","查询成功但无记录"),
        FAIL("0002","查询失败"),
        SYSTEM_ERROR("9999","系统异常");

        private String code;
        private String msg;

        ReturnCode(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }


    /**
     * 无参构造器
     */
    private ResultVo() {

    }



    private ResultVo(boolean success, ReturnCode returnCode) {
        this.success = success;
        this.code=returnCode.getCode();
        this.msg=returnCode.getMsg();
    }

    private ResultVo(boolean success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }


    /**
     * 使用系统定义的枚举类型定义返回消息
     *
     * @param success    成功状态
     * @param returnCode 系统定义的返回类型
     * @param <T>        返回的对象的泛型类型
     * @return
     */
    public static <T> cn.itbluebox.common.vo.ResultVo<T> getInstance(boolean success, ReturnCode returnCode){
        return new cn.itbluebox.common.vo.ResultVo<>(success, returnCode);
    }

    /**
     * 自定返回错误类型
     *
     * @param success 成功状态
     * @param msg     返回的信息
     * @param <T>     返回的对象的泛型类型
     * @return
     */
    public static <T> cn.itbluebox.common.vo.ResultVo<T> getInstance(boolean success, String msg) {
        return new cn.itbluebox.common.vo.ResultVo<>(success, "9998", msg);
    }


    public static cn.itbluebox.common.vo.ResultVo getInstance(){
        return new cn.itbluebox.common.vo.ResultVo();
    }

    //
    public cn.itbluebox.common.vo.ResultVo settingObjectData(T data){
        this.data=data;
        return this;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
