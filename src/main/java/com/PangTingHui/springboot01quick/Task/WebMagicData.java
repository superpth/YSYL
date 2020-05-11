package com.PangTingHui.springboot01quick.Task;


import com.PangTingHui.springboot01quick.Service.IikesService;
import com.PangTingHui.springboot01quick.mapper.VideoMakerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class WebMagicData implements Pipeline {

    @Autowired
    IikesService iikesService;

    @Autowired
    VideoMakerMapper videoMakerMapper;

    Integer a;
    public Integer r(Integer s){
        a=s;
        return s;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        //处理点赞数
        Object likes = resultItems.get("likes");
        String s = likes.toString();
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        String trim = m.replaceAll("").trim();
        int trim1=Integer.parseInt(trim);
        videoMakerMapper.updateLikes(a,trim1);
        System.out.println("likes"+trim1);

        //处理播放量
        Object plays = resultItems.get("plays");
        String s2 = plays.toString();
        String regEx2="[^0-9]";
        Pattern p2 = Pattern.compile(regEx2);
        Matcher m2 = p.matcher(s2);
        String trim2 = m2.replaceAll("").trim();
        int trim12=Integer.parseInt(trim2);
        videoMakerMapper.updatePlays(a,trim12);
        System.out.println("plays"+trim2);

        //处理粉丝数量
        Object fans=resultItems.get("fans");
        String s3 = fans.toString();
        String regEx3="[^0-9]";
        Pattern p3 = Pattern.compile(regEx3);
        Matcher m3 = p.matcher(s3);
        String trim3 = m3.replaceAll("").trim();
        int trim13=Integer.parseInt(trim3);
        videoMakerMapper.updateFans(a,trim13);
        System.out.println("fans"+trim3);

        //处理用户名
        Object lastName = resultItems.get("lastName");
        String s1 = lastName.toString();
        videoMakerMapper.updateLastName(a,s1);
        System.out.println("lastName："+lastName);
    }
}
