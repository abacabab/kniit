package org.kniit.lab5.task8;
import java.util.*;
import java.util.stream.Stream;

class ShopItem{
    String name;
    int cost, amount_in_stock;
    ShopItem(String name, int cost, int amount_in_stock){
        this.name = name;
        this.cost = cost;
        this.amount_in_stock = amount_in_stock;
    }
    @Override
    public String toString(){
        return String.format("%s %d %d", this.name, this.cost, this.amount_in_stock);
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.cost, this.amount_in_stock);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItem shopItem = (ShopItem) o;
        if (this.cost != shopItem.cost) return false;
        if (this.amount_in_stock != shopItem.amount_in_stock) return false;
        return this.name.equals(shopItem.name);
    }
}

public class Main {
    public static void main(String[] args) {
        String[] names = {"книга", "ручка", "линейка", "пенал", "шапка", "куртка", "карандаш"};
        Random random = new Random();
        ShopItem[] shopItems = new ShopItem[100];
        for (int i = 0; i < 100; i++)
        {
            int index = random.nextInt(names.length);
            shopItems[i] = new ShopItem(names[index], 88, i % 11 + 100);
        }
        Arrays.sort(shopItems, Comparator.comparingInt((ShopItem shopItem) -> {return shopItem.amount_in_stock; }));
        for (ShopItem shopItem : shopItems) {
            System.out.println(shopItem);
        }
        Set<ShopItem> shopItemSet = new HashSet<>(Arrays.asList(shopItems));
        System.out.println(shopItems.length - shopItemSet.size());
    }
}