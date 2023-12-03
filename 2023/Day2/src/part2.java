import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        final int MAX_BLUE = 14;
        final int MAX_RED = 12;
        final int MAX_GREEN = 13;
        int totalGames = 0;
        int totalPower = 0;
        Set<Integer> impossibles = new HashSet<>();
        while(scanner.hasNext()){
            int gameNumber;
            String gameLine;
            scanner.next();
            gameNumber = Integer.parseInt(scanner.next().replace(":", ""));
            totalGames += gameNumber;
            gameLine = scanner.nextLine();
            String[] draws = gameLine.split(";");
            int highestRed = 0;
            int highestGreen = 0;
            int highestBlue = 0;
            for (String draw : draws) {
                String[] cubes = draw.split(",");
                for (String cube : cubes) {
                    String[] numbers = cube.split(" ");
                    int number = Integer.parseInt(numbers[1]);
                    String color = numbers[2];
                    switch (color){
                        case "red":
                            if(number > highestRed) highestRed = number;
                            if(number > MAX_RED) impossibles.add(gameNumber);
                            break;
                        case "green":
                            if(number > highestGreen) highestGreen = number;
                            if(number > MAX_GREEN) impossibles.add(gameNumber);
                            break;
                        case "blue":
                            if(number > highestBlue) highestBlue = number;
                            if(number > MAX_BLUE) impossibles.add(gameNumber);
                            break;
                    }
                }
            }
            totalPower += highestRed * highestBlue * highestGreen;
        }
        for (Integer impossible : impossibles) {
            totalGames -= impossible;
        }
        System.out.println(totalGames);
        System.out.println(totalPower);
    }
}
