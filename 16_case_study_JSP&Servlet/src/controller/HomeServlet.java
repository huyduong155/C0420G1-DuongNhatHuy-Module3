package controller;

import bo.*;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    private IKhachHangBo iKhachHangBo = new KhachHangBo();
    private IDichVuBo iDichVuBo = new DichVuBo();
    private INhanVienBo iNhanVienBo = new NhanVienBo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request,response);
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
         String ten_dich_vu = request.getParameter("Name");
         int dien_tich = Integer.parseInt(request.getParameter("area"));
         int so_tang = Integer.parseInt(request.getParameter("floor"));
         String so_nguoi = request.getParameter("people");
         String chi_phi_thue = request.getParameter("cost");
         String trang_thai = request.getParameter("status");
         int id_kieu_thue = Integer.parseInt(request.getParameter("RentTypeId"));
         int id_loai_dich_vu = Integer.parseInt(request.getParameter("SerTypeId"));
        Dich_vu dichVu = new Dich_vu(ten_dich_vu,dien_tich,so_tang,so_nguoi,chi_phi_thue,trang_thai,id_kieu_thue,id_loai_dich_vu);
        iDichVuBo.insertDichVu(dichVu);
        try {
            response.sendRedirect("/HomeServlet");
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
            default:
                listHome(request,response);
        }
    }

    private void listHome(HttpServletRequest request, HttpServletResponse response) {
        List<Loai_khach> loaiKhachList= iKhachHangBo.selectAllLoaiKhach();
        request.setAttribute("listCusType",loaiKhachList);
        List<Kieu_thue> kieuThueList = iDichVuBo.selectAllKieuThue();
        request.setAttribute("listRentType",kieuThueList);
        List<Loai_dich_vu> loaiDichVuList = iDichVuBo.selectAllLoaiDichVu();
        request.setAttribute("listSerType",loaiDichVuList);
        List<Vi_tri> viTriList = iNhanVienBo.selectAllViTri();
        request.setAttribute("listPosition",viTriList);
        List<Trinh_do> trinhDoList = iNhanVienBo.selectAllTrinhDo();
        request.setAttribute("listEducation",trinhDoList);
        List<Bo_phan> boPhanList = iNhanVienBo.selectAllBoPhan();
        request.setAttribute("listDivision",boPhanList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("furama/home.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
