package org.example.pageobjects;

import org.example.pageobjects.modules.DeliverToLocationPopUpModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {
    private final String mainPagePath = "https://www.amazon.com";
    private final String gamingKeyboardsPath = "/s?k=gaming+keyboard&pd_rd_r=da8afc49-fa94-41c3-9d45-7e811ac33b10&pd_rd_w=gSHhP&pd_rd_wg"
            + "=fx882&pf_rd_p=12129333-2117-4490-9c17-6d31baf0582a&pf_rd_r=XYWA244WM0H05HEYD0RE&ref=pd_gw_unk";
    private final String headsetsPath = "/s?k=gaming+headsets&pd_rd_r=1599464d-4b89-483f-b7a3-97f894952119&pd_rd_w=F1dlc&pd_rd_wg=CWy7u&pf" +
            "_rd_p=12129333-2117-4490-9c17-6d31baf0582a&pf_rd_r=H82965Q5ZSX17H08VA9T&ref=pd_gw_unk";

    @FindBy(id = "glow-ingress-block")
    private WebElement deliverToModule;

    @FindBy(id = "glow-ingress-line2")
    private WebElement cityAndZipCode;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage openMainPage() {
        webDriver.get(mainPagePath);
        return this;
    }

    public GamingKeyboardsResultsPage openGamingKeyboardsPage() {
        webDriver.get(mainPagePath + gamingKeyboardsPath);
        return new GamingKeyboardsResultsPage(webDriver);
    }

    public HeadsetsResultsPage openHeadsetsPage() {
        webDriver.get(mainPagePath + headsetsPath);
        return new HeadsetsResultsPage(webDriver);
    }

    public DeliverToLocationPopUpModule openDeliverToModule(){
        waitForElementToBeClickable(deliverToModule);
        deliverToModule.click();
        return new DeliverToLocationPopUpModule(webDriver);
    }

    public String getZipCodeFromMainPage(){
        waitForElementVisibility(cityAndZipCode);

        return cityAndZipCode.getText();
    }
}
