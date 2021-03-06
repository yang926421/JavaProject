redis整理

## Redis

### 五大基本数据类型

![1599551007945](redis%E6%95%B4%E7%90%86.assets/1599551007945.png)

```
1. 概念： redis是一款高性能的NOSQL系列的非关系型数据库
```

```
	1.1.什么是NOSQL
		NoSQL(NoSQL = Not Only SQL)，意即“不仅仅是SQL”，是一项全新的数据库理念，泛指非关系型的数据库。
		随着互联网web2.0网站的兴起，传统的关系数据库在应付web2.0网站，特别是超大规模和高并发的SNS类型的web2.0纯动态网站已经显得力不从心，暴露了很多难以克服的问题，而非关系型的数据库则由于其本身的特点得到了非常迅速的发展。NoSQL数据库的产生就是为了解决大规模数据集合多重数据种类带来的挑战，尤其是大数据应用难题。

		1.1.1.	NOSQL和关系型数据库比较
			优点：
				1）成本：nosql数据库简单易部署，基本都是开源软件，不需要像使用oracle那样花费大量成本购买使用，相比关系型数据库价格便宜。
				2）查询速度：nosql数据库将数据存储于缓存之中，关系型数据库将数据存储在硬盘中，自然查询速度远不及nosql数据库。
				3）存储数据的格式：nosql的存储格式是key,value形式、文档形式、图片形式等等，所以可以存储基础类型以及对象或者是集合等各种格式，而数据库则只支持基础类型。
				4）扩展性：关系型数据库有类似join这样的多表查询机制的限制导致扩展很艰难。

			缺点：
				1）维护的工具和资料有限，因为nosql是属于新的技术，不能和关系型数据库10几年的技术同日而语。
				2）不提供对sql的支持，如果不支持sql这样的工业标准，将产生一定用户的学习和使用成本。
				3）不提供关系型数据库对事务的处理。

		1.1.2.	非关系型数据库的优势：
			1）性能NOSQL是基于键值对的，可以想象成表中的主键和值的对应关系，而且不需要经过SQL层的解析，所以性能非常高。
			2）可扩展性同样也是因为基于键值对，数据之间没有耦合性，所以非常容易水平扩展。

		1.1.3.	关系型数据库的优势：
			1）复杂查询可以用SQL语句方便的在一个表以及多个表之间做非常复杂的数据查询。
			2）事务支持使得对于安全性能很高的数据访问要求得以实现。对于这两类数据库，对方的优势就是自己的弱势，反之亦然。

		1.1.4.	总结
			关系型数据库与NoSQL数据库并非对立而是互补的关系，即通常情况下使用关系型数据库，在适合使用NoSQL的时候使用NoSQL数据库，
			让NoSQL数据库对关系型数据库的不足进行弥补。
			一般会将数据存储在关系型数据库中，在nosql数据库中备份存储关系型数据库的数据

	1.2.主流的NOSQL产品
		•	键值(Key-Value)存储数据库
				相关产品： Tokyo Cabinet/Tyrant、Redis、Voldemort、Berkeley DB
				典型应用： 内容缓存，主要用于处理大量数据的高访问负载。 
				数据模型： 一系列键值对
				优势： 快速查询
				劣势： 存储的数据缺少结构化
		•	列存储数据库
				相关产品：Cassandra, HBase, Riak
				典型应用：分布式的文件系统
				数据模型：以列簇式存储，将同一列数据存在一起
				优势：查找速度快，可扩展性强，更容易进行分布式扩展
				劣势：功能相对局限
		•	文档型数据库
				相关产品：CouchDB、MongoDB
				典型应用：Web应用（与Key-Value类似，Value是结构化的）
				数据模型： 一系列键值对
				优势：数据结构要求不严格
				劣势： 查询性能不高，而且缺乏统一的查询语法
		•	图形(Graph)数据库
				相关数据库：Neo4J、InfoGrid、Infinite Graph
				典型应用：社交网络
				数据模型：图结构
				优势：利用图结构相关算法。
				劣势：需要对整个图做计算才能得出结果，不容易做分布式的集群方案。
	1.3 什么是Redis
		Redis是用C语言开发的一个开源的高性能键值对（key-value）数据库，官方提供测试数据，50个并发执行100000个请求,读的速度是110000次/s,写的速度是81000次/s ，且Redis通过提供多种键值数据类型来适应不同场景下的存储需求，目前为止Redis支持的键值数据类型如下：
			1) 字符串类型 string
			2) 哈希类型 hash
			3) 列表类型 list
			4) 集合类型 set
			5) 有序集合类型 sortedset
		1.3.1 redis的应用场景
			•	缓存（数据查询、短连接、新闻内容、商品内容等等）
			•	聊天室的在线好友列表
			•	任务队列。（秒杀、抢购、12306等等）
			•	应用排行榜
			•	网站访问统计
			•	数据过期处理（可以精确到毫秒)
			•	分布式集群架构中的session分离
```

