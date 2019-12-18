package week1.dianshangjinjie.bw.com.demo4.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：Han98
 * 创建时间：2019/11/23
 * 描述：TODO
 * 最近修改：2019/11/23 11:41 modify by liujc
 */
@Entity
public class GrBean {
    @Id
    private Long id;
    private String json;
    @Generated(hash = 1101148832)
    public GrBean(Long id, String json) {
        this.id = id;
        this.json = json;
    }
    @Generated(hash = 276048557)
    public GrBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getJson() {
        return this.json;
    }
    public void setJson(String json) {
        this.json = json;
    }
}
