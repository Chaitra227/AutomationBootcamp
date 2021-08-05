package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {
	int counter=0;
	int limit=2;

	public boolean retry(ITestResult result) {
		if(counter<limit) {
			System.out.println("Retrying test method "+ result.getMethod().getMethodName()+ " for the "+ (counter+1)+" time");
			counter++;
			return true;
		}
		
		return false;
	}

}
