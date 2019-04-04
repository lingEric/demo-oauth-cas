1. cas-overlay 打包

mvn package

2. 把打成的cas.war包放在tomcat下面运行，并启动oauth-server
3. 访问

```http
http://localhost:8082/oauth/authorize?client_id=iqiyi&response_type=token&redirect_uri=http://localhost:8081/iqiyi/qq/redirect
```

用户未认证，跳转到认证页面

![](D:\ideaworkspace_demo\demo-oauth-cas\asserts\Snipaste_2019-04-04_10-06-25.png)

认证成功，跳转到service【/{context_path}/login/cas,默认端点，可配置】路径，校验service ticket之后，重定向到之前的请求路径

![](D:\ideaworkspace_demo\demo-oauth-cas\asserts\Snipaste_2019-04-04_10-07-22.png)

不携带access_token访问资源

![](D:\ideaworkspace_demo\demo-oauth-cas\asserts\Snipaste_2019-04-04_10-13-04.png)

已经生成了access_token，访问资源，

```http
http://localhost:8082/qq/info/233423424?access_token=353b5476-1e79-4994-bd67-492659e44ac1
```

![](D:\ideaworkspace_demo\demo-oauth-cas\asserts\Snipaste_2019-04-04_10-13-30.png)



抓包截图如下：

![](D:\ideaworkspace_demo\demo-oauth-cas\asserts\Snipaste_2019-04-04_10-22-52.png)

![Snipaste_2019-04-04_10-26-20](D:\ideaworkspace_demo\demo-oauth-cas\asserts\Snipaste_2019-04-04_10-26-20.png)

![Snipaste_2019-04-04_10-28-14](D:\ideaworkspace_demo\demo-oauth-cas\asserts\Snipaste_2019-04-04_10-28-14.png)