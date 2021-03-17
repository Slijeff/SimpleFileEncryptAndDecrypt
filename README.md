# SimpleFileEncryptAndDecrypt
A Simple utility that encrypts &amp; decrypts files with a given password

## How to Use
1. Make sure you've installed the **Java Runtime Environment (JRE)**, you can find the instruction here: https://www.oracle.com/java/technologies/javase-jre8-downloads.html
2. Download `Crypto.jar`
3. Prepare the files you want to encrypt/decrypt, and copy `Crypto.jar` to the **same** directory (folder) as those files
4. Open a command prompt (terminal) in the same directory
5. Type `java -jar Crypto.jar -p <your_desire_password> -e <file>` for encryption and `java -jar Crypto.jar -p <your_password> -d <file>` for decryption
6. Done! An encrypted file will appear in the same directory with suffix *ENCRYPTED*, or restore your encrypted file with the original filename

## Build/Customizing Encryption & Decryption
Clone the project using `git clone https://github.com/Slijeff/SimpleFileEncryptAndDecrypt.git` or download the zip

You can now write a class that implements the `EncryptionAndDecryption` interface and replace the new object in the `Driver.java` during instantiation
