package test_rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class Consumer {
    public void consumer() throws NoSuchMethodException, IOException, ClassNotFoundException {
        String interfaceName = SayHelloService.class.getName();
        Method method = SayHelloService.class.getMethod("sayHello", String.class);
        Object[] arguments = {"hello"};
        Socket socket = new Socket("127.0.0.1", 1234);
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        output.writeUTF(interfaceName);
        output.writeUTF(method.getName());
        output.writeObject(method.getParameterTypes());
        output.writeObject(arguments);

        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        Object result = input.readObject();
        System.out.println(result);

    }

    public static void main(String[] args) throws NoSuchMethodException, IOException, ClassNotFoundException {
        new Consumer().consumer();
    }
}
