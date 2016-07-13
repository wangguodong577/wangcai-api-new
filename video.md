#通用参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|token|字符串|用户登录凭证|是(登录、注册接口除外)||
|tz|字符串|用户所在时区|是|Asia/Shanghai|
|pf|字符串|客户端平台类型,ios或者android|是|ios|
#接口域名
```
  测试:
    接口：apitest.video.iwifiapi.com
    后台：admintest.video.iwifiapi.com
  正式:
    接口：api.video.iwifiapi.com
    后台：admin.video.iwifiapi.com
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
##话题相关接口
###话题列表
####接口:/topic/list
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|score|字符串|上一个视频的score，若为空，则从最大的开始|否|12343131564|
|size|整型|返回条数，默认10|否|10|
####成功返回值
```
{
    "timestamp": 1464577677439,
    "ret": 200,
    "data": [
        {
            "id": "57483425e4b04bf232fa612c",
            "name": "hey，你在吃啥？",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/789c7cefb49d2848b98f540aad764461.jpg",
            "sightCount": 8,
            "userCount": 3,
            "createTime": 1464349733000,
            "likeCount": 7,
            "score": 1464575305155,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                }
            ]
        },
        {
            "id": "57490133e4b00fa654fb3598",
            "name": "你的独特笑声 ",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/63e1bd433b640085ccad1b160bc7484a.jpg",
            "sightCount": 5,
            "userCount": 3,
            "createTime": 1464402227019,
            "likeCount": 22,
            "score": 1464575275328,
            "users": [
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                },
                {
                    "id": "5718470ee4b03799b4b2e592",
                    "nickname": "Junxu Wang",
                    "avatar": "https://graph.facebook.com/108211386249243/picture?type=large&cacheTime=1461208850249"
                },
                {
                    "id": "5718470ee4b03799b4b2e592",
                    "nickname": "Junxu Wang",
                    "avatar": "https://graph.facebook.com/108211386249243/picture?type=large&cacheTime=1461208850249"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                }
            ]
        },
        {
            "id": "5748ef9fe4b00fa654fb3594",
            "name": "你今天穿啥鞋子？",
            "creator": "572c9636e4b0a39362b519c6",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/9327cf5df33febe1f8e0356aaba9fcdb.jpg",
            "sightCount": 2,
            "userCount": 1,
            "createTime": 1464397727357,
            "likeCount": 5,
            "score": 1464575085151,
            "users": [
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                }
            ]
        },
        {
            "id": "5749128ee4b00fa654fb359b",
            "name": "六秒钟，你想对你的前任说什么？",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "",
            "sightCount": 2,
            "userCount": 1,
            "createTime": 1464406670279,
            "likeCount": 2,
            "score": 1464514655217,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                }
            ]
        },
        {
            "id": "57487ce8e4b092318903e0ae",
            "name": "夜深了，道声晚安。",
            "creator": "5717203ce4b0af7349ac8336",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/be26a8be52f941cf048c6da9da9437ca.jpg",
            "sightCount": 6,
            "userCount": 4,
            "createTime": 1464368361000,
            "likeCount": 11,
            "score": 1464406880627,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "5718470ee4b03799b4b2e592",
                    "nickname": "Junxu Wang",
                    "avatar": "https://graph.facebook.com/108211386249243/picture?type=large&cacheTime=1461208850249"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                }
            ]
        },
        {
            "id": "57485358e4b03ddb60b1e272",
            "name": "拍一下HOLA所有加班狗的屏幕",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/b0531d0b9eaa136a9c89d62f6f280586.jpg",
            "sightCount": 6,
            "userCount": 3,
            "createTime": 1464357721000,
            "likeCount": 5,
            "score": 1464373116363,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                }
            ]
        },
        {
            "id": "5748720ae4b032c838af5b49",
            "name": "六秒钟，你想对你的前任说什么？",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/e2f0090ef0b067bc3136c716e82c4cfc.jpg",
            "sightCount": 3,
            "userCount": 2,
            "createTime": 1464365578000,
            "likeCount": 3,
            "score": 1464373061072,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                }
            ]
        },
        {
            "id": "57483325e4b04bf232fa6128",
            "name": "如果这六秒钟你说的话，能被全世界看到，你想说什么？",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/55df35848196e4352afafdef76c66120.jpg",
            "sightCount": 3,
            "userCount": 2,
            "createTime": 1464349477000,
            "likeCount": 3,
            "score": 1464369401188,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                }
            ]
        },
        {
            "id": "574832e5e4b04bf232fa6125",
            "name": "Hello world",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/55df35848196e4352afafdef76c66120.jpg",
            "sightCount": 8,
            "userCount": 3,
            "createTime": 1464349414000,
            "likeCount": 8,
            "score": 1464369401187,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                }
            ]
        },
        {
            "id": "574844a7e4b04bf232fa612f",
            "name": "hey，你在吃啥？",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/789c7cefb49d2848b98f540aad764461.jpg",
            "sightCount": 6,
            "userCount": 2,
            "createTime": 1464353959000,
            "likeCount": 0,
            "score": 1464369401183,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                }
            ]
        }
    ]
}
```

###置顶话题列表
####接口:/topic/hotlist
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|score|字符串|上一个视频的score，若为空，则从0的开始|否|1|
|size|整型|返回条数，默认10|否|10|
####成功返回值
```
{
    "timestamp": 1464577677439,
    "ret": 200,
    "data": [
        {
            "id": "57483425e4b04bf232fa612c",
            "name": "hey，你在吃啥？",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/789c7cefb49d2848b98f540aad764461.jpg",
            "sightCount": 8,
            "userCount": 3,
            "createTime": 1464349733000,
            "likeCount": 7,
            "score": 1464575305155,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                }
            ]
        },
        {
            "id": "57490133e4b00fa654fb3598",
            "name": "你的独特笑声 ",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/63e1bd433b640085ccad1b160bc7484a.jpg",
            "sightCount": 5,
            "userCount": 3,
            "createTime": 1464402227019,
            "likeCount": 22,
            "score": 1464575275328,
            "users": [
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                },
                {
                    "id": "5718470ee4b03799b4b2e592",
                    "nickname": "Junxu Wang",
                    "avatar": "https://graph.facebook.com/108211386249243/picture?type=large&cacheTime=1461208850249"
                },
                {
                    "id": "5718470ee4b03799b4b2e592",
                    "nickname": "Junxu Wang",
                    "avatar": "https://graph.facebook.com/108211386249243/picture?type=large&cacheTime=1461208850249"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                }
            ]
        },
        {
            "id": "5748ef9fe4b00fa654fb3594",
            "name": "你今天穿啥鞋子？",
            "creator": "572c9636e4b0a39362b519c6",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/9327cf5df33febe1f8e0356aaba9fcdb.jpg",
            "sightCount": 2,
            "userCount": 1,
            "createTime": 1464397727357,
            "likeCount": 5,
            "score": 1464575085151,
            "users": [
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                }
            ]
        },
        {
            "id": "5749128ee4b00fa654fb359b",
            "name": "六秒钟，你想对你的前任说什么？",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "",
            "sightCount": 2,
            "userCount": 1,
            "createTime": 1464406670279,
            "likeCount": 2,
            "score": 1464514655217,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                }
            ]
        },
        {
            "id": "57487ce8e4b092318903e0ae",
            "name": "夜深了，道声晚安。",
            "creator": "5717203ce4b0af7349ac8336",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/be26a8be52f941cf048c6da9da9437ca.jpg",
            "sightCount": 6,
            "userCount": 4,
            "createTime": 1464368361000,
            "likeCount": 11,
            "score": 1464406880627,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "5718470ee4b03799b4b2e592",
                    "nickname": "Junxu Wang",
                    "avatar": "https://graph.facebook.com/108211386249243/picture?type=large&cacheTime=1461208850249"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                }
            ]
        },
        {
            "id": "57485358e4b03ddb60b1e272",
            "name": "拍一下HOLA所有加班狗的屏幕",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/b0531d0b9eaa136a9c89d62f6f280586.jpg",
            "sightCount": 6,
            "userCount": 3,
            "createTime": 1464357721000,
            "likeCount": 5,
            "score": 1464373116363,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                }
            ]
        },
        {
            "id": "5748720ae4b032c838af5b49",
            "name": "六秒钟，你想对你的前任说什么？",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/e2f0090ef0b067bc3136c716e82c4cfc.jpg",
            "sightCount": 3,
            "userCount": 2,
            "createTime": 1464365578000,
            "likeCount": 3,
            "score": 1464373061072,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                }
            ]
        },
        {
            "id": "57483325e4b04bf232fa6128",
            "name": "如果这六秒钟你说的话，能被全世界看到，你想说什么？",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/55df35848196e4352afafdef76c66120.jpg",
            "sightCount": 3,
            "userCount": 2,
            "createTime": 1464349477000,
            "likeCount": 3,
            "score": 1464369401188,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                }
            ]
        },
        {
            "id": "574832e5e4b04bf232fa6125",
            "name": "Hello world",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/55df35848196e4352afafdef76c66120.jpg",
            "sightCount": 8,
            "userCount": 3,
            "createTime": 1464349414000,
            "likeCount": 8,
            "score": 1464369401187,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                },
                {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                }
            ]
        },
        {
            "id": "574844a7e4b04bf232fa612f",
            "name": "hey，你在吃啥？",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/789c7cefb49d2848b98f540aad764461.jpg",
            "sightCount": 6,
            "userCount": 2,
            "createTime": 1464353959000,
            "likeCount": 0,
            "score": 1464369401183,
            "users": [
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                }
            ]
        }
    ]
}
```

###发布视频，参加某个话题
####接口:/topic/join
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|topicId|字符串|话题id|是|xxxxxxxxx|
|title|字符串|视频标题，预留字段，也许能用得上呢|否|xxxxxxxxx|
|url|字符串|视频链接|是|/xxxx/xx/xxx.mp4|
|cover|字符串|视频链接|否|/xxxx/xx/xxx.jpeg|
|height|整型|高度|否|34|
|width|整型|宽度|否|45|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###创建话题并上传视频接口
####接口:/topic/create
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|sights|字符串|创建话题的数据，详见示例|是|xxxxxxxxxxxxx|
示例：
```
{
    "topicName": "",
    "cover": "",
    "type": 1,
    "sights": [
        {
            "url": "",
            "title": "xxxxx",
            "cover": "",
            "width": 4,
            "height": 43
        }
    ]
}
```
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###话题点赞用户列表
####接口:/topic/likelist
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|topicId|字符串|话题ID|是|asdf2jr2ojflajfjlkajfsdfsaf|
|maxId|字符串|上一个列表最后一条记录的ID|否|asdf2jr2ojflajfjlkajfsdfsaf|
|size|整型|要获取的记录数|否|10|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "list": [
            {
                "id": "574ba46be4b00fa654fb35a2",
                "nickname": "Zhuomian Wang",
                "hasFollow" : true,
                "avatar": "https://graph.facebook.com/1548236228815896/picture?type=large&cacheTime=1464575088316"
            },
            {
                "id": "574ab77ce4b00fa654fb35a0",
                "nickname": "Jingyu Zhao",
                "hasFollow" : flase,
                "avatar": "https://graph.facebook.com/1039369769483637/picture?type=large&cacheTime=1464514410406"
            },
            {
                "id": "574832d0e4b04bf232fa6124",
                "nickname": "Reborn Zms",
                "hasFollow" : true,
                "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
            }
        ],
        "recommends":[]
    }
}
```

