package com.PangTingHui.springboot01quick.Task;

import com.PangTingHui.springboot01quick.Service.PageModelPipeline;
import com.PangTingHui.springboot01quick.entities.VideoTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;


@Component
public class RankTagData implements Pipeline {
    @Autowired
    PageModelPipeline pageModelPipeline;

    @Override
    public void process(ResultItems resultItems, Task task) {
        VideoTag tag1 = resultItems.get("videoTag");
        if (tag1 != null) {
            pageModelPipeline.add(tag1);
        }
    }
}
