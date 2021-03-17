import java.util.ArrayList;

/**
 * The entry point for the program, contains the main method
 * @author Jeffrey
 */
public class Driver {

  public static void main(String[] args) throws Exception {
    //Initialize
    DefaultCrypto crypto = new DefaultCrypto();
    String pwd = null;
    String mode = null;
    ArrayList<FileUtil> process = new ArrayList<>();

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-p")){
        pwd = args[i + 1];
      }
      if (args[i].equals("-e")){
        mode = "e";
        for (int j = i + 1; j < args.length; j++) {
          process.add(new FileUtil(args[j]));
        }
        break;
      }
      if (args[i].equals("-d")){
        mode = "d";
        for (int j = i + 1; j < args.length; j++) {
          process.add(new FileUtil(args[j]));
        }
        break;
      }
    }

    for (FileUtil f : process) {
      if (mode.equals("e")) f.encrypt(f.convertFileToByte(), crypto, pwd);
      else if (mode.equals("d")) f.decrypt(f.convertFileToByte(), crypto, pwd);
    }
  }
}
