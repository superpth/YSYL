package com.PangTingHui.springboot01quick.Service;

import com.PangTingHui.springboot01quick.entities.VideoMakers;

import java.util.Collection;
import java.util.List;

public interface IikesService {
    /**
     *
     * 保存用户信息
     */
    public void save(VideoMakers videoMakers);

    /**
     * 根据条件查询用户信息
     */
    public Collection<VideoMakers> findVideoMakers(VideoMakers videoMakers);

    /**
     *列表查询所有用户信息
     */
    public List<VideoMakers> findAll();
}
