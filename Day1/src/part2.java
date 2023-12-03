import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        int total = 0;
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String firstNumber = "";
            String lastNumber = "";
            String textNumber = "";
            for (Character c : line.toCharArray()) {
                if(Character.isDigit(c)){
                    if(firstNumber.isEmpty()) firstNumber += c;
                    else lastNumber = String.valueOf(c);
                }
                else{
                    textNumber+=c;
                    int tmp = stringToInt(textNumber);
                    if(tmp > 0) {
                        if(firstNumber.isEmpty()) firstNumber += tmp;
                        else lastNumber = String.valueOf(tmp);
                        textNumber = ""+textNumber.toCharArray()[textNumber.length()-1];
                    }
                }
            }
            if(lastNumber.isEmpty()) lastNumber = firstNumber;
            String lineTotal = firstNumber+lastNumber;
            total += Integer.parseInt(lineTotal);
        }
        System.out.println(total);
    }

    public static int stringToInt(String string){
        switch(string){
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            default:
                break;
        }
        if(string.contains("one")) return 1;
        if(string.contains("two")) return 2;
        if(string.contains("three")) return 3;
        if(string.contains("four")) return 4;
        if(string.contains("five")) return 5;
        if(string.contains("six")) return 6;
        if(string.contains("seven")) return 7;
        if(string.contains("eight")) return 8;
        if(string.contains("nine")) return 9;
        return -1;
    }
}
