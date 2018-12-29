# spring boot整合redis
##1. 在pom.xml加入依赖spring-boot-starter-data-redis
##2. 在配置文件中配置相关参数
##3. spring boot有两种连接redis的方式一种是：jedis；一种是lettuce
##4. spring boot默认使用lettuce连接redis
##5. 如果使用 Jedis 替代  Lettuce 则需要排除lettuce,并引入jedis
##6. 要使用连接池的时候需要引入commons-pool2
jedis：是Redis的Java实现客户端，提供了比较全面的Redis命令的支持，
lettuce：高级Redis客户端，用于线程安全同步，异步和响应使用，支持集群，Sentinel，管道和编码器。
Jedis 在实现上是直接连接 Redis-Server，在多个线程间共享一个 Jedis 实例时是线程不安全的，如果想要在多线程场景下使用 Jedis，需要使用连接池，每个线程都使用自己的 Jedis 实例，当连接数量增多时，会消耗较多的物理资源。

与 Jedis 相比，Lettuce 则完全克服了其线程不安全的缺点：Lettuce 是一个可伸缩的线程安全的 Redis 客户端，支持同步、异步和响应式模式。多个线程可以共享一个连接实例，而不必担心多线程并发问题。它基于优秀 Netty NIO 框架构建，支持 Redis 的高级功能，如 Sentinel，集群，流水线，自动重新连接和 Redis 数据模型。

lettuce既然是线程安全的那为什么也有连接池的配置呢？
lettuce有如下几种情况你不能在线程之间复用连接：
1. 请求批量下发，即禁止调用命令后立即flush
2. 使用`BLPOP`这种阻塞命令
3. 事务操作
4. 有多个数据库的情况

所以LettuceConnectionFactory在使用阻塞命令或者事务操作的时候才会使用到连接池
