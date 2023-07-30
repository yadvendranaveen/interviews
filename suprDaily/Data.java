package com.dm.mesh.jiraplugin.suprDaily;

import com.dm.mesh.jiraplugin.suprDaily.dto.Category;
import com.dm.mesh.jiraplugin.suprDaily.dto.DateItemKey;
import com.dm.mesh.jiraplugin.suprDaily.dto.Item;
import com.dm.mesh.jiraplugin.suprDaily.dto.Warehouse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yadvendranaveen
 * Date: 2021-01-22
 */

public class Data {

    public static Map<Integer, Item> itemMap;

    public static Map<Integer, Warehouse> warehouseMap;

    public static Map<Category, Integer> categoryAvailabilityMap;

    static {
        Item item1 = Item.builder().id(1).name("Apple 1kg").category(Category.F_N_V).build();
        Item item2 = Item.builder().id(2).name("Milk 1l").category(Category.DAIRY).build();

        itemMap = new HashMap<>();
        itemMap.put(1, item1);
        itemMap.put(2, item2);

        DateItemKey dateItemKeyI1 = DateItemKey.builder()
                .date("2021-01-01")
                .item(item1)
                .build();
        DateItemKey dateItemKeyI2 = DateItemKey.builder()
                .date("2021-01-01")
                .item(item2)
                .build();
        DateItemKey dateItemKeyD1 = DateItemKey.builder()
                .date("2021-01-02")
                .item(item1)
                .build();
        DateItemKey dateItemKeyD2 = DateItemKey.builder()
                .date("2021-01-02")
                .item(item2)
                .build();

        Map<DateItemKey, Integer> availableItemMap1 = new HashMap<>();
        availableItemMap1.put(dateItemKeyI1, 50);
        availableItemMap1.put(dateItemKeyI2, 150);
        availableItemMap1.put(dateItemKeyD2, 200);
        availableItemMap1.put(dateItemKeyD2, 250);

        Map<DateItemKey, Integer> availableItemMap2 = new HashMap<>();
        availableItemMap2.put(dateItemKeyI1, 10);
        availableItemMap2.put(dateItemKeyI2, 20);
        availableItemMap2.put(dateItemKeyD2, 30);
        availableItemMap2.put(dateItemKeyD2, 40);

        warehouseMap = new HashMap<>();
        Warehouse warehouse1 = Warehouse.builder()
                .id(1)
                .availableItemMap(availableItemMap1)
                .build();
        Warehouse warehouse2 = Warehouse.builder()
                .id(2)
                .availableItemMap(availableItemMap2)
                .build();

        warehouseMap.put(1, warehouse1);
        warehouseMap.put(2, warehouse2);

        categoryAvailabilityMap = new HashMap<>();
        categoryAvailabilityMap.put(Category.F_N_V, 250);
        categoryAvailabilityMap.put(Category.DAIRY, 400);
    }
}
