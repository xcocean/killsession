# killsession
实现用户不能重复登陆，可根据实际情况让用户强制下线

### 思路：
1、当用户登录时，记录下sessionId → key=username，value=session
2、用户再次登录时，检查key是否存在，再次登录是存在的，此时，把session换成再次登录的sessionId，原来的sessionid从httpsession中移除
### 需要考虑的情况：
1、系统重启
### 简书文章
https://www.jianshu.com/p/71e218a1833c

![效果图](https://github.com/xcocean/killsession/blob/master/GIF.gif)
