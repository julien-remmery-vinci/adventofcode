import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        final int MAX_BLUE = 14;
        final int MAX_RED = 12;
        final int MAX_GREEN = 13;
        int totalGames = 0;
        Set<Integer> impossibles = new HashSet<>();
        while(scanner.hasNext()){
            int gameNumber = 0;
            String gameLine = "";
            scanner.next();
            gameNumber = Integer.parseInt(scanner.next().replace(":", ""));
            totalGames += gameNumber;
            gameLine = scanner.nextLine();
            String[] draws = gameLine.split(";");
            for (String draw : draws) {
                String[] cubes = draw.split(",");
                for (String cube : cubes) {
                    String[] numbers = cube.split(" ");
                    int number = Integer.parseInt(numbers[1]);
                    String color = numbers[2];
                    switch (color){
                        case "red":
                            if(number > MAX_RED) impossibles.add(gameNumber);
                            break;
                        case "green":
                            if(number > MAX_GREEN) impossibles.add(gameNumber);
                            break;
                        case "blue":
                            if(number > MAX_BLUE) impossibles.add(gameNumber);
                            break;
                    }
                }
            }
        }
        for (Integer impossible : impossibles) {
            totalGames -= impossible;
        }
        System.out.println(totalGames);
    }
}
