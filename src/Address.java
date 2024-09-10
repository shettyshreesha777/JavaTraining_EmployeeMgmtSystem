public class Address {
    private String houseName;
    private String streetName;
    private String landmark;
    private String pincode;

    // Constructor
    /*
    public Address(String houseName, String streetName, String landmark, String pincode) {
        this.houseName = houseName;
        this.streetName = streetName;
        this.landmark = landmark;
        this.pincode = pincode;
    }
    */
    // Getters and Setters
    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String toString() {
        return "Address{" +
                "houseName='" + houseName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", landmark='" + landmark + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
