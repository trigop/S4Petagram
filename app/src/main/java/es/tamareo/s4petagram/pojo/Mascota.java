package es.tamareo.s4petagram.pojo;

/**
 * Created by paco on 2/4/17.
 */

public class Mascota {

    private String urlImg;
    private String name;
    private int likes = 0;
    private String id;

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Mascota(){}


    public Mascota(String urlImg, String name, int likes) {
        this.urlImg = urlImg;
        this.name = name;
        this.likes = likes;
    }
}
