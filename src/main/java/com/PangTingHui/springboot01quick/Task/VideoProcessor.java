package com.PangTingHui.springboot01quick.Task;

import com.PangTingHui.SeleniumDownloader;
import com.PangTingHui.springboot01quick.Webmagic.likesProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

@Component
public class VideoProcessor{

    //Selenium-chrome-driver配置文件
    String url1="C:\\Program Files (x86)\\Google\\Chrome\\Application\\config.ini";
    //chrome-diver启动程序
    String url2="C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";

    //爬取目标网页地址
    String url;
    public String setS(String s){
        url="https://space.bilibili.com/"+s;
        return url;
    }

    @Autowired
    WebMagicData webMagicData;
    //定时启动，当任务启动后等待1秒，每隔10秒执行一次
    @Scheduled(initialDelay = 1000,fixedDelay = 10000)
    public void process(){
        System.setProperty("selenuim_config", url1);
        Spider.create(new likesProcessor())
                .addUrl(url)
                .setDownloader(new SeleniumDownloader(url2))
                .addPipeline(webMagicData).thread(5).run();
    }
}
