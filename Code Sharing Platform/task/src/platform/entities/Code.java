package platform.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "snippets")
@JsonIgnoreProperties(value = {"id","originalTime", "viewsRestrict", "timeRestrict"})
public class Code {

    @Id
    @Column
    private String id;

    @Column(name = "code")
    private String code;

    @Column
    private String date;

    @Column(name = "views")
    private Long views;

    @Column(name = "time")
    private Long time;

    @Column
    private boolean viewsRestrict;

    @Column
    private boolean timeRestrict;

    @Column
    private Long originalTime;



    public Code(){
    }

    public Code(String id, String date, String code, Long views, Long time){
        this.id = id;
        this.date = date;
        this.code = code;
        this.views = views;
        this.time = time;
        this.originalTime = time;
        if(views > 0){
            this.viewsRestrict = true;
        }
        if(time > 0){
            this.timeRestrict = true;
        }
    }
    public String getDate(){
        return date;
    }

    public void setDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.date = LocalDateTime.now().format(formatter);
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public Long getViews(){
        return views;
    }

    public void setViews(Long views){
        this.views = views;
    }

    public Long getOriginalTime(){
        return originalTime;
    }
    public void setOriginalTime(){
        this.originalTime = time;
    }

    public Long getTime(){
        return time;
    }

    public void setTime(Long time){
        this.time = time;
    }

    public boolean isTimeRestrict() {
        return timeRestrict;
    }

    public void setTimeRestrict(){
        if(time > 0){
            this.timeRestrict = true;
        }
        else{
            this.timeRestrict = false;
        }
    }

    public boolean isViewsRestrict() {
        return viewsRestrict;
    }

    public void setViewsRestrict() {
        if(views > 0){
            this.viewsRestrict = true;
        }
        else{
            this.viewsRestrict = false;
        }
    }
}
