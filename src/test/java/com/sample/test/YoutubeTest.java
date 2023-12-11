package com.sample.test;

import com.sample.PageManager;
import org.testng.annotations.Test;

public class YoutubeTest extends BaseTest{

    //Test to scroll down till "Watch" button is visible and click on Watch button on Youtube home page
    @Test
    public void TestYoutube(){
        PageManager pageManager = new PageManager(getDriver());
        pageManager.getYoutubePage().scrollTillWatch();
        pageManager.getYoutubePage().clickwatch();
    }

    //Test to scroll down till "Shorts" are visible and then swipe right till Shorts with text containing "Aise dost" is visible and click on it on Youtube home page
    @Test
    public void TestYoutube2() throws InterruptedException {
        PageManager pageManager = new PageManager(getDriver());
        Thread.sleep(3000);
        pageManager.getYoutubePage().scrollTillShortsWidget();
        pageManager.getYoutubePage().swipeToShortTitle("Aise dost");
        pageManager.getYoutubePage().playShortTitle("Aise dost");
    }
}
