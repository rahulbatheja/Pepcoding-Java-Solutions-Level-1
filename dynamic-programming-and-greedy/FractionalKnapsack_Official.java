import java.io.*;
import java.util.*;

public class Main {


    private static class Item {
        int itemWeight;
        int itemValue;
        double itemValuePerKg;

        public Item(int itemWeight, int itemValue, double itemValuePerKg) {
            this.itemWeight = itemWeight;
            this.itemValue = itemValue;
            this.itemValuePerKg = itemValuePerKg;
        }

        public int getItemWeight() {
            return itemWeight;
        }

        public void setItemWeight(int itemWeight) {
            this.itemWeight = itemWeight;
        }

        public int getItemValue() {
            return itemValue;
        }

        public void setItemValue(int itemValue) {
            this.itemValue = itemValue;
        }

        public double getItemValuePerKg() {
            return itemValuePerKg;
        }

        public void setItemValuePerKg(double itemValuePerKg) {
            this.itemValuePerKg = itemValuePerKg;
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int noOfItems = sc.nextInt();

        int[] values = new int[noOfItems];
        for (int i = 0; i < noOfItems; i++)
            values[i] = sc.nextInt();

        int[] weights = new int[noOfItems];
        for (int i = 0; i < noOfItems; i++)
            weights[i] = sc.nextInt();


        int allowedWeight = sc.nextInt();

        System.out.println(fractionalKnapsackHelper(values, weights, allowedWeight));
    }

    private static double fractionalKnapsackHelper(int[] values, int[] weights, int allowedWeight) {


        ArrayList<Item> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            list.add(new Item(weights[i], values[i], values[i] / weights[i]));
        }

        list.sort(Comparator.comparingDouble(Item::getItemValuePerKg).reversed());

        int currentItemIndex = 0;
        double amount = 0;
        while (allowedWeight > 0 && currentItemIndex < list.size()) {

            Item currentItem = list.get(currentItemIndex);
            while (allowedWeight > 0 && currentItem.getItemWeight() > 0) {
                amount += currentItem.getItemValuePerKg();
                currentItem.itemWeight--;
                allowedWeight--;
            }

            currentItemIndex++;

        }


        return amount;
    }

}