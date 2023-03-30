package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class TablePage {
    WebDriver driver;

    public TablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id=\"searchBox\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@id=\"addNewRecordButton\"]")
    private WebElement addButton;

    @FindBy(xpath = "//input[@id=\"firstName\"]")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id=\"lastName\"]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id=\"userEmail\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id=\"age\"]")
    private WebElement ageInput;

    @FindBy(xpath = "//input[@id=\"salary\"]")
    private WebElement salaryInput;

    @FindBy(xpath = "//input[@id=\"department\"]")
    private WebElement departmentInput;

    @FindBy(xpath = "//button[@id=\"submit\"]")
    private WebElement submitButton;

    public void clickToAddButton() {
        addButton.click();
    }

    public void fillData(String fistName, String lastName, String email, String age, String salary, String department) {
        firstNameInput.clear();
        firstNameInput.sendKeys(fistName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        emailInput.clear();
        emailInput.sendKeys(email);
        ageInput.clear();
        ageInput.sendKeys(age);
        salaryInput.clear();
        salaryInput.sendKeys(salary);
        departmentInput.clear();
        departmentInput.sendKeys(department);
        submitButton.click();
    }

    public void fillSearchInput(String text) {
        searchInput.clear();
        searchInput.sendKeys(text);
    }

    public List<Map<String, String>> getTableData() {
        List<WebElement> data = driver.findElements(By.xpath("//div[@role='rowgroup']"));
        List<Map<String, String>> rows = new ArrayList<>();

        for(int k=0; k<= data.size()-1; k++) {
            List<String> cell = new ArrayList<>();
            Map<String, String> dataCell = new HashMap<>();
            if(!data.get(k).getText().contains("  ")) {
                for(int i=1; i<=6; i++) {
                    String locator = String.format("//div[@role='rowgroup'][%s]//div[@class='rt-td'][%s]", k + 1, i);
                    String cellText = driver.findElement(By.xpath(locator)).getText();
                    cell.add(cellText);
                }
                dataCell.put("First Name", cell.get(0));
                dataCell.put("Last Name", cell.get(1));
                dataCell.put("Age", cell.get(2));
                dataCell.put("Email", cell.get(3));
                dataCell.put("Salary", cell.get(4));
                dataCell.put("Department", cell.get(5));
                rows.add(dataCell);
            }

        }
        return rows;
    }


}
