#通用参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|token|字符串|用户登录凭证|是(登录、注册接口除外)||
|tz|字符串|用户所在时区|是|Asia/Shanghai|
|pf|字符串|客户端平台类型,ios或者android|是|ios|
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

###获得长连接服务器信息
####接口:/passport/server
####请求方式:POST/GET
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":{
    	"list":[{
    		"host":"52.88.106.245",
    		"port":"15624"
    	}],
    	"timeout":{
    		"idle":180,
    		"read":50,
    		"write":10
    	}
    }
}
```


###用户登录
####接口:/passport/login
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|accessToken|字符串|第三方登录成功凭证|是(type为fb或gg时必须)|asdf2jr2ojflajfjlkajfsdfsaf|
|oauthId|字符串|第三方系统唯一标识|是(type为fb或gg时必须)|165464616546|
|type|字符串|第三方账号来源,值为:fb\gg\email|是|fb|
|email|字符串|邮箱|是(type为email时必须)|/avatar/232.png|
|password|字符串|密码,进行32位md5|是(type为email时必须),进行32位md5|1985-02-14|
|pf|字符串|平台(ios或者android)|是|ios|
|pushToken|字符串|推送token|是|sdfsdfawefawfasfd|
####成功返回值
```
{
    "ret":200,
    "data":{
        "token":"",
        "userId":"",
        "nickname":"",
        "avatar":"",
        "thumbnail":"",
        "family":{
            "id" : "",
            "dogs" : [
              "id" : "",
              "name" : "",
              "avatar" : "",
              "gender" : ""
            ]
        },
        "groups":[{
          "name":"global",
          "id":"xxxx"
        },{
          "name":"loser",
          "id":"xxxxx"
        }]
    }
}
```
###账号注册
####接口:/passport/register
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|accessToken|字符串|第三方登录成功凭证|是|asdf2jr2ojflajfjlkajfsdfsaf|
|oauthId|字符串|第三方系统唯一标识|是|165464616546|
|nickname|字符串|用户昵称,必须唯一|是|张三|
|type|字符串|账号来源,可选值有fb\email\gg|是|fb|
|avatar|字符串|用户头像|是|/avatar/232.png|
|birthday|字符串|用户生日,格式为yyyy-MM-dd|否|1985-02-14|
|gender|字符串|第三方系统里的用户性别|否|male|
|email|字符串|用户邮箱,若type为email或通过邀请邮箱注册,则必须|是|test@holaverse.com|
|password|字符串|用户密码,若type为email,则必须,进行32位md5|是|23232323|
|locale|字符串|用户语言|否||
|timezone|字符串|用户所在时区|是|8|
|country|字符串|用户所在国家|否|china|
|pf|字符串|平台(ios或者android)|是|ios|
|pushToken|字符串|推送token|是|sdfsdfawefawfasfd|
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
###用户邮箱激活
####接口:/passport/verify
####请求方式:POST
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###用户退出登录
####接口:/passport/logout
####请求方式:POST/GET
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":""
}
```
###搜索用户
####接口:/user/search
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|keyword|字符串|用户昵称或者编码|是|abc|
|gender|字符串|用户性别|否|male|
|page|整型|页码，默认为1|否|1|
|size|整型|每页大小，默认为10|否|10|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "total": 1,
        "page": 1,
        "size": 10,
        "users": [
            {
                "id": "57159725e4b030b983af7668",
                "thumbnail": "",
                "status": "NORMAL",
                "nickname": "ddd",
                "familyId": "",
                "code": "8115645",
                "avatar": ""
            }
        ]
    }
}
```

###城市搜索接口
####接口:/user/city/query
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|query|字符串|城市名，支持多语言|是|beijing或北京等|
|lang|字符串|返回城市等语言，如en，zh等|否|en|
|page|整型|页码，默认为1|否|1|
|size|整型|每页大小，默认为10|否|10|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "iso": "zh",
            "name": "Beijing, Beijing, China",
            "country": "China"
        },
        {
            "iso": "zh",
            "name": "Xicheng,Beijing, Beijing, China",
            "country": "China"
        }
    ]
}
```

###批量查询用户信息
####接口:/user/query
####请求方式:POST／GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|ids|字符串|用户id列表|是|["xxxxx","xxxxx","xxxxx","xxxxx"]|
####成功返回值
```
{
    "ret": 200,
    "data": [{
        "id":"xxxxxxx",
        "name":"xxf",
        "avatar":"http://xxx.xxx/xx/xx.jpg"
    },{
        "id":"xxxxxxx",
        "name":"fred",
        "avatar":"http://xxx.xxx/xx/xx.jpg"
    }]
}
```

###用户删除(测试用)
####接口:/passport/delete
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|accessToken|字符串|第三方登录成功凭证|是(type为fb或gg时必须)|asdf2jr2ojflajfjlkajfsdfsaf|
|oauthId|字符串|第三方系统唯一标识|是(type为fb或gg时必须)|165464616546|
|type|字符串|第三方账号来源,值为:fb\gg\email|是|fb|
|email|字符串|邮箱|是(type为email时必须)|/avatar/232.png|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```
###用户忘记密码
####接口:/passport/forgetpasswd
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|email|字符串|邮箱|是|jimmy.zhang@holaverse.com|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

##声波相关接口
###用户获得面对面加好友或加入家庭的token
####接口:/face/token
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|type|字符串|类型,family代表加入家庭,friend代表添加好友|是|family|
####成功返回值
```
{
    "ret":200,
    "data":{
      "faceToken":"xxxxxxxxxxxxxxx"
    }
}
```
###面对面加入家庭或加为好友的目标详情,家庭基本信息或者用户基本信息
####接口:/face/detail
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|authToken|字符串|面对面token|是|asdf2jr2ojflajfjlkajfsdfsaf|
####成功返回值
当类型是加入家庭时:
```
{
    "ret": 200,
    "data": {
        "id": "",
        "name": "",
        "background": "",
        "createTime": "",
        "creator": "",
        "owner": "",
        "family": [
            {
                "id": "",
                "nickname": "",
                "avatar": ""
            },
            {
                "id": "",
                "nickname": "",
                "avatar": ""
            }
        ],
        "dogs": [
            {
                "id": "",
                "name": "",
                "avatar": "",
                "breed": ""
            }
        ]
    }
}
```
当类型是添加好友时:
```
{
    "ret": 200,
    "data": {
        "id": "56b00a46e4b021083bb2c8e7",
        "thumbnail": "",
        "lastLoginDate": "",
        "status": "NORMAL",
        "nickname": "Junrui Kang",
        "familyId": "56b00a46e4b021083bb2c8e8",
        "regDate": "",
        "avatar": ""
    }
}
```

###面对面加入家庭或加为好友的具体操作,加入家庭或者加为好友
####接口:/face/action
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|authToken|字符串|面对面token|是|asdf2jr2ojflajfjlkajfsdfsaf|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

##动态接口
###显示关注的狗照片
####接口:/note/follow
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|maxId|字符串|最大一个id，上一页最后一个的id|否|xxxxxxxxxx|
|size|数字|大小|否|10|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "id": "568390cfe4b0691b108f792f",
            "createTime": 1451462856000,
            "birthday": 0,
            "breed": "二哈",
            "breedInfo": "",
            "lineage": true,
            "name": "dogName",
            "familyId": "568390cfe4b0691b108f792e",
            "gender": 0,
            "avatar": "http://img1.test.enterest.me/user/avatar/server/66555880-6fab-4870-a8bc-8b1417476594",
            "creator": "568390c8e4b0691b108f792d",
            "type": "DOG"
        },
        {
            "id": "56b00a46e4b021083bb2c8e9",
            "createTime": 1454377543000,
            "birthday": 8388607,
            "breed": "maltese",
            "breedInfo": "",
            "lineage": false,
            "name": "ggg",
            "familyId": "56b00a46e4b021083bb2c8e8",
            "gender": 0,
            "avatar": "http://img2.enterest.me/test-dogs-img/img/2016/03/3e52e347cba352e15eaea90e7874e10d.JPG",
            "creator": "56b00a46e4b021083bb2c8e7",
            "type": "DOG"
        }
    ]
}
```

###发布照片
####接口:/note/publish
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|photo|字符串|图片url|是|http://xxxx.xxx.xxx/xxx.jpg|
|words|字符串|配文字|否|xxx|
|topicId|字符串|所属话题|否|asdf2jr2ojflajfjlkajfsdfsaf|
|mentionUserId|字符串数组|提到的用户,最多5个人|否|asdf2jr2ojflajfjlkajfsdfsaf|
|mentionDogId|字符串数组|提到的狗,最多5条|否|asdf2jr2ojflajfjlkajfsdfsaf|
|lat|double|维度|否|111.8834140000|
|lng|double|经度|否|37.2888310000|
|walkId|字符串|遛狗id|否|xxxxxxxxxxxxxx|
####成功返回值
```
{
    "ret": 200,
    "data": ""
}
```

###点赞接口
####接口:/note/like
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|noteId|字符串|动态id|是|xfasdfasdfasdfsdfasdfasdf|
####成功返回值
```
{
    "ret": 200,
    "data": ""
}
```

###取消点赞接口
####接口:/note/unlike
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|noteId|字符串|动态id|是|xfasdfasdfasdfsdfasdfasdf|
####成功返回值
```
{
    "ret": 200,
    "data": ""
}
```

