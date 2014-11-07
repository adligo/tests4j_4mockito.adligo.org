package org.adligo.tests4j_4mockito;

import org.adligo.tests4j.system.shared.trials.SourceFileTrial;
import org.hamcrest.Matcher;
import org.mockito.MockSettings;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MockitoUseCaseTrial extends SourceFileTrial implements I_MockitoAsserts {

  @Override
  public boolean anyBoolean() {
    return Mockito.anyBoolean();
  }

  @Override
  public byte anyByte() {
    return Mockito.anyByte();
  }

  @Override
  public char anyChar() {
    return Mockito.anyChar();
  }

  @Override
  public int anyInt() {
    return Mockito.anyInt();
  }

  @Override
  public long anyLong() {
    return Mockito.anyLong();
  }

  @Override
  public float anyFloat() {
    return Mockito.anyFloat();
  }

  @Override
  public double anyDouble() {
    return Mockito.anyDouble();
  }

  @Override
  public short anyShort() {
    return Mockito.anyShort();
  }

  @Override
  public <T> T anyObject() {
    return Mockito.anyObject();
  }

  @Override
  public <T> T anyVararg() {
    return Mockito.anyVararg();
  }

  @Override
  public <T> T any(Class<T> clazz) {
    return Mockito.any(clazz);
  }

  @Override
  public <T> T any() {
    return Mockito.any();
  }

  @Override
  public String anyString() {
    return Mockito.anyString();
  }

  @SuppressWarnings("rawtypes")
  @Override
  public List anyList() {
    return Mockito.anyList();
  }

  @Override
  public <T> List<T> anyListOf(Class<T> clazz) {
    return Mockito.anyListOf(clazz);
  }

  @SuppressWarnings("rawtypes")
  @Override
  public Set anySet() {
    return Mockito.anySet();
  }

  @Override
  public <T> Set<T> anySetOf(Class<T> clazz) {
    return Mockito.anySetOf(clazz);
  }

  @SuppressWarnings("rawtypes")
  @Override
  public Map anyMap() {
    return Mockito.anyMap();
  }

  @Override
  public <K, V> Map<K, V> anyMapOf(Class<K> keyClazz, Class<V> valueClazz) {
    return Mockito.anyMapOf(keyClazz, valueClazz);
  }

  @SuppressWarnings("rawtypes")
  @Override
  public Collection anyCollection() {
    return Mockito.anyCollection();
  }

  @Override
  public <T> Collection<T> anyCollectionOf(Class<T> clazz) {
    return Mockito.anyCollectionOf(clazz);
  }

  @Override
  public <T> T isA(Class<T> clazz) {
    return Mockito.isA(clazz);
  }

  @Override
  public boolean eq(boolean value) {
    return Mockito.eq(value);
  }

  @Override
  public byte eq(byte value) {
    return Mockito.eq(value);
  }

  @Override
  public char eq(char value) {
    return Mockito.eq(value);
  }

  @Override
  public double eq(double value) {
    return Mockito.eq(value);
  }

  @Override
  public float eq(float value) {
    return Mockito.eq(value);
  }

  @Override
  public int eq(int value) {
    return Mockito.eq(value);
  }

  @Override
  public long eq(long value) {
    return Mockito.eq(value);
  }

  @Override
  public short eq(short value) {
    return Mockito.eq(value);
  }

  @Override
  public <T> T eq(T value) {
    return Mockito.eq(value);
  }

  @Override
  public <T> T refEq(T value, String... excludeFields) {
    return Mockito.refEq(value, excludeFields);
  }

  @Override
  public <T> T same(T value) {
    return Mockito.same(value);
  }

  @Override
  public Object isNull() {
    return Mockito.isNull();
  }

  @Override
  public <T> T isNull(Class<T> clazz) {
    return Mockito.isNotNull(clazz);
  }

  @Override
  public Object notNull() {
    return Mockito.notNull();
  }

  @Override
  public <T> T notNull(Class<T> clazz) {
    return Mockito.notNull(clazz);
  }

  @Override
  public Object isNotNull() {
    return Mockito.isNotNull();
  }

  @Override
  public <T> T isNotNull(Class<T> clazz) {
    return Mockito.isNotNull(clazz);
  }

  @Override
  public String contains(String substring) {
    return Mockito.contains(substring);
  }

  @Override
  public String matches(String regex) {
    return Mockito.matches(regex);
  }

  @Override
  public String endsWith(String suffix) {
    return Mockito.endsWith(suffix);
  }

  @Override
  public String startsWith(String prefix) {
    return Mockito.startsWith(prefix);
  }

  @Override
  public <T> T argThat(Matcher<T> matcher) {
    return Mockito.argThat(matcher);
  }

  @Override
  public char charThat(Matcher<Character> matcher) {
    return Mockito.charThat(matcher);
  }

  @Override
  public boolean booleanThat(Matcher<Boolean> matcher) {
    return Mockito.booleanThat(matcher);
  }

  @Override
  public byte byteThat(Matcher<Byte> matcher) {
    return Mockito.byteThat(matcher);
  }

  @Override
  public short shortThat(Matcher<Short> matcher) {
    return Mockito.shortThat(matcher);
  }

  @Override
  public int intThat(Matcher<Integer> matcher) {
    return Mockito.intThat(matcher);
  }

  @Override
  public long longThat(Matcher<Long> matcher) {
    return Mockito.longThat(matcher);
  }

  @Override
  public float floatThat(Matcher<Float> matcher) {
    return Mockito.floatThat(matcher);
  }

  @Override
  public double doubleThat(Matcher<Double> matcher) {
    return Mockito.doubleThat(matcher);
  }

  @Override
  public <T> T mock(Class<T> classToMock) {
    return Mockito.mock(classToMock);
  }

  @SuppressWarnings("rawtypes")
  @Override
  public <T> T mock(Class<T> classToMock, Answer defaultAnswer) {
    return Mockito.mock(classToMock, defaultAnswer);
  }

  @Override
  public <T> T mock(Class<T> classToMock, MockSettings settings) {
    return Mockito.mock(classToMock,settings);
  }

  @Override
  public <T> T mock(Class<T> classToMock, String name) {
    return Mockito.mock(classToMock, name);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> void reset(T... mocks) {
    Mockito.reset(mocks);
  }

  @Override
  public MockingDetails mockingDetails(Object toInspect) {
    return Mockito.mockingDetails(toInspect);
  }

  @Override
  public <T> T spy(T object) {
    return Mockito.spy(object);
  }

  @Override
  public <T> OngoingStubbing<T> when(T methodCall) {
    return Mockito.when(methodCall);
  }

}
