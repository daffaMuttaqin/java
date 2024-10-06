package com.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;
import com.booking.repositories.PersonRepository;
import com.booking.repositories.ServiceRepository;

public class ReservationService {
    private static Scanner input = new Scanner(System.in);
    private static List<Reservation> reservations = new ArrayList<>();
    private static int reservationId = 1;
    
    public static void createReservation(){
        String reservationIdSend = "Rsv-0";
        // Ambil daftar customer, employee, dan service dari repository
        List<Person> personList = PersonRepository.getAllPerson();
        List<Service> serviceList = ServiceRepository.getAllService();

        // Pilih customer
        System.out.println("Pilih Customer:");
        for (Person person : personList) {
            if (person instanceof Customer) {
                System.out.println(person.getId() + " - " + person.getName());
            }
        }

        System.out.println("Masukkan ID Customer: ");
        String customerId = input.nextLine();
        Customer customer = getCustomerByCustomerId(customerId, personList);

        // Pilih employee
        System.out.println("Pilih Employee:");
        for (Person person : personList) {
            if (person instanceof Employee) {
                System.out.println(person.getId() + " - " + person.getName());
            }
        }
        System.out.println("Masukkan ID Employee: ");
        String employeeId = input.nextLine();
        Employee employee = getEmployeeById(employeeId, personList);

        // Pilih service (bisa memilih beberapa service jika diperlukan)
        List<Service> selectedServices = new ArrayList<>();
        String chooseMore;
        do {
            System.out.println("Pilih Service:");
            for (Service service : serviceList) {
                System.out.println(service.getServiceId() + " - " + service.getServiceName());
            }
            System.out.print("Masukkan ID Service: ");
            String serviceId = input.nextLine();
            Service service = getServiceById(serviceId, serviceList);
            if (service != null) {
                selectedServices.add(service);
            }

            System.out.print("Tambah service lagi? (Y/T): ");
            chooseMore = input.nextLine();
        } while (chooseMore.equalsIgnoreCase("Y"));

        // Masukkan workstage
        // System.out.print("Masukkan Workstage (Waiting/In Process/Finished): ");
        String workstage = "In Process";

        // Membuat objek Reservation
        Reservation reservation = new Reservation(reservationIdSend+reservationId, customer, employee, selectedServices, workstage);

        // Tambahkan reservasi ke dalam daftar
        reservations.add(reservation);
        System.out.println("Booking berhasil: " + reservation);
        reservationId++;

    }

    public static List<Reservation> getReservations() {
        return reservations;
    }

    public static Customer getCustomerByCustomerId(String customerId, List<Person> personList){
        for (Person person : personList) {
            if (person instanceof Customer && person.getId().equals(customerId)) {
                return (Customer) person;
            }
        }
        return null; 
    }

    // Method untuk mendapatkan employee berdasarkan ID
    private static Employee getEmployeeById(String employeeId, List<Person> personList) {
        for (Person person : personList) {
            if (person instanceof Employee && person.getId().equals(employeeId)) {
                return (Employee) person;
            }
        }
        return null; // Jika employee tidak ditemukan
    }

    // Method untuk mendapatkan service berdasarkan ID
    private static Service getServiceById(String serviceId, List<Service> serviceList) {
        for (Service service : serviceList) {
            if (service.getServiceId().equals(serviceId)) {
                return service;
            }
        }
        return null; // Jika service tidak ditemukan
    }

    private static Reservation getReservationById(String reservationId, List<Reservation> reservationList) {
        for (Reservation reservation : reservationList) {
            if (reservation.getReservationId().equals(reservationId)) {
                return reservation;
            }
        }
        return null; // Jika reservasi tidak ditemukan
    }

    public static void editReservationWorkstage(){
        List<Reservation> reservationList = getReservations();
        List<Reservation> selectedReservation = new ArrayList<>();
        int num = 1;
        System.out.printf("| %-4s | %-4s | %-11s | %-15s | %-15s | %-15s | %-10s |\n",
                "No.", "ID", "Nama Customer", "Service", "Biaya Service", "Pegawai", "Workstage");
        System.out.println("+================================================================================================+");
        for (Reservation reservation : reservationList) {
            // Gunakan metode printServices untuk menampilkan list services dalam format string
            PrintService printService = new PrintService();
            String services = printService.printServices(reservation.getServices());
            
            // Tampilkan reservasi dalam format tabel
            System.out.printf("| %-4s | %-4s | %-11s | %-15s | %-15s | %-15s | %-10s |\n",
            num, reservation.getReservationId(), reservation.getCustomer().getName(), services, reservation.getReservationPrice(), reservation.getEmployee().getName(), reservation.getWorkstage());
            num++;

        }
        System.out.println("Silahkan masukkan Reservation Id:");
        String reservationId = input.nextLine();
        Reservation reservation = getReservationById(reservationId, reservationList);

        System.out.println("Selesaikan Reservasi:");
        String finishReservation = input.nextLine();

        if (finishReservation.equals("Finish")) {
            reservation.setWorkstage("Finish");
        } else if (finishReservation.equals("Cancel")) {
            // selectedReservation.remove(reservation);
            reservation.setWorkstage("Canceled");
        }
        System.out.println("Reservasi dengan ID " + reservationId + " sudah " + finishReservation);
    }

    // Silahkan tambahkan function lain, dan ubah function diatas sesuai kebutuhan
}
