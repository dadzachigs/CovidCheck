package co.zw.engineer.covidscreening.help;

public class ContactData {
    String labName;
    String labAddress;
    String labNum;
    String labCity;
    String labNature;

    public ContactData(String labName, String labAddress, String labNum, String labCity, String labNature) {
        this.labName = labName;
        this.labAddress = labAddress;
        this.labNum = labNum;
        this.labCity = labCity;
        this.labNature = labNature;
    }

    public String getLabName() {
        return labName;
    }

    public String getLabAddress() {
        return labAddress;
    }

    public String getLabNum() {
        return labNum;
    }

    public String getLabCity() {
        return labCity;
    }

    public String getLabNature() {
        return labNature;
    }

}
