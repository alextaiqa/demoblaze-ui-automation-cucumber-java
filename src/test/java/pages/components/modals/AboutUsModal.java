package pages.components.modals;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class AboutUsModal extends BaseModal {

    //selectors
    private final By aboutUsModalContainerCSS = By.cssSelector("#videoModal");
    private final By aboutUSModalHeaderCSS = By.cssSelector("#videoModalLabel");

    //constructor
    public AboutUsModal(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods


    //getters for common methods
    @Override
    protected By getModalContainer() {
        return aboutUsModalContainerCSS;
    }

    @Override
    protected By getHeaderLocator() {
        return aboutUSModalHeaderCSS;
    }

    @Override
    protected String getModalName() {
        return "'About us'";
    }

}
