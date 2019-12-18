package week1.dianshangjinjie.bw.com.demo3.bean;

import java.util.List;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 19:15 modify by liujc
 */
public class ShopBean {



    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 1001002
         * name : 女装
         * secondCategoryVo : [{"id":"1001002001","masterPic":"http://172.17.8.100/images/small/commodity/nx/bx/6/1.jpg","name":"外套"},{"id":"1001002002","masterPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/7/1.jpg","name":"裙装"},{"id":"1001002003","masterPic":"http://172.17.8.100/images/small/commodity/nx/ddx/3/1.jpg","name":"打底毛衣"},{"id":"1001002004","masterPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg","name":"卫衣"},{"id":"1001002005","masterPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/1.jpg","name":"裤装"}]
         */

        private String id;
        private String name;
        private List<SecondCategoryVoBean> secondCategoryVo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SecondCategoryVoBean> getSecondCategoryVo() {
            return secondCategoryVo;
        }

        public void setSecondCategoryVo(List<SecondCategoryVoBean> secondCategoryVo) {
            this.secondCategoryVo = secondCategoryVo;
        }

        public static class SecondCategoryVoBean {
            /**
             * id : 1001002001
             * masterPic : http://172.17.8.100/images/small/commodity/nx/bx/6/1.jpg
             * name : 外套
             */

            private String id;
            private String masterPic;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMasterPic() {
                return masterPic;
            }

            public void setMasterPic(String masterPic) {
                this.masterPic = masterPic;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
