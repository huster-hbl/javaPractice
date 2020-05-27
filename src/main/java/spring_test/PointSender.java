package spring_test;

import org.springframework.stereotype.Component;

@Component
public class PointSender implements PrizeSender {

    @Override
    public boolean support(String string) {
        return string.equals("Point");
    }

    @Override
    public void sendPrize(String string) {
        System.out.println("发放积分");

    }
}
