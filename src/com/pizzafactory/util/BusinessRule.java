package com.pizzafactory.util;

import com.pizzafactory.model.Inventory;
import com.pizzafactory.model.Order;

public interface BusinessRule {
    boolean verify(Order order, Inventory inventory);
}
