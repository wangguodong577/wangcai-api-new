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
###账号注册,包含有狗的注册,无狗的注册,邀请邮箱注册
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
|authToken|字符串|认证token,若为面对面加入家庭或者email申请加入,则为必填|是|lsdfjlsdfjlsdjf|
|email|字符串|用户邮箱,若type为email或通过邀请邮箱注册,则必须|是|test@holaverse.com|
|password|字符串|用户密码,若type为email,则必须,进行32位md5|是|23232323|
|dogName|字符串|狗的名字,有狗为必填|是|旺财|
|dogAvatar|字符串|狗的头像,有狗为必填|是|/avatar/dog/lsdfj.jpg|
|locale|字符串|用户语言|否||
|timezone|字符串|用户所在时区|是|8|
|locationId|字符串|用户所在地区id|否||
|locationName|字符串|用户所在地区名|否||
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
###发布动态
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
###评论动态
####接口:/note/reply
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

##家庭相关接口
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
                "gender": "Junrui Kang",
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

###狗的基本信息
####接口:/dog/info
####请求方式:GET/POST
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|dogId|字符串|狗的id|是|bobo|
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
###获得未读消息提醒
####接口:/message/unread
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
|USER_NOT_EXIST|用户已经加入某个家庭|
|USER_NOT_EXIST|用户不存在|
|VALID_FAILED|第三方账号二次校验失败|
|PUSH_FAILED|推送失败|
|NO_PERMISSION|没有权限|
|WALK_DOG_FINISH|遛狗已经结束|
|WALK_DOG_NOT_FINISH|遛狗还未结束|
|OVER_MAX_WALK_TIME|超过最大遛狗时间|
|ALREADY_LIKE|已经点赞|
|OVER_MAX_DOGS|超过一个家庭所能拥有的最大狗数目|
