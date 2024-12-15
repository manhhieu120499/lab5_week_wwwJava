# LAB WEEK 05: Ứng dụng Web sử dụng Spring Boot tạo mô hình tuyển dụng việc làm
Thông tin sinh viên:
- Họ và tên: Võ Mạnh Hiếu
- Mssv: 21097401
- Lớp: DHKTPM17C
- Môn học: Lập trình WWW - JAVA
- Giảng viên: TS Võ Văn Hải

[Link github here](https://github.com/manhhieu120499/lab5_week_wwwJava.git)

[Link VoManhHieu_Report](https://drive.google.com/drive/folders/1yo8mUSeKXkWub27ThTzjgd_80Z83o6U-?usp=drive_link)
## I. Kết quả đạt được:
### 1. Về chức năng:
- Đăng nhập:
    + Giao diện đăng nhập
      ![Home Page](https://res.cloudinary.com/dwzptn5fj/image/upload/v1734074853/z6126220872019_144dd12fcb7ce10e96a4b3b85b4379d6_u7q8ri.jpg)
    + Đối với Candidate:

        - Account: Name0
  
        - Password: password0
  
        - Giao diện sau khi đăng nhập: 
        ![Home Page For Candidate](https://res.cloudinary.com/dwzptn5fj/image/upload/v1734074853/z6126254738271_d315ae690494b1042ce9d96fbf2566b7_t8vzsq.jpg)
    + Đối với Company:
  
        - Account: Name3

        - Password: password3
  
        - Giao diện sau khi đăng nhập:
        ![Home Page For Company](https://res.cloudinary.com/dwzptn5fj/image/upload/v1734074854/z6126256319660_38726b31615fdb1694aae00e38ee1e27_brjhtq.jpg)
- Company:
    + Bao gồm những chức năng sau: 
        Managed Jobs: 
            
        Giao diện như sau: 
        ![Managed Job](https://res.cloudinary.com/dwzptn5fj/image/upload/v1734075818/z6126323720653_ea4445937d16e588771dee8422eaa8d1_a7ktte.jpg)
        Ở giao diện này công ty có thể thực hiện các chức năng như: Add Job, Edit Job, Delete Job, View Detail Job
        
        a. Add Job
        
       Giao diện: 
        ![Add Job](https://res.cloudinary.com/dwzptn5fj/image/upload/v1734075818/z6126325513833_384c65f02f4a2ab219bdbe57948701ba_aewjdr.jpg)
        b. Edit Job
        ![Edit Job](https://res.cloudinary.com/dwzptn5fj/image/upload/v1734076584/z6126365538330_bb216ac0a503c566d4f42162fef25dc4_qncff3.jpg)
        Công ty có thể cập nhật các skill cho job đã được tạo thông qua chức năng update skill và hoàn thành việc update khi nhấn update job
        ![Update Skill](https://res.cloudinary.com/dwzptn5fj/image/upload/v1734076842/z6126398265661_2904dd9ad0b4e5c145137219aebc9cc0_zj3bvt.jpg)
        c. Delete Job
        Công ty chỉ cần nhấn nút "Delete" trên dòng dữ liệu chứ tên job là sẽ xóa được job đó
        d. View Detail
        Công ty sẽ xem được chi tiết về job đó bao gồm cả skill khi nhấn vào chức năng "Detail" ở cột View Detail
        Giao diện:
        ![View Detail](https://res.cloudinary.com/dwzptn5fj/image/upload/v1734076584/z6126380821692_be0346b61f46f2306880119dde5efd97_tsbhuo.jpg)
        News Job:
  
        Giao diện như sau: 
        ![News Job](https://res.cloudinary.com/dwzptn5fj/image/upload/v1734077530/z6126441929290_ee2e51e958e726188a8a8f75a85b9bf9_cafith.jpg)
        Những thông tin về job của công ty sẽ được hiển thị ở trang này để công ty theo dõi mình đã đăng nhưng job nào
        
        Send Mail

        Giao diện xem Candidate
        ![Candidate-Paging](https://res.cloudinary.com/dwzptn5fj/image/upload/v1734266372/z6133222653886_0818e308e5d0aa4bf5b1b347cd7ce042_jwjm5p.jpg)
        Company có thể chọn Candidate rồi sau đó tiến hành gửi mail thông qua chức năng Send Mail
        
        Giao diện Send Mail
        ![Send Mail](https://res.cloudinary.com/dwzptn5fj/image/upload/v1734266371/z6133222987611_9d179470bc8621bb147d654283b3cb6f_lpxzti.jpg)
        Company có thể nhập nội dung phỏng vấn và gửi đến Candidate
- Candidate:
    + Bao gồm những chức năng sau: 
  
        a. Filter Job
  
        Giao diện chung với Suggest Job: 
        ![Suggest Job](https://res.cloudinary.com/dwzptn5fj/image/upload/v1734078081/z6126477161454_cdb029535a31a7b2abde9f4d00d649c4_sqix0v.jpg)
        Candidate có thể tùy chọn tìm kiếm job theo công ty mà mình muốn, ngoài ra hệ thống sẽ gợi ý job theo skill mà ứng
        viên có
  
        b. Sugest SKill To Learn
  
        Khi Candiate xem chi tiết job thì hệ thống cũng sẽ đưa ra những skill mà Candidate đó còn thiếu để apply vào job
        hiện tại mà Candidate đang xem nếu Candidate chưa đủ skill để đáp ứng
        
        Giao diện: 
        ![Suggest Skill For Candidate](https://res.cloudinary.com/dwzptn5fj/image/upload/v1734078588/z6126508010412_36e5264a93e9c658132a4a7699dfa2b0_x87jic.jpg)
        
            