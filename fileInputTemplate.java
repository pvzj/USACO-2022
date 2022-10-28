import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class fileInputTemplate {
    public static void main(String[] args) throws IOException {
        String fileName = "";
        BufferedReader br = new BufferedReader(new FileReader(fileName + ".in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));

        pw.close();
        br.close();
    }
}
