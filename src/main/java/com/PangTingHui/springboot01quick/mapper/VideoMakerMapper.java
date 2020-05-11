package com.PangTingHui.springboot01quick.mapper;

import com.PangTingHui.springboot01quick.entities.VideoMakers;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VideoMakerMapper {
    @Select("select * from likes where id=#{id}")
    public VideoMakers getByID(Integer id);

    @Delete("delete from likes where id=#{id}")
    public int deleteById(Integer id);

    @Insert("insert into likes(id,uid) values (#{id},#{uid})")
    public int insertVM(VideoMakers videoMakers);

    @Update("update likes set id=#{id},lastName=#{lastName},fansCount=#{fansCount},playCount=#{playCount},likesCount=#{likesCount},uid=#{uid} where id=#{id}")
    public int updateVM(VideoMakers videoMakers);

    @Select("select max(id) from likes")
    public int count();

    @Update("update likes set likesCount=#{likesCount} where id=#{id}")
    public int updateLikes(Integer id,Integer likesCount);

    @Update("update likes set playCount=#{playCount} where id=#{id}")
    public int updatePlays(Integer id,Integer playCount);

    @Update("update likes set fansCount=#{fansCount} where id=#{id}")
    public int updateFans(Integer id,Integer fansCount);

    @Update("update likes set lastName=#{lastName} where id=#{id}")
    public int updateLastName(Integer id,String lastName);
}
