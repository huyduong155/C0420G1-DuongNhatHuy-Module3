<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Note Management</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        body {
            color: #566787;

            background-image: url("https://letweb.net/wp-content/uploads/2018/06/tom-tat-chien-dich-online-marketing-trong-mot-trang-giay-1.jpg");
            /*background: #f7f5f2;*/
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
            background: dimgray;
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
</head>
<body>

<div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper" style="background-color:#f7f5f2 ">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Note  <b>Management</b></h2>
                    </div>
                    <div class="col-sm-3">
                        <a href="#addNoteModal" class="btn btn-success" data-toggle="modal"><i class="fa fa-plus"></i> <span>Add New Note</span></a>
                    </div>
                    <div class="col-sm-3">
                        <div class="search-box">
                            <div class="input-group">
                                <input type="text" id="search" class="form-control" placeholder="Search by Title">
                                <span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <table class="table table-striped" >
                <thead>
                <tr>
                    <th>#</th>
                    <th style="width: 22%;">Title</th>
                    <th style="width: 22%;">Note Type</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="note" items="${noteList}">
                    <tr>
                        <td><c:out value="${note.id}"/></td>
                        <td><span><c:out value="${note.title}"/></span></td>
                        <c:forEach var="noteType" items="${noteTypeList}">
                            <c:if test="${note.type_Id == noteType.id_note_type}">
                                <td><c:out value="${noteType.name_type}"/></td>
                            </c:if>
                        </c:forEach>
                        <td>
                            <a href="/NoteManagementServlet?action=view&id=${note.id}" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                            <a href="/NoteManagementServlet?action=edit&id=${note.id}" class="edit" title="Edit" ><i class="material-icons">&#xE254;</i></a>
                            <a href="/NoteManagementServlet?action=delete&id=${note.id}" class="delete" title="Delete"><i class="material-icons">&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<!-- Edit Modal HTML -->
<div id="addNoteModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/NoteManagementServlet?action=create" method="post">
                <div class="modal-header" style="background: dimgrey">
                    <h4 class="modal-title" style="color: #e9e9e9">Add Note</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Title</label>
                        <input type="text" class="form-control" name="title" id="title">
                    </div>
                    <div class="form-group">
                        <label>Content</label>
                        <textarea class="form-control" name="content" id="content"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Note type :</label>
                        <select name="noteTypeId" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <c:forEach var="noteType" items="${noteTypeList}">
                                <option value="${noteType.id_note_type}"><c:out value="${noteType.name_type}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
