package bansal.test.mobile.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import bansal.test.mobile.data.room.reviews.ReviewDao
import bansal.test.mobile.data.room.reviews.ReviewsDataModel

const val DB_NAME = "proto.db"
private const val CURRENT_VERSION = 1

@Database(entities = [ReviewsDataModel::class], version = CURRENT_VERSION)
abstract class ProtoAppDatabase : RoomDatabase(){

    abstract fun reviewDao() : ReviewDao
}