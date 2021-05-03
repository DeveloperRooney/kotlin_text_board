package article

import java.text.SimpleDateFormat

class Util {

    fun getNowDate():String {

        var format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        return format.format(System.currentTimeMillis())
    }
}