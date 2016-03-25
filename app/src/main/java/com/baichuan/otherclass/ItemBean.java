package com.baichuan.otherclass;

/**
 * Created by Administrator on 2016/3/23.
 */
public class ItemBean {
    /**
     * 用来封装数据
     */
    public int ItemImageResid;
    public String ItemTitle;
    public String ItemContent;

    public ItemBean(int itemImageResid, String itemTitle, String itemContent) {
        ItemImageResid = itemImageResid;
        ItemTitle = itemTitle;
        ItemContent = itemContent;
    }
}
