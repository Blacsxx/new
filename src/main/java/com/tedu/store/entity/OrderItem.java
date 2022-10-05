package com.tedu.store.entity;


public class OrderItem extends BaseEntity {
    private Integer id;
    private Integer oid;
    private Integer goodsId;
    private String goodsImage;
    private String goodsTitle;
    private Integer goodsCount;
    private Long goodsPrice;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", oid=" + oid +
                ", goodsId=" + goodsId +
                ", goodsImage='" + goodsImage + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsCount=" + goodsCount +
                ", goodsPrice=" + goodsPrice +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public Integer getGoodsCount(Integer count) {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Long getGoodsPrice(Long newPrice) {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
