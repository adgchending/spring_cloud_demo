package cn.itbluebox.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//UserImportSelector接口继承ImportSelector,他和ImportSelector的区别在于装载bean的时机上,UserImportSelector需要等所有的@Configuration都执行完毕后才会进行装载
public class UserImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //获取配置类的名称
        return new String[]{UserConfiguration.class.getName()};//自动找到对应的类将其加载到Spring容器当中
    }

}

