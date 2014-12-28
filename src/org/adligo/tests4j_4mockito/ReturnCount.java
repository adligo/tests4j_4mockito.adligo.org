package org.adligo.tests4j_4mockito;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;


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
 * List<Integer> hashCodeReturnValues = new ArrayList<Integer>();
 * hashCodeReturnValues.add(new Integer(56));
 * hashCodeReturnValues.add(new Integer(65));
 * ReturnCount<Integer> count = new ReturnCount(hashCodeReturnValues);
 * when(mockString.hashCode()).thenAnswer(count);
 * 
 * assertEquals(1, count.count());
 * 
 * For void return types do this;
 * ReturnCount<Void> rvc = new ReturnCount<Void>();
 * PrintStream out = System.out;
 * doAnswer(rvc).when(out).println(any(String.class));
 * 
 * assertEquals(1, count.count());
 * assertEquals("hey", count.getArguments(0)[0]);
 * 
 * @author scott
 *
 */
public class ReturnCount<T> implements Answer<T> {
  private int count_;
  private final List<Object[]> callArgs_ = new ArrayList<Object[]>();
  private final Stack<T> types_;
  private T repeatingType_;
  
  public ReturnCount() {
    types_ = null;
  }
  
  public ReturnCount(T type) {
    types_ = new Stack<T>();
    types_.push(type);
  }
  
  public ReturnCount(T type, boolean repeat) {
    if (! repeat) {
      types_ = new Stack<T>();
      types_.push(type);
    } else {
      types_ = null;
      repeatingType_ = type;
    }
  }
  
  public ReturnCount(Collection<T> types) {
    types_ = new Stack<T>();
    for (T t: types) {
      types_.push(t);
    }
  }
  
  @Override
  public T answer(InvocationOnMock invocation) throws Throwable {
    count_++;
    callArgs_.add(invocation.getArguments());
    if (types_ == null) {
      if (repeatingType_ != null) {
        return repeatingType_;
      }
      return null;
    }
    
    T toRet = types_.firstElement();
    types_.remove(0);
    return toRet;
  }
  
  public int count() {
    return count_;
  }
  
  public Object [] getArguments(int call) {
    return callArgs_.get(call);
  }
}
