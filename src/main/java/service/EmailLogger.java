package service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("Email")
public class EmailLogger implements Logger{
    @Override
    public void print(Object object){
        System.out.println("Send email: " + object);
    }
}
