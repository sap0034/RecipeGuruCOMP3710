package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Measurement;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MeasurementDao {

    @Query("SELECT * FROM Measurement")
    List<Measurement> getAll();

    @Query("SELECT * FROM Measurement where MeasurementName LIKE :MeasurementName")
    Measurement findMeasurementByName(String MeasurementName);

    @Query("SELECT COUNT(*) FROM Measurement")
    int countMeasurements();

    @Insert(onConflict = REPLACE)
    void addMeasurement(Measurement measurement);

    @Insert
    void insertAll(Measurement... measurements);

    @Delete
    void delete(Measurement measurement);
}
