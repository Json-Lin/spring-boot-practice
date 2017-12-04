1、@ConfigurationProperties(prefix = "druid") 会将application.yml里面的配置自动注入到类中
2、当使用多数据源时必须通过@Primary指定主要的数据源，使用@ConfigurationProperties与此类似
3、多数据源如果使用默认的datasourceManager会产生跨库事物问题
4、@Bean bean名称默认为方法名称