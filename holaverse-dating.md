#通用参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|token|字符串|用户登录凭证|是(登录、注册接口除外)||
|tz|字符串|用户所在时区|是|Asia/Shanghai|
|pf|字符串|客户端平台类型,ios或者android|是|ios|
#接口域名
```
  测试:api.test.dating.holalauncher.com 
  正式:待定
```
#接口返回值说明
```
1:接口返回类型均为json格式
2:ret参数用于表示是否成功,400以下为成功，400及以上为失败
3:若成功,可以在data里获得结果,失败则可以通过errcode获得出错原因
```

#接口列表

###facebook登录
####接口:/Users/loginByFacebook
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|facebookAccessToken|字符串|第三方登录成功凭证|是|asdf2jr2ojflajfjlkajfsdfsaf|
|avatarUrl|字符串|客户端上传头想后得到的url|否|xxxxxxx|
|pushToken|字符串|推送token|是|sdfsdfawefawfasfd|
####成功返回值
```
{
  "ret": 200,
  "data": {
    "birthday": "",
    "lastWorkPosition": "Holaverse Farmer",
    "lastEducation": "dongbeishi daxue",
    "name": "Zhou Xichao",
    "id": 1,
    "avatar": "http://graph.facebook.com/140156023054005/picture",
    "introduction": "",
    "age": "",
    "token": "fc8966e4f58dc2348778ff405d5f60f2"
  }
}
```

###更新个人信息
####接口:/Users/updateProfile
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|introduction|字符串|个人简介|否|asdf2jr2ojflajfjlkajfsdfsaf|
|pictureUrls|字符串|用户图片, 数组形式|否|xxxxxxx|

####请求示例
curl "http://localhost:9111/Users/updateProfile" -d "introduction=xxxxxx&pictureUrls[]=xxxxxxxx&pictureUrls[]=yyyyyy"

####成功返回值
```
{
  "ret": 200,
  "data": ""
}
```

###获取我的个人信息
####接口:/Users/getProfile
####请求方式:GET
####接口参数

####成功返回值
```
{
  "ret": 200,
  "data": {
    "birthday": null,
    "lastWorkPosition": "Holaverse Farmer",
    "lastEducation": "dongbeishi daxue",
    "name": "Zhou Xichao",
    "id": 1,
    "avatar": "http://graph.facebook.com/140156023054005/picture",
    "introduction": "xxxx",
    "age": null,
    "pictures": [
      {
        "id": 10,
        "userId": 1,
        "url": "http://img3.imgtn.bdimg.com/it/u=777984066,3378417135",
        "sortNum": 0,
        "status": "NORMAL",
        "createTime": 1461725982660
      }
    ],
    "token": "38155d4fd4040b7feeffb11d7f149d16"
  }
}
```

###获取其他人的信息
####接口:/Users/getProfile
####请求方式:GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|Long|其他人ID|是|1|

####成功返回值
```
{
  "ret": 200,
  "data": {
    "birthday": null,
    "lastWorkPosition": "Holaverse Farmer",
    "lastEducation": "dongbeishi daxue",
    "name": "Zhou Xichao",
    "id": 1,
    "avatar": "http://graph.facebook.com/140156023054005/picture",
    "introduction": "xxxx",
    "age": null,
    "pictures": [
      {
        "id": 10,
        "userId": 1,
        "url": "http://img3.imgtn.bdimg.com/it/u=777984066,3378417135",
        "sortNum": 0,
        "status": "NORMAL",
        "createTime": 1461725982660
      }
    ],
    "token": "38155d4fd4040b7feeffb11d7f149d16"
  }
}
```

###查找附近的人
####接口:/Users/findNearbyUsers
####请求方式:GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|gender|0/1/null|男或女，空为全部|否|0|
|radius|double|搜寻半径，默认为50000，单位为米|否|50000|

####注意，如果被like或者dislike的用户不会出现在列表中，目前这个限制没有加，性别的限制也暂时没加

####成功返回值
```
{
  "ret": 200,
  "data": {
    "contentList": [
      {
        "id": 1,
        "birthday": null,
        "distance": 1234,
        "age": null,
        "lastWorkPosition": "Holaverse Farmer",
        "pictures": [
          {
            "id": 14,
            "userId": 1,
            "url": "http://ww1.sinaimg.cn/large/7a8aed7bjw1f2nxxvgz7xj20hs0qognd.jpg",
            "sortNum": 4,
            "status": "NORMAL",
            "createTime": null
          },
          {
            "id": 15,
            "userId": 1,
            "url": "http://ww2.sinaimg.cn/large/7a8aed7bjw1f2mteyftqqj20jg0siq6g.jpg",
            "sortNum": 5,
            "status": "NORMAL",
            "createTime": null
          }
        ],
        "likeMe": false,
        "avatar": "http://graph.facebook.com/140156023054005/picture",
        "lastEducation": "dongbeishi daxue"
      }

    ],
    "refresh": false //如果refresh为true，表明gender+radius的组合筛选结果已经更新
  }
}
```

###like接口
####接口:/Users/like
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|oppositeId|Long|被赞人ID|是|1|

####成功返回值
```
{
  "ret": 200,
  "data": ""
}
```

###dislike接口
####接口:/Users/dislike
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|oppositeId|Long|被否定人ID|是|1|

####成功返回值
```
{
  "ret": 200,
  "data": ""
}
```


###上报GEO信息
####接口:/Locations/report
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|lat|Double|维度|是|100.10|
|lng|Double|经度|是|100.10|

####成功返回值
```
{
  "ret": 200,
  "data": ""
}
```


