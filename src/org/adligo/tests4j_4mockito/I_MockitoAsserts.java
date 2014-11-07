package org.adligo.tests4j_4mockito;

import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.mockito.MockSettings;
import org.mockito.MockingDetails;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

/**
 * this adds together the I_Asserts interface from tests4j
 * and the Mockito interface from org.mockito.Mockito.
 * 
 * note mock(Class<T> classToMock, ReturnValues returnValues)
 * is depricated in the Mockito api so didn't add it here.
 * 
 * @author scott
 *
 */
public interface I_MockitoAsserts extends I_MockitoMatchers, I_Asserts {
  
  public <T> T mock(Class<T> classToMock);
  @SuppressWarnings("rawtypes")
  public <T> T mock(Class<T> classToMock, Answer answer);
  public <T> T mock(Class<T> classToMock, MockSettings settings);
  public <T> T mock(Class<T> classToMock, String name);
  @SuppressWarnings("unchecked")
  public <T> void reset(T ... mocks);
  public MockingDetails mockingDetails(Object toInspect);
  public <T> T spy(T object);
  public <T> OngoingStubbing<T> when(T methodCall);
}