###用户参与的话题列表
####接口:/topic/joinlist
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|对方的ID|是|asdf2jr2ojflajfjlkajfsdfsaf|
|maxId|字符串|上一个列表最后一条记录的ID|否|asdf2jr2ojflajfjlkajfsdfsaf|
|size|整型|要获取的记录数|否|10|
####成功返回值
```
{
    "timestamp": 1466066393840,
    "ret": 200,
    "data": {
        "topicList": [
            {
                "id": "574bbcf1e4b0b55e4efb9857",
                "name": "Your Dog",
                "creator": "574ba46be4b00fa654fb35a2",
                "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/7996d37f0df1c877fe5c17f31999a6d8.jpg",
                "sightCount": 11,
                "userCount": 7,
                "createTime": 1464581362000,
                "status": "PUBLIC",
                "firstSightIndex": 5,
                "creatorUserInfo": {
                    "id": "574ba46be4b00fa654fb35a2",
                    "nickname": "Zhuomian Wang",
                    "type": 1,
                    "avatar": "https://graph.facebook.com/1548236228815896/picture?type=large&cacheTime=1464575088316"
                },
                "likeCount": 13
            },
            {
                "id": "57612f18e4b09518b8c8ae1b",
                "name": "Sit down keep it real",
                "creator": "1036998860259618816",
                "cover": "https://v.cdn.vine.co/r/thumbs/19C0FD0CFC1354743015188643840_4eeec09ad41.0.2.967535600775393501.mp4.jpg?versionId=WUEQEgAsL.YjEBOU1TSoIpR.vIyNTxag",
                "sightCount": 4,
                "userCount": 2,
                "createTime": 1465986841000,
                "status": "PUBLIC",
                "firstSightIndex": 1,
                "creatorUserInfo": {
                    "id": "1036998860259618816",
                    "nickname": "Christopher",
                    "type": 0,
                    "avatar": "https://v.cdn.vine.co/r/avatars/72760D382E1318774421976141824_41956ccba96.0.2.jpg?versionId=wST.HMu0daKjaSJQyPGsOMuP1W9uWJUU"
                },
                "likeCount": 1
            }
        ],
        "userInfo": {
            "id": "5757e2dfe4b0b336d4f045bf",
            "status": "NORMAL",
            "regTime": 1465377504000,
            "nickname": "王新宇",
            "locale": "zh_CN",
            "gender": "male",
            "type": 1,
            "avatar": "https://graph.facebook.com/177798332622820/picture?type=large&cacheTime=1465377441545",
            "lastLoginTime": 1466063773000,
            "fansCount": 2,
            "followCount": 1,
            "sightCount": 25,
            "hasFollow": false
        }
    }
}
```

