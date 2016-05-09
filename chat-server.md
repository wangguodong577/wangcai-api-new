
#域名
```
  测试:52.11.70.32 56789
  正式:push.nuzzle.me 56789
```

##  RPC 相关

**客户端调用rpc需要在Body里面传两个参数，Action 和 params，其中，params为key=value&key=value格式，注意对value进行urlEncode**
**返回的data为字符串，需要手动转换， 其中包含action和content两项内容**

###获取群组详情
#####RPC Body Action : GetGroupDetails 
#####params
|参数名|类型|描述|是否必须|示例|
|---|---|---|---|---|
|groupIds|字符串|群id，以","分割|是|1,2|

####返回ACK中Body为
```
{
  ret: 200
  data: "{\"action\":\"GetGroupDetails\",\"content\":[{\"owner\":\"56fa401a5e0a239bba8eb538\",\"creator\":\"56fa401a5e0a239bba8eb538\",\"createTime\":1459859928161,\"name\":\"alpha-team\",\"id\":\"5703b1d85e0af04f5b2966cb\"}]}"
}
```
