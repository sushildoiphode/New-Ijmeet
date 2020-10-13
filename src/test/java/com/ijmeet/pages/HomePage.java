package com.ijmeet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ijmeet.util.Constant;

public class HomePage {
	public HomePage() {
		PageFactory.initElements(Constant.driver, this);
	}
	
}