###用户创建的话题列表
####接口:/topic/createlist
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|对方的ID|是|asdf2jr2ojflajfjlkajfsdfsaf|
|maxId|字符串|上一个列表最后一条记录的ID|否|asdf2jr2ojflajfjlkajfsdfsaf|
|size|整型|要获取的记录数|否|10|
####成功返回值
```
{
    "timestamp": 1466066393840,
    "ret": 200,
    "data": {
        "topicList": [
            {
                "id": "574bbcf1e4b0b55e4efb9857",
                "name": "Your Dog",
                "creator": "574ba46be4b00fa654fb35a2",
                "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/7996d37f0df1c877fe5c17f31999a6d8.jpg",
                "sightCount": 11,
                "userCount": 7,
                "createTime": 1464581362000,
                "status": "PUBLIC",
                "firstSightIndex": 5,
                "creatorUserInfo": {
                    "id": "574ba46be4b00fa654fb35a2",
                    "nickname": "Zhuomian Wang",
                    "type": 1,
                    "avatar": "https://graph.facebook.com/1548236228815896/picture?type=large&cacheTime=1464575088316"
                },
                "likeCount": 13
            },
            {
                "id": "57612f18e4b09518b8c8ae1b",
                "name": "Sit down keep it real",
                "creator": "1036998860259618816",
                "cover": "https://v.cdn.vine.co/r/thumbs/19C0FD0CFC1354743015188643840_4eeec09ad41.0.2.967535600775393501.mp4.jpg?versionId=WUEQEgAsL.YjEBOU1TSoIpR.vIyNTxag",
                "sightCount": 4,
                "userCount": 2,
                "createTime": 1465986841000,
                "status": "PUBLIC",
                "firstSightIndex": 1,
                "creatorUserInfo": {
                    "id": "1036998860259618816",
                    "nickname": "Christopher",
                    "type": 0,
                    "avatar": "https://v.cdn.vine.co/r/avatars/72760D382E1318774421976141824_41956ccba96.0.2.jpg?versionId=wST.HMu0daKjaSJQyPGsOMuP1W9uWJUU"
                },
                "likeCount": 1
            }
        ],
        "userInfo": {
            "id": "5757e2dfe4b0b336d4f045bf",
            "status": "NORMAL",
            "regTime": 1465377504000,
            "nickname": "王新宇",
            "locale": "zh_CN",
            "gender": "male",
            "type": 1,
            "avatar": "https://graph.facebook.com/177798332622820/picture?type=large&cacheTime=1465377441545",
            "lastLoginTime": 1466063773000,
            "fansCount": 2,
            "followCount": 1,
            "sightCount": 25,
            "hasFollow": false
        }
    }
}
```

