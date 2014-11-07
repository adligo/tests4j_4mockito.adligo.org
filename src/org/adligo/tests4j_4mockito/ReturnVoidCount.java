package org.adligo.tests4j_4mockito;


/**
 * these are extensions to Mockito 
 * that I will try to contribute to mockito if they want it
 * which make tests4j and Mockito work together.
 * 
 * @author scott
 *
 */
public class ReturnVoidCount extends ReturnCount<Void> {
  public ReturnVoidCount() {
    super(null);
  }
}
