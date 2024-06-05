package Lottospiel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;

public class Lottospiel {

    public static void main(String[] args) {
        ArrayList<Integer> alZahlenstapel = new ArrayList<>();
        ArrayList<Integer> alTreffer = new ArrayList<>();
        ArrayList<Integer> alEingaben = new ArrayList<>();
        ArrayList<Integer> alLottozahlen = new ArrayList<>();
        ArrayList<Integer> alEingabeZahlen = new ArrayList<>();
        
        int min_val = 1;
        int max_val = 49;
        int list_size = 48;
        int list_size2 = 6;
        int versuche = 0;
        int eingabeZahl = 0;
        String eingabe;
        
        Random rand = new Random();
        while (alZahlenstapel.size() <= list_size) {
            int zufallsWert = min_val + rand.nextInt((max_val - min_val) + 1);
            
            if (!alZahlenstapel.contains(zufallsWert)) {
                alZahlenstapel.add(zufallsWert);
            }
        }
        
        // Lottozahlen bestimmen
        Collections.shuffle(alZahlenstapel);
        alLottozahlen.addAll(alZahlenstapel.subList(0, list_size2));
        
       // System.out.println("Die gezogenen Lottozahlen sind: " + alLottozahlen);
        
        do {
            eingabe = JOptionPane.showInputDialog(null, 
                    "Geben Sie eine Zahl ein!", 
                    "Wert in ArrayList suchen", 
                    JOptionPane.INFORMATION_MESSAGE);
            
            // Überprüfen, ob die Eingabe null oder leer ist
            if (eingabe == null || eingabe.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ungültige Eingabe! Bitte geben Sie eine gültige Zahl ein." + (5 - versuche) + " Versuche übrig!");
                continue;
            }
            try {
                eingabeZahl = Integer.parseInt(eingabe);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ungültige Eingabe! Bitte geben Sie eine gültige Zahl ein." + (5 - versuche) + " Versuche übrig!");
                System.out.println(eingabeZahl + "Ungültige Eingabe! Bitte geben Sie eine gültige Zahl ein. " + (5 - versuche) + " Versuche übrig!");
                continue;
            }
            
            if (alEingabeZahlen.contains(eingabeZahl)) {
                JOptionPane.showMessageDialog(null, "Diese Zahl hattest du bereits gewählt, bitte wähle eine andere Zahl." + (5 - versuche) + " Versuche übrig!");
            } else {
                alEingaben.add(eingabeZahl);
                alEingabeZahlen.add(eingabeZahl);

                if (alLottozahlen.contains(eingabeZahl)) {
                    alTreffer.add(eingabeZahl);
                    JOptionPane.showMessageDialog(null, eingabeZahl + " ist eine der gezogenen Lottozahlen!" + (5 - versuche) + " Versuche übrig!");
                } else {
                    JOptionPane.showMessageDialog(null, eingabeZahl + " ist leider kein Treffer.. Du hast noch " + (5 - versuche) + " Versuche übrig!");
                    System.out.println("Leider kein Treffer.. Du hast noch " + (5 - versuche) + " Versuche übrig!");
                }
                versuche++;
            }
        } while (versuche < 6);
        
        System.out.println("Deine gewählten Zahlen waren: " + alEingaben);
        System.out.println("Die Lottozahlen waren: " + alLottozahlen);
        System.out.println("Du hattest folgende Treffer: " + alTreffer);
    }
}
