import java.util.stream.Stream;

public enum Day {

    SUNDAY("work"),
    MONDAY("work"),
    TUESDAY("WORK"),
    WEDNESDAY("work"),
    THURSDAY("off"),
    FRIDAY("off"),
    SATURDAY("work");

    private String val;
    
    Day(String string) {
       this.val = string;
    }
    public static Stream<Day> stream() {
        return Stream.of(Day.values()); 
    }
    public String getVal() {
        return val;
    }
    public void setVal(String val) {
        this.val = val;
    }

    
    
}


