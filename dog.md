#通用参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|token|字符串|用户登录凭证|是(登录、注册接口除外)||
|tz|字符串|用户所在时区|是|Asia/Shanghai|
|pf|字符串|客户端平台类型,ios或者android|是|ios|
#接口域名
```
  测试:api.test.enterest.me
  正式:api.enterest.me
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
    	"host":"52.88.106.245",
    	"port":"15624",
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
|city|字符串|用户所在城市|否|beijing|
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

##面对面相关接口
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
    "data": ""
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

###查看周边的家庭
####接口:/square/around
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|country|字符串|用户所在国家|是|china|
|city|字符串|用户所在城市|是|beijing|
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


##家庭相关接口

###家庭地理位置上报
####接口:/families/location
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|country|字符串|用户所在国家|是|china|
|city|字符串|用户所在城市|是|beijing|
|lng|浮点型|经度|是|12.315456|
|lat|浮点型|维度|是|25.145644|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###邀请加入家庭
####接口:/families/invite
####请求方式:POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|content|字符串|邮件正文,最长300字符|是|hi,xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|
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

###家长审核申请
####接口:/families/audit
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
####成功返回值
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
        "recent":[{
        	"id":"",
        	"photoUrl":"",
        	"userId":"",
        	"familyId":""
        }]
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
|gender|字符串|性别,male,female|否|male|
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
                "avatar": ""
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
|avatar|字符串|狗的头像链接|是|http://xxx.xx/xx.jpg|
|gender|字符串|狗的性别,可选值为male或female|是|male|
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
                "breed": "56b00a46e4b021083bb2c8e8"
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
    "ret":200,
    "data":
    	{
        	"id": "56b00a46e4b021083bb2c8e7",
                "name": "",
                "avatar": "",
                "birthday": "NORMAL",
                "height":43,
                "weight":43,
                "bodyType":"perfect",
                "recommendExercise":43,
                "gender": "Junrui Kang",
                "breed": "56b00a46e4b021083bb2c8e8"
                "walkDogs":[{
                	"id":"",
                	"walkId":"",
                	"userId":"",
                	"dogId":"",
                	"startTime":"",
                	"endTime":"",
                	"duration":"",
                	"distance":"",
                	"calorie":""
                }]
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
###发送信息
####接口:/chat/send
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|receiver|字符串|接收用户id|是|dsdfsldfjlasfe|
|content|字符串|正文|否,当且仅当是文字信息时为必须|你好啊,美女|
|url|字符串|资源地址|否,当且仅当不是文字信息时为必须|http://sss/sss.amr|
|type|字符串|消息类型,可选值为(TEXT,AUDIO,VEDIO,IMAGE,LOCATION)|是|text|
####成功返回值
```
{
    "ret": 200,
    "data": {
        "id": "sdflsjdflsjldfjslfdjlsdjflsf",
        "sender": "sdfsdafsadfasdfsdfasdfasf23223",
        "senderUser": {
            "id": "",
            "nickname": "",
            "avatar": ""
        },
        "receiverUser": {
            "id": "",
            "nickname": "",
            "avatar": ""
        },
        "receiver": "sdfasfweefweafaef2324e",
        "type": "TEXT",
        "hasRead": false,
        "sendTime": 1234564561646546,
        "url": "",
        "content": "abcdefg",
        "sessionId": "sdfasfweefweafaef2324e"
    }
}
```

###阅读信息,根据当前用户与目标用户之间的所有未读的消息
####接口:/chat/read
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|对方的用户id|是|dsdfsldfjlasfe|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "id": "sdflsjdflsjldfjslfdjlsdjflsf",
            "sender": "sdfsdafsadfasdfsdfasdfasf23223",
            "receiver": "sdfasfweefweafaef2324e",
            "senderUser": {
                "id": "",
                "nickname": "",
                "avatar": ""
            },
            "receiverUser": {
                "id": "",
                "nickname": "",
                "avatar": ""
            },
            "type": "TEXT",
            "hasRead": false,
            "sendTime": 1234564561646546,
            "url": "",
            "content": "abcdefg",
            "sessionId": "sdfasfweefweafaef2324e"
        },
        {
            "id": "sdflsjdflsjldfjslfdjlsdjflsdddddf",
            "sender": "sdfsdafsadfasdfsdfasdfasf23223",
            "receiver": "sdfasfweefweafaef2324e",
            "senderUser": {
                "id": "",
                "nickname": "",
                "avatar": ""
            },
            "receiverUser": {
                "id": "",
                "nickname": "",
                "avatar": ""
            },
            "type": "TEXT",
            "hasRead": false,
            "sendTime": 1234564561646546,
            "url": "",
            "content": "dfa",
            "sessionId": "sdfasfweefweafaef2324e"
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
|id|字符串数组|消息的id列表|是|id=dsdfsldfjlasfe1&id=dsdfsldfjlasfe2|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###获得会话信息
####接口:/chat/list
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|对方的用户id|是|dsdfsldfjlasfe|
|maxId|字符串|最后一条记录|是|2323rfasdfasdfasdfsaf|
|size|数字|消息数|否,默认为10|15|
####成功返回值
```
{
    "ret": 200,
    "data": [
        {
            "id": "sdflsjdflsjldfjslfdjlsdjflsf",
            "sender": "sdfsdafsadfasdfsdfasdfasf23223",
            "receiver": "sdfasfweefweafaef2324e",
            "senderUser": {
                "id": "",
                "nickname": "",
                "avatar": ""
            },
            "receiverUser": {
                "id": "",
                "nickname": "",
                "avatar": ""
            },
            "type": "TEXT",
            "hasRead": false,
            "sendTime": 1234564561646546,
            "url": "",
            "content": "abcdefg",
            "sessionId": "sdfasfweefweafaef2324e"
        },
        {
            "id": "sdflsjdflsjldfjslfdjlsdjflsdddddf",
            "sender": "sdfsdafsadfasdfsdfasdfasf23223",
            "receiver": "sdfasfweefweafaef2324e",
            "senderUser": {
                "id": "",
                "nickname": "",
                "avatar": ""
            },
            "receiverUser": {
                "id": "",
                "nickname": "",
                "avatar": ""
            },
            "type": "TEXT",
            "hasRead": false,
            "sendTime": 1234564561646546,
            "url": "",
            "content": "dfa",
            "sessionId": "sdfasfweefweafaef2324e"
        }
    ]
}
```

##朋友相关接口
###申请加为朋友
####接口:/friend/apply
####请求方式:POST
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
###获得申请交朋友详情
####接口:/friend/apply
####请求方式:GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|applyId|字符串|申请id|是|dsdfsldfjlasfe|
####成功返回值
```
{
    "ret":200,
    "data":{
		"id":"xxxxxx",
		"applyUserId":"sfsdfasdfasdfsadfasdfasdfs",
		"reason":"美女你好啊,交个朋友呗",
		"operator":"xxxxxxxxx",
		"handle":false,
		"applyTime":"15646545616546"
	}
}
```

###取消好友申请
####接口:/friend/cancel
####请求方式:GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|userId|字符串|对方的用户id|是|dsdfsldfjlasfe|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###审核朋友申请
####接口:/friend/audit
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|applyId|字符串|申请id|是|dsdfsldfjlasfe|
|accept|布尔值|是否同意|是|true|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

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

###显示所有的好友申请
####接口:/friend/applys
####请求方式:GET/POST
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
		"userId":"xdsfjakldfsaldfjsdf",
		"applyTime":"15646545616546"
	}]
}
```

