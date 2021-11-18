package beans;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class InputReader {
    public String read() {
        System.out.println("Please input your sum:");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();

            return input;
        } catch(Exception e) {
            e.getStackTrace();
        }

        return "";
    }
}
