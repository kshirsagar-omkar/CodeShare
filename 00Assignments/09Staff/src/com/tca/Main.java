package com.tca;

import com.tca.entities.staff.FullTimeStaff;
import com.tca.entities.staff.PartTimeStaff;

public class Main {
    public static void main(String[] args) {

        FullTimeStaff fts = new FullTimeStaff("AAA", "Pune", "CS", 10000.0);
        fts.displayStaffInformation();


        PartTimeStaff pts = new PartTimeStaff("BBB", "PCMC", 4, 500);
        pts.displayStaffInformation();

    }
}