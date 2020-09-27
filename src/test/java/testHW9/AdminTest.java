package testHW9;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends BaseTestAdmin {
    //Admin credentials for https://www.phptravels.net/admin
    String adminEmail = "admin@phptravels.com";
    String adminPassword = "demoadmin";

    //booking info
    String firstName = "Oksana";
    String id = "43";
    String status = "unpaid";

    @Test()
    public void test(){
        //go to https://www.phptravels.net/admin
        //log in
        adminLoginPage.loginAs(adminEmail, adminPassword);
        adminWelcomePage.clickBookingsLinkSideBar();
        System.out.println(adminWelcomePage.getTableText());
        String[] split = adminWelcomePage.getTableText().split("\\R");
        for (String a: split) {
            System.out.println(a);
        }

        for (int i=0; i<split.length; i++){
            if (split[i].contains(id)) {
                Assert.assertTrue(split[i].contains(status));
                Assert.assertTrue(split[i].contains(firstName));
            }
            break;
        }


//        Assert.assertEquals();

    }
}
