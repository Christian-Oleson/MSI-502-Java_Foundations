/** Christian Oleson
 * MSI-503
 * Assignment 3
 */
public class OlesonChristian_TestCheckup {
    public static void main(String[] args) {
        var checkup = new OlesonChristian_Checkup(1);
        checkup.setSystolicBloodPressure(120);
        checkup.setDiastolicBloodPressure(80);
        checkup.setBloodPressure(new BloodPressure(120, 80));
        checkup.setLdl(100);
        checkup.setHdl(50);
        checkup.setCholesterol(new Cholesterol(1, 50));
        System.out.println(checkup);
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println();
        var secondCheckup = new OlesonChristian_Checkup(2);
        secondCheckup.setSystolicBloodPressure(140);
        secondCheckup.setDiastolicBloodPressure(90);
        secondCheckup.setBloodPressure(new BloodPressure(140, 90));
        secondCheckup.setLdl(110);
        secondCheckup.setHdl(60);
        secondCheckup.setCholesterol(new Cholesterol(20, 60));
        System.out.println(secondCheckup);
    }
}
