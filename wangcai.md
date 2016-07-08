#通用参数
|参数名|类型|位置|描述|是否必须|示例|
|---|---|---|---|---|---|
|Authorization|字符串|header|用户登录凭证|是(登录、注册接口除外)|xxxxx|
|tz|字符串|parameter|用户所在时区|是|Asia/Shanghai|
|pf|字符串|parameter|客户端平台类型,ios或者android|否|iOS|
|locale|字符串|parameter|客户端语言|否|zh_CN|
#接口域名
```
  测试:api.test.enterest.me
  正式:api.nuzzle.me
  推送服务器：push.nuzzle.me
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
        "nickname":"",
        "avatar":"",
        "thumbnail":""
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
##认证相关接口
###邮箱注册接口
####接口:/passport/email/register
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|email|字符串|用户的邮箱|是|jimmy.zhang@holaverse.com|
|password|字符串|用户密码，客户端将密码进行md5加密后传输|是|JF2OFJ23FJOJWFI2JOFJ3OI2FJOWI|
|nickname|字符串|用户昵称|是|张三|
|pf|字符串|客户端平台|否|android|
|pushToken|字符串|用户的推送token|否|xxxxxxxxxxxx|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "id": "57714a9ee4b0ea4b5c459dfc",
        "token": "LMvnsTNJo4pPuW4DBUArKw==",
        "status": "NORMAL",
        "email": "jimmy@holaverse.com",
        "nickname": "Jimmy",
        "facebookId": "",
        "regDone": false,
        "type": "nobody",
        "avatar": "",
        "registerTime": 1467042462341
    }
}
```

###邮箱登录接口
####接口:/passport/email/login
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|email|字符串|用户的邮箱|是|jimmy.zhang@holaverse.com|
|password|字符串|用户密码，客户端将密码进行md5加密后传输|是|JF2OFJ23FJOJWFI2JOFJ3OI2FJOWI|
|pf|字符串|客户端平台|否|android|
|pushToken|字符串|用户的推送token|否|xxxxxxxxxxxx|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "id": "57714a9ee4b0ea4b5c459dfc",
        "token": "LMvnsTNJo4pPuW4DBUArKw==",
        "status": "NORMAL",
        "email": "jimmy@holaverse.com",
        "nickname": "Jimmy",
        "facebookId": "",
        "regDone": false,
        "type": "nobody",
        "avatar": "",
        "registerTime": 1467042462341
    }
}
```

###邮箱找回密码接口
####接口:/passport/forgot/passwd
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|email|字符串|用户的邮箱|是|jimmy.zhang@holaverse.com|
####成功返回值
```
{
    "ret": 200,
    "data": true
}
```

###修改密码接口
####接口:/passport/modify/passwd
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|oldPasswd|字符串|老密码，md5后的值|是|xxxxxxxxxxxxxxx|
|newPasswd|字符串|新密码，md5后的值|是|xxxxxxxxxxxxxxx|
####成功返回值
```
{
    "ret": 200,
    "data": true
}
```

###退出接口
####接口:/passport/logout
####请求方式:POST/GET
####接口参数
无
####成功返回值
```
{
    "ret": 200,
    "data": true
}
```

###facebook第三方登录接口
####接口:/passport/facebook/login
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|accessToken|字符串|fb授权成功后获得的accessToken|是|JF2OFJ23FJOJWFI2JOFJ3OI2FJOWI|
|oauthId|字符串|fb第三方唯一id|是|2311232141241|
|nickname|字符串|用户的昵称|是|jimmy.zhang|
|avatar|字符串|用户的头像|是|https://img.facebook.com/user/xxx/avatar.png|
|pf|字符串|客户端平台|否|android|
|pushToken|字符串|用户的推送token|否|xxxxxxxxxxxx|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "id": "57714a9ee4b0ea4b5c459dfc",
        "token": "LMvnsTNJo4pPuW4DBUArKw==",
        "status": "NORMAL",
        "email": "",
        "nickname": "Jimmy",
        "facebookId": "2112121212121212",
        "regDone": false,
        "type": "nobody",
        "isFirstTime" : false,
        "avatar": "https://img.facebook.com/user/xxx/avatar.png",
        "registerTime": 1467042462341
    }
}
```