###点赞用户列表接口
####接口:/note/likelist
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|noteId|字符串|动态id|是|xfasdfasdfasdfsdfasdfasdf|
|page|整型|页码|否|1|
|size|整型|大小|否|10|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "id": "570487b0e4b04562f4232c8e",
            "thumbnail": "http://img2.enterest.me/crop/test-dogs-img/img/2016/04/91765df50a7b7d9d62f263ec8e6ffde8.JPG_100x100_80.jpg",
            "regTime": 1459914673000,
            "status": "NORMAL",
            "nickname": "kang01",
            "familyId": "570487b0e4b04562f4232c8f",
            "code": "",
            "avatar": "http://img2.enterest.me/test-dogs-img/img/2016/04/91765df50a7b7d9d62f263ec8e6ffde8.JPG",
            "lastLoginTime": 1460620438099
        }
    ]
}
```

###删除照片接口
####接口:/note/delete
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|noteId|字符串|动态id|是|xfasdfasdfasdfsdfasdfasdf|
####成功返回值
```
{
    "ret": 200,
    "data": ""
}
```

##评论相关接口
###评论照片
####接口:/comment/reply
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|words|字符串|评论正文|是|我是一条评论|
|noteId|字符串|动态id|是|asdf2jr2ojflajfjlkajfsdfsaf|
|userId|字符串|回复的用户id|否|asdf2jr2ojflajfjlkajfsdfsaf|
####成功返回值
```
{
    "ret": 200,
    "data": {
    	"id":"",
    	"userId":"",
    	"userInfo":{
    		"id":"",
    		"avatar":"",
    		"nickname":""
    	},
    	"noteId":"",
    	"words":"xxxxxxxxxxxxxx"
    	"createTime":111111111111
    }
}
```

###删除评论
####接口:/comment/delete
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|commentId|字符串|评论id|是|asdf2jr2ojflajfjlkajfsdfsaf|
####成功返回值
```
{
    "ret": 200,
    "data": ""
}
```

###评论列表
####接口:/comment/list
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|noteId|字符串|动态id|是|asdf2jr2ojflajfjlkajfsdfsaf|
|maxId|字符串|最大评论id，分页用，为空则从最新的开始|否|asdf2jr2ojflajfjlkajfsdfsaf|
|size|整型|记录数，默认是10|否|10|
####成功返回值
```
{
    "ret": 200,
    "data": [{
    	"id":"",
    	"userId":"",
    	"userInfo":{
    		"id":"",
    		"avatar":"",
    		"nickname":""
    	},
    	"noteId":"",
    	"words":"xxxxxxxxxxxxxx",
    	"replyUserId":"",
    	"replyUserInfo":{
    		"id":"",
    		"avatar":"",
    		"nickname":""
    	},
    	"createTime":111111111111
    }]
}
```

##广场相关接口

###查看好友或关注的狗的照片
####接口:/square/photos
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|maxId|字符串|最大一个照片的id|否|xxxxxxxxxxxxxxxx|
|size|整型|每页大小|否，不传默认是10|10|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "id": "56c527eee4b0d4e743a592a1",
            "userId": "56b00a46e4b021083bb2c8e7",
            "familyId": "56b00a46e4b021083bb2c8e8",
            "photoUrl": "http://fanyi.baidu.com/static/i18n/zh/widget/translate/head/logo/logo_16ea8bb7.png",
            "words": "",
            "topicId": "",
	    "hasLocation":true,
            "lng":23.4353,
            "lat":54.2323,
            "likes": 99,
            "type" : "WALK", //可取值 WALK, PIC
            
            "comments": [
                {
                    "id": "56c527eee4b0d4e743a592a2",
                    "noteId": "56c527eee4b0d4e743a592a1",
                    "userId": "56b00a46e4b021083bb2c8e7",
                    "words": "I'm a reply...",
                    "replyUserId": "",
                    "createTime": 1455761390650,
                    "author": {
                        "id": "56b00a46e4b021083bb2c8e7",
                        "thumbnail": "",
                        "lastLoginDate": "",
                        "status": "NORMAL",
                        "nickname": "Junrui Kang",
                        "familyId": "56b00a46e4b021083bb2c8e8",
                        "regDate": "",
                        "avatar": ""
                    }
                }
            ],
            "createTime": 1455761390606,
            "author": {
                "id": "56b00a46e4b021083bb2c8e7",
                "thumbnail": "",
                "lastLoginDate": "",
                "status": "NORMAL",
                "nickname": "Junrui Kang",
                "familyId": "56b00a46e4b021083bb2c8e8",
                "regDate": "",
                "avatar": ""
            },
            "dogs" : [{
            	"id":"",
            	"name":"",
            	"avatar":"",
            	"breed":"",
            	"birthday":"",
            	"createTime":"",
            	
            	//如果是遛的狗，有一下信息
            	"startTime" : "xxx",
            	"endTime" : "xxx",
            	"duration":"",
            	"distance":"",
            	"calorie":"",
            	"exercise" : {
                        "expect" : 4234,
                        "actual" : 2323
                }
            }]
        }
    ]
}
```

###查看周边的家庭
####接口:/square/around
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|country|字符串|用户所在国家|是|china|
|lng|浮点型|经度|是|12.315456|
|lat|浮点型|维度|是|25.145644|
|radius|整型|半径,单位英里|是|3|
####成功返回值
```
{
    "ret":200,
    "data":[{
    	"id":"",
    	"name":"bobo's home",
    	"background":"",
    	"dogs":3,
    	"members":5,
    	"distance":2.2
    }]
}
```

###查看好友和家人喜欢的照片
####接口:/square/like
####请求方式:GET/POST
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":[{
    	"id":"",
    	"nickname":"bobo",
    	"avatar":"",
    	"gender":"male",
    	"photos":[{
    		"id":"",
    		"photoUrl":""
    	}]
    }]
}
```
##发现附近的家或人相关接口

###查找附近的人，以便添加好友
####接口:/discover/nearby/others
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|lng|浮点型|经度|是|12.315456|
|lat|浮点型|维度|是|25.145644|
|radius|浮点型|半径|是|3|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "id": 1,
            "nickname": "",
            "avatar": "",
            "distance": 0.32,
            "location": {
                "longitude": 23.546446546,
                "latitude": 233.21312312312
            },
            "familyId": "xxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "dogs": [
                {
                    "id": "",
                    "avatar": "",
                    "familyId": "",
                    "name": ""
                }
            ],
            "isFriend": false
        }
    ]
}
```

###查找附近的家庭，以便申请加入
####接口:/discover/nearby/family
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|lng|浮点型|经度|是|12.315456|
|lat|浮点型|维度|是|25.145644|
|radius|浮点型|半径|是|3|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "id": 1,
            "nickname": "",
            "avatar": "",
            "distance": 0.32,
            "location": {
                "longitude": 23.546446546,
                "latitude": 233.21312312312
            },
            "familyId": "xxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "dogs": [
                {
                    "id": "",
                    "avatar": "",
                    "familyId": "",
                    "name": ""
                }
            ],
            "isFriend": false
        }
    ]
}
```

###家庭查找附近未加入家庭的人，以便邀请加入
####接口:/discover/nearby/users
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|lng|浮点型|经度|是|12.315456|
|lat|浮点型|维度|是|25.145644|
|radius|浮点型|半径|是|3|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "id": 1,
            "nickname": "",
            "avatar": "",
            "distance": 0.32,
            "location": {
                "longitude": 23.546446546,
                "latitude": 233.21312312312
            }
        }
    ]
}
```

###清除家庭或者个人的地理位置信息
####接口:/discover/nearby/clear
####请求方式:GET/POST
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

##家庭相关接口

###邀请加入家庭
####接口:/families/invite
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|title|字符串|邮件标题|是|你也来玩吧|
|content|字符串|邮件正文|是|hi，这个应用很有意思，你去下载吧！|
|email|字符串|被邀请人的邮箱|是|jimmy.zhang@holaverse.com|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###获得邮箱所有的被邀请的家庭列表
####接口:/families/invite
####请求方式:GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|email|字符串|被邀请人的邮箱|是|165464616546|
####成功返回值
```
{
    "ret":200,
    "data":[{
      "authToken":"sdfasdfsadfasdfs",
      "id":"xxdfassdffsdfsdaf",
      "name":"",
      "background":"",
      "members":[{
      	"id":"",
      	"avatar":"",
      	"name":""
      }],
      "pets":[{
      	"name":"",
      	"avatar":"",
      	"breed":""
      }]
    }
    },{
      "authToken":"sdfasdfsadfasdfs",
      "id":"xxdfasdfsdaf",
      "name":"",
      "background":"",
      "members":[{
      	"id":"",
      	"avatar":"",
      	"name":""
      }],
      "pets":[{
      	"name":"",
      	"avatar":"",
      	"breed":""
      }]
    }]
}
```

