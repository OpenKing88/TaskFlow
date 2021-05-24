package com.openking.oklib.taskflow

/***
 *
 * 去好好学习吧,又看源码,看你妹呀！
 * author: openKing
 * e-mail: 362608496@qq.com
 * date: 2021/5/2117:09
 * des:task创建接口
 */
interface ITaskCreator {
    fun createTask(taskName: String): Task
}