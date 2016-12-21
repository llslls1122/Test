package com.lls;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.RemoteTouchScreen;

import bsh.Capabilities;

import com.opera.core.systems.mobile.MobileDevices;

public class MyDriver extends ChromeDriver implements HasTouchScreen{
	private RemoteTouchScreen touch;
	public MyDriver(ChromeOptions capabilities) {
        super(capabilities);
        touch = new RemoteTouchScreen(getExecuteMethod());
    }
	@Override
	public TouchScreen getTouch() {
		// TODO Auto-generated method stub
		return touch;
	}

	

}
