<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Customer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.2.1.js" ></script>
    <!-- JS tạo nút bấm di chuyển trang start -->
    <script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
    <!--    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>-->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <style>
        .menu ul li{
            margin-right: 10%;
        }

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
<div>
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/KhachHangServlet?action=delete" method="post">
                <div class="modal-header" style="background: #2d3338">
                    <h4 class="modal-title" style="color: #e9e9e9">Delete Customer</h4>
                    <a href="/KhachHangServlet"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button></a>
                </div>
                <div class="modal-body">
                    <table>
                        <tr>
                            <td><input type="hidden" name="id" value="${cusDelete.id_khach_hang}"></td>
                        </tr>
                        <tr>
                            <td>Name : </td>
                            <td>${cusDelete.ho_ten}</td>
                        </tr>
                        <tr>
                            <td>Date of birth : </td>
                            <td>${cusDelete.ngay_sinh}</td>
                        </tr>
                        <tr>
                            <td>CMND : </td>
                            <td>${cusDelete.CMND}</td>
                        </tr>
                        <tr>
                            <td>Phone : </td>
                            <td>${cusDelete.SDT}</td>
                        </tr>
                        <tr>
                            <td>Email : </td>
                            <td>${cusDelete.email}</td>
                        </tr>
                        <tr>
                            <td>Address : </td>
                            <td>${cusDelete.dia_chi}</td>
                        </tr>
                        <tr>
                            <td>Customer Type : </td>
                            <c:forEach var="cusType" items="${listCusType}">
                                <c:if test="${cusDelete.id_loai_khach == cusType.id_loai_khach}">
                                    <td><c:out value="${cusType.ten_loai_khach}"></c:out></td>
                                </c:if>
                            </c:forEach>
                        </tr>
                    </table>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <a href="/KhachHangServlet"><input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel"></a>
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
