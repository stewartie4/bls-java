package bls;

import com.herumi.mcl.G2;

public class PublicKey extends Key<G2> {

    PublicKey(G2 g2) {
        super(g2);
    }
}
