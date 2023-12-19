package Listenres;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int retryingAttempts=0;
    @Override
    public boolean retry(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE){
            retryingAttempts++;
            if (retryingAttempts == 1){
                System.out.println("first attempet");
            return true;
            }
            else if (retryingAttempts>1){
                System.out.println("stop");
            }
        }
        return false;
    }
}