###某话题下的视频列表
####接口:/sight/list
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|topicId|字符串|话题id|是|xxxxxxxxxxxxx|
|maxId|字符串|上一个列表中最后一个视频id|否|xxxxxxxxxxxxx|
|size|整型|大小|否|32|
####成功返回值
```
{
    "timestamp": 1464577729286,
    "ret": 200,
    "data": {
        "sightCount": 10,
        "sightLimit": -1,
        "topic": {
            "id": "57483425e4b04bf232fa612c",
            "name": "hey，你在吃啥？",
            "creator": "574832d0e4b04bf232fa6124",
            "cover": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/789c7cefb49d2848b98f540aad764461.jpg",
            "sightCount": 2,
            "userCount": 1,
            "createTime": 1464349733000,
            "creatorUserInfo": {
                "id": "574832d0e4b04bf232fa6124",
                "nickname": "Reborn Zms",
                "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
            }
        },
        "sights": [
            {
                "id": "57483425e4b04bf232fa612d",
                "vid": "76088954",
                "topicId": "57483425e4b04bf232fa612c",
                "author": "574832d0e4b04bf232fa6124",
                "title": "",
                "url": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/5dc4634bbe481dd3bde2c99f96f150ba.mp4",
                "cover": "",
                "width": 0,
                "height": 0,
                "publishTime": 1464349734000,
                "likes": 3,
                "comments": 0,
                "views": 0,
                "locale": "",
                "status": "PUBLIC",
                "type": "MP4",
                "userInfo": {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                "hadLike": false
            },
            {
                "id": "57483425e4b04bf232fa612e",
                "vid": "25997552",
                "topicId": "57483425e4b04bf232fa612c",
                "author": "574832d0e4b04bf232fa6124",
                "title": "",
                "url": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/7bfe72e6dc40285114f304fb86a11ebf.mp4",
                "cover": "",
                "width": 0,
                "height": 0,
                "publishTime": 1464349734000,
                "likes": 1,
                "comments": 0,
                "views": 0,
                "locale": "",
                "status": "PUBLIC",
                "type": "MP4",
                "userInfo": {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                "hadLike": false
            },
            {
                "id": "574848d5e4b04bf232fa6134",
                "vid": "31658197",
                "topicId": "57483425e4b04bf232fa612c",
                "author": "572c9636e4b0a39362b519c6",
                "title": "",
                "url": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/137aea7f0d47265f38a5786149b420c2.mp4",
                "cover": "",
                "width": 100,
                "height": 100,
                "publishTime": 1464355029000,
                "likes": 1,
                "comments": 0,
                "views": 0,
                "locale": "",
                "status": "PREPARED",
                "type": "MP4",
                "userInfo": {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                "hadLike": false
            },
            {
                "id": "574851dee4b03ddb60b1e26e",
                "vid": "22166049",
                "topicId": "57483425e4b04bf232fa612c",
                "author": "574832d0e4b04bf232fa6124",
                "title": "",
                "url": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/35911994703d6a1a87b9e44f23aa7160.mp4",
                "cover": "",
                "width": 100,
                "height": 100,
                "publishTime": 1464357343000,
                "likes": 1,
                "comments": 0,
                "views": 0,
                "locale": "",
                "status": "PREPARED",
                "type": "MP4",
                "userInfo": {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                "hadLike": false
            },
            {
                "id": "5748522ae4b03ddb60b1e26f",
                "vid": "66024201",
                "topicId": "57483425e4b04bf232fa612c",
                "author": "572c9636e4b0a39362b519c6",
                "title": "",
                "url": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/f78e6f8f4dbbe70e77df1bdb4fe37f76.mp4",
                "cover": "",
                "width": 100,
                "height": 100,
                "publishTime": 1464357418000,
                "likes": 0,
                "comments": 0,
                "views": 0,
                "locale": "",
                "status": "PREPARED",
                "type": "MP4",
                "userInfo": {
                    "id": "572c9636e4b0a39362b519c6",
                    "nickname": "廖进",
                    "avatar": "https://graph.facebook.com/1047978161916701/picture?type=large&cacheTime=1462539837960"
                },
                "hadLike": false
            },
            {
                "id": "5748523ee4b03ddb60b1e270",
                "vid": "72476967",
                "topicId": "57483425e4b04bf232fa612c",
                "author": "574832d0e4b04bf232fa6124",
                "title": "",
                "url": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/4e0cbb6bd9e1856a45622dc0d1cfcb88.mp4",
                "cover": "",
                "width": 100,
                "height": 100,
                "publishTime": 1464357439000,
                "likes": 1,
                "comments": 0,
                "views": 0,
                "locale": "",
                "status": "PREPARED",
                "type": "MP4",
                "userInfo": {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                "hadLike": false
            },
            {
                "id": "57485295e4b03ddb60b1e271",
                "vid": "21783802",
                "topicId": "57483425e4b04bf232fa612c",
                "author": "574832d0e4b04bf232fa6124",
                "title": "",
                "url": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/0d72728dff6f9ea5578e3160887d264b.mp4",
                "cover": "",
                "width": 100,
                "height": 100,
                "publishTime": 1464357526000,
                "likes": 0,
                "comments": 0,
                "views": 0,
                "locale": "",
                "status": "PREPARED",
                "type": "MP4",
                "userInfo": {
                    "id": "574832d0e4b04bf232fa6124",
                    "nickname": "Reborn Zms",
                    "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
                },
                "hadLike": false
            },
            {
                "id": "57485c75e4b01b4fe5847757",
                "vid": "57280027",
                "topicId": "57483425e4b04bf232fa612c",
                "author": "5717203ce4b0af7349ac8336",
                "title": "",
                "url": "http://testvideo.iwifiapi.com/wow-video/video/2016/05/40b357bb11737f2ad27dbf2b276ab0c3.mp4",
                "cover": "",
                "width": 100,
                "height": 100,
                "publishTime": 1464360053000,
                "likes": 0,
                "comments": 0,
                "views": 0,
                "locale": "",
                "status": "PUBLIC",
                "type": "MP4",
                "userInfo": {
                    "id": "5717203ce4b0af7349ac8336",
                    "nickname": "臧春晖",
                    "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983"
                },
                "hadLike": false
            }
        ]
    }
}
```

