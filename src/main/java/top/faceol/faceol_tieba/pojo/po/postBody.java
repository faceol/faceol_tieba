package top.faceol.faceol_tieba.pojo.po;


public class postBody {
    private int id;
    private String body;

    public postBody() {
    }

    public postBody(int id,  String body) {
        this.id = id;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
