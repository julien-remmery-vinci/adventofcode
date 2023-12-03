import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        int total = 0;
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String firstNumber = "";
            String lastNumber = "";
            for (Character c : line.toCharArray()) {
                if(Character.isDigit(c)){
                    if(firstNumber.isEmpty()) {
                        firstNumber = String.valueOf(c);
                    }
                    else {
                        lastNumber = String.valueOf(c);
                    }
                }
            }
            if(lastNumber.isEmpty()) lastNumber = firstNumber;
            total += Integer.parseInt(firstNumber+lastNumber);
            System.out.println(total);
        }
        System.out.println(total);
    }
}
