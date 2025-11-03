

import FacadePattern.WeatherFacade;
import StrategyPattern.Concretes.APIUpdate;
import StrategyPattern.Concretes.ManualUpdate;
import StrategyPattern.Concretes.RealTimeUpdate;
import StrategyPattern.Concretes.ScheduledUpdate;

import java.util.Scanner;

public class MainDemo {
    public static void main(String[] args) {
        WeatherFacade system = new WeatherFacade();
        system.addObserver("MobileApp");
        system.addObserver("SmartWatch");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Weather System ---");
            System.out.println("1. Manual Update");
            System.out.println("2. Scheduled Update");
            System.out.println("3. API (Online) Update");
            System.out.println("4. Real-Time Update");
            System.out.println("5. Change City");
            System.out.println("0. Exit");
            System.out.print("Select: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) break;

            System.out.print("Enter city (Almaty/Astana/Shymkent/Aktobe): ");
            String city = sc.nextLine();

            switch (choice) {
                case 1 -> system.changeStrategy(new ManualUpdate());
                case 2 -> system.changeStrategy(new ScheduledUpdate());
                case 3 -> system.changeStrategy(new APIUpdate());
                case 4 -> system.changeStrategy(new RealTimeUpdate());
                default -> System.out.println("Invalid option!");
            }

            system.updateCity(city);
        }
        System.out.println("System closed.");
    }
}