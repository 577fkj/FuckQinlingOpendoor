package cn.fkj233.fuckqinling.hook

import com.github.kyuubiran.ezxhelper.utils.Log
import com.github.kyuubiran.ezxhelper.utils.findMethod
import com.github.kyuubiran.ezxhelper.utils.hookBefore


object DisableKaijiaAD : BaseHook() {
    override fun init() {
//        findMethod("com.kaijia.adsdk.center.AdCenter") { name == "onReqSuccess" }.hookBefore {
//            Log.d("args0: ${it.args[0]} args1: ${it.args[1]}")
//        }
        findMethod("com.kaijia.adsdk.Utils.q") { name == "a" }.hookBefore {
            Log.d("decode return: ${it.result}")
            it.result = ""
        }
        findMethod("g.r.b.h.a") { name == "d" }.hookBefore {
            it.result = null
        }

    }
}