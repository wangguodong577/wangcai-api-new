#通用参数
除了获取accessToken以外，其他接口都要加上如下http header


#接口域名
```
  测试:im.test.nuzzle.me
  正式:im.nuzzle.me
  推送服务器：push.nuzzle.me
```

###获取accessToken
####接口:/Passports/accessToken
####请求方式:GET
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|appKey|字符串|app标示|是|holaverse#nuzzle|
|appSecret|字符串|app秘钥|是|de92419b60d52b0f754f0a7c0a20d39ea50a0458|
####成功返回值
```
{
  "ret":200,
  "data":{
    "accessToken":"62ea0c70fb0bf175b266cd903ff97fc193511d8b"
  }
}
```
####错误代码errcode
1, APP_LOGIN_FAIL, app登陆错误，key或者secret不匹配


###注册用户
####接口:/Users/register
####请求方式:POST
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|用户标示|是|user1111|
|password|字符串|用户密码|是|pwd11111|
####成功返回值
```
{
   "ret": 200,
   "data": {
      "userId": "user111",
      "uuid": "4d576241bb87755c7292db5c2578ed86",
      "appKey": "holaverse#nuzzle"
   }
}

```
####错误代码errcode
1, USER_HAS_BEEN_REGISTERED, 该用户已经注册

###批量注册用户
####接口:/Users/batchRegister
####请求方式:POST
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|json|字符串|批量用户信息|是|[{"userId": "xxx", "password" : "xxx"}]|
####成功返回值
```
{
   "ret": 200,
   "data": [{
      "userId": "user111",
      "uuid": "4d576241bb87755c7292db5c2578ed86",
      "appKey": "holaverse#nuzzle"
   }]
}
```
***注意，服务端会对json数据处理，删除不合法的数据条目（比如缺userId或者password）和已经存在的条目，返回的data里面是真正添加的数据条目

###登陆
####接口: /Users/login
####请求方式:POST
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|用户ID|是|z1|
|password|字符串|密码|是|p1|
|token|字符串|原始token|否|xxxx|
|platForm|字符串|登陆平台|否|ANDROID/IOS|
|pushToken|字符串|用户第三方推送|否|xxxx|
|nickName|字符串|昵称|否|xxx|
|extras|字符串|额外信息|否|{a:b}|
####成功返回值
```
{
  "ret": 200,
  "data": {
    "token": "92cddc6e65d999ff14b25b5599c4d4a225d8ffd3"
  }
}
```

###更新用户信息
####接口: /Users/updateProfile
####请求方式:POST
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|用户ID|是|z1|
|platForm|字符串|登陆平台|否|ANDROID/IOS|
|pushToken|字符串|用户第三方推送|否|xxxx|
|nickName|字符串|昵称|否|xxx|
|extras|字符串|额外信息|否|{a:b}|
####成功返回值
```
{
  "ret": 200,
  "data": ""
}
```

