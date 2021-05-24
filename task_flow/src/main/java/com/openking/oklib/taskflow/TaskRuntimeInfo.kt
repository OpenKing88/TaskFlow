package com.openking.oklib.taskflow

import android.util.SparseArray

/***
 *
 * 去好好学习吧,又看源码,看你妹呀！
 * author: openKing
 * e-mail: 362608496@qq.com
 * date: 2021/5/2117:46
 * des: 用于记录每一个task对象运行时的信息封装
 */
class TaskRuntimeInfo(val task: Task) {
    val stateTime = SparseArray<Long>()
    var isBlockTask = false
    var threadName: String? = null

    fun setStateTime(@TaskState state: Int, time: Long) {
        stateTime.put(state, time)
    }

    fun isSameTask(task: Task?): Boolean {
        return task != null && this.task == task
    }

    override fun toString(): String {
        return "TaskRuntimeInfo{" +
                "stateTime=" + stateTime +
                ", isBlockTask=" + isBlockTask +
                ", task=" + task +
                ", threadName='" + threadName + '\'' +
                '}'
    }
}