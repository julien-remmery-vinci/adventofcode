import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class part2 {
    static int TAILLE = 140;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        int total = 0;
        char[][] input = new char[TAILLE][TAILLE];
        for (int i = 0; i < TAILLE; i++) {
            char[] line = scanner.nextLine().toCharArray();
            if (TAILLE >= 0) System.arraycopy(line, 0, input[i], 0, TAILLE);
        }

        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                if(input[i][j] == '*') {
                    total += check(input, i, j);
                }
            }
        }

        System.out.println("Total: "+total);
    }

    static int check(char[][] input, int x, int y){
        int xStart = Math.max(x - 1, 0);
        int xEnd = Math.min(x + 1, TAILLE);
        int yStart = Math.max(y-3, 0);
        int yEnd = Math.min(y+3, TAILLE);

        String number = "";
        List<String> numbers = new ArrayList<>();
        int start = -1;
        int end;
        int line = -1;

        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) {
                if(!Character.isDigit(input[i][j]) && !number.isEmpty()){
                    end = j-1;
                    if(checkGear(input, start, end, line, x, y)){
                        System.out.println("Valid number: "+number);
                        numbers.add(number);
                        number = "";
                    }
                    else number = "";
                }
                if(Character.isDigit(input[i][j])) {
                    line = i;
                    if(number.isEmpty()){
                        start = j;
                        number+=input[i][j];
                    }else{
                        number+=input[i][j];
                    }
                }
            }
            if(!number.isEmpty()){
                if(checkGear(input, start, yEnd, line, x, y)){
                    System.out.println("Valid number: "+number);
                    numbers.add(number);
                    number = "";
                }
                else number ="";
            }
        }
        if(numbers.size()>1) {
            System.out.println("Size: "+numbers.size());
            int product = 1;
            for (String s : numbers) {
                product *= Integer.parseInt(s);
            }
            System.out.println("Result: "+product);
            return product;
        }
        System.out.println("Not a gear");
        return 0;
    }

    public static boolean checkGear(char[][] input, int start, int end, int y, int gearX, int gearY){
        int yStart = 0, yEnd;
        if(start>0) start--;
        if(y>0) yStart = y-1;
        if(end+1<TAILLE) end++;
        if(y+2<TAILLE) yEnd = y+2;
        else yEnd = y+1;

        for (int i = yStart; i < yEnd; i++) {
            for (int j = start; j < end+1; j++) {
                if(!Character.isDigit(input[i][j]) && input[i][j] == '*') {
                    if(i==gearX && j==gearY) return true;
                    return false;
                };
            }
        }
        return false;
    }
}
