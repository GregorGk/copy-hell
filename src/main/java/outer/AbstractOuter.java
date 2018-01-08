package outer;

import state.StateInterface;

public abstract class AbstractOuter {

  public AbstractOuter() {
  }

  /**
   * A state object that can be either serializable or non-serializable.
   */
  private StateInterface mutableObject;

  /**
   * A primitive to demonstrate copying of primitives.
   */
  private int primitive;

  public AbstractOuter(StateInterface mutableObject, int primitive) {
    this.mutableObject = mutableObject;
    this.primitive = primitive;
  }

  ;

  /**
   * Casting for exception handling purposes. {@code Object}'s clone could only throw a {@code
   * CloneNotSupportedException}. For some reasons it was necessery to throw another type of
   * exception like e.g. {@code NotSerializableException}. This method should not be called in
   * test.
   */
  protected AbstractOuter cloneIt() throws Exception {
    return (AbstractOuter) super.clone();
  }

  ;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractOuter)) {
      return false;
    }
    AbstractOuter outer = (AbstractOuter) o;
    if (getPrimitive() != outer.getPrimitive()) {
      return false;
    }
    return getMutableObject() != null ? getMutableObject().equals(outer.getMutableObject())
        : outer.getMutableObject() == null;
  }

  @Override
  public int hashCode() {
    int result = getMutableObject() != null ? getMutableObject().hashCode() : 0;
    result = 31 * result + getPrimitive();
    return result;
  }

  @Override
  public String toString() {
    return "AbstractOuter{"
        + "mutableObject=" + mutableObject
        + ", primitive=" + primitive + '}';
  }

  public StateInterface getMutableObject() {
    return mutableObject;
  }

  public void setMutableObject(StateInterface mutableObject) {
    this.mutableObject = mutableObject;
  }

  public int getPrimitive() {
    return primitive;
  }

  public void setPrimitive(int primitive) {
    this.primitive = primitive;
  }
}
