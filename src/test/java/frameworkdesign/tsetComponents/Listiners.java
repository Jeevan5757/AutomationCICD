package frameworkdesign.tsetComponents;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import frameworkdesign.resources.ExtentReportNG;

public class Listiners extends BaseTest implements ITestListener{
	ExtentReports extent = ExtentReportNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal();
	@Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test); //unique Thread ID
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
//        test.fail(result.getThrowable());  //it will provide error message
        extentTest.get().fail(result.getThrowable()); //it will provide error message
        try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String filepath = null;
		try {
			filepath = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
        System.out.println("TestCase will skip");
    }
    
    @Override
    public void onFinish(ITestContext context) {
    	extent.flush();
    }



}
