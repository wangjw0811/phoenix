# 1.注解说明
* 1.1 @NotBlank、@NotNull、@NotEmpty三者之间的区别
    * @NotNull：不能为null，但可以为空字符串
    * @NotEmpty：不能为null，并且长度必须大于0
    * @NotBlank：只能作用在String上，不能为null，而且调用trim()后，长度必须大于0

* 1.2 @Builder
    * 参考链接： https://www.liangzl.com/get-article-detail-125474.html


# 2.mysql相关操作
* 2.1 关于主键id自增 AUTO_INCREMENT 重置
    * 直接重置autoIncrement的值
    `ALTER TABLE table_name AUTO_INCREMENT = 1;`
    * 通过truncate table 完成
    `TRUNCATE TABLE table_name;`
    * 删除表，然后重建表

* 2.1 由于JavaScript中Number类型的自身原因，并不能完全表示Long型的数字，
      在Long长度大于17位时会出现精度丢失的问题（四舍五入的方式丢弃后两位）