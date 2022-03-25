package service;

import org.springframework.stereotype.Component;

@Component
public class ConsoleLogger implements Logger{
    @Override
    public void print(Object object) {
        System.out.println(object);
    }
}
