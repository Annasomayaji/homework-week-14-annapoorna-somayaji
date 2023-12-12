package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "systemuser")
    public Object[][] getData() {
        Object[][] data = new Object[][]{

                {"Nina.Patel", "ESS", "Akhil Sharma", "Enabled"},
                {"Admin", "Admin", "Amar Akbar Anthony", "Enabled"},
                {"Cassidy.Hope ", "ESS", "Cassidy Hope", "Enabled"},
                {"Odis.Adalwin", "Admin", "Odis Adalwin", "Enabled"}

        };
        return data;
    }

    @DataProvider(name = "invalidlogindetails")
    public Object[][] getCredentials() {
        Object[][] data = new Object[][]{

                {"", "", "Required"},
                {"test123@gmail.com", "", "Required"},
                {"", "test123", "Required"},
                {"test123@gmail.com", "test123", "Invalid credentials"}

        };
        return data;
    }


}
