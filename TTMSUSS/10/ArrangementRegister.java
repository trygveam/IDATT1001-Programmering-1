import javax.swing.*;
import java.util.Arrays;

public class ArrangementRegister {
    private Arrangement[] arrangements;
    private int posNumber = 0;

    // Disclaimer, using arrays, ArrayList would be a better alternative
    public ArrangementRegister(int size) {
        arrangements = new Arrangement[size];
    }

    public void addArrangement(int nr, String name, String location, String organizer, String type, int date) {
        if (posNumber == arrangements.length) {
            Arrangement[] boo = new Arrangement[arrangements.length + 1];
            for (int i = 0; i < arrangements.length; i++) {
                boo[i] = arrangements[i];
            }
            // One-liner for copying array System.arraycopy(arrangements, 0, boo, 0, arrangements.length);
            arrangements = boo;
        }
        arrangements[posNumber] = new Arrangement(nr, name, location, organizer, type, date);
        posNumber++;
    }

    public Arrangement[] findArrangementsLocation(String location) {
        int pos = 0;
        Arrangement[] temp = new Arrangement[arrangements.length];
        for (Arrangement arr : arrangements) {
            if (arr.getLocation().equals(location)) {
                temp[pos] = arr;
                pos++;
            }
        }
        if (temp[0] == null) {
            return null;
        }
        return temp;
    }

    public Arrangement[] findArrangementsDate(int date) {
        int pos = 0;
        Arrangement[] temp = new Arrangement[arrangements.length];
        for (Arrangement arr : arrangements) {
            if (arr.getDate() == date) {
                temp[pos] = arr;
                pos++;
            }
        }
        return temp;
    }

    public Arrangement[] findArrangementsOnDates(int dateLeft, int dateRight) {
        int pos = 0;
        Arrangement[] temp = new Arrangement[arrangements.length];
        for (Arrangement arr : arrangements) {
            if (arr.getDate() > dateLeft && arr.getDate() < dateRight) {
                temp[pos] = arr;
                pos++;
            }
        }
        return temp;
    }

    public String print(Arrangement[] arr) {
        String s = "";
        for (Arrangement a : arr) {
            s += a.toString() + "\n";
        }
       return s;
    }

    public String toString() {
        String s = "";
        for (Arrangement a : arrangements) {
            s += a.toString() + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        ArrangementRegister ar = new ArrangementRegister(8);
        ar.addArrangement(1, "lan", "bodo", "LKI", "gaming", 2010071800);
        ar.addArrangement(2, "sport", "bodo", "LKI", "gaming", 2010072000);
        ar.addArrangement(3, "klubb", "svolvor", "LKI", "gaming", 2010072200);
        ar.addArrangement(4, "trening", "harstad", "LKI", "gaming", 2010071600);
        ar.addArrangement(5, "klubb", "svolvor", "LKI", "gaming", 2010072200);
        ar.addArrangement(6, "trening", "harstad", "LKI", "gaming", 2010071600);
        ar.addArrangement(7, "klubb", "narvik", "TKO", "gaming", 2010070900);
        ar.addArrangement(8, "trening", "narvik", "TKO", "workout", 2010072400);

        boolean start = true;
        String[] options = {"Add arrangement",
                "Find arrangement by location",
                "Find arrangement by date",
                "Find arrangement between dates",
                "Sort arrangement by location",
                "Sort arrangement by date",
                "Sort arrangement by type",
                "Exit"};

        while (start) {
            String n = (String) JOptionPane.showInputDialog(null, "Pick", "OGA BOGA", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch (n) {
                case "Add arrangement":
                    int ans = Integer.parseInt(JOptionPane.showInputDialog("nr:"));
                    String name = JOptionPane.showInputDialog("name");
                    String location = JOptionPane.showInputDialog("location");
                    String organizer = JOptionPane.showInputDialog("organizer");
                    String type = JOptionPane.showInputDialog("type");
                    int date = Integer.parseInt(JOptionPane.showInputDialog("date:"));
                    ar.addArrangement(ans, name, location, organizer, type, date);
                    break;

                case "Find arrangement by location":
                    String loc = JOptionPane.showInputDialog("location");
                    if (ar.findArrangementsLocation(loc) != null) {
                        JOptionPane.showMessageDialog(null, ar.findArrangementsLocation(loc));
                    }
                    break;

                case "Find arrangement by date":
                    int num = Integer.parseInt(JOptionPane.showInputDialog("nr:"));
                    if (ar.findArrangementsDate(num) != null) {
                        JOptionPane.showMessageDialog(null, ar.findArrangementsDate(num));
                    }
                    break;

                case "Find arrangement between dates":
                    int dateLeft = Integer.parseInt(JOptionPane.showInputDialog("Dateleft:"));
                    int dateRight = Integer.parseInt(JOptionPane.showInputDialog("DateRight:"));
                    if (ar.findArrangementsOnDates(dateLeft, dateRight) != null) {
                        JOptionPane.showMessageDialog(null, ar.findArrangementsOnDates(dateLeft, dateRight));
                    }
                    break;

                case "Sort arrangement by location":
                    Arrays.sort(ar.arrangements, Arrangement::compareToLocation);
                    JOptionPane.showMessageDialog(null, ar.toString());
                    break;

                case "Sort arrangement by date":
                    Arrays.sort(ar.arrangements, Arrangement::compareTo);
                    JOptionPane.showMessageDialog(null, ar.toString());
                    break;

                case "Sort arrangement by type":
                    Arrays.sort(ar.arrangements, Arrangement::compareToType);
                    JOptionPane.showMessageDialog(null, ar.toString());
                    break;

                case "Exit":
                    start = false;
                    break;
            }
        }
    }

}
