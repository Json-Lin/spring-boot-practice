1、jsp项目需要引入tomcat-embed-jasper和jstl
2、jsp web项目需要发布在Tomcat中以war包运行,直接打jar包，web-inf目录下的资源文件不会打包在jar包中,会使view无法访问.
3、war在Tomcat容器里面运行容器已经包含Tomcat相关的包,发布到容器需将Tomcat和jasper的scope设置为： <scope>provided</scope>
4、springboot会默认加载application.properties文件.
   server.port 端口
   spring.mvc.view.prefix 资源文件前缀
   spring.mvc.view.suffix 资源文件后缀