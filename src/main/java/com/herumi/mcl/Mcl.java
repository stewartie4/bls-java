package com.herumi.mcl;

public class Mcl {
  public final static int BN254 = 0;
  public final static int BLS12_381 = 5;

  public static void SystemInit(int curveType) {
    MclJNI.SystemInit(curveType);
  }

  public static void neg(Fr y, Fr x) {
    MclJNI.neg__SWIG_0(Fr.getCPtr(y), y, Fr.getCPtr(x), x);
  }

  public static void add(Fr z, Fr x, Fr y) {
    MclJNI.add__SWIG_0(Fr.getCPtr(z), z, Fr.getCPtr(x), x, Fr.getCPtr(y), y);
  }

  public static void sub(Fr z, Fr x, Fr y) {
    MclJNI.sub__SWIG_0(Fr.getCPtr(z), z, Fr.getCPtr(x), x, Fr.getCPtr(y), y);
  }

  public static void mul(Fr z, Fr x, Fr y) {
    MclJNI.mul__SWIG_0(Fr.getCPtr(z), z, Fr.getCPtr(x), x, Fr.getCPtr(y), y);
  }

  public static void mul(G1 z, G1 x, Fr y) {
    MclJNI.mul__SWIG_1(G1.getCPtr(z), z, G1.getCPtr(x), x, Fr.getCPtr(y), y);
  }

  public static void mul(G2 z, G2 x, Fr y) {
    MclJNI.mul__SWIG_2(G2.getCPtr(z), z, G2.getCPtr(x), x, Fr.getCPtr(y), y);
  }

  public static void div(Fr z, Fr x, Fr y) {
    MclJNI.div__SWIG_0(Fr.getCPtr(z), z, Fr.getCPtr(x), x, Fr.getCPtr(y), y);
  }

  public static void pow(GT z, GT x, Fr y) {
    MclJNI.pow(GT.getCPtr(z), z, GT.getCPtr(x), x, Fr.getCPtr(y), y);
  }

  public static void neg(Fp y, Fp x) {
    MclJNI.neg__SWIG_1(Fp.getCPtr(y), y, Fp.getCPtr(x), x);
  }

  public static void add(Fp z, Fp x, Fp y) {
    MclJNI.add__SWIG_1(Fp.getCPtr(z), z, Fp.getCPtr(x), x, Fp.getCPtr(y), y);
  }

  public static void sub(Fp z, Fp x, Fp y) {
    MclJNI.sub__SWIG_1(Fp.getCPtr(z), z, Fp.getCPtr(x), x, Fp.getCPtr(y), y);
  }

  public static void mul(Fp z, Fp x, Fp y) {
    MclJNI.mul__SWIG_3(Fp.getCPtr(z), z, Fp.getCPtr(x), x, Fp.getCPtr(y), y);
  }

  public static void div(Fp z, Fp x, Fp y) {
    MclJNI.div__SWIG_1(Fp.getCPtr(z), z, Fp.getCPtr(x), x, Fp.getCPtr(y), y);
  }

  public static void neg(G1 y, G1 x) {
    MclJNI.neg__SWIG_2(G1.getCPtr(y), y, G1.getCPtr(x), x);
  }

  public static void dbl(G1 y, G1 x) {
    MclJNI.dbl__SWIG_0(G1.getCPtr(y), y, G1.getCPtr(x), x);
  }

  public static void add(G1 z, G1 x, G1 y) {
    MclJNI.add__SWIG_2(G1.getCPtr(z), z, G1.getCPtr(x), x, G1.getCPtr(y), y);
  }

  public static void sub(G1 z, G1 x, G1 y) {
    MclJNI.sub__SWIG_2(G1.getCPtr(z), z, G1.getCPtr(x), x, G1.getCPtr(y), y);
  }

  public static void pairing(GT e, G1 P, G2 Q) {
    MclJNI.pairing(GT.getCPtr(e), e, G1.getCPtr(P), P, G2.getCPtr(Q), Q);
  }

  public static void hashAndMapToG1(G1 P, byte[] cbuf) {
    MclJNI.hashAndMapToG1(G1.getCPtr(P), P, cbuf);
  }

  public static void neg(G2 y, G2 x) {
    MclJNI.neg__SWIG_3(G2.getCPtr(y), y, G2.getCPtr(x), x);
  }

  public static void dbl(G2 y, G2 x) {
    MclJNI.dbl__SWIG_1(G2.getCPtr(y), y, G2.getCPtr(x), x);
  }

  public static void add(G2 z, G2 x, G2 y) {
    MclJNI.add__SWIG_3(G2.getCPtr(z), z, G2.getCPtr(x), x, G2.getCPtr(y), y);
  }

  public static void sub(G2 z, G2 x, G2 y) {
    MclJNI.sub__SWIG_3(G2.getCPtr(z), z, G2.getCPtr(x), x, G2.getCPtr(y), y);
  }

  public static void hashAndMapToG2(G2 P, byte[] cbuf) {
    MclJNI.hashAndMapToG2(G2.getCPtr(P), P, cbuf);
  }

  public static void mul(GT z, GT x, GT y) {
    MclJNI.mul__SWIG_4(GT.getCPtr(z), z, GT.getCPtr(x), x, GT.getCPtr(y), y);
  }

  public static void inv(GT y, GT x) {
    MclJNI.inv(GT.getCPtr(y), y, GT.getCPtr(x), x);
  }

}
