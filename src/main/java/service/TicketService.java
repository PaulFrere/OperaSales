package service;

import annotations.Notifierable;
import entity.Premier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class TicketService {
    private String success;
    private PremierList list;

    @Autowired
    public TicketService(PremierList list) {
        this.list = list;
    }

    @Notifierable
    public String buyTicket(String title, String place) {
        Scanner sc = new Scanner(System.in);
        for (Premier opera : list.playbill) {
            if (opera.getTitle().contains(title)) {
                //TODO Добавить действие покупки билета
                success = "Билет на оперу " + title + " Ваше место: " + place;
            }
        }
        return success;
    }

    @Notifierable
    public String returnTicket(String title, String place) {
        for (Premier opera : list.playbill) {
            if (opera.getTitle().contains(title)) {
                //TODO Добавить действие возврата билета
                success = "Билет на оперу " + title + " Место: " + place + " успешно сдан";
            }
        }
        return success;
    }
}
