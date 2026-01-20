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

WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.advantageonlineshopping.com/#/')

// Open login popup
WebUI.click(findTestObject('Object Repository/Advantage_Demo/Login/button_user'))

// Username
if (username != null && username != '') {
	WebUI.setText(findTestObject('Object Repository/Advantage_Demo/Login/field_username_password', ['field':'1']), username)
}

// Password
if (password != null && password != '') {
	WebUI.setText(findTestObject('Object Repository/Advantage_Demo/Login/field_username_password', ['field':'2']), password)
}

// Click Sign In
WebUI.click(findTestObject('Object Repository/Advantage_Demo/Login/button_sign_in'))

// Verification
if (expected == 'success') {

	WebUI.verifyElementPresent(
		findTestObject('Object Repository/Advantage_Demo/Login/label_logged_username'),
		10
	)

	WebUI.verifyElementText(
		findTestObject('Object Repository/Advantage_Demo/Login/label_logged_username'),
		username
	)

} else {

	WebUI.verifyElementPresent(
		findTestObject('Object Repository/Advantage_Demo/Login/label_login_error'),
		5
	)
}

WebUI.closeBrowser()