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
##明星相关接口
###推荐明星接口
####接口:/star/recommend/list
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|size|整型|返回明星的个数|否|6|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "id": "57737578e4b061b8c7241d0c",
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
