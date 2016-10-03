package jsf;

import java.io.Serializable;
import java.util.Random;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

@SessionScoped
@Named
public class EdController implements Serializable {

    UIComponent inputField;
    UserInfo initialValue = new UserInfo("Anonymous","");

    @NotNull
    private String myNumber;
    private UIComponent numberToRedirectField;

    public EdController() {
        System.out.println("New instance");
    }

    public UIComponent getInputField() {
        return inputField;
    }

    public void setInputField(UIComponent inputField) {
        this.inputField = inputField;
    }

    public UserInfo getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(UserInfo initialValue) {
        this.initialValue = initialValue;
    }

    public void buttonAction(ActionEvent actionEvent) {
        addMessage();
    }

    public void addMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "You have clicked button message:" + initialValue, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String handleAction() {
        System.out.println("Action handler");
        return "";
    }

    public String getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(String myNumber) {
        this.myNumber = myNumber;
    }

    public boolean isIsRequired() {
        return true;
    }

    public String nextPage() {
        return ((HtmlInputText) numberToRedirectField).getValue().toString();
    }

    public void setNumberToRedirectField(UIComponent numberToRedirectField) {
        this.numberToRedirectField = numberToRedirectField;
    }

    public UIComponent getNumberToRedirectField() {
        return numberToRedirectField;
    }
}
