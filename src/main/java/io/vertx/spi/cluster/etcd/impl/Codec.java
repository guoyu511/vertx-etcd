package io.vertx.spi.cluster.etcd.impl;

import com.google.protobuf.ByteString;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import io.vertx.core.VertxException;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.shareddata.impl.ClusterSerializable;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
class Codec {

  static ByteString toByteString(Object object) {
    if (object == null) {
      return ByteString.EMPTY;
    }
    try {
      ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
      DataOutput dataOutput = new DataOutputStream(byteOut);
      if (object instanceof ClusterSerializable) {
        ClusterSerializable clusterSerializable = (ClusterSerializable) object;
        dataOutput.writeBoolean(true);
        dataOutput.writeUTF(object.getClass().getName());
        Buffer buffer = Buffer.buffer();
        clusterSerializable.writeToBuffer(buffer);
        byte[] bytes = buffer.getBytes();
        dataOutput.writeInt(bytes.length);
        dataOutput.write(bytes);
      } else {
        dataOutput.writeBoolean(false);
        ByteArrayOutputStream javaByteOut = new ByteArrayOutputStream();
        ObjectOutput objectOutput = new ObjectOutputStream(javaByteOut);
        objectOutput.writeObject(object);
        dataOutput.write(javaByteOut.toByteArray());
      }
      return ByteString.copyFrom(byteOut.toByteArray());
    } catch (IOException e) {
      throw new VertxException(e);
    }
  }

  static <T> T fromByteString(ByteString bytes) {
    if (bytes.equals(ByteString.EMPTY)) {
      return null;
    }
    try {
      ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes.toByteArray());
      DataInputStream in = new DataInputStream(byteIn);
      boolean isClusterSerializable = in.readBoolean();
      if (isClusterSerializable) {
        String className = in.readUTF();
        Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(className);
        int length = in.readInt();
        byte[] body = new byte[length];
        in.readFully(body);
        try {
          ClusterSerializable clusterSerializable;
          if (clazz.getConstructors().length == 0) {
            Constructor<T> constructor = (Constructor<T>) clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            clusterSerializable = (ClusterSerializable) constructor.newInstance();
          } else {
            clusterSerializable = (ClusterSerializable) clazz.newInstance();
          }
          clusterSerializable.readFromBuffer(0, Buffer.buffer(body));
          return (T) clusterSerializable;
        } catch (Exception e) {
          throw new IllegalStateException("Failed to load class " + e.getMessage(), e);
        }
      } else {
        byte[] body = new byte[in.available()];
        in.readFully(body);
        ObjectInputStream objectIn = new ObjectInputStream(new ByteArrayInputStream(body));
        return (T) objectIn.readObject();
      }
    } catch (IOException | ClassNotFoundException e) {
      throw new VertxException(e);
    }
  }
}
