package utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class Serializer {

    private Serializer(){}

    public static ByteBuffer serialize(Serializable obj) {
        try{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(obj);
            oos.flush();
            return ByteBuffer.wrap(outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ByteBuffer.allocate(8);
    }
}

