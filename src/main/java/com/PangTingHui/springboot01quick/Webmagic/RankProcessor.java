package com.PangTingHui.springboot01quick.Webmagic;

import com.PangTingHui.SeleniumDownloader;
import com.PangTingHui.springboot01quick.Task.RankTagData;
import com.PangTingHui.springboot01quick.Task.WebMagicData;
import com.PangTingHui.springboot01quick.entities.VideoTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.example.GithubRepo;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;

@Component
public class RankProcessor implements PageProcessor {
    //解析页面
    @Override
    public void process(Page page) {
        //解析page返回的数据，并把解析的结果放到ResultItems中
        Html html = page.getHtml();
        page.addTargetRequests(page.getHtml().xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div[2]/div[3]/ul").links().regex("https://www.bilibili.com/video/BV.*").all());
        //page.putField("tag1",html.xpath("//*[@id=\"v_tag\"]/ul/li[1]/a"));
        VideoTag videoTag = new VideoTag();
        videoTag.setTag1(html.xpath("//*[@id=\"v_tag\"]/ul/li[1]/a").regex(">(.*?)<").toString());
        videoTag.setTag2(html.xpath("//*[@id=\"v_tag\"]/ul/li[2]/a").regex(">(.*?)<").toString());
        videoTag.setTag3(html.xpath("//*[@id=\"v_tag\"]/ul/li[3]/a").regex(">(.*?)<").toString());
        videoTag.setTag4(html.xpath("//*[@id=\"v_tag\"]/ul/li[4]/a").regex(">(.*?)<").toString());
        videoTag.setTag5(html.xpath("//*[@id=\"v_tag\"]/ul/li[5]/a").regex(">(.*?)<").toString());
        videoTag.setTag6(html.xpath("//*[@id=\"v_tag\"]/ul/li[6]/a").regex(">(.*?)<").toString());
        videoTag.setTag7(html.xpath("//*[@id=\"v_tag\"]/ul/li[7]/a").regex(">(.*?)<").toString());
        videoTag.setTag8(html.xpath("//*[@id=\"v_tag\"]/ul/li[8]/a").regex(">(.*?)<").toString());
        videoTag.setTag9(html.xpath("//*[@id=\"v_tag\"]/ul/li[9]/a").regex(">(.*?)<").toString());
        videoTag.setTag10(html.xpath("//*[@id=\"v_tag\"]/ul/li[10]/a").regex(">(.*?)<").toString());
        page.putField("videoTag", videoTag);
    }
    //爬取目标网页地址
    String url;
    public String setS(String s){
        //url="https://api.bilibili.com/x/space/top/arc?vmid="+s+"&jsonp=jsonp";
        url="https://www.bilibili.com/";
        return url;
    }

    private Site site=Site.me().setCharset("utf8").setRetryTimes(3);

    @Override
    public Site getSite() {
        return site;
    }


    @Autowired
    RankTagData rankTagData;
    //定时启动，当任务启动后等待1秒，每隔10秒执行一次

    public void process(){
        Spider.create(new RankProcessor())
                .addUrl("https://www.bilibili.com/ranking/all/1/0/3")
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10000000)))
                .addPipeline(rankTagData)
                .thread(20).run();
    }
}
