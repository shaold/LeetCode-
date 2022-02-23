package com.sld;

/**
 * @Author: shaold
 * @since 2021-4-19 15:17
 */
public enum UserTrackType {

    /** 小程序启动 */
    MPLaunch("MPLaunch", "小程序启动"),
    /** 小程序显示 */
    MPShow("MPShow", "小程序显示"),
    /** 小程序进入后台 */
    MPHide("MPHide", "小程序进入后台"),
    /** 小程序页面浏览 */
    MPViewScreen("MPViewScreen", "小程序页面浏览"),
    /** 加入购物车 */
    AddToShoppingCart("AddToShoppingCart", "加入购物车"),
    /** 提交订单 */
    SubmitOrder("SubmitOrder", "提交订单"),
    /** 提交订单详情 */
    SubmitOrderDetail("SubmitOrderDetail", "提交订单详情"),
    /** 支付订单 */
    PayOrder("PayOrder", "支付订单"),
    /** 支付订单详情 */
    PayOrderDetail("PayOrderDetail", "支付订单详情");


    /** 类型值 */
    public final String eventName;
    /** 标签 */
    public final String label;


    UserTrackType(String eventName, String label) {
        this.eventName = eventName;
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
