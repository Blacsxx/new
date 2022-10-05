package com.tedu.store.entity;

public class Cart extends BaseEntity{
    private Integer id;
    private Integer uid;
    private Integer gid;
    private Long price;
    private Integer count;

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", uid=" + uid +
                ", gid=" + gid +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