##信息流相关接口
###举报接口
####接口:/feed/report
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|type|字符串|类型，图片还是视频，可选值有pic，video|是|pic|
|id|字符串|feed标识|是|sdf1wef1we1fw5e1f6ewf|
|reportType|字符串|举报类型，可选值有（adOrPornographic，violenceOrIllegal，fraud，copyright，threats，other）|是|other|
|reason|字符串|举报原因|否|不喜欢这个|
####成功返回值
```
{
    "ret": 200,
    "data": true
}
```
###分享接口
####接口:/feed/share
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|type|字符串|类型，图片还是视频还是应用，可选值有pic，video，app|是|pic|
|id|字符串|feed标识，当且仅当type是分享应用的时候，可以不填|是|sdf1wef1we1fw5e1f6ewf|
####成功返回值
返回页面

###feed详情接口
####接口:/feed/detail
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|type|字符串|类型，图片还是视频，可选值有pic，video|是|pic|
|id|字符串|feed标识|是|sdf1wef1we1fw5e1f6ewf|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "id": "5775edc14568298ccd4fcca5",
        "author": "57738f8ee4b0d14a93c11564",
        "height": 260,
        "words": "",
        "publishTime": 1467346371766,
        "width": 200,
        "photoUrl": "http://img2.enterest.me/test-dogs-img/user/avatar/server/dc5b6bd5-6f0d-4824-8dd4-6656e9c9983b",
        "type": "pic"
    }
}
```

###删除接口
####接口:/feed/delete
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|type|字符串|类型，图片还是视频，可选值有pic，video|是|pic|
|id|字符串|feed标识|是|sdf1wef1we1fw5e1f6ewf|
####成功返回值
```
{
    "ret": 200,
    "data": true
}
```

###信息流接口
####接口:/feed/post
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|type|字符串|类型，pic或者video|是|pic|
|photoUrl|字符串|类型，pic或者video|是|pic|
|videoUrl|字符串|类型，pic或者video|是|pic|
|width|整型|照片宽度|是|150|
|height|整型|照片高度|是|100|
|duration|整型|时长，秒级别|否|100|
|words|字符串|描述|否|顶顶顶顶顶|
|tag|字符串|首发还是独家，可选值：exclusive，premiere|否|premiere|
|free|布尔值|是否免费|是|true|
|price|浮点型|价格|否|10|
|mute|布尔值|是否静音|否|false|
|shootingTime|长整型|拍摄时间的毫秒数|否|116464646464|
####成功返回值
```
{
    "ret": 200,
    "data": true
}
```

####接口:/feed/list
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|maxId|字符串|上一个列表中最后一条记录的id|否|JFOWEJFOIJIJWOFJSF|
|size|整型|分页大小|否|10|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "publishTime": 1467072423897,
            "tag": "exclusive",
            "videoUrl": "http://img2.enterest.me/nuzzle/video/2016/06/66897E479CE26F6400102B40ED01E6AC.mp4",
            "width": 320,
            "access": false,
            "type": "video",
            "id": "5771bfa7e4b0cc8e3c175586",
            "author": "5771bfa7e4b0cc8e3c175585",
            "duration": 1583366305824246300,
            "free": false,
            "height": 240,
            "price": 0,
            "authorUserInfo": {
                "id": "5771bfa7e4b0cc8e3c175584",
                "nickname": "FHjgK",
                "avatar": ""
            },
            "words": "hello world",
            "photoUrl": "http://img2.enterest.me/test-dogs-img/img/2016/05/F1882DA2BF9CC88E1640800266D902EF.webp"
        },
        {
            "publishTime": 1467072423904,
            "tag": "starter",
            "videoUrl": "http://img2.enterest.me/nuzzle/video/2016/06/66897E479CE26F6400102B40ED01E6AC.mp4",
            "width": 320,
            "access": true,
            "type": "video",
            "id": "5771bfa7e4b0cc8e3c175589",
            "author": "5771bfa7e4b0cc8e3c175588",
            "duration": 2426710510662402600,
            "free": false,
            "height": 240,
            "price": 568,
            "authorUserInfo": {
                "id": "5771bfa7e4b0cc8e3c175587",
                "nickname": "uceMM",
                "avatar": ""
            },
            "words": "hello world",
            "photoUrl": "http://img2.enterest.me/test-dogs-img/img/2016/05/F1882DA2BF9CC88E1640800266D902EF.webp"
        },
        {
            "id": "5771bfa7e4b0cc8e3c17558b",
            "author": "5771bfa7e4b0cc8e3c17558a",
            "height": 240,
            "authorUserInfo": {
                "id": "5771bfa7e4b0cc8e3c17558a",
                "nickname": "LmNyj",
                "avatar": ""
            },
            "words": "hello world",
            "publishTime": 1467072423905,
            "tag": "starter",
            "width": 320,
            "photoUrl": "http://img2.enterest.me/test-dogs-img/img/2016/05/F1882DA2BF9CC88E1640800266D902EF.webp",
            "type": "pic"
        }
    ]
}
```
##支付相关接口
###支付校验充值
####接口:/pay/verify
####请求方式:POST/GET
####接口参数
参数示意，在body中
```
{
    "receipt-data": "xxx",
    "sign": "xxxxx",
    "recharge": [
        {
            "userId": "xxx",
            "transactionId": "xxxxxx"
        }
    ]
}
```
####成功返回值
```
{
    "ret": 200,
    "data": {
      "balance":3000,
      "transactions": [{
        "xxxxxx",
        "xxxxxx"
      }]
    }
}
```

