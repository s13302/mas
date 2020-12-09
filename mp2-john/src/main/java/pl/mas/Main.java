package pl.mas;

import pl.mas.model.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Narty nartyRossignol = new Narty("Rossignol", "K-1000", "ABH181", 48.7);
        Narty nartyQuickSilver = new Narty("QuickSilver", "AB-123", "88872K", 32.8);
        MagazynSprzetu magazynSprzetu = new MagazynSprzetu();
        magazynSprzetu.addSprzet(nartyRossignol);
        nartyQuickSilver.setMagazyn(magazynSprzetu); // Asocjacja kwalifikowana                            Sprzet -> MagazynSprzetu

        DaneOsobowe daneOsoboweMarcinZielonkiewicz = new DaneOsobowe("Marcin", "Zielonkiewicz", "s17934");
        DaneOsobowe daneOsoboweKarolKrawczyk = new DaneOsobowe("Karol", "Krawczyk", "AVG2211");
        Wypozyczenie wypozyczenie = new Wypozyczenie(daneOsoboweMarcinZielonkiewicz); // Asocjacja binarna Wypozyczenie -> DaneOsobowe
        daneOsoboweKarolKrawczyk.addWypozyczenie(wypozyczenie); // Asocjacja binarna                       DaneOsobowe -> Wypozyczenie

        System.out.println(magazynSprzetu.getSprzet("ABH181")); // Asocjacja kwalifikowana     MagazynSprzetu -> Sprzet

        Instruktor instruktor1 = new Instruktor("Kamil", "Blak");
        Instruktor instruktor2 = new Instruktor("Bożena", "Rączka");
        Grafik grafik1 = new Grafik(new BigDecimal(3.5), instruktor1, magazynSprzetu);
        Grafik grafik2 = new Grafik(new BigDecimal(4.5), instruktor2, magazynSprzetu);

        System.out.println(instruktor1.getGrafik()); // Asocjacja z atrybutem                              Instruktor -> Grafik -> MagazynSprzetu
        System.out.println(magazynSprzetu.getGrafik()); // Asocjacja z atrybutem                           MagazynSprzetu -> Grafik -> Instruktor

        instruktor1.addSprzetInstruktora("narty"); // Kompozycja                                    Instruktor -> SprzetInstruktora
        instruktor1.addSprzetInstruktora("snowboard"); // Kompozycja                                Instruktor -> SprzetInstruktora
        instruktor2.addSprzetInstruktora("narty"); // Kompozycja                                    Instruktor -> SprzetInstruktora

        System.out.println(instruktor1.getSprzetInstruktora());
        System.out.println(instruktor2.getSprzetInstruktora());

        instruktor2.getSprzetInstruktora().stream().forEach(sprzet -> System.out.println(sprzet.getInstruktor()));
    }

}
