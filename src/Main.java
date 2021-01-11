import libnl2.Park;
import libnl2.coaster.Coaster;
import libnl2.io.Reader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Park park = new Park("Test Park 1.nl2park");

        System.out.println("Author: " + park.getInfo().getAuthor());
        System.out.println("Description: " + park.getInfo().getDescription());
        System.out.println("Number of coasters: " + park.getCoasters().size());
        System.out.println();
        System.out.println("COASTERS");
        for (Coaster coaster : park.getCoasters()) {
            System.out.println("Name: " + coaster.getName());
            System.out.println("Description: " + coaster.getDescription());
            System.out.println("Frozen: " + coaster.isFrozen());
            System.out.println();
        }
    }
}
