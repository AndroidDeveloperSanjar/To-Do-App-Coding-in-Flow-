package uz.androbeck.todoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import uz.androbeck.todoapp.di.ApplicationScope
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    class Callback @Inject constructor(
        private val database: Provider<TaskDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().taskDao()

            applicationScope.launch {
                dao.insert(Task("Bir iki "))
                dao.insert(Task("Howmework", completed = true))
                dao.insert(Task("Aayvoooo", important = true))
                dao.insert(Task("Buxara"))
                dao.insert(Task("Grant", completed = true))
                dao.insert(Task("Universitet"))
                dao.insert(Task("Nima bu"))
            }
        }
    }
}