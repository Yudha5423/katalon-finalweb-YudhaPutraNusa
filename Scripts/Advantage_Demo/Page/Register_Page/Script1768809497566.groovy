import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Inisiasi

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://advantageonlineshopping.com/#/register')

//Set Text Account Details
def time = new Date().format('HHmmss')

String username = 'yudha_' + time

WebUI.setText(findTestObject('Object Repository/Advantage_Demo/Register/field_username_email', ['field' : '1']), username)

WebUI.setText(findTestObject('Object Repository/Advantage_Demo/Register/field_username_email', ['field' : '2']), "yudha.test@test.com")

WebUI.setText(findTestObject('Object Repository/Advantage_Demo/Register/field_password_confirm_password', ['field' : '1']), "Yudhatest123")

WebUI.setText(findTestObject('Object Repository/Advantage_Demo/Register/field_password_confirm_password', ['field' : '2']), "Yudhatest123")

//Set Text Personal Details

WebUI.setText(findTestObject('Object Repository/Advantage_Demo/Register/field_first_last_name', ['field' : '1']), "Yudha")

WebUI.setText(findTestObject('Object Repository/Advantage_Demo/Register/field_first_last_name', ['field' : '2']), "Test")

WebUI.setText(findTestObject('Object Repository/Advantage_Demo/Register/field_phone_number'), "081234567890")

//Set Text Address

WebUI.selectOptionByLabel(
    findTestObject('Object Repository/Advantage_Demo/Register/listbox_country'),
    'Indonesia',
    false)

WebUI.setText(findTestObject('Object Repository/Advantage_Demo/Register/field_city'), "Semarang")

WebUI.setText(findTestObject('Object Repository/Advantage_Demo/Register/field_address_state', ['field' : '1']), "Jalan Kaki")

WebUI.setText(findTestObject('Object Repository/Advantage_Demo/Register/field_address_state', ['field' : '2']), "Semarang")

WebUI.setText(findTestObject('Object Repository/Advantage_Demo/Register/field_postal_code'), "12345")

WebUI.click(findTestObject('Object Repository/Advantage_Demo/Register/checkbox_agreement'))

WebUI.click(findTestObject('Object Repository/Advantage_Demo/Register/button_register'))

String weburl = WebUI.getUrl()

if (weburl == 'https://advantageonlineshopping.com/#/register') {
	CustomKeywords.'navigation.browserNavigation.browserForward'()
	
	WebUI.navigateToUrl('https://advantageonlineshopping.com/#/')
}


//Verify Element Visible
WebUI.verifyElementVisible(
	findTestObject('Object Repository/Advantage_Demo/Register/Div_Speaker')
)