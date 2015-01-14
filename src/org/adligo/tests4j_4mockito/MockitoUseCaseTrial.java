package org.adligo.tests4j_4mockito;

import org.adligo.tests4j.system.shared.trials.UseCaseTrial;
import org.hamcrest.Matcher;
import org.mockito.MockSettings;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MockitoUseCaseTrial extends UseCaseTrial  {

  public static boolean anyBoolean() {
    return Mockito.anyBoolean();
  }

  public static byte anyByte() {
    return Mockito.anyByte();
  }
  
  public static char anyChar() {
    return Mockito.anyChar();
  }

  public static int anyInt() {
    return Mockito.anyInt();
  }

  public static long anyLong() {
    return Mockito.anyLong();
  }

  public static float anyFloat() {
    return Mockito.anyFloat();
  }

  public static double anyDouble() {
    return Mockito.anyDouble();
  }

  public static short anyShort() {
    return Mockito.anyShort();
  }

  public static <T> T anyObject() {
    return Mockito.anyObject();
  }

  public static <T> T anyVararg() {
    return Mockito.anyVararg();
  }

  public static <T> T any(Class<T> clazz) {
    return Mockito.any(clazz);
  }

  public static <T> T any() {
    return Mockito.any();
  }

  public static String anyString() {
    return Mockito.anyString();
  }

  @SuppressWarnings("rawtypes")
  public static List anyList() {
    return Mockito.anyList();
  }

  public static <T> List<T> anyListOf(Class<T> clazz) {
    return Mockito.anyListOf(clazz);
  }

  @SuppressWarnings("rawtypes")
  public static Set anySet() {
    return Mockito.anySet();
  }

  public static <T> Set<T> anySetOf(Class<T> clazz) {
    return Mockito.anySetOf(clazz);
  }

  @SuppressWarnings("rawtypes")
  public static Map anyMap() {
    return Mockito.anyMap();
  }

  public static <K, V> Map<K, V> anyMapOf(Class<K> keyClazz, Class<V> valueClazz) {
    return Mockito.anyMapOf(keyClazz, valueClazz);
  }

  @SuppressWarnings("rawtypes")
  public static Collection anyCollection() {
    return Mockito.anyCollection();
  }

  public static <T> Collection<T> anyCollectionOf(Class<T> clazz) {
    return Mockito.anyCollectionOf(clazz);
  }

  public static <T> T isA(Class<T> clazz) {
    return Mockito.isA(clazz);
  }

  public static boolean eq(boolean value) {
    return Mockito.eq(value);
  }

  public static byte eq(byte value) {
    return Mockito.eq(value);
  }

  public static char eq(char value) {
    return Mockito.eq(value);
  }

  public static double eq(double value) {
    return Mockito.eq(value);
  }

  public static float eq(float value) {
    return Mockito.eq(value);
  }

  public static int eq(int value) {
    return Mockito.eq(value);
  }

  public static long eq(long value) {
    return Mockito.eq(value);
  }

  public static short eq(short value) {
    return Mockito.eq(value);
  }

  public static <T> T eq(T value) {
    return Mockito.eq(value);
  }

  public static <T> T refEq(T value, String... excludeFields) {
    return Mockito.refEq(value, excludeFields);
  }

  public static <T> T same(T value) {
    return Mockito.same(value);
  }

  public static Object isNull() {
    return Mockito.isNull();
  }

  public static <T> T isNull(Class<T> clazz) {
    return Mockito.isNotNull(clazz);
  }

  public static Object notNull() {
    return Mockito.notNull();
  }

  public static <T> T notNull(Class<T> clazz) {
    return Mockito.notNull(clazz);
  }

  public static Object isNotNull() {
    return Mockito.isNotNull();
  }

  public static <T> T isNotNull(Class<T> clazz) {
    return Mockito.isNotNull(clazz);
  }

  public static String contains(String substring) {
    return Mockito.contains(substring);
  }

  public static String matches(String regex) {
    return Mockito.matches(regex);
  }

  public static String endsWith(String suffix) {
    return Mockito.endsWith(suffix);
  }

  public static String startsWith(String prefix) {
    return Mockito.startsWith(prefix);
  }

  public static <T> T argThat(Matcher<T> matcher) {
    return Mockito.argThat(matcher);
  }

  public static char charThat(Matcher<Character> matcher) {
    return Mockito.charThat(matcher);
  }

  public static boolean booleanThat(Matcher<Boolean> matcher) {
    return Mockito.booleanThat(matcher);
  }

  public static byte byteThat(Matcher<Byte> matcher) {
    return Mockito.byteThat(matcher);
  }

  public static short shortThat(Matcher<Short> matcher) {
    return Mockito.shortThat(matcher);
  }

  public static int intThat(Matcher<Integer> matcher) {
    return Mockito.intThat(matcher);
  }

  public static long longThat(Matcher<Long> matcher) {
    return Mockito.longThat(matcher);
  }

  public static float floatThat(Matcher<Float> matcher) {
    return Mockito.floatThat(matcher);
  }

  public static double doubleThat(Matcher<Double> matcher) {
    return Mockito.doubleThat(matcher);
  }

  public static <T> T mock(Class<T> classToMock) {
    return Mockito.mock(classToMock);
  }

  @SuppressWarnings("rawtypes")
  public static <T> T mock(Class<T> classToMock, Answer defaultAnswer) {
    return Mockito.mock(classToMock, defaultAnswer);
  }

  public static <T> T mock(Class<T> classToMock, MockSettings settings) {
    return Mockito.mock(classToMock,settings);
  }

  public static <T> T mock(Class<T> classToMock, String name) {
    return Mockito.mock(classToMock, name);
  }

  @SuppressWarnings("unchecked")
  public static <T> void reset(T... mocks) {
    Mockito.reset(mocks);
  }

  public static MockingDetails mockingDetails(Object toInspect) {
    return Mockito.mockingDetails(toInspect);
  }

  public static <T> T spy(T object) {
    return Mockito.spy(object);
  }

  public static <T> OngoingStubbing<T> when(T methodCall) {
    return Mockito.when(methodCall);
  }

  public static <T> Stubber doAnswer(Answer<T> answer) {
    return Mockito.doAnswer(answer);
  }
}
