package cn.fkj233.fuckqinling.hook

import com.github.kyuubiran.ezxhelper.utils.Log
import com.github.kyuubiran.ezxhelper.utils.findMethod
import com.github.kyuubiran.ezxhelper.utils.hookAfter
import com.github.kyuubiran.ezxhelper.utils.hookBefore

object DisableQinlinAD : BaseHook() {
    override fun init() {
        findMethod("g.r.d.h.f") { name == "h" }.hookAfter {
            Log.d("h result = ${it.result}")
            it.result = "http://0.0.0.0"
        }
    }
}