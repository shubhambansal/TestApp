package bansal.test.mobile.data.room.reviews

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single
import java.sql.SQLException

@Dao
abstract class ReviewDao{

    @Query("SELECT * FROM reviews")
    abstract fun getOnce(): Single<List<ReviewsDataModel>>

    @Query("SELECT * FROM reviews WHERE review_id = :id")
    abstract fun getOnce(id: Long): Single<ReviewsDataModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Throws(SQLException::class)
    abstract  fun put(value: ReviewsDataModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Throws(SQLException::class)
    abstract  fun put(values: List<ReviewsDataModel>)

    @Query("DELETE FROM reviews WHERE review_id = :id")
    @Throws(SQLException::class)
    abstract  fun delete(id: Long)
}