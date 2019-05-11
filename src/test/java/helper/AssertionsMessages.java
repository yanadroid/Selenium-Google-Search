package helper;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import helper.logger.Log;

public class AssertionsMessages extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info("Assertions test was failed. Name: " + iTestResult.getMethod().getMethodName());
        super.onTestFailure(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info("Assertions test was success. Name: " + iTestResult.getMethod().getMethodName());
        super.onTestSuccess(iTestResult);
    }
}
