package cn.fkj233.fuckqinling.hook

import com.github.kyuubiran.ezxhelper.utils.Log
import com.github.kyuubiran.ezxhelper.utils.loadClass
import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XposedBridge

object DisableUmeng : BaseHook() {
    override fun init() {
        try {
            val umengClass = loadClass("com.umeng.commonsdk.UMConfigure")
            XposedBridge.hookAllMethods(umengClass, "init", XC_MethodReplacement.DO_NOTHING)
            XposedBridge.hookAllMethods(umengClass, "preInit", XC_MethodReplacement.DO_NOTHING)
            XposedBridge.hookAllMethods(umengClass, "getOaid", XC_MethodReplacement.DO_NOTHING)
        } catch (e: Exception) {
            Log.e(e)
        }
    }
}