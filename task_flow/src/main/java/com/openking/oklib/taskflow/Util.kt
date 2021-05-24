package com.openking.oklib.taskflow

/***
 *
 * 去好好学习吧,又看源码,看你妹呀！
 * author: openKing
 * e-mail: 362608496@qq.com
 * date: 2021/5/2116:41
 * des:
 */
object Util {
    //比较两个任务的先后执行顺序
    //优先级越高越优先
    fun compareTask(task1: Task, task2: Task): Int {
        if (task1.priority < task2.priority) {
            return 1
        }
        if (task1.priority > task2.priority) {
            return -1
        }
        return 0
    }
}