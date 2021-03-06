#通用参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|token|字符串|用户登录凭证|是(登录、注册接口除外)||
|tz|字符串|用户所在时区|是|Asia/Shanghai|
|lang|字符串|系统语言|是|ZH_cn|
|ver|字符串|版本号|是|2|
|pf|字符串|客户端平台类型,ios或者android|是|ios|

#接口域名
```
  测试:api.test.dating.holalauncher.com 
  正式:api.lookinsocial.com
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
  "data":{
    "birthday": null,
    "lastWorkPosition": "Farmer",
    "lastEducation": "dongbeishi daxue",
    "name": "Zhou Xichao",
    "lastSecondEducation": "Weishi high schooi",
    "lastWorkCompany": "Farmer",
    "id": 1,
    "avatar": "http://graph.facebook.com/140156023054005/picture",
    "smallAvatar": "xxx",
    "introduction": "xxxx",
    "age": null,
    "token": "1cfe47ceafc6e967d3c8d2c9997e3ddf",
    "extras": {
      "avatarPhotoUrl": "https://scontent.xx.fbcdn.net/hphotos-xpt1/t31.0-8/13047851_140139266389014_4113989213930852584_o.jpg",
      "isNew" : false
    },
    searchCondition:{
      "id": 1,
      "userId": 84,
      "gender": 1,
      "minDistance": 0,
      "maxDistance": 150000,
      "minAge": 15,
      "maxAge": 25,
      "sameCollege" : false,
      "invisibleToFriend" : false,
      "invisibleToAll" : false
    },
    likeCount: 3,
    city : "xxx",
    country: "xxx"
  }
}
```

###注销登陆
####接口: /Users/logout
####请求方式: POST
####成功返回值
```
{
  "ret": 200,
  "data": ""
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
  "data": {
    "birthday": null,
    "lastWorkPosition": "Farmer",
    "lastEducation": "dongbeishi daxue",
    "name": "Zhou Xichao",
    "lastSecondEducation": "Weishi high schooi",
    "lastWorkCompany": "Farmer",
    "id": 1,
    "avatar": "http://graph.facebook.com/140156023054005/picture",
    "smallAvatar": "xxx",
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
    "likeCount" : 3
  }
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
    "lastWorkPosition": "Farmer",
    "lastEducation": "dongbeishi daxue",
    "name": "Zhou Xichao",
    "lastSecondEducation": "Weishi high schooi",
    "lastWorkCompany": "Farmer",
    "id": 1,
    "avatar": "http://graph.facebook.com/140156023054005/picture",
    "smallAvatar": "xxx",
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
    "educations" : [],
    works": [
          {
            "id": 2775,
            "userId": 86,
            "locationName": "Beijing, China",
            "positionName": "Product Management",
            "employerName": "昆仑万维"
          }
    ],
    "likeCount" : 3
  }
}
```

