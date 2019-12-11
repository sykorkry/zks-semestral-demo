package cz.cvut.fel.still.sqa.seleniumStarterPack.listeners;
/*
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
*/

public class ScreenshotListener {}/*implements TestExecutionListener {

    private boolean createFile(File screenshot) {
        boolean fileCreated = false;

        if (screenshot.exists()) {
            fileCreated = true;
        } else {
            File parentDirectory = new File(screenshot.getParent());
            if (parentDirectory.exists() || parentDirectory.mkdirs()) {
                try {
                    fileCreated = screenshot.createNewFile();
                } catch (IOException errorCreatingScreenshot) {
                    errorCreatingScreenshot.printStackTrace();
                }
            }
        }

        return fileCreated;
    }

    private void writeScreenshotToFile(WebDriver driver, File screenshot) {
        try {
            FileOutputStream screenshotStream = new FileOutputStream(screenshot);
            screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            screenshotStream.close();
        } catch (IOException unableToWriteScreenshot) {
            System.err.println("Unable to write " + screenshot.getAbsolutePath());
            unableToWriteScreenshot.printStackTrace();
        }
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        try {
            WebDriver driver = getDriver();
            String screenshotDirectory = System.getProperty("screenshotDirectory", "target/screenshots");
            String screenshotAbsolutePath = screenshotDirectory + File.separator + System.currentTimeMillis() + "_" + testIdentifier.getDisplayName() + ".png";
            File screenshot = new File(screenshotAbsolutePath);
            if (createFile(screenshot)) {
                try {
                    writeScreenshotToFile(driver, screenshot);
                } catch (ClassCastException weNeedToAugmentOurDriverObject) {
                    writeScreenshotToFile(new Augmenter().augment(driver), screenshot);
                }
                System.out.println("Written screenshot to " + screenshotAbsolutePath);
            } else {
                System.err.println("Unable to create " + screenshotAbsolutePath);
            }
        } catch (Exception ex) {
            System.err.println("Unable to capture screenshot: " + ex.getCause());
        }
    }
}*/