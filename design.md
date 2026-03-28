Lấy toàn bộ danh sách công việc, người dùng.
GET /users
GET /tasks


Tạo mới công việc, tạo mới người dùng.
POST /users
{
  "name": "Luck";
  "role": "Admin"
}

POST /tasks
{
  "title": "Do homework",
  "priority": "high",
  "userId": 1
}


Cập nhật trạng thái một công việc, cập nhật vai trò của người dùng.
PATCH /tasks/{id}
{
"status": "done"
}

PATCH /users/{id}
{
"role": "manager"
}


Xóa một công việc, xóa một người dùng khỏi hệ thống.
DELETE /users/{id}
DELETE /users/{id}


Tìm các công việc có mức độ ưu tiên là "high".
GET /tasks?priority=high


Tìm các công việc có độ ưu tiên là "high" và được giao cho người dùng với id là 1.
GET /tasks?priority=high&userId=1


Liệt kê toàn bộ công việc của 1 người dùng.
GET /users/{id}/task


Gắn công việc cho người dùng.
PATCH /tasks/{id}
{
"userId": 1
}