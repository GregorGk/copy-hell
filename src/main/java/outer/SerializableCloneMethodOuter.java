package outer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import state.StateInterface;

public class SerializableCloneMethodOuter extends AbstractOuter implements Serializable {

  public SerializableCloneMethodOuter() {}

  public SerializableCloneMethodOuter(StateInterface mutableObject, int primitive) {
    super(mutableObject, primitive);
  }

  /**
   * The old way of deep cloning.
   * @throws Exception iff this object is not {@code Serializable}.
   */
  @Override
  public AbstractOuter cloneIt() throws Exception {
    Object toReturn = null;
    try {
      ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
      objectOutputStream.writeObject(this);
      objectOutputStream.flush();
      objectOutputStream.close();
      ObjectInputStream in = new ObjectInputStream(
          new ByteArrayInputStream(byteOutputStream.toByteArray()));
      toReturn = in.readObject();
    } catch (NotSerializableException serializationException) {
      throw serializationException;
    } catch (Exception differentException) {
      differentException.printStackTrace();
    }
    return (AbstractOuter) toReturn;
  }
}