##溜溜相关接口
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
####成功返回值,返回本次遛狗唯一编号,walkId
```
{
    "ret":200,
    "data":{
		"id":"xxxxxxxxxx"
	}
}
```

###结束遛狗
####接口:/walk/finish
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
|walkId|字符串|本次遛狗id|是|ekwjldjslfjasldfj|
|lat|double|维度|是|111.8834140000|
|lng|double|经度|是|37.2888310000|
|remain|布尔值|是否依然在遛狗,若遛狗时间超过最大遛狗时间,需要明确指明,否则会提示错误|否|true|
####成功返回值
```
{
    "ret":200,
    "data":""
}
```

###查看附近的人
####接口:/walk/nearby
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|distance|double|半径范围,单位是米|是|3000|
|lat|double|维度|否|111.8834140000|
|lng|double|经度|否|37.2888310000|
####成功返回值
```
{
    "ret":200,
    "data":{
		"family":[{
			"name":"",
			"avatar":"",
			"location":{
				"longitude":111.8834140000,
				"latitude":37.2888310000
			}
		}],
		"friend":[{
			"name":"",
			"avatar":"",
			"location":{
				"longitude":111.8834140000,
				"latitude":37.2888310000
			}
		}],
		"stranger":[{
			"name":"",
			"avatar":"",
			"location":{
				"longitude":111.8834140000,
				"latitude":37.2888310000
			}
		}]
	}
}
```

##消息相关接口
###获得未读消息提醒,ios
####接口:/message/unread/ios
####请求方式:GET/POST
####接口参数
无
####成功返回值

```
{
    "ret": 200,
    "data": [{
        "senderId": "",
        "name": "",
        "avatar": "",
        "type": "message",
        "message": "xxxxxx"
    }]
}
```
###获得未读消息提醒,android
####接口:/message/unread/android
####请求方式:GET/POST
####接口参数
无
####成功返回值

```
{
    "ret": 200,
    "data": [{
        "sender": {
        	"id":"",
        	"avatar":"",
        	"name":""
        }
        "name": "",
        "avatar": "",
        "type": "message",
        "message": "xxxxxx"
    }]
}
```

##话题相关接口
###获得话题列表
####接口:/topic/list
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|order|字符串|排序方式,photo根据照片数量降序,like,根据话题点赞数降序|否,默认是photo|photo|
|page|整型|分页,默认是1|否|1|
|size|整型|每页大小,默认是10|否|10|
####成功返回值

```
{
    "ret": 200,
    "data": [{
        "id":"",
        "name": "",
        "likeCount": 4,
        "photoCount": 3,
        "createTime": 2323232333223
    }]
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
|{"sessionId":seq}|sessionId:字符串,seq：long|会话及其最后一条已读消息的seq|是|{"session1":1,"session2",3}|
####成功body返回值

```
{
    "ret": 200,
    "data": {
    	"session1":true,
    	"session2":true
    }
}
```

###获得有未读消息的会话列表
####接口action:GetUnreadSessionList
####接口参数
无
####成功body返回值

```
{
    "ret": 200,
    "data": {
    	"session1":2,
    	"session2":3
    }
}
```

###根据会话id推送该会话最老的十条未读消息,消息会通过另外一个长连接发送，此消息返回ack
####接口action:GetUnreadMessagesBySession
####接口参数
|格式说明|类型|描述|是否必须|示例|
|---|---|---|---|---|
|sessionId=xxx|sessionId:字符串|会话Id|是|sessionId=xxxxxx|
####成功body返回值

```
{
    "ret": 200,
    "data": ""
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
|USER_HAS_JOIN_FAMILY|用户已经加入某个家庭|
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
