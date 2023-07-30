package com.dm.mesh.jiraplugin.suprDaily.service;

import com.dm.mesh.jiraplugin.suprDaily.Data;
import com.dm.mesh.jiraplugin.suprDaily.dto.Category;
import com.dm.mesh.jiraplugin.suprDaily.dto.DateItemKey;
import com.dm.mesh.jiraplugin.suprDaily.dto.Warehouse;
import com.dm.mesh.jiraplugin.suprDaily.dto.viewDto.ItemRequest;
import com.dm.mesh.jiraplugin.suprDaily.dto.viewDto.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yadvendranaveen
 * Date: 2021-01-22
 */

@Service
@Slf4j
public class OrderFulfilmentService {

    public Boolean canFulfilOrder(OrderRequest orderRequest) {

        Warehouse warehouse = orderRequest.getWarehouse();
        Map<DateItemKey, Integer> availableItemMap = warehouse.getAvailableItemMap();

        Map<Category, Integer> requestedCategoryQuantity = new HashMap<>();
        requestedCategoryQuantity.put(Category.F_N_V, 0);
        requestedCategoryQuantity.put(Category.DAIRY, 0); //TODO: use computeIfAbsent

        return checkValidity(orderRequest, availableItemMap, requestedCategoryQuantity);
    }

    public void reserveOrder(OrderRequest orderRequest) {
        if (!canFulfilOrder(orderRequest)) {
            throw new BadRequestException("Can't take this order");
        }


        Warehouse warehouse = orderRequest.getWarehouse();
        Map<DateItemKey, Integer> availableItemMap = warehouse.getAvailableItemMap();

        Map<Category, Integer> requestedCategoryQuantity = new HashMap<>();
        requestedCategoryQuantity.put(Category.F_N_V, 0);
        requestedCategoryQuantity.put(Category.DAIRY, 0); //TODO: use computeIfAbsent

        updateAvailableItems(orderRequest, availableItemMap, requestedCategoryQuantity);
        updateCategoryWiseItemQuantity(requestedCategoryQuantity);

// Finally Save active order for customer
//        Customer.save(orderRequest);
    }

    public void flattenOrderedItemsList() {
//     TODO: add order quantity in incoming order in case same item is added multiple times
    }

    Boolean checkValidity(OrderRequest orderRequest, Map<DateItemKey, Integer> availableItemMap, Map<Category, Integer> requestedCategoryQuantity) {
        for (ItemRequest itemRequest : orderRequest.getItemRequestList()) {
//            check 1
            DateItemKey key = DateItemKey.builder().item(itemRequest.getItem()).date(orderRequest.getDate()).build();
            if (itemRequest.getQuantity() > availableItemMap.get(key)) {
                return false;
            }
//            set up for check 2
            Category category = itemRequest.getItem().getCategory();
            Integer quantity = requestedCategoryQuantity.get(category);
            requestedCategoryQuantity.put(category, quantity + itemRequest.getQuantity());
        }

        // check 2
        for (Map.Entry<Category, Integer> requestedQuantityMap : requestedCategoryQuantity.entrySet()) {
            if (requestedQuantityMap.getValue() > Data.categoryAvailabilityMap.get(requestedQuantityMap.getKey())) {
                return false;
            }
        }
        return true;
    }

    void updateAvailableItems(OrderRequest orderRequest, Map<DateItemKey, Integer> availableItemMap, Map<Category, Integer> requestedCategoryQuantity) {
        for (ItemRequest itemRequest : orderRequest.getItemRequestList()) {
            DateItemKey key = DateItemKey.builder().item(itemRequest.getItem()).date(orderRequest.getDate()).build();

            // update corresponding to check 1
            Integer oldAvailability = availableItemMap.get(key);
            availableItemMap.put(key, oldAvailability - itemRequest.getQuantity());

            //set up for update corresponding to check 2
            Category category = itemRequest.getItem().getCategory();
            Integer quantity = requestedCategoryQuantity.get(category);
            requestedCategoryQuantity.put(category, quantity + itemRequest.getQuantity());
        }
    }

    void updateCategoryWiseItemQuantity(Map<Category, Integer> requestedCategoryQuantity) {
        // update corresponding to check 2
        for (Map.Entry<Category, Integer> requestedQuantityMap : requestedCategoryQuantity.entrySet()) {
            Category category = requestedQuantityMap.getKey();
            Integer oldValue = Data.categoryAvailabilityMap.get(category);
            Data.categoryAvailabilityMap.put(category, oldValue - requestedQuantityMap.getValue());
        }

    }
}
