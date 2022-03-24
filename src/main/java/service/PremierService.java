package service;

import entity.Premier;

public interface PremierService {
    void addPremier(String name, String annotation, int ageCategory, int place, int tickets);
    void editPremier(String name, Premier premier);
    void showPremier(String name);
    void showAllPremier();
    void deletePremier();
}
