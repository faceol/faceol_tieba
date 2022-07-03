package top.faceol.faceol_tieba.pojo.dto;

public class myPage {
    private int id;
    private int index;
    private int size;

    public myPage() {
    }

    public myPage(int index, int size) {
        this.index = index;
        this.size = size;
    }

    public myPage(int id, int index, int size) {
        this.id = id;
        this.index = index;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