### 根据邀请邮箱和校验token加入家庭
####接口:/families/byinvite
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|email|字符串|用户email|是|xxx@mail.com|
|authToken|字符串|校验token|是|xxxxxxxxxx|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###获得家庭的所有notes
####接口:/families/notes
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|familyId|字符串|家庭名称|是|asdf2jr2ojflajfjlkajfsdfsaf|
|maxId|字符串|最大noteid,分页用|否,若为空,则从最新的开始|asdf2jr2ojflajfjlkajfsdfsaf|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "id": "56c527eee4b0d4e743a592a1",
            "userId": "56b00a46e4b021083bb2c8e7",
            "familyId": "56b00a46e4b021083bb2c8e8",
            "photoUrl": "http://fanyi.baidu.com/static/i18n/zh/widget/translate/head/logo/logo_16ea8bb7.png",
            "words": "",
            "topicId": "",
            "hasLocation":true,
            "lng":23.4353,
            "lat":54.2323,
            "likes": 99,
            "comments": [
                {
                    "id": "56c527eee4b0d4e743a592a2",
                    "noteId": "56c527eee4b0d4e743a592a1",
                    "userId": "56b00a46e4b021083bb2c8e7",
                    "words": "I'm a reply...",
                    "replyUserId": "",
                    "createTime": 1455761390650,
                    "author": {
                        "id": "56b00a46e4b021083bb2c8e7",
                        "thumbnail": "",
                        "lastLoginDate": "",
                        "status": "NORMAL",
                        "nickname": "Junrui Kang",
                        "familyId": "56b00a46e4b021083bb2c8e8",
                        "regDate": "",
                        "avatar": ""
                    }
                }
            ],
            "createTime": 1455761390606,
            "author": {
                "id": "56b00a46e4b021083bb2c8e7",
                "thumbnail": "",
                "lastLoginDate": "",
                "status": "NORMAL",
                "nickname": "Junrui Kang",
                "familyId": "56b00a46e4b021083bb2c8e8",
                "regDate": "",
                "avatar": ""
            },
            "dogs" : [{
            	"id":"",
            	"name":"",
            	"avatar":"",
            	"breed":"",
            	"birthday":"",
            	"createTime":""
            }]
        }
    ]
}
```

###家长移除成员
####接口:/families/remove
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|familyId|字符串|家庭id|是|sdfsdfawefawfasfd|
|userId|字符串|待移除的成员id|是|dsdfsldfjlasfe|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###获得家庭基本信息接口
####接口:/families/info
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|familyId|字符串|家庭名称|是|asdf2jr2ojflajfjlkajfsdfsaf|
|recent|布尔值|是否获得最近六条记录|否|false|
|tips|布尔值|是否获得用户的tips|否|false|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "id": "56b00a46e4b021083bb2c8e8",
        "dogs": [
            {
                "id": "56b00a46e4b021083bb2c8e9",
                "familyId": "56b00a46e4b021083bb2c8e8",
                "name": "ggg",
                "avatar": "http://img2.enterest.me/test-dogs-img/img/2016/03/3e52e347cba352e15eaea90e7874e10d.JPG",
                "breed": "maltese",
                "birthday": 2147483647,
                "lineage": false,
                "gender": "",
                "weight": "",
                "height": "",
                "createTime": 1454377543000,
                "creator": ""
            }
        ],
        "members": 1,
        "name": "",
        "background": "",
        "createTime": 1454377543000,
        "creator": "56b00a46e4b021083bb2c8e7",
        "owner": "56b00a46e4b021083bb2c8e7",
        "recent": [
            {
                "id": "56d9395fe4b0757ebf2f5ec3",
                "createTime": 1457076576000,
                "hasLocation": false,
                "dogs": [
                    "56b00a46e4b021083bb2c8e9"
                ],
                "words": "",
                "familyId": "56b00a46e4b021083bb2c8e8",
                "userId": "56b00a46e4b021083bb2c8e7",
                "topicId": "56838b08e4b0691b1083fd42",
                "lng": "",
                "photoUrl": "http://img2.enterest.me/test-dogs-img/img/2016/03/9c580b30b49afdbc84fb36c86e782421.JPG",
                "lat": ""
            }
        ],
        "family": [
            {
                "id": "56b00a46e4b021083bb2c8e7",
                "thumbnail": "",
                "lastLoginDate": "",
                "regTime": 1454377543000,
                "status": "NORMAL",
                "nickname": "Junrui Kang",
                "familyId": "56b00a46e4b021083bb2c8e8",
                "avatar": ""
            }
        ],
        "tips": [
            {
                "subHeader": "Southern California",
                "type": "NOTICE",
                "header": "Emergency warning",
                "title": "A massive outbreak in southern California",
                "summary": "Emergency outbreak, everybody, don't go out!",
                "url": "",
                "image": "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1286576253,1008054910&fm=58",
                "rating": 4
            },
            {
                "subHeader": "In 3 days…",
                "type": "REMIND",
                "header": "Bobo and Lei need to take bath in 3 days.",
                "title": "Why should dogs take bath?",
                "summary": "Your dog needs to take bath is because: 1) Clean off the dirt on him/her. 2) Clean the stink off him/her. The stink of dog mainly from ...",
                "url": "http://www.baidu.com",
                "image": "http://static.360buyimg.com/finance/base/1.1.0/images/logo-slogan.png",
                "rating": 0
            },
            {
                "subHeader": "Knowledge",
                "type": "SWITH",
                "header": "Behavior Training-Leash Training",
                "title": "Your puppy should be taught to walk on a loose leash and have good manners from the beginning?",
                "summary": "Start with a nylon or leather collar. Leave the collar on for short periods. When the puppy is no longer bothered by it, leave it on all the time. Attach a leash that he can drag behind him.",
                "url": "http://www.baidu.com",
                "image": "",
                "rating": 0
            }
        ]
    }
}
```

###显示家庭成员和好友列表接口,只能显示自己的家庭和好友
####接口:/families/member
####请求方式:GET/POST
####接口参数
无
####成功返回值
```
{
    "ret": 200,
    "data": {
        "family": [
            {
                "id": "",
                "nickname": "",
                "avatar": ""
            },
            {
                "id": "",
                "nickname": "",
                "avatar": ""
            }
        ],
        "friends": [
            {
                "id": "",
                "nickname": "",
                "avatar": ""
            },
            {
                "id": "",
                "nickname": "",
                "avatar": ""
            }
        ],
        "dogs": [
            {
                "id": "",
                "name": "",
                "avatar": "",
                "breed": ""
            }
        ]
    }
}
```

##小贴士接口
###获得用户的小贴士
####接口:/tip/list
####请求方式:POST/GET
####接口参数
无
####成功返回值
返回值说明:

|字段名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|type|字符串|类型(NOTICE:通知,疫情,突发事件,KNOWLEDGE:一般性知识,REMIND:提醒,如洗澡等,SWITH:季节切换,成长阶段变化等)|是|NOTICE|
|rating|整型|事件紧急程度,五星表示,一到五|否(当type是NOTICE时为必须)|4|

```
{
    "ret": 200,
    "data": [
        {
            "type": "NOTICE",
            "subHeader":"加州地区",
            "header": "紧急疫情预警",
            "title": "加州南部爆发大规模疫情",
            "summary": "这里是内容,摘要,什么乱七八糟的东西...",
            "url": "",
            "image": "http://static.360buyimg.com/finance/base/1.1.0/images/logo-slogan.png",
            "rating": 4
        },
        {
            "type": "REMIND",
            "subHeader":"还有3天",
            "header": "bobo和leilei该洗澡了",
            "title": "为啥需要洗澡呢?",
            "summary": "因为洗澡好啊,皮肤好啊,什么乱七八糟的东西...",
            "url": "http://www.baidu.com",
            "image": "http://static.360buyimg.com/finance/base/1.1.0/images/logo-slogan.png",
            "rating": 0
        },
        {
            "type": "SWITH",
            "subHeader":"小知识",
            "header": "迎来成犬期",
            "title": "如何安抚发情期的爱犬?",
            "summary": "这里就是这条资讯的内容,什么乱七八糟的东西...",
            "url": "http://www.baidu.com",
            "image": "",
            "rating": 0
        }
    ]
}
```

##举报相关接口

###举报照片
####接口:/report/note
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|noteId|字符串|照片id|是|dsdfsldfjlasfe|
|type|字符串|类型（adOrPornographic，violenceOrIllegal，fraud，copyright，threats，other）|是|other|
|reason|字符串|原因|否|色情|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###举报评论
####接口:/report/comment
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|noteId|字符串|照片id|是|dsdfsldfjlasfe|
|commentId|字符串|评论id|是|dsdfsldfjlasfe|
|type|字符串|类型（adOrPornographic，violenceOrIllegal，fraud，copyright，threats，other）|是|other|
|reason|字符串|原因|否|色情|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

##用户相关接口

