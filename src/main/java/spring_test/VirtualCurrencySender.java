package spring_test;

import org.springframework.stereotype.Component;

@Component
public class VirtualCurrencySender implements PrizeSender {
    @Override
    public boolean support(String string) {
        return string.equals("Virtual");
    }

    @Override
    public void sendPrize(String string) {
        System.out.println("发放虚拟币");

    }
}