```
2. 下载安装
	1. 官网：https://redis.io
	2. 中文网：http://www.redis.net.cn/
	3. 解压直接可以使用：
		* redis.windows.conf：配置文件
		* redis-cli.exe：redis的客户端
		* redis-server.exe：redis服务器端
	
3. 命令操作
	1. redis的数据结构：
		* redis存储的是：key,value格式的数据，其中key都是字符串，value有5种不同的数据结构
			* value的数据结构：
				1) 字符串类型 string
				2) 哈希类型 hash ： map格式  
				3) 列表类型 list ： linkedlist格式。支持重复元素
				4) 集合类型 set  ： 不允许重复元素
				5) 有序集合类型 sortedset：不允许重复元素，且元素有顺序
	
	2. 字符串类型 string
		1. 存储： set key value
			127.0.0.1:6379> set username zhangsan
			OK
		2. 获取： get key
			127.0.0.1:6379> get username
			"zhangsan"
		3. 删除： del key
			127.0.0.1:6379> del age
			(integer) 1
	3. 哈希类型 hash
		1. 存储： hset key field value
			127.0.0.1:6379> hset myhash username lisi
			(integer) 1
			127.0.0.1:6379> hset myhash password 123
			(integer) 1
		2. 获取： 
			* hget key field: 获取指定的field对应的值
				127.0.0.1:6379> hget myhash username
				"lisi"
			* hgetall key：获取所有的field和value
				127.0.0.1:6379> hgetall myhash
				1) "username"
				2) "lisi"
				3) "password"
				4) "123"
				
		3. 删除： hdel key field
			127.0.0.1:6379> hdel myhash username
			(integer) 1
	
	4. 列表类型 list:可以添加一个元素到列表的头部（左边）或者尾部（右边）
		1. 添加：
			1. lpush key value: 将元素加入列表左表
				
			2. rpush key value：将元素加入列表右边
				
				127.0.0.1:6379> lpush myList a
				(integer) 1
				127.0.0.1:6379> lpush myList b
				(integer) 2
				127.0.0.1:6379> rpush myList c
				(integer) 3
		2. 获取：
			* lrange key start end ：范围获取
				127.0.0.1:6379> lrange myList 0 -1
				1) "b"
				2) "a"
				3) "c"
		3. 删除：
			* lpop key： 删除列表最左边的元素，并将元素返回
			* rpop key： 删除列表最右边的元素，并将元素返回
		4.通过下标获取值
			* lindex mylist 0  获取mylist  0 位置上 的值
			* lindex mylist 1  获取mylist  1 位置上 的值
		5.获取列表的长度
			* llen mylist 返回列表的长度
```

