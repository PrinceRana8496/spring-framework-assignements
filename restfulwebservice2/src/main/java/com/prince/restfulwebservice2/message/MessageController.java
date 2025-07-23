package com.prince.restfulwebservice2.message;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class MessageController {
    private MessageSource messageSource;

    public MessageController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @GetMapping("/message")
    public String sendMessage(@RequestParam String firstname,@RequestParam String lastname)
    {
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("greeting.message",new Object[]{firstname,lastname},
                "Hello",locale);

    }

}
