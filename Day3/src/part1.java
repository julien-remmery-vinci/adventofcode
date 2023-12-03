import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class part1 {
    static int TAILLE = 140;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        Set<String> chars = new HashSet<>();
        int total = 0;
        int xStart = -1;
        int xEnd;
        int y = -1;
        char[][] input = new char[TAILLE][TAILLE];
        for (int i = 0; i < TAILLE; i++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int j = 0; j < TAILLE; j++) {
                input[i][j] = line[j];
            }
        }

        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                if(!Character.isDigit(input[i][j]) && input[i][j] != '.') chars.add(""+input[i][j]);
            }
        }

        String number = "";
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                char c = input[i][j];
                if(Character.isDigit(c)){
                    y = i;
                    number+=c;
                    if(xStart < 0) xStart = j;
                    if(j==TAILLE-1){
                        xEnd = j;
                        if(check(input, xStart, xEnd, y)) {
                            total += Integer.parseInt(number);
                            System.out.println();
                            System.out.println("Valid number: "+Integer.parseInt(number));
                        }
                        xStart = -1;
                        number = "";
                    }
                } else if (!number.isEmpty()) {
                    xEnd = j-1;
                    if(check(input, xStart, xEnd, y)) {
                        total += Integer.parseInt(number);
                        System.out.println();
                        System.out.println("Valid number: "+Integer.parseInt(number));
                    }
                    xStart = -1;
                    number = "";
                }
            }
        }
        System.out.println();
        System.out.println("Total: "+total);
        System.out.println(chars);
    }

    public static boolean check(char[][] input, int start, int end, int y){
        System.out.println();
        int yStart = 0, yEnd =0;
        if(start>0) start--;
        if(y>0) yStart = y-1;
        if(end+1<TAILLE) end++;
        if(y+2<TAILLE) yEnd = y+2;
        else yEnd = y+1;
        System.out.println("start: "+start);
        System.out.println("end: "+end);
        System.out.println("y: "+y);
        for (int i = yStart; i < yEnd; i++) {
            System.out.println();
            for (int j = start; j < end+1; j++) {
                System.out.print(input[i][j]);
                if(!Character.isDigit(input[i][j]) && input[i][j] != '.') return true;
            }
        }
        return false;
    }
}
