此项目为springBoot,myBatis,neo4j,gradle整合项目。

有增删改查、动态分页条件排序等一些示例。

运行此项目前请先到http://localhost:7474/browser/运行cql
create (u:user{name:'阿强',sex:'男',age:22}) - [l:like] -> (y:user{name:'阿珍',sex:'女',age:21})