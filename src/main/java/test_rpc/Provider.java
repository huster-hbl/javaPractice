package test_rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Provider {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ServerSocket sever = new ServerSocket(1234);
        while (true) {
            Socket socket = sever.accept();
            System.out.println("accept!");

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            String interfaceName = inputStream.readUTF();
            String methodName = inputStream.readUTF();
            Class<?>[] parameterTypes = (Class<?>[])inputStream.readObject();
            Object[] arguments = (Object[]) inputStream.readObject();

            Class serviceInterfaceClass = Class.forName(interfaceName);
            Method method = serviceInterfaceClass.getMethod(methodName, parameterTypes);
            Object result = method.invoke(new SayHelloServiceImpl(), arguments);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
        }
    }
}
