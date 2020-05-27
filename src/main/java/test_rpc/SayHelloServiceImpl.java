package test_rpc;

public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello(String helloArg) {
        if (helloArg.equals("hello")) {
            return "hello";
        }
        return "bye, bye";
    }
}
