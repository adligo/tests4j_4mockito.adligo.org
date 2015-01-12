package org.adligo.tests4j_4mockito;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;


/**
 * This class is the base replacement for verify <br/>
 * which is intentionally missing from the I_MockitoAsserts <br/>
 * because it will never be counted as a assertion, which it <br/>
 * really what it is.  This also clearly divides the work between <br/>
 * tests4j and mockito; <br/>
 * tests4j assertions <br/>
 * mockito partial or full mocking only <br/>
 *  <br/>
 *  For void return types do this; <br/>
 * MockMethod&lt;Void&gt; mm = new MockMethod&lt;Void&gt;(); <br/>
 * PrintStream out = System.out; <br/>
 * doAnswer(mm).when(out).println(any(String.class)); <br/>
 * out.println("hey");
 * <br/> 
 * assertEquals(1, mm.count());<br/> 
 * assertEquals("hey", mm.getArguments(0)[0]);<br/>
 * <br/>
 * String mockString = mock(String.class); <br/>
 * List&lt;Integer&gt; hashCodeReturnValues = new ArrayList&lt;Integer&gt;(); <br/>
 * hashCodeReturnValues.add(new Integer(56)); <br/>
 * hashCodeReturnValues.add(new Integer(65)); <br/>
 * MockMethod&lt;Integer&gt; count = new MockMethod&lt;Integer&gt;(hashCodeReturnValues); <br/>
 * when(mockString.hashCode()).thenAnswer(count); <br/>
 *  <br/>
 * assertEquals(1, count.count());<br/>
 * <br/>
 * This class can be used to reduce the amount of typing 
 * for mocking when(foo.bar()).thenReturn(); <br/>
 * ArgMap&lt;Integer&gt; hashResponces = new ArgMap&lt;Integer&gt;(); <br/>
 * printResponces.put(MockMethod.EMPTY, 12);<br/>
 * printResponces.put(MockMethod.EMPTY, 13);<br/>
 * printResponces.put(MockMethod.EMPTY, 14);<br/>
 * MockMethod&lt;Integer&gt; mockHash = new MockMethod&lt;Integer&gt;();<br/>
 * when(foo.hashCode()).thenAnswer(mockHash);<br/>
 * assertEquals(12, foo.hashCode());<br/>
 * 
 * @author scott
 *
 */
public class MockMethod<T> implements Answer<T> {
  public static final Object[] EMPTY = new Object[]{};
  
  private int count_;
  private ArgMap<T> argsToResults_;
  private final List<Object[]> callArgs_ = new ArrayList<Object[]>();
  
  private final Stack<T> types_;
  private T defaultType_;
  
  public MockMethod() {
    
    types_ = null;
  }
  
  public MockMethod(@SuppressWarnings("unchecked") T ... type) {
    types_ = new Stack<T>();
    for (int i = 0; i < type.length; i++) {
      types_.push(type[i]);
    }
  }
  
  public MockMethod(T type, boolean repeat) {
    if (! repeat) {
      types_ = new Stack<T>();
      types_.push(type);
    } else {
      types_ = null;
      defaultType_ = type;
    }
  }
  
  public MockMethod(ArgMap<T> responses) {
    types_ = null;
    argsToResults_ = new ArgMap<T>();
    argsToResults_.putAll(responses);
  }
  
  public MockMethod(ArgMap<T> responses, T defaultType) {
    this(responses);
    defaultType_ = defaultType;
  }
  
  public MockMethod(Collection<T> types) {
    types_ = new Stack<T>();
    for (T t: types) {
      types_.push(t);
    }
  }
  
  @Override
  public T answer(InvocationOnMock invocation) throws Throwable {
    count_++;
    Object [] args = invocation.getArguments();
    callArgs_.add(args);
    
    ObjParams params = new ObjParams(args);
    if (argsToResults_ != null) {
      T toRet = argsToResults_.get(params);
      if (toRet == null) {
        return defaultType_;
      } else {
        return toRet;
      }
    }
    
    if (types_ == null) {
      if (defaultType_ != null) {
        return defaultType_;
      }
      return null;
    }
    
    T toRet = types_.firstElement();
    //fifo
    types_.remove(0);
    return toRet;
  }
  
  /**
   * 
   * @return
   * The number of times the method was called.
   */
  public int count() {
    return count_;
  }
  
  /**
   * @param call which recorded method call to return the arguments/parameters for.
   * @return the arguments/parameters of a recorded method call.
   */
  public Object [] getArgs(int call) {
    return callArgs_.get(call);
  }
  
  /**
   * @param call which recorded method call to return the arguments/parameters for.
   * @return the first or single argument of a recorded method call.
   */
  public Object getArg(int call) {
    return callArgs_.get(call)[0];
  }

  
}
