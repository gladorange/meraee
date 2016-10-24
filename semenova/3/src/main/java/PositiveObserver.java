import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ansemen on 29.09.2016.
 */
public class PositiveObserver implements Observer {
    public void notify(int n1, int n2) {
        if(n1 <= 0 || n2 <= 0){
            return;
        }
        try{
            FileWriter writer = new FileWriter("D:\\TT\\JAVAEE course\\meraee\\semenova\\3\\output\\positive.txt", false);
            writer.write(n1 + "\n" + n2);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
