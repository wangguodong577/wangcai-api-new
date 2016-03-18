#通用参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|token|字符串|用户登录凭证|是(登录、注册接口除外)||
|tz|字符串|用户所在时区|是|Asia/Shanghai|
#接口域名
```
  测试:api.test.iwifiapi.com
  正式:api.iwifiapi.com
```
#接口返回值说明
1:接口返回类型均为json格式
2:ret参数用于表示是否成功,200为成功,500为失败
3:若成功,可以在data里获得结果,失败则可以通过errcode获得出错原因,错误代码列表可见本文末尾

如成功:
```
{
    "ret":200,
    "data":{
        "token":"",
        "userId":"",
        "nickname":""
    }
}
```
失败:
```
{
    "ret":500,
    "errcode":"SERVER_ERROR"
}
```
#接口列表
##用户相关接口
###用户登录
####接口:/user/login
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|access_token|字符串|第三方登录成功凭证|是|asdf2jr2ojflajfjlkajfsdfsaf|
|oauth_id|字符串|第三方系统唯一标识|是(type为fb或gg时必须)|165464616546|
|type|字符串|第三方账号来源,值为:fb|是|fb|
|nickname|字符串|昵称|否|正举|
|avatar|字符串|头像|否|http://xxx.xxx/xxx.jpg|
|gender|字符串|性别|否|male|
|locale|字符串|语言|否|zh_cn|
|body|字符串|{"points",11}的加密串|否|sjldfjasdlfj2oijfio2f|
####成功返回值
```
{
    "ret":200,
    "data":{
        "token":"",
        "userId":"",
        "nickname":"",
        "avatar":"",
        "code":12,
        "shareWifiCount":1
        "shareWifiConnectCount":1,
        "totalCheckinDayCount":1,
        "taskList":{
          "beInvited":false
        }
        "points":111
    }
}
```
###用户使用他人邀请码接口
####接口:/user/invite
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|code|字符串|他人邀请码|是|d1we|
####成功返回值
```
{
    "ret":200,
    "data":{
        "increment":33,
        "points":123
    }
}
```

###获得用户信息接口
####接口:/user/info
####请求方式:POST/GET
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":{
        "id":"fb_sdfsdfsdfsdf",
        "code":"sdf3",
        "nickname":"xxx",
        "inviter":"fb_xxxxsdfsdf",
        "points":123
    }
}
```

###用户签到接口
####接口:/user/checkin
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|tz|字符串|时区|是|America/Los_Angeles或者GMT-8:00|
####成功返回值
```
{
    "ret":200,
    "data":{
      "continueDays":1,
      "increment":33,
      "points":32
    }
}che
```

## 积分相关接口
###获取积分规则
####接口:/points/rule
####请求方式:POST/GET
####接口参数
无
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "id": "1",
            "increase": true,
            "amount": 2,
            "event": "register",
            "interval": "once",
            "enable": true,
            "createTime": 1455821752000
        },
        {
            "id": "2",
            "increase": true,
            "amount": 3,
            "event": "dropdown",
            "interval": "day",
            "enable": true,
            "createTime": 1455821979000
        },
        {
            "id": "3",
            "increase": true,
            "amount": 4,
            "event": "connect",
            "interval": "day",
            "enable": true,
            "createTime": 1455822005000
        },
        {
            "id": "4",
            "increase": true,
            "amount": 5,
            "event": "invite",
            "interval": "none",
            "enable": true,
            "createTime": 1455822033000
        },
        {
            "id": "5",
            "increase": true,
            "amount": 1,
            "event": "beinvited",
            "interval": "once",
            "enable": true,
            "createTime": 1455822060000
        }
    ]
}
```

###获取本地积分,返回最新积分
####接口:/points/offline
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|body|字符串|{"points",11}的加密串|是|sjldfjasdlfj2oijfio2f|
####成功返回值
```
{
    "ret":200,
    "data":{
        "points":123
    }
}
```

###上报事件,获取积分,返回最新积分
####接口:/points/earn
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|event|字符串|事件类型,可选值为register,check(测速,安全,信号增强),dropdown(下拉),connect|是|check|
|tz|字符串|时区|是|America/Los_Angeles或者GMT-8:00|
####成功返回值
```
{
    "ret":200,
    "data":{
        "points":123
    }
}
```

#错误码
|错误码|含义|
|---|---|
|SERVER_ERROR|系统错误|
|PARAM_ERROR|参数错误|
|USER_NOT_LOGIN|用户未登录|
|USER_LOGIN_FAIL|用户登录失败|
|USER_IS_CANCELED|用户被封禁|
|POINT_EVENT_LIMIT|该类型事件已经参与积分|
