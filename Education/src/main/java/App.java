import com.google.gson.Gson;
import dao.Sql2oCourseDao;
import dao.Sql2oContentDao;
import dao.Sql2oNoteDao;
import dao.Sql2oTeacherDao;
import dao.Sql2oUniversityDao;
import models.Note;
import models.Teacher;
import models.Content;
import models.Course;
import models.University;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;

public class App {

public static void main(String[] args) {
   Sql2oCourseDao courseDao;
   Sql2oContentDao contentDao;
   Sql2oNoteDao noteDao;
   Sql2oTeacherDao teacherDao;
   Sql2oUniversityDao universityDao;
   Connection conn;
   Gson gson = new Gson();

   String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
   Sql2o sql2o = new Sql2o(connectionString, "", "");

   courseDao = new Sql2oCourseDao(sql2o);
   contentDao = new Sql2oContentDao(sql2o);
   noteDao = new Sql2oNoteDao(sql2o);
   teacherDao = new Sql2oTeacherDao(sql2o);
   universityDao = new Sql2oUniversityDao(sql2o);
   conn = sql2o.open();


   post("/notes/new", "application/json", (req, res) -> {
     Note note = gson.fromJson(req.body(), Note.class);
       noteDao.add(note);
       res.status(201);
       return gson.toJson(note);
   });

   get("/notes", "application/json", (req, res) -> { //accept a request in format JSON from an app
     return gson.toJson(noteDao.getAll());//send it back to be displayed
   });

   get("/notes/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
     int noteId = Integer.parseInt(req.params("id"));
     return gson.toJson(noteDao.findById(noteId));
   });

   after((req, res) ->{
     res.type("application/json");
   });
  }
}
