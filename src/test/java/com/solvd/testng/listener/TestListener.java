package com.solvd.testng.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("starting test: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("test failed: " + result.getName());
    }
}
