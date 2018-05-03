package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Measurement")
public class Measurement {

    @PrimaryKey(autoGenerate = true)
    private int MeasurementID;

    @ColumnInfo(name = "MeasurementName")
    private String MeasurementName;

    public void setMeasurementID(int MeasurementID) {this.MeasurementID = MeasurementID;}
    public int getMeasurementID() {return this.MeasurementID;}

    public void setMeasurementName(String MeasurementName) {this.MeasurementName = MeasurementName;}
    public String getMeasurementName() {return this.MeasurementName;}
}