###更新token信息
####接口:/user/push/token
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|用户id|否(当且仅当未登录为空)|dsdfsldfjlasfe|
|pf|字符串|平台(ios或者android)|是|ios|
|pushToken|字符串|推送token|是|sdfsdfawefawfasfd|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###修改密码
####接口:/user/modify/passwd
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|password|字符串|新密码，32位md5加密|是|dsdfsldfjlasfe|
|oldPassword|字符串|原始密码，32位md5加密|是|dsdfsldfjlasfe|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###修改资料
####接口:/user/modify/profile
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|avatar|字符串|新头像|否|http://xxxx.jpg|
|email|字符串|新邮箱|否|dsdfsldf@test.com|
|nickname|字符串|昵称|否|abc|
|city|字符串|城市|否|beijing|
|gender|字符串|性别,male,female|否|male|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###邀请未加入任何家庭的人加入自己所在的家庭
####接口:/user/invite
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|待邀请的人|是|xxxxxxxxxxx|
|reason|字符串|申请理由|否|hello|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###获得联系人列表
####接口:/user/contacts
####请求方式:GET/POST
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":[
    	{
        	"id": "56b00a46e4b021083bb2c8e7",
                "thumbnail": "",
                "lastLoginDate": "",
                "status": "NORMAL",
                "nickname": "Junrui Kang",
                "familyId": "56b00a46e4b021083bb2c8e8",
                "regDate": "",
                "avatar": "",
                "type" : "PRIVATE" //可取值 PRIVATE / GROUP

    	}
    ]
}
```

###个人主页接口
####接口:/user/index
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|用户id|是|sdfsdfsdfsdfsdfasdfasdfs|
####成功返回值
```
{
    "ret":200,
    "data":
    	{
        	"id": "56b00a46e4b021083bb2c8e7",
                "thumbnail": "",
                "lastLoginDate": "",
                "status": "NORMAL",
                "nickname": "Junrui Kang",
                "familyId": "56b00a46e4b021083bb2c8e8",
                "regDate": "",
                "avatar": "",
                "followCount":50,
                "email":"",//当用户不是本人时,无此字段
                "city":"",
                "isFriend":false,//当用户是本人时,无此字段
                "hasApply":true,//是否已经发过申请,当且仅当对方不是好友,且发过申请时为true
                "dogs":[{
        		"id": "56b00a46e4b021083bb2c8e7",
                	"name": "",
                	"avatar": "",
                	"birthday": "NORMAL",
                	"gender": "male",
                	"breed": "56b00a46e4b021083bb2c8e8"
                	"hasFollow":true
                }]
    	}
}
```

##狗相关接口

###添加狗到一个家庭
####接口:/dog/adopt
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|name|字符串|狗的名字|是|bobo|
|avatar|字符串|狗的头像链接|否|http://xxx.xx/xx.jpg|
|gender|字符串|狗的性别,可选值为male或female|否|male|
####成功返回值
```
{
    "ret":200,
    "data":
    	{
        	"id": "56b00a46e4b021083bb2c8e7",
                "name": "",
                "avatar": "",
                "birthday": "NORMAL",
                "gender": "male",
                "breed": "56b00a46e4b021083bb2c8e8"
    	}
}
```
###修改狗的资料
####接口:/dog/modify/profile
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogId|字符串|狗id|是|xxxx|
|name|字符串|狗的名字|否|bobo|
|avatar|字符串|狗的头像链接|否|http://xxx.xx/xx.jpg|
|gender|字符串|狗的性别,可选值为male或female|否|male|
|birthday|字符串|狗的生日，格式为yyyy-MM-dd|否|male|
|breed|字符串|狗的品种id|否|xxxxxxxxxxx|
|lineage|布尔值|狗是否为纯种|否|true|
|weight|浮点型|狗的体重|否|10.5|
|height|浮点型|狗的身高|否|20.5|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###关注一条狗
####接口:/dog/follow
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogId|字符串|狗的id|是|xxxxxxx|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###狗粉絲
####接口:/dog/fans
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogId|字符串|狗的id|是|xxxxxxx|
|page|數字|頁碼|否|1|
|size|數字|page size|否|10|
####成功返回值
```
{
  "ret": 200,
  "data": [
    {
      "id": "56d80913e4b026c016f58144",
      "thumbnail": "http://img2.enterest.me/crop/user/avatar/server/65f2f1d5-f7fb-4a56-8a48-f52d782a536d_100x100_80.jpg",
      "regTime": 1456998676000,
      "status": "NORMAL",
      "nickname": "devosjdi",
      "familyId": "56d80913e4b026c016f58145",
      "avatar": "http://img2.enterest.me/user/avatar/server/65f2f1d5-f7fb-4a56-8a48-f52d782a536d",
      "lastLoginTime": 1460106121552
    }
  ]
}
```

###取消关注狗
####接口:/dog/unfollow
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogId|字符串|狗的id|是|xxxxxxx|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###获得狗的品种
####接口:/dog/breeds
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|page|整型|页码，默认为1|否|1|
|size|整型|个数，默认是10|否|10|
|filter|字符串|当且仅当为hot时，只显示热门犬种|否|hot|
####成功返回值
```
{
    "ret":200,
    "data":
    	[{
        	"id": "56b00a46e4b021083bb2c8e7",
                "name": "",
                "photo": "",
                "isHot": true,
                "rank": 1,
                "createTime": 1231354351316
    	}]
}
```

###用户正在关注的狗列表
####接口:/dog/following
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|用户id|是|xxxxxxx|
|page|整型|页码,默认是1|否|1|
|size|整型|每页大小,默认是10|否|10|
####成功返回值
```
{
    "ret":200,
    "data":
    	[{
        	"id": "56b00a46e4b021083bb2c8e7",
                "name": "",
                "avatar": "",
                "birthday": "NORMAL",
                "gender": "Junrui Kang",
                "breed": "56b00a46e4b021083bb2c8e8"
    	}]
}
```

###狗的基本信息
####接口:/dog/info
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogId|字符串|狗的id|是|xxxxxxx|
####成功返回值
```
{
    "ret":200,
    "data":
    	{
        	"id": "56b00a46e4b021083bb2c8e7",
                "name": "",
                "avatar": "",
                "birthday": "NORMAL",
                "gender": "Junrui Kang",
                "breed": "56b00a46e4b021083bb2c8e8",
                "breedInfo":{
                	"id":"xxx",
                	"isHot":false,
                	"name":"xxxx"
                },
                "lineage":true,
                "fans":[{
                	"id":"",
                	"nickname":"",
                	"avatar":""
                },{
                	"id":"",
                	"nickname":"",
                	"avatar":""
                }],
                "fansCount":5
                "family":{
                	"name":"",
                	"id":"",
                	"background":""
                }
    	}
}
```
###遛狗记录
####接口:/dog/walks
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogId|字符串|狗的id|是|xxxxxxx|
|maxId|字符串|最后一个记录的id|否|sdsfasdfwefasedfasdfasf|
|size|整型|待获取的记录数,若为空,则默认10条|否|12|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "id": "56b00a46e4b021083bb2c8e7",
        "name": "",
        "avatar": "",
        "birthday": "NORMAL",
        "height": 43,
        "weight": 43,
        "bodyType": "perfect",
        "recommendExercise": 43,
        "gender": "Junrui Kang",
        "breed": "56b00a46e4b021083bb2c8e8",
        "walkDogs": [
            {
                "id": "",
                "walkId": "",
                "userId": "",
                "dogId": "",
                "startTime": "",
                "endTime": "",
                "duration": "",
                "distance": "",
                "exercise": {
                    "actual": 32,
                    "expect": 3600
                },
                "calorie": "",
                "note": {
                    "id": "5736a4bfe4b03b0b6ae33d77",
                    "createTime": 1463198911868,
                    "hasLocation": true,
                    "dogs": [
                        {
                            "id": "5736a48ae4b03b0b6ae33d75",
                            "birthday": 0,
                            "createTime": 1463198858716,
                            "weight": 0,
                            "height": 0,
                            "lineage": false,
                            "familyId": "5736a48ae4b03b0b6ae33d76",
                            "name": "Huche",
                            "gender": 0,
                            "avatar": "http://img2.enterest.me/test-dogs-img/img/2016/05/b47a329f7f5e0dd3ca258f7d85f6c7dc.PNG",
                            "creator": "5736a43ae4b03b0b6ae33d73"
                        }
                    ],
                    "words": "Post a picture of w the day",
                    "familyId": "5736a48ae4b03b0b6ae33d76",
                    "userId": "5736a43ae4b03b0b6ae33d73",
                    "lng": 116.4241177217257,
                    "referer": "",
                    "type": "PIC",
                    "photoUrl": "http://img2.enterest.me/test-dogs-img/img/2016/05/cf54760d8d414b325826370211465609.PNG",
                    "lat": 39.93206094954157,
                    "commentCount": 0,
                    "likeCount": 0,
                    "hasLike": false,
                    "thumbnail": "http://img2.enterest.me/crop/test-dogs-img/img/2016/05/cf54760d8d414b325826370211465609.PNG_100x100_80.jpg",
                    "author": {
                        "id": "5736a43ae4b03b0b6ae33d73",
                        "thumbnail": "http://img2.enterest.me/crop/test-dogs-img/img/2016/05/d0d6600615a7272da25c0fadf6b56bbb.PNG_100x100_80.jpg",
                        "regTime": 1463198778085,
                        "status": "NORMAL",
                        "nickname": "cl105",
                        "familyId": "5736a48ae4b03b0b6ae33d76",
                        "code": "3085622",
                        "avatar": "http://img2.enterest.me/test-dogs-img/img/2016/05/d0d6600615a7272da25c0fadf6b56bbb.PNG",
                        "lastLoginTime": 1463198778085
                    }
                }
            }
        ]
    }
}
```

###提到某条狗的照片列表
####接口:/dog/notes
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogId|字符串|狗的id|是|xxxxxxx|
|maxId|字符串|最后一个照片的id|否|sdsfasdfwefasedfasdfasf|
|size|整型|待获取的记录数,若为空,则默认12条|否|12|
####成功返回值
```
{
    "ret":200,
    "data":
    	[{
        	"id": "56b00a46e4b021083bb2c8e7",
                "name": "",
                "userId":"",
                "familyId":"",
                "topicId":"",
            	"hasLocation":true,
            	"lng":23.4353,
            	"lat":54.2323,
                "likeCount":4,
                "commentCount":5
                "photoUrl": ""
    	}]
}
```

###获得某个家庭所有的狗
####接口:/dog/list
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|familyId|字符串|家庭id|是|dsdfsldfjlasfe|
####成功返回值
```
{
    "ret":200,
    "data":[
    	{
        	"id": "56b00a46e4b021083bb2c8e7",
                "name": "",
                "avatar": "",
                "birthday": "NORMAL",
                "gender": "Junrui Kang",
                "breed": "56b00a46e4b021083bb2c8e8"
    	}
    ]
}
```

##聊天接口
###轮询，获得用户未读的会话列表及其未读消息数
####接口:/chat/unread
####请求方式:GET/POST
####接口参数
无
####成功返回值
```
{
    "ret": 200,
    "data": [{
        "oppositeId":"xxxxxx",
        "chatType":"PRIVATE",
        "count":4
    },{
        "oppositeId":"xxxxxx",
        "chatType":"GROUP",
        "count":2
    }]
}
```

