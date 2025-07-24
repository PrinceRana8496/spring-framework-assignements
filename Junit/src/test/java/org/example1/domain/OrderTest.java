package org.example1.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class OrderTest {

    @Test
    void testOrderSettersAndGetters() {
        Order order = new Order();
        order.setItemName("Laptop")
                .setQuantity(2)
                .setPrice(500.0)
                .setPriceWithTax(100.0);

        assertEquals("Laptop", order.getItemName());
        assertEquals(2, order.getQuantity());
        assertEquals(500.0, order.getPrice());
        assertEquals(600.0, order.getPriceWithTax(), 0.001);
    }

    @Test
    void testConstructorAndNotificationFlag() {
        Order order = new Order(1, "Mouse", 50.0);
        order.setCustomerNotified(true);

        assertEquals("Mouse", order.getItemName());
        assertEquals(1, order.getQuantity());
        assertEquals(50.0, order.getPrice());
        assertTrue(order.isCustomerNotified());
    }
}