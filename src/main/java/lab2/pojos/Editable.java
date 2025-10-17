package lab2.pojos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public abstract class Editable {
    protected int id;
    protected static final Scanner SC = new Scanner(System.in);
    protected static final DateTimeFormatter LOCAL_DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }


    public abstract void edit();
    public abstract void initialize();


    protected String getInput(String prompt, String defaultValue) {
        System.out.print(prompt + (defaultValue != null ? " ["+defaultValue+"]" : "") + ": ");
        String line = SC.nextLine().trim();
        return line.isEmpty() ? defaultValue : line;
    }


    protected int getInputInt(String prompt, int defaultValue) {
        String s = getInput(prompt, Integer.toString(defaultValue));
        try { return Integer.parseInt(s); } catch (Exception e) { return defaultValue; }
    }


    protected double getInputDouble(String prompt, double defaultValue) {
        String s = getInput(prompt, Double.toString(defaultValue));
        try { return Double.parseDouble(s); } catch (Exception e) { return defaultValue; }
    }


    protected boolean getInputBoolean(String prompt, boolean defaultValue) {
        String s = getInput(prompt, Boolean.toString(defaultValue));
        return Boolean.parseBoolean(s);
    }


    protected LocalDate getInputDate(String prompt, LocalDate defaultValue) {
        String s = getInput(prompt, defaultValue != null ? defaultValue.format(LOCAL_DATE_FORMAT) : "");
        try { return LocalDate.parse(s, LOCAL_DATE_FORMAT); } catch (Exception e) { return defaultValue; }
    }
}
