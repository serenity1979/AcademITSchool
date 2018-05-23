package ru.academits.bozhko;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ParsingCSVinHTML {
    public static void main(String[] args) throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter(args[1]);
             Scanner scanner = new Scanner(new FileInputStream(args[0]))) {
            //noinspection SpellCheckingInspection
            printWriter.println("<!DOCTYPE html>");
            printWriter.println("<html lang=\"ru-RU\">");
            printWriter.println("<head>");
            printWriter.println("<meta charset=\"UTF-8\">");
            printWriter.print("<title> CSV </title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<p> Таблица </p> ");
            //noinspection SpellCheckingInspection
            printWriter.println("<table border=\"1\" cellspacing=\"0\" align=\"left\">");
            // TODO обработка строк
            printWriter.println("</table>");
            printWriter.println("</body>");
            printWriter.println("</html>");
        }
    }
}

