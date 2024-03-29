package week1.dianshangjinjie.bw.com.demo2.bean;

import java.util.List;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 11:40 modify by liujc
 */
public class Shop {

    /**
     * orderList : [{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":25,"commodityName":"秋冬季真皮兔毛女鞋韩版休闲平底毛毛鞋软底百搭浅口水钻加绒棉鞋毛毛鞋潮鞋","commodityPic":"http://172.17.8.100/images/small/commodity/nx/ddx/1/1.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/1/2.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/1/3.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/1/4.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/1/5.jpg","commodityPrice":158,"orderDetailId":21592},{"commentStatus":1,"commodityCount":1,"commodityId":12,"commodityName":"Lara style美妆BB蛋","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/4.jpg","commodityPrice":22,"orderDetailId":21593}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2019112211385686010155","orderStatus":1,"orderTime":1574393937000,"payAmount":180,"payMethod":1,"userId":10155}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<OrderListBean> orderList;

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

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * detailList : [{"commentStatus":1,"commodityCount":1,"commodityId":25,"commodityName":"秋冬季真皮兔毛女鞋韩版休闲平底毛毛鞋软底百搭浅口水钻加绒棉鞋毛毛鞋潮鞋","commodityPic":"http://172.17.8.100/images/small/commodity/nx/ddx/1/1.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/1/2.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/1/3.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/1/4.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/1/5.jpg","commodityPrice":158,"orderDetailId":21592},{"commentStatus":1,"commodityCount":1,"commodityId":12,"commodityName":"Lara style美妆BB蛋","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/4.jpg","commodityPrice":22,"orderDetailId":21593}]
         * expressCompName : 京东快递
         * expressSn : 1001
         * orderId : 2019112211385686010155
         * orderStatus : 1
         * orderTime : 1574393937000
         * payAmount : 180
         * payMethod : 1
         * userId : 10155
         */

        private String expressCompName;
        private String expressSn;
        private String orderId;
        private int orderStatus;
        private long orderTime;
        private int payAmount;
        private int payMethod;
        private int userId;
        private List<DetailListBean> detailList;

        public String getExpressCompName() {
            return expressCompName;
        }

        public void setExpressCompName(String expressCompName) {
            this.expressCompName = expressCompName;
        }

        public String getExpressSn() {
            return expressSn;
        }

        public void setExpressSn(String expressSn) {
            this.expressSn = expressSn;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public long getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(long orderTime) {
            this.orderTime = orderTime;
        }

        public int getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(int payAmount) {
            this.payAmount = payAmount;
        }

        public int getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(int payMethod) {
            this.payMethod = payMethod;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            /**
             * commentStatus : 1
             * commodityCount : 1
             * commodityId : 25
             * commodityName : 秋冬季真皮兔毛女鞋韩版休闲平底毛毛鞋软底百搭浅口水钻加绒棉鞋毛毛鞋潮鞋
             * commodityPic : http://172.17.8.100/images/small/commodity/nx/ddx/1/1.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/1/2.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/1/3.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/1/4.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/1/5.jpg
             * commodityPrice : 158
             * orderDetailId : 21592
             */

            private int commentStatus;
            private int commodityCount;
            private int commodityId;
            private String commodityName;
            private String commodityPic;
            private int commodityPrice;
            private int orderDetailId;

            public int getCommentStatus() {
                return commentStatus;
            }

            public void setCommentStatus(int commentStatus) {
                this.commentStatus = commentStatus;
            }

            public int getCommodityCount() {
                return commodityCount;
            }

            public void setCommodityCount(int commodityCount) {
                this.commodityCount = commodityCount;
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

            public String getCommodityPic() {
                return commodityPic;
            }

            public void setCommodityPic(String commodityPic) {
                this.commodityPic = commodityPic;
            }

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getOrderDetailId() {
                return orderDetailId;
            }

            public void setOrderDetailId(int orderDetailId) {
                this.orderDetailId = orderDetailId;
            }
        }
    }
}