###购买付费视频接口
####接口:/pay/view
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|type|字符串|类型，视频，可选值暂时只有video|是|video|
|id|字符串|feed标识|是|sdf1wef1we1fw5e1f6ewf|
####成功返回值
```
{
    "ret": 200,
    "data": {
      "balance" : 32444
    }
}
```
##收入相关接口
###收入摘要
####接口:/income/summary
####请求方式:POST/GET
####接口参数
无
####成功返回值
```
{
    "ret": 200,
    "data": {
      "summary" :{
        "coins" : 2324,
        "counts" : 140
      },
      "list" : [{
         "coins" : 323,
         "counts" : 4,
         "feed" : {
            "id" : "",
            "photoUrl" : "",
            "type" : "video",
            "videoUrl" : ""
         }
        }]
    }
}
```

###收入明细
####接口:/income/detail
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|type|字符串|类型，视频，可选值暂时只有video|是|video|
|id|字符串|feed标识|是|sdf1wef1we1fw5e1f6ewf|
|maxId|字符串|上一个列表中最后一条记录的id|否|JFOWEJFOIJIJWOFJSF|
|size|整型|分页大小|否|10|
####成功返回值
```
{
    "ret": 200,
    "data": {
      "summary" :{
        "coins" : 323,
        "counts" : 4,
        "feed" : {
           "id" : "",
           "photoUrl" : "",
           "type" : "video",
           "videoUrl" : ""
        }
      },
      "list" : [{
         "id" : "xxxxxx",
         "payTime" : 1234242387423423,
         "coins" : 2323,
         "user" : {
            "id" : "",
            "nickname" : "",
            "avatar" : "video"
         }
        }]
    }
}
```

##明星相关接口
###关注明星接口
####接口:/star/follow
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|明星id|是|xxxxxx|
####成功返回值
```
{
    "ret": 200,
    "data": true
}
```

###取消关注明星接口
####接口:/star/unfollow
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|明星id|是|xxxxxx|
####成功返回值
```
{
    "ret": 200,
    "data": true
}
```

###明星所有的feed列表接口
####接口:/star/feed/list
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|明星id|是|xxxxxx|
|maxId|字符串|上一页最后一个id|否|xxxx|
|size|整型|返回feed的个数|否|6|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "id": "5775edc14568298ccd4fcca5",
            "author": "57738f8ee4b0d14a93c11564",
            "height": 260,
            "words": "",
            "publishTime": 1467346371766,
            "width": 200,
            "photoUrl": "http://img2.nuzzle.com/test-dogs-img/user/avatar/server/dc5b6bd5-6f0d-4824-8dd4-6656e9c9983b",
            "type": "pic"
        }
    ]
}
```

###明星所有首发及独家的feed列表接口
####接口:/star/feed/tag/list
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|明星id|是|xxxxxx|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "feeds": [
            {
                "id": "5775edc14568298ccd4fcca5",
                "author": "57738f8ee4b0d14a93c11564",
                "height": 260,
                "words": "",
                "publishTime": 1467346371766,
                "width": 200,
                "photoUrl": "http://img2.nuzzle.com/test-dogs-img/user/avatar/server/dc5b6bd5-6f0d-4824-8dd4-6656e9c9983b",
                "type": "pic"
            }
        ],
        "userMap": {
            "id": "57738f8ee4b0d14a93c11564",
            "balance": 0,
            "nickname": "Jimmy",
            "facebookId": "",
            "hasFollow": false,
            "regDone": true,
            "code": "",
            "avatar": "",
            "signature": "",
            "fansCount": 54
        }
    }
}
```

