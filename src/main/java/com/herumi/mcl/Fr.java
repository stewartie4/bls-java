package com.herumi.mcl;

public class Fr implements ByteProvider {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Fr(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Fr obj) {
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
        MclJNI.delete_Fr(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public Fr() {
    this(MclJNI.new_Fr__SWIG_0(), true);
  }

  public Fr(Fr rhs) {
    this(MclJNI.new_Fr__SWIG_1(Fr.getCPtr(rhs), rhs), true);
  }

  public Fr(int x) {
    this(MclJNI.new_Fr__SWIG_2(x), true);
  }

  public Fr(String str, int base) {
    this(MclJNI.new_Fr__SWIG_3(str, base), true);
  }

  public Fr(String str) {
    this(MclJNI.new_Fr__SWIG_4(str), true);
  }

  public boolean equals(Fr rhs) {
    return MclJNI.Fr_equals(swigCPtr, this, Fr.getCPtr(rhs), rhs);
  }

  public boolean isZero() {
    return MclJNI.Fr_isZero(swigCPtr, this);
  }

  public void setStr(String str, int base) {
    MclJNI.Fr_setStr__SWIG_0(swigCPtr, this, str, base);
  }

  public void setStr(String str) {
    MclJNI.Fr_setStr__SWIG_1(swigCPtr, this, str);
  }

  public void setInt(int x) {
    MclJNI.Fr_setInt(swigCPtr, this, x);
  }

  public void clear() {
    MclJNI.Fr_clear(swigCPtr, this);
  }

  public void setByCSPRNG() {
    MclJNI.Fr_setByCSPRNG(swigCPtr, this);
  }

  public String toString(int base) {
    return MclJNI.Fr_toString__SWIG_0(swigCPtr, this, base);
  }

  public String toString() {
    return MclJNI.Fr_toString__SWIG_1(swigCPtr, this);
  }

  public void deserialize(byte[] cbuf) {
    MclJNI.Fr_deserialize(swigCPtr, this, cbuf);
  }

  public void setLittleEndianMod(byte[] cbuf) {
    MclJNI.Fr_setLittleEndianMod(swigCPtr, this, cbuf);
  }

  public void setLittleEndian(byte[] cbuf) {
    MclJNI.Fr_setLittleEndian(swigCPtr, this, cbuf);
  }

  public void setHashOf(byte[] cbuf) {
    MclJNI.Fr_setHashOf(swigCPtr, this, cbuf);
  }

  public byte[] serialize() { return MclJNI.Fr_serialize(swigCPtr, this); }

}
