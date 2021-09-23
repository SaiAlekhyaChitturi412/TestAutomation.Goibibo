package com.qa.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports XReports;
	public ExtentTest XTest;
	
	  public void onStart(ITestContext testContext)
	  {
		  String datestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		  String reportname = "TestAutomation-Goibibo"+datestamp+".html";
		  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\"+reportname);
		  htmlReporter.config().setDocumentTitle("TestAutomation-Goibibo");
		  htmlReporter.config().setReportName("TestAutomation-Goibibo");
		  htmlReporter.config().setAutoCreateRelativePathMedia(true);
		  htmlReporter.config().setTheme(Theme.DARK);
		  XReports = new ExtentReports();
		  XReports.attachReporter(htmlReporter);
		  XReports.setSystemInfo("HostName", "localHost");
		  XReports.setSystemInfo("Browser","Chrome");
		  XReports.setSystemInfo("OS","WINDOWS 10");
		  
	  }
	  
	  public void onFinish(ITestContext testContext)
	  {
		  XReports.flush();
	  }
	
	  public void onTestSuccess(ITestResult tr)
	  {
		  XTest = XReports.createTest(tr.getName());
		  XTest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		  String SSName = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		  File file= new File(SSName);
		  if(file.exists())
		  {
			  try
			  {
				  XTest.pass("Screenshot for the test passed is"+XTest.addScreenCaptureFromPath(SSName));
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
		  }
		  
	  }

	  public void onTestFailure(ITestResult tr) 
	  {
		  XTest = XReports.createTest(tr.getName());
		  XTest.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		  XTest.log(Status.FAIL,"Test is Failed");
		  String SSName = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		  File file= new File(SSName);
		  if(file.exists())
		  {
			  try
			  {
				  XTest.fail("Screenshot for the test passed is"+XTest.addScreenCaptureFromPath(SSName));
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
		  }
	  }

	
	  public void onTestSkipped(ITestResult tr)
	  {
		  XTest = XReports.createTest(tr.getName());
		  XTest.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
		  XTest.log(Status.SKIP,"Test is Skipped");
	  }
}
