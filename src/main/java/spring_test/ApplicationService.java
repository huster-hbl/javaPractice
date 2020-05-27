package spring_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ApplicationService {
    @Autowired
    private PrizeSenderFactory prizeSenderFactory;

    public void mockedClient() {
        String request = "Virtual";
        PrizeSender prizeSender = prizeSenderFactory.getPrizeSender(request);
        prizeSender.sendPrize(request);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationService.class);
        ApplicationService service = context.getBean(ApplicationService.class);
        service.mockedClient();


    }
}
