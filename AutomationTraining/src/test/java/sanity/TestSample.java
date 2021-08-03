package sanity;

import org.testng.annotations.Test;

import base.InitializeBrowser;
import utility.Test_POJO;

public class TestSample extends InitializeBrowser {

	@Test(dataProvider="test data")
	public void sample(Test_POJO test) {
		System.out.println(test.getUsername()+ " "+ test.getPassword());
	}

}
