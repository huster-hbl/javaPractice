package spring_test;

import org.springframework.stereotype.Component;

@Component
public class CashSender implements PrizeSender {
    @Override
    public boolean support(String string) {
        return string.equals("cash");
    }

    @Override
    public void sendPrize(String string) {
        System.out.println("发放现金");
    }
}
