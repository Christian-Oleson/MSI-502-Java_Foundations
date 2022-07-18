/** Christian Oleson
 * MSI-503
 * Assignment 3
 */
public class OlesonChristian_TestCheckup {
    public static void main(String[] args) {
        var checkup = new OlesonChristian_Checkup(1);
        checkup._bloodPressure.setSystolicBloodPressure(120);
        checkup._bloodPressure.setDiastolicBloodPressure(80);
        checkup._cholesterol.setLdl(100);
        checkup._cholesterol.setHdl(50);
        System.out.println(checkup);
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println();
        var secondCheckup = new OlesonChristian_Checkup(2);
        secondCheckup._bloodPressure.setSystolicBloodPressure(140);
        secondCheckup._bloodPressure.setDiastolicBloodPressure(90);
        secondCheckup._cholesterol.setLdl(110);
        secondCheckup._cholesterol.setHdl(60);
        System.out.println(secondCheckup);
    }
}
