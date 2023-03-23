import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SSLCheck {
    public static void main(String[] args) {
        EdgeOptions options = new EdgeOptions();

        // Add the WebDriver proxy capability.
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipadress:4444");
        options.setCapability("proxy", proxy);

        // Block pop-up windows
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        // Set download directory
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);

        // Enable acceptance of insecure certificates
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new EdgeDriver(options);
        driver.get("https://expired.badssl.com/");

        System.out.println(driver.getTitle());

    }
}
