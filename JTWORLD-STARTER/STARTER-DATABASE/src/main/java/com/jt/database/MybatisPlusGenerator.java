package com.jt.database;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MybatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称")).fileOverride().outputDir(filepath))
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名")))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个表名用,隔开？所有输入 all")))
                        .serviceBuilder().formatServiceFileName("%sService").formatServiceImplFileName("%sServiceImpl")
                        .mapperBuilder().enableMapperAnnotation().formatMapperFileName("%sMapper").formatXmlFileName("%sMapper")
                        .entityBuilder().enableLombok().addTableFills(new Column("create_time", FieldFill.INSERT))
                        .build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker 或 Enjoy
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                   .templateEngine(new EnjoyTemplateEngine())
                 */
                // 不生成controller
                .templateConfig(builder -> builder.controller(""))
                .execute();
    }

    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

    /**
     * 数据源配置
     */
    private static final String host = "127.0.0.1:3306";
    private static final String database = "jt_world";
    private static final String username = "root";
    private static final String password = "LoL@20201112";
    private static final String url = "jdbc:mysql://" + host + "/" + database + "?characterEncoding=utf-8&autoReconnect=true&createDatabaseIfNotExist=true&useSSL=false&failOverReadOnly=false&serverTimezone=Asia/Shanghai";
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder(url, username, password);

    /**
     * 项目地址配置
     *
     * @descript 包名  选择全量包名  com.jt.admin
     * @since filepath  选择到模块下 /java
     */
    private static final String filepath = "D:\\project\\JTWORLD\\JTWORLD-ADMIN\\src\\main\\java";

}