###获取其他人的信息
####接口:/Users/getProfileByUserId
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
    "lastWorkPosition": "Farmer",
    "lastEducation": "dongbeishi daxue",
    "name": "Zhou Xichao",
    "lastSecondEducation": "Weishi high schooi",
    "lastWorkCompany": "Farmer",
    "id": 1,
    "avatar": "http://graph.facebook.com/140156023054005/picture",
    "smallAvatar": "xxx",
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
    works": [
          {
            "id": 2775,
            "userId": 86,
            "locationName": "Beijing, China",
            "positionName": "Product Management",
            "employerName": "昆仑万维"
          }
    ]
  }
}
```

###由facebookId获取其他人的信息
####接口:/Users/getProfileByFacebookId
####请求方式:GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|facebookId|String|facebookId|是|1|

####成功返回值
```
{
  "ret": 200,
  "data": {
        "birthday": null,
        "lastWorkPosition": "Farmer",
        "distance": 1234,
        "lastEducation": "dongbeishi daxue",
        "lastSecondEducation": "Weishi high schooi",
        "lastWorkCompany": "Farmer",
        "avatar": "http://graph.facebook.com/140156023054005/picture",
        "smallAvatar": "xxx",
        "mutualInterests" : ["足球", "篮球"],
        "mutualFriends" : [{"facebookName" : "xxx", "avatar" : "xxx"}],
        "pictures": [
          {
            "id": 10,
            "userId": 1,
            "url": "http://ww4.sinaimg.cn/large/610dc034jw1f2uyg3nvq7j20gy0p6myx.jpg",
            "sortNum": 0,
            "status": "NORMAL",
            "createTime": null
          },
          {
            "id": 11,
            "userId": 1,
            "url": "http://ww4.sinaimg.cn/large/7a8aed7bjw1f2tpr3im0mj20f00l6q4o.jpg",
            "sortNum": 1,
            "status": "NORMAL",
            "createTime": null
          }
        ],
        works": [
          {
            "id": 2775,
            "userId": 86,
            "locationName": "Beijing, China",
            "positionName": "Product Management",
            "employerName": "昆仑万维"
          }
        ],
        "name": "Zhou Xichao",
        "id": 1,
        "age": null,
        "introduction": "123"
  }
}
```

###查找附近的人
####接口:/Users/findNearbyUsers
####请求方式:GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|pn|int|页码|否|默认为1|
|pageSize|int|每页条数|否|默认为10|
|forceRefresh|boolean|强制刷新列表|否|默认为false|

**筛选条件 见 getSearchCondition，如果个人没有设置，默认为：年龄 16-45， 距离： 150千米， 性别：facebook为男，默认为女，facebook为女性，默认为男，如果facebook没有设置性别，默认为1**

**注意refresh参数，如果refresh为true，表明当前列表更新，服务端返回的是列表刷新后的第一页数据，这个时候客户端注意把当前页码设置为1**

####成功返回值
```
{
  "ret": 200,
  "data": {
    "contentList": [
      {
        "birthday": null,
        "lastWorkPosition": "Farmer",
        "distance": 1234,
        "lastEducation": "dongbeishi daxue",
        "lastSecondEducation": "Weishi high schooi",
        "lastWorkCompany": "Farmer",
        "likeMe": false,
        "superLikeMe": false,
        "avatar": "http://graph.facebook.com/140156023054005/picture",
        "smallAvatar": "xxx",
        "mutualInterests" : ["足球", "篮球"],
        "pictures": [
          {
            "id": 10,
            "userId": 1,
            "url": "http://ww4.sinaimg.cn/large/610dc034jw1f2uyg3nvq7j20gy0p6myx.jpg",
            "sortNum": 0,
            "status": "NORMAL",
            "createTime": null
          },
          {
            "id": 11,
            "userId": 1,
            "url": "http://ww4.sinaimg.cn/large/7a8aed7bjw1f2tpr3im0mj20f00l6q4o.jpg",
            "sortNum": 1,
            "status": "NORMAL",
            "createTime": null
          }
        ],
        "name": "Zhou Xichao",
        "id": 1,
        "age": null,
        "introduction": "123"，
        works": [
          {
            "id": 2775,
            "userId": 86,
            "locationName": "Beijing, China",
            "positionName": "Product Management",
            "employerName": "昆仑万维"
          }
        ]
      },
      {
        "birthday": null,
        "lastWorkPosition": "Farmer",
        "distance": 1234,
        "lastEducation": "dongbeishi daxue",
        "lastSecondEducation": "Weishi high schooi",
        "lastWorkCompany": "Farmer",
        "likeMe": false,
        "superLikeMe": false,
        "avatar": "http://graph.facebook.com/140156023054005/picture",
        "smallAvatar": "xxx",
        "pictures": [
          {
            "id": 21,
            "userId": 2,
            "url": "http://ww4.sinaimg.cn/large/7a8aed7bjw1f2tpr3im0mj20f00l6q4o.jpg",
            "sortNum": 1,
            "status": "NORMAL",
            "createTime": null
          },
          {
            "id": 22,
            "userId": 2,
            "url": "http://ww1.sinaimg.cn/large/7a8aed7bjw1f2sm0ns82hj20f00l8tb9.jpg",
            "sortNum": 2,
            "status": "NORMAL",
            "createTime": null
          }
        ],
        "mutualInterests" : ["足球", "篮球"],
        "name": "Zhou Xichao",
        "id": 2,
        "age": null,
        "introduction": "123"，
        works": [
          {
            "id": 2775,
            "userId": 86,
            "locationName": "Beijing, China",
            "positionName": "Product Management",
            "employerName": "昆仑万维"
          }
        ],
      },
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

###获取匹配的用户列表
####接口:/Users/getMatchList
####请求方式:GET
####接口参数
####成功返回值

```
{
  "ret": 200,
  "data":  [
      {
        "birthday": null,
        "lastWorkPosition": "Farmer",
        "distance": 1234,
        "lastEducation": "dongbeishi daxue",
        "lastSecondEducation": "Weishi high schooi",
        "lastWorkCompany": "Farmer",
        "likeMe": false,
        "avatar": "http://graph.facebook.com/140156023054005/picture",
        "smallAvatar": "xxx",
        "mutualInterests" : ["足球", "篮球"],
        "mutualFriends" : [{"facebookName" : "xxx", "avatar" : "xxx"}],
        "pictures": [
          {
            "id": 10,
            "userId": 1,
            "url": "http://ww4.sinaimg.cn/large/610dc034jw1f2uyg3nvq7j20gy0p6myx.jpg",
            "sortNum": 0,
            "status": "NORMAL",
            "createTime": null
          },
          {
            "id": 11,
            "userId": 1,
            "url": "http://ww4.sinaimg.cn/large/7a8aed7bjw1f2tpr3im0mj20f00l6q4o.jpg",
            "sortNum": 1,
            "status": "NORMAL",
            "createTime": null
          }
        ],
        "name": "Zhou Xichao",
        "id": 1,
        "age": null,
        "introduction": "123"，
        "matchTime" : 12313456465,
        works": [
          {
            "id": 2775,
            "userId": 86,
            "locationName": "Beijing, China",
            "positionName": "Product Management",
            "employerName": "昆仑万维"
          }
        ],
      },
      {
        "birthday": null,
        "lastWorkPosition": "Farmer",
        "distance": 1234,
        "lastEducation": "dongbeishi daxue",
        "lastSecondEducation": "Weishi high schooi",
        "lastWorkCompany": "Farmer",
        "likeMe": false,
        "avatar": "http://graph.facebook.com/140156023054005/picture",
        "smallAvatar": "xxx",
        "pictures": [
          {
            "id": 21,
            "userId": 2,
            "url": "http://ww4.sinaimg.cn/large/7a8aed7bjw1f2tpr3im0mj20f00l6q4o.jpg",
            "sortNum": 1,
            "status": "NORMAL",
            "createTime": null
          },
          {
            "id": 22,
            "userId": 2,
            "url": "http://ww1.sinaimg.cn/large/7a8aed7bjw1f2sm0ns82hj20f00l8tb9.jpg",
            "sortNum": 2,
            "status": "NORMAL",
            "createTime": null
          }
        ],
        "mutualInterests" : ["足球", "篮球"],
       
        "name": "Zhou Xichao",
        "id": 2,
        "age": null,
        "introduction": "123"，
        works": [
          {
            "id": 2775,
            "userId": 86,
            "locationName": "Beijing, China",
            "positionName": "Product Management",
            "employerName": "昆仑万维"
          }
        ]
      }
  ]
}
```

###解除match
####接口:/Users/mismatch
####请求方式:GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|oppositeId|Long|对方id|是|100|
####成功返回值
```
{
  "ret": 200,
  "data": ""
}
```

###保存筛选条件
####接口:/Users/saveSearchCondition
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|gender|Integer|性别，1标示男，0标示女，2标示男女不限|否|1|
|minDistance|Integer|最小距离，单位是米|是|0|
|maxDistance|Integer|最大距离，单位是米|是|15000|
|minAge|Integer|最小年龄|是|15|
|maxAge|Integer|最大年龄|是|25|
|sameCollege|Boolean|同一所大学|否|false|
|invisibleToAll|Boolean|隐身模式|否|false|
|invisibleToFriend|Boolean|对好友屏蔽|否|false|
####成功返回值
```
{
  "ret": 200,
  "data": ""
}
```

###获取筛选条件
####接口:/Users/getSearchCondition
####请求方式:GET
####成功返回值 示例
```
{
  "ret": 200,
  "data": {
    "id": 1,
    "userId": 84,
    "gender": 1,
    "minDistance": 0,
    "maxDistance": 150000,
    "minAge": 15,
    "maxAge": 25,
    "sameCollege" : false,
    "invisibleToFriend" : false，
    "invisibleToAll" : false
  }
}
```

###获取兴趣标签
####接口:/Interests/getInterests
####请求方式:GET
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|interestCategoryId|Long|目录Id|是|1|
####成功返回值 示例
```
{
  "ret": 200,
  "data": 
    {
      "id": 1,
      "name": "运动", //一级目录
      "items": [  //二级目录
        {
          "id": 2,
          "name": "足球",
          "createTime": 1464774603161
        },
        {
          "id": 1,
          "name": "篮球",
          "createTime": 1464774601500
        }
      ],
      "modelStatus": "NORMAL",
      "createTime": 1464774425000
    }

```

###添加个人兴趣标签
####接口:/Interests/updateUserInterests
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|interestCategoryId|Long|目录Id|是|1|
|interestItemIds[]|Long[]|标签Id列表|否|interestItemIds[]=1&interestItemIds[]=2|
|interestItemNames[]|String[]|自定义标签名0|否|interestItemNames[]=xxx&interestItemNames[]=yyy|

**特别注意的是，interestItemIds里面全是预定义标签， interestItemNames是自定义标签。**

####成功返回值 示例
```
{
  "ret": 200,
  "data": ""
}
```

###获取我的兴趣标签
####接口:/Interests/getMyInterests
####请求方式:POST
####成功返回值 示例
```
{
  "ret": 200,
  "data": [
    {
      "id": 1,
      "name": "运动", //一级目录
      "items": [ //二级
        {
          "id": 2,
          "name": "足球"
        },
        {
          "id": null, //id为空表示自定义标签
          "name": "xxx"
        }
      ]
    }
  ]
}
```

###获取配置
####接口:/Configurations/getConf
####请求方式:GET
####成功返回值 示例
```
{
  "ret": 200,
  "data": {
    "like_count_limit": 5,   //最多like次数
    "first_like_interval_limit": 43200 //单位为秒
  }
}
```

###反馈
####接口:/HolaDesks/feedback
####请求方式:post
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|pf|String|ios/andoid|是|ios|
|osVer|int|操作系统版本号|是|25|
|lang|string|语言|是|TH|
|pid|int|产品id|是|100211|
|ver|int|产品版本号|是|100211|
|email|string|邮箱地址|是|aa@bb.com|
|verName|string|产品版本名|是|1.2.3|
|model|string|机器型号|否|MZxxx|
|content|string|反馈内容|是|太烂了太烂了|

####成功返回值 示例
```
{
  "ret": 200,
  "data": {}
}
```

###SUPER LIKE
####接口:/Users/superLike
####请求方式:post
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|oppositeId|long|对方ID|是|12|

####成功返回值 示例
```
{
  "ret": 200,
  "data": {}
}
```
**错误返回值： 如果13小时候，使用过一次superlike，再次使用，ret 为701**

###获取共同好友
####接口:/Users/getMutualFriends
####请求方式:get
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|long|对方ID|是|12|

####成功返回值 示例
```
{
  "ret": 200,
  "data": [
    {
      "facebookName" : "xxx",
      "avatar" : "xxx"
    }
  ]
}
```


###举报
####接口:/HolaDesks/report
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|oppositeId|long|对方ID|是|12|
|reason|string|举报原因|是|涉黄|

####成功返回值 示例
```
{
  "ret": 200,
  "data": ""
}
```


###我关注（like）的人的列表
####接口:/QAs/getFollows
####请求方式:GET
####接口参数

####成功返回值 示例
```
{
  "ret": 200,
  "data": [
    {
      "smallAvatar": "https://non-prod-test.s3.amazonaws.com/dating/s/img/avatar/691bd2db1695d3fc2993ef358315bb98.jpg",
      "questions": [ //问题列表
        {
          "id": 2871,
          "userId": 86,
          "content": "我帅吗",
          "createTime": 1468319020419,
          "answer": { //答案
            "id": 2867,
            "userId": 81,
            "questionId": 2871,
            "content": "123456",
            "createTime": 1468319083559
          }
        }
      ],
      isNew: true, //表明该记录有更新，要显示小红点
      "avatar": "http://graph.facebook.com/1730863817151745/picture",
      "name": "王凯",
      "id": 86,
      "vip": false,
      "facebookId" : "xxxxxx"
    }
  ]
}

```


###关注我（be liked）的人的列表
####接口:/QAs/getFollowers
####请求方式:GET
####接口参数

####成功返回值  同上


###提问
####接口:/QAs/question
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|receivers|array|问题接受人id列表|是|receivers[]=1&receivers[]=2|
|content|string|问题内容|是|我帅吗?|
####成功返回值  同上

####成功返回值  同上
```
{
  "ret": 200,
  "data": ""
}
```

###回答
####接口:/QAs/answer
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|questionId|long|问题id||是|123|
|content|string|答案内容|是|帅|

####成功返回值 
```
{
  "ret": 200,
  "data": ""
}
```


###获取会话列表
####接口:/QAs/getChats
####请求方式:GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|oppositeId|long|对方id|是|123|

####成功返回值 
```
// 20160713144842
// http://localhost:9111/QAs/getChats?token=df91ea2dcac39bb2e29b54ce68cc4a99&oppositeId=86

{
  "ret": 200,
  "data": [
    {
      "id": 27305,
      "sessionId": "77_86",
      "content": "123",
      "senderId": 86,
      "receiverId": 77,
      "type": "TEXT_QUESTION",
      "createTime": 1468392143720
    },
    {
      "id": 27306,
      "sessionId": "77_86",
      "content": "123",
      "senderId": 77,
      "receiverId": 86,
      "type": "TEXT_ANSWER",
      "createTime": 1468392248710
    }
  ]
}
```


###上报已读时间
####接口:/QAs/reportLastReadMessage
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|chatId|long|回话ID|是|123|

####成功返回值 
```
{
  "ret": 200,
  "data": ""
}
```
