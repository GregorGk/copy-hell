import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.rules.ErrorCollector;
import outer.AbstractOuter;

public interface EqualityTestInterface {

  /**
   * Using the {@code ==} operator.
   */
  default void areEqualByEqualityOperator(
      boolean positive,
      AbstractOuter outer,
      AbstractOuter outerClone,
      ErrorCollector collector) {
    boolean toBeTested = outer == outerClone;
    String messageForTrue = String.format("%s == %s.", outer, outerClone);
    String messageForFalse = String.format("It is not true that %s == %s.", outer, outerClone);
    try {
      assertIt(positive, toBeTested, messageForTrue, messageForFalse, collector);
    } catch (Throwable error) {
      collector.addError(error);
    }
  }

  /**
   * Using the {@code equals} method call.
   */
  default void areEqualByEqualsMethodCall(
      boolean positive,
      AbstractOuter outer,
      AbstractOuter outerClone,
      ErrorCollector collector) {
    boolean toBeTested = outer.equals(outerClone);
    String messageForTrue = String.format("%s.equals(%s).", outer, outerClone);
    String messageForFalse = String.format("It is not true that %s.equals(%s).", outer, outerClone);
    assertIt(positive, toBeTested, messageForTrue, messageForFalse, collector);
  }

  /**
   * Positive and negative test cases.
   */
  private void assertIt(
      boolean positive,
      boolean toBeTested,
      String messageForTrue,
      String messageForFalse,
      ErrorCollector collector) {
    try {
      if (positive) {
        assertTrue(assertMessageOf(messageForFalse), toBeTested);
        System.out.println(messageForTrue);
      } else {
        assertFalse(assertMessageOf(messageForTrue), toBeTested);
        System.out.println(messageForFalse);
      }
    } catch (Throwable error) {
      collector.addError(error);
    }
  }

  /**
   * Assertion message wrapper.
   */
  private String assertMessageOf(String message) {
    return
        new StringBuilder("\n")
        .append(message)
        .toString();
  }
}
