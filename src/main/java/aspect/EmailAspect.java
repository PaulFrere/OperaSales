package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmailAspect {
    @Pointcut ("@annotation(ru.zsa.operasales.annotation.Notifierable)")

    public void sendEmail(){}

    @AfterReturning("sendEmail()")

    public void sendEmailAfterSuccess(JoinPoint point){
        System.out.println("email sent successfully");
    }
}
