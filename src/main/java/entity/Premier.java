package entity;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Premier extends ArrayList<Premier> {

    private String name;
    private String annotation;
    private Integer ageCategory;
    private Integer place;
    private Integer tickets;

    public Premier(String name, String annotation, int ageCategory, int place, int tickets) {
        this.name = name;
        this.annotation = annotation;
        this.ageCategory = ageCategory;
        this.place = place;
        this.tickets = tickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Integer getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(Integer ageCategory) {
        this.ageCategory = ageCategory;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public  Integer getTickets() { return tickets; }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return name +
                ", " + annotation +
                ", " + ageCategory +
                ", Free Seat: " + place;
    }

    @Override
    public Stream<Premier> stream() {
        return super.stream();
    }

}
