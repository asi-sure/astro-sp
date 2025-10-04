package com.congreso.backend.libs;

import java.time.LocalDate;


public class ObtenerFechas {
    static LocalDate today;  // =  LocalDate.now();

    public static int getDay(LocalDate xfecha) {
        return xfecha.getDayOfMonth();
    }
    public static int getMonth(LocalDate xfecha) {
        return xfecha.getMonthValue();
    }
    public static int getYear(LocalDate xfecha) {
        return xfecha.getYear();
    }
    public static int getDiasDelMes(LocalDate xfecha) {
        return xfecha.lengthOfMonth();
    }

    /*
      LocalDate today = LocalDate.now();

        // 2. Extract the components
        int year = today.getYear();
        Month monthEnum = today.getMonth();
        int monthValue = today.getMonthValue();
        int dayOfMonth = today.getDayOfMonth();
        int dayOfYear = today.getDayOfYear();
        int dayOfWeek = today.getDayOfWeek().getValue(); // 1 (Monday) to 7 (Sunday)

        // 3. Print the results
        System.out.println("Today's Date: " + today);
        System.out.println("Year: " + year);         // e.g., 2025
        System.out.println("Month (Enum): " + monthEnum); // e.g., OCTOBER
        System.out.println("Month (Value): " + monthValue); // e.g., 10
        System.out.println("Day of Month: " + dayOfMonth); // e.g., 1
        System.out.println("Day of Week (1=Mon): " + dayOfWeek); // e.g., 3 (Wednesday)
        ////////////////////////
        System.out.println("Month : " + today.getMonthValue()); // e.g., 10
        System.out.println("Year: " + today.getYear());         // e.g., 2025
        System.out.println("Day of Month: " + today.getDayOfMonth()); // e.g., 10
        System.out.println("Quantity Day of Month: " + today.lengthOfMonth()); // e.g., 10
     */
}
