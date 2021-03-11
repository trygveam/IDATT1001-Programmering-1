import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ArrangementRegister {
    private ArrayList<Arrangement> arrangements = new ArrayList<>();

    public void addArrangement(Arrangement arrangement) {
        if(arrangements.contains(arrangement)){
            throw new IllegalArgumentException("allready in");
        }
        else{
            arrangements.add(arrangement);
        }
    }

    public ArrayList<Arrangement> findArrangementsLocation(String location) {
        return arrangements.stream().filter(a->a.getLocation().equals(location)).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Arrangement> findArrangementsDate(int date) {
        return arrangements.stream().filter(a->a.getDate()==date).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Arrangement> findArrangementsDates(int lowerBound, int upperBound) {
        return arrangements.stream().filter(a->a.getDate() > lowerBound && a.getDate() < upperBound).collect(Collectors.toCollection(ArrayList::new));
    }


    public String print(ArrayList<Arrangement> arr) {
        String s = "";
        for (Arrangement a : arr) {
            s += a.toString() + "\n";
        }
       return s;
    }

    @Override
    public String toString() {
        String s = "";
        for (Arrangement a : arrangements) {
            s += a.toString() + "\n";
        }
        return s;
    }


    public static void main(String[] args) {
        ArrangementRegister ar = new ArrangementRegister();
        Arrangement a1 = new Arrangement(1, "lan", "bodo", "LKI", "gaming", 2010071800);
        Arrangement a2 = new Arrangement(2, "sport", "bodo", "LKI", "gaming", 2010072000);
        Arrangement a3 = new Arrangement(3, "klubb", "svolvor", "LKI", "gaming", 2010072200);
        Arrangement a4 = new Arrangement(4, "trening", "harstad", "LKI", "gaming", 2010071600);
        Arrangement a5 = new Arrangement(5, "klubb", "svolvor", "LKI", "gaming", 2010072200);
        Arrangement a6 = new Arrangement(6, "trening", "harstad", "LKI", "gaming", 2010071600);
        Arrangement a7 = new Arrangement(7, "klubb", "narvik", "TKO", "gaming", 2010070900);
        Arrangement a8 = new Arrangement(8, "trening", "narvik", "TKO", "workout", 2010072400);
        ar.addArrangement(a1);
        ar.addArrangement(a2);
        ar.addArrangement(a3);
        ar.addArrangement(a4);
        ar.addArrangement(a5);
        ar.addArrangement(a6);
        ar.addArrangement(a7);
        ar.addArrangement(a8);


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
                    ar.addArrangement(new Arrangement(ans, name, location, organizer, type, date));
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
                    if (ar.findArrangementsDates(dateLeft, dateRight) != null) {
                        JOptionPane.showMessageDialog(null, ar.findArrangementsDates(dateLeft, dateRight));
                    }
                    break;

                case "Sort arrangement by location":
                    ar.arrangements.sort(new Comparator<Arrangement>() {
                        @Override
                        public int compare(Arrangement o1, Arrangement o2) {
                            return o1.getLocation().compareTo(o2.getLocation());
                        }
                    });
                    JOptionPane.showMessageDialog(null, ar.toString());
                    break;

                case "Sort arrangement by date":
                    ar.arrangements.sort(new Comparator<Arrangement>() {
                        @Override
                        public int compare(Arrangement o1, Arrangement o2) {
                            return o1.getDate() - o2.getDate();
                        }
                    });
                    JOptionPane.showMessageDialog(null, ar.toString());
                    break;

                case "Sort arrangement by type":
                    ar.arrangements.sort(new Comparator<Arrangement>() {
                        @Override
                        public int compare(Arrangement o1, Arrangement o2) {
                            return o1.getType().compareTo(o2.getType());
                        }
                    });
                    JOptionPane.showMessageDialog(null, ar.toString());
                    break;

                case "Exit":
                    start = false;
                    break;
            }
        }
    }

}
