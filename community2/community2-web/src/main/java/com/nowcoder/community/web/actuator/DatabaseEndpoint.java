package com.nowcoder.community.web.actuator;

import com.nowcoder.community.common.util.CommunityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ying.zhang01
 */
@Component
@Endpoint(id = "database")
public class DatabaseEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseEndpoint.class);

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @ReadOperation
    public String checkConnection() {
        try (
                Connection connection = dataSource.getConnection();
                ) {
            return CommunityUtil.getJsonString(0, "获取链接成功");
        } catch (SQLException e) {
            return CommunityUtil.getJsonString(1, "获取链接失败");
        }
    }
}
