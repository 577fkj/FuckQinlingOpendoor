package cn.fkj233.fuckqinling.hook

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.kyuubiran.ezxhelper.utils.*
import java.net.Proxy


object OkHttp3 : BaseHook() {
    override fun init() {
        findMethod("java.net.URL") { name == "openConnection" && paramCount >= 1 && parameterTypes[0] == Proxy::class.java }.hookBefore {
            it.result = it.thisObject.invokeMethod("openConnection")
        }
        findMethod("okhttp3.OkHttpClient\$Builder") { name == "proxy" }.hookBefore {
            it.result = it.thisObject
        }
        findMethod("com.fighter.fs") { name == "select" }.hookBefore {
            it.result = emptyList<Proxy>()
        }
        findMethod("com.kwad.sdk.core.videocache.i") { name == "select" }.hookBefore {
            it.result = emptyList<Proxy>()
        }
//        findMethod("g.r.b.g.e") { name == "f" }.hookBefore {
//            Log.d("f args = ${it.args[0]}")
//        }
//        findMethod("g.r.d.k.c") { name == "g"}.hookBefore {
//            Log.d("g args = ${it.args[0]} args1 = ${it.args[1]} args2 = ${it.args[2]}")
//        }
//        findMethod("g.r.d.k.c") { name == "i"}.hookBefore {
//            Log.d("i args = ${it.args[0]} args1 = ${it.args[1]}")
//        }
    }
}