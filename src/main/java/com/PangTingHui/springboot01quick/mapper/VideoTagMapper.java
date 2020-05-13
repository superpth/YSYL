package com.PangTingHui.springboot01quick.mapper;

import com.PangTingHui.springboot01quick.entities.TagReturnData;
import com.PangTingHui.springboot01quick.entities.VideoTag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VideoTagMapper {
    @Insert("Insert into VideoTag(tag1,tag2,tag3,tag4,tag5,tag6,tag7) values(#{tag1},#{tag2},#{tag3},#{tag4},#{tag5},#{tag6},#{tag7})")
    public int add(VideoTag videoTag);

    @Delete("Delete from VideoTag")
    public void delete();

    @Select("SELECT word FROM (SELECT tag1 as word,COUNT(1)  as num FROM (SELECT tag1 from VideoTag WHERE tag1 IS NOT NULL UNION ALL SELECT tag2 from VideoTag WHERE tag2 IS NOT NULL UNION ALL SELECT tag3 from VideoTag WHERE tag3 IS NOT NULL UNION ALL SELECT tag4 from VideoTag WHERE tag4 IS NOT NULL UNION ALL SELECT tag5 from VideoTag WHERE tag5 IS NOT NULL UNION ALL SELECT tag6 from VideoTag WHERE tag6 IS NOT NULL UNION ALL SELECT tag7 from VideoTag WHERE tag7 IS NOT NULL UNION ALL SELECT tag8 from VideoTag WHERE tag8 IS NOT NULL UNION ALL SELECT tag9 from VideoTag WHERE tag9 IS NOT NULL UNION ALL SELECT tag10 from VideoTag WHERE tag10 IS NOT NULL) AS t GROUP BY tag1) AS o ORDER BY num DESC limit #{uid},1;")
    public String wordcloud(Integer uid);

    @Select("SELECT num FROM (SELECT tag1 as word,COUNT(1)  as num FROM (SELECT tag1 from VideoTag WHERE tag1 IS NOT NULL UNION ALL SELECT tag2 from VideoTag WHERE tag2 IS NOT NULL UNION ALL SELECT tag3 from VideoTag WHERE tag3 IS NOT NULL UNION ALL SELECT tag4 from VideoTag WHERE tag4 IS NOT NULL UNION ALL SELECT tag5 from VideoTag WHERE tag5 IS NOT NULL UNION ALL SELECT tag6 from VideoTag WHERE tag6 IS NOT NULL UNION ALL SELECT tag7 from VideoTag WHERE tag7 IS NOT NULL UNION ALL SELECT tag8 from VideoTag WHERE tag8 IS NOT NULL UNION ALL SELECT tag9 from VideoTag WHERE tag9 IS NOT NULL UNION ALL SELECT tag10 from VideoTag WHERE tag10 IS NOT NULL) AS t GROUP BY tag1) AS o ORDER BY num DESC limit #{uid},1;")
    public Integer numcloud(Integer uid);
}