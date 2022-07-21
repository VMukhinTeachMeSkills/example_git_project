package com.tms.courses.vm.lesson16;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class StoreService
{
    public static void main(String[] args)
    {
        User user1 = new User("ignat@gmail.com", "Ignat");
        User user2 = new User("pasha@gmail.com", "Pasha");
        User user3 = new User("vitaly@gmail.com", "Vitaly");
        User user4 = new User("yuri@gmail.com", "Yuri");

        Product product1 = new Product("Iphone 10", 600d);
        Product product2 = new Product("Samsung S8", 450.5d);
        Product product3 = new Product("Huawei P20", 500d);
        Product product4 = new Product("Xiaomi Redmi Note 10", 330d);
        Product product5 = new Product("Nokia 3310", 80d);

        Map<Product, Integer> map1 = new HashMap<>();
        map1.put(product1, 1);
        Order order1 = new Order(
                "1",
                map1,
                Date.from(LocalDate.of(2022, 7, 21).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                user1);

        Map<Product, Integer> map2 = new HashMap<>();
        map2.put(product2, 5);
        map2.put(product3, 1);
        Order order2 = new Order(
                "2",
                map2,
                Date.from(LocalDate.of(2022, 7, 20).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                user3);

        Map<Product, Integer> map3 = new HashMap<>();
        map3.put(product5, 1);
        Order order3 = new Order(
                "3",
                map3,
                Date.from(LocalDate.of(2022, 6, 10).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                user2);

        Map<Product, Integer> map4 = new HashMap<>();
        map4.put(product4, 2);
        map4.put(product2, 1);
        map4.put(product1, 10);

        Order order4 = new Order(
                "4",
                map4,
                Date.from(LocalDate.of(2022, 6, 25).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                user4);

        Store store = new Store(Arrays.asList(order1, order2, order3, order4));

        sum(store);
        showOrders(store,
                Date.from(LocalDate.of(2022, 6, 27).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDate.of(2022, 7, 30).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        findMostValuableProduct(store);
    }

    public static void sum(Store store)
    {
        Optional<Double> sum = store.getOrders().stream()
                .map(order -> order.getEntries().entrySet().stream()
                        .map(StoreService::getEntryTotalPrice)
                        .reduce(Double::sum)
                        .get())
                .reduce(Double::sum);
        System.out.println(sum.get());
    }

    private static double getEntryTotalPrice(Map.Entry<Product, Integer> entry)
    {
        return entry.getKey().getPrice() * entry.getValue();
    }

    public static void showOrders(Store store, Date from, Date to)
    {
        List<Order> orders = store.getOrders().stream()
                .filter(order -> order.getDate().after(from) && order.getDate().before(to))
                .collect(Collectors.toList());
        System.out.println(orders);
    }

    public static void findMostValuableProduct(Store store)
    {
        Map<Product, Double> productToTotalEarningsMap = new HashMap<>();
        store.getOrders().stream()
                .forEach(order ->
                {
                    order.getEntries().entrySet().stream()
                            .forEach(entry ->
                            {
                                Product product = entry.getKey();
                                Double priceToSet = getEntryTotalPrice(entry);
                                if (productToTotalEarningsMap.containsKey(product))
                                {
                                    priceToSet += productToTotalEarningsMap.get(product);
                                }
                                productToTotalEarningsMap.put(product, priceToSet);
                            });
                });
        Optional<Product> result = productToTotalEarningsMap.entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey);
        System.out.println(result.get());
    }
}
