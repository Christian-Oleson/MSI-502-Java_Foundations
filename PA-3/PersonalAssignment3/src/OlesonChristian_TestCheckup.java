/** Christian Oleson
 * MSI-503
 * Assignment 3
 */
public class OlesonChristian_TestCheckup {
    public static void main(String[] args) {
        var checkup = new OlesonChristian_Checkup(1);
        checkup.BloodPressure.setSystolicBloodPressure(120);
        checkup.BloodPressure.setDiastolicBloodPressure(80);
        checkup.Cholesterol.setLdl(100);
        checkup.Cholesterol.setHdl(50);
        System.out.println(checkup);
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println();
        var secondCheckup = new OlesonChristian_Checkup(2);
        secondCheckup.BloodPressure.setSystolicBloodPressure(140);
        secondCheckup.BloodPressure.setDiastolicBloodPressure(90);
        secondCheckup.Cholesterol.setLdl(110);
        secondCheckup.Cholesterol.setHdl(60);
        System.out.println(secondCheckup);
    }
}
