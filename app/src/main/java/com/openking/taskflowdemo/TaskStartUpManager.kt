package com.openking.taskflowdemo

import android.util.Log
import com.openking.oklib.taskflow.ITaskCreator
import com.openking.oklib.taskflow.Project
import com.openking.oklib.taskflow.Task
import com.openking.oklib.taskflow.TaskFlowManager

object TaskStartUpManager {
    const val TASK_BLOCK_1 = "block_task_1"
    const val TASK_BLOCK_2 = "block_task_2"
    const val TASK_BLOCK_3 = "block_task_3"

    const val TASK_ASYNC_1 = "async_task_1"
    const val TASK_ASYNC_2 = "async_task_2"
    const val TASK_ASYNC_3 = "async_task_3"

    @JvmStatic
    fun start() {
        Log.e("TaskStartUpManager", "start")
        /**
         * 添加任务到任务组，并通过TaskCreator来创建Task，包括异步任务和同步任务
         */
        val project = Project.Builder("TaskStartUpManager", createTaskCreator())
            .add(TASK_BLOCK_1)
            .add(TASK_BLOCK_2)
            .add(TASK_BLOCK_3)
            .add(TASK_ASYNC_1).dependOn(TASK_BLOCK_1)
            .add(TASK_ASYNC_2).dependOn(TASK_BLOCK_2)
            .add(TASK_ASYNC_3).dependOn(TASK_BLOCK_3)
            .build()
        /**
         * 通过TaskFlowManager来启动初始化任务
         */
        TaskFlowManager
            .addBlockTask(TASK_BLOCK_1)
            .addBlockTask(TASK_BLOCK_2)
            .addBlockTask(TASK_BLOCK_3)
            .start(project)

        Log.e("TaskStartUpManager", "end")
    }

    private fun createTaskCreator(): ITaskCreator {
        return object : ITaskCreator {
            override fun createTask(taskName: String): Task {
                when (taskName) {
                    TASK_ASYNC_1 -> return createTask(taskName, true)
                    TASK_ASYNC_2 -> return createTask(taskName, true)
                    TASK_ASYNC_3 -> return createTask(taskName, true)

                    TASK_BLOCK_1 -> return createTask(taskName, false)
                    TASK_BLOCK_2 -> return createTask(taskName, false)
                    TASK_BLOCK_3 -> return createTask(taskName, false)
                }
                return createTask("default", false)
            }
        }
    }

    fun createTask(taskName: String, isAsync: Boolean): Task {
        return object : Task(taskName, isAsync) {
            override fun run(id: String) {
                when (taskName) {
                    TASK_ASYNC_1 -> {
                        //do something
                    }
                    TASK_ASYNC_2 -> {
                        //do something
                    }
                    TASK_ASYNC_3 -> {
                        //do something
                    }
                    TASK_BLOCK_1 -> {
                        //do something
                    }
                    TASK_BLOCK_2 -> {
                        //do something
                    }
                    TASK_BLOCK_3 -> {
                        //do something
                    }
                }
                Log.e("TaskStartUpManager", "task $taskName, $isAsync,finished")
            }
        }
    }
}