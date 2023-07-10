package softeer2nd.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputView {
    Scanner sc;

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public String read(){
        return sc.nextLine();
    }
}