###明星列表接口
####接口:/star/list
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|maxId|字符串|上一个列表最后一个明星id|否|xxx|
|size|整型|返回明星的个数|否|6|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "id": "57737578e4b061b8c7241d0c",
            "hasFollow" : false,
            "feeds": [
                {
                    "type": "pic",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/afbcb4eb566cff03b586d427a91c6eb2.jpeg"
                },
                {
                    "type": "pic",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/a5c587ad663b7da55955a3504c3348ee.jpeg"
                },
                {
                    "type": "video",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/162e899f92857b675278af3ce5c985ab.jpeg"
                }
            ],
            "email": "",
            "nickname": "ovmYQ",
            "facebookId": "",
            "regDone": true,
            "type": "star",
            "avatar": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/5947de73e29c3a2b98a435af41479504.jpeg",
            "signature": "I'm a big star!!!plz follow me!",
            "registerTime": 1467184504300
        },
        {
            "id": "57737578e4b061b8c7241d0d",
            "feeds": [
                {
                    "type": "pic",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/afbcb4eb566cff03b586d427a91c6eb2.jpeg"
                },
                {
                    "type": "pic",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/a5c587ad663b7da55955a3504c3348ee.jpeg"
                },
                {
                    "type": "video",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/162e899f92857b675278af3ce5c985ab.jpeg"
                }
            ],
            "email": "",
            "nickname": "HNgee",
            "facebookId": "",
            "regDone": true,
            "type": "star",
            "avatar": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/5947de73e29c3a2b98a435af41479504.jpeg",
            "signature": "I'm a big star!!!plz follow me!",
            "registerTime": 1467184504300
        },
        {
            "id": "57737578e4b061b8c7241d0e",
            "feeds": [
                {
                    "type": "pic",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/afbcb4eb566cff03b586d427a91c6eb2.jpeg"
                },
                {
                    "type": "pic",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/a5c587ad663b7da55955a3504c3348ee.jpeg"
                },
                {
                    "type": "video",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/162e899f92857b675278af3ce5c985ab.jpeg"
                }
            ],
            "email": "",
            "nickname": "IdLGb",
            "facebookId": "",
            "regDone": true,
            "type": "star",
            "avatar": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/5947de73e29c3a2b98a435af41479504.jpeg",
            "signature": "I'm a big star!!!plz follow me!",
            "registerTime": 1467184504300
        },
        {
            "id": "57737578e4b061b8c7241d0f",
            "feeds": [
                {
                    "type": "pic",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/afbcb4eb566cff03b586d427a91c6eb2.jpeg"
                },
                {
                    "type": "pic",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/a5c587ad663b7da55955a3504c3348ee.jpeg"
                },
                {
                    "type": "video",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/162e899f92857b675278af3ce5c985ab.jpeg"
                }
            ],
            "email": "",
            "nickname": "wJpuU",
            "facebookId": "",
            "regDone": true,
            "type": "star",
            "avatar": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/5947de73e29c3a2b98a435af41479504.jpeg",
            "signature": "I'm a big star!!!plz follow me!",
            "registerTime": 1467184504300
        },
        {
            "id": "57737578e4b061b8c7241d10",
            "feeds": [
                {
                    "type": "pic",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/afbcb4eb566cff03b586d427a91c6eb2.jpeg"
                },
                {
                    "type": "pic",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/a5c587ad663b7da55955a3504c3348ee.jpeg"
                },
                {
                    "type": "video",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/162e899f92857b675278af3ce5c985ab.jpeg"
                }
            ],
            "email": "",
            "nickname": "lnkjQ",
            "facebookId": "",
            "regDone": true,
            "type": "star",
            "avatar": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/5947de73e29c3a2b98a435af41479504.jpeg",
            "signature": "I'm a big star!!!plz follow me!",
            "registerTime": 1467184504300
        },
        {
            "id": "57737578e4b061b8c7241d11",
            "feeds": [
                {
                    "type": "pic",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/afbcb4eb566cff03b586d427a91c6eb2.jpeg"
                },
                {
                    "type": "pic",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/a5c587ad663b7da55955a3504c3348ee.jpeg"
                },
                {
                    "type": "video",
                    "photoUrl": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/162e899f92857b675278af3ce5c985ab.jpeg"
                }
            ],
            "email": "",
            "nickname": "EvjNo",
            "facebookId": "",
            "regDone": true,
            "type": "star",
            "avatar": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/5947de73e29c3a2b98a435af41479504.jpeg",
            "signature": "I'm a big star!!!plz follow me!",
            "registerTime": 1467184504301
        }
    ]
}
```

##用户相关接口
###修改签名
####接口:/user/modify/signature
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|signature|字符串|新的签名|是|xxxxxxxxxxxxxxx|
####成功返回值
```
{
    "ret": 200,
    "data": {
      "id": "xxxxxxxxx",
      "email": "",
      "nickname": "EvjNo",
      "facebookId": "",
      "regDone": true,
      "type": "star",
      "avatar": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/5947de73e29c3a2b98a435af41479504.jpeg",
      "signature": "I'm a big star!!!plz follow me!",
      "registerTime": 1467184504301
    }
}
```

###修改个人信息
####接口:/user/modify/profile
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|nickname|字符串|昵称，昵称头像至少填写一个|是|xxxxxxxxxxxxxxx|
|avatar|字符串|头像，昵称头像至少填写一个|是|xxxxxxxxxxxxxxx|
####成功返回值
```
{
    "ret": 200,
    "data": {
      "id": "xxxxxxxxx",
      "email": "",
      "nickname": "EvjNo",
      "facebookId": "",
      "regDone": true,
      "type": "star",
      "avatar": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/5947de73e29c3a2b98a435af41479504.jpeg",
      "signature": "I'm a big star!!!plz follow me!",
      "registerTime": 1467184504301
    }
}
```

###获得个人信息
####接口:/user/profile
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|要查看的用户id，若为空，返回自己的详情|否|xxxxxxxxxxxxxxx|
####成功返回值
```
{
    "ret": 200,
    "data": {
      "id": "xxxxxxxxx",
      "email": "",
      "nickname": "EvjNo",
      "facebookId": "",
      "regDone": true,
      "type": "star",
      "avatar": "http://video.iwifiapi.com/wow-video/cover/480/video/2016/06/5947de73e29c3a2b98a435af41479504.jpeg",
      "signature": "I'm a big star!!!plz follow me!",
      "registerTime": 1467184504301
    }
}
```

##存储相关接口
###获得s3上传token
####接口:/aws/store/token
####请求方式:POST/GET
####接口参数
无
####成功返回值
```
{
    "ret": 200,
    "data": "h6/jpoWsgKAXRjEtRW6EhAUqiEQg92MhkrBMqMNRhFWSh+2R8qXjm1QwTNuSke3IkucVTBg6zlc5StULR/Zuev3lfzaqwaN0ucwkzOs8/oIG3+aQ3y766GYGs+GkkMs9laoLDJBVmRc+0yi9ula3SM999allw2mCj7ASgk23w5zU/B2fmHrA/MTsoyMD5mGgL4Bq/3GvTi7I1rfOAmfGp2T5rL6+B1xspsQL9aFHG9cNj5Sr9wjLAPwZywDocAXc5zzu0O7Sb7A0teUPi13TJ+LNgK5gdbtnGEhnmlx9kRadGr5NcS46wlyGE0jwWQq3cijBKcghdOPXyw1N3D7qsHoB4EtcWt+fInl8itYAEzDxdfS9kFjfWB7CHDXjXB4SM/u6otcvm2qfIt3k60Pi/0wD01ozPmCeYFTlJdV0p+cam0ynorMDkbK+OMDxjEyoLR7dnkcfudAUoC7xEzXQ+xg3v2gxsJ1tIm6XnGV/J/7XK5awc+fVptNEWRlX7hjaNDL3T9cbNiC9W+xyW6mzLYLcnoEMFBuyQ9huAGI9j8DLn9QahDWWirRY3iAZhKQrpFp57D8qsKrWNMyk7zWyN7MlwILG1mAiIy0DdJB0U+8JQ8iZMoSu8cAzI0wBKnh/z1G2PP11SVjrIel4CNUa9DYTlO6J8ve/xgsLv6Cy9v02taH2lZ7KaGb/KjRYgWJw/k0e7qJdWKJZ3LkdazwhYQXyKyvfH7BAaO7JucylDWyOMNs38M00xXwtV8BDsLWn"
}
```


#错误码
|错误码|含义|
|---|---|
|SERVER_ERROR|系统错误|
|PARAM_ERROR|参数错误|
|USER_NOT_LOGIN|用户未登录|
|USER_NOT_EXIST|用户不存在|
|USER_IS_CANCELED|用户被封禁|
|USER_HAS_EXIST|用户已经存在|
|NICKNAME_IS_INVALID|昵称不合法|
|PASSWD_NOT_MATCH|密码不匹配|
|BALANCE_NOT_ENOUGH|余额不足|
|NOT_ALLOWED|不允许的操作|
|USER_BOUGHT|已有用户购买|
