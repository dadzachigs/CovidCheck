package co.zw.engineer.covidscreening.information.vaccine;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "vaccineFqa2")

public class VaccineQsns {
    @PrimaryKey(autoGenerate = true)
    private int question_id;

    @ColumnInfo(name="title")
    private String title;

    @ColumnInfo(name="content")
    private String content;



//    @Embedded(prefix = "mylist_array") private ArrayList<MyListItems> myListItems;




    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id= question_id;
    }

    public String getTitle() {
        return title;
    }



    public String getContent() {
        return content;
    }
}
