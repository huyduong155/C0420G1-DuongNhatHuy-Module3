<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <!-- CSS only -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.js" ></script>
    <!-- JS tạo nút bấm di chuyển trang start -->
    <script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
    <!-- JS, Popper.js, and jQuery -->
    <%--    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <style>
        .menu ul li{
            margin-right: 10%;
        }
    </style>
    <script>
        $(document).ready(function(){
            // Activate tooltips
            $('[data-toggle="tooltip"]').tooltip();

            // Filter table rows based on searched term
            $("#search").on("keyup", function() {
                var term = $(this).val().toLowerCase();
                $("table tbody tr").each(function(){
                    $row = $(this);
                    var name = $row.find("td:nth-child(2)").text().toLowerCase();
                    console.log(name);
                    if(name.search(term) < 0){
                        $row.hide();
                    } else{
                        $row.show();
                    }
                });
            });
        });

    </script>
    <script type="text/javascript">
        $(function () {
            var pageSize = 5; // Hiển thị 6 sản phẩm trên 1 trang
            showPage = function (page) {
                $(".contentPage").hide();
                $(".contentPage").each(function (n) {
                    if (n >= pageSize * (page - 1) && n < pageSize * page)
                        $(this).show();
                });
            }
            showPage(1);
            ///** Cần truyền giá trị vào đây **///
            var totalRows = 40; // Tổng số sản phẩm hiển thị
            var btnPage = 3; // Số nút bấm hiển thị di chuyển trang
            var iTotalPages = Math.ceil(totalRows / pageSize);
            var obj = $('#pagination').twbsPagination({
                totalPages: iTotalPages,
                visiblePages: btnPage,
                onPageClick: function (event, page) {
                    console.info(page);
                    showPage(page);
                }
            });
            console.info(obj.data());
        });
    </script>
    <style>
        body {
            color: #566787;
            background: #f7f5f2;
            font-family: 'Roboto', sans-serif;
        }
        .table-responsive {
            margin: 30px 0;
        }
        .table-wrapper {
            min-width: 1000px;
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            box-shadow: 0 1px 1px rgba(0,0,0,.05);
        }
        .table-title {
            color: #fff;
            background: #40b2cd;
            padding: 16px 25px;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }
        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }
        .search-box {
            position: relative;
            float: right;
        }
        .search-box .input-group {
            min-width: 300px;
            position: absolute;
            right: 0;
        }
        .search-box .input-group-addon, .search-box input {
            border-color: #ddd;
            border-radius: 0;
        }
        .search-box input {
            height: 34px;
            padding-right: 35px;
            background: #f4fcfd;
            border: none;
            border-radius: 2px !important;
        }
        .search-box input:focus {
            background: #fff;
        }
        .search-box input::placeholder {
            font-style: italic;
        }
        .search-box .input-group-addon {
            min-width: 35px;
            border: none;
            background: transparent;
            position: absolute;
            right: 0;
            z-index: 9;
            padding: 6px 0;
        }
        .search-box i {
            color: #a0a5b1;
            font-size: 19px;
            position: relative;
            top: 2px;
        }
        table.table {
            table-layout: fixed;
            margin-top: 15px;
        }
        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
        }
        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }
        table.table th:first-child {
            width: 60px;
        }
        table.table th:last-child {
            width: 120px;
        }
        table.table td a {
            color: #a0a5b1;
            display: inline-block;
            margin: 0 5px;
        }
        table.table td a.view {
            color: #03A9F4;
        }
        table.table td a.edit {
            color: #FFC107;
        }
        table.table td a.delete {
            color: #E34724;
        }
        table.table td i {
            font-size: 19px;
        }
        #pagination {
            display: flex;

            flex-wrap: wrap;

            justify-content: center;
            -webkit-justify-content: center;
        }
    </style>
</head>
<body style="background-image: url('https://cdn.lifestyleasia.com/wp-content/uploads/2018/09/11142931/The-Nautilus-Maldives-Beach-Residence-exterior-1.jpg')">
<div class="header">
    <div class="container-fluid">
        <div class="row" >
            <div class="col-3">
                <img style="width: 30%;padding: 15px" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQlTaPPCcmHWMt6vGZ5QyfBTCSLcbmOys20dg&usqp=CAU">
            </div>
            <div class="col-3"></div>
            <div class="col-3"></div>
            <div class="col-3" style="display: flex;align-items: center">
                <h3 style="color: white">Dương Nhật Huy</h3>
            </div>
        </div>
    </div>
</div>
<!--end header-->

