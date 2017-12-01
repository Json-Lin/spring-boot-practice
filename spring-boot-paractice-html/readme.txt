1、jsp需要进行编译，而html等模板文件不需要。
2、springboot可以访问resources/static目录下的资源文件。resources/static默认的资源访问路径为/
   也可以自定义资源文件访问路径。eg:
   资源文件路径为: resources/static/dist/        那么要访问/dist目录下的资源文件，则默认的访问路径就是/dist
   要更改访问路径/dist为/，只需要添加配置: spring.resources.static-locations=classpath:/static/dist/
3、建议前后端分离，springboot只提供restful接口，前端单独一个工程。
4、<plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
   </plugin>
   该插件能将springboot工程打包为一个可以执行的jar包。可直接运行不需要外部容器(使用内嵌的Tomcat容器)。所以springboot更适合做微服务。