###视频点赞用户列表
####接口:/sight/likelist
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|id|字符串|视频id|是|xxxxxxxxxxxxx|
|size|整型|大小|否|32|
####成功返回值
```
{
    "timestamp": 1464577763354,
    "ret": 200,
    "data": [
        {
            "id": "574ba46be4b00fa654fb35a2",
            "nickname": "Zhuomian Wang",
            "avatar": "https://graph.facebook.com/1548236228815896/picture?type=large&cacheTime=1464575088316"
        },
        {
            "id": "574ab77ce4b00fa654fb35a0",
            "nickname": "Jingyu Zhao",
            "avatar": "https://graph.facebook.com/1039369769483637/picture?type=large&cacheTime=1464514410406"
        },
        {
            "id": "574832d0e4b04bf232fa6124",
            "nickname": "Reborn Zms",
            "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
        }
    ]
}
```

###点赞接口
####接口:/sight/like
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|id|字符串|视频id|是|xxxxxxxxxxxxx|
|topicId|字符串|视频所在组点id|是|xxxxxxxxxxxxx|
|author|字符串|视频作者id|是|xxxxxxxxxxxxx|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###取消点赞接口
####接口:/sight/dislike
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|id|字符串|视频id|是|xxxxxxxxxxxxx|
|topicId|字符串|视频所在组点id|是|xxxxxxxxxxxxx|
|author|字符串|视频作者id|是|xxxxxxxxxxxxx|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###记录阅读接口
####接口:/sight/view
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|id|字符串|视频id|是|xxxxxxxxxxxxx|
|topicId|字符串|视频所在组点id|是|xxxxxxxxxxxxx|
|author|字符串|视频作者id|是|xxxxxxxxxxxxx|
|uniqId|字符串|设备唯一标志，区分每一个用户|是|xxxxxxxxxxxxx|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###举报接口
####接口:/sight/report
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|id|字符串|视频id|是|xxxxxxxxxxxxx|
|topicId|字符串|视频所在组点id|是|xxxxxxxxxxxxx|
|author|字符串|视频作者id|是|xxxxxxxxxxxxx|
|type|整型|举报类型|是|1，2，3，4|
|reason|字符串|举报原因|否|很黄很暴力|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###获得主题库随机主题
####接口:/recommend/topic
####请求方式:POST/GET
####接口参数
无
####成功返回值
```
{
    "timestamp": 1464678112085,
    "ret": 200,
    "data": {
        "names": [
            "Whats outside your window now",
            "Hey，what are you eating now？",
            "Show me an awkward smile",
            "What would you like to tell your ex in 6 secs",
            "Say hello to the world",
            "Your laughter",
            "Lip Sync a Song",
            "Guess which animal I am by the sound",
            "Show Me your room now",
            "Sexiest part of your body",
            "What would you like to tell the world if you have 6 seconds",
            "Say Goodnight to the people who are going to sleep",
            "What do your shoes look like?",
            "Two second sexy face",
            "Your Cat",
            "Tell Someone They ‘re beautiful",
            "Show me your best moves",
            "Your Dog"
        ]
    }
}
```
##用户相关接口
###用户登录
####接口:/user/login
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|accessToken|字符串|第三方登录成功凭证|是(type为fb或gg时必须)|asdf2jr2ojflajfjlkajfsdfsaf|
|oauthId|字符串|第三方系统唯一标识|是(type为fb或gg时必须)|165464616546|
|type|字符串|第三方账号来源,值为:fb\gg\email\nickname|是|fb|
|email|字符串|邮箱|是|test@ttt.com|
|password|字符串|加密后的md5，邮箱时必须|是|MFO23JFO2JF203FJJASFJ2J3LFRJ2L3KJ242|
|nickname|字符串|昵称|是|廖进|
|avatar|字符串|头像|是|/avatar/232.png|
|gender|字符串|性别，可选值有male或female|否|male|
|pf|字符串|客户端平台，可选值有android和iOS|否|iOS|
|pushToken|字符串|推送token|否|JDKLFJLJLFKJDKLJFLJIOIUJFJFJIODEJFOIJFKL|
####成功返回值
```
{
    "ret":200,
    "data":{
        "token":"",
        "userId":"",
        "nickname":"",
        "avatar":"",
        "id":"",
        "thumbnail":""
    }
}
```

