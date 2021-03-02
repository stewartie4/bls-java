package bls;

import com.herumi.mcl.ByteProvider;

public abstract class Key<UnderlyingImpl extends ByteProvider> {

    private final UnderlyingImpl impl;

    Key(UnderlyingImpl impl){
        this.impl = impl;
    }

    public byte[] getBytes(){
        return impl.serialize();
    }

    public String getHexString(){
        return toHexString(getBytes());
    }

    UnderlyingImpl getUnderlyingImpl(){
        return impl;
    }

    private String toHexString(byte[] bytes){
        char[] HEX_MASK = "0123456789abcdef".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_MASK[v >>> 4];
            hexChars[j * 2 + 1] = HEX_MASK[v & 0x0F];
        }
        return new String(hexChars);
    }
}
