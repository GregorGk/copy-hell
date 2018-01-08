package outer;

import state.StateInterface;

public class DefaultCloneMethodOuter extends AbstractOuter implements Cloneable {

  public DefaultCloneMethodOuter(StateInterface mutableObject, int primitive) {
    super(mutableObject, primitive);
  }

  /**
   * A call to {#code Object}'s default clone method.
   */
  @Override
  public AbstractOuter cloneIt() throws Exception {
    return (AbstractOuter) super.clone();
  }
}
