# OAuth2

## 社交登录

![image-20240411171202452](D:\本地图片\image-20240411171202452.png![image-20240411171232708](D:\本地图片\image-20240411171232708.png)

### GitHub

clientId: aed3fb28b921a579172c

clientSecrets: 8a1dfd12e7ef4e696bdfc571cd43093282bca422



## 授权码模式

![20210727102918815](D:\本地图片\20210727102918815.png)



## what

​		OAuth 2.0是用于授权的行业标准协议

## why

​		利用oauth2实现两个服务之间授权登录，一个客户端，一个授权服务器（授权服务器中存在用户信息），授权服务器授权客户端访问资源。

## where

## how



> https://github.com/login/oauth/authorize
>
> ?response_type=code
>
> &client_id=aed3fb28b921a579172c
>
> &scope=read:user
>
> &state=9E7WnlKYvQNh5_WF30jMtgD7PdhQsn6wnA8siNhnnKk%3D
>
> &redirect_uri=http://localhost:8888/login/oauth2/code/github

> GET 
>
> /login/oauth2/code/github
>
> ?code=e95a91d4fd0cff2b1067
>
> &state=9E7WnlKYvQNh5_WF30jMtgD7PdhQsn6wnA8siNhnnKk%3D 
>
> HTTP/1.1

>  POST
>
> https://github.com/login/oauth/access_token
> {
>
> ​	grant_type=[authorization_code], 
>
> ​	code=[e95a91d4fd0cff2b1067], 
>
> ​	redirect_uri=[http://localhost:8888/login/oauth2/code/github]
>
> }

> GET 
>
> https://api.github.com/user

> http://localhost:8888/

> GET 
>
> / 
>
> HTTP/1.1