```
	5. 集合类型 set ： 不允许重复元素
		1. 存储：sadd key value
			127.0.0.1:6379> sadd myset a
			(integer) 1
			127.0.0.1:6379> sadd myset a
			(integer) 0
		2. 获取：smembers key:获取set集合中所有元素
			127.0.0.1:6379> smembers myset
			1) "a"
		3. 删除：srem key value:删除set集合中的某个元素	
			127.0.0.1:6379> srem myset a
			(integer) 1
	6. 有序集合类型 sortedset：不允许重复元素，且元素有顺序.每个元素都会关联一个double类型的分数。redis正是通过分数来为集合中的成员进行从小到大的排序。

		1. 存储：zadd key score value
			127.0.0.1:6379> zadd mysort 60 zhangsan
			(integer) 1
			127.0.0.1:6379> zadd mysort 50 lisi
			(integer) 1
			127.0.0.1:6379> zadd mysort 80 wangwu
			(integer) 1
		2. 获取：zrange key start end [withscores]
			127.0.0.1:6379> zrange mysort 0 -1
			1) "lisi"
			2) "zhangsan"
			3) "wangwu"

			127.0.0.1:6379> zrange mysort 0 -1 withscores
			1) "zhangsan"
			2) "60"
			3) "wangwu"
			4) "80"
			5) "lisi"
			6) "500"
		3. 删除：zrem key value
			127.0.0.1:6379> zrem mysort lisi
			(integer) 1

	7. 通用命令
		1. keys * : 查询所有的键
		2. type key ： 获取键对应的value的类型
		3. del key：删除指定的key value
```

```
4. 持久化
	1. redis是一个内存数据库，当redis服务器重启，获取电脑重启，数据会丢失，我们可以将redis内存中的数据持久化保存到硬盘的文件中。
	2. redis持久化机制：
		1. RDB：默认方式，不需要进行配置，默认就使用这种机制
			* 在一定的间隔时间中，检测key的变化情况，然后持久化数据
			1. 编辑redis.windwos.conf文件
				#   after 900 sec (15 min) if at least 1 key changed
				save 900 1
				#   after 300 sec (5 min) if at least 10 keys changed
				save 300 10
				#   after 60 sec if at least 10000 keys changed
				save 60 10000
				
			2. 重新启动redis服务器，并指定配置文件名称
				D:\JavaWeb2018\day23_redis\资料\redis\windows-64\redis-2.8.9>redis-server.exe redis.windows.conf	
			
		2. AOF：日志记录的方式，可以记录每一条命令的操作。可以每一次命令操作后，持久化数据
			1. 编辑redis.windwos.conf文件
				appendonly no（关闭aof） --> appendonly yes （开启aof）
				
				# appendfsync always ： 每一次操作都进行持久化
				appendfsync everysec ： 每隔一秒进行一次持久化
				# appendfsync no	 ： 不进行持久化

5. Java客户端 Jedis
	* Jedis: 一款java操作redis数据库的工具.
	* 使用步骤：
		1. 下载jedis的jar包
		2. 使用
			//1. 获取连接
    		Jedis jedis = new Jedis("localhost",6379);
   			//2. 操作
   			jedis.set("username","zhangsan");
    		//3. 关闭连接
    		jedis.close();
```

​		
		* Jedis操作各种redis中的数据结构
​			1) 字符串类型 string
​				set
​				get
​				

```
			 //1. 获取连接
	        Jedis jedis = new Jedis();//如果使用空参构造，默认值 "localhost",6379端口
	        //2. 操作
	        //存储
	        jedis.set("username","zhangsan");
	        //获取
	        String username = jedis.get("username");
	        System.out.println(username);
	
	        //可以使用setex()方法存储可以指定过期时间的 key value
	        jedis.setex("activecode",20,"hehe");//将activecode：hehe键值对存入redis，并且20秒后自动删除该键值对
	
	        //3. 关闭连接
	        jedis.close();

		2) 哈希类型 hash ： map格式  
			hset
			hget
			hgetAll
			//1. 获取连接
	        Jedis jedis = new Jedis();//如果使用空参构造，默认值 "localhost",6379端口
	        //2. 操作
	        // 存储hash
	        jedis.hset("user","name","lisi");
	        jedis.hset("user","age","23");
	        jedis.hset("user","gender","female");
	
	        // 获取hash
	        String name = jedis.hget("user", "name");
	        System.out.println(name);
```

