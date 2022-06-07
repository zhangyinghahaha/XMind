package com.demo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ying.zhang01
 * @date 2022/5/28
 */
@Configuration
@MapperScan(basePackages = "com.demo.**.mapper")
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加多租户插件
        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(customTenantLineHandler()));
        // 添加分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    private TenantLineHandler customTenantLineHandler() {
        return new TenantLineHandler() {
            /**
             * 一般是从当前上下文中取出一个租户id
             * @return 租户Id
             */
            @Override
            public Expression getTenantId() {
                return new LongValue(1L);
            }

            /**
             * 租户Id的列名, 通常封装到一个配置类中(如TenantConfig)
             * @return 租户id的列名
             */
            @Override
            public String getTenantIdColumn() {
                return "manager_id";
            }

            /**
             * 根据表名判断是否忽略拼接多租户条件
             * @param tableName 表名
             * @return 是否忽略, true:表示忽略，false:需要解析并拼接多租户条件
             */
            @Override
            public boolean ignoreTable(String tableName) {
                return !"advanced_user".equals(tableName);
            }
        };
    }
}
