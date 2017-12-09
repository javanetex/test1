package com.company;

import org.testng.annotations.DataProvider;

public class provideLogin {
    @DataProvider
    public static Object[][] getLoginData() {

        return new Object[][]{ {" iulian", "iuli1234"}};

    }
}
