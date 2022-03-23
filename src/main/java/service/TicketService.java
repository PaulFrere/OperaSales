package service;

import entity.Premier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class TicketService {
    private String success;
    private PremierService repository;

    @Autowired
    public TicketService(PremierService repository){
        this.repository = repository;
    }

    public String buyTicket(String name, Integer place) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input title of opera:");
        name = scanner.nextLine();
        System.out.println("Input number of seat:");
        place = scanner.nextInt();
        for(Premier opera : repository.staging){
            if (opera.getName().contains(name) && opera.getPlace().equals(place)) {
                success = "Ticket on " + name + " Your place: " + place;
            }else System.out.println("Seat is taken");
        }
        return success;
    }

    public String returnTicket(String name, Integer place){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input title of opera:");
        name = scanner.nextLine();
        System.out.println("Input number of seat:");
        place = scanner.nextInt();
        for (Premier opera : repository.staging){
            if(opera.getName().contains(name) && opera.getPlace().equals(place)){
                success = "Ticket " + name + " was return.";
            }else System.out.println("Wrong data");
        }
        return success;
    }
}
