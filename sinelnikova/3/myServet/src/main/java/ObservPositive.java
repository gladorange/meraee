import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Viktoria on 28-Sep-16.
 */
public class ObservPositive implements Observer {
    public void notifyNum(int a, int b) {
        if(a > 0 && b > 0){
            try {
                FileWriter fr = new FileWriter("D:\\positiveNumbers.txt");
//                FileWriter fr = new FileWriter("D:\\a.txt");
                String out = a + "," + b;
                fr.write(out);
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
