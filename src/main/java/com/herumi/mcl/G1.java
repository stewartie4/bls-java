package com.herumi.mcl;

public class G1 {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected G1(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(G1 obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        MclJNI.delete_G1(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public G1() {
    this(MclJNI.new_G1__SWIG_0(), true);
  }

  public G1(G1 rhs) {
    this(MclJNI.new_G1__SWIG_1(G1.getCPtr(rhs), rhs), true);
  }

  public G1(Fp x, Fp y) {
    this(MclJNI.new_G1__SWIG_2(Fp.getCPtr(x), x, Fp.getCPtr(y), y), true);
  }

  public boolean equals(G1 rhs) {
    return MclJNI.G1_equals(swigCPtr, this, G1.getCPtr(rhs), rhs);
  }

  public boolean isZero() {
    return MclJNI.G1_isZero(swigCPtr, this);
  }

  public boolean isValidOrder() {
    return MclJNI.G1_isValidOrder(swigCPtr, this);
  }

  public void set(Fp x, Fp y) {
    MclJNI.G1_set(swigCPtr, this, Fp.getCPtr(x), x, Fp.getCPtr(y), y);
  }

  public void clear() {
    MclJNI.G1_clear(swigCPtr, this);
  }

  public void setStr(String str, int base) {
    MclJNI.G1_setStr__SWIG_0(swigCPtr, this, str, base);
  }

  public void setStr(String str) {
    MclJNI.G1_setStr__SWIG_1(swigCPtr, this, str);
  }

  public String toString(int base) {
    return MclJNI.G1_toString__SWIG_0(swigCPtr, this, base);
  }

  public String toString() {
    return MclJNI.G1_toString__SWIG_1(swigCPtr, this);
  }

  public void deserialize(byte[] cbuf) {
    MclJNI.G1_deserialize(swigCPtr, this, cbuf);
  }

  public byte[] serialize() { return MclJNI.G1_serialize(swigCPtr, this); }

}