###用户注册
####接口:/user/register
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|email|字符串|邮箱|否|test@ttt.com|
|password|字符串|加密后的md5，邮箱时必须|是|MFO23JFO2JF203FJJASFJ2J3LFRJ2L3KJ242|
|nickname|字符串|昵称|是|廖进|
|avatar|字符串|头像|是|/avatar/232.png|
|tz|字符串|用户时区|是|Asia/Shanghai|
|locale|字符串|客户端语言|是|zh_CN|
|gender|字符串|性别，可选值有male或female|否|male|
|pf|字符串|客户端平台，可选值有android和iOS|否|iOS|
|pushToken|字符串|推送token|否|JDKLFJLJLFKJDKLJFLJIOIUJFJFJIODEJFOIJFKL|
####成功返回值
```
{
    "ret":200,
    "data":{
        "token":"",
        "id":"",
        "userId":"",
        "nickname":"",
        "avatar":"",
        "thumbnail":""
    }
}
```

###更新用户推送token接口
####接口:/user/update/pushtoken
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|pf|字符串|客户端平台，可选值有android和iOS|是|iOS|
|pushToken|字符串|推送token|是|JDKLFJLJLFKJDKLJFLJIOIUJFJFJIODEJFOIJFKL|
####成功返回值
```
{
    "ret":200,
    "data":true
}
```

