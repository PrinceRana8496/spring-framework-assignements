package org.example1.service;
import org.example1.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class OrderServiceTest {

    private OrderService orderService;
    @BeforeEach
    void setUp() {
        orderService = OrderService.getInstance();
    }
    @Test
    void testPlaceOrderThrowsException() {
        Order order = new Order(4, "Bluetooth Speaker", 250.0);

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            orderService.placeOrder(order);
        });

        assertEquals("An Exception Occurred", ex.getMessage());
        assertEquals(300.0, order.getPriceWithTax(), 0.001);
        assertFalse(order.isCustomerNotified());
    }

    @Test
    void testPlaceOrderWithCcSuccess() {
        Order order = new Order(2, "USB-C Cable", 75.0);
        boolean result = orderService.placeOrder(order, "team@servicehub.io");

        assertTrue(result);
        assertTrue(order.isCustomerNotified());
        assertEquals(90.0, order.getPriceWithTax(), 0.001);
    }
}
