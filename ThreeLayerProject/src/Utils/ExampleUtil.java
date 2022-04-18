package Utils;

import java.util.Scanner;

public class ExampleUtil
{
    private static final Scanner scanner = new Scanner(System.in);

    public static void writeConsoleLine(String line) 
    {
        System.out.println(line);
    }
    
    public static String readConsoleLine() 
    {
        return scanner.nextLine();
    }
}