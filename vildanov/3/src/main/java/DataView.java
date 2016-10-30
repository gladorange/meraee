import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by svildan on 13.10.2016.
 */
public class DataView implements Observer {

    private DataModel model;
    private boolean isPositive;
    private int n;
    private int m;

    public DataView(DataModel model) {
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(int n, int m) {
        this.n = n;
        this.m = m;
        write();
    }

    public void write(){
        if (n > 0 && m > 0 & this.isPositive) {
            writeToFile("c://positiveNumbers.txt", n + " " + m);
        } else if (n < 0 && m < 0 & !this.isPositive) {
            writeToFile("c://negativeNumbers.txt", n + " " + m);
        }
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    private void writeToFile(String path, String text){
        File file = new File(path);
        //Create the file
        try {
                file.createNewFile();
                FileWriter writer = new FileWriter(file);
                writer.write(text);
                writer.close();
                System.out.println("File is created!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