​		
​		        // 获取hash的所有map中的数据
​		        Map<String, String> user = jedis.hgetAll("user");
​		

```
	        // keyset
	        Set<String> keySet = user.keySet();
	        for (String key : keySet) {
	            //获取value
	            String value = user.get(key);
	            System.out.println(key + ":" + value);
	        }
	
	        //3. 关闭连接
	        jedis.close();
```

```
		3) 列表类型 list ： linkedlist格式。支持重复元素
			lpush / rpush
			lpop / rpop
			lrange start end : 范围获取
			
			 //1. 获取连接
	        Jedis jedis = new Jedis();//如果使用空参构造，默认值 "localhost",6379端口
	        //2. 操作
	        // list 存储
	        jedis.lpush("mylist","a","b","c");//从左边存
	        jedis.rpush("mylist","a","b","c");//从右边存
	
	        // list 范围获取
	        List<String> mylist = jedis.lrange("mylist", 0, -1);
	        System.out.println(mylist);
	        
	        // list 弹出
	        String element1 = jedis.lpop("mylist");//c
	        System.out.println(element1);
	
	        String element2 = jedis.rpop("mylist");//c
	        System.out.println(element2);
	
	        // list 范围获取
	        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
	        System.out.println(mylist2);
	
	        //3. 关闭连接
	        jedis.close();
```

```
		4) 集合类型 set  ： 不允许重复元素
			sadd
			smembers:获取所有元素

			//1. 获取连接
	        Jedis jedis = new Jedis();//如果使用空参构造，默认值 "localhost",6379端口
	        //2. 操作
```

​		
​		        // set 存储
​		        jedis.sadd("myset","java","php","c++");
​		

```
	        // set 获取
	        Set<String> myset = jedis.smembers("myset");
	        System.out.println(myset);
	
	        //3. 关闭连接
	        jedis.close();
		5) 有序集合类型 sortedset：不允许重复元素，且元素有顺序
			zadd
			zrange

			//1. 获取连接
	        Jedis jedis = new Jedis();//如果使用空参构造，默认值 "localhost",6379端口
	        //2. 操作
	        // sortedset 存储
	        jedis.zadd("mysortedset",3,"亚瑟");
	        jedis.zadd("mysortedset",30,"后裔");
	        jedis.zadd("mysortedset",55,"孙悟空");
	
	        // sortedset 获取
	        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
	
	        System.out.println(mysortedset);
```

​		
​		        //3. 关闭连接
​		        jedis.close();

​		
​		* jedis连接池： JedisPool
​			* 使用：
​				1. 创建JedisPool连接池对象
​				2. 调用方法 getResource()方法获取Jedis连接
​					//0.创建一个配置对象
​			        JedisPoolConfig config = new JedisPoolConfig();
​			        config.setMaxTotal(50);
​			        config.setMaxIdle(10);
​			

```
		        //1.创建Jedis连接池对象
		        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
		
		        //2.获取连接
		        Jedis jedis = jedisPool.getResource();
		        //3. 使用
		        jedis.set("hehe","heihei");
```

​			
​			        //4. 关闭 归还到连接池中
​			        jedis.close();
​			

```
		* 连接池工具类
			public class JedisPoolUtils {

			    private static JedisPool jedisPool;
			
			    static{
			        //读取配置文件
			        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
			        //创建Properties对象
			        Properties pro = new Properties();
			        //关联文件
			        try {
			            pro.load(is);
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			        //获取数据，设置到JedisPoolConfig中
			        JedisPoolConfig config = new JedisPoolConfig();
			        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
			        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));
			
			        //初始化JedisPool
			        jedisPool = new JedisPool(config,pro.getProperty("host"),Integer.parseInt(pro.getProperty("port")));
```

​		![1599635336258](redis%E6%95%B4%E7%90%86.assets/1599635336258.png)		改为后台默认启动

![1599635556076](redis%E6%95%B4%E7%90%86.assets/1599635556076.png)				
				    }

