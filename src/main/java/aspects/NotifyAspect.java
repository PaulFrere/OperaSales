package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotifyAspect {

    @Pointcut("@annotation(ru.zsa.operasales.annotations.Notifiable)")
    public void notifyEmail(){

    }
    @After("notifyEmail()")
    public void after(JoinPoint point) {
        String msg = "Executed method";
        String name = point.getSignature().getName();
        send("Executed method" + name);
    }

    private void send(String msg) {
        System.out.println("Send letter to info@operasales.com");
    }

}
