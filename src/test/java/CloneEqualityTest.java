import java.io.NotSerializableException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import outer.AbstractOuter;
import outer.DefaultCloneMethodOuter;
import outer.SerializableCloneMethodOuter;
import outer.UniversalCloneMethodOuter;
import state.NonSerializableState;
import state.SerializableState;
import state.StateInterface;

public class CloneEqualityTest implements EqualityTestInterface {

  @Rule
  public ErrorCollector collector = new ErrorCollector();


  @Test
  public void testSerializableCloneMethod() {
    AbstractOuter serializableObject =
        new SerializableCloneMethodOuter(new SerializableState(1), 1);
    AbstractOuter clone = null;
    try {
      clone = ((SerializableCloneMethodOuter) serializableObject).cloneIt();
    } catch (Exception e) {
      collector.addError(e);
    }
    areEqualByEqualsMethodCall(true, serializableObject, clone, collector);
    areEqualByEqualityOperator(false, serializableObject, clone, collector);
    /**
     * Change state and let's see.
     */
    StateInterface stateObject = serializableObject.getMutableObject();
    stateObject.setStateVariable(2);
    areEqualByEqualsMethodCall(true, serializableObject, clone, collector);
    areEqualByEqualityOperator(false, serializableObject, clone, collector);
  }

  @Test(expected = NotSerializableException.class)
  public void testSerializableCloneMethodWithNonSerializableState() throws Exception {
    AbstractOuter withNonSerializableObject =
        new SerializableCloneMethodOuter(new NonSerializableState(1), 1);
    AbstractOuter clone = ((SerializableCloneMethodOuter) withNonSerializableObject).cloneIt();
  }

  @Test
  public void testDefaultCloneMethod() {
    AbstractOuter serializableObject =
        new DefaultCloneMethodOuter(new SerializableState(1), 1);
    AbstractOuter clone = null;
    try {
      clone = ((DefaultCloneMethodOuter) serializableObject).cloneIt();
    } catch (Exception e) {
      collector.addError(e);
    }
    areEqualByEqualsMethodCall(true, serializableObject, clone, collector);
    areEqualByEqualityOperator(false, serializableObject, clone, collector);
    /**
     * Change state and let's see.
     */
    StateInterface stateObject = serializableObject.getMutableObject();
    stateObject.setStateVariable(2);
    areEqualByEqualsMethodCall(true, serializableObject, clone, collector);
    areEqualByEqualityOperator(false, serializableObject, clone, collector);
  }

  @Test
  public void testUniversalCloneMethod() {
    AbstractOuter serializableObject =
        new UniversalCloneMethodOuter(new SerializableState(1), 1);
    AbstractOuter clone = null;
    try {
      clone = ((UniversalCloneMethodOuter) serializableObject).cloneIt();
    } catch (Exception e) {
      collector.addError(e);
    }
    areEqualByEqualsMethodCall(true, serializableObject, clone, collector);
    areEqualByEqualityOperator(false, serializableObject, clone, collector);
    /**
     * Change state and let's see.
     */
    StateInterface stateObject = serializableObject.getMutableObject();
    stateObject.setStateVariable(2);
    areEqualByEqualsMethodCall(false, serializableObject, clone, collector);
    areEqualByEqualityOperator(false, serializableObject, clone, collector);
  }
}