###阅读信息,根据当前用户指定会话（用户或群）的未读的消息
####接口:/chat/read
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|oppositeId|字符串|对方的id|是|dsdfsldfjlasfe|
|chatType|字符串|对方的类型，群聊还是私聊，PRIVATE，GROUP|是|GROUP|
|size|整型|获得多少条未读消息，默认为10|否|10|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "oppositeId": "xxxxxx",
            "chatType": "GROUP",
            "seq": 10,
            "sender": "sdfsdafsadfasdfsdfasdfasf23223",
            "receiver": "sdfasfweefweafaef2324e",
            "senderDetail": {
                "id": "",
                "name": "",
                "avatar": ""
            },
            "groupDetail": {
                "id": "",
                "name": "",
                "avatar": ""
            },
            "chatMessageType": "TEXT",
            "sendTime": 1234564561646546,
            "url": "",
            "content": "abcdefg"
        },
        {
            "oppositeId": "xxxxxx",
            "chatType": "PRIVATE",
            "seq": 10,
            "sender": "sdfsdafsadfasdfsdfasdfasf23223",
            "receiver": "sdfasfweefweafaef2324e",
            "senderDetail": {
                "id": "",
                "name": "",
                "avatar": ""
            },
            "chatMessageType": "TEXT",
            "sendTime": 1234564561646546,
            "url": "",
            "content": "abcdefg"
        }
    ]
}
```

###标记消息为已读
####接口:/chat/markread
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|oppositeId|字符串|对方的id|是|dsdfsldfjlasfe|
|chatType|字符串|对方的类型，群聊还是私聊，PRIVATE，GROUP|是|GROUP|
|seq|长整型|最后一条已读消息的序列号|是|12|
####成功返回值
```
{
    "ret":200,
    "data":{
        "oppositeId":"xxxxxx",
        "chatType":"GROUP",
        "result": true
    }
}
```
##申请相关接口

###申请加为朋友
####接口:/apply/friend
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|对方的id|是|dsdfsldfjlasfe|
|reason|字符串|理由|否|美女,你的狗好萌啊!我们交个朋友吧?你晚上有空吗?|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###邀请一个未注册的邮箱加入，一旦其注册后，会收到自己的好友申请
####接口:/apply/invite
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|email|字符串|对方的邮箱|是|dsdfsldfjlasfe|
|title|字符串|邮件标题|是|你也来玩吧|
|content|字符串|邮件正文|是|hi，这个应用很有意思，你去下载吧！|
|reason|字符串|理由|否|美女,你的狗好萌啊!我们交个朋友吧?你晚上有空吗?|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###申请加入家庭
####接口:/apply/family
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|familyId|字符串|家庭的id|是|dsdfsldfjlasfe|
|reason|字符串|理由|否|美女,你的狗好萌啊!我们做一家人吧！|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###审核申请
####接口:/apply/audit
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|applyId|字符串|邀请id|是|165464616546|
|accept|布尔值|是否通过该申请|是|true|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```


###获得未处理的申请，包括好友申请和家庭加入申请，一旦获取，将不会再下发。没有分页，一次返回所有数据
####接口:/apply/list
####请求方式:GET/GET
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":[{
		"id":"xxxxxx",
		"applyUserId":"sfsdfasdfasdfsadfasdfasdfs",
		"reason":"美女你好啊,交个朋友呗",
		"operator":"xxxxxxxxx",
		"handle":false,
		"type":"FRIEND",
		"applyTime":"15646545616546",
		"applyUser":{
			"id":"",
			"avatar":"",
			"nickname":""
		}
	},{
		"id":"xxxxxx",
		"applyUserId":"sfsdfasdfasdfsadfasdfasdfs",
		"reason":"我想加入你们家",
		"operator":"xxxxxxxxx",
		"handle":false,
		"type":"FAMILY",
		"applyTime":"15646545616546",
		"applyUser":{
			"id":"",
			"avatar":"",
			"nickname":""
		}
	}]
}
```

###用户主动取消申请（加入家庭或者加为好友）
####接口:/apply/cancel
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|加好友时，对方的id，与familyId二选一必填|是|xxxxxxxxxxxxxx|
|familyId|字符串|加入家庭时，这里是家庭的id，与userId二选一|是|xxxxxxxxxxxxxx|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

##朋友相关接口

###友尽接口
####接口:/friend/breakup
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|待绝交的好友id|是|dsdfsldfjlasfe|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###显示某个人所有的好友列表
####接口:/friend/list
####请求方式:GET/POST
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":[{
		"id":"xxx",
		"familyId":"xxxxxx",
		"userId":"dfklasjdflsjfl",
		"time":"23232323232"
	}]
}
```

##遛遛相关接口

###获得狗今天的运动量
####接口:/walk/exercise
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogs|字符串数组|想要获得运动量的狗们，若为空，则判断本人所在家庭的所有狗|否|dogs=ekwjldjslfjasldfj&dogs=sdfjlsdfjlsadfsdf|
####成功返回值
```
{
    "ret": 200,
    "data": [{
            "dog" : {
                "id": "56f8e844e4b09c24bc16c600",
                "createTime": 1459152964000,
                "birthday": 1459247161226,
                "breed": "9b2df08f-2f16-4d8c-8e74-cdaa5943d655",
                "breedInfo": {
                    "id": "9b2df08f-2f16-4d8c-8e74-cdaa5943d655",
                    "name": "afghan hound",
                    "photo": "",
                    "isHot": false,
                    "rank": 0,
                    "createTime": 1452161532000
                },
                "height": 5,
                "weight": 35,
                "lineage": true,
                "name": "Norman1",
                "familyId": "56b16aece4b01201891e8487",
                "gender": 0,
                "avatar": "http://img2.enterest.me/test-dogs-img/img/2016/03/BD858C7FAB67A144DDEFB40FFC11261F.jpg",
                "creator": "56b16aece4b01201891e8486"
            },
            "exercise" : {
            	"expect" : 4234,
            	"actual" : 2323
            }
        }]
}
```

###出发遛狗
####接口:/walk/setoff
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogs|字符串数组|本次遛的狗们|是|dogs=ekwjldjslfjasldfj&dogs=sdfjlsdfjlsadfsdf|
|visible|布尔值|是否对其他人可见|是|true|
|notice|布尔值|是否通知好友|是|false|
|lat|double|维度|否|111.8834140000|
|lng|double|经度|否|37.2888310000|
|seq|int|排序号|是|1|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "startTime": 1459404337114,
        "dogs": [
            {
                "id": "56f8e844e4b09c24bc16c600",
                "createTime": 1459152964000,
                "birthday": 1459247161226,
                "breed": "9b2df08f-2f16-4d8c-8e74-cdaa5943d655",
                "breedInfo": {
                    "id": "9b2df08f-2f16-4d8c-8e74-cdaa5943d655",
                    "name": "afghan hound",
                    "photo": "",
                    "isHot": false,
                    "rank": 0,
                    "createTime": 1452161532000
                },
                "height": 5,
                "weight": 35,
                "lineage": true,
                "name": "Norman1",
                "familyId": "56b16aece4b01201891e8487",
                "gender": 0,
                "avatar": "http://img2.enterest.me/test-dogs-img/img/2016/03/BD858C7FAB67A144DDEFB40FFC11261F.jpg",
                "creator": "56b16aece4b01201891e8486"
            }
        ],
        "visible": false,
        "userId": "56ebda98e4b081e88c6abcdb",
        "user": {
            "id": "56ebda98e4b081e88c6abcdb",
            "thumbnail": "http://img2.enterest.me/crop/user/avatar/server/b2a79455-6cad-4607-8ce7-bcc31225bbff_100x100_80.jpg",
            "regTime": 1458297497000,
            "status": "NORMAL",
            "nickname": "Light",
            "familyId": "56ebda98e4b081e88c6abcdc",
            "avatar": "http://img2.enterest.me/user/avatar/server/b2a79455-6cad-4607-8ce7-bcc31225bbff",
            "lastLoginTime": 1459321073000
        },
        "walkId": "56fcbe31e4b029bef7435f06"
    }
}
```

###遛狗详情
####接口:/walk/info
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogId|字符串数组|要查看的狗，如果为空，则显示人的信息|否|sdfjlsdfjlsadfsdf|
####成功返回值
```
{
    "ret":200,
    "data":{
    		"walkId":"",
    		"startTime":"",
    		"dogs":[{
    			"id":"",
    			"avatar":"",
    			"name":""
    		}],
    		"location":{
                	"longitude": 111.883414,
                	"latitude": 37.288831
    		}
    	}
}
```

###是否正在遛狗
####接口:/walk/iswalking
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogs|字符串数组|要检测的狗们，若为空，则检测自己所在家庭的狗们|否|dogs=ekwjldjslfjasldfj&dogs=sdfjlsdfjlsadfsdf|
|userId|字符串|用户id，判断用户，若为空，则不判断人|否|sdfjlsdfjlsadfsdf|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "userWalkInfo": {
            "startTime": 1459404337114,
            "dogs": [
                {
                    "id": "56f8e844e4b09c24bc16c600",
                    "createTime": 1459152964000,
                    "birthday": 1459247161226,
                    "breed": "9b2df08f-2f16-4d8c-8e74-cdaa5943d655",
                    "breedInfo": {
                        "id": "9b2df08f-2f16-4d8c-8e74-cdaa5943d655",
                        "name": "afghan hound",
                        "photo": "",
                        "isHot": false,
                        "rank": 0,
                        "createTime": 1452161532000
                    },
                    "height": 5,
                    "weight": 35,
                    "lineage": true,
                    "name": "Norman1",
                    "familyId": "56b16aece4b01201891e8487",
                    "gender": 0,
                    "avatar": "http://img2.enterest.me/test-dogs-img/img/2016/03/BD858C7FAB67A144DDEFB40FFC11261F.jpg",
                    "creator": "56b16aece4b01201891e8486"
                }
            ],
            "visible": false,
            "userId": "56ebda98e4b081e88c6abcdb",
            "user": {
                "id": "56ebda98e4b081e88c6abcdb",
                "thumbnail": "http://img2.enterest.me/crop/user/avatar/server/b2a79455-6cad-4607-8ce7-bcc31225bbff_100x100_80.jpg",
                "regTime": 1458297497000,
                "status": "NORMAL",
                "nickname": "Light",
                "familyId": "56ebda98e4b081e88c6abcdc",
                "avatar": "http://img2.enterest.me/user/avatar/server/b2a79455-6cad-4607-8ce7-bcc31225bbff",
                "lastLoginTime": 1459321073000
            },
            "walkId": "56fcbe31e4b029bef7435f06",
            "seq" : 13,
            "location": {
                "longitude": 116.42345756292343,
                "latitude": 39.9434325387362
            }
        },
        "anyDogIsWalking": true,
        "dogWalkingList": [
            {
                "dogId": "56f8e844e4b09c24bc16c600",
                "wannaDating": false,
                "location": {
                    "longitude": 116.42345756292343,
                    "latitude": 39.9434325387362
                },
                "userId": "56ebda98e4b081e88c6abcdb",
                "dog": {
                    "id": "56f8e844e4b09c24bc16c600",
                    "createTime": 1459152964000,
                    "birthday": 1459247161226,
                    "breed": "9b2df08f-2f16-4d8c-8e74-cdaa5943d655",
                    "breedInfo": {
                        "id": "9b2df08f-2f16-4d8c-8e74-cdaa5943d655",
                        "name": "afghan hound",
                        "photo": "",
                        "isHot": false,
                        "rank": 0,
                        "createTime": 1452161532000
                    },
                    "height": 5,
                    "weight": 35,
                    "lineage": true,
                    "name": "Norman1",
                    "familyId": "56b16aece4b01201891e8487",
                    "gender": 0,
                    "avatar": "http://img2.enterest.me/test-dogs-img/img/2016/03/BD858C7FAB67A144DDEFB40FFC11261F.jpg",
                    "creator": "56b16aece4b01201891e8486"
                },
                "user": {
                    "id": "56ebda98e4b081e88c6abcdb",
                    "thumbnail": "http://img2.enterest.me/crop/user/avatar/server/b2a79455-6cad-4607-8ce7-bcc31225bbff_100x100_80.jpg",
                    "regTime": 1458297497000,
                    "status": "NORMAL",
                    "nickname": "Light",
                    "familyId": "56ebda98e4b081e88c6abcdc",
                    "avatar": "http://img2.enterest.me/user/avatar/server/b2a79455-6cad-4607-8ce7-bcc31225bbff",
                    "lastLoginTime": 1459321073000
                },
                "seq" : 13
            }
        ],
        "userIsWalking": true
    }
}
```

