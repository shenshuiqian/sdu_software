package cn.liantao.lbook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/images/**")
                .addResourceLocations("file:E:/work/大三下/软件工程/sud/sdu_software/sdu_book_backend/src/main/java/cn/liantao/lbook/images/"); // 本地图片文件夹路径
    }
}


//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/api/images/**")
//                .addResourceLocations("file:D:/我的/软件工程/实验/sdu_software/L-book-server/src/main/java/cn/liantao/lbook/images/"); // 本地图片文件夹路径
//    }