package org.example;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.fromFile("C:\\Users\\user\\IdeaProjects\\ShoeShop\\input.txt");
        shop.toConsole();

//        shop.Insert(new Shoe("Nike",11.2022,12,3.14));
//        shop.Insert(new Shoe("Adidas",11.2022,9,3.44));
//        shop.Insert(new Shoe("Nike",02.2021,15,2.53));

        shop.SortName();
        shop.toConsole();
        shop.BinSerchName("Adidas2");
        shop.SortPriceHigh();
        shop.toConsole();
        System.out.println(shop.ListDate(11.2022));
        shop.GroupByDate();
    }
}