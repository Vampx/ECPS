# ECPS
移动电子商城项目，分布式系统架构，SSM框架

页面标签
在一个统一的文件中taglibs.jsp页面进行。

一级菜单下有二级菜单，每一个一级菜单都对应代码中shop文件夹下的模块，每一个shop中都有一个统一的index.jsp的索引页面，每一个index.jsp中都有div做了一个动态包含，包含的就是每一个二级菜单的页面。


1. 购物车的数据存储的位置

不能存在session，生命周期短，浏览器关闭浏览器数据消失

1.  数据库
        可以的
        优点：安全，存储量不受限制
        缺点：存储在数据库中必须登录

2.   使用浏览器的cookie来存储购物车
       优点：不用登录，因为数据存储在用户的浏览器里面
                     大大减轻对服务器的压力
       缺点：安全性差，存储量有限

2.添加购物车，把什么数据存储在cookie里面？
把sku_id和购买数量quantity存储到cookie里面

cookie是键值对
cookie_name:ecps_cart_data
cookie_value: [{skuId:1002, quantity:2},{skuId:1003, quantity:1},.....]

cookie_value要存储json格式的字符串，这种字符串可以和json lib包中的对象相互转换，json lib包下的对象还可以和java的自定义对象相互转换

json格式的字符串<-------------->JSONArray<------------------->EbCart



3.添加购物车之前要做什么事情？
（1）添加购物车之前要对当前要买的最小销售单元的库存做判断，看是否足够当前购买的数量

 （2）
	a添加购物车时在浏览器中可能不存eccps_cart_data这个cookie

   	b添加购物车时在浏览器中已经ecps_cart_data这个cookie
	        (a)当前ecps_cart_data中不存你要添加的sku_id
	        (b)当前ecps_cart_data中存在你要添加的sku_id