​				
​				    /**
​				     * 获取连接方法
​				     */
​				    public static Jedis getJedis(){
​				        return jedisPool.getResource();
​				    }
​				}



## 案例：

```
案例需求：
	1. 提供index.html页面，页面中有一个省份 下拉列表
	2. 当 页面加载完成后 发送ajax请求，加载所有省份
```

```
* 注意：使用redis缓存一些不经常发生变化的数据。
	* 数据库的数据一旦发生改变，则需要更新缓存。
		* 数据库的表执行 增删改的相关操作，需要将redis缓存数据情况，再次存入
		* 在service对应的增删改方法中，将redis数据删除。
```





![1.关系型和非关系型数据库比较](redis%E6%95%B4%E7%90%86.assets/1.%E5%85%B3%E7%B3%BB%E5%9E%8B%E5%92%8C%E9%9D%9E%E5%85%B3%E7%B3%BB%E5%9E%8B%E6%95%B0%E6%8D%AE%E5%BA%93%E6%AF%94%E8%BE%83.bmp)





![2.redis数据结构](redis%E6%95%B4%E7%90%86.assets/2.redis%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84.bmp)



![3.列表list数据结构](C:/Users/Administrator/Desktop/一些文件/黑马java web/课程资料/day23_redis/day23_redis/笔记/3.列表list数据结构.bmp)	

![4.案例](redis%E6%95%B4%E7%90%86.assets/4.%E6%A1%88%E4%BE%8B.bmp)

# redis强化知识

redis默认16个数据库,默认使用第0个数据库

select  选择切换数据库

![1599638845440](redis%E6%95%B4%E7%90%86.assets/1599638845440.png)![1599638899314](redis%E6%95%B4%E7%90%86.assets/1599638899314.png)



## redis的使用场景

用户的cookie,session都可以保存在redis数据库中,设置时长,过期时间

exists key   键是否存在

### 设置键的过期时间

expire key time   expire name 30  设置过期时间30s

ttl  key   (time to live)  查看键的剩余有效时间

type key  查看当前key的类型

append key value  给已经存在的string的类型key添加值,如果当前key不存在,就相当于setkey

### 设置值的自增和自减incr  decr

### (使用场景,比如一篇文章的浏览量,朋友圈的点赞数,微博的点赞数)

![1599640901630](redis%E6%95%B4%E7%90%86.assets/1599640901630.png)

按照步长来增加减少

incrby key  num

decrby key num  给这个key增减num



### 截取字符串

![1599641251974](redis%E6%95%B4%E7%90%86.assets/1599641251974.png)

### 替换字符串

![1599641358349](redis%E6%95%B4%E7%90%86.assets/1599641358349.png)



### setex   set with expire 设置key value过期时间

![1599642035449](redis%E6%95%B4%E7%90%86.assets/1599642035449.png)

### mset  mget 设置多个

![1599642286569](redis%E6%95%B4%E7%90%86.assets/1599642286569.png)

### 设置对象和getset

![1599642664637](redis%E6%95%B4%E7%90%86.assets/1599642664637.png)





![1599642839637](redis%E6%95%B4%E7%90%86.assets/1599642839637.png)



## list相关

![1599645544609](redis%E6%95%B4%E7%90%86.assets/1599645544609.png)

![1599645313095](redis%E6%95%B4%E7%90%86.assets/1599645313095.png)

![1599645508473](redis%E6%95%B4%E7%90%86.assets/1599645508473.png)

## redis的set

![image-20200909211711402](redis%E6%95%B4%E7%90%86.assets/image-20200909211711402.png)

移除

​			srem myset hello 移除set集合中的指定元素

​	![image-20200909212141425](redis%E6%95%B4%E7%90%86.assets/image-20200909212141425.png)

![image-20200909212746904](redis%E6%95%B4%E7%90%86.assets/image-20200909212746904.png)

![image-20200909212942146](redis%E6%95%B4%E7%90%86.assets/image-20200909212942146.png)

## HASH(map集合)

map集合   key -{ key value} 

