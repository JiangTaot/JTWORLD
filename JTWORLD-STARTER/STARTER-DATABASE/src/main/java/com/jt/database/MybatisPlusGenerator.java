package com.jt.database;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.fill.Column;

public class MybatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称")).fileOverride().outputDir(filepath))
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名")))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(scanner.apply("请输入表名，多个表名用,隔开"))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
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
                .execute();
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
     */
    private static final String filepath = "D:\\project\\JTWORLD\\JTWORLD-STARTER\\STARTER-DATABASE\\src\\main\\java\\com\\jt\\database";

}
