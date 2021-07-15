package com.pyramid.utils;

import java.util.Scanner;

public class Utils {

    public static final Scanner scanner = new Scanner(System.in);

    public static int getUserChoice() {
        return Integer.parseInt(scanner.nextLine());
    }
}
