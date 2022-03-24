package service;

import entity.Premier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PremierRepo;


@Service
public class PremierServiceImpl implements PremierService {

    private ConsoleLogger logger;

    private PremierRepo premierRepo;

    @Autowired
    public PremierServiceImpl(ConsoleLogger logger, PremierRepo premierRepo){
        this.logger = logger;
        this.premierRepo= premierRepo;
    }

    @Override
    public void addPremier(String name, String annotation, int ageCategory, int place, int tickets){
        Premier premier = new Premier(name, annotation, ageCategory, place, tickets);
        premierRepo.save(premier);
    }

    @Override
    public void editPremier(String name, Premier premier){

    }
    @Override
    public void showPremier(String name){
        logger.log(premierRepo.get(name));
    }

    @Override
    public void showAllPremier(){
        logger.log("Poster of premiere:\n");
        for (Premier premier : premierRepo.getAll()){
            logger.log(premier.getName());
        }
    }
    @Override
    public void deletePremier(){

    }
}