![image-20200909213912977](redis%E6%95%B4%E7%90%86.assets/image-20200909213912977.png)

![image-20200909214426061](redis%E6%95%B4%E7%90%86.assets/image-20200909214426061.png)

hash变更的数据user name age 尤其是用户信息之类的,经常变动的信息hsah更适合于对象的存储,String更适合字符串的存储

## zset

可以排序

应用场景

成绩  工资表  消息级别 播放量



# redis实现乐观锁(watch)以及事务

redis的事务不保证原子性    单条命令保证原子性

## watch

![1599701728238](assets/1599701728238.png)

新开客户端,在执行事务之前,对watch监控的money进行改变,

![1599702112398](assets/1599702112398.png)



![1599702252114](assets/1599702252114.png)





![image-20200909225633252](redis%E6%95%B4%E7%90%86.assets/image-20200909225633252.png)

## String

![1599707559057](assets/1599707559057.png)

![1599707514539](assets/1599707514539.png)

## list

![1599707610541](assets/1599707610541.png)![1599707635054](assets/1599707635054.png)



## set

![1599707701562](assets/1599707701562.png)



## Map

![1599707790589](assets/1599707790589.png)



## springboot连接redis

springboot操作数据   spring-data jpa jdbc mongodb redis

springdata 也是和springboot齐名的项目

在springboot2.x之后,原来使用的jedis被替换成了lettuce

jedis  底层采用的是直连,多个线程操作 是不安全的 如果要避免不安全的 使用jedisPool连接池

lettuce

springboot所有配置类,都有一个自动配置类,RedisAutoConfiguration

自动配置类都会绑定一个properties配置文件   RedisProperties



redisTemplate的配置

![1599724741940](assets/1599724741940.png)



关于对象的保存

![1599725968274](assets/1599725968274.png)

所以我们一般都需要转换成json字符串







## redis的持久化之rdb和aof

Redis持久化 
面试和工作，持久化都是重点！
Redis 是内存数据库，如果不将内存中的数据库状态保存到磁盘，那么一旦服务器进程退出，服务器中 的数据库状态也会消失。所以 Redis 提供了持久化功能！ 

### RDB（Redis DataBase） 

什么是RDB
在主从复制中，rdb就是备用了！从机上面！

![1599784836994](assets/1599784836994.png)maxclients 



在指定的时间间隔内将内存中的数据集快照写入磁盘，也就是行话讲的Snapshot快照，它恢复时是将快 照文件直接读到内存里。
Redis会单独创建（fork）一个子进程来进行持久化，会先将数据写入到一个临时文件中，待持久化过程 都结束了，再用这个临时文件替换上次持久化好的文件。整个过程中，主进程是不进行任何IO操作的。 这就确保了极高的性能。如果需要进行大规模数据的恢复，且对于数据恢复的完整性不是非常敏感，那 RDB方式要比AOF方式更加的高效。RDB的缺点是后一次持久化后的数据可能丢失。我们默认的就是 RDB，一般情况下不需要修改这个配置！
有时候在生产环境我们会将这个文件进行备份！
rdb保存的文件是dump.rdb  都是在我们的配置文件中快照中进行配置的！

### 触发机制

1、save的规则满足的情况下，会自动触发rdb规则
2、执行 ﬂushall 命令，也会触发我们的rdb规则！

3、退出redis，也会产生 rdb 文件！

 备份就自动生成一个 dump.rdb

### 如果恢复rdb文件！

1、只需要将rdb文件放在我们redis启动目录就可以，redis启动的时候会自动检查dump.rdb 恢复其中 的数据！
2、查看需要存在的位置
几乎就他自己默认的配置就够用了，但是我们还是需要去学习！
优点：
1、适合大规模的数据恢复！  

2、对数据的完整性要不高！
缺点：
1、需要一定的时间间隔进程操作！如果redis意外宕机

了，这个后一次修改数据就没有的了！ 

2、fork进程的时候，会占用一定的内容空间！！



## AOF（Append Only File） 

