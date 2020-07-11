package utils;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.io.IOException;

public class HarCapture {
    private BrowserMobProxy proxy;

    public ChromeOptions setUpProxy(){
        // start the proxy
        proxy = new BrowserMobProxyServer();
        proxy.start(0);

        // get the selenium proxy object
        final Proxy seleniumProxy =  new Proxy();
        final String proxyStr = "localhost:" + proxy.getPort();
        seleniumProxy.setHttpProxy(proxyStr);
        seleniumProxy.setSslProxy(proxyStr);

        // configure it as desired capability
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PROXY, seleniumProxy);

        // add arguments to ignore ssl and certificate errors
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");

        return options;
    }
    public void enableHarCapture(String label){
        // enable HAR capture
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        // create a new HAR
        proxy.newHar(label);
    }
    public void captureHAR(String HAR_FileName){
        // get the HAR data and write to file
        try{
            proxy.getHar().writeTo(new File(HAR_FileName));

        }catch (final IOException ex){
            throw new ExceptionInInitializerError(ex);
        }
    }
    public void destroyProxy(){
        if(proxy != null){
            proxy.stop();
        }
    }
}
