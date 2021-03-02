package bls;

import com.herumi.mcl.Fr;

public class SecretKey extends Key<Fr> {

    SecretKey(Fr fr) {
       super(fr);
    }

}
