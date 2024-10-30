package com.tca.entities.staff;

public abstract class Staff {
    private String staffName;
    private String staffAddress;

    public Staff(String staffName, String staffAddress) {
        this.staffName = staffName;
        this.staffAddress = staffAddress;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public abstract void displayStaffInformation();

}
