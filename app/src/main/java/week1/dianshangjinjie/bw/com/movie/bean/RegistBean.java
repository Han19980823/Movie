package week1.dianshangjinjie.bw.com.movie.bean;

/**
 * 作者：Han98
 * 创建时间：2019/12/5
 * 描述：TODO
 * 最近修改：2019/12/5 08:52 modify by liujc
 */
public class RegistBean {
    /**
     * message : 该手机号已注册，不能重复注册！
     * status : 1001
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
