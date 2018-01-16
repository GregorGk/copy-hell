package outer;

import com.rits.cloning.Cloner;
import state.StateInterface;

public class ClonerMethodOuter extends AbstractOuter {

  public ClonerMethodOuter() {
  }

  public ClonerMethodOuter(StateInterface mutableObject, int primitive) {
    super(mutableObject, primitive);
  }

  /**
   * A call to {#code Object}'s default clone method.
   */
  @Override
  public AbstractOuter cloneIt() throws Exception {
    Object toReturn = null;
    Cloner cloner = new Cloner();
    toReturn = cloner.deepClone(this);
    return (AbstractOuter) toReturn;
  }
}