###用户未读消息列表
####接口:/user/messagebox
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|maxId|字符串|上一个列表最后一条记录的ID|否|asdf2jr2ojflajfjlkajfsdfsaf|
|size|整型|要获取的记录数|否|10|
####成功返回值
```
{
    "ret":200,
    "data":[{
      "type":"beingFollowed",
      "oppositeUserInfo":{
        "id":"",
        "avatar":"",
        "nickname":""
      },
      "sightInfo": {
        "id":"",
        "cover":""
      }
      }]
}
```

###用户是否有未读消息
####接口:/user/hasunread
####请求方式:POST/GET
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":{
      "hasUnreadMessage":true
    }
}
```

###推荐关注用户列表
####接口:/recommend/user
####请求方式:POST/GET
####接口参数
无
####成功返回值
```
{
    "timestamp": 1465808666019,
    "ret": 200,
    "data": [
        {
            "id": "5717203ce4b0af7349ac8336",
            "status": "NORMAL",
            "regTime": 1461133373000,
            "nickname": "臧春晖",
            "locale": "zh_CN, zh_CN",
            "gender": "male",
            "type": 1,
            "avatar": "https://graph.facebook.com/1598531320467255/picture?type=large&cacheTime=1461133370983",
            "lastLoginTime": 1465388550000
        },
        {
            "id": "57184784e4b03799b4b2e593",
            "status": "NORMAL",
            "regTime": 1461208965000,
            "nickname": "曹玉玲",
            "locale": "zh_CN, zh_CN",
            "gender": "female",
            "type": 1,
            "avatar": "https://graph.facebook.com/1329162890443463/picture?type=large&cacheTime=1461208963734",
            "lastLoginTime": 1464860815000
        },
        {
            "id": "574832d0e4b04bf232fa6124",
            "status": "NORMAL",
            "regTime": 1464349393000,
            "nickname": "Reborn Zms",
            "locale": "zh_CN, zh_CN",
            "gender": "male",
            "type": 1,
            "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987",
            "lastLoginTime": 1465391804000
        }
    ]
}
```
###关注
####接口:/user/follow
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|对方的ID|是|asdf2jr2ojflajfjlkajfsdfsaf|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```
###取消关注
####接口:/user/unfollow
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|对方的ID|是|asdf2jr2ojflajfjlkajfsdfsaf|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```
###关注列表
####接口:/user/followlist
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|对方的ID|是|asdf2jr2ojflajfjlkajfsdfsaf|
|maxId|字符串|上一个列表最后一条记录的ID|否|asdf2jr2ojflajfjlkajfsdfsaf|
|size|整型|要获取的记录数|否|10|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "recommends": [
            {
                "id": "574ba46be4b00fa654fb35a2",
                "nickname": "Zhuomian Wang",
                "avatar": "https://graph.facebook.com/1548236228815896/picture?type=large&cacheTime=1464575088316"
            }
        ],
        "list": [
            {
                "id": "574ba46be4b00fa654fb35a2",
                "nickname": "Zhuomian Wang",
                "hasFollow" : false,
                "avatar": "https://graph.facebook.com/1548236228815896/picture?type=large&cacheTime=1464575088316"
            },
            {
                "id": "574ab77ce4b00fa654fb35a0",
                "nickname": "Jingyu Zhao",
                "hasFollow" : true,
                "avatar": "https://graph.facebook.com/1039369769483637/picture?type=large&cacheTime=1464514410406"
            },
            {
                "id": "574832d0e4b04bf232fa6124",
                "nickname": "Reborn Zms",
                "hasFollow" : true,
                "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
            }
        ]
    }
}
```

