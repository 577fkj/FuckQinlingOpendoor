package cn.fkj233.fuckqinling.hook

abstract class BaseHook {
    var isInit: Boolean = false
    abstract fun init()
}