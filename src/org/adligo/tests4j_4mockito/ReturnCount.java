package org.adligo.tests4j_4mockito;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


/**
 * This class is the base replacement for verify
 * which is intentionally missing from the I_MockitoAsserts
 * because it will never be counted as a assertion, which it
 * really what it is.  This also clearly divides the work between
 * tests4j and mockito;
 * tests4j assertions
 * mockito partial or full mocking only
 * 
 * String mockString = mock(String.class);
 * ReturnCount<Integer> count = new ReturnCount(new Integer(56));
 * when(mockString.hashCode()).thenAnswer(count);
 * 
 * assertEquals(1, count.count());
 * 
 * @author scott
 *
 */
public class ReturnCount<T> implements Answer<T> {
  private int count_;
  private T type_;
  
  public ReturnCount(T type) {
    type_ = type;
  }
  
  @Override
  public T answer(InvocationOnMock invocation) throws Throwable {
    count_++;
    return type_;
  }
  
  public int count() {
    return count_;
  }
}
