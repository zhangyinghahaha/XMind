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
    Resource selectResourceById(int resourceId);

    List<Integer> selectResourceIdsByUserId(int userId);
    int insertResourcesByRoleId(int roleId, List<Integer> resourceIds);
    int deleteResourceIdsByRoleId(int roleId);
    List<Integer> selectResourceIdsByRoleId(int roleId);
    int deleteResourcesByType(String type);
}
