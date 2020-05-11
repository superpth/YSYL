package com.PangTingHui.springboot01quick.ServiceImp;

import com.PangTingHui.springboot01quick.Service.IikesService;
import com.PangTingHui.springboot01quick.entities.VideoMakers;
import com.PangTingHui.springboot01quick.mapper.VideoMakerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class likesServiceImp implements IikesService {

    @Autowired
    VideoMakerMapper videoMakerMapper;

    @Override
    public void save(VideoMakers videoMakers) {
        //根据用户名查询数据
        VideoMakers videoMakers1 = new VideoMakers();
        videoMakers1.setUid(videoMakers.getUid());

        //执行查询
        List<VideoMakers> videoMakers2 = this.findVideoMakers(videoMakers1);

        //判断查询结果是否为空，如果查询结果为空，表示招聘信息数据不存在，或者已经更新了，需要新增或者更新数据库
        if(videoMakers2.size()==0){
            this.videoMakerMapper.insertVM(videoMakers);
        }
    }

    @Override
    public List<VideoMakers> findVideoMakers(VideoMakers videoMakers) {
        int count = videoMakerMapper.count();
        ArrayList<VideoMakers> videoMakers0=new ArrayList<>();
        ArrayList<VideoMakers> videoMakers1=new ArrayList<>();
        for(int i=0;i<=count;i++) {
            if(videoMakerMapper.getByID(i)!=null) {
                VideoMakers byID = videoMakerMapper.getByID(i);
                videoMakers1.add(byID);
                if (videoMakers.getUid().equals(byID.getUid())){
                    videoMakers0.add(videoMakers);
                }
            }
        }
        return videoMakers0;
    }

    @Override
    public List<VideoMakers> findAll() {
        int count = videoMakerMapper.count();
        ArrayList<VideoMakers> videoMakers0=new ArrayList<>();
        for(int i=0;i<=count;i++) {
            if(videoMakerMapper.getByID(i)!=null) {
                VideoMakers byID = videoMakerMapper.getByID(i);
                videoMakers0.add(byID);
            }
        }
        return videoMakers0;
    }
}