将我们的所有命令都记录下来，history，恢复的时候就把这个文件全部在执行一遍

以日志的形式来记录每个写操作，将Redis执行过的所有指令记录下来（读操作不记录），只许追加文件 但不可以改写文件，redis启动之初会读取该文件重新构建数据，换言之，redis重启的话就根据日志文件 的内容将写指令从前到后执行一次以完成数据的恢复工作

Aof保存的是 appendonly.aof 文件
append

![1599785206885](assets/1599785206885.png)



### 如果appendonly.aof文件意外的被改动

无法重新启动的情况下  使用redis提供的修复工具

![1599785303057](assets/1599785303057.png)



## aof文件默认是追加的,会越来越大,重写规则

![1599785409973](assets/1599785409973.png)

aof持久化的优点和缺点

![1599785813524](assets/1599785813524.png)



## 扩展：

1、RDB 持久化方式能够在指定的时间间隔内对你的数据进行快照存储

 2、AOF 持久化方式记录每次对服务器写的操作，当服务器重启的时候会重新执行这些命令来恢复原始 的数据，AOF命令以Redis 协议追加保存每次写的操作到文件末尾，Redis还能对AOF文件进行后台重 写，使得AOF文件的体积不至于过大。 

3、只做缓存，如果你只希望你的数据在服务器运行的时候存在，你也可以不使用任何持久化
4、同时开启两种持久化方式 在这种情况下，当redis重启的时候会优先载入AOF文件来恢复原始的数据，因为在通常情况下AOF 文件保存的数据集要比RDB文件保存的数据集要完整。 RDB 的数据不实时，同时使用两者时服务器重启也只会找AOF文件，那要不要只使用AOF呢？作者 建议不要，因为RDB更适合用于备份数据库（AOF在不断变化不好备份），快速重启，而且不会有 AOF可能潜在的Bug，留着作为一个万一的手段。

 5、性能建议
因为RDB文件只用作后备用途，建议只在Slave上持久化RDB文件，而且只要15分钟备份一次就够 了，只保留 save 900 1 这条规则。 如果Enable AOF ，好处是在恶劣情况下也只会丢失不超过两秒数据，启动脚本较简单只load自 己的AOF文件就可以了，代价一是带来了持续的IO，二是AOF rewrite 的后将 rewrite 过程中产 生的新数据写到新文件造成的阻塞几乎是不可避免的。只要硬盘许可，应该尽量减少AOF rewrite 的频率，AOF重写的基础大小默认值64M太小了，可以设到5G以上，默认超过原大小100%大小重 写可以改到适当的数值。 如果不Enable AOF ，仅靠 Master-Slave Repllcation 实现高可用性也可以，能省掉一大笔IO，也 减少了rewrite时带来的系统波动。代价是如果Master/Slave 同时倒掉，会丢失十几分钟的数据， 启动脚本也要比较两个 Master/Slave 中的 RDB文件，载入较新的那个，微博就是这种架构。



redis项目配置

![1599791071762](assets/1599791071762.png)





node的配置

