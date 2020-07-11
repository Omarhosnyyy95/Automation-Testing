package utils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EventReporter implements ITestListener {
    private File file;
    private FileWriter writer;
    private BufferedWriter bufferedWriter;

    private void createFile(String fileName){
        file = new File(fileName);
        try{
            file.createNewFile();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void writeToFile(String text){
        try {
            writer = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(text);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private long getRunTime(ITestResult iTestResult){
        return iTestResult.getEndMillis() - iTestResult.getStartMillis();
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {

        writeToFile("Test: " + iTestResult.getName() + "\n");
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        long timeTaken = getRunTime(iTestResult);
        writeToFile("time taken: " + timeTaken + " .ms\n");
        writeToFile("status: passed\n");
        writeToFile("**********************\n");
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        long timeTaken = getRunTime(iTestResult);
        writeToFile("time taken: " + timeTaken + " .ms\n");

        writeToFile("status: failed\n");
        writeToFile("**********************\n");
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        writeToFile("status: skipped\n");
        writeToFile("**********************\n");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }
    @Override
    public void onStart(ITestContext iTestContext) {

        // create file
        createFile("resources/report_" + iTestContext.getName() + ".txt");
        writeToFile("****************************\n");
        writeToFile("Starting tests: " + iTestContext.getName() + "\n");
        writeToFile("****************************\n\n");
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        writeToFile("End tests: " + iTestContext.getName() + "\n\n");

        // close file
        try {
            bufferedWriter.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}