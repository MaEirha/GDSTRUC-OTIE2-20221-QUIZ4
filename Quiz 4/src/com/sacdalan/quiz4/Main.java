package com.sacdalan.quiz4;

public class Main {
    public static void main(String[] args) {
        Player pikachu = new Player(25, "Pikachu", 1);
        Player celebi = new Player(251, "Celebi", 2);
        Player hitmonchan = new Player(107, "Hitmonchan", 3);
        Player mankey = new Player(56, "Mankey", 4);
        Player starmie = new Player(175, "Starmie", 4);

        SimpleHashtable hashtable = new SimpleHashtable();

        hashtable.put(celebi.getUserName(), celebi);
        hashtable.put(mankey.getUserName(), mankey);
        hashtable.put(pikachu.getUserName(), pikachu);
        hashtable.put(hitmonchan.getUserName(), hitmonchan);
        hashtable.put(starmie.getUserName(), starmie);

        hashtable.printHashtable();

        System.out.println("\n Removing Mankey.");
        hashtable.remove("Mankey");
        hashtable.printHashtable();

        System.out.println("\n Removing Mankey when it doesn't exist.");
        hashtable.remove("Mankey");

        System.out.println("\n Removing Celebi.");
        hashtable.remove("Celebi");
        hashtable.printHashtable();
    }
}
