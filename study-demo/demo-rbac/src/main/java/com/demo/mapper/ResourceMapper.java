package com.demo.mapper;

import com.demo.entity.Resource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ying.zhang01
 */
@Mapper
public interface ResourceMapper {
    int insertResource(Resource resource);
    int updateResource(Resource resource);
    int deleteResourceById(int resourceId);

    List<Resource> selectAllResources();
    //List<Resource> getResourceByUserId(int userId);
    Resource selectResourceById(int resourceId);

}
