package com.lls;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.RemoteTouchScreen;

import bsh.Capabilities;

public class MyDriverFire extends FirefoxDriver implements HasTouchScreen{
	private RemoteTouchScreen touch;
	public MyDriverFire(FirefoxProfile profile) {
        super(profile);
        touch = new RemoteTouchScreen(getExecuteMethod());
    }
	@Override
	public TouchScreen getTouch() {
		// TODO Auto-generated method stub
		return touch;
	}

	

}
