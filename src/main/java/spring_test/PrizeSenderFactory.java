package spring_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrizeSenderFactory {
    @Autowired
    private List<PrizeSender> prizeSenders;

    public PrizeSender getPrizeSender(String s) {
        for (PrizeSender prizeSender : prizeSenders) {
            if (prizeSender.support(s)) {
                return prizeSender;
            }
        }
        throw new UnsupportedOperationException("unsupport" + s);
    }
}
