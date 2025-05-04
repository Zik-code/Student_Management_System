//package edu.cqnu.myproject3.config;
//
//import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
//import org.springframework.context.annotation.Configuration;
//@Configuration
//public class MpConfig {
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        // 1. 创建拦截器
//        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
//        // 2. 创建分页插件，指定数据库类型为MySQL
//        PaginationInnerInterceptor page = new PaginationInnerInterceptor(MySqlDialect.INSTANCE);
//        // 3. 添加分页插件
//        mybatisPlusInterceptor.addInnerInterceptor(page);
//        // 4. 返回
//        return mybatisPlusInterceptor;
//    }
//}
