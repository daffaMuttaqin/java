package com.booking.service;

import java.util.ArrayList;
import java.util.List;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;
import com.booking.repositories.PersonRepository;

public class PrintService {
    public static void printMenu(String title, String[] menuArr){
        int num = 1;
        System.out.println(title);
        for (int i = 0; i < menuArr.length; i++) {
            if (i == (menuArr.length - 1)) {   
                num = 0;
            }
            System.out.println(num + ". " + menuArr[i]);   
            num++;
        }
    }

    public String printServices(List<Service> serviceList){
        StringBuilder serviceNames = new StringBuilder();
        for (Service service : serviceList) {
            serviceNames.append(service.getServiceName()).append(", ");
        }
        // Menghapus koma terakhir jika ada
        if (serviceNames.length() > 0) {
            serviceNames.setLength(serviceNames.length() - 2); // Hilangkan ", " terakhir
        }
        return serviceNames.toString();
    }

    public String printReservation(List<Reservation> reservationList){
        StringBuilder reservationNames = new StringBuilder();
        for (Reservation reservation : reservationList) {
            reservationNames.append(reservation.getReservationId()).append(", ");
        }
        // Menghapus koma terakhir jika ada
        if (reservationNames.length() > 0) {
            reservationNames.setLength(reservationNames.length() - 2); // Hilangkan ", " terakhir
        }
        return reservationNames.toString();
    }

    // Function yang dibuat hanya sebgai contoh bisa disesuaikan kembali
    public void showRecentReservation(){
        List<Reservation> reservationList = ReservationService.getReservations();
        int num = 1;
        System.out.printf("| %-4s | %-4s | %-11s | %-15s | %-15s | %-15s | %-10s |\n",
                "No.", "ID", "Nama Customer", "Service", "Biaya Service", "Pegawai", "Workstage");
        System.out.println("+================================================================================================+");
        for (Reservation reservation : reservationList) {
            // Hanya tampilkan reservasi dengan workstage "In process"
            if (reservation.getWorkstage().equalsIgnoreCase("In Process")) {
                // Gunakan metode printServices untuk menampilkan list services dalam format string
                String services = printServices(reservation.getServices());
                
                // Tampilkan reservasi dalam format tabel
                System.out.printf("| %-4s | %-4s | %-11s | %-15s | %-15s | %-15s | %-10s |\n",
                num, reservation.getReservationId(), reservation.getCustomer().getName(), services, reservation.getReservationPrice(), reservation.getEmployee().getName(), reservation.getWorkstage());
                num++;
            }
        }
    }
    public void showAllCustomer(){
        int num = 1;
        ArrayList<Customer> customerList = new ArrayList<>();

        // Mengambil semua Person dari PersonRepository dan memfilter hanya Customer
        for (Person person : PersonRepository.getAllPerson()) {
            if (person instanceof Customer customer) {
                customerList.add(customer); // Cast person menjadi Customer
            }
        }

        System.out.printf("| %-4s | %-8s | %-13s | %-15s | %-15s | %-15s\n",
                "No.", "ID", "Nama", "Alamat", "Membership", "Uang");
        System.out.println("+========================================================================================+");
        for (Customer customer : customerList) {
            System.out.printf("| %-4s | %-8s | %-13s | %-15s | %-15s | %-15s\n",
                num, customer.getId(), customer.getName(), customer.getAddress(), customer.getMember().getMembershipName(), customer.getWallet());
            num++;
        }
        System.out.println();
    }
    public void showAllEmployee(){
        int num = 1;
        ArrayList<Employee> employeeList = new ArrayList<>();

        for (Person person : PersonRepository.getAllPerson()){
            if (person instanceof Employee employee) {
                employeeList.add(employee);
            }
        }
        
        System.out.printf("| %-4s | %-8s | %-13s | %-15s | %-15s\n",
                "No.", "ID", "Nama", "Alamat", "Pengalaman");
        System.out.println("+========================================================================================+");
        for (Employee employee : employeeList) {
            System.out.printf("| %-4s | %-8s | %-13s | %-15s | %-15s\n",
                num, employee.getId(), employee.getName(), employee.getAddress(), employee.getExperience());
            num++;   
        }

        System.out.println();

    }

    public void showHistoryReservation(){
        List<Reservation> reservationList = ReservationService.getReservations();
        int num = 1;
        System.out.printf("| %-4s | %-8s | %-13s | %-20s | %-15s | %-15s\n",
                "No.", "ID", "Nama Customer", "Service", "Total Biaya", "Workstage");
        System.out.println("+================================================================================================+");

        for (Reservation reservation : reservationList) {
            // Gunakan metode printServices untuk menampilkan list services dalam format string
            PrintService printService = new PrintService();
            String services = printService.printServices(reservation.getServices());
            
            // Tampilkan reservasi dalam format tabel
            System.out.printf("| %-4s | %-8s | %-13s | %-20s | %-15s | %-15s\n",
            num, reservation.getReservationId(), reservation.getCustomer().getName(), services, reservation.getReservationPrice(), reservation.getWorkstage());
            num++;

        }
    }
}
