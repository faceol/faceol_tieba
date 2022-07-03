package top.faceol.faceol_tieba.pojo.dto;

public class publish {
    private int id;
    private int forumId;
    private String head;
    private String main;

    public publish(int id, int forumId, String head, String main) {
        this.id = id;
        this.forumId = forumId;
        this.head = head;
        this.main = main;
    }

    public publish(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
