package com.PangTingHui.springboot01quick.Webmagic;

import jdk.swing.interop.SwingInterOpUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class TestProcessor implements PageProcessor {
        // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
        private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

        @Override
        // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
        public void process(Page page) {
            // 部分二：定义如何抽取页面信息，并保存下来


            // 部分三：从页面发现后续的url地址来抓取
            page.addTargetRequests(page.getHtml().all());
        }

        @Override
        public Site getSite() {
            return site;
        }

        public static void main(String[] args) {

            Spider.create(new TestProcessor())
                    //从"https://github.com/code4craft"开始抓
                    .addUrl("https://api.bilibili.com/x/relation/stat?vmid=546195&jsonp=jsonp")
                    //开启5个线程抓取
                    .thread(5)
                    //启动爬虫
                    .run();
        }

}
