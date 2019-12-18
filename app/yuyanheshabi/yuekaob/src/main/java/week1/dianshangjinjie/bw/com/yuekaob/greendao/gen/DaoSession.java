package week1.dianshangjinjie.bw.com.yuekaob.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import week1.dianshangjinjie.bw.com.yuekaob.bean.ProductBean;

import week1.dianshangjinjie.bw.com.yuekaob.greendao.gen.ProductBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig productBeanDaoConfig;

    private final ProductBeanDao productBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        productBeanDaoConfig = daoConfigMap.get(ProductBeanDao.class).clone();
        productBeanDaoConfig.initIdentityScope(type);

        productBeanDao = new ProductBeanDao(productBeanDaoConfig, this);

        registerDao(ProductBean.class, productBeanDao);
    }
    
    public void clear() {
        productBeanDaoConfig.clearIdentityScope();
    }

    public ProductBeanDao getProductBeanDao() {
        return productBeanDao;
    }

}
