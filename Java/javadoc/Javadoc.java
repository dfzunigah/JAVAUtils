package javadoc;
/**
 * This is the class definition, this is an example of how javadoc documentation works
 * @author Daniel
 */
public class Javadoc {
    /**
     * 
     * @param args this is the main method of the program 
     */
    public static void main(String[] args) {
        String name = System.getProperty("os.name");
        String arch = System.getProperty("os.arch");
        String ver = System.getProperty("os.version");
        System.out.println(name);
        System.out.println(arch);
        System.out.println(ver);
    }
    
}