<div class="menu" style="background-color: #2d3338;height: 50px">
    <div class="container">
        <div class="row">
            <div class="col-12" >
                <ul style="list-style: none;display:flex;flex-direction: row;padding-top: 12px">
                    <li><a href="/HomeServlet">Home</a></li>
                    <li><a href="/NhanVienServlet">Employee</a></li>
                    <li><a href="/KhachHangServlet">Customer</a></li>
                    <li>  <a href="">Service</a></li>
                    <li><a href="">Contract</a></li>
                    <li class="input-group" style="margin: -6px">
                        <input type="text" id="search" class="form-control" placeholder="Search by Name">
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!--end menu-->
<br><br>
<div>
    <div class="content" style="height: 71vh">
        <div class="container-fluid">
            <div class="row" >
                <div class="col-2" style="display: flex;flex-direction: column;margin-top: 70px" >
                    <a href="#addCusModal" class="btn btn-primary" data-toggle="modal" style="margin: 3px"><i class="fa fa-plus"></i> <span>Add New Customer</span></a>
                    <a href="#addEmpModal" class="btn btn-primary" data-toggle="modal" style="margin: 3px"><i class="fa fa-plus"></i> <span>Add New Employee</span></a>
                    <a href="#addSerModal" class="btn btn-primary" data-toggle="modal" style="margin: 3px"><i class="fa fa-plus"></i> <span>Add New Service</span></a>
                    <a href="#addCusModal" class="btn btn-primary" data-toggle="modal" style="margin: 3px"><i class="fa fa-plus"></i> <span>Add New Contract</span></a>
                    <a href="#addCusModal" class="btn btn-primary" data-toggle="modal" style="margin: 3px"><i class="fa fa-plus"></i> <span>Add New Contract Detail</span></a>
                </div>
                <div class="col-10" style="margin-top: 28px">

                </div>
            </div>
        </div>
    </div>
    <!--end content-->
    <div class="footer" >
        <div class="container-fluid">
            <div class="row" >
                <h3><i class="icon-placeholder"></i></h3>
            </div>
        </div>
    </div>
</div>

<!-- add new customer -->
<div id="addCusModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/KhachHangServlet?action=create" method="post">
                <div class="modal-header" style="background: #2d3338">
                    <h4 class="modal-title" style="color: #e9e9e9">Add New Customer</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name :</label>
                        <input type="text" class="form-control" name="Name" id="Name">
                    </div>
                    <div class="form-group">
                        <label>Date of birth : </label>
                        <input type="text" class="form-control" name="dateOfBirth" id="dateOfBirth">
                    </div>
                    <div class="form-group">
                        <label>CMND : </label>
                        <input type="text" class="form-control" name="CMND" id="CMND">
                    </div>
                    <div class="form-group">
                        <label>Phone : </label>
                        <input type="text" class="form-control" name="SDT" id="SDT">
                    </div>
                    <div class="form-group">
                        <label>Email : </label>
                        <input type="text" class="form-control" name="Email" id="Email">
                    </div>
                    <div class="form-group">
                        <label>Address : </label>
                        <input type="text" class="form-control" name="Address" id="Address">
                    </div>
                    <div class="form-group">
                        <label>Customer Type :</label>
                        <select name="CusTypeId" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <c:forEach var="CusType" items="${listCusType}">
                                <option value="${CusType.id_loai_khach}"><c:out value="${CusType.ten_loai_khach}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-primary" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- add new employee -->
<div id="addEmpModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/NhanVienServlet?action=create" method="post">
                <div class="modal-header" style="background: #2d3338">
                    <h4 class="modal-title" style="color: #e9e9e9">Add New Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name :</label>
                        <input type="text" class="form-control" name="Name" >
                    </div>
                    <div class="form-group">
                        <label>Date of birth : </label>
                        <input type="text" class="form-control" name="dateOfBirth" >
                    </div>
                    <div class="form-group">
                        <label>ID Card : </label>
                        <input type="text" class="form-control" name="CMND" >
                    </div>
                    <div class="form-group">
                        <label>Salary : </label>
                        <input type="text" class="form-control" name="Salary" >
                    </div>
                    <div class="form-group">
                        <label>Phone : </label>
                        <input type="text" class="form-control" name="SDT" >
                    </div>
                    <div class="form-group">
                        <label>Email : </label>
                        <input type="text" class="form-control" name="Email" >
                    </div>
                    <div class="form-group">
                        <label>Address : </label>
                        <input type="text" class="form-control" name="Address" >
                    </div>
                    <div class="form-group">
                        <label>Position :</label>
                        <select name="PositionId" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <c:forEach var="position" items="${listPosition}">
                                <option value="${position.id_vi_tri}"><c:out value="${position.ten_vi_tri}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Education :</label>
                        <select name="EducationId" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <c:forEach var="education" items="${listEducation}">
                                <option value="${education.id_trinh_do}"><c:out value="${education.trinh_do}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Division :</label>
                        <select name="DivisionId" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <c:forEach var="division" items="${listDivision}">
                                <option value="${division.id_bo_phan}"><c:out value="${division.ten_bo_phan}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-primary" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>

<%--add new service--%>
<div id="addSerModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/HomeServlet?action=create" method="post">
                <div class="modal-header" style="background: #2d3338">
                    <h4 class="modal-title" style="color: #e9e9e9">Add New Service</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name service:</label>
                        <input type="text" class="form-control" name="Name" >
                    </div>
                    <div class="form-group">
                        <label>Area : </label>
                        <input type="text" class="form-control" name="area" >
                    </div>
                    <div class="form-group">
                        <label>Number of floors : </label>
                        <input type="text" class="form-control" name="floor" >
                    </div>
                    <div class="form-group">
                        <label> Max People : </label>
                        <input type="text" class="form-control" name="people" >
                    </div>
                    <div class="form-group">
                        <label>Cost : </label>
                        <input type="text" class="form-control" name="cost" >
                    </div>
                    <div class="form-group">
                        <label> Status : </label>
                        <input type="text" class="form-control" name="status" >
                    </div>
                    <div class="form-group">
                        <label>Rent Type :</label>
                        <select name="RentTypeId" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <c:forEach var="rentType" items="${listRentType}">
                                <option value="${rentType.id_kieu_thue}"><c:out value="${rentType.ten_kieu_thue}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Service Type :</label>
                        <select name="SerTypeId" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <c:forEach var="serType" items="${listSerType}">
                                <option value="${serType.id_loai_dich_vu}"><c:out value="${serType.ten_loai_dich_vu}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-primary" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
