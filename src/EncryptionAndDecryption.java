/**
 * To use custom encryption and decryption methods, must implement this interface as a template The
 * encryption method and the decryption method must match in order to decrypt the encrypted file
 *
 * @author Jeffrey
 */
public interface EncryptionAndDecryption {

  /**
   * Encrypt the given byte array by doing operations
   *
   * @param bytes the given byte array
   * @return an encrypted byte array
   */
  byte[] encryptByteArray(byte[] bytes, String key) throws Exception;

  /**
   * Decrypt the given byte array by doing operations
   *
   * @param bytes the given byte array
   * @return a decrypted byte array
   */
  byte[] decryptByteArray(byte[] bytes, String key) throws Exception;
}
