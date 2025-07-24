package org.example1.service;
import org.example1.domain.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class EmailServiceTest {
    @Test
    void testSendEmailWithCc() {
        EmailService emailService = EmailService.getInstance();
        Order order = new Order(3, "Wireless Earbuds", 89.99);

        boolean result = emailService.sendEmail(order, "support@company.com");

        assertTrue(result);
        assertTrue(order.isCustomerNotified());
    }
    @Test
    void testSendEmailThrowsException() {
        EmailService emailService = EmailService.getInstance();
        Order order = new Order(5, "Smartwatch", 299.49);

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            emailService.sendEmail(order);
        });

        assertEquals("An Exception Occurred", ex.getMessage());
        assertFalse(order.isCustomerNotified());
    }
}
