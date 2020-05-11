package com.PangTingHui.springboot01quick.Webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

public class likesProcessor implements PageProcessor {
    //解析页面
    @Override
    public void process(Page page) {
        //解析page返回的数据，并把解析的结果放到ResultItems中
        Html html = page.getHtml();
        page.putField("likes",html.regex("累计获赞.{0,15}\""));
        page.putField("plays", html.regex("播放数总计为.{0,15}\""));
        page.putField("fans", html.regex("n-data n-fs\" title=\".{0,15}\""));
        page.putField("lastName", html.regex("<span id=\"h-name\">(.*?)</span>"));
    }

    private Site site=Site.me().setCharset("utf8");

    @Override
    public Site getSite() {
        return site;
    }
}
