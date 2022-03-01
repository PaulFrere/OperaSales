package repository;

import entity.Premier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class PremierRepo {
    public ArrayList<Premier> staging = new ArrayList<>();

    public void addPremier() {
        Premier newPremier = new Premier();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input title:");
        newPremier.setName(scanner.nextLine());
        System.out.println("Input annotation:");
        newPremier.setAnnotation(scanner.nextLine());
        System.out.println("Input age category:");
        newPremier.setAgeCategory(scanner.nextInt());
        System.out.println("Input amount of seat:");
        newPremier.setPlace(scanner.nextInt());
        staging.add(newPremier);
        System.out.println(newPremier.getName() + " added successfully");
    }

    public ArrayList<Premier> removePremier(){
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input title opera for remove");
        name = scanner.nextLine();
        for (Premier opera : staging){
            if(opera.getName().contains(name)){
                staging.remove(opera);
                System.out.println("Opera removed");
                return  staging;
            }
        }
        return null;
    }

    public ArrayList<Premier> showPremiers() {
        System.out.println("Opera premieres:");
        return staging;
    }
    public ArrayList<Premier> showOnePremier(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input title of opera");
        name = scanner.nextLine();
        for (Premier opera : staging){
            if (opera.getName().contains(name)){
                return opera;
            }
        }
        return null;
    }
}