###粉丝列表
####接口:/user/fanslist
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|对方的ID|是|asdf2jr2ojflajfjlkajfsdfsaf|
|maxId|字符串|上一个列表最后一条记录的ID|否|asdf2jr2ojflajfjlkajfsdfsaf|
|size|整型|要获取的记录数|否|10|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "list": [
            {
                "id": "574ba46be4b00fa654fb35a2",
                "nickname": "Zhuomian Wang",
                "hasFollow" : true,
                "avatar": "https://graph.facebook.com/1548236228815896/picture?type=large&cacheTime=1464575088316"
            },
            {
                "id": "574ab77ce4b00fa654fb35a0",
                "nickname": "Jingyu Zhao",
                "hasFollow" : flase,
                "avatar": "https://graph.facebook.com/1039369769483637/picture?type=large&cacheTime=1464514410406"
            },
            {
                "id": "574832d0e4b04bf232fa6124",
                "nickname": "Reborn Zms",
                "hasFollow" : true,
                "avatar": "https://graph.facebook.com/10208066453953025/picture?type=large&cacheTime=1464349389987"
            }
        ],
        "recommends":[]
    }
}
```

##假数据接口
###虚拟点赞接口
####接口:/fake/like
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|sightId|字符串|视频id|是|xxxxxxxxx|
|size|整型|点赞个数，默认为1|否|1|
####成功返回值
```
{
    "ret":200,
    "data":{
      "newLikeCount":2  //成功点赞的个数
    }
}
```

###虚拟关注接口
####接口:/fake/follow
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|待关注的用户id|是|xxxxxxxxx|
|size|整型|粉丝个数，默认为1|否|1|
####成功返回值
```
{
    "ret":200,
    "data":{
      "newFansCount":2 //新增粉丝数
    }
}
```

##存储相关接口
###获得上传token
####接口:/store/token
####请求方式:POST
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
}
```

##升级相关接口
###检查升级接口
####接口:/upgrade/check
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|ver|整型|客户端当前版本号|是|12|
|channel|字符串|渠道|是|gp|
|locale|字符串|国家|否|zh_CN|
####成功返回值
```
{
    "ret":200,
    "data":{
      "versionCode":12,
      "forceUpdate":true,
      "uploadTime":1212321312312,
      "channel":"gp",
      "hasAttachment":true,
      "fileSize":23232,
      "md5":"sdf2f2fwef24f24f",
      "downloadUrl":"http://video.iwifiapi.com/prod-holaverse/upgrade/files/12.apk",
      "packageName":"com.holaverse.test"
    }
}
```

#推送格式
##被点赞
```
{
  "data": {
    "user":{
      "id":"",
      "avatar":"",
      "nickname":""
    },
    "sight":{
      "id":"",
      "cover":""
    },
    "type":"beingLiked"
  }
}
```
##新增粉丝
```
{
  "data": {
    "user":{
      "id":"",
      "avatar":"",
      "nickname":""
    },
    "type":"beingFollowed"
  }
}
```
##关注的人有更新
```
{
  "data": {
    "user":{
      "id":"",
      "avatar":"",
      "nickname":""
    },
    "sight":{
      "id":"",
      "cover":""
    },
    "type":"followingUpdate"
  }
}
```
##发布的主题有更新
```
{
  "data": {
    "user":{
      "id":"",
      "avatar":"",
      "nickname":""
    },
    "sight":{
      "id":"",
      "cover":""
    },
    "type":"topicUpdate"
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
|USER_NOT_EXIST|用户不存在|
|NOT_ALLOWED|不允许操作|
