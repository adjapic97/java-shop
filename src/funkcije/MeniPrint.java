package funkcije;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MeniPrint {
    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Odaberi opciju: ");
    }

    public static Integer print(String[] options) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option < 1 || option > options.length) {
            printMenu(options);
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Unesite vrednost izmedju 1 i " + options.length);
                scanner.next();
            } catch (Exception ex) {
                System.out.println("Neocekivana greska se desila, pokusajte ponovo! :)");
                scanner.next();
            }
        }
        return option;
    }
}
