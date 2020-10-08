import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Arrangement implements Comparable<Arrangement> {
    private int nr;
    private String name;
    private String location;
    private String organizer;
    private String type;
    private int date;


    public Arrangement(int nr, String name, String location, String organizer, String type, int date) {
        this.nr = nr;
        this.name = name;
        this.location = location;
        this.organizer = organizer;
        this.type = type;
        this.date = date;
    }

    public int getNr() {
        return nr;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getType() {
        return type;
    }

    public int getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Arrangement{" +
                "nr: " + nr +
                ", name: '" + name + '\'' +
                ", location: '" + location + '\'' +
                ", organizer: '" + organizer + '\'' +
                ", type: '" + type + '\'' +
                ", date: " + date +
                '}';
    }

    public int compareToLocation(Arrangement ar){
        return this.getLocation().compareTo(ar.getLocation());
    }
    public int compareToType(Arrangement ar){
        return this.getType().compareTo(ar.getType());
    }
    @Override
    public int compareTo(Arrangement o) {
        return this.getDate()-o.getDate();
    }
}
