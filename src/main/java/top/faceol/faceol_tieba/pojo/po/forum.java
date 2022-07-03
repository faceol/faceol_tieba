package top.faceol.faceol_tieba.pojo.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDateTime;

public class forum {
    private int id;
    private int score;
    @TableField("`name`")
    private String name;
    @TableField("`type`")
    private String type;
    private int followers;
    private int posts;
    private String synopsis;
    private String img;
    @TableField(fill = FieldFill.INSERT,value = "`create`")
    private LocalDateTime create;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modified;

    public forum(int id, int score, String name, String type, int followers, int posts, String synopsis, String img, LocalDateTime create, LocalDateTime modified) {
        this.id = id;
        this.score = score;
        this.name = name;
        this.type = type;
        this.followers = followers;
        this.posts = posts;
        this.synopsis = synopsis;
        this.img = img;
        this.create = create;
        this.modified = modified;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreate() {
        return create;
    }

    public void setCreate(LocalDateTime create) {
        this.create = create;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public forum() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "forum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", followers=" + followers +
                ", posts=" + posts +
                ", synopsis='" + synopsis + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
