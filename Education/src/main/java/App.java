import com.google.gson.Gson;
import exceptions.ApiException;
import dao.Sql2oCourseDao;
import dao.Sql2oUnitDao;
import dao.Sql2oUploadDao;
import dao.Sql2oContentDao;
import dao.Sql2oNoteDao;
import dao.Sql2oTeacherDao;
import dao.Sql2oUniversityDao;
import dao.Sql2oEducationlevelDao;
import dao.Sql2oGenderDao;
import dao.Sql2oLectureDao;
import dao.Sql2oEnrolmentDao;
import dao.Sql2oStudentDao;
import models.Note;
import models.Upload;
import models.Teacher;
import models.Gender;
import models.Educationlevel;
import models.Content;
import models.Course;
import models.Unit;
import models.University;
import models.Review;
import models.Lecture;
import models.Enrolment;
import models.Student;
import models.dao.Sql2oReviewDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;
import com.google.gson.Gson;
import spark.Filter;
import spark.Request;
import spark.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class App {
  private static String requestInfo(Request request){
    StringBuilder sb = new StringBuilder();
    sb.append(request.requestMethod());
    sb.append("\n"+request.requestMethod());
    sb.append("\n"+request.url());
    sb.append("\n body:"+request.body());
    return sb.toString();
  }
public static void main(String[] args) {
  before((request,response) -> {
    System.out.println(requestInfo(request));
  });
  after((Filter) (request, response) -> {
    response.header("Access-Control-Allow-Origin", "*");
    response.header("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
    response.header("Access-Control-Allow-Credentials", "true");
    response.header("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

  });


  Sql2oCourseDao courseDao;
   Sql2oContentDao contentDao;
   Sql2oNoteDao noteDao;
   Sql2oTeacherDao teacherDao;
   Sql2oReviewDao reviewDao;
   Sql2oEducationlevelDao educationlevelDao;
   Sql2oGenderDao genderDao;
   Sql2oUniversityDao universityDao;
   Sql2oLectureDao lectureDao;
    Sql2oEnrolmentDao enrolmentDao;
   Sql2oUploadDao uploadDao;
   Sql2oUnitDao unitDao;
   Sql2oStudentDao studentDao;
   Connection conn;
   Gson gson = new Gson();

   String connectionString = "jdbc:postgresql://localhost:5432/education"; //connect to jadle, not jadle_test!
Sql2o sql2o = new Sql2o(connectionString, null, "melvin");  //Ubuntu Sql2o sql2o = new Sql2o(connectionString, "user", "1234");

   courseDao = new Sql2oCourseDao(sql2o);
   reviewDao = new Sql2oReviewDao(sql2o);
   contentDao = new Sql2oContentDao(sql2o);
   noteDao = new Sql2oNoteDao(sql2o);
   teacherDao = new Sql2oTeacherDao(sql2o);
   universityDao = new Sql2oUniversityDao(sql2o);
   genderDao = new Sql2oGenderDao(sql2o);
   educationlevelDao = new Sql2oEducationlevelDao(sql2o);
   lectureDao = new Sql2oLectureDao(sql2o);
   uploadDao = new Sql2oUploadDao(sql2o);
   enrolmentDao = new Sql2oEnrolmentDao(sql2o);
   studentDao = new Sql2oStudentDao(sql2o);
   unitDao = new Sql2oUnitDao(sql2o);
   conn = sql2o.open();


   post("/teachers/new", "application/json", (req, res) -> {
    System.out.println(req.body());
     Teacher teacher = gson.fromJson(req.body(), Teacher.class);
       JSONObject response = teacherDao.add(teacher);
       res.status(200);

       return gson.toJson(response);
   });

   post("/teachers/login", "application/json", (req, res) -> {
    System.out.println(req.body());
     Map map = gson.fromJson(req.body(), Map.class);
     map.get("email");
     map.get("password");
     String response = teacherDao.login("email", "password");
     res.status(200);
     return gson.toJson(response);
   });

   get("/teachers", "application/json", (req, res) -> { //accept a request in format JSON from an app
     return gson.toJson(teacherDao.getAll());//send it back to be displayed
   });

   get("/teachers/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
     int teacherId = Integer.parseInt(req.params(":id"));
     return gson.toJson(teacherDao.findById(teacherId));
   });

   post("/students/new", "application/json", (req, res) -> {
    System.out.println(req.body());
     Student student = gson.fromJson(req.body(), Student.class);
       JSONObject response = studentDao.add(student);
       res.status(200);

       return gson.toJson(response);
   });
  

   get("/students", "application/json", (req, res) -> { //accept a request in format JSON from an app
     return gson.toJson(studentDao.getAll());//send it back to be displayed
   });

   get("/students/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
     int studentId = Integer.parseInt(req.params(":id"));
     return gson.toJson(studentDao.findById(studentId));
   });

   post("/notes/new", "application/json", (req, res) -> {
     Note note = gson.fromJson(req.body(), Note.class);
       noteDao.add(note);
       res.status(201);
       return gson.toJson(note);
   });

   get("/notes/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
     int noteId = Integer.parseInt(req.params("id"));
     return gson.toJson(noteDao.findById(noteId));
   });

   get("/notess/:teacherid", "application/json", (req, res) -> { //accept a request in format JSON from an app
     int teacherId = Integer.parseInt(req.params("teacherid"));
     return gson.toJson(noteDao.getAllNotesByTeacher(teacherId));
   });

   get("/notes/:courseid", "application/json", (req, res) -> { //accept a request in format JSON from an app
     int courseId = Integer.parseInt(req.params("courseid"));
     return gson.toJson(noteDao.getAllNotesByCourse(courseId));
   });

   get("/notes", "application/json", (req, res) -> { //accept a request in format JSON from an app
     String noteHeading = req.queryParams("search");
     System.out.println(noteHeading);
     if(noteHeading != null && !noteHeading.isEmpty()){
       return gson.toJson(noteDao.getAllNotesByHeading(noteHeading));
     }
     else{
       return gson.toJson(noteDao.getAll());
     }
   });
   get("/notesteacher", "application/json", (req, res) -> { //accept a request in format JSON from an app
     String noteHeading = req.queryParams("search");
     int universityid = Integer.parseInt(req.params("universityid"));
     System.out.println(noteHeading);
     if(noteHeading != null && !noteHeading.isEmpty()){
       return gson.toJson(noteDao.getAllNotesByHeadingAndUniversityId(noteHeading, universityid));
     }
     else{
       return gson.toJson("no element found");
     }
   });

   post("/notes/:noteid/reviews/new", "application/json", (req, res) -> {
     int noteid = Integer.parseInt(req.params("noteid"));
     Review review = gson.fromJson(req.body(), Review.class);

     review.setNoteId(noteid); //we need to set this separately because it comes from our route, not our JSON input.
     reviewDao.add(review);
     res.status(201);
     return gson.toJson(review);
   });

   get("/notestopthree", "application/json", (req, res) -> { //accept a request in format JSON from an app
     return gson.toJson(noteDao.getFirstThreeNotes());//send it back to be displayed
   });

   get("/notes/:id", "application/json", (req, res) -> {
     int noteid = Integer.parseInt(req.params("id"));
     Note noteToFind = noteDao.findById(noteid);
     if (noteToFind == null){
       throw new ApiException(404, String.format("No note with the id: \"%s\" exists", req.params("id")));
     }
     return gson.toJson(noteToFind);
   });

   post("/notes/:noteid/reviews/new", "application/json", (req, res) -> {
    int noteid = Integer.parseInt(req.params("noteid"));
    Review review = gson.fromJson(req.body(), Review.class);
    review.setCreatedat(); //I am new!
    review.setFormattedCreatedAt();
    review.setNoteId(noteid);
    reviewDao.add(review);
    res.status(201);
    return gson.toJson(review);
  });

  get("/notes/:id/sortedReviews", "application/json", (req, res) -> { //// TODO: 1/18/18 generalize this route so that it can be used to return either sorted reviews or unsorted ones.
    int noteid = Integer.parseInt(req.params("id"));
    Note noteToFind = noteDao.findById(noteid);
    List<Review> allReviews;
    if (noteToFind == null){
        throw new ApiException(404, String.format("No restaurant with the id: \"%s\" exists", req.params("id")));
    }
    allReviews = reviewDao.getAllReviewsByNoteSortedNewestToOldest(noteid);
    return gson.toJson(allReviews);
  });

  get("/notesall", "application/json", (req, res) -> { //accept a request in format JSON from an app
    return gson.toJson(noteDao.getAll());//send it back to be displayed
  });

  post("/lectures/new", "application/json", (req, res) -> {
    Lecture lecture = gson.fromJson(req.body(), Lecture.class);
      lectureDao.add(lecture);
      res.status(201);
      return gson.toJson(lecture);
  });

  get("/lectures", "application/json", (req, res) -> { //accept a request in format JSON from an app
    return gson.toJson(lectureDao.getAll());//send it back to be displayed
  });

  get("/lectures/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
    int lectureId = Integer.parseInt(req.params("id"));
    return gson.toJson(lectureDao.findById(lectureId));
  });

  get("notes/lectures/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
    int noteid = Integer.parseInt(req.params("id"));
    return gson.toJson(lectureDao.getLectureByNoteId(noteid));
  });

  post("/contents/new", "application/json", (req, res) -> {
    Content content = gson.fromJson(req.body(), Content.class);
      contentDao.add(content);
      res.status(201);
      return gson.toJson(content);
  });

  get("/contents", "application/json", (req, res) -> { //accept a request in format JSON from an app
    return gson.toJson(contentDao.getAll());//send it back to be displayed
  });

  get("/contents/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
    int contentId = Integer.parseInt(req.params("id"));
    return gson.toJson(contentDao.findById(contentId));
  });

  post("/courses/new", "application/json", (req, res) -> {
    Course course = gson.fromJson(req.body(), Course.class);
      courseDao.add(course);
      res.status(201);
      return gson.toJson(course);
  });

  get("/courses", "application/json", (req, res) -> { //accept a request in format JSON from an app
    return gson.toJson(courseDao.getAll());//send it back to be displayed
  });

  get("/courses/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
    int courseId = Integer.parseInt(req.params("id"));
    return gson.toJson(courseDao.findById(courseId));
  });

  post("/units/new", "application/json", (req, res) -> {
    Unit unit = gson.fromJson(req.body(), Unit.class);
      unitDao.add(unit);
      res.status(201);
      return gson.toJson(unit);
  });

  get("/units", "application/json", (req, res) -> { //accept a request in format JSON from an app
    return gson.toJson(unitDao.getAll());//send it back to be displayed
  });

  get("/units/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
    int unitId = Integer.parseInt(req.params("id"));
    return gson.toJson(unitDao.findById(unitId));
  });

  post("/universities/new", "application/json", (req, res) -> {
    University university = gson.fromJson(req.body(), University.class);
      universityDao.add(university);
      res.status(201);
      return gson.toJson(university);
  });

  get("/universities", "application/json", (req, res) -> { //accept a request in format JSON from an app
    return gson.toJson(universityDao.getAll());//send it back to be displayed
  });

  get("/universities/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
    int universityId = Integer.parseInt(req.params("id"));
    return gson.toJson(universityDao.findById(universityId));
  });

  post("/educationlevels/new", "application/json", (req, res) -> {
    Educationlevel educationlevel = gson.fromJson(req.body(), Educationlevel.class);
      educationlevelDao.add(educationlevel);
      res.status(201);
      return gson.toJson(educationlevel);
  });

  get("/educationlevels", "application/json", (req, res) -> { //accept a request in format JSON from an app
    return gson.toJson(educationlevelDao.getAll());//send it back to be displayed
  });

  get("/educationlevels/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
    int educationlevelId = Integer.parseInt(req.params("id"));
    return gson.toJson(educationlevelDao.findById(educationlevelId));
  });

  post("/genders/new", "application/json", (req, res) -> {
    Gender gender = gson.fromJson(req.body(), Gender.class);
      genderDao.add(gender);
      res.status(201);
      return gson.toJson(gender);
  });

  get("/genders", "application/json", (req, res) -> { //accept a request in format JSON from an app
    return gson.toJson(genderDao.getAll());//send it back to be displayed
  });

  get("/genders/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
    int genderId = Integer.parseInt(req.params("id"));
    return gson.toJson(genderDao.findById(genderId));
  });

  post("/uploads/new", "application/json", (req, res) -> {
    Upload upload = gson.fromJson(req.body(), Upload.class);
      uploadDao.add(upload);
      res.status(201);
      return gson.toJson(upload);
  });

  get("/uploads", "application/json", (req, res) -> { //accept a request in format JSON from an app
    return gson.toJson(uploadDao.getAll());//send it back to be displayed
  });

  get("/uploads/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
    int uploadId = Integer.parseInt(req.params("id"));
    return gson.toJson(uploadDao.findById(uploadId));
  });

  post("/enrolments/new", "application/json", (req, res) -> {
    Enrolment enrolment = gson.fromJson(req.body(), Enrolment.class);
      enrolmentDao.add(enrolment);
      res.status(201);
      return gson.toJson(enrolment);
  });

  get("/enrolments", "application/json", (req, res) -> { //accept a request in format JSON from an app
    return gson.toJson(enrolmentDao.getAll());//send it back to be displayed
  });

  get("/enrolments/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
    int enrolmentId = Integer.parseInt(req.params("id"));
    return gson.toJson(enrolmentDao.findById(enrolmentId));
  });

   exception(ApiException.class, (exc, req, res) -> {
     ApiException err = (ApiException) exc;
     Map<String, Object> jsonMap = new HashMap<>();
     jsonMap.put("status", err.getStatusCode());
     jsonMap.put("errorMessage", err.getMessage());
     res.type("application/json"); //after does not run in case of an exception.
     res.status(err.getStatusCode()); //set the status
     res.body(gson.toJson(jsonMap));  //set the output.
   });

   after((req, res) ->{
     res.type("application/json");
   });
  }
}
