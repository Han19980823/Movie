package week1.dianshangjinjie.bw.com.movie.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：Han98
 * 创建时间：2019/12/13
 * 描述：TODO
 * 最近修改：2019/12/13 09:08 modify by liujc
 */
@Entity
public class CityBean {

    @Id
    public Long id;
    public String toJson;
    @Generated(hash = 499063222)
    public CityBean(Long id, String toJson) {
        this.id = id;
        this.toJson = toJson;
    }
    @Generated(hash = 273649691)
    public CityBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getToJson() {
        return this.toJson;
    }
    public void setToJson(String toJson) {
        this.toJson = toJson;
    }
}