###呼朋引伴
####接口:/walk/wannadating
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|words|字符串|约炮宣言|是|我在这里，你在哪里？|
####成功返回值
```
{
    "ret":200,
    "data":{
    	"chatGroup" : {
    		"id":"",
    		"name":""
    	}
    }
}
```

###取消呼朋引伴
####接口:/walk/canceldate
####请求方式:GET/POST
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###获得自己发起的呼朋引伴的加入人列表
####接口:/walk/getdating
####请求方式:GET/POST
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":[{
    	"id":"",
    	"nickname":"",
    	"avatar":""
    }]
}
```

###加入呼朋引伴
####接口:/walk/joindate
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogId|字符串|狗的id|是|xxxxxxxxxxxxxx|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```
###退出呼朋引伴
####接口:/walk/quitdate
####请求方式:GET/POST
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###结束遛狗
####接口:/walk/finish
####请求方式:GET/POST
####接口参数
无
####成功返回值
```
{
    "ret":200,
    "data":{
		"walkDogs":[{
			"id":"",
			"walkId":"",
			"userId":"",
			"dogId":"",
			"startTime":"",
			"endTime":"",
			"visible":"",
			"duration":"",
			"distance":"",
			"calorie":"",
			"exercise" : {
                		"expect" : 4234,
                		"actual" : 2323
    			}
		},{
			"id":"",
			"walkId":"",
			"userId":"",
			"dogId":"",
			"startTime":"",
			"endTime":"",
			"visible":"",
			"duration":"",
			"distance":"",
			"calorie":"",
			"exercise" : {
                		"expect" : 4234,
                		"actual" : 2323
    			}
		}],
		"walkTrails":[{
			"id":"",
			"walkId":"",
			"lat":"",
			"lng":"",
			"seq":1,
			"recordTime":12232432424
		},{
			"id":"",
			"walkId":"",
			"lat":"",
			"lng":"",
			"seq":2,
			"recordTime":12232432424
		}]
	}
}
```

###遛狗详情
####接口:/walk/detail
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|walkId|字符串|本次遛狗id|是|ekwjldjslfjasldfj|
####成功返回值
```
{
    "ret":200,
    "data":{
		"walkDogs":[{
			"id":"",
			"walkId":"",
			"userId":"",
			"dogId":"",
			"startTime":"",
			"endTime":"",
			"visible":"",
			"duration":"",
			"distance":"",
			"calorie":""
		},{
			"id":"",
			"walkId":"",
			"userId":"",
			"dogId":"",
			"startTime":"",
			"endTime":"",
			"visible":"",
			"duration":"",
			"distance":"",
			"calorie":""
		}],
		"trails":[{
			"id":"",
			"walkId":"",
			"lat":"",
			"lng":"",
			"recordTime":12232432424
		},{
			"id":"",
			"walkId":"",
			"lat":"",
			"lng":"",
			"recordTime":12232432424
		}]
	}
}
```

###遛狗坐标上报
####接口:/walk/location
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|lat|double|维度|是|111.8834140000|
|lng|double|经度|是|37.2888310000|
|radius|double|半径范围,单位是英里|否|3|
|seq|int|排序号|是|1|
|remain|布尔值|是否依然在遛狗,若遛狗时间超过最大遛狗时间,需要明确指明,否则会提示错误|否|true|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "dog": {
                "id": "",
                "avatar": "",
                "name": ""
            },
            "location": {
                "longitude": 111.883414,
                "latitude": 37.288831
            },
            "hasFollow":false,
            "wannaDating": true,
            "dateAds" : "我想你",
            "distance": 5.3,
            "iAmJoin" : true
        },
        {
            "dog": {
                "id": "",
                "avatar": "",
                "name": ""
            },
            "location": {
                "longitude": 111.883414,
                "latitude": 37.288831
            },
            "hasFollow":false,
            "wannaDating": true,
            "dateAds" : "我想你",
            "distance": 5.3,
            "iAmJoin" : false
        }
    ]
}
```

###查看附近的狗
####接口:/walk/nearby
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|radius|double|半径范围,单位是英里|是|3|
|lat|double|维度|否|111.8834140000|
|lng|double|经度|否|37.2888310000|
|follow|布尔值|是否只显示关注的狗|否|true|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "dog": {
                "id": "",
                "avatar": "",
                "name": ""
            },
            "location": {
                "longitude": 111.883414,
                "latitude": 37.288831
            },
            "hasFollow":false,
            "wannaDating": true,
            "dateAds" : "来找我玩",
            "chatGroup":{
            	"id":"xxxxxxx",
            	"name":"xxxxxxx"
            },
            "distance": 5.3,
            "iAmJoin" : false
        },
        {
            "dog": {
                "id": "",
                "avatar": "",
                "name": ""
            },
            "location": {
                "longitude": 111.883414,
                "latitude": 37.288831
            },
            "hasFollow":false,
            "wannaDating": true,
            "dateAds" : "一起遛狗",
            "chatGroup":{
            	"id":"xxxxxxx",
            	"name":"xxxxxxx"
            },
            "distance": 5.3,
            "iAmJoin" : false
        }
    ]
}
```

