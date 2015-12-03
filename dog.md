#通用参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|token|字符串|用户登录凭证|是(登录、注册接口除外)||
|tz|字符串|用户所在时区|是|Asia/Shanghai|
#接口域名
  测试:api.test.enterest.me
  正式:api.enterest.me
#接口列表
##用户相关接口
###第三方账号注册
####接口:/user/oauth/reg
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|accessToken|字符串|第三方登录成功凭证|是|asdf2jr2ojflajfjlkajfsdfsaf|
|oauthId|字符串|第三方系统唯一标识|是|165464616546|
|nickname|字符串|用户昵称,必须唯一|是|张三|
|from|字符串|第三方账号来源,如fb或者gg|是|fb|
|avatar|字符串|用户头像|是|/avatar/232.png|
|birthday|字符串|用户生日,格式为yyyy-MM-dd|否|1985-02-14|
|gender|字符串|第三方系统里的用户性别|否|male|
|locale|字符串|用户语言|否||
|timezone|字符串|用户所在时区|是|8|
|locationId|字符串|用户所在地区id|否||
|locationName|字符串|用户所在地区名|否||
|familyId|字符串|用户需要加入的家庭id|否|sldfjsljfoi32uor23rf2jl|
####成功返回值
```
{
    "ret":200,
    "data":{
        "token":"",
        "userId":"",
        "nickname":"",
        "avatar":"",
        "thumbnail":""
    }
}
```
####失败返回值
```
{
    "ret":500,
    "errcode":"SERVER_ERROR"
}
```

###第三方账号登录
####接口:/user/oauth/reg
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|accessToken|字符串|第三方登录成功凭证|是|asdf2jr2ojflajfjlkajfsdfsaf|
|oauthId|字符串|第三方系统唯一标识|是|165464616546|
|from|字符串|第三方账号来源,如fb或者gg|是|fb|
####成功返回值
```
{
    "ret":200,
    "data":{
        "token":"",
        "userId":"",
        "nickname":"",
        "avatar":"",
        "thumbnail":""
    }
}
```
####失败返回值
```
{
    "ret":500,
    "errcode":"SERVER_ERROR"
}
```


###邮箱注册



###邮箱登录



###已有账号绑定第三方账号



###已有账号加入家庭
#错误码
|错误码|含义|
