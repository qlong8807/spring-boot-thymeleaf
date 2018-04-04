SpringBoot自动配置类路径
把类路径下的/static、/public、/resources和/META-INF/resources文件夹下的静态文件直接映射为/**，可以通过http://localhost:8080/**直接访问。

打开http://localhost:8080会自动跳转到https://localhost:8443

广播式websocket
访问http://localhost:8080/ws,多打开几个浏览器窗口。在一个窗口中输入，点击发送，所有的窗口都能收到。

点对点websocket
打开两个浏览器。访问http://localhost:8080/login.一个用zhangsan/1登录，一个用lisi/2登录。两个可以给对方发送消息。