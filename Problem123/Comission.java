import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.FormatFlagsConversionMismatchException;

public class Comission {
    public int host;
    public int monitor;
    public int peripheral;
    public double CalculateCommision() {
        int saleroom = 0;
        int flag;
        double comission = 0;
        if (host <= 0 || monitor <= 0 || peripheral <= 0) {
            flag = 0;
        }
        else if (host > 70 || monitor > 80 || peripheral > 90) {
            comission = -1;
            flag = 0;
        }
        else {
            saleroom = host * 25 + monitor * 30 + peripheral * 45;
            flag = -1;
        }

        if (flag == -1) {
            if (saleroom <= 1000) {
                comission = saleroom * 0.1;
            }
            else if (saleroom <= 1800) {
                comission = saleroom * 0.15;
            }
            else {
                comission = saleroom * 0.2;
            }
        }
        return comission;
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./testcsv/ComissionBoundary.csv"));

            reader.readLine();

            String line = null;
            while((line = reader.readLine())!=null) {
                String item[] = line.split(",");
                String host = item[1];
                String monitor = item[2];
                String peripheral = item[3];
                Comission test = new Comission();
                test.host = Integer.parseInt(host);
                test.monitor = Integer.parseInt(monitor);
                test.peripheral = Integer.parseInt(peripheral);
                double result = test.CalculateCommision();
                System.out.println("预期输出：" + item[6] + "\t\t实际输出：" + result);
            }

        }
        catch (Exception e) {

        }
    }
}
