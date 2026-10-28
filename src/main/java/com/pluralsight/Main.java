package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Product> inventory = getInventory();

        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    public static ArrayList<Product> getInventory() {

        ArrayList<Product> inventory = new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader("inventory.csv"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);

                Product product = new Product(id, name, price);

                inventory.add(product);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return inventory;
    }
}