```
[root@localhost redis]# cd bin
[root@localhost bin]# ls
appendonly.aof  nodes-6380.conf  nodes-6382.conf  redis-check-aof  redis-cli       redis-server
dump.rdb        nodes-6381.conf  redis-benchmark  redis-check-rdb  redis-sentinel
[root@localhost bin]# cat nodes-638
cat: nodes-638: 没有那个文件或目录
[root@localhost bin]# cat nodes-6380.conf 
02065732e17724af6f56ff0454cfddee19324cba 192.168.0.22:6381@16381 slave d30d49c8d6332f6e61864fbc8f9c397765e7504c 0 1561109398339 5 connected
1e63bd1a2736f85b3f88567f40b199e4a6a13c04 192.168.0.21:6382@16382 master - 0 1561109397033 7 connected 5461-10922
d30d49c8d6332f6e61864fbc8f9c397765e7504c 192.168.0.21:6381@16381 master - 0 1561109399042 2 connected 10923-16383
5dc5c3fee27acd667eadfdda74c0148d9e35bdcb 192.168.0.22:6382@16382 slave 09cd386bdf87d3d4b07488c5ba78aaf0ce5c7c1e 0 1561109399659 6 connected
1664c01a8a7b3f260c8b07a8549382a70816f376 192.168.0.22:6380@16380 slave 1e63bd1a2736f85b3f88567f40b199e4a6a13c04 0 1561109398340 7 connected
09cd386bdf87d3d4b07488c5ba78aaf0ce5c7c1e 192.168.0.21:6380@16380 myself,master - 0 1561109398000 1 connected 0-5460
vars currentEpoch 7 lastVoteEpoch 7
[root@localhost bin]# cat nodes-6381.conf 
02065732e17724af6f56ff0454cfddee19324cba 192.168.0.22:6381@16381 slave d30d49c8d6332f6e61864fbc8f9c397765e7504c 0 1561109398339 5 connected
d30d49c8d6332f6e61864fbc8f9c397765e7504c 192.168.0.21:6381@16381 myself,master - 0 1561109398000 2 connected 10923-16383
5dc5c3fee27acd667eadfdda74c0148d9e35bdcb 192.168.0.22:6382@16382 slave 09cd386bdf87d3d4b07488c5ba78aaf0ce5c7c1e 0 1561109399659 6 connected
1664c01a8a7b3f260c8b07a8549382a70816f376 192.168.0.22:6380@16380 slave 1e63bd1a2736f85b3f88567f40b199e4a6a13c04 0 1561109398339 7 connected
1e63bd1a2736f85b3f88567f40b199e4a6a13c04 192.168.0.21:6382@16382 master - 0 1561109399042 7 connected 5461-10922
09cd386bdf87d3d4b07488c5ba78aaf0ce5c7c1e 192.168.0.21:6380@16380 master - 0 1561109398037 1 connected 0-5460
vars currentEpoch 7 lastVoteEpoch 7
[root@localhost bin]# cat nodes-6382.conf 
d30d49c8d6332f6e61864fbc8f9c397765e7504c 192.168.0.21:6381@16381 master - 0 1561109399000 2 connected 10923-16383
09cd386bdf87d3d4b07488c5ba78aaf0ce5c7c1e 192.168.0.21:6380@16380 master - 0 1561109399342 1 connected 0-5460
1664c01a8a7b3f260c8b07a8549382a70816f376 192.168.0.22:6380@16380 slave 1e63bd1a2736f85b3f88567f40b199e4a6a13c04 0 1561109398341 7 connected
1e63bd1a2736f85b3f88567f40b199e4a6a13c04 192.168.0.21:6382@16382 myself,master - 0 1561109397000 7 connected 5461-10922
5dc5c3fee27acd667eadfdda74c0148d9e35bdcb 192.168.0.22:6382@16382 slave 09cd386bdf87d3d4b07488c5ba78aaf0ce5c7c1e 0 1561109399659 6 connected
02065732e17724af6f56ff0454cfddee19324cba 192.168.0.22:6381@16381 slave d30d49c8d6332f6e61864fbc8f9c397765e7504c 0 1561109398347 5 connected
vars currentEpoch 7 lastVoteEpoch 0

```



服务器21redis进程



```
# ls
appendonly.aof  nodes-6380.conf  nodes-6382.conf  redis-check-aof  redis-cli       redis-server
dump.rdb        nodes-6381.conf  redis-benchmark  redis-check-rdb  redis-sentinel
[root@localhost bin]# ps -ef |grep redis
root     21145     1  0  2019 ?        23:04:26 ./redis-server 0.0.0.0:6380 [cluster]
root     21150     1  0  2019 ?        23:05:07 ./redis-server 0.0.0.0:6381 [cluster]
root     21155     1  0  2019 ?        23:00:08 ./redis-server 0.0.0.0:6382 [cluster]
root     29795 29632  0 10:54 pts/0    00:00:00 grep --color=auto redis

```



![1599807136693](assets/1599807136693.png)

































