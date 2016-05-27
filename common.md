### s3图片处理

1， 配置规则

   规则配置在ddb表 img-process中，key为 s3Prefix。value为rules，其中rules参数如下
   
   1) t. threshold 图片大小阈值，单位byte。**如果设置了该值，只有传过来的图片大于该值时才会做压缩处理，否则只是拷贝**
   
   2) q. quality 图片质量，百分制。如果不设置，默认为75
   
   3) h. height 图片高度，可以设置为整数像素值或者字符串百分比。
   
   4) w. width 图片宽度，可以设置为整数像素值或者字符串百分比。
   
   ** q h w 不能同时为空 **
   
   ** h w 同时为空，默认为100% **
   
   5) a. aliasDir 处理后的图片另存目录。如果a没有设置时
   
      i)  h w 同时为空，默认a为 _t_
      
      ii) a 为 w + "x" + h
      
