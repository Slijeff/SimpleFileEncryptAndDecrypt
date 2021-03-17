import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * A default crypto class that defines the encryption/decryption
 * @author Jeffrey
 */
public class DefaultCrypto implements EncryptionAndDecryption {

  private final String keyAlgo = "AES";
  private final String encryptAlgo = "AES";

  /**
   * Encrypt the given byte array by doing operations
   *
   * @param bytes the given byte array
   * @return an encrypted byte array
   */
  @Override
  public byte[] encryptByteArray(byte[] bytes, String key)
      throws Exception {
    Key encryptedKey = new SecretKeySpec(key.getBytes(), keyAlgo);
    Cipher cipher = Cipher.getInstance(encryptAlgo);
    cipher.init(Cipher.ENCRYPT_MODE, encryptedKey);

    byte[] output = cipher.doFinal(bytes);
    return output;

  }

  /**
   * Decrypt the given byte array by doing operations
   *
   * @param bytes the given byte array
   * @return a decrypted byte array
   */
  @Override
  public byte[] decryptByteArray(byte[] bytes, String key) throws Exception {
    Key encryptedKey = new SecretKeySpec(key.getBytes(), keyAlgo);
    Cipher cipher = Cipher.getInstance(encryptAlgo);
    cipher.init(Cipher.DECRYPT_MODE, encryptedKey);

    byte[] output = cipher.doFinal(bytes);
    return output;
  }
}
