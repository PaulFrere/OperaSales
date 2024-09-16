package repository;

import entity.Premier;

import java.util.List;

public interface PremierRepo{
    List<Premier> getAll();
    Premier get(String name);
    boolean save(Premier premier);
}
