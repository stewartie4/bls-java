package bls;

import bls.util.LibraryLoader;
import bls.util.LibraryLoader.OperatingSystem;
import com.herumi.mcl.Fp;
import com.herumi.mcl.Fr;
import com.herumi.mcl.G2;
import com.herumi.mcl.Mcl;
import java.util.concurrent.atomic.AtomicBoolean;

public enum BlsBn254 implements Bls {
    INSTANCE;

    private final AtomicBoolean nativeLibsLoaded = new AtomicBoolean(false);

    public static void init(){
        if (!INSTANCE.nativeLibsLoaded.getAndSet(true)) {
            try {
                new LibraryLoader().loadNativeLibrary("mcljava");
                Mcl.SystemInit(Mcl.BN254);
            } catch(Exception e){
                INSTANCE.nativeLibsLoaded.set(false);
                throw new IllegalStateException("Library could not be loaded automatically, try loading manually by calling BlsBn254.INSTANCE.init(osType) before generating keys", e);
            }
        }
    }

    public static void init(OperatingSystem operatingSystem){
        if(!INSTANCE.nativeLibsLoaded.get()) {
            new LibraryLoader().loadNativeLibrary("mcljava", operatingSystem);
            Mcl.SystemInit(Mcl.BN254);
            INSTANCE.nativeLibsLoaded.set(true);
        }
    }

    @Override
    public SecretKey getSecretKey(byte[] seed) {
        init();
        if(seed == null || seed.length == 0){
            throw new IllegalArgumentException("Seed must not be null or empty");
        }
        Fr secretKey = new Fr();
        secretKey.setLittleEndian(seed);

        return new SecretKey(secretKey);
    }

    @Override
    public PublicKey getPublicKey(SecretKey secretKey) {
        init();
        if(secretKey == null){
            throw new IllegalArgumentException("SecretKey must not be null");
        }
        G2 pub = new G2();
        Mcl.mul(pub, getBn254PublicKeyBase(), toFr(secretKey));

        return new PublicKey(pub);
    }

    private Fr toFr(SecretKey secretKey) {
        return secretKey.getUnderlyingImpl();
    }

    private static G2 getBn254PublicKeyBase() {
        Fp ax = new Fp("11ccb44e77ac2c5dc32a6009594dbe331ec85a61290d6bbac8cc7ebb2dceb128", 16);
        Fp ay = new Fp("f204a14bbdac4a05be9a25176de827f2e60085668becdd4fc5fa914c9ee0d9a", 16);
        Fp bx = new Fp("7c13d8487903ee3c1c5ea327a3a52b6cc74796b1760d5ba20ed802624ed19c8", 16);
        Fp by = new Fp("8f9642bbaacb73d8c89492528f58932f2de9ac3e80c7b0e41f1a84f1c40182", 16);

        return new G2(ax, ay, bx, by);
    }

}
