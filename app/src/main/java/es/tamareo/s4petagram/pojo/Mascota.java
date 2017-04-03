package es.tamareo.s4petagram.pojo;

/**
 * Created by paco on 2/4/17.
 */

public class Mascota {

    private int img;
    private String name;
    private int counter;


    public Mascota(String name, int img, int counter) {
        this.img = img;
        this.name = name;
        this.counter = counter;
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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter += counter;
    }

}
