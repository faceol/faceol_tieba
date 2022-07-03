package top.faceol.faceol_tieba.enums;

public enum weightEnum {
    FOLLOWER(50,"followCache","关注数权重"),
    POST(20,"postCache","发帖权重"),
    COMMENT(10,"commentCache","评论权重"),
    LIKE(5,"likeCache","点赞权重"),
    VIEW(1,"viewCache","观看权重");


    private int weight;
    private String cache;
    private String mag;

    weightEnum(int weight, String cache, String mag) {
        this.weight = weight;
        this.cache = cache;
        this.mag = mag;
    }

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    public  int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }
}
