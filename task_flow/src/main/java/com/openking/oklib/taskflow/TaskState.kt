package com.openking.oklib.taskflow

import androidx.annotation.IntDef

/***
 *
 * 去好好学习吧,又看源码,看你妹呀！
 * author: openKing
 * e-mail: 362608496@qq.com
 * date: 2021/5/2116:11
 * des: task任务的状态注解
 */
@Retention(AnnotationRetention.SOURCE)
@IntDef(
    TaskState.IDLE,
    TaskState.START,
    TaskState.RUNNING,
    TaskState.FINISHED,
)

annotation class TaskState {
    companion object {
        const val IDLE = 0//静止
        const val START = 1//启动，可能需要等待调度
        const val RUNNING = 2//运行
        const val FINISHED = 3//运行结束
    }
}
