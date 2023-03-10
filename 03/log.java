import java.io.IOException;
import java.util.logging.*;
/**
 * log
 */
public class log {
    public static String log_file = "./log.txt";
    public static void main(String[] args) {
        System.out.println("start");
    }
    
    public static Logger initLog() throws SecurityException, IOException{
        Logger loger = Logger.getLogger(hw03.class.getName());
        FileHandler fch = new FileHandler(log_file, true); //true - для добавления в концец файла, без него будет перезаписывать.
        loger.addHandler(fch);
        SimpleFormatter sformat = new SimpleFormatter();
        fch.setFormatter(sformat);
        loger.setLevel(Level.FINE);
        loger.log(Level.FINE, "Class initialized");
        return loger;
    }
}
