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
 * assertEquals("hey", mm.getArg(0));<br/>
 * <br/>
 * For methods that return values (i.e. String) do this;<br/>
 * MockMethod&lt;String&gt; getMock = new MockMethod&lt;String&gt;(); <br/>
 * List&lt;String&gt; mockList = mock(List.class); <br/>
 * getMock.push("abc");<br/>
 * getMock.push("dev");<br/>
 * when(mockList.get(anyInt())).thenAnswer(getMock); <br/>
 * mockList.get(123); <br/>
 * mockList.get(456); <br/>
 * assertEquals(2, getMock.count());<br/>
 * assertEquals(123, getMock.getArg(0));<br/>
 * assertEquals(456, getMock.getArg(1));<br/>
 * <br/>
 * For a map of return values do this;<br/>
 * ArgMap&lt;String&gt; map = new ArgMap&lt;String&gt;();<br/>
 * Note: putVal is backward on purpose see it's javadoc.<br/>
 * map.putVal("hey",111);<br/>
 * map.putVal("hey2",212);<br/>
 * MockMethod&lt;String&gt; getMockTwo = new MockMethod&lt;String&gt;(map); <br/>
 * when(mockList.get(anyInt()).thenAnswer(getMockTwo); <br/>
 * assertEquals("hey", mockList.get(111)); <br/>
 * assertEquals("hey2", mockList.get(212)); <br/>
 * 
 * @author scott
 *
 */
public class MockMethod<T> implements Answer<T> {
  public static final Object[] EMPTY = new Object[]{};
  
  private int count_;
  private ArgMap<T> argsToResults_;
  private final List<Object[]> callArgs_ = new ArrayList<Object[]>();
  
  private Stack<T> types_;
  private T defaultType_;
  
  public MockMethod() {}
  
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
    argsToResults_ = responses;
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
  
  public void push(T type) {
    if (types_ == null) {
      types_ = new Stack<T>();
    }
    types_.push(type);
  }
  
  @Override
  public T answer(InvocationOnMock invocation) throws Throwable {
    count_++;
    Object [] args = invocation.getArguments();
    callArgs_.add(args);
    
    T toRet = null;
    if (types_ != null) {
      if (types_.size() >= 1) {
        toRet = types_.firstElement();
        //fifo
        types_.remove(0);
      }
    }
    if (toRet == null) {
      ObjParams params = new ObjParams(args);
      if (argsToResults_ != null) {
        toRet = argsToResults_.get(params);
        if (toRet == null) {
          return defaultType_;
        } else {
          return toRet;
        }
      }
    }
    if (toRet == null) {
      if (defaultType_ != null) {
        return defaultType_;
      }
    }
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
