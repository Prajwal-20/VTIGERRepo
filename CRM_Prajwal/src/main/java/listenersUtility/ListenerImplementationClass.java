package listenersUtility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseUtilities.BaseClass;
import genericUtilities.JavaUtilityFile;

public class ListenerImplementationClass implements ITestListener, ISuiteListener{
  public ExtentReports report;
  public ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		JavaUtilityFile jutil= new JavaUtilityFile();
		String time = jutil.dateAndTime();
	System.out.println("Execution Started and Report Configuration");
		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("VTIGER_CRM");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Execution completed and report Backup");
		report.flush();
		}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"==START==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"==SUCCESS==");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		
	    test= report.createTest(methodName);
		JavaUtilityFile jutil= new JavaUtilityFile();
		String datetime = jutil.dateAndTime();
	
			TakesScreenshot tks= (TakesScreenshot) BaseClass.sdriver;
			String temp = tks.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(temp,methodName+"_"+datetime );
			test.log(Status.FAIL, methodName+"==FAILED==");		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"==SKIPPED==");
	}

	
}

