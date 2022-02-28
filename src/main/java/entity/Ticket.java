package entity;

public class Ticket {

    private Integer number;
    private Integer price;
    private String nameOfOpera;

    public Ticket(){
        this.number = number;
        this.price = price;
        this.nameOfOpera = nameOfOpera;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getNameOfOpera() {
        return nameOfOpera;
    }

    public void setNameOfOpera(String nameOfOpera) {
        this.nameOfOpera = nameOfOpera;
    }
}
