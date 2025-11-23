package core;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.slf4j.Logger; // Menggunakan SLF4J yang terhubung ke Log4j
import org.slf4j.LoggerFactory;

public class TestListener implements ITestListener {

    // Inisialisasi Logger
    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("========================================");
        log.info("MULAI TEST: " + result.getName());
        log.info("========================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("STATUS: " + result.getName() + " -> SUKSES ✅");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("STATUS: " + result.getName() + " -> GAGAL ❌");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("----------------------------------------");
        log.info("SEMUA TEST SELESAI DIJALANKAN");
        log.info("----------------------------------------");
    }
}