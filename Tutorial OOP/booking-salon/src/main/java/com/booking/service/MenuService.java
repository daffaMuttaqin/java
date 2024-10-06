package com.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;
import com.booking.repositories.PersonRepository;
import com.booking.repositories.ServiceRepository;

public class MenuService {
    private static List<Person> personList = PersonRepository.getAllPerson();
    private static List<Service> serviceList = ServiceRepository.getAllService();
    private static List<Reservation> reservationList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    private static PrintService printService = new PrintService();

    public static void mainMenu() {
        String[] mainMenuArr = {"Show Data", "Create Reservation", "Complete/cancel reservation", "Exit"};
        String[] subMenuArr = {"Recent Reservation", "Show Customer", "Show Available Employee", "Show History Reservation", "Back to main menu"};
    
        int optionMainMenu;
        int optionSubMenu;

		boolean backToMainMenu = false;
        boolean backToSubMenu = false;
        do {
            PrintService.printMenu("Main Menu", mainMenuArr);
            optionMainMenu = Integer.valueOf(input.nextLine());
            switch (optionMainMenu) {
                case 1 -> {
                    do {
                        PrintService.printMenu("Show Data", subMenuArr);
                        optionSubMenu = Integer.valueOf(input.nextLine());
                        // Sub menu - menu 1
                        switch (optionSubMenu) {
                            case 1 -> printService.showRecentReservation();
                            case 2 -> printService.showAllCustomer();
                            case 3 -> printService.showAllEmployee();
                            case 4 -> printService.showHistoryReservation();
                            case 0 -> backToSubMenu = true;
                        }
                    } while (!backToSubMenu);
                }
                case 2 -> ReservationService.createReservation();
                case 3 -> ReservationService.editReservationWorkstage();
                case 0 -> backToMainMenu = true;
            }
            // panggil fitur mengubah workstage menjadi finish/cancel
                    } while (!backToMainMenu);
		
	}
}
