package com.openking.oklib.taskflow

/***
 *
 * 去好好学习吧,又看源码,看你妹呀！
 * author: openKing
 * e-mail: 362608496@qq.com
 * date: 2021/5/2116:22
 * des:任务task执行状态的监听器
 */
interface TaskListener {

    fun onStart(task: Task)

    fun onRunning(task: Task)

    fun onFinished(task: Task)
}