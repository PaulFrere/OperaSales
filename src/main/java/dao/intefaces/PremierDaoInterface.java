package dao.intefaces;

import entity.Premier;

import java.util.List;

public interface PremierDaoInterface {
    Premier getPremierById(Long id);
    List<Premier> getAllPremiers();
    Premier addPremier(Premier premier);
    Premier updatePremier(Premier premier);
    boolean deletePremierById(Long id);
    Premier getPremierByTitle(String title);
}
