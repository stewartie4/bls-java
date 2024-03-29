package bls;

public interface Bls {
    SecretKey getSecretKey(byte[] seed);
    PublicKey getPublicKey(SecretKey secretKey);
    Signature sign(byte[] hash, SecretKey secretKey);
}
