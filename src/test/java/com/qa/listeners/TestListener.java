package com.qa.listeners;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener
{
    String separator = "++++++++++++++++++++++++++++++++++\n";

    public void onTestFailure(ITestResult result)
    {
        if(null != result.getThrowable())
        {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
            System.err.println(separator+sw.toString()+separator);
        }
    }

}