###查看我家正在遛的狗
####接口:/walk/mydogs
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|lat|double|维度|否|111.8834140000|
|lng|double|经度|否|37.2888310000|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "dog": {
                "id": "",
                "avatar": "",
                "name": ""
            },
            "location": {
                "longitude": 111.883414,
                "latitude": 37.288831
            },
            "wannaDating": true,
            "dateAds" : "我想你",
            "distance": 5.3,
            "iAmJoin" : false
        },
        {
            "dog": {
                "id": "",
                "avatar": "",
                "name": ""
            },
            "location": {
                "longitude": 111.883414,
                "latitude": 37.288831
            },
            "wannaDating": true,
            "dateAds" : "我想你",
            "distance": 5.3,
            "iAmJoin" : false
        }
    ]
}
```

##通知相关接口
###获得未读通知数目
####接口:/notice/unreadcount
####请求方式:GET/POST
####接口参数
无
####成功返回值

```
{
    "ret": 200,
    "data":{
    	"count":1
    }
}
```
###获得未读通知列表
####接口:/notice/unreadlist
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|size|整型|每页大小,默认是10|否|10|
####成功返回值

```
{
    "ret": 200,
    "data": [
        {
            "id": "",
            "type": "apply",
            //通知类型有apply（请求加好友或者请求加入家庭）、notification（通知，自己发出申请的结果等）"userId": "xxxxxxxxxx",
            "hasRead": false,
            "content": "xxx wan to make friend with you",
            "action": "friend",
            "time": 2323232333223,
            "extraInfo": {
                "user": {
                    "id": "",
                    "avatar": "",
                    "nickname": ""
                }
            }
        },
        {
            "id": "",
            "type": "notification",
            //通知类型有apply（请求加好友或者请求加入家庭）、notification（通知，自己发出申请的结果等）"userId": "xxxxxxxxxx",
            "hasRead": false,
            "content": "You have joined xxx's family!",
            "action": "agree_family",
            "time": 2323232333223"extraInfo": {
                "user": {
                    "id": "",
                    "avatar": "",
                    "nickname": ""
                },
                "note": {
                    "id": "57223045e4b0b56377615674",
                    "createTime": 1461858373055,
                    "hasLocation": false,
                    "dogs": [
                        {
                            "id": "571020e9e4b0973f5a7b6032",
                            "birthday": 0,
                            "createTime": 1460674793000,
                            "lineage": false,
                            "familyId": "571020e9e4b0973f5a7b6031",
                            "name": "Calvin",
                            "gender": 0,
                            "avatar": "",
                            "creator": "571020e9e4b0973f5a7b6030"
                        }
                    ],
                    "words": "",
                    "familyId": "571020e9e4b0973f5a7b6031",
                    "userId": "571020e9e4b0973f5a7b6030",
                    "referer": "",
                    "type": "PIC",
                    "photoUrl": "http://img.nuzzle.me/prod-dogs-img/img/2016/04/7552DFF7253E1BF1BB251F7B881C4809.jpg",
                    "commentCount": 0,
                    "likeCount": 1,
                    "hasLike": false,
                    "thumbnail": "http://img.nuzzle.me/crop/prod-dogs-img/img/2016/04/7552DFF7253E1BF1BB251F7B881C4809.jpg_100x100_80.jpg",
                    "author": {
                        "id": "571020e9e4b0973f5a7b6030",
                        "thumbnail": "http://img.nuzzle.me/crop/prod-dogs-img/user/avatar/server/0e2ff44c-f7bd-46e1-97cf-5e43f334467b_100x100_80.jpg",
                        "regTime": 1460674793142,
                        "status": "NORMAL",
                        "nickname": "Eric",
                        "familyId": "571020e9e4b0973f5a7b6031",
                        "code": "8578113",
                        "avatar": "http://img.nuzzle.me/prod-dogs-img/user/avatar/server/0e2ff44c-f7bd-46e1-97cf-5e43f334467b",
                        "lastLoginTime": 1460674793142
                    },
                    "likeUsers": [
                        {
                            "id": "570fa765e4b0be4f1bdae775",
                            "thumbnail": "http://img.nuzzle.me/crop/prod-dogs-img/user/avatar/server/26653f34-b0de-4143-80d9-9c1afe0d36fd_100x100_80.jpg",
                            "regTime": 1460643686000,
                            "status": "NORMAL",
                            "nickname": "HowardLee",
                            "familyId": "570fa765e4b0be4f1bdae776",
                            "code": "4482739",
                            "avatar": "http://img.nuzzle.me/prod-dogs-img/user/avatar/server/26653f34-b0de-4143-80d9-9c1afe0d36fd",
                            "lastLoginTime": 1461914621248
                        }
                    ]
                }
            }
        }
    ]
}
```

##黑名单相关接口
###获得自己的黑名单列表
####接口:/blacklist/list
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|maxId|字符串|上一次分页中最后一个用户ID|否|xxxx|
|size|整型|每页大小,默认是10|否|10|
####成功返回值

```
{
    "ret": 200,
    "data": [{
        "id":"",
        "nickname": "",
        "avatar": ""
    }]
}
```

###将用户加入黑名单
####接口:/blacklist/block
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|对方的用户id|是|xxxx|
####成功返回值

```
{
    "ret": 200,
    "data": ""
}
```

###将用户从黑名单中移除
####接口:/blacklist/unblock
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|对方的用户id|是|xxxx|
####成功返回值

```
{
    "ret": 200,
    "data": ""
}
```
##话题相关接口
###获得话题列表
####接口:/topic/list
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|order|字符串|排序方式,photo根据照片数量降序,like,根据话题点赞数降序|否,默认是photo|photo|
|page|整型|分页,默认是1|否|1|
|size|整型|每页大小,默认是10|否|10|
####成功返回值

```
{
    "ret": 200,
    "data": [
        {
            "id": "56838b08e4b0691b1083fd42",
            "name": "topic2",
            "coverImgUrl": "",
            "photoCount": 21,
            "likeCount": 0,
            "createTime": ""
        },
        {
            "id": "56838b08e4b0691b108f73fe3",
            "name": "topic1",
            "coverImgUrl": "",
            "photoCount": 9,
            "likeCount": 0,
            "createTime": ""
        }
    ]
}
```

###获得某个话题的最新内容
####接口:/note/topic/recent
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|topicId|字符串|话题id|是|xxxxxxxxxxx|
|page|整型|分页,默认是1|否|1|
|size|整型|每页大小,默认是10|否|10|
####成功返回值

```
{
    "ret": 200,
    "data": [
        {
            "id": "56c527eee4b0d4e743a592a1",
            "userId": "56b00a46e4b021083bb2c8e7",
            "familyId": "56b00a46e4b021083bb2c8e8",
            "photoUrl": "http://fanyi.baidu.com/static/i18n/zh/widget/translate/head/logo/logo_16ea8bb7.png",
            "words": "",
            "topicId": "",
	    "hasLocation":true,
            "lng":23.4353,
            "lat":54.2323,
            "likes": 99,
            "type" : "WALK", //可取值 WALK, PIC
            
            "comments": [
                {
                    "id": "56c527eee4b0d4e743a592a2",
                    "noteId": "56c527eee4b0d4e743a592a1",
                    "userId": "56b00a46e4b021083bb2c8e7",
                    "words": "I'm a reply...",
                    "replyUserId": "",
                    "createTime": 1455761390650,
                    "author": {
                        "id": "56b00a46e4b021083bb2c8e7",
                        "thumbnail": "",
                        "lastLoginDate": "",
                        "status": "NORMAL",
                        "nickname": "Junrui Kang",
                        "familyId": "56b00a46e4b021083bb2c8e8",
                        "regDate": "",
                        "avatar": ""
                    }
                }
            ],
            "createTime": 1455761390606,
            "author": {
                "id": "56b00a46e4b021083bb2c8e7",
                "thumbnail": "",
                "lastLoginDate": "",
                "status": "NORMAL",
                "nickname": "Junrui Kang",
                "familyId": "56b00a46e4b021083bb2c8e8",
                "regDate": "",
                "avatar": ""
            },
            "dogs" : [{
            	"id":"",
            	"name":"",
            	"avatar":"",
            	"breed":"",
            	"birthday":"",
            	"createTime":"",
            	
            	//如果是遛的狗，有一下信息
            	"startTime" : "xxx",
            	"endTime" : "xxx",
            	"duration":"",
            	"distance":"",
            	"calorie":"",
            	"exercise" : {
                        "expect" : 4234,
                        "actual" : 2323
                }
            }]
        }
    ]
}
```

###获得某个话题的最热内容
####接口:/note/topic/top
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|topicId|字符串|话题id|是|xxxxxxxxxxx|
|page|整型|分页,默认是1|否|1|
|size|整型|每页大小,默认是10|否|10|
####成功返回值

```
{
    "ret": 200,
    "data": [
        {
            "id": "56c527eee4b0d4e743a592a1",
            "userId": "56b00a46e4b021083bb2c8e7",
            "familyId": "56b00a46e4b021083bb2c8e8",
            "photoUrl": "http://fanyi.baidu.com/static/i18n/zh/widget/translate/head/logo/logo_16ea8bb7.png",
            "words": "",
            "topicId": "",
	    "hasLocation":true,
            "lng":23.4353,
            "lat":54.2323,
            "likes": 99,
            "type" : "WALK", //可取值 WALK, PIC
            
            "comments": [
                {
                    "id": "56c527eee4b0d4e743a592a2",
                    "noteId": "56c527eee4b0d4e743a592a1",
                    "userId": "56b00a46e4b021083bb2c8e7",
                    "words": "I'm a reply...",
                    "replyUserId": "",
                    "createTime": 1455761390650,
                    "author": {
                        "id": "56b00a46e4b021083bb2c8e7",
                        "thumbnail": "",
                        "lastLoginDate": "",
                        "status": "NORMAL",
                        "nickname": "Junrui Kang",
                        "familyId": "56b00a46e4b021083bb2c8e8",
                        "regDate": "",
                        "avatar": ""
                    }
                }
            ],
            "createTime": 1455761390606,
            "author": {
                "id": "56b00a46e4b021083bb2c8e7",
                "thumbnail": "",
                "lastLoginDate": "",
                "status": "NORMAL",
                "nickname": "Junrui Kang",
                "familyId": "56b00a46e4b021083bb2c8e8",
                "regDate": "",
                "avatar": ""
            },
            "dogs" : [{
            	"id":"",
            	"name":"",
            	"avatar":"",
            	"breed":"",
            	"birthday":"",
            	"createTime":"",
            	
            	//如果是遛的狗，有一下信息
            	"startTime" : "xxx",
            	"endTime" : "xxx",
            	"duration":"",
            	"distance":"",
            	"calorie":"",
            	"exercise" : {
                        "expect" : 4234,
                        "actual" : 2323
                }
            }]
        }
    ]
}
```

##标签相关接口
###查询标签
####接口:/tag/query
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|query|字符串|标签名，模糊匹配|是|ab|
|size|整型|每页大小,默认是10|否|10|
####成功返回值

```
{
    "ret": 200,
    "data": {
    	"query":"ab",
    	"total":100,
    	"tags":[
    	 {
    	 	"tag":"abc",
    	 	"posts":242
    	 },{
    	 	"tag":"abcd",
    	 	"posts":434
    	 }
    	]
    }
}
```

###获得某个标签的最新内容
####接口:/note/tag/recent
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|tag|字符串|标签名|是|xxxxxxxxxxx|
|page|整型|分页,默认是1|否|1|
|size|整型|每页大小,默认是10|否|10|
####成功返回值

```
{
    "ret": 200,
    "data": [
        {
            "id": "56c527eee4b0d4e743a592a1",
            "userId": "56b00a46e4b021083bb2c8e7",
            "familyId": "56b00a46e4b021083bb2c8e8",
            "photoUrl": "http://fanyi.baidu.com/static/i18n/zh/widget/translate/head/logo/logo_16ea8bb7.png",
            "words": "",
            "topicId": "",
	    "hasLocation":true,
            "lng":23.4353,
            "lat":54.2323,
            "likes": 99,
            "type" : "WALK", //可取值 WALK, PIC
            
            "comments": [
                {
                    "id": "56c527eee4b0d4e743a592a2",
                    "noteId": "56c527eee4b0d4e743a592a1",
                    "userId": "56b00a46e4b021083bb2c8e7",
                    "words": "I'm a reply...",
                    "replyUserId": "",
                    "createTime": 1455761390650,
                    "author": {
                        "id": "56b00a46e4b021083bb2c8e7",
                        "thumbnail": "",
                        "lastLoginDate": "",
                        "status": "NORMAL",
                        "nickname": "Junrui Kang",
                        "familyId": "56b00a46e4b021083bb2c8e8",
                        "regDate": "",
                        "avatar": ""
                    }
                }
            ],
            "createTime": 1455761390606,
            "author": {
                "id": "56b00a46e4b021083bb2c8e7",
                "thumbnail": "",
                "lastLoginDate": "",
                "status": "NORMAL",
                "nickname": "Junrui Kang",
                "familyId": "56b00a46e4b021083bb2c8e8",
                "regDate": "",
                "avatar": ""
            },
            "dogs" : [{
            	"id":"",
            	"name":"",
            	"avatar":"",
            	"breed":"",
            	"birthday":"",
            	"createTime":"",
            	
            	//如果是遛的狗，有一下信息
            	"startTime" : "xxx",
            	"endTime" : "xxx",
            	"duration":"",
            	"distance":"",
            	"calorie":"",
            	"exercise" : {
                        "expect" : 4234,
                        "actual" : 2323
                }
            }]
        }
    ]
}
```

###获得某个标签的最热内容
####接口:/note/tag/top
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|tag|字符串|标签名|是|xxxxxxxxxxx|
|page|整型|分页,默认是1|否|1|
|size|整型|每页大小,默认是10|否|10|
####成功返回值

```
{
    "ret": 200,
    "data": [
        {
            "id": "56c527eee4b0d4e743a592a1",
            "userId": "56b00a46e4b021083bb2c8e7",
            "familyId": "56b00a46e4b021083bb2c8e8",
            "photoUrl": "http://fanyi.baidu.com/static/i18n/zh/widget/translate/head/logo/logo_16ea8bb7.png",
            "words": "",
            "topicId": "",
	    "hasLocation":true,
            "lng":23.4353,
            "lat":54.2323,
            "likes": 99,
            "type" : "WALK", //可取值 WALK, PIC
            
            "comments": [
                {
                    "id": "56c527eee4b0d4e743a592a2",
                    "noteId": "56c527eee4b0d4e743a592a1",
                    "userId": "56b00a46e4b021083bb2c8e7",
                    "words": "I'm a reply...",
                    "replyUserId": "",
                    "createTime": 1455761390650,
                    "author": {
                        "id": "56b00a46e4b021083bb2c8e7",
                        "thumbnail": "",
                        "lastLoginDate": "",
                        "status": "NORMAL",
                        "nickname": "Junrui Kang",
                        "familyId": "56b00a46e4b021083bb2c8e8",
                        "regDate": "",
                        "avatar": ""
                    }
                }
            ],
            "createTime": 1455761390606,
            "author": {
                "id": "56b00a46e4b021083bb2c8e7",
                "thumbnail": "",
                "lastLoginDate": "",
                "status": "NORMAL",
                "nickname": "Junrui Kang",
                "familyId": "56b00a46e4b021083bb2c8e8",
                "regDate": "",
                "avatar": ""
            },
            "dogs" : [{
            	"id":"",
            	"name":"",
            	"avatar":"",
            	"breed":"",
            	"birthday":"",
            	"createTime":"",
            	
            	//如果是遛的狗，有一下信息
            	"startTime" : "xxx",
            	"endTime" : "xxx",
            	"duration":"",
            	"distance":"",
            	"calorie":"",
            	"exercise" : {
                        "expect" : 4234,
                        "actual" : 2323
                }
            }]
        }
    ]
}
```

##事件相关接口
###事件记录接口
####接口:/event/record
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|type|字符串|事件类型，有四种，分别为（BATH，VACCINATE，REPELLENT，ESTRUS）|是|BATH|
|dogId|字符串|狗id|是|xxxxxxx|
|date|长整型|记录的时间，若为空，则取服务器当前时间，毫秒数|否|12231345645646456|
|remark|字符串|备注|否|在宠物店洗的|
|cycle|整型|周期|否|30|
|unit|字符串|周期单位，可选值有day,week,month,year。若有cycle，则此必须|否|day|
####成功返回值

```
{
    "ret": 200,
    "data": ""
}
```

###事件概况接口
####接口:/event/summary
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogId|字符串|狗id|是|xxxxxxx|
####成功返回值

```
{
    "ret": 200,
    "data": [
        {
            "type": "BATH",
            "icon": "http://xxxxx.xxx/xxx.jpg",
            "count": 12,
            "lastRecord": {
                "id": "",
                "dogId": "",
                "recorder": {
                    "id": "",
                    "nickname": "",
                    "avatar": ""
                },
                "remark": "",
                "cycle": 30,
                "time": 1232312312312
            },
            "eventCycle": {
                "cycle": 30,
                "unit": "day"
            }
        },
        {
            "type": "VACCINATE",
            "icon": "http://xxxxx.xxx/xxx.jpg",
            "eventCycle": {
                "cycle": 1,
                "unit": "week"
            },
            "count": 0
        },
        {
            "type": "REPELLENT",
            "icon": "http://xxxxx.xxx/xxx.jpg",
            "eventCycle": {
                "cycle": 5,
                "unit": "day"
            },
            "count": 0
        },
        {
            "type": "ESTRUS",
            "icon": "http://xxxxx.xxx/xxx.jpg",
            "eventCycle": {
                "cycle": 1,
                "unit": "year"
            },
            "count": 0
        }
    ]
}
```
###事件记录列表接口
####接口:/event/list
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogId|字符串|狗id|是|xxxxxxx|
|type|字符串|事件类型|是|BATH|
|maxId|字符串|最大的id，分页用|否|xxxxxxx|
|size|字符串|要获取的记录数，默认10|否|10|
####成功返回值

```
{
    "ret": 200,
    "data": [
        {
            "id": "",
            "dogId": "",
            "recorder": {
                "id": "",
                "nickname": "",
                "avatar": ""
            },
            "remark": "",
            "cycle": 30,
            "time": 1232312312312
        }
    ]
}
```
#长连接RPC接口
type=RPC
body中的action指定方法，params中设置参数
返回类型为ack，消息内容看返回消息的body

###标记已读接口
####接口action:MarkChatMessageAsRead
####接口参数
|格式说明|类型|描述|是否必须|示例|
|---|---|---|---|---|
|oppositeId=xxxx&type=PRIVATE&seq=xxx|oppositeId:字符串,seq：long|会话及其最后一条已读消息的seq|是|oppositeId=xxxx&type=PRIVATE&seq=5|
####成功body返回值

```
{
    "ret": 200,
    "data": {
        "oppositeId":"xxxxxx",
        "type":"PRIVATE",
        "result":true
    }
}
```

###获得有未读消息的会话列表
####接口action:GetUnreadChatList
####接口参数
无
####成功body返回值

```
{
    "ret": 200,
    "data": [{
        "oppositeId":"xxxxxx",
        "type":"PRIVATE",
        "count":4
    },{
        "oppositeId":"xxxxxx",
        "type":"GROUP",
        "count":2
    }]
}
```

###根据对方id推送该会话最老的N条未读消息
####接口action:GetUnreadMessagesByOppositeId
####接口参数
|格式说明|类型|描述|是否必须|示例|
|---|---|---|---|---|
|oppositeId=xxx&chatType=GROUP&size=10|oppositeId:字符串,chatType聊天类型|对方Id加上类型，确认唯一会话|是|oppositeId=xxxxxx&chatType=GROUP|
####成功body返回值

```
{
    "ret": 200,
    "data":[{
    }]
}
```

###獲取可用的chat server端口列表
####接口/chat/avaliableServerPorts
####成功body返回值

```
{
    "ret": 200,
    "data":[1,2,3]
}
```

#推送格式
##申请加为好友
```
{
    "type": "notice",
    "noticeType":"apply",
    "action":"friend",
    "content":"xxx send you a friend request",
    "user":{
    	"id":"",
    	"nickname":"",
    	"avatar":""
    }
}
```
##申请加入家庭
```
{
    "type": "notice",
    "noticeType":"apply",
    "action":"family",
    "content":"xxx wanna join your family",
    "user":{
    	"id":"",
    	"nickname":"",
    	"avatar":""
    }
}
```
##同意加入家庭
```
{
    "type": "notice",
    "noticeType":"notification",
    "action":"agree_family",
    "content":"You have joined xxx's family",
    "user":{
    	"id":"",
    	"nickname":"",
    	"avatar":""
    }
}
```
##拒绝加入家庭
```
{
    "type": "notice",
    "noticeType":"notification",
    "action":"disagree_family",
    "content":"xxx do not accept your join family request",
    "user":{
    	"id":"",
    	"nickname":"",
    	"avatar":""
    }
}
```
##同意加为好友
```
{
    "type": "notice",
    "noticeType":"notification",
    "action":"agree_friend",
    "content":"xxx has accepted your friend request",
    "user":{
    	"id":"",
    	"nickname":"",
    	"avatar":""
    }
}
```
##拒绝加入家庭
```
{
    "type": "notice",
    "noticeType":"notification",
    "action":"disagree_friend",
    "content":"xxx do not accept your friend request",
    "user":{
    	"id":"",
    	"nickname":"",
    	"avatar":""
    }
}
```
##呼朋引伴
```
{
    "type": "notice",
    "noticeType":"QuitDate",//JoinDate或者CancelDate
    "dogId":["xxx","xxx","xxx"],
    "message":"xxx join your dating"
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
|NICKNAME_HAS_EXIST|昵称已经存在|
|NICKNAME_IS_INVALID|昵称不合法|
|OAUTH_ALREADY_BIND|第三方账号已经绑定别的用户|
|USER_EXISTS|用户已经存在|
|ALREADY_IN_OTHER_FAMILY|用户已经加入某个家庭|
|USER_NOT_EXIST|用户不存在|
|VALID_FAILED|第三方账号二次校验失败|
|PUSH_FAILED|推送失败|
|NO_PERMISSION|没有权限|
|WALK_DOG_FINISH|遛狗已经结束|
|WALK_DOG_NOT_FINISH|遛狗还未结束|
|OVER_MAX_WALK_TIME|超过最大遛狗时间|
|ALREADY_LIKE|已经点赞|
|OVER_MAX_DOGS|超过一个家庭所能拥有的最大狗数目|
|USER_IS_HOMELESS|用户未加入任何一个家庭|
|NOT_FOLLOWED|没有关注|
|ALREADY_FOLLOW|已经关注|
|PASSWD_NOT_MATCH|密码不匹配|
|USER_HAS_IN_DATING|用户已经加入了呼朋引伴|
|REPEAT_REQUEST|重复请求|
|WE_ARE_FAMILY|同一个家庭|
|IN_BLOCK_LIST|用户在黑名单中|
|ALREADY_FRIEND|已经是好友了|
