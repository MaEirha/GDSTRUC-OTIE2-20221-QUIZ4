package com.sacdalan.quiz4;

public class SimpleHashtable {
    private StoredPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredPlayer[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        // applied linear probing
        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;

            // hashedkey is pointing at the last element
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }

            // search the array for the next immediate vacant position
            while (isOccupied(hashedKey) && hashedKey != stoppingIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey)) {
            System.out.println("Sorry, there is already an element at position " + hashedKey);
        }
        else {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    public int findKey(String key) {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) {
            return  hashedKey;
        }

        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (hashedKey != stoppingIndex &&
                    isOccupied(hashedKey) &&
                    !hashtable[hashedKey].getKey().equals(key)) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }

        return -1;
    }

    public Player get(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return  null;
        }

        return hashtable[hashedKey].getValue();
    }

    public boolean isOccupied(int index) {
        return hashtable[index] != null;
    }

    public void printHashtable() {
        System.out.println("\n=================================================================");
        System.out.println("Printing Current Hashtable :");
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] != null) {
                System.out.println("Element " + i + " " + hashtable[i].getValue());
            }
            else {
                System.out.println("Element " + i + " null");
            }
        }
        System.out.println("\n=================================================================");
    }

    public void remove(String key){
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            System.out.println("The element you seem to be looking for does not exist within the Hashtable.");
        }
        else{
            System.out.println(hashtable[hashedKey].getValue().getUserName() + " is being removed.\n");
            hashtable[hashedKey] = null;
        }
    }
}
