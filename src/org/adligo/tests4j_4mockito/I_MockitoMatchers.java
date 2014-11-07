package org.adligo.tests4j_4mockito;

import org.hamcrest.Matcher;
import org.mockito.ArgumentMatcher;
import org.mockito.Matchers;
import org.mockito.internal.matchers.Any;
import org.mockito.internal.matchers.AnyVararg;
import org.mockito.internal.matchers.Contains;
import org.mockito.internal.matchers.EndsWith;
import org.mockito.internal.matchers.Equals;
import org.mockito.internal.matchers.InstanceOf;
import org.mockito.internal.matchers.Matches;
import org.mockito.internal.matchers.NotNull;
import org.mockito.internal.matchers.Null;
import org.mockito.internal.matchers.Same;
import org.mockito.internal.matchers.StartsWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.internal.progress.HandyReturnValues;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * a interface which is basically the same as org.mockito.matchers.Matchers
 * with the sole purpose of fixing the eclipse ctrl-shift-o 
 * import fix which screws up import static org.mockito.Mockito.*;
 * 
 * @author scott
 *
 */
public interface I_MockitoMatchers {

  public boolean anyBoolean();
  public byte anyByte();
  public char anyChar();
  public int anyInt();
  public long anyLong();
  public float anyFloat();
  public double anyDouble();
  public short anyShort();
  public <T> T anyObject();
  public <T> T anyVararg();
  public <T> T any(Class<T> clazz);
  public <T> T any();
  public String anyString();
  public List anyList();
  public <T> List<T> anyListOf(Class<T> clazz);
  public Set anySet();
  public <T> Set<T> anySetOf(Class<T> clazz);
  public Map anyMap();
  public <K, V>  Map<K, V> anyMapOf(Class<K> keyClazz, Class<V> valueClazz);
  public Collection anyCollection();
  public <T> Collection<T> anyCollectionOf(Class<T> clazz);
  public <T> T isA(Class<T> clazz);
  public boolean eq(boolean value);
  public byte eq(byte value);
  public char eq(char value);
  public double eq(double value);
  public float eq(float value);
  public int eq(int value);
  public long eq(long value);
  public short eq(short value);
  public <T> T eq(T value);
  public <T> T refEq(T value, String... excludeFields);
  public <T> T same(T value);
  public Object isNull();
  public <T> T isNull(Class<T> clazz);
  public Object notNull();
  public <T> T notNull(Class<T> clazz);
  public Object isNotNull();
  public <T> T isNotNull(Class<T> clazz);
  public String contains(String substring);
  public String matches(String regex);
  public String endsWith(String suffix);
  public String startsWith(String prefix);
  public <T> T argThat(Matcher<T> matcher);
  public char charThat(Matcher<Character> matcher);
  public boolean booleanThat(Matcher<Boolean> matcher);
  public byte byteThat(Matcher<Byte> matcher);
  public short shortThat(Matcher<Short> matcher);
  public int intThat(Matcher<Integer> matcher);
  public long longThat(Matcher<Long> matcher);
  public float floatThat(Matcher<Float> matcher);
  public double doubleThat(Matcher<Double> matcher);
}
