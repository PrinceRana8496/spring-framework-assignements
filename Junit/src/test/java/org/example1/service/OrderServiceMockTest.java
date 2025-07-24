package org.example1.service;

import org.example1.domain.Order;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceMockTest {
    @Mock
    private EmailService emailService;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testPlaceOrderWithoutCC() {
        Order order = new Order();
        order.setPrice(100.0);
        doNothing().when(emailService).sendEmail(order);
        orderService.placeOrder(order);
        assertEquals(120.0, order.getPriceWithTax());
        assertTrue(order.isCustomerNotified());
        verify(emailService, times(1)).sendEmail(order);

    }
    @Test
    public void testPlaceOrderWithCC() {
        Order order = new Order();
        order.setPrice(200.0);
        when(emailService.sendEmail(order, "abc@example.com")).thenReturn(true);
        boolean result = orderService.placeOrder(order, "abc@example.com");
        assertTrue(result);
        assertEquals(240.0, order.getPriceWithTax());
        verify(emailService, times(1)).sendEmail(order, "abc@example.com");
    }
}
