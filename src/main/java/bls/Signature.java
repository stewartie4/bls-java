package bls;

import com.herumi.mcl.G1;

public class Signature extends Key<G1>{

    Signature(G1 g1) {
        super(g1);
    }
}
