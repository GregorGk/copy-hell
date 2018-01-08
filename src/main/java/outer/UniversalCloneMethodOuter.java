package outer;

import com.rits.cloning.Cloner;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import state.StateInterface;

public class UniversalCloneMethodOuter extends AbstractOuter {

  public UniversalCloneMethodOuter() {
  }

  public UniversalCloneMethodOuter(StateInterface mutableObject, int primitive) {
    super(mutableObject, primitive);
  }

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
      Cloner cloner = new Cloner();
      toReturn = cloner.deepClone(this);
    } catch (Exception differentException) {
      differentException.printStackTrace();
    }
    return (AbstractOuter) toReturn;
  }
}
