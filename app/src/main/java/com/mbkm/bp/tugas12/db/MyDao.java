package com.mbkm.bp.tugas12.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.mbkm.bp.tugas12.FavouriteDetailActivity;
import com.mbkm.bp.tugas12.fragm.favourite.List_Favourite;

import java.util.List;

@Dao
public interface MyDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void addFavourite(User user);

    @Query("select * from favourite order by title asc")
    public List<User> getFavourite();

    @Query("select * from favourite where id=:id")
    List_Favourite getMovieDetail(String id);

    @Delete
    public void deleteFavourite(User user);

    @Update
    public void updateFavourite(User user);
}
