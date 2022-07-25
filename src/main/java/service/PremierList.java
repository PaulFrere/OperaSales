package service;

import dao.PremierDao;
import entity.Premier;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class PremierList implements ApplicationContextAware {
    private PremierDao premierDao;
    ArrayList<Premier> playbill = new ArrayList<>();
    private ApplicationContext ctx;
    public PremierList(PremierDao premierDao) {
        this.premierDao = premierDao;
    }
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }
    public Premier addPremier() {
        PremierDao repo = (PremierDao) premierDao;
        Premier newPremier = new Premier();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название:");
        newPremier.setTitle(sc.nextLine());
        System.out.println("Введите описание:");
        newPremier.setDescription(sc.nextLine());
        System.out.println("Введите категорию:");
        newPremier.setCathegory(sc.nextLine());
        System.out.println("Введите места");
        newPremier.setPlaces(sc.nextLine());
        repo.addPremier(newPremier);
        System.out.println("Премьера " + newPremier.getTitle() + " успешно добавлена");
        return newPremier;
    }
    public Premier updatePremier() {
        PremierDao repo = (PremierDao) premierDao;
        Premier newPremier = new Premier();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите оперу,которую хотите обновить:");
        String title = sc.nextLine();
        Premier premierToUpdate = repo.getPremierByTitle(title);
        System.out.println("Введите название:");
        newPremier.setTitle(sc.nextLine());
        System.out.println("Введите описание:");
        newPremier.setDescription(sc.nextLine());
        System.out.println("Введите категорию:");
        newPremier.setCathegory(sc.nextLine());
        System.out.println("Введите места");
        newPremier.setPlaces(sc.nextLine());
        premierToUpdate.setTitle(newPremier.getTitle());
        premierToUpdate.setDescription(newPremier.getDescription());
        premierToUpdate.setCathegory(newPremier.getCathegory());
        premierToUpdate.setPlaces(newPremier.getPlaces());
        repo.addPremier(premierToUpdate);
        System.out.println("Премьера " + newPremier.getTitle() + " успешно обновлена");
        return newPremier;
    }
    public List<Premier> removePremier() {
        PremierDao repo = (PremierDao) premierDao;
        String title;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите оперу,которую хотите удалить:");
        title = sc.nextLine();
        Premier premier = repo.getPremierByTitle(title);
        Long id = premier.getId();
        repo.deletePremierById(id);
        System.out.println("Опера " + title + " удалена,текущая афиша:");
        return repo.getAllPremiers();
    }

    public List<Premier> showAllPremier() {
        PremierDao repo = (PremierDao) premierDao;
        System.out.println("Список всех премьер:");
        return repo.getAllPremiers();
    }

    public Premier showOnePremier(String title) {
        PremierDao repo = (PremierDao) premierDao;
        return repo.getPremierByTitle(title);
    }
}
