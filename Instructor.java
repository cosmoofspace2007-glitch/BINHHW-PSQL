package com.example.product_management.Baiss3;
//Thiết kế 3 lớp model:
//Instructor       (id, name, email)
//Course          (id, title, status, instructorId)
//Enrollment     (id, studentName, courseId)
//Khởi tạo dự án với kiến trúc đa tầng:
//Dự án cần phải có các tầng cơ bản model, controller, service, repository
//Sử dụng các annotation @Controller, @Service, @Repository để khởi tạo bean.
//Sử dụng @Autowired trên Constructor Inject (không Field Inject)
//Chuẩn bị dữ liệu:
//Ở tầng repo, chuẩn bị dữ liệu cho từng model.
//Mỗi model ít nhất 2 bản ghi.

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Instructor
{
    private int id;
    private String instructorName;
    private String instructorEmail;
}
