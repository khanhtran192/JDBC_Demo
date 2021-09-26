/**
 * Tao cac ham kiem soat ngoai le cho Input khi nhap
 * java 12
 * @version 1.0
 * 25/9/2021
 * * @author Tran Duy Khanh
 */
package Application;

import java.util.Scanner;

public class ExceptionInput {
    public int inputScannerInt() {
        while (true) {
            try {
                Scanner keyboard = new Scanner(System.in);
                String input = keyboard.nextLine();
                long pressedType = Long.parseLong(input);
                return (int) pressedType;
            } catch (NumberFormatException e) {
                System.out.println("nhap sai dinh dang so");
            }
        }
    }
    public String inputScannerString(){
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        return input;
    }
}
