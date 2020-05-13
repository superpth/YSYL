package com.PangTingHui.springboot01quick.ServiceImp;

import com.PangTingHui.springboot01quick.Service.PageModelPipeline;
import com.PangTingHui.springboot01quick.entities.TagReturnData;
import com.PangTingHui.springboot01quick.entities.VideoTag;
import com.PangTingHui.springboot01quick.mapper.VideoTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class PageModelPipelineImp implements PageModelPipeline {

    @Autowired
    VideoTagMapper videoTagMapper;
    @Override
    public void add(VideoTag videoTag) {
            videoTagMapper.add(videoTag);
    }

    @Override
    public void delete() {
        videoTagMapper.delete();
    }

    @Override
    public ArrayList<TagReturnData> returnData() {
        return null;
    }
}
