package week1.dianshangjinjie.bw.com.demo3.bean;

import java.util.List;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 15:24 modify by liujc
 */
public class CarBean {
    /**
     * result : [{"categoryName":"美妆护肤","shoppingCartList":[{"commodityId":5,"commodityName":"双头两用修容笔","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39},{"commodityId":8,"commodityName":"Lara style蜜颊润泽腮红","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/6/1.jpg","price":19},{"commodityId":4,"commodityName":"佩佩防晕染眼线液笔","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/2/1.jpg","price":19},{"commodityId":10,"commodityName":"BYPHASSE蓓昂丝温和清洁净肤保湿卸妆水","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/7/1.jpg","price":69}]},{"categoryName":"女鞋","shoppingCartList":[{"commodityId":35,"commodityName":"唐狮女款小白鞋百搭秋季新款女鞋女款板鞋休闲鞋子帆布鞋女","count":1,"pic":"http://172.17.8.100/images/small/commodity/nx/fbx/4/1.jpg","price":78},{"commodityId":50,"commodityName":"【人气特卖】时尚金属扣休闲平底凉鞋","count":1,"pic":"http://172.17.8.100/images/small/commodity/nx/lx/5/1.jpg","price":99}]}]
     * message : 查询成功
     * status : 0000
     */

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
         * categoryName : 美妆护肤
         * shoppingCartList : [{"commodityId":5,"commodityName":"双头两用修容笔","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39},{"commodityId":8,"commodityName":"Lara style蜜颊润泽腮红","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/6/1.jpg","price":19},{"commodityId":4,"commodityName":"佩佩防晕染眼线液笔","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/2/1.jpg","price":19},{"commodityId":10,"commodityName":"BYPHASSE蓓昂丝温和清洁净肤保湿卸妆水","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/7/1.jpg","price":69}]
         */

        private String categoryName;
        private boolean ischecked;

        public ResultBean(boolean ischecked) {
            this.ischecked = ischecked;
        }

        public boolean isIschecked() {
            return ischecked;
        }

        public void setIschecked(boolean ischecked) {
            this.ischecked = ischecked;
        }

        private List<ShoppingCartListBean> shoppingCartList;

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public List<ShoppingCartListBean> getShoppingCartList() {
            return shoppingCartList;
        }

        public void setShoppingCartList(List<ShoppingCartListBean> shoppingCartList) {
            this.shoppingCartList = shoppingCartList;
        }

        public static class ShoppingCartListBean {
            /**
             * commodityId : 5
             * commodityName : 双头两用修容笔
             * count : 1
             * pic : http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg
             * price : 39
             */

            private int commodityId;
            private String commodityName;
            private int count;
            private String pic;
            private int price;
            private boolean iScheck;

            public ShoppingCartListBean(boolean iScheck) {
                this.iScheck = iScheck;
            }

            public boolean isiScheck() {
                return iScheck;
            }

            public void setiScheck(boolean iScheck) {
                this.iScheck = iScheck;
            }

            public int getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(int commodityId) {
                this.commodityId = commodityId;
            }

            public String getCommodityName() {
                return commodityName;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }
        }
    }
}
