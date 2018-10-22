/oauth/authorize：授权端点
/oauth/token：令牌端点
/oauth/confirm_access：用户确认授权提交端点
/oauth/error：授权服务错误信息端点
/oauth/check_token：用于资源服务访问的令牌解析端点
/oauth/token_key：提供公有密匙的端点，如果你使用JWT令牌的话

===================================================
GrantType authorization_code （授权码模式）
步骤一: 获取客户端 client_id=client  对应 code （在浏览器测试，使用postman工具发起请求，无法重定向到指定页面）
Get请求
http://localhost:8900/oauth/authorize?client_id=client&response_type=code&redirect_uri=https://cn.bing.com

最终重定向到：
    https://cn.bing.com/?code=PDz1P0
步骤二：获取 token
Post 请求
http://localhost:8900/oauth/token

request headers:
Content-Type:application/x-www-form-urlencoded
Authorization:Basic Y2xpZW50OjEyMzQ1Ng==

form-data
grant_type:authorization_code
code:CNvJSf
redirect_uri:https://cn.bing.com

response data:
{
    "access_token": "9a10937c-9414-47d0-80d0-f096a6036664",
    "token_type": "bearer",
    "refresh_token": "6105b4b2-6a67-4559-ba98-5298894af245",
    "expires_in": 42299,
    "scope": "app"
}

刷新时 token
Post 请求
http://localhost:8900/oauth/token

request headers:
Content-Type:application/x-www-form-urlencoded
Authorization:Basic Y2xpZW50OjEyMzQ1Ng==

form-data
grant_type:refresh_token
refresh_token:6105b4b2-6a67-4559-ba98-5298894af245

===================================================
===================================================
GrantType password （密码模式）

获取 token
Post 请求
http://localhost:8900/oauth/token

request headers:
Content-Type:application/x-www-form-urlencoded
Authorization:Basic Y2xpZW50OjEyMzQ1Ng==

form-data
grant_type:password
username:user
password:123456

response data:
{
    "access_token": "4f2f9266-2940-4a3b-93a3-7d547e659906",
    "token_type": "bearer",
    "refresh_token": "cb565c03-0170-49f0-bd73-07671f1681d2",
    "expires_in": 42937,
    "scope": "app"
}

刷新时 token
Post 请求
http://localhost:8900/oauth/token

request headers:
Content-Type:application/x-www-form-urlencoded
Authorization:Basic Y2xpZW50OjEyMzQ1Ng==

form-data
grant_type:refresh_token
refresh_token:6105b4b2-6a67-4559-ba98-5298894af245

===================================================

https://blog.csdn.net/qq_27828675/article/details/82388555
https://blog.csdn.net/qq_27828675/article/details/82415536

https://www.cnblogs.com/cjsblog/p/9296361.html


spring在获得token后，必须要调用一下resource.userInfoUri里的接口，看看到底有没有返回值，
也就是要验证一下token是不是正确的，这一步是它自动完成的。获得token——调用接口获取user details信息，
如果成功了，才算正常;


https://github.com/babylikebird/Micro-Service-Skeleton