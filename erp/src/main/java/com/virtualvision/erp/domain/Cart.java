package com.virtualvision.erp.domain;
//importa product
import com.virtualvision.erp.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Long, Integer> items = new HashMap<>();

    public void addProduct(Long productId, int quantity) {
        int currentQuantity = items.getOrDefault(productId, 0);
        items.put(productId, currentQuantity + quantity);
    }

    public void removeProduct(Long productId) {
        items.remove(productId);
    }

    public void updateProduct(Long productId, int quantity) {
        if (items.containsKey(productId)) {
            if (quantity > 0) {
                items.put(productId, quantity);
            } else {
                removeProduct(productId);
            }
        }
    }

    public void clear() {
        items.clear();
    }

    public Map<Long, Integer> getItems() {
        return items;
    }

    // Puedes añadir más métodos según sea necesario
}

