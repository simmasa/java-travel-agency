package jana60;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Agenzia {
    public static void main(String[] args) {
        System.out.println("Benvenuto");
        Scanner scan = new Scanner(System.in);
        System.out.println("Premi: 1 per programmare una nuova vacanza");
        System.out.println("       2 per uscire");
        String welcomeOpt = scan.nextLine();

        switch (welcomeOpt) {
            case "2":
                System.out.println("Grazie per averi scelto");
                break;
            case "1":
                System.out.println("Inserisci destinazione: ");
                String destinazione = scan.nextLine();
                System.out.println("Inserisci data di partenza: (dd/mm/yyyy) ");
                String dataInizio = scan.nextLine();
                System.out.println("Inserisci data di ritorno:  (dd/mm/yyyy) ");
                String dataFine = scan.nextLine();

                try {
                    Vacanza vacanza1 =   new Vacanza(destinazione, dataInizio , dataFine);
                    System.out.println("Grazie.");
                    System.out.println(vacanza1);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (DateTimeParseException e) {
                    System.out.println("Le date non sono state inserite correttamente");
                }


        }
        scan.close();
    }
}
