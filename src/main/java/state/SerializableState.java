package state;

import java.io.Serializable;

public class SerializableState implements StateInterface, Serializable {
  private int stateVariable;

  public SerializableState(int serializable) {
    this.stateVariable = serializable;
  }

  @Override
  public String toString() {
    return this.deepToString();
  }

  /**
   * {@code toString} wrapper.
   * @return
   */
  public String deepToString() {
    return "SerializableState{"
        + "stateVariable=" + stateVariable
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SerializableState)) {
      return false;
    }
    SerializableState that = (SerializableState) o;
    return getStateVariable() == that.getStateVariable();
  }

  @Override
  public int hashCode() {
    return getStateVariable();
  }

  @Override
  public int getStateVariable() {
    return stateVariable;
  }

  @Override
  public void setStateVariable(int stateVariable) {
    this.stateVariable = stateVariable;
  }
}
