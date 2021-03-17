import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This is the class that encrypt/decrypts the file
 * @author Jeffrey
 */
public class FileUtil {

  private File file;

  /**
   * Constructor that takes in a File object
   * @param file
   */
  public FileUtil(File file) {
    this.file = file;
  }

  /**
   * Constructor that takes a path
   * @param path
   */
  public FileUtil(String path) {
    this.file = new File(path);
  }

  /**
   * Util that converts any file to a byte array
   * @return a byte array representation of the file
   * @throws IOException
   */
  public byte[] convertFileToByte() throws IOException {
    FileInputStream inputStream = new FileInputStream(this.file);
    byte[] fileBytes = new byte[(int) this.file.length()];
    inputStream.read(fileBytes);
    inputStream.close();
    return fileBytes;
  }

  /**
   * Encrypt the given byte array using specifications in another class
   * @param bytes the given byte array
   * @param crypto the crypto method specified
   * @param key a password
   * @throws Exception
   */
  public void encrypt(byte[] bytes, EncryptionAndDecryption crypto, String key)
      throws Exception {
    System.out.print("Encrypting " + this.file.getName() + " ...");
    File output = new File(this.file.getName() + ".ENCRYPTED");
    FileOutputStream fos = new FileOutputStream(output);
    key = formatKey(key);
    byte[] encryptedBytes = crypto.encryptByteArray(bytes, key);
    fos.write(encryptedBytes);
    fos.close();
    System.out.print("\tDONE!\n");
  }

  /**
   * Decrypt the given byte array using specifications in another class
   * @param bytes the given byte array
   * @param crypto the crypto method specified
   * @param key a password
   * @throws Exception
   */
  public void decrypt(byte[] bytes, EncryptionAndDecryption crypto, String key) throws Exception {
    System.out.print("Decrypting " + this.file.getName() + " ...");
    File output = new File(formatFileExtension(this.file.getName()));
    FileOutputStream fos = new FileOutputStream(output);
    key = formatKey(key);
    byte[] encryptedBytes = crypto.decryptByteArray(bytes, key);
    fos.write(encryptedBytes);
    fos.close();
    System.out.print("\tDONE!\n");
  }

  /**
   * A private helper method that formats the file extension
   * @param encryptedFilename file name given
   * @return a formatted file name with the correct extension
   */
  private String formatFileExtension(String encryptedFilename) {
    if (encryptedFilename == null || encryptedFilename.isEmpty()) {
      return encryptedFilename;
    }
    String correctName = encryptedFilename.substring(0, encryptedFilename.indexOf(".") + 1);

    int startIndex = encryptedFilename.indexOf(".");
    int endIndex = encryptedFilename.indexOf(".", startIndex + 1);
    String correctExtension = encryptedFilename.substring(startIndex + 1, endIndex);

    return correctName + correctExtension;

  }

  /**
   * A private helper method that formats the key to 16 bytes long
   * @param key the given key
   * @return a formatted key that is 16 bytes in length
   */
  private String formatKey(String key){
    byte[] keyBytes = key.getBytes();
    if (keyBytes.length == 16){
      return key;
    }
    else if (keyBytes.length < 16){
      byte[] ret = new byte[(16 - keyBytes.length) + keyBytes.length];
      System.arraycopy(keyBytes, 0, ret, 0, keyBytes.length);
      return new String(ret);
    }
    else {
      byte[] ret = new byte[16];
      System.arraycopy(keyBytes, 0, ret, 0, 16);
      return new String(ret);
    }
  }


}
