package lab3.pojos;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public abstract class Editable implements Serializable, SaleableItem {



    public Scanner input = new Scanner(System.in);

    public abstract void edit();

    public abstract void initialize();

    public String getInput(String s) {
        String ss = input.nextLine();
        if (ss.trim().isEmpty()) {
            return s;
        }
        Scanner in2 = new Scanner(ss);
        return in2.nextLine();
    }

    public int getInput(int i) {
        String s = input.nextLine();
        if (s.trim().isEmpty()) {
            return i;
        }
        Scanner in2 = new Scanner(s);
        return in2.nextInt();
    }

    public double getInput(double i) {
        String s = input.nextLine();
        if (s.trim().isEmpty()) {
            return i;
        }
        Scanner in2 = new Scanner(s);
        return in2.nextDouble();
    }

    public boolean getInput(boolean b) {
        String s = input.nextLine();
        if (s.trim().isEmpty()) {
            return b;
        }
        Scanner in2 = new Scanner(s);
        return in2.nextBoolean();
    }

    public Date getInput(Date date) {
        String s = input.nextLine();
        if (s.trim().isEmpty()) {
            return date;
        }
        Scanner in2 = new Scanner(s);
        // date = "29-Mar-2006";
        String dateInString = in2.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date d;
        try {
            d = formatter.parse(dateInString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return d;
    }

    public LocalDate getInput(LocalDate date) {
        String s = input.nextLine();
        if (s.trim().isEmpty()) {
            return date;
        }
        LocalDate d;
        try {
            d = LocalDate.parse(s, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            throw e;
        }
        return d;
    }

    @Override
    public String toString() {
        return "Editable{}";
    }



    // these are uesd for unit testing
    public void setSystemInput(ByteArrayInputStream testIn) {
        System.setIn(testIn);
        input = new Scanner(System.in);
    }

    public void setSystemOutput(ByteArrayOutputStream testOut) {
        System.setOut(new PrintStream(testOut));
    }


}