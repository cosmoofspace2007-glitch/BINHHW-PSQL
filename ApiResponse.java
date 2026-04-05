package Baiss4;

public class ApiResponse<T> {
    private String message;
    private T data;

    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public ApiResponse(boolean b, String getCoursesByStatusSuccessfully, PageResponse<CourseResponse> pagedCourses)
    {

    }
}
