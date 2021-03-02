package bls;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BlsBn254Test {
    private final Bls classUnderTest = BlsBn254.INSTANCE;
    private byte[] exampleSeed;
    private byte[] expectedSecretKeyBytes;
    private byte[] expectedPublicKeyBytes;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup(){
        exampleSeed = new byte[] {
            (byte)131, (byte) 167, (byte)174, (byte)111, (byte)221,
            (byte)248, (byte)64, (byte)164, (byte)182, (byte)61,
            (byte)112, (byte)183, (byte)218, (byte)4, (byte)252,
            (byte)91, (byte)64, (byte)234, (byte)66, (byte)176,
            (byte)81, (byte)87, (byte)212, (byte)71, (byte)217,
            (byte)34, (byte)98, (byte)0, (byte)35, (byte)52,
            (byte)46, (byte)2, (byte)44, (byte)186, (byte)40,
            (byte)203, (byte)68, (byte)161, (byte)145, (byte)74,
            (byte)12, (byte)33, (byte)237, (byte)156, (byte)70,
            (byte)249, (byte)8, (byte)199, (byte)46, (byte)60,
            (byte)177, (byte)186, (byte)94, (byte)139, (byte)130,
            (byte)175, (byte)179, (byte)201, (byte)42, (byte)163,
            (byte)50, (byte)78, (byte)28, (byte)85
        };

        expectedSecretKeyBytes = new byte[] {
            -125, -89, -82, 111,
            -35, -8, 64, -92,
            -74, 61, 112, -73,
            -38, 4, -4, 91,
            64, -22, 66, -80,
            81, 87, -44, 71,
            -39, 34, 98, 0,
            35, 52, 46, 2
        };
        expectedPublicKeyBytes = new byte[]{
            54, -21, 14, 96, -41,
            76, 11, 43, 0,
            105, 126, 79, -68,
            18, 35, -19, 41,
            -38, -11, -36, 33,
            89, 82, -6, 78,
            -33, 79, 63, 64,
            14, 44, 2, 18,
            24, 114, -25, -72,
            -10, 92, -6, 72,
            -64, 7, 126, 64,
            -5, -123, -89, -9,
            124, 107, 122, 56,
            88, -86, 23, -10,
            -46, -65, -23, -53,
            -23, 127, -120
        };
    }

    @Test
    public void shouldCorrectlyCreateBn254SecretKeyForGivenSeed(){
        SecretKey secretKey = classUnderTest.getSecretKey(exampleSeed);

        assertEquals("83a7ae6fddf840a4b63d70b7da04fc5b40ea42b05157d447d922620023342e02", secretKey.getHexString());
        assertArrayEquals(expectedSecretKeyBytes, secretKey.getBytes());
    }

    @Test
    public void shouldCorrectlyCreateBn254SPublicKeyFromPrivateKey(){
        SecretKey secretKey = classUnderTest.getSecretKey(exampleSeed);
        PublicKey publicKey = classUnderTest.getPublicKey(secretKey);

        assertEquals("36eb0e60d74c0b2b00697e4fbc1223ed29daf5dc215952fa4edf4f3f400e2c02121872e7b8f65cfa48c0077e40fb85a7f77c6b7a3858aa17f6d2bfe9cbe97f88", publicKey.getHexString());
        assertArrayEquals(expectedPublicKeyBytes, publicKey.getBytes());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSeedNull(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Seed must not be null or empty");

        classUnderTest.getSecretKey(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSeedEmpty(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Seed must not be null or empty");

        classUnderTest.getSecretKey(new byte[0]);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSecretKeyNull(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("SecretKey must not be null");

        classUnderTest.getPublicKey(null);
    }
}