##升级相关接口
###检查升级接口
####接口:/upgrade/check
####请求方式:POST/GET
####接口参数
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|pid|整型|每个产品唯一标识|是|100016|
|ver|整型|客户端当前版本号|是|12|
|channel|字符串|渠道|是|gp|
|locale|字符串|客户端国家语言|否|zh_CN|
|net|字符串|网络环境，2G、3G、WIFI|否|WIFI|
####成功返回值
```
{
    "timestamp": 1466491532694,
    "ret": 200,
    "data": {
        "level": 1, // 升级级别
        "remindCycle": 3, // 若level为1，则此字段表示提醒的天数间隔
        "instructions": "Express Yourself!<br/>1) Inspired? Start a video trend and get everyone to join in the fun!<br/>2) Check out and follow creative and funny short videos!<br/>3) See who liked your videos.", //升级说明，换行用<br/>分割
        "packageName": "com.holaverse.video",// 包名
        "channel": "gp", // 渠道，有官方渠道gp和appstore，若是其他渠道，如线下。则可能需要下载安装文件自行安装
        "versionCode": 6, // 最新的版本号
        "versionName": "1.06", // 最新的版本名称
        "hasAttachment": false, // 是否有升级包
        "fileSize": 0, // 升级包大小
        "md5": "", // 升级包md5校验
        "downloadUrl": "", // 升级包下载路径
        "uploadTime": 1465852994000 // 此版本发布时间
    }
}
```
