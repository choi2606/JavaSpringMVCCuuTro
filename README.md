# CuuTroSpringMVC - Hướng dẫn cài đặt trên Railway
## Yêu cầu
- Tài khoản [Railway](https://railway.app/) (đăng ký miễn phí).
- Tài khoản [GitHub](https://github.com/) để push code và kết nối với Railway.
- Kiến thức cơ bản về Git và terminal/command line.
- Java 17 (vì sử dụng Spring Boot) và Maven/Gradle (tùy project).
- MySQL (sẽ được tạo trên Railway).

## Các bước cài đặt (Nếu chỉ muốn đưa project lên Railway thì bỏ qua bước 1,2,3)

### 1. Chuẩn bị mã nguồn
- Clone repository này:
  ```bash
  git clone https://github.com/[username]/[repo-name].git
  cd [repo-name]
  ```
- Đảm bảo bạn đã cài đặt Java 17 và Maven/Gradle. Kiểm tra bằng:
  ```bash
  java -version
  mvn -version  # hoặc gradle -version
  ```

### 2. Cấu hình file `application.yaml`
- Mở file `src/main/resources/application.yaml` và đảm bảo cấu hình MySQL sử dụng biến môi trường của Railway:
  ```yaml
  server:
    port: "${PORT:8080}"
    servlet:
      context-path: /cuu-tro

  spring:
    application:
      name: [tên-project]
    datasource:
      url: "jdbc:mysql://${MYSQL_HOST}:${MYSQL_PORT}/${MYSQL_DATABASE}"
      username: "${MYSQL_USER}"
      password: "${MYSQL_PASSWORD}"
      driver-class-name: com.mysql.cj.jdbc.Driver
    jpa:
      database-platform: org.hibernate.dialect.MySQL8Dialect
      hibernate:
        ddl-auto: update
      show-sql: true
  ```
- Lưu ý: Các biến `${MYSQL_HOST}`, `${MYSQL_PORT}`, v.v. sẽ được Railway cung cấp khi bạn tạo database.

### 3. Đẩy mã nguồn lên GitHub
- Nếu chưa push, thực hiện:
  ```bash
  git add .
  git commit -m "Initial commit with Railway setup"
  git push origin main
  ```
- Đảm bảo repository là public hoặc private (nếu bạn có quyền truy cập Railway cho private repo).

### 4. Triển khai trên Railway
1. **Tạo dự án trên Railway**:
   - Đăng nhập [Railway](https://railway.app/), nhấp **New Project** > **Empty Project**.
2. **Kết nối GitHub**:
   - Chọn **GitHub** trong giao diện Railway, cấp quyền truy cập, và chọn repository của bạn.
3. **Cấu hình dịch vụ**:
   - Railway sẽ tự động phát hiện Spring Boot (qua `pom.xml` hoặc `build.gradle`).
   - Nhấp **Deploy**.
4. **Thêm database MySQL**:
   - Trong dự án Railway, nhấp **New** > **Database** > **MySQL**.
   - Lấy thông tin kết nối (host, port, database, user, password) từ tab **Variables** của MySQL service.
5. **Cập nhật biến môi trường**:
   - Trong tab **Variables** của dịch vụ Spring Boot, thêm:
     ```
     MYSQL_HOST=<giá trị từ MySQL service>
     MYSQL_PORT=<thường là 3306>
     MYSQL_DATABASE=<tên database>
     MYSQL_USER=<tên user>
     MYSQL_PASSWORD=<mật khẩu>
     PORT=8080
     ```
   - Lưu và redeploy bằng cách push code hoặc nhấp **Redeploy**.
6. **Kiểm tra**:
   - Sau khi triển khai, Railway cung cấp domain công khai (e.g., `https://your-project.up.railway.app`).
   - Truy cập `https://your-project.up.railway.app/cuu-tro` để kiểm tra ứng dụng.

### 5. Khắc phục sự cố
- Nếu gặp lỗi kết nối MySQL (e.g., "Communications link failure"):
  - Kiểm tra lại biến môi trường trong tab **Variables**.
  - Đảm bảo MySQL service đang chạy (xem tab **Logs**).
- Xem log chi tiết: Vào tab **Logs** của dịch vụ để debug.

### 6. Tài liệu tham khảo
- [Railway Docs](https://docs.railway.app)
- [Spring Boot with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
- Hỗ trợ: Đặt câu hỏi trên [Railway Community](https://community.railway.app/).

## Góp ý và đóng góp
- Fork repository và gửi pull request nếu bạn muốn cải thiện project.
- Báo cáo lỗi qua [Issues](https://github.com/[username]/[repo-name]/issues).

Cảm ơn bạn đã sử dụng project này! Chúc bạn thành công khi triển khai trên Railway!
