package es.tamareo.s4petagram.pojo;

/**
 * Created by paco on 4/4/17.
 */

public class Perfil {

    private int img;
    private String name;

    public Perfil(int img, String name) {
        this.img = img;
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
