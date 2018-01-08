package state;

public class NonSerializableState implements StateInterface {
  private int stateVariable;

  public NonSerializableState(int serializable) {
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
    return "NonSerializableState{"
        + "stateVariable=" + stateVariable
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NonSerializableState)) {
      return false;
    }
    NonSerializableState that = (NonSerializableState) o;
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
