package softeer2nd.View;

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
