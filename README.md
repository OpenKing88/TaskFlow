# TaskFlow
任务管理工具，用于管理应用启动时初始化的任务执行顺序，可设置异步任务，可插队，可分组。提高应用初始化效率！

/********搬砖学习整理项目，请理解项目精髓*******/

通过工具将初始化任务集中管理，异步管理可异步初始化的任务，减少主线程初始化耗时

具体使用参考app模块中的TaskStartUpManager类




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
         * 添加任务到任务组，并通过TaskCreator来创建Task，包括异步任务和同步任务，对任务作依赖管理
         */
        val project = Project.Builder("TaskStartUpManager", createTaskCreator())
            .add(TASK_BLOCK_1)
            .add(TASK_BLOCK_2)
            .add(TASK_BLOCK_3)
            .add(TASK_ASYNC_1).dependOn(TASK_BLOCK_1)//异步任务TASK_ASYNC_1依赖于TASK_BLOCK_1执行
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
                    TASK_ASYNC_1 -> return createTask(taskName, true)//true：代表异步任务
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
		//在这里根据任务作对应的初始化操作
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

