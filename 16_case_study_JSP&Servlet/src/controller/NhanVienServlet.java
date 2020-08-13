package controller;

import bo.INhanVienBo;
import bo.NhanVienBo;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NhanVienServlet",urlPatterns = "/NhanVienServlet")
public class NhanVienServlet extends HttpServlet {
    private INhanVienBo iNhanVienBo = new NhanVienBo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iNhanVienBo.deleteNhanVien(id);
        try {
            response.sendRedirect("/NhanVienServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String ho_ten = request.getParameter("Name");
        String ngay_sinh = request.getParameter("dateOfBirth");
        String CMND = request.getParameter("CMND");
        String luong = request.getParameter("Salary");
        String SDT = request.getParameter("SDT");
        String email = request.getParameter("Email");
        String dia_chi = request.getParameter("Address");
        int id_trinh_do =Integer.parseInt(request.getParameter("EducationId"));
        int id_vi_tri =Integer.parseInt(request.getParameter("PositionId"));
        int id_bo_phan =Integer.parseInt(request.getParameter("DivisionId"));
        Nhan_vien nhanVien = new Nhan_vien(id,ho_ten,ngay_sinh,CMND,luong,SDT,email,dia_chi,id_trinh_do,id_vi_tri,id_bo_phan);
        iNhanVienBo.editNhanVien(nhanVien);
        try {
            response.sendRedirect("/NhanVienServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String ho_ten = request.getParameter("Name");
        String ngay_sinh = request.getParameter("dateOfBirth");
        String CMND = request.getParameter("CMND");
        String luong = request.getParameter("Salary");
        String SDT = request.getParameter("SDT");
        String email = request.getParameter("Email");
        String dia_chi = request.getParameter("Address");
        int id_trinh_do =Integer.parseInt(request.getParameter("PositionId"));
        int id_vi_tri =Integer.parseInt(request.getParameter("EducationId"));
        int id_bo_phan =Integer.parseInt(request.getParameter("DivisionId"));
        Nhan_vien nhanVien = new Nhan_vien(ho_ten,ngay_sinh,CMND,luong,SDT,email,dia_chi,id_trinh_do,id_vi_tri,id_bo_phan);
        iNhanVienBo.insertNhanVien(nhanVien);
        try {
            response.sendRedirect("/NhanVienServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEditEmployee(request,response);
                break;
            case "delete":
                showDeleteEmployee(request,response);
                break;
            default:
                listEmployee(request,response);
                break;

        }
    }

    private void showDeleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Nhan_vien nhanVien = iNhanVienBo.selectNhanVien(id);
        request.setAttribute("employeeDelete",nhanVien);
        List<Vi_tri> viTriList = iNhanVienBo.selectAllViTri();
        request.setAttribute("listPosition",viTriList);
        List<Trinh_do> trinhDoList = iNhanVienBo.selectAllTrinhDo();
        request.setAttribute("listEducation",trinhDoList);
        List<Bo_phan> boPhanList = iNhanVienBo.selectAllBoPhan();
        request.setAttribute("listDivision",boPhanList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama/deleteNhanVien.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Nhan_vien nhanVien = iNhanVienBo.selectNhanVien(id);
        request.setAttribute("employeeEdit",nhanVien);
        List<Vi_tri> viTriList = iNhanVienBo.selectAllViTri();
        request.setAttribute("listPosition",viTriList);
        List<Trinh_do> trinhDoList = iNhanVienBo.selectAllTrinhDo();
        request.setAttribute("listEducation",trinhDoList);
        List<Bo_phan> boPhanList = iNhanVienBo.selectAllBoPhan();
        request.setAttribute("listDivision",boPhanList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("furama/editNhanVien.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<DTO_nhan_vien> dtoNhanVienList = iNhanVienBo.selectAllNhanVien();
        request.setAttribute("listEmployee",dtoNhanVienList);
        List<Vi_tri> viTriList = iNhanVienBo.selectAllViTri();
        request.setAttribute("listPosition",viTriList);
        List<Trinh_do> trinhDoList = iNhanVienBo.selectAllTrinhDo();
        request.setAttribute("listEducation",trinhDoList);
        List<Bo_phan> boPhanList = iNhanVienBo.selectAllBoPhan();
        request.setAttribute("listDivision",boPhanList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("furama/dsNhanVien.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
