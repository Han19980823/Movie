package week1.dianshangjinjie.bw.com.yuekaob.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：Han98
 * 创建时间：2019/11/26
 * 描述：TODO
 * 最近修改：2019/11/26 16:31 modify by liujc
 */
@Entity
public class ProductBean {
    @Id
    private Long id;
    private String tojson;
    @Generated(hash = 1098083221)
    public ProductBean(Long id, String tojson) {
        this.id = id;
        this.tojson = tojson;
    }
    @Generated(hash = 669380001)
    public ProductBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTojson() {
        return this.tojson;
    }
    public void setTojson(String tojson) {
        this.tojson = tojson;
    }
}
