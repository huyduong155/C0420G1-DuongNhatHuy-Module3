package controller;

import bo.IKhachHangBo;
import bo.KhachHangBo;
import model.DTO_khach_hang;
import model.Khach_hang;
import model.Loai_khach;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "KhachHangServlet", urlPatterns = "/KhachHangServlet")
public class KhachHangServlet extends HttpServlet {
    private IKhachHangBo iKhachHangBo = new KhachHangBo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                editCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        iKhachHangBo.deleteKhachHang(id);
        try {
            response.sendRedirect("/KhachHangServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("Name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String cmnd = request.getParameter("CMND");
        String phone = request.getParameter("Phone");
        String email = request.getParameter("Email");
        int idLoaiKhach = Integer.parseInt(request.getParameter("cusTypeId"));
        String address = request.getParameter("Address");

        Khach_hang khachHang = new Khach_hang(id,name,dateOfBirth,cmnd,phone,email,address,idLoaiKhach);
        iKhachHangBo.editKhachHang(khachHang);
        try {
            response.sendRedirect("/KhachHangServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("Name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String cmnd = request.getParameter("CMND");
        String phone = request.getParameter("SDT");
        String email = request.getParameter("Email");
        String address = request.getParameter("Address");
        int idLoaiKhach = Integer.parseInt(request.getParameter("CusTypeId"));
        Khach_hang khachHang = new Khach_hang(name,dateOfBirth,cmnd,phone,email,address,idLoaiKhach);
        iKhachHangBo.insertKhachHang(khachHang);
        try {
            response.sendRedirect("/KhachHangServlet");
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
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id_khach_hang = Integer.parseInt(request.getParameter("id"));
        Khach_hang khachHang = iKhachHangBo.selectKhachHang(id_khach_hang);
        request.setAttribute("cusDelete",khachHang);
        List<Loai_khach> loaiKhachList = iKhachHangBo.selectAllLoaiKhach();
        request.setAttribute("listCusType",loaiKhachList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("furama/deleteKhachHang.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id_khach_hang = Integer.parseInt(request.getParameter("id"));
        Khach_hang khachHang = iKhachHangBo.selectKhachHang(id_khach_hang);
        request.setAttribute("cusEdit",khachHang);
        List<Loai_khach> loaiKhachList = iKhachHangBo.selectAllLoaiKhach();
        request.setAttribute("listCusType",loaiKhachList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("furama/editKhachHang.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<DTO_khach_hang> list = iKhachHangBo.selectAllKhachHang();
        List<Loai_khach> loaiKhachList= iKhachHangBo.selectAllLoaiKhach();
        request.setAttribute("listCus",list);
        request.setAttribute("listCusType",loaiKhachList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("furama/dsKhachHang.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
