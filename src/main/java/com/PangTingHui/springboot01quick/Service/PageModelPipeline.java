package com.PangTingHui.springboot01quick.Service;

import com.PangTingHui.springboot01quick.entities.TagReturnData;
import com.PangTingHui.springboot01quick.entities.VideoTag;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface PageModelPipeline{
    public void add(VideoTag videoTag);
    public void delete();
    public ArrayList<TagReturnData> returnData();
}
