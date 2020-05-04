package io.github.lamprose.bookshell.network.entity

data class BookBean(
    var name:String,
    var author:String,
    var img:String,
    var id:Long
)



data class BookInfoBean(
    var isbn:String,
    var title:String?=null,
    var desc:String?=null,
    var coverImg:String?=null,
    var author: String?=null,
    var summary:String?=null
)