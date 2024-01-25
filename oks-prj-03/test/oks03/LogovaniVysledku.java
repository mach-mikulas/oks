package oks03;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

import static oks03.Kontrola_Prj_03.logger;

public class LogovaniVysledku implements TestExecutionListener {


    public void executionStarted(TestIdentifier testIdentifier){
        if(testIdentifier.isTest()){
            //System.err.println(testIdentifier.getDisplayName());

            logger.info(testIdentifier.getDisplayName());
        }

    }

    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult){
        switch (testExecutionResult.getStatus()) {
            case SUCCESSFUL:

                break;
            case FAILED:
                //System.err.println("FAILED: " + testExecutionResult.getThrowable().get().getMessage());

                logger.error(testExecutionResult.getThrowable().get().getMessage());
                break;
        }
    }
}
